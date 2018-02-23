package it.polito.tdp.librettoUniversitario.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.librettoUniversitario.db.DB_Manager;
import it.polito.tdp.librettoUniversitario.model.Esame;
import it.polito.tdp.librettoUniversitario.sql.QUERY_Esame;

public class DAO_Esame {

	public Esame find(String codice){
		
		Esame esame = null;
		
		try {
			Connection conn = DB_Manager.getInstance().getConnection();
			
			PreparedStatement ps = conn.prepareStatement(QUERY_Esame.SELECT_BY_CODICE);
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
			
		try {
			Connection conn = DB_Manager.getInstance().getConnection();
			
			PreparedStatement ps = conn.prepareStatement(QUERY_Esame.INSERT_ESAME);
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
