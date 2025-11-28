package br.unitins.algoritmos2.crudfilmes.model;

public class Ator {
	private String nome;
	private String papel;

	public Ator(String nome, String papel) {
		this.nome = nome;
		this.papel = papel;
	}

	public Ator() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	@Override
	public String toString() {
		
		return 	"\nNome: " +
				nome +
				" | Papel: " +
				papel;
	
		
	}

}
