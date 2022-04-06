package selectDropdown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownwithoutSelect {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		WebElement dropDown = driver.findElement(By.name("country"));
		dropDown.click();
		List<WebElement> dropDownValues = driver.findElements(By.xpath("//select[@name='country']//option"));
		//System.out.println(dropDownValues);
		for(WebElement s : dropDownValues) {
			String countryValue = s.getText();
			System.out.println(countryValue);
			if(countryValue.equals("INDIA")) {
				s.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("input#email")).sendKeys("Bhavin");
		Select s = new Select(dropDown);
		s.selectByValue("GREENLAND");
		

	}

}
