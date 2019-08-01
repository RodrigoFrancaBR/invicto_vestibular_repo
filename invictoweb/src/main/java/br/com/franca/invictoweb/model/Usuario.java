package br.com.franca.invictoweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985035458790790933L;
	
	private String nome;
	private String senha;

	@Column(length = 10, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return "Usuario [nome=" + nome + ", senha=" + senha + "]";
	}
	
	
	
	
}
