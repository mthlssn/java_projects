package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "";
	
	private static final String DATABASE_URL = "jdbc:mariadb://localhost/agenda";
	
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if(con != null) {
			System.out.println("Conexão obetida com sucesso!");
			con.close();
		}
	}
}
