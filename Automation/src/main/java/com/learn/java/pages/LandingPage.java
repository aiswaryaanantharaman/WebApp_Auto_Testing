package com.learn.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.learn.java.base.TestBase;

public class LandingPage extends TestBase{

	public static WebElement element;
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}

	//web element locator methods
	public static WebElement pageHeader() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='app']//img"));
		} catch (Exception e) {
			System.out.println("Unable to locate element : pageHeader");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement elementsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
		} catch (Exception e) {
			System.out.println("Unable to locate elements card.");
			e.printStackTrace();
		}		
		return element;
	}
	
	public WebElement formsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Forms')]"));
		} catch (Exception e) {
			System.out.println("Unable to locate forms card.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement alertsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Alerts')]"));
		} catch (Exception e) {
			System.out.println("Unable to locate alerts card.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement widgetsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
		} catch (Exception e) {
			System.out.println("Unable to locate widgets card.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement interactionsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Interactions')]"));
		} catch (Exception e) {
			System.out.println("Unable to locate interactions card.");
			e.printStackTrace();
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
		return status;
	}
}
