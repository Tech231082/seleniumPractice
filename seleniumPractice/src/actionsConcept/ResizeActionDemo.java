package actionsConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizeActionDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//window maximize
		driver.manage().window().maximize();
		//delete cache before launching new url
		driver.manage().deleteAllCookies();
		
		driver.get("https://jqueryui.com/droppable/");
		//switching to frame
				driver.switchTo().frame(0);	
				//putting static wait of 3 seconds
				//static wait always requires throws declaration
				Thread.sleep(3000);
				//creating Actions class object
				Actions action=new Actions(driver);
				
				WebElement resize=driver.findElement(By.xpath("//div[@id='resizable']"));
				
				action.moveByOffset(50,50).build().perform();
				

	}

}
