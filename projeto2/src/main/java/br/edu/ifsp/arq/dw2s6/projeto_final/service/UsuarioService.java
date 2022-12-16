package br.edu.ifsp.arq.dw2s6.projeto_final.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Usuario;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.UserSpec;

public interface UsuarioService {
	
	Usuario createUser(Usuario user);

	Optional<Usuario> findById(Long id);

	Page<Usuario> findAll(UserSpec spec, Pageable pageable);

	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByName(String userName);

	void updatePropertyActive(Long codigo, Boolean ativo);
	
	void deleteById(Long idUser);

}	
