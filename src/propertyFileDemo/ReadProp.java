package propertyFileDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadProp {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = null;
		// how to read properties file 
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Dell\\OneDrive - MMI HOLDINGS LTD"
				+ "\\Documents\\Workspace\\seleniumTest\\src\\propertyFileDemo\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("browser"));
		String broswerName = prop.getProperty("browser");
		
		if(broswerName.equals("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhpanchal\\"
			//		+ "OneDrive - MMI HOLDINGS LTD\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if(broswerName.equals("FF")) {
			driver = new FirefoxDriver();
			WebDriverManager.firefoxdriver().setup();
		}
		else if(broswerName.equals("Safari")) {
			driver = new SafariDriver();
		
		}
		driver.get(prop.getProperty("url"));

	}

}
