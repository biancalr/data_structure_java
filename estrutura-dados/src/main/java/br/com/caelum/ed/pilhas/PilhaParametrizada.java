package br.com.caelum.ed.pilhas;

import java.util.LinkedList;
import java.util.List;

public class PilhaParametrizada<T> {

	private List<T> objetos = new LinkedList<>();

	/**
	 * Insere o elemento no topo da estrutura
	 * 
	 * @param objeto
	 *            a peca a ser adicionada
	 */
	public void insere(T objeto) {
		this.objetos.add(objeto);
	}

	/**
	 * Remove o elemento do topo da estrutura e retorna esse objeto como valor
	 * dessa função
	 * 
	 * @return o elemento no topo da pilha
	 */
	public T remove() {
		return this.objetos.remove(this.objetos.size() - 1);
	}

	/**
	 * Verifica se a estrutura está vazia
	 * 
	 * @return <code>true</code> se a estrutura estiver vazia e <code>false</code>
	 *         caso contrário
	 */
	public boolean vazia() {
		return this.objetos.size() == 0;
	}

}
