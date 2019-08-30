package br.com.lucasfaria.javawebcrud.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.CidadeDao;
import br.com.lucasfaria.javawebcrud.model.Cidade;

@SuppressWarnings("serial")
@WebServlet("/listarCidades")
public class ListarCidadeServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CidadeDao dao = new CidadeDao();
		List<Cidade> lista = dao.listarTudo();

//		Pode ser declarado assim:
//		List<Cidade> lista = new CidadeDao().listarTudo();
		
		req.setAttribute("lista", lista);
		RequestDispatcher rd = req.getRequestDispatcher("/listaDeCidades.jsp");
		rd.forward(req, resp);
	}
}
