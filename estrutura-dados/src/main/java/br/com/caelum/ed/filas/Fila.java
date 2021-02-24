package br.com.caelum.ed.filas;

import java.util.LinkedList;
import java.util.List;

import br.com.caelum.ed.vetores.Aluno;

public class Fila {

	private List<Aluno> alunos = new LinkedList<>();

	/**
	 * O próximo aluno a ser atendido é sempre o que está no início da Fila. No
	 * nosso caso, quem está no início da Fila é o aluno que está no início da
	 * Lista
	 * 
	 * @param aluno
	 *            o aluno a ser inserido
	 */
	public void insere(Aluno aluno) {
		this.alunos.add(aluno);
	}

	/**
	 * O próximo aluno a ser atendido é sempre o que está no início da Fila.
	 * Nesse caso, quem está no início da Fila é o aluno que está no início da
	 * Lista
	 * 
	 * @return
	 */
	public Aluno remove() {
		return this.alunos.remove(0);
	}

	/**
	 * Esta operação verifica se o tamanho da Lista é zero para indicar se a
	 * fila está vazia ou não.
	 * 
	 * @return <code>true</code> se a fila está vazia e <code>false</code> caso
	 *         contrário
	 */
	public boolean vazia() {
		return this.alunos.size() == 0;
	}

}
