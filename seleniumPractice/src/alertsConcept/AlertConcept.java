package alertsConcept;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		//launching rediff url
		driver.get("https://www.rediff.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")).click();
		//alert class reference and switching to popup
		Alert alert=driver.switchTo().alert();
		//getting alert 
		String msg=alert.getText();
		//printing
		System.out.print(msg);
		//validating
		if(msg.equals("Please enter a valid user name")) {
			System.out.print("Correct alert message");
		}else
		{
			System.out.print("Incorrect alert message");
		}
		//accepting
		alert.accept();
		

	}

}
