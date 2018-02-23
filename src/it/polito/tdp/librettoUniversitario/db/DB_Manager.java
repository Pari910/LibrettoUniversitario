package it.polito.tdp.librettoUniversitario.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Manager {
	
	static private DB_Manager instance = null;

	private DB_Manager() {
		instance = this;
	}

	public static DB_Manager getInstance() {
		if (instance == null)
			return new DB_Manager();
		else {
			return instance;
		}
	}

	public Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(DB_Constants.jdbcUrl);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get connection " + DB_Constants.jdbcUrl, e);
		}
	}
}