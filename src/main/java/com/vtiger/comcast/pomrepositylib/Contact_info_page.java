package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_info_page {
	public Contact_info_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement Oraname;

	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
	}

	public WebElement getOraname() {
		return Oraname;
	}
	
	
	

}