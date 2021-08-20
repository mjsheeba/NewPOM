package com.qa.proj.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.proj.base.BasePage;

public class ProductCategoryPage extends BasePage{

	public WebDriver driver;
	private AccountsPage accountsPage;
	
	private By resultItems = By.cssSelector(".product-thumb h4 a");
	private By addToCartBtn= By.xpath("//div[@class='button-group']/button[@type=\"button\"][position()=1]");
	private By shoppingCartLink= By.partialLinkText("shopping cart");
	private By listofSortByDropdownBtn= By.xpath("//select[@id='input-sort']/option");
	
	public ProductCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		//accountsPage= new AccountsPage(this.driver);
	}
	
	
	public void addToCart(String productName)
	{
		driver.findElement(addToCartBtn).click();
	}
	
	public ShoppingCart openShoppingCartThroughLink(String productName)
	{
		//accountsPage.doSearch(productName);
		//addToCart(productName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(shoppingCartLink).click();
		return new ShoppingCart(driver);
	}
	
	
	public  ProductInfoPage selectProductFromResults(String productName) 
	{
		List<WebElement> resultItemList = driver.findElements(resultItems);
		System.out.println("total number of items displayed: " + resultItemList.size());

		for (WebElement e : resultItemList) {
			if (e.getText().equals(productName)) {
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	
	
	
	public List<String> listofSortByDropdown()
	{
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> eleList= new ArrayList<WebElement>();
		List<String> list= new ArrayList<>();
		
		try 
		{
			eleList= driver.findElements(listofSortByDropdownBtn);
		}
		catch (Exception e) 
		{
			System.out.println("SortByDropDown not found");
		}
		
		for (WebElement ele : eleList)
		{
			list.add(ele.getText());
		}
		return list;
	}
	
}

