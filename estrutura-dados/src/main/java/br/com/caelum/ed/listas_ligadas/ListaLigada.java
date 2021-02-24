package br.com.caelum.ed.listas_ligadas;

public class ListaLigada {

	private Celula primeira;
	private Celula ultima;
	private int totalDeElementos;

	/**
	 * Adiciona um elemento no fim da lista. No caso especial da Lista estar
	 * vazia, adicionar no começo ou no fim dessa lista dá o mesmo efeito.
	 * Então, se a Lista estiver vazia, chamaremos o método
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
	 * Adiciona o elemento em uma determinada posição dentro da estrutura
	 * 
	 * @param posicao
	 *            a posição desejada para adicionar o elemento
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
	 * Adiciona um elemento no começo da estrutura. Cria-se uma nova célula, e
	 * esta nova célula terá a referência <code>proxima</code> apontando para a
	 * atual <code>primeira</code> da lista. Depois atualiza-se o atributo
	 * <code>primeira</code> para se referenciar a esta nova célula recém
	 * criada. Ainda falta tratar o caso especial da Lista estar vazia. Neste
	 * caso, deve-se atualizar a referência que aponta para a última célula
	 * também. Através do atributo <code>totalDeAlunos</code> podemos
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
	 * Para inserir um elemento em qualquer posição precisamos pegar a célula
	 * anterior a da posição desejada, porque precisamos mexer na sua referência
	 * <code>proxima</code>. Para isso vamos criar um método auxiliar que pega
	 * determinada célula. Este método deve tomar cuidado com o caso da posição
	 * não existir. A verificação se a posição existe ou não é feita pelo método
	 * <code>posicaoOcupada(int)</code>.
	 * 
	 * @param posicao
	 *            a posicao da célula que se deseja buscar
	 * @return A célula requerida
	 */
	private Celula pegaCelula(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
		}
		Celula atual = primeira;
		for (int i = 0; i < posicao; i++) {
			atual = atual.getProxima();

		}
		return atual;
	}

	/**
	 * Pega a célula em que aquele elemento se encontra e acessa o elemento de
	 * dentro dela. Pode-se utilizar o <code>pegaCelula(int)</code> previamente
	 * criado
	 * 
	 * @param posicao
	 *            a posição do elemento
	 * @return o elemento requerido caso ele exista
	 */
	public Object pega(int posicao) {
		return this.pegaCelula(posicao).getElemento();
	}

	/**
	 * Inicialmente, deve-se verificar se a posição está ou não ocupada. Se não
	 * estiver, lança uma exceção. Caso contrário, deve-se verificar se a
	 * remoção é do começo ou do fim da Lista, se for um destes casos
	 * simplesmente chama-se os métodos já feitos. Por fim, se a remoção é no
	 * interior da Lista deve-se atualizar as referências das células
	 * relacionadas a célula a serem removidas (anterior e próxima). A próxima
	 * da anterior deve ser a proxima e a anterior da proxima deve ser a
	 * anterior
	 * 
	 * @param posicao
	 *            a posição do elemento a ser removido
	 */
	public void remove(int posicao) {
		if (!this.posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posição não existe");
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
	 * Antes de tentar remover deve-se verificar se a posição está ocupada. Não
	 * faz sentido remover algo que não existe. Depois, basta “avançar” a
	 * referência que aponta para a primeira célula. Por fim, é importante
	 * perceber que a Lista pode ficar vazia. Neste caso, deve-se colocar
	 * <code>null</code> na referência que aponta para a última célula.
	 */
	public void removeDoComeco() {
		if (!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posição não existe");
		}

		this.primeira = this.primeira.getProxima();
		this.totalDeElementos--;

		if (this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}

	/**
	 * A primeira verificação a ser feita é se a última posição existe. Podemos
	 * fazer isso através do método já criado <code>posicaoOcupada(int)</code>.
	 * Se a Lista estiver com apenas um elemento então remover do fim é a mesma
	 * coisa que remover do começo. Logo, podemos reutilizar o método
	 * <code>removeDoComeco()</code> para este caso. Agora, se a Lista tem mais
	 * que um elemento então devemos pegar a penúltima célula; fazer a próxima
	 * da penúltima ser <code>null</code>; e fazer o atributo
	 * <code>ultima</code> apontar para a penúltima.
	 */
	public void removeDoFim() {
		if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posição não existe");
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
	 * Verifica se a posiçao da estrutura está ocupada
	 * 
	 * @param posicao
	 *            a posição que se deseja verificar
	 * @return <code>true</code> se a posição estiver ocupada ou
	 *         <code>false</code> caso contrário
	 */
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}

	/**
	 * Percorre a Lista e compara com o método <code>equals(Object)</code> o
	 * elemento procurado contra todos os elementos da Lista.
	 * 
	 * @param elemento
	 *            o elemento a se pesquisar
	 * @return <code>true</code> se o elemento existe na estrutura e
	 *         <code>false</code> caso contrário
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
		//verificando se a lista está vazia
		if (this.totalDeElementos == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		Celula atual = primeira;

		// percorrendo até o penúltimo elemento
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
