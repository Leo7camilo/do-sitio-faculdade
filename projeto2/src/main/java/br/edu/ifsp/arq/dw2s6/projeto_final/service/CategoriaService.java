package br.edu.ifsp.arq.dw2s6.projeto_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Categoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.CategoriaSpec;

public interface CategoriaService {
	
	Categoria create(Categoria categoria);

	Optional<Categoria> findById(Long categoriaId);

	Page<Categoria> findAll(CategoriaSpec spec, Pageable pageable);

	Optional<Categoria> findByName(String categoriaName);
	
	void deleteById(Long categoriaId);

	List<Categoria> findAll();

}	
