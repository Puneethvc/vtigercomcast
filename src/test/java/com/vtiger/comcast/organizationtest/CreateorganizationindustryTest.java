package com.vtiger.comcast.organizationtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vtiger.comcast.generalUtility.ExcelUtility;
import com.vtiger.comcast.generalUtility.FileUtility;
import com.vtiger.comcast.generalUtility.JavaUtility;
import com.vtiger.comcast.generalUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizations;

public class CreateorganizationindustryTest {
	public static void main(String[] args) throws Throwable  {
		
		  // Object Creation for Lib
		   JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			FileUtility fLib = new FileUtility();
			ExcelUtility eLib = new ExcelUtility();
			WebDriver driver = null;
			int randomInt = jLib.getRandomNumber();
			
			/* Read common Data*/
			String USERNAME = fLib.getPropertyKeyValue("username");
			String PASSWORD = fLib.getPropertyKeyValue("password");
			String URL = fLib.getPropertyKeyValue("url");
			String BROWSER = fLib.getPropertyKeyValue("browser");
			
			/* Read test script Data */
			String orgName = eLib.getDataFromExcel("org", 1, 2) + "-"+randomInt;
			
			/* Launch the browser */
			if(BROWSER.equals("Firefox")) {
				driver = new FirefoxDriver();
			}else if(BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			}else if(BROWSER.equals("ie")) {
				driver = new InternetExplorerDriver();
			}else {
				driver = new ChromeDriver();
			}
	        
	        /* step 1 : login */
			driver.get(URL);
	        Login loginPage = new Login(driver);
	        loginPage.loginToApp(USERNAME, PASSWORD);
	        
	        /* step 2 : navigate to organization */
	        Home homePage = new Home(driver);
	        homePage.getOrganizationLnk().click();
	        
	        /*step 3 : navigate to "create new organization"page by click on "+" image */
	        Organizations orgPage = new Organizations(driver);
	        orgPage.getCreateOrgImg().click();
	        
	        CreateNewOrganization cno = new CreateNewOrganization(driver);
	        cno.createdropd(orgName);
	      
	        /* step 4 : verify the successful msg with org name */
	        OrganizationInfo oinfop = new OrganizationInfo(driver);
	        wLib.waitForElementVisibility(driver, oinfop.getSuccesfulMsg());
	        String  actSuccesfullMg =  oinfop.getSuccesfulMsg().getText();
	        System.out.println(actSuccesfullMg);
	        
	        if(actSuccesfullMg.contains(orgName)) {
	        	System.out.println(orgName + "==>industry is verified successfully");
	        }else {
	        	System.out.println(orgName + "==> industry is not verified successfully");

	        }
	       /* step 5 : logout */
	        homePage.logout();
	        /* step 6 : close */
	        driver.close();
		}


}