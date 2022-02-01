package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.vtiger.comcast.generalUtility.WebDriverUtility;

public class CreateNewOrganization extends WebDriverUtility {

	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDpd;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	public WebElement getIndustryDpd() {
		return industryDpd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

public void createOrg(String orgName) {
orgNameEdt.sendKeys(orgName);
saveBtn.click();
}
public void createdropd(String orgName) {
	orgNameEdt.sendKeys(orgName);
 WebDriverUtility wLib = new WebDriverUtility();
			wLib.select(industryDpd, "Banking");
	saveBtn.click();

}
	
	
	
	
	
	
	
	
	
	
	
	

}