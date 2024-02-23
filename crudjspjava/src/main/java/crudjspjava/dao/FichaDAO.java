package crudjspjava.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crudjspjava.modelo.Ficha;
import util.ConnectionFactory;

public class FichaDAO {
	
	private static Connection con;
	
	public static List<Ficha> getAllFichas() {
		List<Ficha> list = new ArrayList<Ficha>();
		
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"SELECT ficha.id, ficha.nomePaciente, ficha.numCarteiraPlano, planoDeSaude.nomePlan, especialidade.nomeEsp FROM ficha "
					+ "INNER JOIN planoDeSaude ON planoDeSaude.id = ficha.idPlanoDeSaude "
					+ "INNER JOIN especialidade ON especialidade.id = ficha.idEspecialidade "
					+ "ORDER BY ficha.id;"
			); 
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Ficha ficha = new Ficha();
				
				ficha.setId(rs.getInt("ficha.id"));
				ficha.setNomePaciente(rs.getString("ficha.nomePaciente"));
				ficha.setNumCarteiraPlano(rs.getString("ficha.numCarteiraPlano"));
				ficha.setPlanoDeSaude(rs.getString("planoDeSaude.nomePlan"));
				ficha.setEspecialidade(rs.getString("especialidade.nomeEsp"));
				
				list.add(ficha);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static Ficha getFichaById(int id) {
		Ficha ficha = new Ficha();
		
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"SELECT ficha.id, ficha.nomePaciente, ficha.numCarteiraPlano, planoDeSaude.nomePlan, especialidade.nomeEsp FROM ficha "
					+ "INNER JOIN planoDeSaude ON planoDeSaude.id = ficha.idPlanoDeSaude "
					+ "INNER JOIN especialidade ON especialidade.id = ficha.idEspecialidade "
					+ "WHERE ficha.id=?"
			); 
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				ficha.setId(rs.getInt("ficha.id"));
				ficha.setNomePaciente(rs.getString("ficha.nomePaciente"));
				ficha.setNumCarteiraPlano(rs.getString("ficha.numCarteiraPlano"));
				ficha.setPlanoDeSaude(rs.getString("planoDeSaude.nomePlan"));
				ficha.setEspecialidade(rs.getString("especialidade.nomeEsp"));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ficha;
	} 
	
	public static int criarFicha(Ficha f) {
		int status = 0;
		
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO ficha (nomePaciente, numCarteiraPlano, idPlanoDeSaude, idEspecialidade) VALUES (?, ?, ?, ?)");
		
			ps.setString(1, f.getNomePaciente());
			ps.setString(2, f.getNumCarteiraPlano());
			ps.setInt(3, PlanoDeSaudeDAO.getIdByName(f.getPlanoDeSaude()));
			ps.setInt(4, EspecialidadeDAO.getIdByName(f.getEspecialidade()));
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int editarFicha(Ficha f, int id) {
		int status = 0;
		
		try {
			con = ConnectionFactory.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE ficha SET "
					+ "nomePaciente=?, numCarteiraPlano=?, idPlanoDeSaude=?, idEspecialidade=? WHERE id=?");
			
			System.out.println(ps);
			
			ps.setString(1, f.getNomePaciente());
			ps.setString(2, f.getNumCarteiraPlano());
			ps.setInt(3, PlanoDeSaudeDAO.getIdByName(f.getPlanoDeSaude()));
			ps.setInt(4, EspecialidadeDAO.getIdByName(f.getEspecialidade()));
			ps.setInt(5, id);
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
