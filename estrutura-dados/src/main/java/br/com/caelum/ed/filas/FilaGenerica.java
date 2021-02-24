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
	 * acordo com a ordem de inser��o na estrutura
	 * 
	 * @param objeto
	 *            o objeto a ser inserido na estrutura
	 */
	public void insere(Object objeto) {
		this.objetos.add(objeto);
	}

	/**
	 * Remove o elemento do in�cio da estrutura. Ou seja, o pr�ximo elemento a
	 * ser solicitado � sempre o que est� no topo da estrutura.
	 * 
	 * @return remove o objeto do topo da estrutura e o devolve como retorno
	 *         deste m�todo
	 */
	public Object remove() {
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
