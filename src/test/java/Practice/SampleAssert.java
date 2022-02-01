package Practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.generalUtility.BaseClass;

public class SampleAssert extends BaseClass {
	@Test
	
	public void VeifyHomePage()
	{
		System.out.println("===========Test Starts ==========");
		String expectedResult = "home".trim();
		System.out.println("capture home page");
		String actualResult = driver.getTitle().trim();
		Assert.assertEquals(actualResult, expectedResult);
		System.out.println("======Test end ==========");
	}
	
	@Test
	public void VerifyLogoInHomePage()
	{
		System.out.println("=======test start========");
		System.out.println("capture the logo");
		boolean actstatus = driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isDisplayed();
		Assert.assertTrue(actstatus);
		System.out.println("ends");
	}

}
