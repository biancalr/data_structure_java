package br.com.caelum.ed.filas.testes;

import br.com.caelum.ed.filas.FilaParametrizada;
import br.com.caelum.ed.vetores.Aluno;

public class Teste2 {

	public static void main(String[] args) {

		FilaParametrizada<Aluno> fila = new FilaParametrizada<>();
		
		Aluno aluno = new Aluno();
		fila.insere(aluno);
		
		@SuppressWarnings("unused")
		Aluno alunoRemovido = fila.remove();
		
		if (fila.vazia()) {
			System.out.println("A fila está vazia");
		}
		
		FilaParametrizada<String> filaDeString = new FilaParametrizada<>();
		
		filaDeString.insere("Rafael Consentino");
		filaDeString.insere("Paulo Silveira");
		
		String paulo = filaDeString.remove();
		String rafael = filaDeString.remove();
		
		System.out.println(paulo);
		System.out.println(rafael);
		
	}

}
