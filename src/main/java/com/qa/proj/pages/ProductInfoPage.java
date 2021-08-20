	package com.qa.proj.pages;
	
	import java.time.Duration;
import java.util.ArrayList;
	import java.util.List;
	
	import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.proj.base.BasePage;
	
	public class ProductInfoPage extends BasePage{
	
		public WebDriver driver;
		private AccountsPage accountsPage;
		private ProductCategoryPage productCategoryPage;
		
		private By selectProduct=By.xpath("//div[@class='product-thumb']//h4/a");	
		private By shoppingCartLink= By.partialLinkText("shopping cart");
		
		public ProductInfoPage(WebDriver driver)
		{
			this.driver = driver;
			accountsPage= new AccountsPage(this.driver);
			productCategoryPage= new ProductCategoryPage(this.driver);
		}
		
		public void selectProduct(String productName)
		{
			driver.findElement(selectProduct).click();	
			
			
			WebDriverWait wait1= new WebDriverWait(driver,15);
			//wait.until(ExpectedConditions.);
			
			
			//Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(null).
			
			
//			.withTimeout(Duration.ofSeconds(15)
//			.pollingevery(Duration.ofSeconds(3))
//			.ignoring(NoSuchElementException.class);


			
		}
		
		public ShoppingCart openShoppingCartThroughLink(String productName)
		{
			accountsPage.doSearch(productName);
			productCategoryPage.addToCart(productName);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(shoppingCartLink).click();
			return new ShoppingCart(driver);
		}
		

		
	}
