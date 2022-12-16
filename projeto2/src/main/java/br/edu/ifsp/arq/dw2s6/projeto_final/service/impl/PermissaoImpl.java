package br.edu.ifsp.arq.dw2s6.projeto_final.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Permissao;
import br.edu.ifsp.arq.dw2s6.projeto_final.repository.PermissionRepository;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.PermissaoService;

@Service
public class PermissaoImpl implements PermissaoService {

	@Autowired
	PermissionRepository permissionRepository;

	@Override
	public Optional<Permissao> findById(Long id) {
		return permissionRepository.findById(id);
	}



}
