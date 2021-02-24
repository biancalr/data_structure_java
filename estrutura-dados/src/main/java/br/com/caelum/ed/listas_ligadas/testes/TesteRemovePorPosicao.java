package br.com.caelum.ed.listas_ligadas.testes;

import br.com.caelum.ed.listas_ligadas.ListaLigada;

public class TesteRemovePorPosicao {

	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();

		lista.adiciona("Rafael");
		lista.adiciona("Paulo");
		lista.adiciona("Camila");
		
		lista.remove(1);
		System.out.println(lista);
	}

}
