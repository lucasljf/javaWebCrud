package br.com.lucasfaria.javawebcrud.model;

public class Cidade {
	private int id;
	private String nome;
	private String estado;

	public Cidade() {

	}
	
	public Cidade(int id, String nome, String estado) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
