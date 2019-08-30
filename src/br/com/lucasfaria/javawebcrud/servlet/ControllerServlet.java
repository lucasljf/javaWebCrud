package br.com.lucasfaria.javawebcrud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.logica.CadastrarAluno;
import br.com.lucasfaria.javawebcrud.logica.CadastrarCidade;
import br.com.lucasfaria.javawebcrud.logica.ListarAluno;
import br.com.lucasfaria.javawebcrud.logica.ListarCidade;

@WebServlet("/sistema")
public class ControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("logica");

		if (acao.equals("CadastrarCidade")) {
			new CadastrarCidade().executa(req, resp);

		} else if (acao.equals("ListarCidade")) {
			new ListarCidade().executa(req, resp);
		}

		else if (acao.equals("CadastrarAluno")) {
			new CadastrarAluno().executa(req, resp);
		}

		else if (acao.equals("ListarAluno")) {
			new ListarAluno().executa(req, resp);
		}
	}
}
