package it.polito.tdp.librettoUniversitario.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import it.polito.tdp.librettoUniversitario.constants.Constants_DB;

public class DB_Connect {
	
	static private DB_Connect instance = null;

	private DB_Connect() {
		instance = this;
	}

	public static DB_Connect getInstance() {
		if (instance == null)
			return new DB_Connect();
		else {
			return instance;
		}
	}

	public Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(Constants_DB.jdbcUrl);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get connection " + Constants_DB.jdbcUrl, e);
		}
	}
}