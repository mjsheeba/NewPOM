package com.qa.proj.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.proj.base.BasePageTest;
import com.qa.proj.utils.Constants;

public class AccountsPageTest extends BasePageTest
{

	@BeforeMethod
	public void AccountsPageTestSetUp()
	{	
		System.out.println("AccountsPageTestSetUp()...");
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	  @Test public void verifylistofSections()
	  {
		  System.out.println("verifylistofSections()...");
		  Assert.assertEquals(accountsPage.listofSectionHeader(),
		  Constants.getAccountsPageSectionsHeaderList());
		  System.out.println(accountsPage.listofSectionHeader()); 
	  }
		 
		
	@Test(priority=1)
	public void verifylistofsubSections()
	{
		System.out.println("verifylistofsubSections()...");
		Assert.assertEquals(accountsPage.subSectionsHeaders(),Constants.getsubsectionsList() );	
	}
	
	
	  @Test(priority=2)
	  public void verifyNewsletterSubscription()
	  {
		  System.out.println("verifyNewsletterSubscription()...");
		  Assert.assertTrue(accountsPage.selectNewsletterSubscription(true), "Newsletter Subscription :Yes ");
		  Assert.assertFalse(accountsPage.selectNewsletterSubscription(false), "Newsletter Subscription :False ");
	  }
		
		  @AfterMethod	  
	public void LogoutPageTestSetUp() 
		  {
		  logoutPage = loginPage.doLogout(); 
		  logoutPage.clickLoginLink();
		  }
		 
}