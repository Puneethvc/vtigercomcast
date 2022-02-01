package com.vtiger.comcast.contact;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vtiger.comcast.generalUtility.ExcelUtility;
import com.vtiger.comcast.generalUtility.FileUtility;
import com.vtiger.comcast.generalUtility.JavaUtility;
import com.vtiger.comcast.generalUtility.WebDriverUtility;
import com.vtiger.comcast.pomrepositylib.Contact_info_page;
import com.vtiger.comcast.pomrepositylib.Contact_page;
import com.vtiger.comcast.pomrepositylib.Create_new_Contact_page;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;

public class CreatecontactTest {
	public static void main(String[] args) throws Throwable {
		
	
	// create the object of gneric lib
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	// Read common Data
	String USERNAME = fLib.getPropertyKeyValue("username");
	String PASSWORD = fLib.getPropertyKeyValue("password");
	String URL = fLib.getPropertyKeyValue("url");
	String BROWSER = fLib.getPropertyKeyValue("browser");
	
	// test data
	int randomInt = jLib.getRandomNumber();
	String orgName = eLib.getDataFromExcel("sheet2", 4, 3) + "-"+randomInt;
	
	// step 1 :Launch the browser 
	WebDriver driver = null;
	if(BROWSER.equals("Firefox")) {
		driver = new FirefoxDriver();
	}else if(BROWSER.equals("chrome")) {
		driver = new ChromeDriver();
	}else if(BROWSER.equals("ie")) {
		driver = new InternetExplorerDriver();
	}else {
		driver = new ChromeDriver();
	}
	
	// login to app 
	driver.get(URL);
	wLib.waitUntilPageLoad(driver);
	Login ip = new Login(driver);
	ip.loginToApp(USERNAME, PASSWORD);
	
	// navigate to contact
	Home homePage = new Home(driver);
    homePage.getContactsLnk().click();
    
    // create the contact
    Contact_page cp = new Contact_page(driver);
    cp.getCreateIcon().click();
    
    // create new contact
    Create_new_Contact_page cncp = new Create_new_Contact_page(driver);
    cncp.getLastnameEdt().sendKeys(orgName);
    cncp.getSaveBtn().click();
    
    // verify the contact
    Contact_info_page cip = new Contact_info_page(driver);
    String act_msg = cip.getSuccesfullMsg().getText();
    System.out.println(act_msg);
    assertTrue(act_msg.contains(act_msg));
    
    // step : 7 logout
    homePage.logout();
    
    // close the browser
    driver.close();
    
    
    
    
	

}
}
