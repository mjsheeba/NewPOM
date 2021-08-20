package com.qa.proj.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.proj.base.BasePageTest;
import com.qa.proj.utils.Constants;

public class LoginPageTest extends BasePageTest {
	
	@BeforeMethod
	public void LoginPageTestSetUp() {	
		System.out.println("LoginPageTestSetUp()");
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=2)	
	public void verifyLoginPageTiltleTest() {
	 //need url,browserinfo,uname,password,driver
		System.out.println("@Test called");
		String title= loginPage.loginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);	
	}
	@Test(priority=3)	
	public void verifyDesktopMenu() {
	 
		System.out.println("@Test verifyMenuDesktop called");
		String desktopMenu= loginPage.desktopMenu();
		Assert.assertEquals(desktopMenu, Constants.LOGIN_PAGE_MENU1);
		
	}
	  @AfterMethod
	 public void LogoutPageTestSetUp() 
	  {

	  logoutPage = loginPage.doLogout(); 
	  logoutPage.clickLoginLink();
	  }
	 
}
