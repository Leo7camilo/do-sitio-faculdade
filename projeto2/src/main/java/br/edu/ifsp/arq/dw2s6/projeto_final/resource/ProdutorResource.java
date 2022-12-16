package br.edu.ifsp.arq.dw2s6.projeto_final.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Produtor;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.ProdutorService;

@RestController
@RequestMapping("/produtor")
public class ProdutorResource {
	

	@Autowired
	private ProdutorService produtorService;
	
	@GetMapping
	public List<Produtor> listar(){
		return produtorService.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize
	("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')")
	public Produtor criar(@Valid @RequestBody Produtor produtor, 
			HttpServletResponse response) {
		return produtorService.save(produtor);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize
	("hasAuthority('ROLE_PESQUISAR') and #oauth2.hasScope('read')")
	public ResponseEntity<Produtor> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Produtor> produtor = produtorService.findById(codigo);
		if(produtor.isPresent()) {
			return ResponseEntity.ok(produtor.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@PreAuthorize
	("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')")
	public void remover(@PathVariable Long codigo) {
		produtorService.deleteById(codigo);
	}
	
	
	@PutMapping("/{codigo}")
	@PreAuthorize
	("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')")
	public ResponseEntity<Produtor> atualizar(@PathVariable Long codigo,
			@Valid @RequestBody Produtor pessoa){
		Produtor produtorSalvo = produtorService.atualizar(codigo, pessoa);
		return ResponseEntity.ok(produtorSalvo);
	}
	
}









