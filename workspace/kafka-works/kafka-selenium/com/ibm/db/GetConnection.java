package com.ibm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	public Connection getMysql() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			String connectString = "jdbc:mysql://localhost/ibmaug";
			// ctrl + l + 2 
			Connection connection = DriverManager.getConnection(connectString, "root", "kanchan@1");
			
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return null; 
	}
	
	public static void main(String[] args) {
		System.out.println(new GetConnection().getMysql()!=null);  
	}
	
}
