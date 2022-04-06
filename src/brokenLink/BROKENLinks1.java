package brokenLink;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BROKENLinks1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[contains(text(),'Best Sellers')]")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		/*List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links) {
			//WebElement ul = link;
			String url = link.getAttribute("href");
			verifyLinkActive(url);
			
		}*/
		
		TakesScreenshot scr = (TakesScreenshot)driver;
		File file = scr.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("path"));
		
	}

	private static void verifyLinkActive(String linkurl) {
		
		try {
		URL url = new URL(linkurl);
		HttpURLConnection httpconnection = (HttpURLConnection)url.openConnection();
		httpconnection.setConnectTimeout(3000);
		httpconnection.connect();
		if(httpconnection.getResponseCode()==200) {
			System.out.println(linkurl + " = " +httpconnection.getResponseMessage());
		}
		if(httpconnection.getResponseCode()== HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(linkurl + " = " +httpconnection.getResponseMessage() + " " +HttpURLConnection.HTTP_NOT_FOUND);
		}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
