package com.sgic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class databaseConnection {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/library";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to a selected database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException ex) {
			Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("Connected database successfully...");
		return conn;
	}
/*public static void main (String args[]) throws ClassNotFoundException, SQLException{
	getConnection();
}*/
}
