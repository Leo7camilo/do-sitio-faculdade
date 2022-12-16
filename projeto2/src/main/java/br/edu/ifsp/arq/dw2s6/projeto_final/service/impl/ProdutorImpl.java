package br.edu.ifsp.arq.dw2s6.projeto_final.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Produtor;
import br.edu.ifsp.arq.dw2s6.projeto_final.repository.ProdutorRepository;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.ProdutorService;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.ProdutorSpec;

@Service
public class ProdutorImpl implements ProdutorService {

	@Autowired
	ProdutorRepository produtorRepository;

	@Override
	public Optional<Produtor> findById(Long id) {
		return produtorRepository.findById(id);
	}

	@Override
	public void deleteById(Long produtorId) {
		produtorRepository.deleteById(produtorId);		
	}

	@Override
	public Produtor create(Produtor produtor) {
		return produtorRepository.save(produtor);
	}

	@Override
	public Page<Produtor> findAll(ProdutorSpec spec, Pageable pageable) {
		return produtorRepository.findAll(spec, pageable);
	}

	@Override
	public Optional<Produtor> findByName(String produtorNome) {
		return produtorRepository.findByNome(produtorNome);
	}

	@Override
	public List<Produtor> findAll() {
		return produtorRepository.findAll();
	}

	@Override
	public Produtor save(Produtor produtor) {
		return produtorRepository.save(produtor);
	}

	@Override
	public Produtor atualizar(Long codigo, Produtor produtor) {
		produtor.setCodigo(codigo);
		return produtorRepository.save(produtor);
	}
	

}
