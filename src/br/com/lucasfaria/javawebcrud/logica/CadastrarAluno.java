package br.com.lucasfaria.javawebcrud.logica;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.AlunoDao;
import br.com.lucasfaria.javawebcrud.dao.CidadeDao;
import br.com.lucasfaria.javawebcrud.model.Aluno;
import br.com.lucasfaria.javawebcrud.model.Cidade;

public class CadastrarAluno implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		int idade = Integer.parseInt(req.getParameter("idade"));
		int idCidade = Integer.parseInt(req.getParameter("idCidade"));

		Cidade cidade = new CidadeDao().pequisaId(idCidade);

		Aluno aluno = new Aluno(nome, idade, cidade);
		new AlunoDao().inserir(aluno);

		return "sucessoAluno.jsp";
	}
}
