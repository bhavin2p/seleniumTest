package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class brokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.co.in/");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			verifyLinkActive(url);
		}
	}

	public static void verifyLinkActive(String url) throws IOException {
		URL url1 = new URL(url);
		HttpURLConnection httpconnection = (HttpURLConnection) url1.openConnection();
		httpconnection.setConnectTimeout(3000);
		httpconnection.connect();
		if (httpconnection.getResponseCode() == 200) {
			System.out.println(url + " = " + httpconnection.getResponseMessage());
		}
		if (httpconnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(
					url + " - " + httpconnection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
		}
	}
}
