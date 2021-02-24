package br.com.caelum.ed.conjuntos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamentoParametrizado<T> {

	private List<List<T>> tabela = new ArrayList<List<T>>();

	private int tamanho = 0;

	public ConjuntoEspalhamentoParametrizado() {
		for (int i = 0; i < 26; i++) {
			LinkedList<T> lista = new LinkedList<>();
			tabela.add(lista);
		}
	}

	/**
	 * <p>
	 * Para adicionar um objeto ao Conjunto, devemos aplicar a Função de
	 * Espalhamento para descobrir em qual posição da Tabela devemos adicionar.
	 * Depois, recuperamos a Lista que está nesta posição para guardar a
	 * palavra.
	 * </p>
	 * <p>
	 * Utilizamos o método <code>contem(String)</code> para saber se o Conjunto
	 * já contém o objeto. Se contém o <code>adiciona(String)</code> não faz
	 * nada.
	 * </p>
	 * 
	 * @param objeto
	 *            o objeto a se adicionar no conjunto
	 */
	public void adiciona(T objeto) {
		if (!this.contem(objeto)) {
			this.verificaCarga();
			int indice = this.calculaIndiceDaTabela(objeto);
			List<T> lista = this.tabela.get(indice);
			lista.add(objeto);
			this.tamanho++;
		}
	}

	/**
	 * <p>
	 * Analogamente ao <code>adiciona(String)</code>, o método
	 * <code>remove(Object)</code> deve achar a posição da Tabela onde está a
	 * Lista na qual o objeto a ser removido estaria. Depois, basta remover o
	 * objeto da Lista.
	 * </p>
	 * <p>
	 * Antes de tentar remover se verifica se a palavra está no Conjunto. Nas
	 * Listas da API do Java, existe uma sobrecarga do método de
	 * <code>remover</code> que recebe o próprio elemento, além do qual recebe
	 * um índice. Isto auxilia no este método.
	 * </p>
	 * 
	 * @param objeto
	 *            o objeto que se deseja remover
	 */
	public void remove(T objeto) {
		if (this.contem(objeto)) {
			int indice = this.calculaIndiceDaTabela(objeto);
			List<T> lista = this.tabela.get(indice);
			lista.remove(objeto);
			this.tamanho--;
			this.verificaCarga();
		}
	}

	/**
	 * <p>
	 * Os objetos estão armazenados na Tabela. Então, para recuperar todos os
	 * objetos, precisamos percorrer todas as posições da Tabela. Em cada
	 * posição, há uma Lista, pegaremos todos os elementos de cada Lista e
	 * armazenaremos em uma única Lista e a devolveremos.
	 * </p>
	 * 
	 * @return todos os conjuntos de objetos armazenadas na estrutura
	 */
	public List<T> pegaTodos() {
		List<T> objetos = new ArrayList<>();
		for (int i = 0; i < this.tabela.size(); i++) {
			objetos.addAll(this.tabela.get(i));
		}
		return objetos;
	}

	/**
	 * <p>
	 * Esta operação é simples, basta achar o índice da Tabela aplicando a
	 * Função de Espalhamento da palavra desejada e verificar se ela está na
	 * Lista correspondente.
	 * </p>
	 * <p>
	 * Aqui está o grande truque para deixar nosso Conjunto mais rápido que uma
	 * simples lista: buscamos apenas nos elementos que se encontram naquela
	 * “página da agenda”. Se o elemento não estiver lá, com certeza ele não se
	 * encontra em nenhuma outra página da agenda. O nosso espalhamento tem uma
	 * certa organização que facilita as buscas!
	 * </p>
	 * 
	 * @param objeto
	 *            o objeto que se deseja verificar
	 * @return <code>true</code> se a palavra existe dentro da esrutura e
	 *         <code>false</code> caso contrário
	 */
	public boolean contem(T objeto) {
		int indice = this.calculaIndiceDaTabela(objeto);
		List<T> lista = this.tabela.get(indice);

		return lista.contains(objeto);
	}

	/**
	 * <p>
	 * Um atributo guarda a quantidade de palavras presentes no Conjunto. Este
	 * atributo deve ser incrementado toda vez que uma palavra for adicionada e
	 * decrementado toda vez que uma palavra for removida.
	 * </p>
	 * 
	 * @return a quantidade de elementos armazenados na estrutura
	 */
	public int getTamanho() {
		return tamanho;
	}

	/**
	 * <p>
	 * O método <code>calculaIndiceDaTabela(String)</code> usa o método
	 * <code>hashCode</code> para obter o Código de Espalhamento e a partir dele
	 * calcula um índice válido para a Tabela (isto é, dentro dos índices da
	 * tabela)
	 * </p>
	 * <p>
	 * Esta operação de resto ajusta o resultado da função de hash para não sair
	 * do intervalo fechado considerando a quantidade de conjuntos representados
	 * pelo tamanho da tabela.
	 * </p>
	 * 
	 * @param objeto
	 *            o objeto que se deseja calcular o indice de espalhamento
	 * @return o codigo do conjunto da tabela em que o objeto será armazenado
	 */
	private int calculaIndiceDaTabela(T objeto) {
		int codigoDeEspalhamento = objeto.hashCode();
		codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
		return codigoDeEspalhamento % tabela.size();
	}

	/**
	 * <p>
	 * O tamanho da Tabela será dinâmico, ou seja, quanto mais elementos no
	 * Conjunto maior a Tabela e quanto menos elementos menor a Tabela.
	 * </p>
	 * <p>
	 * O que é feito neste método é o seguinte:
	 * </p>
	 * <ul>
	 * <li>Guarda em uma Lista todas as palavras do Conjunto.</li>
	 * <li>Limpa a tabela através do método <code>clear()</code> que toda Lista
	 * do Java tem.</li>
	 * <li>Inicializa a Tabela com a quantida de Lista da novaCapacidade.</li>
	 * <li>Guarda novamente as palavras no Conjunto.</li>
	 * </ul>
	 * 
	 * @param novaCapacidade
	 *            a nova capacidade de armazenamento da tabela
	 */
	private void redimensionaTabela(int novaCapacidade) {
		List<T> objetos = this.pegaTodos();
		this.tabela.clear();

		for (int i = 0; i < novaCapacidade; i++) {
			this.tabela.add(new LinkedList<T>());
		}

		for (T objeto : objetos) {
			this.adiciona(objeto);
		}
	}

	/**
	 * <p>
	 * Este método calcula a carga atual do conjunto. Se a carga for maior que
	 * 0.75 a novaCapacidade será o dobro da antiga. Se a carga for menor que
	 * 0.25 a novaCapacidade será a metade da antiga, mas para evitar ficar com
	 * uma capacidade muito pequena foi definido o mínimo de 10.
	 * </p>
	 * <p>
	 * Se esta carga ultrapassar o valor 0.75 significa que há uma alta chance
	 * de ocorrer colisões. Neste caso, aumentaremos o tamanho da Tabela.
	 * </p>
	 * <p>
	 * Se a carga ficar menor do que o valor 0.25 significa que a Tabela tem
	 * muito espaço vazio. Neste caso, diminuiremos o tamanho dela
	 * </p>
	 */
	private void verificaCarga() {
		int capacidade = this.tabela.size();
		double carga = (double) this.tamanho / capacidade;

		if (carga > 0.75) {
			this.redimensionaTabela(capacidade * 2);
		} else if (carga < 0.25) {
			this.redimensionaTabela(Math.max((capacidade / 2), 10));
		}
	}

	/**
	 * Um método cuja única função é testar o espalhamento da estrutura.
	 */
	public void imprimeTabela() {
		for (List<T> lista : this.tabela) {
			System.out.println("[");
			for (int i = 0; i < lista.size(); i++) {
				System.out.println("*");
			}
			System.out.println("]");
		}
	}

}
