package com.learn.java.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.learn.java.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public static String projectPath = System.getProperty("user.dir");
	public static String screenshotsFolder = projectPath + "/test-output/Screenshots/";
	
	public TestBase()
	{
		
	}
	
	//open browser and navigate to url
	public static void initialization(String url) throws Exception
	{
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);
		
		//defining desired capabilities for chrome driver
		ChromeOptions options = new ChromeOptions();
		options.setBrowserVersion("116");
		options.addArguments("start-maximized");
		options.addArguments("disable-popup-blocking");
//		//extension to block ads
//		options.addExtensions(new File("./Extensions/Adblock Plus - free ad blocker 3.19.0.0.crx"));
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("autofill.profile_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.get(url);
	}
	
	//screenshot code for failed tests
	public static void screenshot(String testName)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(scrFile, new File(screenshotsFolder + testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//close browser and quit driver
	public static void closeBrowser()
	{
		driver.close();
		driver.quit();
	}
}
