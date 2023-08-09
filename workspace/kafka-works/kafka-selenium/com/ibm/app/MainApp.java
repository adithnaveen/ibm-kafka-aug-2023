package com.ibm.app;

import com.ibm.db.User;
import com.ibm.selenium.WebRegistrationForm;

public class MainApp {
	public static void main(String[] args) {
		WebRegistrationForm form = new WebRegistrationForm();
		
		form.sendUserDetailsToWeb(new User());
	}
}
