package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DAOFuncionario {

	

	public void inserir (Funcionarios f) {
		
		try {
			Connection con = Conexao.getConexao();
			
			String sql = "INSERT INTO funcionarios(nome, funcao, unidade) VALUES(?, ?, ?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, f.getNome());
			pstm.setString(2, f.getFuncao());
			pstm.setString(3, f.getUnidade());
			
			pstm.execute();
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	
	public List<Funcionarios> listar(){
		List<Funcionarios> listaFuncionarios = new LinkedList<>();
		
		try {
			Connection con = Conexao.getConexao();
			
			String sql = "SELECT * FROM funcionarios ORDER BY id";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Funcionarios f = new Funcionarios();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setFuncao(rs.getString("funcao"));
				f.setUnidade(rs.getString("unidade"));
				listaFuncionarios.add(f);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaFuncionarios;
		
	}
	
	public void deletar(int id) {
		
		try {
			Connection con = Conexao.getConexao();
			String sql = "DELETE FROM funcionarios WHERE id=?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
			
	}
	
	public void editar(Funcionarios funcionario) {
		try {
			Connection con = Conexao.getConexao();
			String sql = "UPDATE funcionarios SET nome = ?, funcao = ?, unidade = ? WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, funcionario.getNome());
			pstm.setString(2, funcionario.getFuncao());
			pstm.setString(3, funcionario.getUnidade());
			pstm.setInt(4, funcionario.getId());
			
			pstm.execute();
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		
		}
		
	}
	
	public Funcionarios buscarPorId (int id) {
		
		try {
			Connection con = Conexao.getConexao();
			String sql = "SELECT * FROM funcionarios WHERE id = ?";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if(rs.next()) {
				Funcionarios f = new Funcionarios();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setFuncao(rs.getString("funcao"));
				f.setUnidade(rs.getString("unidade"));
				
				return f;
				
				
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		
		
		}
		return null;
	}
		
		
		
}


