package com.qa.proj.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;

public class Constants {

	public static final String LOGIN_PAGE_TITLE = "My Account";
	 
	public static final String LOGIN_PAGE_MENU1= "Desktops";
	
	public static List<String> getAccountsPageSectionsHeaderList() 
	{
		List<String> accountsList = new ArrayList<String>();
		accountsList.add("My Account");
		accountsList.add("My Orders");
		accountsList.add("My Affiliate Account");
		accountsList.add("Newsletter");
		return accountsList;
	}
	
	public static List<ArrayList<String>> getsubsectionsList()
	{
		List<ArrayList<String>> subsectionsName= new ArrayList<ArrayList<String>>();
		//[[Edit your account information, Change your password,Modify your address book entries, Modify your wish list],
		//[View your order history, Downloads, Your Reward Points, View your return requests, Your Transactions, Recurring payments],
		//[Register for an affiliate account], 
		//[Subscribe / unsubscribe to newsletter]]
		
		ArrayList<String> MyAccount = new ArrayList<String>();
		MyAccount.addAll(Arrays.asList("Edit your account information", "Change your password","Modify your address book entries", "Modify your wish list"));

		ArrayList<String> MyOrders = new ArrayList<String>();
		MyOrders.addAll(Arrays.asList("View your order history", "Downloads", "Your Reward Points", "View your return requests", "Your Transactions", "Recurring payments"));
		
		ArrayList<String> MyAffiliateAccount = new ArrayList<String>();
		MyAffiliateAccount.addAll(Arrays.asList("Register for an affiliate account"));
		
		ArrayList<String> Newsletter = new ArrayList<String>();
		Newsletter.addAll(Arrays.asList("Subscribe / unsubscribe to newsletter"));
		
		subsectionsName.add(0,MyAccount);
		subsectionsName.add(1,MyOrders);
		subsectionsName.add(2,MyAffiliateAccount);
		subsectionsName.add(3,Newsletter);
		
		System.out.println(subsectionsName);
		return subsectionsName;
		
		
	}
	
	public static List<String> getProductCategorySortByDropdown() 
	{
		List<String> sortByDropdownList = new ArrayList<String>();

		sortByDropdownList.add("Default");
		sortByDropdownList.add("Name (A - Z)");
		sortByDropdownList.add("Name (Z - A)");
		sortByDropdownList.add("Price (Low > High)");
		sortByDropdownList.add("Price (High > Low)");
		sortByDropdownList.add("Rating (Highest)");
		sortByDropdownList.add("Rating (Lowest)");
		sortByDropdownList.add("Model (A - Z)");
		sortByDropdownList.add("Model (Z - A)");
		
		return sortByDropdownList;
	}
	
}
