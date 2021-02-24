package br.com.caelum.ed.pilhas;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.ed.Peca;

public class Pilha {

	private List<Peca> pecas = new LinkedList<Peca>();

	/**
	 * Insere a {@link Peca} no fim da lista
	 * 
	 * @param peca
	 *            a {@link Peca} a ser inserida
	 */
	public void insere(Peca peca) {
		this.pecas.add(peca);
	}

	/**
	 * Remove a {@link Peca} do topo da {@link Pilha} e retorna a {@link Peca}
	 * como valor dessa funcao
	 * 
	 * @return o elemento no topo da estrutura
	 */
	public Peca remove() {
		return this.pecas.remove(this.pecas.size() - 1);
	}

	/**
	 * Verifica se a {@link Pilha} está vazia
	 * 
	 * @return <code>true</code> se a pilha estiver vazia e <code>false</code>
	 *         caso contrário
	 */
	public boolean vazia() {
		return this.pecas.size() == 0;
	}

}
