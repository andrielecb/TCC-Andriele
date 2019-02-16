<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserir Funcionarios</title>
</head>
<body>
	<form method="POST" action="/ControleEpi/InserirFuncionariosServlet">
		
		<div>
			<label for="nome">Nome</label>
			<input type="type" name="nome" id="nome">			
		</div>
		<div>
			<label for="Funcao">Funçao</label>
			<input type="type" name="funcao" id="funcao">
		</div>
		<div>
			<label for="Unidade">Unidade</label>
			<input type="type" name="unidade" id="unidade">
		</div>
		<input type="submit" value="Salvar">
	
	</form>


</body>
</html>