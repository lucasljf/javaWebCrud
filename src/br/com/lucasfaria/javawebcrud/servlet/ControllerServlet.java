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
import br.com.lucasfaria.javawebcrud.dao.CidadeDao;
import br.com.lucasfaria.javawebcrud.model.Aluno;
import br.com.lucasfaria.javawebcrud.model.Cidade;

@WebServlet("/sistema")
public class ControllerServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String acao = req.getParameter("logica");

		if (acao.equals("CadastrarCidade")) {
			String nome = req.getParameter("nome");
			String estado = req.getParameter("estado");

			Cidade cidade = new Cidade();
			cidade.setNome(nome);
			cidade.setEstado(estado);

			new CidadeDao().inserir(cidade);

			RequestDispatcher rd = req.getRequestDispatcher("sucessoCidade.jsp");
			rd.forward(req, resp);

		} else if (acao.equals("ListarCidades")) {
			CidadeDao dao = new CidadeDao();
			List<Cidade> lista = dao.listarTudo();

			req.setAttribute("lista", lista);
			RequestDispatcher rd = req.getRequestDispatcher("/listaDeCidades.jsp");
			rd.forward(req, resp);
		}

		else if (acao.equals("CadastrarAluno")) {
			String nome = req.getParameter("nome");
			int idade = Integer.parseInt(req.getParameter("idade"));
			int idCidade = Integer.parseInt(req.getParameter("idCidade"));

			Cidade cidade = new CidadeDao().pequisaId(idCidade);

			Aluno aluno = new Aluno(nome, idade, cidade);
			new AlunoDao().inserir(aluno);

			RequestDispatcher rd = req.getRequestDispatcher("sucessoAluno.jsp");
			rd.forward(req, resp);
		}

		else if (acao.equals("ListarAlunos")) {
			List<Aluno> lista = new AlunoDao().listarTudo();

			req.setAttribute("lista", lista);
			RequestDispatcher rd = req.getRequestDispatcher("listaDeAlunos.jsp");
			rd.forward(req, resp);
		}
	}
}
