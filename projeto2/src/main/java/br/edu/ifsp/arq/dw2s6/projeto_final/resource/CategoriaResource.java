package br.edu.ifsp.arq.dw2s6.projeto_final.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Categoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.CategoriaService;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> listar(){
		return categoriaService.findAll();
	}
	
	@GetMapping("/page")
	@PreAuthorize
	("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('read')") 
	public ResponseEntity<Page<Categoria>> listar(SpecificationTemplate.CategoriaSpec spec, @PageableDefault(page = 0, size = 10, sort = "id", 
									direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.ok(categoriaService.findAll(spec, pageable));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize
	("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')") 
	public Categoria criar(@Valid @RequestBody Categoria categoria, 
			HttpServletResponse response) {
		return categoriaService.create(categoria);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize
	("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('read')") 
	public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Categoria> categoria = categoriaService.findById(codigo);
		if(categoria.isPresent()) {
			return ResponseEntity.ok(categoria.get());
		}
		return ResponseEntity.notFound().build();
	}

}









