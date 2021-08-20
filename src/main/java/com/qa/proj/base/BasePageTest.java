package com.qa.proj.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.proj.pages.AccountsPage;
import com.qa.proj.pages.LoginPage;
import com.qa.proj.pages.LogoutPage;
import com.qa.proj.pages.ProductCategoryPage;
import com.qa.proj.pages.ProductInfoPage;
import com.qa.proj.pages.AccountsPage;
import com.qa.proj.pages.ShoppingCart;

public class BasePageTest {
	
	public BasePage basePage;
	public Properties prop;
	public WebDriver driver;
	public LoginPage loginPage;
	public ProductInfoPage prodInfo;
	public AccountsPage accountsPage;
	public ShoppingCart shoppingCart;
	public LogoutPage logoutPage;
	public ProductCategoryPage productCategoryPage;

	
	
	@BeforeClass
	public void SetUp()
	{
		
		System.out.println("SetUp()...");
		//1. Load Properties
		
		basePage= new BasePage();
		prop =basePage.init_prop();
		
		System.out.println(prop.getProperty("username")+"  " +prop.getProperty("password"));
		//2. init_driver to set driver with the browser
		driver=basePage.init_driver(prop.getProperty("browser"));
	
		//3.login page set with driver
		loginPage= new LoginPage(driver);
		
		//4. first place to url
		System.out.println(prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
	
	}
	
	@AfterClass
	public void TearDown()
	{	
		driver.quit();
	}

}
