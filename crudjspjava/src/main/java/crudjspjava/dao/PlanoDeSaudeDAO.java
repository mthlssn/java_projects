package crudjspjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crudjspjava.modelo.PlanoDeSaude;
import util.ConnectionFactory;

public class PlanoDeSaudeDAO {
	private static Connection con;
	
	public static List<PlanoDeSaude> getAllPlanosDeSaude() {
		List<PlanoDeSaude> list = new ArrayList<PlanoDeSaude>();
		
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM planoDeSaude"); 
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				PlanoDeSaude plan = new PlanoDeSaude(); 
				
				plan.setId(rs.getInt("id"));
				plan.setNome(rs.getString("nomePlan"));
				
				list.add(plan);
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
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM planoDeSaude WHERE nomePlan= ? "); 
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
