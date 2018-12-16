package edu.northeastern.cs5200;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionPool {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://cs5200-fall2018-hu.ctigxtza5ece.us-east-1.rds.amazonaws.com:3306/bonus";
	private static final String USER = "khu";
	private static final String PASSWORD = "wojiaohukuai";
	private static Connection dbConnection = null;
	private static ConnectionPool pool = null;
	
	public static ConnectionPool getInstance() {
		if (pool == null) {
			pool = new ConnectionPool();
		}
		return pool;
	}
	
	public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		if (dbConnection == null) {
			dbConnection = DriverManager.getConnection(URL, USER, PASSWORD);
			return dbConnection;
		} else { return dbConnection; } }
	
	public static void closeConnection() {
		try {
			if (dbConnection != null) {
			dbConnection.close();
			dbConnection = null; }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}