package it.polito.tdp.librettoUniversitario.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.librettoUniversitario.model.Esame;

public class DAO_Esame {

	public Esame find(String codice){
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		String query = ""
				+ "SELECT CODICE, TITOLO, DOCENTE, SUPERATO, VOTO, DATA_SUPERAMENTO "
				+ "FROM ESAME "
				+ "WHERE CODICE = ? ";
		Esame esame = null;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, codice);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				esame = new Esame(rs.getString("CODICE"), rs.getString("TITOLO"), rs.getString("DOCENTE"));
			}
			
			conn.close();
			return esame;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean create(Esame e){
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		String insert = ""
				+ "INSERT INTO ESAME (CODICE, TITOLO, DOCENTE) "
				+ "VALUES ( ?, ? , ?) ";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, e.getCodice());
			ps.setString(2, e.getTitolo());
			ps.setString(3, e.getDocente());
			
			int count = ps.executeUpdate();
			
			conn.close();
			
			return count>0?true:false;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
