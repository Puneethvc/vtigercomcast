package Practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.vtiger.comcast.generalUtility.BaseClass;



public class ListenersTest implements ITestListener
{
	@Test
	public void onTestFailure(ITestResult result)
	{
		String testName = result.getMethod().getMethodName();
		System.out.println("execute & listener is listening");
		
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyDirectory(srcFile, new File("./ScreenShots/"+testName+".png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
