package model;

import java.time.LocalDate;

public class Equipamentos {

	private int id;
	private String nome;
	private Funcionarios funcionarios; //Minha chave estrangeira com (funcionarios)
	private int quantidade;
	private LocalDate dataEntrega;
	private LocalDate dataDevolucao;
	private int aprovacaoCA;
	
	
	
	
	public Funcionarios getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate string) {
		this.dataEntrega = string;
	}
	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getAprovacaoCA() {
		return aprovacaoCA;
	}
	public void setAprovacaoCA(int aprovacaoCA) {
		this.aprovacaoCA = aprovacaoCA;
	}
	
	
	
}
