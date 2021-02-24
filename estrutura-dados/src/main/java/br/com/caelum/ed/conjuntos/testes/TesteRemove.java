package br.com.caelum.ed.conjuntos.testes;

import java.util.List;

import br.com.caelum.ed.conjuntos.ConjuntoEspalhamento;

public class TesteRemove {

	public static void main(String[] args) {
		ConjuntoEspalhamento conjunto = new ConjuntoEspalhamento();
		
		conjunto.adiciona("Rafael");
		conjunto.adiciona("Ana");
		conjunto.adiciona("Paulo");
		
		List<String> palavras = conjunto.pegaTodas();
		
		System.out.println("Antes de remover");
		for (String palavra : palavras) {
			System.out.println(palavra);
		}
		
		conjunto.remove("Rafael");
		
		palavras = conjunto.pegaTodas();
		
		System.out.println("Depois de remover");
		for (String palavra : palavras) {
			System.out.println(palavra);
		}
		
	}

}
