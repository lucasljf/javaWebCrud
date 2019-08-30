package br.com.lucasfaria.javawebcrud.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.CidadeDao;
import br.com.lucasfaria.javawebcrud.model.Cidade;

@WebServlet("/cadastrarCidade")
public class CadastrarCidadeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		busca parâmetro (enviados pelo formulário)
		String nome = req.getParameter("nome");
		String estado = req.getParameter("estado");

//		objeto contato
		Cidade cidade = new Cidade(); //refazer o construtor?
		cidade.setNome(nome);
		cidade.setEstado(estado);

//		salvar a cidade
		new CidadeDao().inserir(cidade);
		
		RequestDispatcher rd = req.getRequestDispatcher("sucessoCidade.jsp");
		rd.forward(req, resp);		
	}
}
