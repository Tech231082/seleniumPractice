import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScriptExecutionDemo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		//create prefs map to store all preferences
		Map<String,Object> prefs=new HashMap<String,Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		driver=new ChromeDriver(options);
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sush.rinwa@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("sushila231082");
		
		
		WebElement element1=driver.findElement(By.xpath("//input[@type='submit']"));
		element1.click();
		//if the element is giving some exception with xpath/id etc stale-element,not visible type then we can use javascriptexcutor
		//it will directly jump into the html api and search the element
		//JavascriptExecutor js=((JavascriptExecutor)driver);
		//js.executeScript("arguments[0].click()", element1);
		Thread.sleep(1000);
		/*Alert alert=driver.switchTo().alert();
		System.out.print(alert.getText());
		alert.accept();*/
		
		WebElement element=driver.findElement(By.xpath("//input[@class='_1frb']"));
		drawBorder(element,driver);
		//get title by js
		String title=getTitleByJS(driver);
		System.out.print(title);
		
		String pageText=getInnerText(driver);
		System.out.print(pageText);
		
		//scroll page down
		scrollPageDown(driver);
		
		//scroll into view
		//find the element ele where we want to scroll
		driver.findElement(By.xpath("//div[contains(text(),'News Feed')]")).click();
		//Thread.sleep(2000);
		//WebElement el=driver.findElement(By.xpath("//a[@id='js_5xv']"));
				
		//scrollIntoView(el,driver);
		
		//taking screenshot 
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\JUnit\\eclipse-workspace\\seleniumPractice\\src\\screenShots\\screen1.png");
		FileUtils.copyFile(source,dest);
		//generateAlert(driver,"There is an issue with the pop up in facebook login");
		//driver.quit();
		//refresh the page using selenium
		//driver.navigate().refresh();
		//refresh using JS executor
		
		//refreshBrowserJS(driver);
		
		

	}
	/*public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
		public static void changeColor(String color,WebElement element,WebDriver driver) {
			JavascriptExecutor js=((JavascriptExecutor)driver);
			js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element)
		}*/
	public static void drawBorder(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='10px solid red'", element);
	}
	/*public static void generateAlert(WebDriver driver,String message) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}*/
	public static void refreshBrowserJS(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	public static String getInnerText(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String text=js.executeScript("return document.documentElement.innerText").toString();
		return text;
		
	}
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	public static void scrollIntoView(WebElement ele,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
}


