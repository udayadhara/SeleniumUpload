package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//page factory or OR
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String username, String password) 
	{
	userName.sendKeys(username);
	pwd.sendKeys(password);
	loginBtn.click();
	return new HomePage();
		
	}
	
	
}
