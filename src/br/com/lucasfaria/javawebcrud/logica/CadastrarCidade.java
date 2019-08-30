package br.com.lucasfaria.javawebcrud.logica;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.CidadeDao;
import br.com.lucasfaria.javawebcrud.model.Cidade;

public class CadastrarCidade implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String estado = req.getParameter("estado");

		Cidade cidade = new Cidade();
		cidade.setNome(nome);
		cidade.setEstado(estado);

		new CidadeDao().inserir(cidade);

		return "sucessoCidade.jsp";
	}
}
