package br.com.caelum.ed.pilhas.testes;

import java.util.Stack;

import br.com.caelum.ed.Peca;

public class TesteApi {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Stack<Peca> pilha = new Stack<>();

		Peca pecaInsere = new Peca();
		pilha.push(pecaInsere);
		
		Peca pecaRemove = (Peca) pilha.pop();
		
		if (pilha.isEmpty()) {
			System.out.println("A pilha está vazia");
		}
		
	}

}
