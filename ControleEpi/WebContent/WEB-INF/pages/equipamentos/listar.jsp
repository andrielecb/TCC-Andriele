<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Equipamentos</title>
</head>
<body>

	<h1>Listar Equipamentos</h1>
	
	<a href="<c:url value="/AdicionarEquipamentosServlet"/>">Adicionar</a>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Funcionarios</th>
			<th>Quantidade</th>
			<th>Data de Entrega</th>
			<th>Data de Devolução</th>
			<th>Aprovação CA</th>
			<th>Ações</th>
		</tr>
	
	<c:forEach items="${equipamentos}" var="e">
		<tr>
			<td>${e.id}</td>
			<td>${e.nome}</td>
			<td>${e.funcionarios.nome}</td>
			<td>${e.quantidade}</td>
			<td>${e.dataEntrega}</td>
			<td>${e.dataDevolucao}<td>
			<td>${e.aprovacaoCA}</td>
			<td>
			<a href="<c:url value="/EditarEquipamentosServlet?id=${e.id}"/>">Editar</a>
			<a href="<c:url value="/DeletarEquipamentosServlet?id=${e.id}"/>">Deletar</a>
			</td>
		
		
		</tr>
		
	</c:forEach>
	
	
	</table>
</body>
</html>