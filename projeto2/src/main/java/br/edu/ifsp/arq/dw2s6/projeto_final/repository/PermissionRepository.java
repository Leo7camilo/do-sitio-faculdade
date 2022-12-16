package br.edu.ifsp.arq.dw2s6.projeto_final.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Permissao;

public interface PermissionRepository extends JpaRepository<Permissao, Long>{
	
	
}