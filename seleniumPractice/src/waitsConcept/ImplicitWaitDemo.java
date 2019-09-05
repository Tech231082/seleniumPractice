package waitsConcept;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ImplicitWaitDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//window maximize
		driver.manage().window().maximize();
		//delete cache before launching new url
		driver.manage().deleteAllCookies();
		//putting page load timeOuts
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		
		WebElement element=driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		Actions action=new Actions(driver);
		
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Create a List')]")).click();
		
		driver.navigate().back();
		WebElement element1=driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		action.moveToElement(element1).build().perform();
		driver.findElement(By.xpath("//span[contains(text(),'Find a Gift')]")).click();
		
	
		//driver.quit();

		}

}
