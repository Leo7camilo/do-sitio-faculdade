package br.edu.ifsp.arq.dw2s6.projeto_final.service.impl;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Permissao;
import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.Usuario;
import br.edu.ifsp.arq.dw2s6.projeto_final.domain.model.UsuarioPermissao;
import br.edu.ifsp.arq.dw2s6.projeto_final.repository.UserPermissionRepository;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.PermissaoService;
import br.edu.ifsp.arq.dw2s6.projeto_final.service.UsuarioPermissaoService;

@Service
public class UsuarioPermissaoImpl implements UsuarioPermissaoService {

	@Autowired
	UserPermissionRepository userPermissionRepository;
	
	@Autowired
	PermissaoService permissaoService;

	@Override
	public void setPermissionToUser(Usuario user) {
		List<Integer> permissions = new ArrayList<Integer>();
		permissions.add(1);
		permissions.add(2);
		
		List<Permissao> permissionsAdded = new ArrayList<>();
		for(Integer permissionId: permissions) {
			UsuarioPermissao userPermission = new UsuarioPermissao();
			userPermission.setCodigoUsuario(user.getCodigo());
			userPermission.setCodigoPermissao(permissionId);
			userPermissionRepository.save(userPermission);
			
			permissionsAdded.add(permissaoService.findById(Long.valueOf(permissionId)).get());
		}
		user.setPermissoes(permissionsAdded);
	}

}
