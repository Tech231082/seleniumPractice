import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalanderHandlinDemo {

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

		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div
		driver.findElement(By.xpath("//span[contains(text(),'Calendar')]")).click();
		driver.findElement(By.xpath("//i[@class='chevron right icon']")).click();
		//driver.findElement(By.xpath("//i[@class='chevron right icon']")).click();
		
		driver.findElement(By.cssSelector("#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > div > div.ui.segment.calendar-wrapper > div > div.rbc-month-view > div:nth-child(6) > div.rbc-row-bg > div:nth-child(6)")).click();
		
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[1]
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[5]
		////*[@id="ui"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[1]/div[2]
		
		////body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@class='']/div[@class='ui fluid container main-content']/div[@class='calendar-container']/div[@class='ui segment calendar-wrapper']/div[@class='rbc-calendar']/div[@class='rbc-month-view']/div[2]/div[1]/div[1]  
		////body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@class='']/div[@class='ui fluid container main-content']/div[@class='calendar-container']/div[@class='ui segment calendar-wrapper']/div[@class='rbc-calendar']/div[@class='rbc-month-view']/div[3]/div[1]/div[1]  
		////body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@class='']/div[@class='ui fluid container main-content']/div[@class='calendar-container']/div[@class='ui segment calendar-wrapper']/div[@class='rbc-calendar']/div[@class='rbc-month-view']/div[4]/div[1]/div[6]  
		
		String date="02/09/2019";
		
		String dateArray[]=date.split("/");
		
		//String day=dateArray[0];
		String month=dateArray[1];
		String year=dateArray[2];
		
		/*Select select=new Select(driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[4]")));
		*/
		String before_xpath="//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[";
		String after_xpath="]/div[1]/div[";
		
		
		final int totalWeekdays=7;
		String dayVal=null;
		boolean flag=false;
		
		/*for(int row=2;row<=totalWeekdays;row++) {
			for(int col=1;col<=totalWeekdays;col++) {
			
					//dayVal=driver.findElement(By.xpath(before_xpath+ row +after_xpath+ col +"]")).getText();
				driver.findElement(By.xpath(before_xpath+ row +after_xpath+ col +"]")).click();
				
				//System.out.println(dayVal);
				
			}
		
			
		}*/
		
		
	}

}
