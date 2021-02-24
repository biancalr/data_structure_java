package br.com.caelum.ed.vetores.testes;

import java.util.ArrayList;
import java.util.Vector;

import br.com.caelum.ed.vetores.Aluno;
import br.com.caelum.ed.vetores.Vetor;

public class TesteDeApi {

	public static void main(String[] args) {
		Vetor vetor = new Vetor();
		Aluno aluno;

		System.out.println("Tamanho do vetor = " + vetor.getTamanho());
		for (int i = 0; i < 1000; i++) {
			aluno = new Aluno();
			vetor.adiciona(aluno);
		}
		System.out.println("Tamanho do vetor = " + vetor.getTamanho());

		System.out.println("---------------------");

		Vector<Aluno> vector = new Vector<Aluno>();
		System.out.println("Tamanho do vector = " + vector.size());
		for (int i = 0; i < vetor.getTamanho(); i++) {
			vector.add((Aluno) vetor.pega(i));
		}
		System.out.println("Tamanho do vector = " + vector.size());

		System.out.println("---------------------");

		ArrayList<Aluno> arraylist = new ArrayList<>();
		System.out.println("Tamanho do arraylist = " + arraylist.size());
		for (int i = 0; i < vetor.getTamanho(); i++) {
			arraylist.add((Aluno) vetor.pega(i));
		}
		System.out.println("Tamanho do arraylist = " + arraylist.size());
	}

}
