package com.ibm.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ibm.db.User;
import com.ibm.kafka.KafkaSeleniumProducer;

public class WebRegistrationForm {

	public void sendUserDetailsToWeb(User user) {
		WebDriver driver = null;
		KafkaSeleniumProducer ksp = new KafkaSeleniumProducer();

		System.setProperty("webdriver.chrome.driver",
				"/Volumes/Kanchan/MyTrainings/ibm/ibm-kafka-aug-2023/driver/chromedriver");
		// step 1 : load driver

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		// step 2 : load url
		String url = "https://training-support.net/selenium/SimpleForm";
		driver.get(url);

		// step 3 : process
		String webSiteTitle = driver.getTitle();

		System.out.println("Title is " + webSiteTitle);

		ksp.postMessage(webSiteTitle);

		driver.findElement(By.id("full-name")).clear();
		driver.findElement(By.id("full-name")).sendKeys(user.getFullName());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(user.getEmail());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("event-date")).clear();
		driver.findElement(By.name("event-date")).sendKeys(user.getEventDate());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("additional-details")).clear();
		driver.findElement(By.id("additional-details")).sendKeys(user.getAdditionalDetails());

		driver.findElement(By.xpath("//*[@id=\"signInForm\"]/button")).click();

		ksp.postMessage("Sent user details " + user.getFullName()); 
		
		
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
