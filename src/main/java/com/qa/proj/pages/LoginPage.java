package com.qa.proj.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.proj.base.BasePage;

public class LoginPage extends BasePage{
	
	public WebDriver driver;
	
	private By desktopMenu = By.xpath("//li[@class=\"dropdown\"]/a[text()='Desktops']");
	private By uname=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn= By.xpath("//input[@value='Login']");
	private By logoutBtn=By.xpath("//ul[contains(@class,'dropdown-menu-right')]//a[text()='Logout']");
	private By myAccountBtn= By.xpath("//a[@title=\"My Account\"]");
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;		
	}
	
	public String loginPageTitle() {
		System.out.println("LoginPageTitle method called");
		String title;
		try {
			title = driver.getTitle();
			return title;
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return null;
		
	}
	
	public String desktopMenu() {
		//li[@class="dropdown"]/a[text()='Desktops']	
		return driver.findElement(desktopMenu).getText();	
	}
	
	public AccountsPage doLogin(String un,String pwd) {
		
		
		System.out.println("Login with : " + un + " and " + pwd);
		
		driver.findElement(uname).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AccountsPage(driver);
		
	}
	
	public LogoutPage doLogout() {
		driver.findElement(myAccountBtn).click();
		driver.findElement(logoutBtn).click();
		return new LogoutPage(driver);
		
	}

}
