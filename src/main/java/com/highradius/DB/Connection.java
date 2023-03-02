package com.highradius.DB;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	java.sql.Connection conn = null;

	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "Your pass";

	// Getting the connection
	static String mysqlUrl = DB_URL;

	public java.sql.Connection getconnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			System.out.println("Error while connecting to db");
			System.exit(0);
		}
		return conn;
	}
}
