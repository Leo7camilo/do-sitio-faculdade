package br.edu.ifsp.arq.dw2s6.projeto_final.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Produtor;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.ProdutorSpec;

public interface ProdutorService {
	
	Produtor create(Produtor categoria);

	Optional<Produtor> findById(Long categoriaId);

	Page<Produtor> findAll(ProdutorSpec spec, Pageable pageable);

	Optional<Produtor> findByName(String categoriaName);
	
	void deleteById(Long categoriaId);

	List<Produtor> findAll();

	Produtor save(Produtor produtor);

	Produtor atualizar(Long codigo, Produtor pessoa);

}	
