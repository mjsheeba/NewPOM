package com.qa.proj.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.proj.base.BasePageTest;
import com.qa.proj.utils.Constants;

public class ProductCategoryPageTest extends BasePageTest{

	
	@BeforeMethod
	public void ProductCategoryPageTestSetUp()
	{	
		System.out.println("ProductCategoryPageTestSetUp()");
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifylistofSortByDropdown()
	{
		productCategoryPage=accountsPage.selectMenu("Monitors");
		
		Assert.assertEquals(productCategoryPage.listofSortByDropdown(),Constants.getProductCategorySortByDropdown());
	}
	
	
	  @AfterMethod
	  
	  public void LogoutPageTestSetUp() 
	  {
	 
	  logoutPage = loginPage.doLogout(); 
	  logoutPage.clickLoginLink();
	  }
	
}
