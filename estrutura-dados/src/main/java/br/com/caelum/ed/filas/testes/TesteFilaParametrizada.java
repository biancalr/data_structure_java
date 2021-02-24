package br.com.caelum.ed.filas.testes;

import br.com.caelum.ed.filas.FilaParametrizada;
import br.com.caelum.ed.vetores.Aluno;

public class TesteFilaParametrizada {

	public static void main(String[] args) {

		FilaParametrizada<Aluno> filaDeAlunos = new FilaParametrizada<>();

		Aluno aluno = new Aluno();
		filaDeAlunos.insere(aluno);

		Aluno alunoRemovido = filaDeAlunos.remove();

		if (aluno != alunoRemovido) {
			System.out.println("Erro: o aluno removido não é igual ao que foi inserido");
		}

		if (!filaDeAlunos.vazia()) {
			System.out.println("Erro: A fila não está vazia");
		}
		
		FilaParametrizada<String> filaDeString = new FilaParametrizada<>();
		
		filaDeString.insere("Rafael Cosentino");
		filaDeString.insere("Paulo Silveira");
		
		System.out.println(filaDeString.remove());
		System.out.println(filaDeString.remove());

	}

}
