package com.learn.test.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.learn.java.base.TestBase;
import com.learn.java.pages.LandingPage;

public class LandingPageTest extends TestBase{

	LandingPage landingpage = new LandingPage();
	private static final Logger logger = LogManager.getLogger(LandingPageTest.class);
	
	public LandingPageTest()
	{
		super();
	}
	
	@Parameters({"url"})
	@BeforeClass
	public void setUp(String url) throws Exception
	{
		try {
			initialization(url);
		} catch (Exception e) {
			logger.error("Unable to initialize driver for test execution.");
		}
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
		try {
			closeBrowser();
		} catch (Exception e) {
			logger.error("Unable to close browser.");
		}
	}
}
