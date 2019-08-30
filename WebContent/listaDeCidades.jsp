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
			<td>Identificação</td>
			<td>Nome</td>
			<td>Estado</td>
		</tr>
		<%
			List<Cidade> cidades = (List<Cidade>) request.getAttribute("lista");
			for (Cidade c : cidades) {
				out.println("<tr>");
				out.println("<td>" + c.getId() + "</td>");
				out.println("<td>" + c.getNome() + "</td>");
				out.println("<td>" + c.getEstado() + "</td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>