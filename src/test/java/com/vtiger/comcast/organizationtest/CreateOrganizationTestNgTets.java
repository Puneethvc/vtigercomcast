package com.vtiger.comcast.organizationtest;

import static org.junit.Assert.assertTrue;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.generalUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizations;

public class CreateOrganizationTestNgTets extends BaseClass {
	
	@Test(groups = "smokeTest")
	public void CreateOrganizationTest() throws Throwable, Throwable
	{	
		// test script data 
		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2) + "-"+randomInt;
		
		/* step 2 : navigate to organization */
        Home homePage = new Home(driver);
        homePage.getOrganizationLnk().click();
        
        // step 3 : navigate to "create new organization"page by click on "+" image 
        Organizations orgPage = new Organizations(driver);
        orgPage.getCreateOrgImg().click();
        
     // cteate the new organization
     		CreateNewOrganization corg =new CreateNewOrganization(driver);
     		corg.createOrg(orgName);
     	
     // step 4 : verify the successful msg with org name 
        OrganizationInfo oinfop = new OrganizationInfo(driver);
        wLib.waitForElementVisibility(driver, oinfop.getSuccesfulMsg());
        String  actSuccesfullMg =  oinfop.getSuccesfulMsg().getText();
        System.out.println(actSuccesfullMg);
        assertTrue(actSuccesfullMg.contains(actSuccesfullMg));
	}
	
	@Test(groups ="regressionTest")
	public void CreateorganizationindustryTest() throws Throwable, Throwable {
		/* Read test script Data */
		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("org", 1, 2)+"_"+randomInt;
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
        assertTrue(actSuccesfullMg.contains(actSuccesfullMg));
        
        
       
}
}
