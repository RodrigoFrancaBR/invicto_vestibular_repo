package br.com.franca.invictoweb.enuns;

public enum Situacao {
	// Declaração das constantes
	ATIVO(1, "Ativo"), INATIVO(0, "Inativo");

	// método que define as constantes
	private Situacao(int numero, String nome) {
		this.numero = numero;
		this.nome = nome;
	}

	// Definição das constantes
	private final int numero;
	private final String nome;

	// métodos para acessar os valores
	public int numero() {
		return this.numero;
	}

	public String nome() {
		return this.nome;
	}
}
