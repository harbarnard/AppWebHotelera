package com.restaurant.hoteleria.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {

	private static Connection conn;
		
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_hotel", "root", "maru2016");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
}