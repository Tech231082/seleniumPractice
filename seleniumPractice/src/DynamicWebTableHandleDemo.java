import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandleDemo {

	private static final String String = null;

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
		driver.findElement(By.xpath("//span[contains(text(),'Companies')]")).click();
		
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/thead/tr/th[2]
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/thead/tr/th[3]
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/thead/tr/th[4]
		
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td[2]
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]
		
		//first way
		/*String beforexpath= "//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[";
				String afterxpath = "]/td[2]";
				
				for(int i=1;i<=3;i++) {
					String name=driver.findElement(By.xpath(beforexpath+i+afterxpath)).getText();
					System.out.println(name);
					if(name.contains("Rahini KUMAR")) {
					////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[3]/td[2]
						driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" +i +"]/td[2]")).click();
					}
				}*/
		//second method
		driver.findElement(By.xpath("//td[contains(text(),'Sushila Lnu')]//preceding-sibling::td")).click();
		driver.findElement(By.xpath("//td[contains(text(),'PARMOD KUMAR')]//preceding-sibling::td")).click();
		driver.findElement(By.xpath("//td[contains(text(),'Rahini KUMAR')]//preceding-sibling::td")).click();
		//driver.findElement(By.xpath("//th[contains(text(),'Address')]//preceding-sibling::th[@class='collapsing']")).click();
		
		
		
		driver.quit();
		
		

	}

}
