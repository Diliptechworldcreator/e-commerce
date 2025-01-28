package com.jsp.ecommerce_jee_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.Driver;

public class ConnectionProvider {
	
	private static Connection conn = null;
	public static Connection getConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			String url = "jdbc:mysql://localhost:3306/e-commerce";
			String name  = "root";
			String password = "root";
			
			return DriverManager.getConnection(url, name, password);
			
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

}
