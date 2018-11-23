package com.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver = null;
	Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sriva\\Documents\\Selenium Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		log.info("****Launching Facebook***");
		}
	
	@Test(priority=1)
	public void verifyTitle(){
		log.info("*******Verifying Title*********");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void verifyButtonDisplay(){
		log.info("*******Verifying Button*********");
		boolean btn = driver.findElement(By.xpath("//input[@value='Log In']")).isDisplayed();
		Assert.assertTrue(btn, "Button is displayed");
		log.info("*******Button verified*********");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
