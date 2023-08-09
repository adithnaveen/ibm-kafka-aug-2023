package com.ibm.app;

import java.util.List;

import com.ibm.db.User;
import com.ibm.db.UserDAO;
import com.ibm.selenium.WebRegistrationForm;

public class MainApp {
	public static void main(String[] args) {
		WebRegistrationForm form = new WebRegistrationForm();
		
		List<User> users = new UserDAO().getAllUsers(); 
		
		for(User user : users) {
			form.sendUserDetailsToWeb(user);
		}
		
	}
}
