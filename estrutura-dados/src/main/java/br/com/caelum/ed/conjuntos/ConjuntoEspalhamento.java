package br.com.caelum.ed.conjuntos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ConjuntoEspalhamento {

	private List<List<String>> tabela = new ArrayList<List<String>>();

	private int tamanho = 0;

	public ConjuntoEspalhamento() {
		for (int i = 0; i < 26; i++) {
			LinkedList<String> lista = new LinkedList<>();
			tabela.add(lista);
		}
	}

	/**
	 * <p>
	 * Para adicionar uma palavra no Conjunto, devemos aplicar a Função de
	 * Espalhamento para descobrir em qual posição da Tabela devemos adicionar.
	 * Depois, recuperamos a Lista que está nesta posição para guardar a
	 * palavra.
	 * </p>
	 * <p>
	 * Utilizamos o método <code>contem(String)</code> para saber se o Conjunto
	 * já contém a palavra. Se contém o <code>adiciona(String)</code> não faz
	 * nada.
	 * </p>
	 * 
	 * @param palavra
	 *            a {@link String} a se adicionar no conjunto
	 */
	public void adiciona(String palavra) {
		if (!this.contem(palavra)) {
			this.verificaCarga();
			int indice = this.calculaIndiceDeTabela(palavra);
			List<String> lista = this.tabela.get(indice);
			lista.add(palavra);
			this.tamanho++;
		}
	}

	/**
	 * <p>
	 * Analogamente ao <code>adiciona(String)</code>, o método
	 * <code>remove(String)</code> deve achar a posição da Tabela onde está a
	 * Lista na qual a palavra a ser removida estaria. Depois, basta remover a
	 * palavra da Lista.
	 * </p>
	 * <p>
	 * Antes de tentar remover poderíamos verificar se a palavra está no
	 * Conjunto. Nas Listas da API do Java, existe uma sobrecarga do método de
	 * <code>remover</code> que recebe o próprio elemento, além do qual recebe
	 * um índice. Isto auxilia no este método
	 * </p>
	 * 
	 * @param palavra
	 */
	public void remove(String palavra) {
		if (this.contem(palavra)) {
			int indice = this.calculaIndiceDeTabela(palavra);
			List<String> lista = this.tabela.get(indice);
			lista.remove(palavra);
			this.tamanho--;
			this.verificaCarga();
		}
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
	 * @param palavra
	 *            a palavra que se deseja achar
	 * @return <code>true</code> se a palavra existe dentro da esrutura e
	 *         <code>false</code> caso contrário
	 */
	public boolean contem(String palavra) {
		int indice = this.calculaIndiceDeTabela(palavra);
		List<String> lista = this.tabela.get(indice);

		return lista.contains(palavra);
	}

	/**
	 * <p>
	 * As palavras estão armazenadas na Tabela. Então, para recuperar todas as
	 * palavras, precisamos percorrer todas as posições da Tabela. Em cada
	 * posição, há uma Lista, pegaremos todos os elementos de cada Lista e
	 * armazenaremos em uma única Lista e a devolveremos.
	 * </p>
	 * 
	 * @return todos os conjuntos de palavras armazenadas na estrutura
	 */
	public List<String> pegaTodas() {
		List<String> palavras = new ArrayList<>();
		for (int i = 0; i < this.tabela.size(); i++) {
			palavras.addAll(this.tabela.get(i));
		}
		return palavras;
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
		return this.tamanho;
	}

	/**
	 * <p>
	 * O método <code>calculaIndiceDaTabela(String)</code> usa o método
	 * <code>calculaCodigoDeEspalhamento</code> para obter o Código de
	 * Espalhamento e a partir dele calcula um índice válido para a Tabela (isto
	 * é, dentro dos índices da tabela)
	 * </p>
	 * <p>
	 * Esta operação de resto ajusta o resultado da função de hash para não sair
	 * do intervalo fechado considerando a quantidade de conjuntos representados
	 * pelo tamanho da tabela.
	 * </p>
	 * 
	 * @param palavra
	 *            a palavra a ser analisada
	 * @return o índice correspondente ao conjunto da palavra pesquisada
	 */
	private int calculaIndiceDeTabela(String palavra) {
		int codigoDeEspalhamento = this.calculaCodigoDeEspalhamento(palavra);
		codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
		return codigoDeEspalhamento % this.tabela.size();

	}

	/**
	 * <p>
	 * Esta operação está encarregada de analisar uma dada palavra e gerar um
	 * código genérico que chamaremos de <strong>Código de
	 * Espalhamento</strong>.
	 * </p>
	 * <p>
	 * Este método calcula o <strong>Código de Espalhamento</strong> faz um
	 * calculo sobre todos os caracteres que formam a String.
	 * </p>
	 * 
	 * 
	 * @param palavra
	 *            a palavra a ser analisada
	 * @return o código correspondente à palavra
	 */
	private int calculaCodigoDeEspalhamento(String palavra) {
		int codigo = 1;
		for (int i = 0; i < palavra.length(); i++) {
			codigo = 31 * codigo + palavra.charAt(i);
		}
		return codigo;
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
		List<String> palavras = this.pegaTodas();
		this.tabela.clear();

		for (int i = 0; i < novaCapacidade; i++) {
			this.tabela.add(new LinkedList<String>());
		}

		for (String palavra : palavras) {
			this.adiciona(palavra);
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
		double carga = this.tamanho / capacidade;

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

		for (List<String> lista : this.tabela) {
			System.out.print("[");
			for (int i = 0; i < lista.size(); i++) {
				System.out.print("*");
			}
			System.out.println("]");
		}
	}

}
