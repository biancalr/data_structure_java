package br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

public class FilaParametrizada<T> {

	private List<T> objetos = new LinkedList<T>();

	/**
	 * Insere o objeto sempre no fim da estrutura. A prioridade sempre segue de
	 * acordo com a ordem de inser��o na estrutura
	 * 
	 * @param t
	 *            o objeto a ser inserido na estrutura
	 */
	public void insere(T t) {
		this.objetos.add(t);
	}

	/**
	 * Remove o elemento do in�cio da estrutura. Ou seja, o pr�ximo elemento a
	 * ser solicitado � sempre o que est� no topo da estrutura.
	 * 
	 * @return remove o objeto do topo da estrutura e o devolve como retorno
	 *         deste m�todo
	 */
	public T remove() {
		return this.objetos.remove(0);
	}

	/**
	 * Verifica se a estrutura est� vazia verificando a quantidade de elementos
	 * contidos
	 * @return <code>true</code> se a fila est� vazia e <code>false</code> caso
	 *                          contr�rio
	 */
	public boolean vazia() {
		return this.objetos.size() == 0;
	}

}
