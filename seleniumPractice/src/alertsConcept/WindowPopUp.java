package alertsConcept;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		
		//file upload pop up
				driver.findElement(By.xpath(" //input[@id='fileupload']")).sendKeys("C:\\Users\\parmod.kumar\\Desktop\\Book2.xlsx");
		//driver.findElement(By.xpath("//input[2]")).click();

	}

}
