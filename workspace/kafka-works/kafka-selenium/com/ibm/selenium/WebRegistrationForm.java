package com.ibm.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ibm.db.User;

public class WebRegistrationForm {

	public void sendUserDetailsToWeb(User user) {
		WebDriver driver = null; 
		System.setProperty("webdriver.chrome.driver", 
				"/Volumes/Kanchan/MyTrainings/ibm/ibm-kafka-aug-2023/driver/chromedriver");
		// step 1 : load driver 
		driver = new ChromeDriver(); 
		
		
		// step 2 : load url 
		String url = "https://training-support.net/selenium/SimpleForm"; 
		driver.get(url); 
		
		
		// step 3 : process 
		String webSiteTitle = driver.getTitle(); 

		System.out.println("Title is " + webSiteTitle);
		
		driver.findElement(By.id("full-name")).clear();
		driver.findElement(By.id("full-name")).sendKeys("harry"); 
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("harry@barray.com");
		
		driver.findElement(By.name("event-date")).clear();
		driver.findElement(By.name("event-date")).sendKeys("1/1/2023");  
		
		driver.findElement(By.id("additional-details")).clear();
		driver.findElement(By.id("additional-details")).sendKeys("testing additional Details"); 
		
		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/button")).click(); 
		
		// step 4 : close 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		driver.close(); 
	}
}
