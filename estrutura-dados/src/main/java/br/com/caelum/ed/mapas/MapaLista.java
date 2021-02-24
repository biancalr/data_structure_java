package br.com.caelum.ed.mapas;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.ed.Carro;

public class MapaLista {

	private List<Associacao> associacoes = new ArrayList<>();

	/**
	 * O Mapa não pode permitir duas associações com a mesma chave. Então,
	 * fazemos uma verificação para saber se a chave já está no Mapa. Utilizamos
	 * o método contemChave(String) para este teste.
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
	 * Da maneira que foi implementado devemos percorrer todas as associações
	 * para achar a desejada. Se a chave não estiver presente no Mapa uma
	 * exceção é lançada
	 * 
	 * @param placa
	 *            a chave cujo elemento associado se deseja recuperar
	 * @return o Elemento associado àquela chave
	 * @throws IllegalArgumentException
	 *             caso a chave fornecida não exista na estrutura
	 */
	public Carro pega(String placa) {
		for (Associacao associacao : this.associacoes) {
			if (placa.equals(associacao.getPlaca())) {
				return associacao.getCarro();
			}
		}
		throw new IllegalArgumentException("Chave fornecida não existe");
	}

	/**
	 * Comparamos a chave recebida no parâmetro com as chaves de todas as
	 * associações da Lista. Se alguma for igual então marcamos a associação
	 * para remover. Não podemos remover dentro do for por causa da
	 * concorrência. Se o Mapa não tem uma associação com a chave procurada
	 * então uma exceção é lançada.
	 * 
	 * @param placa
	 *            a chave do elemento o qual se deseja remover
	 * @throws IllegalArgumentException
	 *             caso a chave não exista na estrutura
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
			throw new IllegalArgumentException("Chave fornecida não existe");
		}
	}

	/**
	 * Esta operação é simples, basta percorrer a Lista e comparar as chaves.
	 * Logo o consumo de tempo será linear
	 * 
	 * @param placa
	 * @return <code>true</code> se a chave já tem um valor assiciado e
	 *         <code>false</code> caso não
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
	 * Como todas as associações estão armazenadas em uma Lista, o tamanho do
	 * Mapa é o tamanho da Lista
	 * 
	 * @return o tamanho da estrutura {@link MapaLista}
	 */
	public int getTamanho() {
		return this.associacoes.size();
	}

}
