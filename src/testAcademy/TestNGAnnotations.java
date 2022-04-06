package testAcademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGAnnotations {
	
	public WebDriver driver;
	public String testURL = "http://www.swtestacademy.com/";
	
	@BeforeSuite
    public void setupSuite () {
        System.out.println("@BeforeSuite started.");
    }
	
	@BeforeTest
    public void setupTests () {
        System.out.println("@BeforeTest started.");
    }
	
	@BeforeClass
    public void setupClass () {
        System.out.println("@BeforeClass started.");
    }
	
	@BeforeMethod
    public void setupTest (){
        //Print console that code is in @BeforeMethod!
        System.out.println("@BeforeMethod has started.");
        //Create a new ChromeDriver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
	
	@Test
    public void firstTest () {
        System.out.println("First Test is Started.");
        //Go to www.swtestacademy.com
        driver.get(testURL);
        //Get page title
        String title = driver.getTitle();
        //Print page's title
        System.out.println("Page Title: " + title);
    }
	
	@Test
    public void secondTest () {
        System.out.println("Second Test is Started.");
        //Go to www.amazon.com
        driver.get("https://www.amazon.com/");
        //Get page title
        String title = driver.getTitle();
        //Print page's title
        System.out.println("Page Title: " + title);
    }
	
	@AfterMethod
    public void teardownTest (){
        System.out.println("@AfterMethod has started.");
        //Close browser and end the session
        driver.quit();
    }

    @AfterClass
    public void teardownClass (){
        System.out.println("@AfterClass has started.");
    }

    @AfterTest
    public void teardownTests (){
        System.out.println("@AfterTest has started.");
    }

    @AfterSuite
    public void teardownSuite (){
        System.out.println("@AfterSuite has started.");
    }

	
	
	
}
