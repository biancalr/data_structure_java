package br.com.caelum.ed.mapas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.caelum.ed.Carro;

public class MapaEspalhamento {

	private List<List<Associacao>> tabela = new ArrayList<List<Associacao>>();

	public MapaEspalhamento() {
		for (int i = 0; i < 100; i++) {
			this.tabela.add(new LinkedList<Associacao>());
		}
	}

	/**
	 * Como estamos utilizando a técnica de Espalhamento, para verificar se uma
	 * chave existe no {@link MapaEspalhamento}, basta calcular o índice correto
	 * da Tabela e procurar na Lista correspondente.
	 * 
	 * @param placa
	 *            chave que se deseja verificar a existência
	 * @return <code>true</code> se a chave existe dentro da estrutura e
	 *         <code>false</code> caso contrário
	 */
	public boolean contemChave(String placa) {
		int indice = this.calculaIndiceDaTabela(placa);
		List<Associacao> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			Associacao associacao = lista.get(i);
			if (associacao.getPlaca().equals(placa)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Este procedimento é simples, calculamos o índice e procuramos a chave na
	 * Lista correspondente. Ao achar a chave, removemos a {@link Associacao},
	 * se a chave não for achada podemos lançar uma exceção ao usuário.
	 * 
	 * @param placa
	 *            a chave do elemento que se deseja remover
	 * 
	 * @throws IllegalArgumentException
	 *             caso a chave não exista na estrutura
	 */
	public void remove(String placa) {
		int indice = this.calculaIndiceDaTabela(placa);
		List<Associacao> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			Associacao associacao = lista.get(i);
			if (associacao.getPlaca().equals(placa)) {
				lista.remove(i);
				return;
			}
		}
		throw new IllegalArgumentException("A chave não existe");
	}

	/**
	 * Ao adicionar uma {@link Associacao} nova, pode ser que a chave da mesma
	 * já exista no {@link MapaEspalhamento}. Neste caso, vamos retirar a
	 * {@link Associacao} antiga antes de colocar a nova. Isso deve ser feito
	 * porque o {@link MapaEspalhamento} não permite chaves repetidas
	 * 
	 * @param placa
	 *            a chave do elemento que se deseja adicionar
	 * @param carro
	 *            o elemento a ser adicionado
	 */
	public void adiciona(String placa, Carro carro) {
		if (this.contemChave(placa)) {
			this.remove(placa);
		}

		int indice = this.calculaIndiceDaTabela(placa);
		List<Associacao> list = this.tabela.get(indice);
		list.add(new Associacao(placa, carro));
	}

	/**
	 * <p>
	 * O principal objetivo do {@link MapaEspalhamento} é oferecer uma forma
	 * rápida de acessar o valor de uma chave dada.
	 * </p>
	 * <p>
	 * Então, procuramos a associação pela chave na Lista adequada e devolvemos
	 * o valor correspondente. Se a chave não existe então lançamos uma exceção
	 * para o usuário
	 * </p>
	 * 
	 * @param placa
	 *            a chave cujo elemento associado se deseja recuperar
	 * @return o elemento desejado associado àquela chave
	 * @throws IllegalArgumentException
	 *             caso a chave não exista na estrutura
	 */
	public Carro pega(String placa) {
		int indice = this.calculaIndiceDaTabela(placa);
		List<Associacao> lista = this.tabela.get(indice);

		for (int i = 0; i < lista.size(); i++) {
			Associacao associacao = lista.get(i);
			if (associacao.getPlaca().equals(placa)) {
				return associacao.getCarro();
			}
		}

		throw new IllegalArgumentException("A chave não existe");
	}

	/**
	 * Este método define uma maneira de ajustar o código gerado pelo método
	 * <code>hashCode()</code> e gerar um índice válido para a tabela;
	 * 
	 * @param placa
	 *            chave a qual se deseja ajustar
	 * @return a chave ajustada de acordo com a tabela
	 */
	private int calculaIndiceDaTabela(String placa) {
		return Math.abs(placa.hashCode()) % this.tabela.size();
	}

}
