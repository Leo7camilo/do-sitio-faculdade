package br.edu.ifsp.arq.dw2s6.projeto_final.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario_permissao")
public class UsuarioPermissao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "codigo_usuario")
	private Long codigoUsuario;
	
	@Column(name = "codigo_permissao")
	private int codigoPermissao;

	public Long getCodigo() {
		return codigo;
	}

	public Long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(Long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public int getCodigoPermissao() {
		return codigoPermissao;
	}

	public void setCodigoPermissao(int codigoPermissao) {
		this.codigoPermissao = codigoPermissao;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


}
