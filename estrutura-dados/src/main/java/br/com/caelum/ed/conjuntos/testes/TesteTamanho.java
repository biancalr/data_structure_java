package br.com.caelum.ed.conjuntos.testes;

import br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteTamanho {

	public static void main(String[] args) {
		ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
		
		conjunto.adiciona("Ana");
		conjunto.adiciona("Paulo");
		
		System.out.println(conjunto.getTamanho());
		
		conjunto.adiciona("Paulo");
		
		System.out.println(conjunto.getTamanho());
		
		conjunto.adiciona("Rafael");
		
		System.out.println(conjunto.getTamanho());

	}

}
