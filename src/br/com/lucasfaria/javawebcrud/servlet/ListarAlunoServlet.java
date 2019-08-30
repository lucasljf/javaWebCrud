package br.com.lucasfaria.javawebcrud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.AlunoDao;
import br.com.lucasfaria.javawebcrud.model.Aluno;

@WebServlet("/listarAlunos")
public class ListarAlunoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Aluno> lista = new AlunoDao().listarTudo();

		req.setAttribute("lista", lista);
		RequestDispatcher rd = req.getRequestDispatcher("listaDeAlunos.jsp");
		rd.forward(req, resp);
	}
}
