package br.com.lucasfaria.javawebcrud.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.lucasfaria.javawebcrud.dao.AlunoDao;
import br.com.lucasfaria.javawebcrud.dao.CidadeDao;
import br.com.lucasfaria.javawebcrud.model.Aluno;
import br.com.lucasfaria.javawebcrud.model.Cidade;

public class ExcluirCidade implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int idCidade = Integer.parseInt(req.getParameter("id"));

//		pesquisar cidade pelo ID gerando objeto cidade
		Cidade cidade = new CidadeDao().pesquisaId(idCidade);

//		pesquisar alunos que possuam essa cidade: pesquisaPorCidade()
		List<Aluno> alunos = new AlunoDao().pesquisaPorCidade(cidade);

//		deletar todos os alunos: for
		if (alunos != null) {
			for (Aluno a : alunos) {
				new AlunoDao().excluirAluno(a);
			}
		}

//		deletar a cidade
		new CidadeDao().excluirCidade(cidade);

		return "sistema?logica=ListarCidade";
	}

}
