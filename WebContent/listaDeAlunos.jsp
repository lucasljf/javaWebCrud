<%@page import="br.com.lucasfaria.javawebcrud.model.Aluno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Lista de Alunos Cadastrados</h4>
	<table border="1">
		<tr>
			<th>Identificação</th>
			<th>Nome</th>
			<th>Idade</th>
			<th>Cidade</th>
		</tr>
		<%
			List<Aluno> alunos = (List<Aluno>) request.getAttribute("lista");

			for (Aluno a : alunos) {
		%>
		<tr>
			<td><%=a.getId()%></td>
			<td><%=a.getNome()%></td>
			<td><%=a.getIdade()%></td>
			<td><%=a.getCidade().getNome() + " - " + a.getCidade().getEstado()%></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>