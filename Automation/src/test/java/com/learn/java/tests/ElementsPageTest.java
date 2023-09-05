package com.learn.java.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.learn.java.base.TestBase;
import com.learn.java.pages.ElementsPage;
import com.learn.java.pages.LandingPage;

public class ElementsPageTest extends TestBase{

	LandingPage landingPage = new LandingPage();	
	ElementsPage elementsPage = new ElementsPage();
	
	@Parameters({"url"})
	@BeforeClass
	public void setUp(String url) throws Exception 
	{
		initialization(url);
	}
	
	@Test
	public void verifyNavigateElementsPage() throws Exception
	{
		Boolean status = elementsPage.verifyNavigateElementsPage();
		Assert.assertTrue(status);
	}
	
	@Test
	public void verifyTextBox() throws Exception
	{
		Boolean status = elementsPage.verifyTextBox();
		Assert.assertTrue(status);
	}
	
	@AfterClass
	public void tearDown() 
	{
		closeBrowser();
	}

}
