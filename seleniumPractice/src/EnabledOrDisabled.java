import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnabledOrDisabled {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com/");
		//applicable for all elements
		boolean b=driver.findElement(By.xpath("//input[@class='nav-input' and @value='Go']")).isDisplayed();
		System.out.println(b);
		
		boolean b1=driver.findElement(By.xpath("//input[@class='nav-input' and @value='Go']")).isEnabled();
		System.out.println(b1);
		
		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
		
		//driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
		boolean bb=driver.findElement(By.xpath("//input[@name='rememberMe']")).isEnabled();
		System.out.print(bb);
		

	}

}
