package com.learn.java.base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.learn.java.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	
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
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("autofill.profile_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		
		driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.get(url);
	}
	
	//close browser and quit driver
	public static void closeBrowser() throws Exception
	{
		driver.close();
		driver.quit();
	}
}
