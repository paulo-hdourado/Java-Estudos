package br.unitins.algoritmos2.crudfilmes.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.unitins.algoritmos2.crudfilmes.model.Filme;

public class Main {

	public static Scanner scan = new Scanner(System.in);
	public static Map<Integer, Filme> filmesInfo = new HashMap<>();

	public static void main(String[] args) {

		// Filme filme = Filme.lerDados(scan);

		int opcao = -1;

		do {

			exibirMenu();

			try {
				opcao = scan.nextInt();
				scan.nextLine();

				switch (opcao) {
				
				case 1 -> adicionar();
				
				case 2 -> {

					boolean varAlterar = false;
					while (varAlterar != true) {

						try {
							alterar();
							varAlterar = true;

						} catch (java.util.InputMismatchException e) {
							System.out.println("Erro: Você deve entrar com um número. Tente novamente.");

							scan.nextLine();
							varAlterar = false;
						} // fim do catch
					} // fim do while
				}

				case 3 -> {
					boolean varExcluir = false;
					while (varExcluir != true) {

						try {
							excluir();
							varExcluir = true;

						} catch (java.util.InputMismatchException e) {
							System.out.println("Erro: Você deve entrar com um número. Tente novamente.");

							scan.nextLine();
							varExcluir = false;
						}
					} // Fim do while
				}

				case 4 -> {
					boolean varListar = false;
					while (varListar != true) {

						try {
							listar();
							varListar = true;

						} catch (java.util.InputMismatchException e) {

							System.out.println("Selecione uma opção válida.");
							
							scan.nextLine();
							varListar = false;
						} // Fim do catch
					} // Fim do while
				}

				case 0 -> System.out.println("Encerrando programa...");

				default -> System.out.println("Entrada inválida! Tente novamente.");
				}

			} catch (java.util.InputMismatchException e) {
				System.out.println("Entrada inválida. Tente novamente.");
				scan.nextLine();

				opcao = -1;

			} // Fim do catch

		} while (opcao != 0);

		System.out.println("Programa encerrado.");

	}

	public static void exibirMenu() {

		System.out.println("------ CADASTRO DE FILMES ------\n");

		System.out.println("[1] - Adicionar filme");
		System.out.println("[2] - Alterar filme");
		System.out.println("[3] - Excluir filme");
		System.out.println("[4] - Listar filmes");
		System.out.println("[0] - Sair");
	}

	// --------------------------------------------------------------------------------------------

	public static void adicionar() {

		Filme filme = Filme.lerDados(scan);
		Integer idx = filme.getId();

		filmesInfo.put(idx, filme);
		System.out.println("Filme " + filme.getTitulo() + " adicionado com sucesso!\n");
	}

	// --------------------------------------------------------------------------------------------

	public static void alterar() {
		System.out.println("Informe o ID do filme que deseja alterar: ");

		Integer idFilme = scan.nextInt();
		scan.nextLine();

		Filme filmeProcurado = buscarFilme(idFilme);

		if (filmeProcurado == null) {
			System.out.println("O filme informado não foi encontrado.");
			return;
		}

		Integer idOriginal = filmeProcurado.getId();

		Filme filmeAtualizado = Filme.lerDados(scan);

		filmeAtualizado.setId(idOriginal);

		filmesInfo.put(idOriginal, filmeAtualizado);
		System.out.println("Filme " + filmeAtualizado.getTitulo() + " atualizado com sucesso!");

	}

	// --------------------------------------------------------------------------------------------

	public static Filme buscarFilme(Integer id) {

		if (filmesInfo.containsKey(id)) {
			return filmesInfo.get(id);
		}
		return null;
	}

	// --------------------------------------------------------------------------------------------

	public static void excluir() {
		System.out.println("Informe o ID do filme que deseja excluir: ");

		Integer idExcluir = scan.nextInt();
		scan.nextLine();

		Filme filmeParaExcluir = buscarFilme(idExcluir);

		if (filmeParaExcluir == null) {
			System.out.println("O filme informado não foi encontrado.");
			return;
		}

		filmesInfo.remove(idExcluir);
		System.out.println("Filme " + filmeParaExcluir.getTitulo() + " removido com sucesso!");
	}

	// --------------------------------------------------------------------------------------------

	public static void listar() {

		if (filmesInfo.isEmpty()) {
			System.out.println("Nenhum filme cadastrado ainda. \n");
			return;
		}

		System.out.println("------ Selecione um Padrão de Ordenação ------\n");

		System.out.println("[1] - Por ordem de inserção (Padrão)");
		System.out.println("[2] - Ordenar por Gênero");
		System.out.println("[3] - Ordenar por Título");
		System.out.println("[4] - Ordenar por Data de lançamento");

		int opcaoOrdenacao = scan.nextInt();
		scan.nextLine();

		switch (opcaoOrdenacao) {

		case 1 -> {

			for (Filme filme : filmesInfo.values()) {
				System.out.println(filme);
			}
		}

		case 2 -> {

			Comparator<Filme> ordenarPorGenero = (g1, g2) -> g1.getGenero().getNomeFormat().compareToIgnoreCase(g2.getGenero().getNomeFormat());

			List<Filme> ordenarPorGeneroList = new ArrayList<>(filmesInfo.values());

			ordenarPorGeneroList.stream().sorted(ordenarPorGenero).forEach(f -> System.out.println(f));

		}
		case 3 -> {

			Comparator<Filme> ordenarPorTitulo = (t1, t2) -> t1.getTitulo().compareToIgnoreCase(t2.getTitulo());

			List<Filme> ordenarPorTituloList = new ArrayList<>(filmesInfo.values());

			ordenarPorTituloList.stream().sorted(ordenarPorTitulo).forEach(t -> System.out.println(t));

		}

		case 4 -> {

			Comparator<Filme> ordenarPorData = (d1, d2) -> Integer.compare(d1.getAno(), d2.getAno());

			List<Filme> ordenarPorDataList = new ArrayList<>(filmesInfo.values());

			ordenarPorDataList.stream().sorted(ordenarPorData).forEach(d -> System.out.println(d));

		}

		default -> {
			System.out.println("Listando por ordem de inserção: \n");

			for (Filme filme : filmesInfo.values()) {
				System.out.println(filme);
			}
		}

		}
	}
}
