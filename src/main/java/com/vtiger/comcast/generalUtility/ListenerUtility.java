package com.vtiger.comcast.generalUtility;
	import java.io.File;
	import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.support.events.EventFiringWebDriver;
	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;
	import com.vtiger.comcast.generalUtility.BaseClass;



	public class ListenerUtility implements ITestListener
	{
		ExtentReports report;
		ExtentTest test;
		public void onStart(ITestContext context)
		{
			//@Beforesuite
			ExtentSparkReporter spark = new ExtentSparkReporter("./extentreport.html");
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("vtiger automation");
			spark.config().setReportName("Execution Report");
			
			ExtentReports report = new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("os", "window");
			report.setSystemInfo("platform", "windowa 10");
			report.setSystemInfo("reporter", "puneeth vc");
		}
		public void onFinish(ITestContext context) {
			//@AfterSuite
			report.flush();
		}
		
		public void onTestStart(ITestResult result) {
			//@Test
			test=report.createTest(result.getMethod().getMethodName());
			
		}
		public void onTestSuccess(ITestResult result) {
			test.log(Status.PASS, result.getMethod().getMethodName()+" is pass");
			
		}
		public void onTestSkipped(ITestResult result) {
			test.log(Status.FAIL, result.getMethod().getMethodName()+"is skipped");
			
		}
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		}
		public void onTestFailedWithTimeout(ITestResult result) {
		}
		@Test
		public void onTestFailure(ITestResult result)
		{
			String failedtestName = result.getMethod().getMethodName();
			System.out.println("execute & listener is listening");
			
			EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
			File srcFile = edriver.getScreenshotAs(OutputType.FILE);
			 String systemDate = new Date().toString().replace(":", "_").replace(" ","_");
			 File target = new File("./ScreenShot" + failedtestName + "_"+systemDate+".png");
			
			try {
				FileUtils.copyDirectory(srcFile, new File("./ScreenShots/"+failedtestName+".png"));
			}catch (IOException e) {
				e.printStackTrace();
			}
			test.log(Status.FAIL, result.getMethod().getMethodName()+"is failed");
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(target.getAbsolutePath());
		}
		

}
