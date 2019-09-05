package xpathConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		
		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("kids");
		
		//driver.findElement(By.xpath("//input[contains(@id,'twotabsearch')]")).sendKeys("kids");
		
		//driver.findElement(By.xpath("//input[starts-with(@id,'twotabsearch')]")).sendKeys("Kids uniform");
		
		//driver.findElement(By.xpath("//input[ends-with(@id,'textbox')]")).sendKeys("Girls school uniforms");
		
		//how to click on a link without using By.linkText
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		driver.navigate().back();
		Thread.sleep(2000);
		//driver.navigate().refresh();
		
		driver.findElement(By.xpath("//a[contains(text(),'Sell')]")).click();
		
		//driver.quit();

	}

}
