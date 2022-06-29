package com.crm.qa.testcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase{

LoginPage loginPage;
HomePage homePage;
ContactsPage contactsPage;
	public HomePageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyTitle() {
		String title=homePage.getTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void goToContactsPage() {
		contactsPage=homePage.goToContactsLink();
		System.out.println(driver.findElement(By.xpath("//a[text()='abc John']")).isDisplayed());
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
