package br.com.lucasfaria.javawebcrud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.lucasfaria.javawebcrud.conexao.Conexao;
import br.com.lucasfaria.javawebcrud.model.Cidade;

public class CidadeDao {
	private Connection conexao;
	private PreparedStatement stmt;

	public CidadeDao() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserir(Cidade cidade) {
		String sql = "INSERT INTO cidade (nome, estado) VALUES (?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cidade.getNome());
			stmt.setString(2, cidade.getEstado());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cidade> listarTudo() {
		String sql = "SELECT * FROM cidade";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Cidade> lista = new ArrayList<Cidade>();
			while (rs.next()) {
				Cidade cidade = new Cidade(rs.getInt("id"), rs.getString("nome"), rs.getString("estado"));
				lista.add(cidade);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Cidade pequisaId(int id) {
		String sql = "SELECT * FROM cidade WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			Cidade cidade = new Cidade();
			if (rs.next()) {
				cidade = new Cidade(rs.getInt("id"), rs.getString("nome"), rs.getString("estado"));
			}
			return cidade;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}