package com.learn.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.learn.java.base.TestBase;

public class LandingPage extends TestBase{

	public static WebElement element;
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public static WebElement pageHeader() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='app']//img"));
		} catch (Exception e) {
			System.out.println("Unable to locate element : pageHeader");
		}		
		return element;
	}
	
	public Boolean verifyLandingPage() throws Exception
	{
		Boolean status = null;
		if(pageHeader().isDisplayed())
		{
			status = true;
		}
		else
		{
			status = false;
		}
		System.out.println(status);
		return status;
	}
}
