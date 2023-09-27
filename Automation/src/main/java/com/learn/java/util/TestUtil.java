package com.learn.java.util;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learn.java.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 2000;
	public static long IMPLICIT_WAIT = 2000;
	public static ExcelUtil excelUtil;
	private static final Logger logger = LogManager.getLogger(TestUtil.class);
	
	public void clickAfterExplicitWait(long timeout, String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Object[]> getTestDataFromExcel()
	{
		try {
			//provide excel sheet path
			excelUtil = new ExcelUtil(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\TestData.xlsx");
		} catch (Exception e) {
			logger.error("Unable to fetch excel sheet.");
			e.printStackTrace();
		}		
		ArrayList<Object[]> testData = new ArrayList<Object[]>();
		
		int row = excelUtil.getRowCount("User_Details");
		
		for(int rowNum=2; rowNum<=row; rowNum++)
		{
			String name = excelUtil.getCellData("User_Details", "name", row);
			String email = excelUtil.getCellData("User_Details", "email", row);
			String currentAddress = excelUtil.getCellData("User_Details", "currentAddress", row);
			String permAddress = excelUtil.getCellData("User_Details", "permAddress", row);
			Object obj[] = {name, email, currentAddress, permAddress};
			testData.add(obj);			
		}
		return testData;
	}
}
