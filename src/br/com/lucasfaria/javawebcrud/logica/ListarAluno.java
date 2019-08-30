package br.com.lucasfaria.javawebcrud.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.AlunoDao;
import br.com.lucasfaria.javawebcrud.model.Aluno;

public class ListarAluno implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Aluno> lista = new AlunoDao().listarTudo();

		req.setAttribute("lista", lista);

		return "listaDeAlunos.jsp";
	}
}
