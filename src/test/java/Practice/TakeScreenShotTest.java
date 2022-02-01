package Practice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.annotations.Test;

import com.vtiger.comcast.generalUtility.BaseClass;
@Test
public class TakeScreenShotTest extends BaseClass{
	
	public void TakescreenshotofHomePage(Method mtd) throws IOException
	{
		System.out.println(mtd.getName());
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://localhost:8888");
			// take screen shot and store
		 String currentTestName=mtd.getName();
		 System.out.println("====start test====");
		 
			
			EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
			File srcFile = edriver.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./ScreenShots/"+currentTestName+".png");
			FileUtils.copyFile(srcFile, destFile);
			
			System.out.println("=====test ends =======");
	}

}
