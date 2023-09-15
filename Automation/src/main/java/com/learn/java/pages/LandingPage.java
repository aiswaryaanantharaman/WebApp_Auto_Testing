package com.learn.java.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.learn.java.base.TestBase;

public class LandingPage extends TestBase{

	public static WebElement element;
	private static final Logger logger = LogManager.getLogger(LandingPage.class);
	
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
			logger.error("Unable to locate element : pageHeader");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement elementsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Elements')]"));
		} catch (Exception e) {
			logger.error("Unable to locate elements card.");
			e.printStackTrace();
		}		
		return element;
	}
	
	public WebElement formsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Forms')]"));
		} catch (Exception e) {
			logger.error("Unable to locate forms card.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement alertsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Alerts')]"));
		} catch (Exception e) {
			logger.error("Unable to locate alerts card.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement widgetsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Widgets')]"));
		} catch (Exception e) {
			logger.error("Unable to locate widgets card.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement interactionsCard() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//h5[contains(text(), 'Interactions')]"));
		} catch (Exception e) {
			logger.error("Unable to locate interactions card.");
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
			logger.info("Verified navigation to landing page");
		}
		else
		{
			status = false;
			logger.error("Unable to verify navigation to landing page");
		}
		return status;
	}
}
