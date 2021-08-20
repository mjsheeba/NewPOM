package com.qa.proj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.proj.base.BasePage;

public class ShoppingCart extends BasePage{
	
	public WebDriver driver;
	By shoppingCartText=By.xpath("//div[@id='content']/h1");
	By shoppingCartBtn= By.xpath("//div[@id=\"cart\"]/button[@type=\"button\"]");
	
	By removeProduct= By.xpath("//table[contains(@class,\"table-striped\")]//button[contains(@class,\"btn-danger\")]");
	public ShoppingCart(WebDriver driver) {
		System.out.println("CheckOut constructor");
		this.driver=driver;		
	}
	
	public String shoppingCartText() {
		return driver.findElement(shoppingCartText).getText();
	}
	public void ProductInShoppingCart(String ProductName) {
			
		
	}
	
	public void clearShoppingCart() {
		driver.findElement(shoppingCartBtn).click();
		driver.findElement(removeProduct).click();
		
		
	}
}
