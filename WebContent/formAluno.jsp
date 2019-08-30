<%@page import="br.com.lucasfaria.javawebcrud.model.Cidade"%>
<%@page import="java.util.List"%>
<%@page import="br.com.lucasfaria.javawebcrud.dao.CidadeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Cadastro de Aluno</h3>
	<form action="sistema?logica=CadastrarAluno" method="post">
		Nome: <br>
		<input type="text" name="nome" > <br><br>
		Idade: <br>
		<input type="text" name="idade"> <br><br>
		Cidade: <br>
		<select name="idCidade">
		<%
			List<Cidade> lista = new CidadeDao().listarTudo();
		
			for (Cidade cidade : lista) {
				out.println("<option value='" + cidade.getId() + "'>" + cidade.getNome() + " - " + cidade.getEstado() + "</option>");
			}
		%>
		</select> <br><br>
		<input type="submit" value="Cadastrar Aluno">
	</form>
</body>
</html>