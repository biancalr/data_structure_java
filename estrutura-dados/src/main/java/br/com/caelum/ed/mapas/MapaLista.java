package br.com.caelum.ed.mapas;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.ed.Carro;

public class MapaLista {

	private List<Associacao> associacoes = new ArrayList<>();

	/**
	 * O Mapa n�o pode permitir duas associa��es com a mesma chave. Ent�o,
	 * fazemos uma verifica��o para saber se a chave j� est� no Mapa. Utilizamos
	 * o m�todo contemChave(String) para este teste.
	 * 
	 * @param placa
	 *            a chave do elemento
	 * @param carro
	 *            o elemento que se deseja armazenar
	 */
	public void adiciona(String placa, Carro carro) {
		if (!this.contemChave(placa)) {
			Associacao associacao = new Associacao(placa, carro);
			this.associacoes.add(associacao);
		}
	}

	/**
	 * Da maneira que foi implementado devemos percorrer todas as associa��es
	 * para achar a desejada. Se a chave n�o estiver presente no Mapa uma
	 * exce��o � lan�ada
	 * 
	 * @param placa
	 *            a chave cujo elemento associado se deseja recuperar
	 * @return o Elemento associado �quela chave
	 * @throws IllegalArgumentException
	 *             caso a chave fornecida n�o exista na estrutura
	 */
	public Carro pega(String placa) {
		for (Associacao associacao : this.associacoes) {
			if (placa.equals(associacao.getPlaca())) {
				return associacao.getCarro();
			}
		}
		throw new IllegalArgumentException("Chave fornecida n�o existe");
	}

	/**
	 * Comparamos a chave recebida no par�metro com as chaves de todas as
	 * associa��es da Lista. Se alguma for igual ent�o marcamos a associa��o
	 * para remover. N�o podemos remover dentro do for por causa da
	 * concorr�ncia. Se o Mapa n�o tem uma associa��o com a chave procurada
	 * ent�o uma exce��o � lan�ada.
	 * 
	 * @param placa
	 *            a chave do elemento o qual se deseja remover
	 * @throws IllegalArgumentException
	 *             caso a chave n�o exista na estrutura
	 */
	public void remove(String placa) {
		if (this.contemChave(placa)) {
			for (int i = 0; i < this.associacoes.size(); i++) {
				Associacao associacao = this.associacoes.get(i);

				if (placa.equals(associacao.getPlaca())) {
					this.associacoes.remove(i);
					break;
				}

			}
		} else {
			throw new IllegalArgumentException("Chave fornecida n�o existe");
		}
	}

	/**
	 * Esta opera��o � simples, basta percorrer a Lista e comparar as chaves.
	 * Logo o consumo de tempo ser� linear
	 * 
	 * @param placa
	 * @return <code>true</code> se a chave j� tem um valor assiciado e
	 *         <code>false</code> caso n�o
	 */
	public boolean contemChave(String placa) {
		for (Associacao associacao : this.associacoes) {
			if (placa.equals(associacao.getPlaca())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Como todas as associa��es est�o armazenadas em uma Lista, o tamanho do
	 * Mapa � o tamanho da Lista
	 * 
	 * @return o tamanho da estrutura {@link MapaLista}
	 */
	public int getTamanho() {
		return this.associacoes.size();
	}

}
