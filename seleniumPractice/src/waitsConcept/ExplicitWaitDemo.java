package waitsConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	
		driver.get("https://www.ebay.com/");
		clickOn(driver,driver.findElement(By.xpath("//input[@class='btn btn-prim gh-spr']")),5);
		driver.quit();

	}
	public static void clickOn(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(element));
	}

}
