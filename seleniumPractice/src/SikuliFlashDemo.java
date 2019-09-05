import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliFlashDemo {

	public static void main(String[] args) throws FindFailed {
		System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
		//launching chrome browser
		WebDriver driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.youtube.com/watch?v=Ji46s5BHdr0");
		
		//create the object of Screen class in Sikuli
		Screen s=new Screen();
		
		Pattern skipadds=new Pattern("skipadds.PNG");
		s.wait(skipadds,6000);
		s.click();
		
		Pattern pause=new Pattern("pause.PNG");
		s.wait(pause,7000);
		s.click();
		s.click();
		
		Pattern play=new Pattern("play.PNG");
		s.wait(play,2000);
		s.click();
		s.click();
		
		Pattern volume=new Pattern("volume.PNG");
		s.wait(volume,1000);
		s.click();
		s.click();
		
		Pattern settings=new Pattern("settings.PNG");
		s.wait(settings,1000);
		s.click();
		s.click();
		
		driver.quit();
	}

}
