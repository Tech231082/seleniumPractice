package actionsConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		WebElement addons=driver.findElement(By.id("highlight-addons"));
		//creating an object of Actions class and passing driver as a reference
		Actions action=new Actions(driver);
		action.moveToElement(addons).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Visa Services")).click();
		
		driver.quit();
		

	}

}
