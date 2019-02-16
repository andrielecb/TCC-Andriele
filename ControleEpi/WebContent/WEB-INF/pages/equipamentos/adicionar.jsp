<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adicionar Equipamentos</title>
</head>
<body>
	<h1>Adicionar Equipamentos</h1>
	
	<form method="POST" action="<c:url value="/AdicionarEquipamentosServlet" />">
	
	<div>
			<label for="funcionarioId">Funcionario</label>
			<select name="funcionarioId" id="funcionarioId">
			
				<c:forEach items="${funcionarios }" var="f"> 
					<option value="${ f.id }">${ f.nome }</option>
				</c:forEach>
			
			</select>
		
	</div>
	
	<div>
			<label for="nome">Nome do Equipamento: </label>
			<input type="text" name="nome" id="nome">		
	</div>
	
	<div>
			<label for="quantidade">Quantidade: </label>
			<input type="text" name="quantidade" id="quantidade">		
	</div>
		
	<div>
			<label for="dataEntrega">Data de entrega: </label>
			<input type="date" name="dataEntrega" id="dataEntrega">		
	</div>
	
	<div>
			<label for="dataDevolucao">Data de devolução: </label>
			<input type="date" name="dataDevolucao" id="dataDevolucao">		
	</div>
	
	<div>
			<label for="aprovacaoCA">Aprovação C A: </label>
			<input type="text" name="aprovacaoCA" id="aprovacaoCA">		
	</div>
	
	<input type="submit" value="Enviar">
	</form>
	
</body>
</html>