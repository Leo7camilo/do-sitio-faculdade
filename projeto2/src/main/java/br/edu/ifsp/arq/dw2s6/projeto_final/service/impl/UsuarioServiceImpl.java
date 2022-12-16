package br.edu.ifsp.arq.dw2s6.projeto_final.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Usuario;
import br.edu.ifsp.arq.dw2s6.projeto_final.repository.UsuarioRepository;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.UsuarioPermissaoService;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.UsuarioService;
import br.edu.ifsp.arq.dw2s6.projeto_final.specification.SpecificationTemplate.UserSpec;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository userRepository;
	
	@Autowired
	UsuarioPermissaoService userPermission;
	

	@Override
	public Usuario createUser(Usuario user) {
		Usuario userCreated = userRepository.save(user);
		userPermission.setPermissionToUser(userCreated);
		return userCreated == null ? new Usuario() : userCreated;
	}
	
	@Override
	public Optional<Usuario> findById(Long id) {
		Optional<Usuario> user = userRepository.findById(id);
		return user;
	}

	@Override
	public Page<Usuario> findAll(UserSpec spec, Pageable pageable) {
		System.out.println();
		
		Page<Usuario> findPrint = userRepository.findAll(spec, pageable);
		System.out.println(findPrint.getContent().toString());
		
		
		findPrint.getContent().forEach(x -> {
			System.out.println(x);
		});
		return findPrint;
	}

	@Override
	public Optional<Usuario> findByEmail(String email) {
		Optional<Usuario> user = userRepository.findByEmail(email);
		return user;
	}

	@Override
	public Optional<Usuario> findByName(String nome) {
		Optional<Usuario> user = userRepository.findByNome(nome);
		return user;
	}

	@Override
	public void updatePropertyActive(Long id, Boolean ativo) {
		Optional<Usuario> user = findById(id);
		if (user.isPresent()) {
			if(ativo) {
				System.out.println("Ativando usuario");
				//user.get().setState(State.ATIVO);
			}else {
				System.out.println("Desativando usuario");
				//user.get().setState(State.DESATIVO);
			}
			
			userRepository.save(user.get());
			
		}
		
	}

	@Override
	public void deleteById(Long idUser) {
		userRepository.deleteById(idUser);
		
	}


}