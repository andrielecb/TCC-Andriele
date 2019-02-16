package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//singleton
public class Conexao {

	private static Connection con;
	
	public static Connection getConexao() throws ClassNotFoundException, SQLException{
		
		if( con == null){
			
				Class.forName("com.mysql.cj.jdbc.Driver");
				String conf = "jdbc:mysql://localhost/controle_epi?useTimezone=true&serverTimezone=UTC";
				con = DriverManager.getConnection(conf, "root", "root");
			
		}
		return con;
	}
	
	
}
