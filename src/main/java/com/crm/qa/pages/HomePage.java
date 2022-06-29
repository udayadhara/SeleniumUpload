package com.crm.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage goToContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	
}
