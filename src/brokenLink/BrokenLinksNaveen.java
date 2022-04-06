package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksNaveen {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Before : " +links.size());
		links.addAll(driver.findElements(By.tagName("img")));
		
		List<WebElement> activeLinks = new ArrayList<>();
		System.out.println("Before : " +links.size());
		for(int i=0; i<links.size();i++) {
			if(links.get(i).getAttribute("href") != null) {
				activeLinks.add(links.get(i));
			}
		}
		
		System.out.println("Before : " +activeLinks.size());
		for(int i=0; i<activeLinks.size();i++) {
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(i).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(i).getAttribute("href") + "-->"+response);
		}
		
		

	}

}
