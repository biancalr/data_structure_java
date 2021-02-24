package br.com.caelum.ed.mapas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MapaEspalhamentoParametrizada<C, V> {

	private List<List<AssociacaoParametrizada<C, V>>> tabela = new ArrayList<List<AssociacaoParametrizada<C, V>>>();

	public MapaEspalhamentoParametrizada() {
		for (int i = 0; i < 100; i++) {
			this.tabela.add(new LinkedList<AssociacaoParametrizada<C, V>>());
		}
	}

	/**
	 * Como estamos utilizando a t�cnica de Espalhamento, para verificar se uma
	 * chave existe no {@link MapaEspalhamentoParametrizada}, basta calcular o
	 * �ndice correto da Tabela e procurar na Lista correspondente.
	 * 
	 * @param chave
	 *            chave que se deseja verificar a exist�ncia
	 * @return <code>true</code> se a chave existe dentro da estrutura e
	 *         <code>false</code> caso contr�rio
	 */
	public boolean contemChave(C chave) {
		int indice = this.calculaIndiceDaTabela(chave);
		List<AssociacaoParametrizada<C, V>> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			AssociacaoParametrizada<C, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Este procedimento � simples, calculamos o �ndice e procuramos a chave na
	 * Lista correspondente. Ao achar a chave, removemos a {@link AssociacaoParametrizada},
	 * se a chave n�o for achada podemos lan�ar uma exce��o ao usu�rio.
	 * 
	 * @param chave
	 *            a chave do elemento que se deseja remover
	 * 
	 * @throws IllegalArgumentException
	 *             caso a chave n�o exista na estrutura
	 */
	public void remove(C chave) {
		int indice = this.calculaIndiceDaTabela(chave);
		List<AssociacaoParametrizada<C, V>> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			AssociacaoParametrizada<C, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				lista.remove(i);
				return;
			}
		}

		throw new IllegalArgumentException("A chave n�o existe");
	}

	/**
	 * Ao adicionar uma {@link AssociacaoParametrizada} nova, pode ser que a chave da mesma
	 * j� exista no {@link MapaEspalhamentoParametrizada}. Neste caso, vamos retirar a
	 * {@link AssociacaoParametrizada} antiga antes de colocar a nova. Isso deve ser feito
	 * porque o {@link MapaEspalhamentoParametrizada} n�o permite chaves repetidas
	 * 
	 * @param chave
	 *            a chave do elemento que se deseja adicionar
	 * @param valor
	 *            o elemento a ser adicionado
	 */
	public void adiciona(C chave, V valor) {
		if (this.contemChave(chave)) {
			this.remove(chave);
		}

		int indice = this.calculaIndiceDaTabela(chave);
		List<AssociacaoParametrizada<C, V>> lista = this.tabela.get(indice);
		lista.add(new AssociacaoParametrizada<C, V>(chave, valor));
	}

	/**
	 * <p>
	 * O principal objetivo do {@link MapaEspalhamentoParametrizada} � oferecer uma forma
	 * r�pida de acessar o valor de uma chave dada.
	 * </p>
	 * <p>
	 * Ent�o, procuramos a associa��o pela chave na Lista adequada e devolvemos
	 * o valor correspondente. Se a chave n�o existe ent�o lan�amos uma exce��o
	 * para o usu�rio
	 * </p>
	 * 
	 * @param chave
	 *            a chave cujo elemento associado se deseja recuperar
	 * @return o elemento desejado associado �quela chave
	 * @throws IllegalArgumentException
	 *             caso a chave n�o exista na estrutura
	 */
	public V pega(C chave) {
		int indice = this.calculaIndiceDaTabela(chave);
		List<AssociacaoParametrizada<C, V>> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			AssociacaoParametrizada<C, V> associacao = lista.get(i);
			if (associacao.getChave().equals(chave)) {
				return associacao.getValor();
			}
		}

		throw new IllegalArgumentException("A chave n�o existe");
	}

	/**
	 * Este m�todo define uma maneira de ajustar o c�digo gerado pelo m�todo
	 * <code>hashCode()</code> e gerar um �ndice v�lido para a tabela;
	 * 
	 * @param chave
	 *            chave a qual se deseja ajustar
	 * @return a chave ajustada de acordo com a tabela
	 */
	private int calculaIndiceDaTabela(C chave) {
		return Math.abs(chave.hashCode()) % this.tabela.size();
	}

	/**
	 * <p>
	 * As associacoes est�o armazenadas na Tabela. Ent�o, para recuperar todas as
	 * associacoes, precisamos percorrer todos os conjuntos da Tabela. Em cada
	 * posi��o, h� uma Lista, pegaremos todos os elementos de cada Lista e
	 * armazenaremos em uma �nica Lista e a devolveremos.
	 * </p>
	 * 
	 * @return todas as associacoes armazenadas na tabela
	 */
	private List<AssociacaoParametrizada<C, V>> pegaTodas() {
		ArrayList<AssociacaoParametrizada<C, V>> associacoes = new ArrayList<AssociacaoParametrizada<C, V>>();
		for (List<AssociacaoParametrizada<C, V>> lista : this.tabela) {
			associacoes.addAll(lista);
		}
		return associacoes;
	}

	@Override
	public String toString() {
		return this.pegaTodas().toString();
	}

}
