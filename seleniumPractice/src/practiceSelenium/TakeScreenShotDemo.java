package practiceSelenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShotDemo {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		
		//driver.get("https://www.google.com/");
		driver.get("https://www.amazon.com/");
		
		//taking screenshot
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\JUnit\\eclipse-workspace\\seleniumPractice\\src\\screenShots\\screen.png");
		FileUtils.copyFile(source,dest);
		
		driver.quit();

	}

}
