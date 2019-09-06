<%@page import="java.util.List"%>
<%@page import="br.com.lucasfaria.javawebcrud.model.Cidade"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Lista de Cidades Cadastradas</h4>
	<table border="1">
		<tr>
			<th>Identificação</th>
			<th>Nome</th>
			<th>Estado</th>
			<th>Excluir</th>
		</tr>
		<%
			List<Cidade> cidades = (List<Cidade>) request.getAttribute("lista");
			for (Cidade c : cidades) {
		%>
		<tr>
			<td><%=c.getId()%></td>
			<td><%=c.getNome()%></td>
			<td><%=c.getEstado()%></td>
			<td><a href="sistema?logica=ExcluirCidade&id=<%=c.getId()%>">X</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<h5>Excluindo uma cidade, você também excluirá os alunos associados a ela.</h5>
	<br>
	<a href="inicio.jsp">Voltar</a>
</body>
</html>