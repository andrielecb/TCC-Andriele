<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Funcionario</title>
</head>
<body>
<h1>Editar</h1>
	<form method="POST" action="<c:url value="/EditarFuncionariosServlet" />">
	<input type="hidden" name="id" value="${ f.id }">
	
	<div>
			<label for="nome">Nome:</label>
			<input type="text" name="nome" value="${f.nome }">
		</div>
	
	
		<div>
			<label for="funcao">Função</label>
			<input type="text" name="funcao" value="${f.funcao}">
		</div>
		<div>
			<label for="funcao">Unidade</label>
			<input type="text" name="unidade" value="${f.unidade}">
		</div>
		<input type="submit" value="salvar">
	</form>
	
</body>
</html>