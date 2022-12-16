package br.edu.ifsp.arq.dw2s6.projeto_final.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Mercadoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.MercadoriaSpec;

public interface MercadoriaService {
	
	Mercadoria create(Mercadoria mercadoria);

	Optional<Mercadoria> findById(Long mercadoriaId);

	Page<Mercadoria> findAll(MercadoriaSpec spec, Pageable pageable);

	Optional<Mercadoria> findByName(String mercadoriaName);
	
	void deleteById(Long mercadoriaId);

}	
