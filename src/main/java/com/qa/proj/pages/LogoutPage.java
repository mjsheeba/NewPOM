package com.qa.proj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.proj.base.BasePage;

public class LogoutPage extends BasePage 
{

	public WebDriver driver;
	
	//By loginLink= By.xpath("//div[@class='list-group']/a[text()='Login']");
	private By myAccountBtn= By.xpath("//a[@title=\"My Account\"]");
	private By loginBtn=By.xpath("//li/a[text()='Login']");
	
	public LogoutPage(WebDriver driver) {
		
		this.driver=driver;		
	}

	
   public LoginPage clickLoginLink() 
    {
	   driver.findElement(myAccountBtn).click();
	   driver.findElement(loginBtn).click();
	   
		return new LoginPage(driver);
		
	 }
	
}
