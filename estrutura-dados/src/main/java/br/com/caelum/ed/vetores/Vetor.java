package br.com.caelum.ed.vetores;

public class Vetor {
	// declarando e inicializando um array de objetos de 100 posi��es
	private Object[] objetos = new Object[100];

	private int totalDeAlunos = 0;

	/**
	 * Adiciona o {@link Aluno} no final da estrutura
	 * 
	 * @param aluno
	 *            o {@link Aluno} a adicionar
	 */
	public void adiciona(Aluno aluno) {
		this.garantaEspaco();
		this.objetos[this.totalDeAlunos] = aluno;
		this.totalDeAlunos++;

	}

	/**
	 * Adiciona o {@link Aluno} na posi��o determinada
	 * 
	 * @param posicao
	 *            A posi��o desejada para adicionar o aluno
	 * @param aluno
	 *            o {@link Aluno} a ser adicionado
	 */
	public void adiciona(int posicao, Aluno aluno) {
		this.garantaEspaco();
		if (!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}

		for (int i = this.totalDeAlunos; i >= posicao; i--) {
			this.objetos[i + 1] = this.objetos[i];
		}

		this.objetos[posicao] = aluno;
		this.totalDeAlunos++;

	}

	/**
	 * Recupera {@link Aluno} na posi��o determinada
	 * 
	 * @param posicao
	 *            a posi��o do aluno para pegar
	 * @return o {@link Aluno} na posi��o determinada
	 * @throws IllegalArgumentException
	 *             caso a posi��o seja inv�lida
	 * 
	 */
	public Object pega(int posicao) {
		if (!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.objetos[posicao];

	}

	/**
	 * Remover aluno de determinada posi��o
	 * 
	 * @param posicao
	 *            a posi��o do {@link Aluno} que se precisa remover
	 */
	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao inv�lida");
		}

		for (int i = posicao; i < (this.totalDeAlunos - 1); i++) {
			this.objetos[i] = this.objetos[i + 1];
		}
		this.totalDeAlunos--;
		System.gc();
	}

	/**
	 * remover da Lista todas as ocorr�ncias de um elemento que � passado como
	 * parametro.
	 * 
	 * @param objeto
	 *            o elemento a ser removido da estrutura
	 */
	public void remove(Object objeto) {
		for (int i = 0; i < this.getTamanho(); i++) {
			if (objeto.equals(this.objetos[i])) {
				remove(i);
			}
		}
	}

	/**
	 * Limpa a estrutura, ou seja, remove todos os elementos.
	 */
	public void clear() {
		this.objetos = new Object[this.getTamanho()];
		this.totalDeAlunos = 0;
		System.gc();
	}

	/**
	 * procurar o �ndice da primeira ocorr�ncia de um elemento passado como
	 * par�metro
	 * 
	 * @param objeto
	 *            o elemento {@link Aluno} a ser encontrado
	 */
	public void indexOf(Object objeto) {
		for (int i = 0; i < this.getTamanho(); i++) {
			if (objeto.equals(this.objetos[i])) {
				System.out.println("�ndice da primera ocorr�ncia = " + i);
				break;
			}
		}
	}

	/**
	 * Procura o �ndice da �ltima ocorr�ncia de um elemento passado como
	 * par�metro
	 * 
	 * @param objeto
	 *            o elemento {@link Aluno} a ser encontrado
	 */
	public void lastIndexOf(Object objeto) {
		for (int i = this.getTamanho(); i >= 0; i--) {
			if (objeto.equals(this.objetos[i])) {
				System.out.println("�ndice da �ltima ocorr�ncia = " + i);
				break;
			}

		}
	}

	/**
	 * Verificar se o {@link Aluno} existe
	 * 
	 * @param aluno
	 *            o {@link Aluno} para verificar
	 * @return <code>true</code> se o {@link Aluno} existe e <code>false</code>
	 *         se o {@link Aluno} n�o existe
	 */
	public boolean contem(Aluno aluno) {
		for (int i = 0; i < this.totalDeAlunos; i++) {
			if (aluno.equals(this.objetos[i])) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Verificar tamanho da lista de {@link Aluno}s
	 * 
	 * @return total de {@link Aluno}s armazenados na estrutura
	 */
	public int getTamanho() {
		return this.totalDeAlunos;
	}

	/**
	 * Verificar se a posi��o do array est� ocupada
	 * 
	 * @param posicao
	 *            a posi��o para verificar
	 * @return <code>true</code> se a <code>posicao</code> est� ocupada e
	 *         <code>false</code> caso contr�rio
	 */
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeAlunos;
	}

	/**
	 * Verifica se a posi��o faz sentido dentro da estrutura. S� pode ser
	 * adicionado um aluno em dada posi��o se ela j� estava ocupada ou na
	 * primeira posi��o vazia da lista
	 * 
	 * @param posicao
	 *            a posi��o do {@link Aluno} para verificar
	 * @return <code>true</code> se a <code>posicao</code> for v�lida para
	 *         adicionar o {@link Aluno} e <code>false</code> caso contr�rio
	 */
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao <= this.totalDeAlunos;
	}

	/**
	 * Caso a array esteja completamente preenchida, cria uma nova array com o
	 * dobro do espa�o e copia a array antiga para a nova.
	 */
	private void garantaEspaco() {
		if (this.totalDeAlunos == this.objetos.length) {
			Object[] novaArray = new Object[this.objetos.length * 2];
			for (int i = 0; i < this.objetos.length; i++) {
				novaArray[i] = this.objetos[i];
			}
			this.objetos = novaArray;
		}
	}

	@Override
	public String toString() {
		if (this.totalDeAlunos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");

		for (int i = 0; i < this.totalDeAlunos; i++) {
			builder.append(this.objetos[i]);
			builder.append(",  ");
		}

		builder.append(this.objetos[this.totalDeAlunos - 1]);
		builder.append("]");

		return builder.toString();

	}

}
