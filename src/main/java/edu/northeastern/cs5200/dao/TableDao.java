package edu.northeastern.cs5200.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.northeastern.cs5200.ConnectionPool;

public class TableDao {
	private PreparedStatement pstmt;
	private Connection conn;
	private static TableDao tableDao = null;
	private final String DELETE_ADDRESS = "DELETE FROM cs5200_fall2018_hu_HW3.Address WHERE idAddress = ?;";
	public static TableDao getInstance() {
		if (tableDao == null) {
			tableDao = new TableDao();
			tableDao.connect();
		}
		return tableDao;
	}
	
	public void connect() {
		try {
			ConnectionPool.getInstance();
			conn = ConnectionPool.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAddress(int idAddress) {
		try {
			pstmt = conn.prepareStatement(DELETE_ADDRESS);
			pstmt.setInt(1, idAddress);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}