package br.edu.ifsp.arq.dw2s6.projeto_final.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario>{

	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByNome(String nome);

}
