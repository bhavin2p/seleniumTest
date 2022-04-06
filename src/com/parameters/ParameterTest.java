package com.parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterTest {

	WebDriver driver;
	
	@Test
	@Parameters({"url", "stockName"})
	public void rediffClick(String url, String stockName) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.switchTo().frame("moneyiframe");
		driver.findElement(By.xpath("//input[@id='query']")).sendKeys(stockName);
		driver.findElement(By.xpath("//input[@class='getqbtn']")).click();
	}
	
}
