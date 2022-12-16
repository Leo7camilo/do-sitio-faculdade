package br.edu.ifsp.arq.dw2s6.projeto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.UsuarioPermissao;

public interface UserPermissionRepository extends JpaRepository<UsuarioPermissao, Long>{
	
	
}