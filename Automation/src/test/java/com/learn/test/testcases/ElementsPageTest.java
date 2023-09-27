package com.learn.test.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	private static final Logger logger = LogManager.getLogger(ElementsPageTest.class);
	
	@Parameters({"url"})
	@BeforeClass
	public void setUp(String url) 
	{
		initialization(url);
	}
	
	@Test(priority = 1)
	public void verifyNavigateElementsPage()
	{
		Boolean status = null;
		try {
			status = elementsPage.verifyNavigateElementsPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(status);
	}
//	
//	@DataProvider
//	public Iterator<Object[]> getTestData()
//	{
//		ArrayList<Object[]> testData = TestUtil.getTestDataFromExcel();
//		return testData.iterator();
//	}
//	
//	@Test(dataProvider = "getTestData", priority = 2)
//	public void verifyTextBox(String name, String email, String currentAddress, String permAddress) throws Exception
//	{
//		Boolean status = elementsPage.verifyTextBox(name, email, currentAddress, permAddress);
//		Assert.assertTrue(status);
//	}
	
	@Test(priority = 3)
	public void verifyRadioBtn()
	{
		Boolean status = null;
		try {
			status = elementsPage.verifyRadioBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(status);	}
	
	@AfterClass
	public void tearDown() 
	{
		closeBrowser();
	}

}
