package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

public class TesteEstoura {

	public static void main(String[] args) {
		Vetor vetor = new Vetor();
		for (int i = 0; i < 100001; i++) {
			Aluno aluno = new Aluno();
			vetor.adiciona(aluno);
		}

	}

}
