package br.com.caelum.ed.listas_ligadas.testes;

import br.com.caelum.ed.listas_ligadas.ListaLigada;

public class TesteAdicionaNoComeco {

	public static void main(String[] args) {
		ListaLigada lista = new ListaLigada();

		lista.adicionaNoComeco("Rafael");
		lista.adicionaNoComeco("Paulo");
		
		System.out.println(lista);

	}

}
