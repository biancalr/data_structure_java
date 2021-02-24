package br.com.caelum.ed.listas_ligadas;

public class ListaLigada {

	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;

	/**
	 * Adiciona um elemento no fim da lista. No caso especial da Lista estar
	 * vazia, adicionar no come�o ou no fim dessa lista d� o mesmo efeito.
	 * Ent�o, se a Lista estiver vazia, chamaremos o m�todo
	 * <code>adicionaNoComeco(Object)</code>.
	 * 
	 * @param elemento
	 *            o elemento a ser adicionado
	 */
	public void adiciona(Object elemento) {
		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;
		}
	}

	/**
	 * Adiciona o elemento em uma determinada posi��o dentro da estrutura
	 * 
	 * @param posicao
	 *            a posi��o desejada para adicionar o elemento
	 * @param elemento
	 *            o elemento a ser adicionado
	 */
	public void adiciona(int posicao, Object elemento) {
		if (posicao == 0) {// No comeco
			this.adicionaNoComeco(elemento);
		} else if (posicao == this.totalDeElementos) { // no fim
			this.adiciona(elemento);
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula proxima = anterior.getProxima();
			Celula nova = new Celula(anterior.getProxima(), elemento);
			nova.setAnterior(anterior);
			anterior.setProxima(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}
	}

	/**
	 * Adiciona um elemento no come�o da estrutura. Cria-se uma nova c�lula, e
	 * esta nova c�lula ter� a refer�ncia <code>proxima</code> apontando para a
	 * atual <code>primeira</code> da lista. Depois atualiza-se o atributo
	 * <code>primeira</code> para se referenciar a esta nova c�lula rec�m
	 * criada. Ainda falta tratar o caso especial da Lista estar vazia. Neste
	 * caso, deve-se atualizar a refer�ncia que aponta para a �ltima c�lula
	 * tamb�m. Atrav�s do atributo <code>totalDeAlunos</code> podemos
	 * identificar este caso.
	 * 
	 * @param elemento
	 *            o elemento a ser adicionado na estrutura
	 */
	public void adicionaNoComeco(Object elemento) {
		Celula nova;
		if (this.totalDeElementos == 0) {
			nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}

	/**
	 * Para inserir um elemento em qualquer posi��o precisamos pegar a c�lula
	 * anterior a da posi��o desejada, porque precisamos mexer na sua refer�ncia
	 * <code>proxima</code>. Para isso vamos criar um m�todo auxiliar que pega
	 * determinada c�lula. Este m�todo deve tomar cuidado com o caso da posi��o
	 * n�o existir. A verifica��o se a posi��o existe ou n�o � feita pelo m�todo
	 * <code>posicaoOcupada(int)</code>.
	 * 
	 * @param posicao
	 *            a posicao da c�lula que se deseja buscar
	 * @return A c�lula requerida
	 */
	private Celula pegaCelula(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posi��o n�o existe");
		}
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();

		}
		return atual;
	}

	/**
	 * Pega a c�lula em que aquele elemento se encontra e acessa o elemento de
	 * dentro dela. Pode-se utilizar o <code>pegaCelula(int)</code> previamente
	 * criado
	 * 
	 * @param posicao
	 *            a posi��o do elemento
	 * @return o elemento requerido caso ele exista
	 */
	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	/**
	 * Inicialmente, deve-se verificar se a posi��o est� ou n�o ocupada. Se n�o
	 * estiver, lan�a uma exce��o. Caso contr�rio, deve-se verificar se a
	 * remo��o � do come�o ou do fim da Lista, se for um destes casos
	 * simplesmente chama-se os m�todos j� feitos. Por fim, se a remo��o � no
	 * interior da Lista deve-se atualizar as refer�ncias das c�lulas
	 * relacionadas a c�lula a serem removidas (anterior e pr�xima). A pr�xima
	 * da anterior deve ser a proxima e a anterior da proxima deve ser a
	 * anterior
	 * 
	 * @param posicao
	 *            a posi��o do elemento a ser removido
	 */
	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posi��o n�o existe");
		}

		if (posicao == 0) {
			this.removeDoComeco();
		} else if (posicao == this.totalDeElementos - 1) {
			this.removeDoFim();
		} else {
			Celula anterior = this.pegaCelula(posicao - 1);
			Celula atual = anterior.getProxima();
			Celula proxima = atual.getProxima();

			anterior.setProxima(proxima);
			proxima.setAnterior(anterior);

			this.totalDeElementos--;
		}
	}

	/**
	 * Antes de tentar remover deve-se verificar se a posi��o est� ocupada. N�o
	 * faz sentido remover algo que n�o existe. Depois, basta �avan�ar� a
	 * refer�ncia que aponta para a primeira c�lula. Por fim, � importante
	 * perceber que a Lista pode ficar vazia. Neste caso, deve-se colocar
	 * <code>null</code> na refer�ncia que aponta para a �ltima c�lula.
	 */
	public void removeDoComeco() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posi��o n�o existe");
		}

		this.primeira = this.primeira.getProxima();
		this.totalDeElementos--;

		if (this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}

	/**
	 * A primeira verifica��o a ser feita � se a �ltima posi��o existe. Podemos
	 * fazer isso atrav�s do m�todo j� criado <code>posicaoOcupada(int)</code>.
	 * Se a Lista estiver com apenas um elemento ent�o remover do fim � a mesma
	 * coisa que remover do come�o. Logo, podemos reutilizar o m�todo
	 * <code>removeDoComeco()</code> para este caso. Agora, se a Lista tem mais
	 * que um elemento ent�o devemos pegar a pen�ltima c�lula; fazer a pr�xima
	 * da pen�ltima ser <code>null</code>; e fazer o atributo
	 * <code>ultima</code> apontar para a pen�ltima.
	 */
	public void removeDoFim() {
		if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posi��o n�o existe");
		}
		if (this.totalDeElementos == 1) {
			this.removeDoComeco();
		} else {
			Celula penultima = this.ultima.getAnterior();
			penultima.setProxima(null);
			this.ultima = penultima;
			this.totalDeElementos--;
		}
	}

	/**
	 * 
	 * @return o total de elementos da estrutura
	 */
	public int getTamanho() {
		return this.totalDeElementos;
	}

	/**
	 * Verifica se a posi�ao da estrutura est� ocupada
	 * 
	 * @param posicao
	 *            a posi��o que se deseja verificar
	 * @return <code>true</code> se a posi��o estiver ocupada ou
	 *         <code>false</code> caso contr�rio
	 */
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

	/**
	 * Percorre a Lista e compara com o m�todo <code>equals(Object)</code> o
	 * elemento procurado contra todos os elementos da Lista.
	 * 
	 * @param elemento
	 *            o elemento a se pesquisar
	 * @return <code>true</code> se o elemento existe na estrutura e
	 *         <code>false</code> caso contr�rio
	 */
	public boolean contem(Object elemento) {
		Celula atual = this.primeira;

		while (atual != null) {
			if (atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProxima();
		}
		return false;
	}

	@Override
	public String toString() {
		//verificando se a lista est� vazia
		if (this.totalDeElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;

		// percorrendo at� o pen�ltimo elemento
		for (int i = 0; i < this.totalDeElementos - 1; i++) {
			builder.append(atual.getElemento());
			builder.append(",");
			atual = atual.getProxima();
		}

		// ultimo elemento
		builder.append(atual.getElemento());
		builder.append("]");

		return builder.toString();
	}

}
