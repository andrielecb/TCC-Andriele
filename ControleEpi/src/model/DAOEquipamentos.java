package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DAOEquipamentos {
	
	public List<Equipamentos> listar(){
		List<Equipamentos> listarEquipamentos = new ArrayList<Equipamentos>();
		
		try {
			Connection con = Conexao.getConexao();
			String sql = "select "+
						 "equipamentos.id AS equipamento_id, "+
						 "equipamentos.nome AS equipamento_nome, "+
						 "equipamentos.quantidade AS equipamento_quantidade, "+
					     "equipamentos.dataEntrega AS equipamento_dataEntrega, "+
					     "equipamentos.dataDevolucao AS equipamento_dataDevolucao, "+
					     "equipamentos.aprovacaoCA AS equipamento_aprovacao_CA, "+
					     "funcionarios.id AS funcionario_id, "+
					 	 "funcionarios.nome AS funcionario_nome, "+
					 	 "funcionarios.funcao AS funcionario_funcao, "+
					 	 "funcionarios.unidade AS funcionario_unidade "+
					 	 "from equipamentos INNER JOIN funcionarios ON equipamentos.funcionario_id = funcionarios.id";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			
			ResultSet rs = pstm.executeQuery();
			
			while( rs.next() ){
				Equipamentos e = new Equipamentos();
				e.setId(rs.getInt("equipamento_id"));
				e.setNome(rs.getString("equipamento_nome"));
				e.setQuantidade(rs.getInt("equipamento_quantidade"));
				
				String dataEntrega = rs.getString("equipamento_dataEntrega");
				
				DateTimeFormatter fmte = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate lde = LocalDate.parse(dataEntrega, fmte);
				e.setDataEntrega(lde);
				
				
				String dataDevolucao = rs.getString("equipamento_dataDevolucao");
				
				DateTimeFormatter fmtd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate ldd = LocalDate.parse(dataDevolucao, fmtd);
				e.setDataDevolucao(ldd);
				
				
				Funcionarios f = new Funcionarios();
				f.setId(rs.getInt("funcionario_id"));
				f.setNome(rs.getString("funcionario_nome"));
				f.setFuncao(rs.getString("funcionario_funcao"));
				f.setUnidade(rs.getString("funcionario_unidade"));
				
				
				e.setFuncionarios(f);
				listarEquipamentos.add(e);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listarEquipamentos;
	}
	
	public void adicionar (Equipamentos e) {
		try {
			Connection con = Conexao.getConexao();
			
			String sql = "INSERT INTO EQUIPAMENTOS(funcionario_id, nome, quantidade, dataEntrega, dataDevolucao, aprovacaoCA) VALUES (?,?,?,?,?,?)";
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, e.getFuncionarios().getId());
			pstm.setString(2, e.getNome());
			pstm.setInt(3, e.getQuantidade());
			
			DateTimeFormatter fmte = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dataEntrega = e.getDataEntrega().format(fmte);
			pstm.setString(4, dataEntrega);
			
			DateTimeFormatter fmtd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String dataDevolucao = e.getDataDevolucao().format(fmtd);
			pstm.setString(5, dataDevolucao);
			
			pstm.setInt(6, e.getAprovacaoCA());
			
			pstm.execute();
			
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
	}
	
	public void deletar (int id) {
		try {
			Connection con = Conexao.getConexao();
			String sql = "DELETE FROM equipamentos WHERE id=?";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			
			pstm.execute();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Equipamentos buscarPorId (int id) {
		try {
			Connection con = Conexao.getConexao();
			
			String sql = "SELECT "+
						 "equipamentos.id AS equipamentos_id, "+
						 "equipamentos.nome AS equipamento_nome, "+
						 "equipamentos.quantidade AS equipamento_quantidade, "+
						 "equipamentos.dataEntrega AS equipamento_dataEntrega, "+
						 "equipamentos.dataDevolucao AS equipamento_dataDevolucao, "+
						 "equipamentos.aprovacaoCA AS equipamento_aprovacao_CA, "+
						 "funcionarios.id AS funcionario_id, "+
						 "funcionarios.nome AS funcionario_nome, "+
						 "funcionarios.funcao AS funcionario_funcao, "+
						 "funcionarios.unidade AS funcionario_unidade "+
						 "FROM equipamentos INNER JOIN funcionarios ON equipamentos.funcionario_id = funcionarios.id "+
						 "WHERE equipamentos.id = ?";
			
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			
			if( rs.next() ) {
				Equipamentos e = new Equipamentos();
				e.setId(rs.getInt("equipamento_id"));
				e.setNome(rs.getString("equipamento_nome"));
				e.setQuantidade(rs.getInt("equipamento_quantidade"));
				
				String dataEntrega = rs.getString("equipamento_dataEntrega");
				
				DateTimeFormatter fmte = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate lde = LocalDate.parse(dataEntrega, fmte);
				e.setDataEntrega(lde);
				
				String dataDevolucao = rs.getString("equipamento_dataDevolucao");
				
				DateTimeFormatter fmtd = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				LocalDate ldd = LocalDate.parse(dataDevolucao, fmtd);
				e.setDataDevolucao(ldd);
				
				Funcionarios f = new Funcionarios();
				f.setId(rs.getInt("funcionario_id"));
				f.setNome(rs.getString("funcionario_nome"));
				f.setFuncao(rs.getString("funcionario_funcao"));
				f.setUnidade(rs.getString("funcionario_unidade"));
				
				
				e.setFuncionarios(f);
				return e;
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}			 
		return null;
	}
}
