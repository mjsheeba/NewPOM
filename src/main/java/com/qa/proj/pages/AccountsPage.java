	package com.qa.proj.pages;
	
	import java.util.ArrayList;
	import java.util.List;
	
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.proj.base.BasePage;
	import com.qa.proj.utils.Constants;
	
	public class AccountsPage extends BasePage {
		private WebDriver driver;
	
		By sectionList=By.xpath("//div[@id='content']/h2");
		By searchBox=By.name("search");
		By searchBtn=By.xpath("//span[@class='input-group-btn']/button");
		By mainmenuItem = By.xpath("//ul[contains(@class,'navbar-nav')]/li");
		By selectsubmenuItem = By.xpath("//ul[contains(@class,'navbar-nav')]//a");
		By selectNewsletterLink= By.xpath("//div[@class=\"list-group\"]/a[contains(text(),'Newsletter')]");
		By selectNewsletterYes=By.xpath("//label[@class=\"radio-inline\"]/input[@type='radio' and @value='1']");
		By selectNewsletterNo=By.xpath("//label[@class=\"radio-inline\"]/input[@type='radio' and @value='0']");
		//a[@class='dropdown-toggle']
	
		//By shoppingCartLink=By.xpath("//div[@id='product-search']//a[@contains[text(),'shopping cart']]");
	
		By shoppingCartLink= By.partialLinkText("shopping cart");
		
		public AccountsPage(WebDriver driver) {
	
			this.driver=driver;
		}
	
	public ProductCategoryPage doSearch(String productName) {
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(searchBtn).click();
		return new ProductCategoryPage(driver);
	}
	
	public List<String> listofSectionHeader() {
		
		List<WebElement> sectionElementList= driver.findElements(sectionList);
		List<String> sectionsName= new ArrayList<String>();
		
		for (WebElement sectionElement : sectionElementList) {
			sectionsName.add(sectionElement.getText());	
		}
		return sectionsName;
	}
	
	public List<ArrayList<String>> subSectionsHeaders() 
	{
		List<WebElement> list= driver.findElements(sectionList);
		List<ArrayList<String>> subsectionsName= new ArrayList<ArrayList<String>>();
		
		int i =0;
		int size=0;
		int j;
		for (WebElement ele : list) 
		{	
			String str1=ele.getText().trim();
			String str2=Constants.getAccountsPageSectionsHeaderList().get(i).trim();
			
			if (str1.equals(str2)) 
			{
				size = driver.findElements(By.xpath("//div[@id='content']/ul["+(i+1)+"]/li")).size();
				ArrayList<String> eachSubSectionList = new ArrayList<String>();
				for (j=1; j<=size;j++) 
				{
					eachSubSectionList.add(driver.findElement(By.xpath("//div[@id='content']/ul["+(i+1)+"]/li["+j+"]/a")).getText());
				} 
				subsectionsName.add(i, eachSubSectionList);
			}
			j=1;    
		    i++;
		}
	
		System.out.println(subsectionsName);
		
		return subsectionsName;
	}
	
	public ProductCategoryPage selectMenu(String menuItemToSelect) 
	
	{
		List<WebElement> mainmenuItemList= driver.findElements(mainmenuItem);
		List<WebElement> subEleList= driver.findElements(selectsubmenuItem);
		Actions action = new Actions(driver);
		
		for (WebElement mainmenuItem : mainmenuItemList)
		{
			action.moveToElement(mainmenuItem).build().perform();
			
			if (mainmenuItem.getAttribute("class").contains("dropdown"))
			{		
				for (WebElement subMenuItem : subEleList) 
				{
					if (subMenuItem.getText().contains(menuItemToSelect))
					{	
							subMenuItem.click();
							return new ProductCategoryPage(driver);
					}						
				}
			}
			
			else
			{
					if (mainmenuItem.getText().contains(menuItemToSelect))
					{
						    mainmenuItem.click();
							System.out.println(mainmenuItem.getText());
							return new ProductCategoryPage(driver);
				    }
				continue;   
			}
		}
		return new ProductCategoryPage(driver);
	}
	
	public boolean selectNewsletterSubscription(boolean option)
	{
		
		driver.findElement(selectNewsletterLink).click();
		
		if (option)
		{
			driver.findElement(selectNewsletterYes).click();
			return true;
		}
		else
		{
			driver.findElement(selectNewsletterNo).click();
			return false;
		}
		
	}
	
	
	}
