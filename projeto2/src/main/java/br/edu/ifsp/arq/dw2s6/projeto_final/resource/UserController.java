package br.edu.ifsp.arq.dw2s6.projeto_final.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.UsuarioDto;
import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Usuario;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.UsuarioService;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.exception.EmailInvalidoException;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.exception.SenhaDiferenteException;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.exception.UserNotFoundException;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	UsuarioService userService;
	
	
	@PostMapping
	public ResponseEntity<Usuario> createUser(@Valid @RequestBody UsuarioDto userDto) {
		if (userService.findByEmail(userDto.getEmail()).isPresent()) {
			throw new EmailInvalidoException();
		}
		
		if(!userDto.getPassword().equals(userDto.getConfirmPassword())){
			throw new SenhaDiferenteException();
		}
		
		
		Usuario user = new Usuario();
		//BeanUtils.copyProperties(userDto, user);
		user.setNome(userDto.getFullName());
		user.setEmail(userDto.getEmail());
		user.setSenha(userDto.getPassword());
		
		user.setSenha(BCryptPasswordEncoder(user.getSenha()));
		Usuario userCreated = userService.createUser(user);
		
		return new ResponseEntity<Usuario>(userCreated, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') and hasAuthority('SCOPE_write')")
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Optional<Usuario> categoria = userService.findById(id);

		return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_ADMIN') and hasAuthority('SCOPE_write')")
	public void atualizarPropriedadeAtivo(@PathVariable Long id, @RequestBody Boolean ativo) {
		userService.updatePropertyActive(id, ativo);
	}
	
	@GetMapping
	public ResponseEntity<Page<Usuario>> getAll(SpecificationTemplate.UserSpec spec,
											@PageableDefault(page = 0, size = 10, sort = "id", 
												direction = Sort.Direction.ASC) Pageable pageable) {

		return ResponseEntity.ok(userService.findAll(spec, pageable));
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN') and hasAuthority('SCOPE_write')")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		Optional<Usuario> user = userService.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	private String BCryptPasswordEncoder(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
		
	}

}
