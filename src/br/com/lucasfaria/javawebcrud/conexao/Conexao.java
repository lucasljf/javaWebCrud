package br.com.lucasfaria.javawebcrud.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String DSN = "jdbc:mysql://localhost/progWeb1";
	private static final String USUARIO = "root";
	private static final String SENHA = "123456";

	public Connection getConexao() {
		try {
//			Pode ser assim (forma mais antiga, mas funcional)
//			Class.forName("com.mysql.jdbc.Driver"); 
			
//			Ou assim (forma mais atual)
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
