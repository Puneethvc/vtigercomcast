package com.vtiger.comcast.generalUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

		public class BaseClass {
			
	
			// create the object of gneric lib
			public JavaUtility jLib = new JavaUtility();
			public WebDriverUtility wLib = new WebDriverUtility();
			public FileUtility fLib = new FileUtility();
			public ExcelUtility eLib = new ExcelUtility();
			public WebDriver driver = null;
			public static WebDriver sdriver = null;
			
			@BeforeSuite(groups = {"smokeTest","regressionTest"})
			public void configBs() {
				System.out.println("=======**conncet to DB**=======");
			}
			//@Parameters("browser")
			@BeforeClass(groups = {"smokeTest","regressionTest"})
			public void configBC() throws Throwable {
				System.out.println("=======**Launch the Browser**======");
		
			String BROWSER = fLib.getPropertyKeyValue("browser");
			//step 1 :Launch the browser 
			
			if(BROWSER.equals("firefox"))
			{
			driver = new FirefoxDriver();
			}
			else if(BROWSER.equals("chrome"))
			{
			 driver = new ChromeDriver();
			}
			else if(BROWSER.equals("ie")) 
			{
				driver = new InternetExplorerDriver();
			}
			
			}
		@BeforeMethod(groups = {"smokeTest","regressionTest"})
			public void configBM() throws Throwable {
				/*common Data*/
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			
			String BROWSER = fLib.getPropertyKeyValue("browser");
			
			/* Navigate to app*/
			wLib.waitUntilPageLoad(driver);
			driver.get(URL);
			 
			driver.manage().window().maximize();
			
			/* step 1 : login */
		     Login loginPage = new Login(driver);
		     loginPage.loginToApp(USERNAME, PASSWORD);
		}


			@AfterMethod(groups = {"smokeTest","regressionTest"})
			public void configAM() {
				
			/*step 6 : logout*/
			Home homePage = new Home(driver);
		    homePage.logout();
			}
			
			@AfterClass(groups = {"smokeTest","regressionTest"})
			public void configAC() {
				System.out.println("=====**Close the Browser**=====");
				driver.quit();
			}
			
			@AfterSuite(groups = {"smokeTest","regressionTest"})
			public void configAS() {
				System.out.println("=======**close DB**=======");
			}
		}

			
			


