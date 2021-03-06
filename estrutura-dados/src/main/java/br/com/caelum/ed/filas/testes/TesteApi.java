package br.com.caelum.ed.filas.testes;

import java.util.LinkedList;
import java.util.Queue;

import br.com.caelum.ed.vetores.Aluno;

public class TesteApi {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		Queue fila = new LinkedList();
		
		Aluno aluno = new Aluno();
		fila.offer(aluno);
		
		@SuppressWarnings("unused")
		Aluno alunoRemovido = (Aluno)fila.poll();
		
		if (fila.isEmpty()) {
			System.out.println("A fila est� vazia");
		}

	}

}
