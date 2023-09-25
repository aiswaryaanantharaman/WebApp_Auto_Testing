package com.learn.java.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.learn.java.base.TestBase;
import com.learn.java.util.ExcelUtil;
import com.learn.java.util.TestUtil;

public class ElementsPage extends TestBase{

	public static WebElement element;
	TestUtil util = new TestUtil();
	ExcelUtil excelUtil = new ExcelUtil(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TestData.xlsx");
	private static final Logger logger = LogManager.getLogger(ElementsPage.class);
	
	public ElementsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement textBox() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//span[contains(text(), 'Text Box')]"));
		} catch (Exception e) {
			logger.error("Unable to locate text box option in side nav.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement fullnameField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='userName']"));
		} catch (Exception e) {
			logger.error("Unable to locate full name field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement emailField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath(" //*[@id='userEmail']"));
		} catch (Exception e) {
			logger.error("Unable to locate email field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement currentAddressField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath(" //*[@id='currentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate current address field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement permanentAddressField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate permanent address field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement submitBtn() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//button[@id='submit']"));
		} catch (Exception e) {
			logger.error("Unable to locate submit btn.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement recordOutput() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//div[@id='output']"));
		} catch (Exception e) {
			logger.error("Unable to locate record output.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement nameOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='name']"));
		} catch (Exception e) {
			logger.error("Unable to locate name on record.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement emailOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='email']"));
		} catch (Exception e) {
			logger.error("Unable to locate email on record.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement currentAddressOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='currentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate currentAddress on record.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement permanentAddressOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate permanentAddress on record.");
			e.printStackTrace();
		}		
		return element;
	}

	public Boolean verifyNavigateElementsPage() throws Exception
	{
		Boolean status = null;
		//click elements card in landing page
		util.clickAfterExplicitWait(2000, "//h5[contains(text(), 'Elements')]");
		if(driver.getCurrentUrl().contentEquals("https://demoqa.com/elements"))
		{
			status = true;
		}
		else
		{
			status = false;
		}
		return status;
	}

	public Boolean verifyTextBox(String name, String email, String currentAddress, String permAddress) throws Exception
	{
		Boolean positiveTest = null;
		Boolean negativeTest = null;
		Boolean status = null;
		//navigate to text box section
		textBox().click();
		//positive test
		//provide inputs
		fullnameField().clear();
		fullnameField().sendKeys(name);
		emailField().clear();
		emailField().sendKeys(email);
		currentAddressField().clear();
		currentAddressField().sendKeys(currentAddress);
		permanentAddressField().clear();
		permanentAddressField().sendKeys(permAddress);
		//click submit btn
		util.clickAfterExplicitWait(2000, "//button[@id='submit']");
		//verify data displayed
		if(recordOutput().isDisplayed() &&
				nameOnRecord().getText().equals("Name:" + name) &&
				emailOnRecord().getText().equals("Email:" + email) &&
				currentAddressOnRecord().getText().equals("Current Address :" + currentAddress) &&
				permanentAddressOnRecord().getText().equals("Permananet Address :" + permAddress))
		{
			positiveTest = true;
		}
		else
		{
			positiveTest = false;
		}
		//refresh page to reset text box contents
		driver.navigate().refresh();
		Thread.sleep(2000);
		//negative test
		//provide inputs
		fullnameField().clear();
		fullnameField().sendKeys(name);
		//provide incorrect email
		emailField().clear();
		emailField().sendKeys("QA");
		currentAddressField().clear();
		currentAddressField().sendKeys(currentAddress);
		permanentAddressField().clear();
		permanentAddressField().sendKeys(permAddress);
		//click submit btn
		util.clickAfterExplicitWait(2000, "//button[@id='submit']");
		if(emailField().getAttribute("class").contains("error"))
		{
			negativeTest = true;
		}
		else
		{
			negativeTest = false;
		}
		if(positiveTest.equals(true) && negativeTest.equals(true))
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
