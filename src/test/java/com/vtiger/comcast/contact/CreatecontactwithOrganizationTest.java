package com.vtiger.comcast.contact;

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
import com.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositylib.Create_new_Contact_page;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.Login;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizations;

public class CreatecontactwithOrganizationTest {

	public static void main(String[] args) throws Throwable {
		
		
		// create the object of gneric lib
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		
		/* Read common Data*/
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String URL = fLib.getPropertyKeyValue("url");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		// test data
		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("sheet2", 4, 3) + "-"+randomInt;
		String conName = eLib.getDataFromExcel("sheet2", 4, 1);
		
		// Launch the browser 
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
	    homePage.getOrganizationLnk().click();
	    
	    //step 4 navigate to organiztion page
		Organizations org = new Organizations(driver);
		org.getCreateOrgImg().click();
		
		// cteate the new organization
		CreateNewOrganization corg =new CreateNewOrganization(driver);
		corg.createOrg(orgName);
		corg.getSaveBtn().click();
		
        /* step 4 : verify the successful msg with org name */
        OrganizationInfo oinfop = new OrganizationInfo(driver);
        wLib.waitForElementVisibility(driver, oinfop.getSuccesfulMsg());
        String  actSuccesfullMg =  oinfop.getSuccesfulMsg().getText();
        System.out.println(actSuccesfullMg);
       
        homePage.getContactsLnk().click();
		
		// create the conatact
		Contact_page cp = new Contact_page(driver);
		cp.getCreateIcon().click();
		
		// create new contact
	    Create_new_Contact_page cncp = new Create_new_Contact_page(driver);
	    cncp.getLastnameEdt().sendKeys(orgName);
	    cncp.getSaveBtn().click();
	    
		//step 9 verify the contact
		Contact_info_page cinfo = new Contact_info_page(driver);
		String actName = cinfo.getSuccesfullMsg().getText();
		System.out.println(orgName);
		if(actName.contains(orgName))
		{
			System.out.println(orgName +"contact last name is verif=== passed");
			
		}else {
			System.out.println(orgName+"contact last nme is not verify === failed");
		}
		
		String actname = cinfo.getOraname().getText();
		if(actname.trim().equals(orgName)) {
			System.out.println(orgName+"is used to create con");
		}else {
			System.out.println(orgName+"is not create con");
		}
		//step 10 logout
		homePage.logout();
		
		//step 11 close 
		driver.close();
		
		
	}
	
}
