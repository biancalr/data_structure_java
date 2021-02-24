package br.com.caelum.ed.listas_ligadas.testes;

import br.com.caelum.ed.listas_ligadas.ListaLigada;

public class TesteContemElemento {

	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();

		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		
		System.out.println(lista.contem("Rafael"));
		System.out.println(lista.contem("Camila"));

	}

}
