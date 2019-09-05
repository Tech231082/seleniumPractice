package practiceSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropertiesReadingConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		Properties prop=new Properties();
		
		FileInputStream fis=new FileInputStream("C:/JUnit/eclipse-workspace/seleniumPractice/src/practiceSelenium/properties1.config");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		String URL=prop.getProperty("url");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
			//launching chrome browser
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "C:/mytools/geckodriver.exe");
			//launching ff browser
			driver=new FirefoxDriver();
		}
		driver.get(URL);
		driver.findElement(By.xpath(prop.getProperty("signIn_btn_xpath"))).click();
		//driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
		//driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		//driver.findElement(By.xpath(prop.getProperty("signIn_Button_xpath"))).click();
		//String title=driver.getTitle();
		//System.out.print(title);
		driver.findElement(By.xpath(prop.getProperty("create_amazon_account_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("app_customername_xpath"))).sendKeys(prop.getProperty("app_customername"));
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));;
		driver.findElement(By.xpath(prop.getProperty("password_check_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("create_account_xpath"))).click();

	}

}
