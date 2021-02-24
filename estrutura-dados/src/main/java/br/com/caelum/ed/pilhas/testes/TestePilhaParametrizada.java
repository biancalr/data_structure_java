package br.com.caelum.ed.pilhas.testes;

import br.com.caelum.ed.Peca;
import br.com.caelum.ed.pilhas.PilhaParametrizada;

public class TestePilhaParametrizada {

	public static void main(String[] args) {
		PilhaParametrizada<Peca> pilhaDePecas = new PilhaParametrizada<>();
		
		Peca peca = new Peca();
		pilhaDePecas.insere(peca);
		
		Peca pecaRemovida = pilhaDePecas.remove();
		
		if (peca != pecaRemovida) {
			System.out.println("Erro: a peca removida não é igual à que foi inserida");
		}
		
		if (!pilhaDePecas.vazia()) {
			System.out.println("Erro: a pilha não está vazia");
		}
		
		PilhaParametrizada<String> pilhaDeString = new PilhaParametrizada<>();
		
		pilhaDeString.insere("Rafael Consentino");
		pilhaDeString.insere("Paulo Silveira");
		
		System.out.println(pilhaDeString.remove());
		System.out.println(pilhaDeString.remove());
		
	}

}
