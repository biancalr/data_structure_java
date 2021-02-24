package br.com.caelum.ed.pilhas.testes;

import br.com.caelum.ed.Peca;
import br.com.caelum.ed.pilhas.PilhaParametrizada;

public class TesteDeUso {

	public static void main(String[] args) {
		PilhaParametrizada<Peca> pilha = new PilhaParametrizada<>();
		
		Peca pecaInsere = new Peca();
		pilha.insere(pecaInsere);
		
		@SuppressWarnings("unused")
		Peca pecaRemove = pilha.remove();
		
		if (pilha.vazia()) {
			System.out.println("A pilha está vazia");
		}

	}

}
