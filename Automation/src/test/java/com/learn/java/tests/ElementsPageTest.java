package com.learn.java.tests;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.learn.java.base.TestBase;
import com.learn.java.pages.ElementsPage;
import com.learn.java.pages.LandingPage;
import com.learn.java.util.TestUtil;

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
	
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> testData = TestUtil.getTestDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void verifyTextBox(String name, String email, String currentAddress, String permAddress) throws Exception
	{
		Boolean status = elementsPage.verifyTextBox(name, email, currentAddress, permAddress);
		Assert.assertTrue(status);
	}
	
	@AfterClass
	public void tearDown() 
	{
		closeBrowser();
	}

}
