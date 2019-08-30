package br.com.lucasfaria.javawebcrud.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.CidadeDao;
import br.com.lucasfaria.javawebcrud.model.Cidade;

public class ListarCidade implements Logica {
	
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CidadeDao dao = new CidadeDao();
		List<Cidade> lista = dao.listarTudo();

		req.setAttribute("lista", lista);

		return "/listaDeCidades.jsp";
	}
}
