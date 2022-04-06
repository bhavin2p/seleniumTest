package testNGDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	@BeforeSuite
	public void setUp() {
		System.out.println("setup system property for chrome");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("launch chrome Browser");
	}
	
	@BeforeTest
	public void login() {
		System.out.println("login method");
	}
	
	@BeforeMethod
	public void enterURL() {
		System.out.println("Enter URL");
	}
	
	@Test
	public void googleTitleTest() {
		System.out.println("Google Title Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout from app");
	}
	
	@AfterTest
	public void deleteAll() {
		System.out.println("Delete all cookies");
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("Close browser");
	}
	
	@AfterSuite
	public void generateTestReport() {
		System.out.println("Generate test reports");
	}
}
