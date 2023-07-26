package com.game.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {

	private static final String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3307/game";
	private static final String USER = "root";
	private static final String PWD = "kd1824java";
	
	static {
		try {
			Class.forName(DRIVER_CLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCon() {
		try {
			Connection con = DriverManager.getConnection(URL, USER, PWD);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		DBCon.getCon();
	}
}
