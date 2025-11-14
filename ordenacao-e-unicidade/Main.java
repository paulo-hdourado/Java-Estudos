package io.github.paulohdourado.ordenacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
	
	
	public static List<Pessoa> pessoas = new ArrayList<>();
	
	public static void main(String[] args) {
		
		
		Pessoa p1 = new Pessoa("Paulo", "123");
		Pessoa p3 = new Pessoa("Fernanda", "678");
		Pessoa p2 = new Pessoa("Ana", "456");
		Pessoa p4 = new Pessoa("Maria", "684");
		Pessoa p5 = new Pessoa("Gabriela", "419");
		Pessoa p6 = new Pessoa("Kaike", "046");
		
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		pessoas.add(p5);
		pessoas.add(p6);
		
		//Duplicatas
		
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		pessoas.add(p5);
		pessoas.add(p6);
		
	
		//Imprime tudo sem filtros
		for(Pessoa p : pessoas) {
			System.out.println(p);;
		}
		
		System.out.println(); //Espaço
		
		Comparator<Pessoa> sortByName = (pessoa1, pessoa2) -> pessoa1.getNome().compareTo(pessoa2.getNome()); //Ordena por nome
		
		Comparator<Pessoa> sortById = (pessoa1, pessoa2) -> Integer.compare(pessoa1.getId(), pessoa2.getId()); //Ordena por Id
		
		pessoas.sort(sortByName); //Ordena por Nome e modifica a lista original
		
		// Ou poderia usar: 
		//Collections.sort(pessoas, sortByName);
		
		
	   //	pessoas.sort(sortById);
		
		for(Pessoa p : pessoas) {
			System.out.println(p);
		}
		
		
		System.out.println(); //Espaço
		
		
		//Ordena por Id usando Stream
		pessoas.stream()
		.sorted(sortById)
		.forEach(p -> System.out.println(p));
		
		System.out.println(); //Espaço
		
		
		//Filtra duplicidade e ordena por ID
		pessoas.stream()
		.distinct()
		.sorted(sortById)
		.forEach(p -> System.out.println(p));
	}
}
