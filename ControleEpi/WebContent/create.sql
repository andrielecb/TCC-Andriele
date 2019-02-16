	CREATE TABLE funcionarios(
		id INT NOT NULL AUTO_INCREMENT,
		nome VARCHAR(255),
		funcao VARCHAR(255),
		unidade VARCHAR(255),
		PRIMARY KEY(id)

	);
	
	INSERT INTO funcionarios(nome, funcao, unidade)VALUES ("Andriele", "Tecnico", "Uruguaiana");
	
	
	
	
	
	CREATE TABLE equipamentos(
		id INT NOT NULL AUTO_INCREMENT,
		nome VARCHAR(255),
		quantidade INT NOT NULL,
		dataEntrega DATE,
		dataDevolucao DATE,
		aprovacaoCA INT NOT NULL,
		funcionario_id INT NOT NULL,
		FOREIGN KEY(funcionario_id) REFERENCES funcionarios(id),
		PRIMARY KEY(id)
		
	
	);
	
	INSERT INTO equipamentos(funcionario_id, nome, quantidade, dataEntrega, dataDevolucao, aprovacaoCA)
	VALUES (3, "Andriele", 10,"2018-12-14", "2019-01-10", 5);
	
	SELECT
	equipamentos.id AS equipamento_id,
	equipamentos.nome AS equipamento_nome,
	equipamentos.quantidade AS equipamento_quantidade,
	equipamentos.dataEntrega AS equipamento_dataEntrega,
	equipamentos.dataDevolucao AS equipamento_dataDevolucao,
	equipamentos.aprovacaoCA AS equipamento_aprovacao_CA,
	funcionarios.id AS funcionario_id,
	funcionarios.nome AS funcionario_nome,
	funcionarios.funcao AS funcionario_funcao,
	funcionarios.unidade AS funcionario_unidade
	from equipamentos INNER JOIN funcionarios ON equipamentos.funcionario_id = funcionarios.id;
