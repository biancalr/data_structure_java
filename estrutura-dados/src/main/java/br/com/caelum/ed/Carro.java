package br.com.caelum.ed;

public class Carro {

	private String nome;
	
	public Carro(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}