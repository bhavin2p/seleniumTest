package toolTipPrint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipdemo2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2019/08/tooltip-in-selenium-or-help-text-example.html");
		//https://demoqa.com/tool-tips
		Actions act = new Actions(driver);
		
		
		WebElement element = driver.findElement(By.xpath("//div[@class='tooltip']"));
		act.moveToElement(element);
		act.build().perform();
		
		String title = element.getText();
		
		System.out.println(title);
	}

}
