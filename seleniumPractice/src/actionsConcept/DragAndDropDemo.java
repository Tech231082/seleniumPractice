package actionsConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

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
		
		//dragging from source  and dropping to target location
		//make sure we always use build() and perform() method with Actions class object otherwise action would not be performed
		//action.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"))).release().build().perform();
		action.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")), driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"))).build().perform();
		//will close the current window
		driver.quit();

	}

}
