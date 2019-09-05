import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropBoxDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		
		driver.findElement(By.id("dropdownMenuButton")).click();
		
		//List<WebElement> list=driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));
		//System.out.println(list.size());
		
		////button[@id='dropdownMenuButton']//following-sibling::div//a
		System.out.println("dropdown menu");
		List<WebElement> lists=driver.findElements(By.xpath("//button[@id='dropdownMenuButton']//following-sibling::div//a"));		
		System.out.println(lists.size());
		for(int i=0;i<lists.size();i++) {
			System.out.println(lists.get(i).getText());
		}
		
		//dropdownlink
		System.out.println("dropdown links");
		driver.findElement(By.id("dropdownMenuLink")).click();
		////div[@aria-labelledby='dropdownMenuLink']//a
		////div[@aria-labelledby='dropdownMenuLink']//following-sibling::a[@class='dropdown-item']
		List<WebElement> links=driver.findElements(By.xpath("//div[@aria-labelledby='dropdownMenuLink']//following-sibling::a[@class='dropdown-item']"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++) {
			String l=links.get(i).getText();
			
			System.out.println(l);
			
			if(l.equals("Another action")) {
				links.get(i).click();
				break;
			}
			
		}
		/*
		//split drop downs
		System.out.println("split links");
		//driver.findElement(By.xpath("//button[@class='btn btn-info']"));
		List<WebElement> split=driver.findElements(By.xpath("//div[@class='dropdown-menu show']//a[@class='dropdown-item']"));
		System.out.println(split.size());
		for(int i=0;i<split.size();i++) {
			System.out.println(split.get(i).getText());
		}
		
		//drop right variation
		List<WebElement> right=driver.findElements(By.xpath("//div[@class='dropdown-menu show']//following-sibling::a[@class='dropdown-item']"));
		System.out.print(right.size());
		*/
		
		driver.quit();
		

	}

}
