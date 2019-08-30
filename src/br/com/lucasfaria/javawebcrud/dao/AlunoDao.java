package br.com.lucasfaria.javawebcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.lucasfaria.javawebcrud.conexao.Conexao;
import br.com.lucasfaria.javawebcrud.model.Aluno;
import br.com.lucasfaria.javawebcrud.model.Cidade;

public class AlunoDao {

	private Connection conexao;
	private PreparedStatement stmt;

	public AlunoDao() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserir(Aluno aluno) {
		String sql = "INSERT INTO aluno (nome, idade, idCidade) VALUES (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setInt(3, aluno.getCidade().getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public List<Aluno> listarTudo() {
		String sql = "SELECT * FROM aluno";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Aluno> lista = new ArrayList<Aluno>();
			while (rs.next()) {
				Cidade cidade = new CidadeDao().pequisaId(rs.getInt("idCidade"));
				Aluno aluno = new Aluno(rs.getInt("id"), rs.getString("nome"), rs.getInt("idade"), cidade);
				lista.add(aluno);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
