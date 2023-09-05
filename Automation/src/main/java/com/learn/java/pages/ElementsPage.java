package com.learn.java.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.learn.java.base.TestBase;
import com.learn.java.util.TestUtil;

public class ElementsPage extends TestBase{

	public static WebElement element;
	TestUtil util = new TestUtil();

	public ElementsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement textBox() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//span[contains(text(), 'Text Box')]"));
		} catch (Exception e) {
			System.out.println("Unable to locate text box option in side nav.");
		}		
		return element;
	}

	public WebElement fullnameField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='userName']"));
		} catch (Exception e) {
			System.out.println("Unable to locate full name field.");
		}		
		return element;
	}

	public WebElement emailField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath(" //*[@id='userEmail']"));
		} catch (Exception e) {
			System.out.println("Unable to locate email field.");
		}		
		return element;
	}

	public WebElement currentAddressField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath(" //*[@id='currentAddress']"));
		} catch (Exception e) {
			System.out.println("Unable to locate current address field.");
		}		
		return element;
	}

	public WebElement permanentAddressField() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
		} catch (Exception e) {
			System.out.println("Unable to locate permanent address field.");
		}		
		return element;
	}

	public WebElement submitBtn() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//button[@id='submit']"));
		} catch (Exception e) {
			System.out.println("Unable to locate submit btn.");
		}		
		return element;
	}
	
	public WebElement recordOutput() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//div[@id='output']"));
		} catch (Exception e) {
			System.out.println("Unable to locate record output.");
		}		
		return element;
	}
	
	public WebElement nameOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='name']"));
		} catch (Exception e) {
			System.out.println("Unable to locate name on record.");
		}		
		return element;
	}
	
	public WebElement emailOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='email']"));
		} catch (Exception e) {
			System.out.println("Unable to locate email on record.");
		}		
		return element;
	}
	
	public WebElement currentAddressOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='currentAddress']"));
		} catch (Exception e) {
			System.out.println("Unable to locate currentAddress on record.");
		}		
		return element;
	}
	
	public WebElement permanentAddressOnRecord() throws Exception
	{
		try {
			element = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
		} catch (Exception e) {
			System.out.println("Unable to locate permanentAddress on record.");
		}		
		return element;
	}

	public Boolean verifyNavigateElementsPage() throws Exception
	{
		try {
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
		} catch (Exception e){
			System.out.println("Unable to verify landing page.");
			return null;
		}
	}

	public Boolean verifyTextBox() throws Exception
	{
		try {
			Boolean positiveTest = null;
			Boolean testWithoutFullName = null;
			Boolean status = null;
			String name = "Jackie Chan";
			String email = "jc@example.com";
			String currentAddress = "1234 SE Main St, Portland, OR 98765";
			String permAddress = "1234 SE Main St, Portland, OR 98765";
			//navigate to text box section
			textBox().click();
			//provide inputs
			fullnameField().sendKeys(name);
			emailField().sendKeys(email);
			currentAddressField().sendKeys(currentAddress);
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
			//refresh page to reset inputs
			driver.navigate().refresh();
			//click submit btn without providing inputs
			util.clickAfterExplicitWait(2000, "//button[@id='submit']");
			List<WebElement> recordData = driver.findElements(By.xpath("//div[@id='output']//p"));
			if(recordData.size() == 0)
			{
				testWithoutFullName = true;
			}
			else
			{
				testWithoutFullName = false;
			}
			if(positiveTest.equals(true) && testWithoutFullName.equals(true))
			{
				status = true;
			}
			else
			{
				status = false;
			}
			return status;
		} catch (Exception e){
			System.out.println("Unable to verify text box.");
			return null;
		}
	}
}
