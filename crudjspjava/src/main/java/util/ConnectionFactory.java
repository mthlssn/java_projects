package util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/crudjspjava", "root", "123");
			
			return con;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
