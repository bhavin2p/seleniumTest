package navigations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcepts {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		clickOn(driver, driver.findElement(By.id("u_0_2_Qz")), 20);
	}
		
		public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
			
			new WebDriverWait(driver, timeout).
			ignoring(StaleElementReferenceException.class).
			until(ExpectedConditions.elementToBeClickable(locator));
			locator.click();
			
			
			
		}


}
