package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Dizionario;

public class DizionarioDAO {
	
	public boolean esisteParola(String parola) {
		
		final String sql = "SELECT nome "
				+ "FROM parola "
				+ "WHERE nome = ? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet rs = st.executeQuery();

			if(rs.next()) {
				rs.close();
				st.close();
				conn.close();
				return true;
			}
			else 
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
}
