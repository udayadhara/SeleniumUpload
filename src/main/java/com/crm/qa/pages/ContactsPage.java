package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[@href='/contacts']/following-sibling::button")

	WebElement addBtn;
	@FindBy(xpath="//label[text()='First Name']/following-sibling::div")
	WebElement firstName;
	@FindBy(xpath="//label[text()='Last Name']/following-sibling::div")
	WebElement lastName;
	@FindBy(xpath="//i[@class='save icon']")
	WebElement saveBtn;
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	public void clickOnNewContactLink() throws InterruptedException {
		Actions action= new Actions(driver);
		action.moveToElement(addBtn).click().build().perform();
		Thread.sleep(5000);
	}
	public void addContacts(String firstName1, String lastName1, String company) {
		
		Actions action= new Actions(driver);
		action.moveToElement(firstName);
		action.click();
		action.sendKeys(firstName1);
		action.build().perform();
		action.moveToElement(lastName);
		action.click();
		action.sendKeys(lastName1);
		action.build().perform();
		saveBtn.click();
		
	}
	
}
