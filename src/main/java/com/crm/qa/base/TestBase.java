package com.crm.qa.base;

import java.io.FileInputStream;

import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	@SuppressWarnings("deprecation")
	public  static EventFiringWebDriver e_driver;
	
	public TestBase() {
		prop=new Properties();
		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Users\\Veerakumar\\eclipse-workspace\\TestCheck\\src\\main\\java\\com\\crm\\qa\\config\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver","D:\\Selenium_jar&servers\\LIB\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
			e_driver=new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
			
			driver.get(prop.getProperty("url"));
			
		}
				
		
		
		
		
		
	
}
