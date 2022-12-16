package br.edu.ifsp.arq.dw2s6.projeto_final.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UsuarioDto {
	
	@NotBlank
	@Size(min = 5, max = 50)
	private String fullName;
	
	@NotBlank
	@Email
	@Size(min = 5, max = 50)
	private String email;
	
	@Size(min = 5, max = 150)
	@NotBlank
	private String password;
	
	@Size(min = 5, max = 150)
	@NotBlank
	private String confirmPassword;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}	

}
