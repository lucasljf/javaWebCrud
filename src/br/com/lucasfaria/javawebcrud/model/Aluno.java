package br.com.lucasfaria.javawebcrud.model;

public class Aluno {
	private int id;
	private String nome;
	private int idade;
	private Cidade cidade;

	public Aluno(int id, String nome, int idade, Cidade cidade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
	}
	
	public Aluno(String nome, int idade, Cidade cidade) {
		this.nome = nome;
		this.idade = idade;
		this.cidade = cidade;
	}

	public String getNome() {
		return this.nome;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public int getIdade() {
		return this.idade;
	}

	public int getId() {
		return id;
	}
}
