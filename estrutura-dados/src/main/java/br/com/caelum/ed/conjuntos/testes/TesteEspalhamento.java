package br.com.caelum.ed.conjuntos.testes;

import br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteEspalhamento {

	public static void main(String[] args) {
		ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
		
		for(int i = 0; i < 100; i++){
			conjunto.adiciona("" + i);
		}
		
		conjunto.imprimeTabela();

	}

}
