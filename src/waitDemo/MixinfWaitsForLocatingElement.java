package waitDemo;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Timeout;

@Test
public class MixinfWaitsForLocatingElement {
	
	//WebDriver driver;
	SearchContext driver;
	//WebDriver driver1;
	 
	public void mixinfWaitsForLocatingElement() {
		// Setting up browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		((WebDriver)driver).get(null);
		}
 
	@AfterMethod
	public void printExitTime() {
		System.out.println("Wait ends at : " + new Date());
		((WebDriver) driver).quit();
	}

}
