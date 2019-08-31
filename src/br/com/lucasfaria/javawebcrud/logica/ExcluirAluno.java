package br.com.lucasfaria.javawebcrud.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.AlunoDao;

public class ExcluirAluno implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idAluno = Integer.parseInt(req.getParameter("id"));
		
//		Modelo1
//		Aluno aluno = new AlunoDao().pesquisaId(idAluno);
//		new AlunoDao().excluirAluno(aluno);
		
//		Modelo2
		new AlunoDao().excluirId(idAluno);
		
		return "sistema?logica=ListarAluno";
	}
}
