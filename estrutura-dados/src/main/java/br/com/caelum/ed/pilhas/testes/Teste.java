package br.com.caelum.ed.pilhas.testes;

import br.com.caelum.ed.Peca;
import br.com.caelum.ed.pilhas.PilhaParametrizada;

public class Teste {

	public static void main(String[] args) {
		PilhaParametrizada<Peca> pilha = new PilhaParametrizada<>();

		Peca peca = new Peca();
		pilha.insere(peca);
		
		@SuppressWarnings("unused")
		Peca pecaRemove = pilha.remove();
		
		if (pilha.vazia()) {
			System.out.println("A pilha está vazia");
		}
		
		PilhaParametrizada<String> pilha2 = new PilhaParametrizada<>();
		pilha2.insere("Rafael Consentino");
		pilha2.insere("Paulo Silveira");
		
		String paulo = pilha2.remove();
		String rafael = pilha2.remove();
		
		System.out.println(paulo);
		System.out.println(rafael);
		
	}

}
