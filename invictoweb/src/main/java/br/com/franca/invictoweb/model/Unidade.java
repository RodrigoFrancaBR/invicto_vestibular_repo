package br.com.franca.invictoweb.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.franca.invictoweb.enuns.Situacao;

@Entity
@Table(name = "tb_unidade")
public class Unidade extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6228598761758789422L;
	private String nome;
	private String endereco;
	private Situacao situacao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Unidade [nome=" + nome + ", endereco=" + endereco + ", situacao=" + situacao + "]";
	}

}
