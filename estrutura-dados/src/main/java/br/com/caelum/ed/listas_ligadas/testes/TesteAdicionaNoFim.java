package br.com.caelum.ed.listas_ligadas.testes;

import br.com.caelum.ed.listas_ligadas.ListaLigada;

public class TesteAdicionaNoFim {

	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();
		
		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		
		System.out.println(lista);

	}

}
