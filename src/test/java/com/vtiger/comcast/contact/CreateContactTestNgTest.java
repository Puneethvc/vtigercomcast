package com.vtiger.comcast.contact;

import static org.testng.Assert.assertTrue;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.comcast.generalUtility.BaseClass;
import com.vtiger.comcast.pomrepositylib.Contact_info_page;
import com.vtiger.comcast.pomrepositylib.Contact_page;
import com.vtiger.comcast.pomrepositylib.CreateNewOrganization;
import com.vtiger.comcast.pomrepositylib.Create_new_Contact_page;
import com.vtiger.comcast.pomrepositylib.Home;
import com.vtiger.comcast.pomrepositylib.OrganizationInfo;
import com.vtiger.comcast.pomrepositylib.Organizations;

		public class CreateContactTestNgTest extends BaseClass {
			@Test(groups = "smokeTest")
		public void CreatecontactTest() throws Throwable, Throwable {
	
		// test data
		int randomInt = jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("sheet2", 4, 3) + "-"+randomInt;
		
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
	    assertTrue(act_msg.contains(act_msg));
	}

			@Test(groups ="regressionTest")
			public void CreatecontacwithtOrganizationTest() throws Throwable, Throwable {
				
			// test data
			int randomInt = jLib.getRandomNumber();
			String orgName = eLib.getDataFromExcel("sheet2", 4, 3) + "-"+randomInt;
			String conName = eLib.getDataFromExcel("sheet2", 4, 1);
			
			// navigate to contact
			Home homePage = new Home(driver);
		    homePage.getOrganizationLnk().click();
		    
		    //step 4 navigate to organiztion page
			Organizations org = new Organizations(driver);
			org.getCreateOrgImg().click();
			
			// cteate the new organization
			CreateNewOrganization corg =new CreateNewOrganization(driver);
			corg.createOrg(orgName);
			//corg.getSaveBtn().click();
			
			// navigate to contact
			  
	        /* step 4 : verify the successful msg with org name */
	        OrganizationInfo oinfop = new OrganizationInfo(driver);
	        wLib.waitForElementVisibility(driver, oinfop.getSuccesfulMsg());
	        String  actSuccesfullMg =  oinfop.getSuccesfulMsg().getText();
	        System.out.println(actSuccesfullMg);
	        
	        // create the conatact
	        homePage.getContactsLnk().click();
			
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
			Assert.assertEquals(actName, orgName);

			String actname = cinfo.getOraname().getText();
			assertTrue(actname.contains(actname));
			}
}
			
