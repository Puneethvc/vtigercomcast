package com.vtiger.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contact_page {
	WebDriver diver;
	public Contact_page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement createIcon;

public WebDriver getDiver() {
	return diver;
}
public WebElement getCreateIcon() {
	return createIcon;
}


}