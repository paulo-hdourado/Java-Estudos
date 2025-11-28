package br.unitins.algoritmos2.crudfilmes.model;

public enum Genero {
	ACAO(1, "Ação"),
	ANIMACAO(2, "Animação"),
	AVENTURA(3, "Aventura"),
	COMEDIA(4, "Comédia"),
	DRAMA(5, "Drama"),
	FANTASIA(6, "Fantasia"),
	FICCAO(7, "Ficção Científica"),
	TERROR(8, "Terror"),
	OUTRO(0, "Outro");
	
	private Integer id;
	private String nomeFormat;
	
	private Genero(Integer id, String nomeFormat) {
		this.id = id;
		this.nomeFormat = nomeFormat;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNomeFormat() {
		return nomeFormat;
	}


	public static Genero selecionarGenero(Integer id) {
		
		for(Genero genero : Genero.values()) {
			if(id == genero.getId()) {
				return genero;
			}
		}
		
		return null;
	}
}
