package it.polito.tdp.librettoUniversitario.sql;

public class QUERY_Esame {
	
	public static final String SELECT_BY_CODICE = ""
		+ "SELECT CODICE, TITOLO, DOCENTE, SUPERATO, VOTO, DATA_SUPERAMENTO "
		+ "FROM ESAME "
		+ "WHERE CODICE = ? ";
	
	public static final String INSERT_ESAME = ""
		+ "INSERT INTO ESAME (CODICE, TITOLO, DOCENTE) "
		+ "VALUES ( ?, ? , ?) ";
}
