package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.generalUtility.BaseClass;



public class RetryTest extends BaseClass 
{

		@Test(retryAnalyzer=com.vtiger.comcast.generalUtility.RetryImpClass.class)
		public void AmazonTest()
		{
			Assert.assertEquals("A", "B");
		}
}
