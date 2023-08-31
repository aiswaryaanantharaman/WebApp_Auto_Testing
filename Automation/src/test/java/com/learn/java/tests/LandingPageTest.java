package com.learn.java.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.learn.java.base.TestBase;
import com.learn.java.pages.LandingPage;

public class LandingPageTest extends TestBase{

	LandingPage landingpage = new LandingPage();
	public LandingPageTest()
	{
		super();
	}
	
	@Parameters({"url"})
	@BeforeClass
	public void setUp(String url) throws Exception
	{
		initialization(url);
	}
	
	@Test()
	public void verifylandingPageTest() throws Exception
	{
		Boolean status = landingpage.verifyLandingPage();
		Assert.assertTrue(status);;
	}
	
	@AfterClass
	public void tearDown() throws Exception
	{
		closeBrowser();
	}
}
