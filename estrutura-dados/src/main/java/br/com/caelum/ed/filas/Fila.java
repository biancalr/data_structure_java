package br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.ed.vetores.Aluno;

public class Fila {

	private List<Aluno> alunos = new LinkedList<>();

	/**
	 * O pr�ximo aluno a ser atendido � sempre o que est� no in�cio da Fila. No
	 * nosso caso, quem est� no in�cio da Fila � o aluno que est� no in�cio da
	 * Lista
	 * 
	 * @param aluno
	 *            o aluno a ser inserido
	 */
	public void insere(Aluno aluno) {
		this.alunos.add(aluno);
	}

	/**
	 * O pr�ximo aluno a ser atendido � sempre o que est� no in�cio da Fila.
	 * Nesse caso, quem est� no in�cio da Fila � o aluno que est� no in�cio da
	 * Lista
	 * 
	 * @return
	 */
	public Aluno remove() {
		return this.alunos.remove(0);
	}

	/**
	 * Esta opera��o verifica se o tamanho da Lista � zero para indicar se a
	 * fila est� vazia ou n�o.
	 * 
	 * @return <code>true</code> se a fila est� vazia e <code>false</code> caso
	 *         contr�rio
	 */
	public boolean vazia() {
		return this.alunos.size() == 0;
	}

}
