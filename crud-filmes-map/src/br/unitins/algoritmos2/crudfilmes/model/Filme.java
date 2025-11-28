package br.unitins.algoritmos2.crudfilmes.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Filme {
	private Integer id;
	private String titulo;
	private int ano;
	private String diretor;

	private Genero genero;
	private List<Ator> elenco;

	static int cont = 1;

	public Filme(String titulo, int ano, String diretor, Genero genero) {
		this.id = cont++;
		this.titulo = titulo;
		this.ano = ano;
		this.diretor = diretor;
		this.genero = genero;
		this.elenco = new ArrayList<Ator>();
	}

	public Filme() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public List<Ator> getElenco() {
		return elenco;
	}

	public void setElenco(List<Ator> elenco) {
		this.elenco = elenco;
	}

	public void adicionarAtor(String nome, String papel) {
		
		Ator novoAtor = new Ator(nome, papel);
		
		this.elenco.add(novoAtor);
	}

	public static Filme lerDados(Scanner scan) {
		System.out.println("Informe o título do filme: ");
		String tituloScan = scan.nextLine();

		
		boolean varAno = false;
		int anoScan = 0;
		while(varAno != true) {
			
			System.out.println("Informe a ano de lançamento: ");
			try {
				
				anoScan = scan.nextInt();
				scan.nextLine();
				varAno = true;

			}catch(java.util.InputMismatchException e) {
				System.out.println("Formato incorreto. Digite apenas números.");
				
				scan.nextLine();
				
				varAno = false;
			}//Fim catch
			
		}//Fim while
		
		
		System.out.println("Informe o nome do diretor: ");
		String diretorNome = scan.nextLine();
		
		
		boolean varGenero = false;
		Genero generoSelecionado = null;
		
		while(varGenero != true) {
			
			System.out.println("Inforome o gênero do filme: \n");
			
			System.out.println("[1] - Ação");
			System.out.println("[2] - Animação");
			System.out.println("[3] - Aventura");
			System.out.println("[4] - Comédia");
			System.out.println("[5] - Drama");
			System.out.println("[6] - Fantasia");
			System.out.println("[7] - Ficção Científica");
			System.out.println("[8] - Terror");
			System.out.println("[0] - Outro");
			
			try {
				
				Integer opcaoGenero = scan.nextInt(); 
				scan.nextLine();
				
				if(opcaoGenero < 0 || opcaoGenero > 8) {
					System.out.println("Opção inválida. Tente novamente.");
					varGenero = false;
				}else {				
					generoSelecionado = Genero.selecionarGenero(opcaoGenero);
					varGenero = true;
				}
				
				
			}catch(java.util.InputMismatchException e) {
				System.out.println("Informe uma opção válida.");
				
				scan.nextLine();
				
				varGenero = false;
			}
		}//Fim do while
		
		
		Filme filme = new Filme(tituloScan, anoScan, diretorNome, generoSelecionado);
		
		int opcaoAdicionarAtor = -1;
		
		do {
			
			System.out.println("\nElenco principal do filme: \n");
			
			System.out.println("[1] - Adicionar novo ator ao elenco: ");
			System.out.println("[0] - Finalizar");
			
			try {
				opcaoAdicionarAtor = scan.nextInt();
				scan.nextLine();
				
				switch(opcaoAdicionarAtor) {
				case 1 : 
					
					System.out.println("Informe o nome do ator: ");
					String nomeAtor = scan.nextLine();
					
					System.out.println("Informe o papel: ");
					String papel = scan.nextLine();
					
					filme.adicionarAtor(nomeAtor, papel);
					
					break;
					
				case 0 : 
					if(filme.elenco.isEmpty()) {
						System.out.println("Um elenco vazio foi adicionado.");
					}else {
						System.out.println("Elenco adicionado com sucesso!");				
					}
					break;
					
				default :
				 System.out.println("Opção iválida.");
				break;
				}
			}catch(java.util.InputMismatchException e) {
				System.out.println("Entrada inválida, selecione apenas 1 ou 2.");
				
				scan.nextLine();
				
				opcaoAdicionarAtor = -1;
			}//fim do catch
			
			
		}while(opcaoAdicionarAtor != 0);
		
		return filme;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Ator ator : elenco) {
			sb.append(ator.toString()).append("\n");
		}
		
		String elencoFormatado = sb.toString();
		
		return 	"\n-------------------------" +
				"\nDetalhes: " +
		        "\n" +
				"\nID: " + id + 
				"\nTítulo: " + titulo +
				"\nAno de Lançamento: " + ano + 
				"\nDiretor: " + diretor +
				"\nGênero: " + genero.getNomeFormat() + 
				"\nElenco: " + elencoFormatado + 
				"\n-------------------------\n";
	}
	

	
	

}
