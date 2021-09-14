package com.qa.proj.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.qa.proj.base.BasePageTest;

public class ShoppingCartPageTest extends BasePageTest{
	
	@BeforeMethod
	public void ShoppingCartPageTestSetUp() {	
		System.out.println("ShoppingCartPageTestSetUp()");
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	@Test
	public void verifyCheckOut() {
		
		 SoftAssert softAssertion= new SoftAssert();	 
		 productCategoryPage = accountsPage.doSearch("iMac");	 
		 productCategoryPage.addToCart("iMac");
		 shoppingCart=productCategoryPage.openShoppingCartThroughLink("iMac8");	
		softAssertion.assertEquals(shoppingCart.shoppingCartText(),"Shopping Cart 123");
		//Assert.assertEquals(shoppingCart.shoppingCartText(),"Shopping Cart");
		 shoppingCart.clearShoppingCart();
	}
	
	
	  @AfterMethod
	  public void LogoutPageTestSetUp() 
	  {
	  logoutPage = loginPage.doLogout(); 
	  logoutPage.clickLoginLink();
	  }

}
