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
	 * Para adicionar uma palavra no Conjunto, devemos aplicar a Fun��o de
	 * Espalhamento para descobrir em qual posi��o da Tabela devemos adicionar.
	 * Depois, recuperamos a Lista que est� nesta posi��o para guardar a
	 * palavra.
	 * </p>
	 * <p>
	 * Utilizamos o m�todo <code>contem(String)</code> para saber se o Conjunto
	 * j� cont�m a palavra. Se cont�m o <code>adiciona(String)</code> n�o faz
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
	 * Analogamente ao <code>adiciona(String)</code>, o m�todo
	 * <code>remove(String)</code> deve achar a posi��o da Tabela onde est� a
	 * Lista na qual a palavra a ser removida estaria. Depois, basta remover a
	 * palavra da Lista.
	 * </p>
	 * <p>
	 * Antes de tentar remover poder�amos verificar se a palavra est� no
	 * Conjunto. Nas Listas da API do Java, existe uma sobrecarga do m�todo de
	 * <code>remover</code> que recebe o pr�prio elemento, al�m do qual recebe
	 * um �ndice. Isto auxilia no este m�todo
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
	 * Esta opera��o � simples, basta achar o �ndice da Tabela aplicando a
	 * Fun��o de Espalhamento da palavra desejada e verificar se ela est� na
	 * Lista correspondente.
	 * </p>
	 * <p>
	 * Aqui est� o grande truque para deixar nosso Conjunto mais r�pido que uma
	 * simples lista: buscamos apenas nos elementos que se encontram naquela
	 * �p�gina da agenda�. Se o elemento n�o estiver l�, com certeza ele n�o se
	 * encontra em nenhuma outra p�gina da agenda. O nosso espalhamento tem uma
	 * certa organiza��o que facilita as buscas!
	 * </p>
	 * 
	 * @param palavra
	 *            a palavra que se deseja achar
	 * @return <code>true</code> se a palavra existe dentro da esrutura e
	 *         <code>false</code> caso contr�rio
	 */
	public boolean contem(String palavra) {
		int indice = this.calculaIndiceDeTabela(palavra);
		List<String> lista = this.tabela.get(indice);

		return lista.contains(palavra);
	}

	/**
	 * <p>
	 * As palavras est�o armazenadas na Tabela. Ent�o, para recuperar todas as
	 * palavras, precisamos percorrer todas as posi��es da Tabela. Em cada
	 * posi��o, h� uma Lista, pegaremos todos os elementos de cada Lista e
	 * armazenaremos em uma �nica Lista e a devolveremos.
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
	 * O m�todo <code>calculaIndiceDaTabela(String)</code> usa o m�todo
	 * <code>calculaCodigoDeEspalhamento</code> para obter o C�digo de
	 * Espalhamento e a partir dele calcula um �ndice v�lido para a Tabela (isto
	 * �, dentro dos �ndices da tabela)
	 * </p>
	 * <p>
	 * Esta opera��o de resto ajusta o resultado da fun��o de hash para n�o sair
	 * do intervalo fechado considerando a quantidade de conjuntos representados
	 * pelo tamanho da tabela.
	 * </p>
	 * 
	 * @param palavra
	 *            a palavra a ser analisada
	 * @return o �ndice correspondente ao conjunto da palavra pesquisada
	 */
	private int calculaIndiceDeTabela(String palavra) {
		int codigoDeEspalhamento = this.calculaCodigoDeEspalhamento(palavra);
		codigoDeEspalhamento = Math.abs(codigoDeEspalhamento);
		return codigoDeEspalhamento % this.tabela.size();

	}

	/**
	 * <p>
	 * Esta opera��o est� encarregada de analisar uma dada palavra e gerar um
	 * c�digo gen�rico que chamaremos de <strong>C�digo de
	 * Espalhamento</strong>.
	 * </p>
	 * <p>
	 * Este m�todo calcula o <strong>C�digo de Espalhamento</strong> faz um
	 * calculo sobre todos os caracteres que formam a String.
	 * </p>
	 * 
	 * 
	 * @param palavra
	 *            a palavra a ser analisada
	 * @return o c�digo correspondente � palavra
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
	 * O tamanho da Tabela ser� din�mico, ou seja, quanto mais elementos no
	 * Conjunto maior a Tabela e quanto menos elementos menor a Tabela.
	 * </p>
	 * <p>
	 * O que � feito neste m�todo � o seguinte:
	 * </p>
	 * <ul>
	 * <li>Guarda em uma Lista todas as palavras do Conjunto.</li>
	 * <li>Limpa a tabela atrav�s do m�todo <code>clear()</code> que toda Lista
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
	 * Este m�todo calcula a carga atual do conjunto. Se a carga for maior que
	 * 0.75 a novaCapacidade ser� o dobro da antiga. Se a carga for menor que
	 * 0.25 a novaCapacidade ser� a metade da antiga, mas para evitar ficar com
	 * uma capacidade muito pequena foi definido o m�nimo de 10.
	 * </p>
	 * <p>
	 * Se esta carga ultrapassar o valor 0.75 significa que h� uma alta chance
	 * de ocorrer colis�es. Neste caso, aumentaremos o tamanho da Tabela.
	 * </p>
	 * <p>
	 * Se a carga ficar menor do que o valor 0.25 significa que a Tabela tem
	 * muito espa�o vazio. Neste caso, diminuiremos o tamanho dela
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
	 * Um m�todo cuja �nica fun��o � testar o espalhamento da estrutura.
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
