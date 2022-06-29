package com.crm.qa.testcases;
import org.testng.annotations.*;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@DataProvider
	public Object[][] getCRMData(){
		
		Object data[][]=TestUtil.getTestData("contacts");
		
		return data;
		
	}
	
	@Test(priority=1, dataProvider="getCRMData")
	public void validateAddContacts(String firstName, String lastName, String company) throws InterruptedException{
		contactsPage=homePage.goToContactsLink();
		contactsPage.clickOnNewContactLink();
		contactsPage.addContacts(firstName,lastName,company);
	
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
