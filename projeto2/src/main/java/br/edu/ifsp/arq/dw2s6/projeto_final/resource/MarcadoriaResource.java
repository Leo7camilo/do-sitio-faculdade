package br.edu.ifsp.arq.dw2s6.projeto_final.resource;

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

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Mercadoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.MercadoriaService;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate;

@RestController
@RequestMapping("/mercadoria")
public class MarcadoriaResource {
	

	@Autowired
	private MercadoriaService mercadoriaService;
	
	@GetMapping
	public ResponseEntity<Page<Mercadoria>> listar(SpecificationTemplate.MercadoriaSpec spec, 
									@PageableDefault(page = 0, size = 10, sort = "codigo", direction = Sort.Direction.ASC) Pageable pageable){
		return ResponseEntity.ok(mercadoriaService.findAll(spec, pageable));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize
	("hasAuthority('ROLE_CADASTRAR') and #oauth2.hasScope('write')") 
	public Mercadoria criar(@Valid @RequestBody Mercadoria mercadoria, 
			HttpServletResponse response) {
		return mercadoriaService.create(mercadoria);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Mercadoria> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Mercadoria> mercadoria = mercadoriaService.findById(codigo);
		if(mercadoria.isPresent()) {
			return ResponseEntity.ok(mercadoria.get());
		}
		return ResponseEntity.notFound().build();
	}

}









