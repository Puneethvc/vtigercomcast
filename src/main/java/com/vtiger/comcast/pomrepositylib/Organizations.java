package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgImg;
	
	@FindBy(xpath = "//body[@onload='set_focus()']")
	private WebElement searchLnk;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement clcikOrgName;
	
	
	public WebElement getSearchLnk() {
		return searchLnk;
	}


	public WebElement getClcikOrgName() {
		return clcikOrgName;
	}


	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	
	}