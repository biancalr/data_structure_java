/**
 * 
 */
package br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

/**
 * @author bibil
 *
 */
public class FilaGenerica {

	private List<Object> objetos = new LinkedList<>();

	/**
	 * Insere o objeto sempre no fim da estrutura. A prioridade sempre segue de
	 * acordo com a ordem de inserção na estrutura
	 * 
	 * @param objeto
	 *            o objeto a ser inserido na estrutura
	 */
	public void insere(Object objeto) {
		this.objetos.add(objeto);
	}

	/**
	 * Remove o elemento do início da estrutura. Ou seja, o próximo elemento a
	 * ser solicitado é sempre o que está no topo da estrutura.
	 * 
	 * @return remove o objeto do topo da estrutura e o devolve como retorno
	 *         deste método
	 */
	public Object remove() {
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
