package br.edu.ifsp.arq.dw2s6.projeto_final.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Categoria;
import br.edu.ifsp.arq.dw2s6.projeto_final.repository.CategoriaRepository;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.CategoriaService;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.CategoriaSpec;

@Service
public class CategoriaImpl implements CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public Optional<Categoria> findById(Long id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public void deleteById(Long categoriaId) {
		categoriaRepository.deleteById(categoriaId);		
	}

	@Override
	public Categoria create(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Page<Categoria> findAll(CategoriaSpec spec, Pageable pageable) {
		return categoriaRepository.findAll(spec, pageable);
	}

	@Override
	public Optional<Categoria> findByName(String categoriaName) {
		return categoriaRepository.findByNome(categoriaName);
	}

	@Override
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

}
