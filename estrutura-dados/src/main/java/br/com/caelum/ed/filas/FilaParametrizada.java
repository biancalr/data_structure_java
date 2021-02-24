package br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

public class FilaParametrizada<T> {

	private List<T> objetos = new LinkedList<T>();

	/**
	 * Insere o objeto sempre no fim da estrutura. A prioridade sempre segue de
	 * acordo com a ordem de inserção na estrutura
	 * 
	 * @param t
	 *            o objeto a ser inserido na estrutura
	 */
	public void insere(T t) {
		this.objetos.add(t);
	}

	/**
	 * Remove o elemento do início da estrutura. Ou seja, o próximo elemento a
	 * ser solicitado é sempre o que está no topo da estrutura.
	 * 
	 * @return remove o objeto do topo da estrutura e o devolve como retorno
	 *         deste método
	 */
	public T remove() {
		return this.objetos.remove(0);
	}

	/**
	 * Verifica se a estrutura está vazia verificando a quantidade de elementos
	 * contidos
	 * @return <code>true</code> se a fila está vazia e <code>false</code> caso
	 *                          contrário
	 */
	public boolean vazia() {
		return this.objetos.size() == 0;
	}

}
