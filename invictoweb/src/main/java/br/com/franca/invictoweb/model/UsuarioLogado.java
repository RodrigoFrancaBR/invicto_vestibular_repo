package br.com.franca.invictoweb.model;

import java.io.Serializable;

public class UsuarioLogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5582610559501771070L;
	private Usuario usuario;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
