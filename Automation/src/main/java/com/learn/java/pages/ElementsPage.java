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

	public WebElement textBox()
	{
		try {
			element = driver.findElement(By.xpath("//span[contains(text(), 'Text Box')]"));
		} catch (Exception e) {
			logger.error("Unable to locate text box option in side nav.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement fullnameField()
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='userName']"));
		} catch (Exception e) {
			logger.error("Unable to locate full name field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement emailField()
	{
		try {
			element = driver.findElement(By.xpath(" //*[@id='userEmail']"));
		} catch (Exception e) {
			logger.error("Unable to locate email field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement currentAddressField()
	{
		try {
			element = driver.findElement(By.xpath(" //*[@id='currentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate current address field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement permanentAddressField()
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate permanent address field.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement submitBtn()
	{
		try {
			element = driver.findElement(By.xpath("//button[@id='submit']"));
		} catch (Exception e) {
			logger.error("Unable to locate submit btn.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement recordOutput()
	{
		try {
			element = driver.findElement(By.xpath("//div[@id='output']"));
		} catch (Exception e) {
			logger.error("Unable to locate record output.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement nameOnRecord()
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='name']"));
		} catch (Exception e) {
			logger.error("Unable to locate name on record.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement emailOnRecord()
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='email']"));
		} catch (Exception e) {
			logger.error("Unable to locate email on record.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement currentAddressOnRecord()
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='currentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate currentAddress on record.");
			e.printStackTrace();
		}		
		return element;
	}

	public WebElement permanentAddressOnRecord()
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
		} catch (Exception e) {
			logger.error("Unable to locate permanentAddress on record.");
			e.printStackTrace();
		}		
		return element;
	}
	
	public WebElement radioButton()
	{
		try {
			element = driver.findElement(By.xpath("//span[contains(text(), 'Radio Button')]"));
		} catch (Exception e) {
			logger.error("Unable to locate radio btn option in side nav.");
			e.printStackTrace();
		}		
		return element;
	}
	
	public WebElement yesBtn()
	{
		try {
			element = driver.findElement(By.xpath("//input[@id='yesRadio']"));
		} catch (Exception e) {
			logger.error("Unable to locate Yes radio btn.");
			e.printStackTrace();
		}		
		return element;
	}
	
	public WebElement impressiveBtn()
	{
		try {
			element = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
		} catch (Exception e) {
			logger.error("Unable to locate Impressive radio btn.");
			e.printStackTrace();
		}		
		return element;
	}
	
	public WebElement noBtn()
	{
		try {
			element = driver.findElement(By.xpath("//input[@id='noRadio']"));
		} catch (Exception e) {
			logger.error("Unable to locate No radio btn.");
			e.printStackTrace();
		}		
		return element;
	}
	
	public WebElement successText()
	{
		try {
			element = driver.findElement(By.xpath("//span[@class='text-success']"));
		} catch (Exception e) {
			logger.error("Unable to locate success text for radio btn click.");
			e.printStackTrace();
		}		
		return element;
	}

	public Boolean verifyNavigateElementsPage()
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

	public Boolean verifyTextBox(String name, String email, String currentAddress, String permAddress)
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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
	
	public Boolean verifyRadioBtn()
	{
		Boolean verifyYesBtn = null;
		Boolean verifyImpressiveBtn = null;
		Boolean verifyNoBtn = null;
		Boolean status = null;
		//navigate to radio btn section
		radioButton().click();
		//verify yes btn click
		if(!yesBtn().isSelected() && yesBtn().isDisplayed())
		{
			util.clickAfterExplicitWait(2000, "//*[@for='yesRadio']");
//			driver.findElement(By.xpath("//*[@for='yesRadio']")).click();
		}
		if(yesBtn().isEnabled() && successText().getText().equals("Yes"))
		{
			verifyYesBtn = true;
		}
		else
		{
			verifyYesBtn = false;
		}
		//verify impressive btn click
		if(!impressiveBtn().isSelected() && impressiveBtn().isDisplayed())
		{
			driver.findElement(By.xpath("//*[@for='impressiveRadio']")).click();
		}		
		if(impressiveBtn().isEnabled() && successText().getText().equals("Impressive"))
		{
			verifyImpressiveBtn = true;
		}
		else
		{
			verifyImpressiveBtn = false;
		}
		//verify no btn
		if(!noBtn().isEnabled() && noBtn().isDisplayed())
		{
			verifyNoBtn = true;
		}
		else
		{
			verifyNoBtn = false;
		}
		if(verifyYesBtn.equals(true) && verifyImpressiveBtn.equals(true) && verifyNoBtn.equals(true))
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
