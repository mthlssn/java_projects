package crudjspjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crudjspjava.modelo.Especialidade;
import util.ConnectionFactory;

public class EspecialidadeDAO {
	private static Connection con;
	
	public static List<Especialidade> getAllEspecialidades() {
		List<Especialidade> list = new ArrayList<Especialidade>();
		
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM especialidade"); 
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Especialidade esp = new Especialidade();
				
				esp.setId(rs.getInt("id"));
				esp.setNome(rs.getString("nomeEsp"));
				
				list.add(esp);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static int getIdByName(String nome) {
		int id = -1;
		
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM especialidade WHERE nomeEsp=?"); 
			ps.setString(1, nome);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("id");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return id;
	}
}
