package br.com.franca.invictoweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends AbstractBaseEntity<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985035458790790933L;

	private String nomeUsuario;
	private String senha;

	@Column(name="nome_usuario", length = 10, nullable = false)
	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Column(length = 10, nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [nomeUsuario=" + nomeUsuario + ", senha=" + senha + "]";
	}

	@Override
	public Usuario createNewEntity() {
		// TODO Auto-generated method stub
		return null;
	}

}
