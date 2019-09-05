package practiceSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ReadingProppertiesFile {
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		//creating an obj of prop class
		Properties prop=new Properties();
		//obj of FIS will make a connection between our code and properties file
		FileInputStream fis=new FileInputStream("C:/JUnit/eclipse-workspace/seleniumPractice/src/practiceSelenium/config.properties");
		//this will enable us to read the properties file
		prop.load(fis);
		
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		String URL=prop.getProperty("url");
		System.out.println(URL);
		//if the proprety is not defined then it will give null value
		//System.out.println(prop.getProperty("Name"));
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		driver=new ChromeDriver();
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
			//launching chrome browser
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
						System.setProperty("webdriver.firefox.driver", "C:/mytools/geckodriver.exe");
			//launching firefox browser
			driver=new FirefoxDriver();
		}
		driver.get(URL);
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		//driver.quit();
			

	}

}
