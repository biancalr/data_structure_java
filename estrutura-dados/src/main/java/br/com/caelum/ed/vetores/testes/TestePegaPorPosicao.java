package br.com.caelum.ed.vetores.testes;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

public class TestePegaPorPosicao {

	public static void main(String[] args) {
		
//		Aluno a1 = new Aluno();
//		Aluno a2 = new Aluno();
//		
//		a1.setNome("Rafael");
//		a2.setNome("Paulo");
//		
//		Vetor lista = new Vetor();
//		
//		lista.adiciona(a1);
//		lista.adiciona(a2);
//		
//		Aluno aluno1 = (Aluno) lista.pega(0);
//		Aluno aluno2 = (Aluno) lista.pega(1);
//		
//		System.out.println(aluno1);
//		System.out.println(aluno2);
		
		Aluno a1 = new Aluno();
		a1.setNome("Rafael");
		Vetor lista = new Vetor();
		lista.adiciona(a1);
		lista.pega(0);
		lista.pega(1);
		lista.pega(100000000);

	}

}
