package com.learn.java.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.learn.java.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 2000;
	public static long IMPLICIT_WAIT = 2000;
	
	public void clickAfterExplicitWait(long timeout, String xpath) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(2000);
	}
}
