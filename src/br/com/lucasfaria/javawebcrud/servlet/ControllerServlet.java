package br.com.lucasfaria.javawebcrud.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.logica.Logica;

@WebServlet("/sistema")
public class ControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String parametro = req.getParameter("logica");
		String nomeClasse = "br.com.lucasfaria.javawebcrud.logica." + parametro;

		try {
			Class<?> classe = Class.forName(nomeClasse);
//			Logica logica = (Logica) classe.newInstance();
			Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();
			
//			Após a execução da lógica, recebe um string
			String pagina = logica.executa(req, resp);
			
//			Faz o direcionamento (forward) para a página JSP
			req.getRequestDispatcher(pagina).forward(req, resp);

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
