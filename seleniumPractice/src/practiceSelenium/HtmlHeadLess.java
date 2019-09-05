package practiceSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlHeadLess {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching htmlunit browser
		//not suitable for action class(mouse movement,drag and drop,double click)
		//very fast
		//browser is not launched (behind the scene)
		WebDriver driver=new HtmlUnitDriver();
		driver.get("https://www.amazon.com/");
		String title=driver.getTitle();
		System.out.println(title);

	}

}
