package xpathConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		driver.get("https://www.amazon.com/");
		//number of input fields
		List<WebElement> input= driver.findElements(By.tagName("input"));
		System.out.print("input fields"+input.size());
		
		//no of buttons
		//List<WebElement> button= driver.findElements(By.tagName("button"));
		//System.out.print(button.size());
		
		//no of links
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
	    System.out.print("Number of links"+links.size());
	    
	    /*for(int i=0;i<links.size();i++) {
	    	System.out.print(links.get(i).getText());
	    }*/
	    
	    driver.quit();

	}

}
