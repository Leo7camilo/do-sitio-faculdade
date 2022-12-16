package br.edu.ifsp.arq.dw2s6.projeto_final.service;

import java.util.Optional;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Permissao;

public interface PermissaoService {
	
	Optional<Permissao> findById(Long id);

}
