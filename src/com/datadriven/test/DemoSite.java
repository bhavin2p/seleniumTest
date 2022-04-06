package com.datadriven.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSite {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.demoblaze.com/");
	}
	@DataProvider(name="SearchData")
	public Object[][] getTestData() {
		return new Object[][] {
			{"Bhavin14", "test123"},
			{"Bhavin15", "test123"},
			{"Bhavin16", "test123"}
		};
		
	}
	@Test(dataProvider = "SearchData")
	public void loginTest(String uName, String uPassword) throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys(uName);
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys(uPassword);
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Thread.sleep(5000);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
