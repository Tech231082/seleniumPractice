import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderUsingJS {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		
		driver.get("https://www.freecrm.com/");
		driver.findElement(By.xpath("//span[@class='icon icon-xs mdi-chart-bar']")).click();
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sush.rinwa@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("sushila231082");
		driver.findElement(By.xpath("//div[@class='ui stacked segment']//div[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).click();
		
		WebElement date=driver.findElement(By.xpath("//i[@class='chevron right icon']"));
		date.click();
		String dateVal="02-09-2019";
		selectDateJS(driver,date,dateVal);

	}
	public static void selectDateJS(WebDriver driver,WebElement element,String dateVal) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
	}

}
