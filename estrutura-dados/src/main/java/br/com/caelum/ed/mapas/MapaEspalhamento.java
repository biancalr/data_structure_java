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
	 * Como estamos utilizando a t�cnica de Espalhamento, para verificar se uma
	 * chave existe no {@link MapaEspalhamento}, basta calcular o �ndice correto
	 * da Tabela e procurar na Lista correspondente.
	 * 
	 * @param placa
	 *            chave que se deseja verificar a exist�ncia
	 * @return <code>true</code> se a chave existe dentro da estrutura e
	 *         <code>false</code> caso contr�rio
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
	 * Este procedimento � simples, calculamos o �ndice e procuramos a chave na
	 * Lista correspondente. Ao achar a chave, removemos a {@link Associacao},
	 * se a chave n�o for achada podemos lan�ar uma exce��o ao usu�rio.
	 * 
	 * @param placa
	 *            a chave do elemento que se deseja remover
	 * 
	 * @throws IllegalArgumentException
	 *             caso a chave n�o exista na estrutura
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
		throw new IllegalArgumentException("A chave n�o existe");
	}

	/**
	 * Ao adicionar uma {@link Associacao} nova, pode ser que a chave da mesma
	 * j� exista no {@link MapaEspalhamento}. Neste caso, vamos retirar a
	 * {@link Associacao} antiga antes de colocar a nova. Isso deve ser feito
	 * porque o {@link MapaEspalhamento} n�o permite chaves repetidas
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
	 * O principal objetivo do {@link MapaEspalhamento} � oferecer uma forma
	 * r�pida de acessar o valor de uma chave dada.
	 * </p>
	 * <p>
	 * Ent�o, procuramos a associa��o pela chave na Lista adequada e devolvemos
	 * o valor correspondente. Se a chave n�o existe ent�o lan�amos uma exce��o
	 * para o usu�rio
	 * </p>
	 * 
	 * @param placa
	 *            a chave cujo elemento associado se deseja recuperar
	 * @return o elemento desejado associado �quela chave
	 * @throws IllegalArgumentException
	 *             caso a chave n�o exista na estrutura
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

		throw new IllegalArgumentException("A chave n�o existe");
	}

	/**
	 * Este m�todo define uma maneira de ajustar o c�digo gerado pelo m�todo
	 * <code>hashCode()</code> e gerar um �ndice v�lido para a tabela;
	 * 
	 * @param placa
	 *            chave a qual se deseja ajustar
	 * @return a chave ajustada de acordo com a tabela
	 */
	private int calculaIndiceDaTabela(String placa) {
		return Math.abs(placa.hashCode()) % this.tabela.size();
	}

}
