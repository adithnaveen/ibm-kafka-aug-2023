package com.ibm.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// DAO - Data Access Object 
public class UserDAO {
	public List<User> getAllUsers() {
		String sql = "select fullname, email, event_date, add_details from registeruser";
		
		List<User> users = null; 
		
		try {
			PreparedStatement prepareStatement = new GetConnection().getMysql().prepareStatement(sql); 
			ResultSet rs = prepareStatement.executeQuery();
			
			
			users = new ArrayList<>(); 
			
			while(rs.next()) {
				User temp = new User(); 
				temp.setFullName(rs.getString("fullname"));
				temp.setEmail(rs.getString("email"));
				temp.setEventDate(rs.getString("event_date"));
				temp.setAdditionalDetails(rs.getString("add_details"));
				
				users.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users; 
		
	}
}
