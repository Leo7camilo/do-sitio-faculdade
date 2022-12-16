package br.edu.ifsp.arq.dw2s6.projeto_final.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Mercadoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.repository.MercadoriaRepository;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.MercadoriaService;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.MercadoriaSpec;

@Service
public class MercadoriaImpl implements MercadoriaService {

	@Autowired
	MercadoriaRepository mercadoriaRepository;

	@Override
	public Optional<Mercadoria> findById(Long id) {
		return mercadoriaRepository.findById(id);
	}	

	@Override
	public void deleteById(Long categoriaId) {
		mercadoriaRepository.deleteById(categoriaId);		
	}

	@Override
	public Mercadoria create(Mercadoria mercadoria) {
		return mercadoriaRepository.save(mercadoria);
	}

	@Override
	public Page<Mercadoria> findAll(MercadoriaSpec spec, Pageable pageable) {
		return mercadoriaRepository.findAll(spec, pageable);
	}

	@Override
	public Optional<Mercadoria> findByName(String descricao) {
		return mercadoriaRepository.findByDescricao(descricao);
	}


}
