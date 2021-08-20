package com.qa.proj.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.proj.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public Properties prop;
	public WebDriver driver;
	public OptionsManager optionsManager;
	public static String highlight;
	public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<WebDriver>();
	
	public Properties init_prop() {
		
		System.out.println("BasePage init_prop");
		 prop= new Properties();
		try {

        FileInputStream ip= new FileInputStream("./src/main/java/com/qa/proj/conf/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("BasePage init_driver");
		if(browser.equalsIgnoreCase("chrome")) {			
			WebDriverManager.chromedriver().setup();		
			//driver= new ChromeDriver();
			tldriver.set(new ChromeDriver());
			
		}		
		else if(browser.equalsIgnoreCase("firefox")) {			
			WebDriverManager.firefoxdriver().setup();			
			//driver = new FirefoxDriver();
			tldriver.set(new ChromeDriver());
		}		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
