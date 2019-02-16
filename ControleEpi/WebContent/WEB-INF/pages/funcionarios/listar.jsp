<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Funcionarios</title>
</head>
<body>

	<a href="<c:url value="/InserirFuncionariosServlet" />" class="btn"> + Adicionar</a>
	
	<table>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Função</th>
					<th>Unidade</th>
					<th>Ações</th>
				</tr>
				
				<c:forEach items="${ funcionarios}" var="f">
					<tr>
						<td>${ f.id }</td>
						<td>${ f.nome }</td>
						<td>${ f.funcao }</td>
						<td>${ f.unidade }</td>
						<td>
							<a href="<c:url value="/EditarFuncionariosServlet?id=${ f.id }" />" class="btn" title="Editar">
								Editar
							</a>
							<a href="<c:url value="/DeletarFuncionariosServlet?id=${ f.id }" />" class="btn">
								Deletar
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>

</body>
</html>