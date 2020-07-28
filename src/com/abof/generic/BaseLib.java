package com.abof.generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {
	public AndroidDriver<MobileElement> driver;
	AppiumDriverLocalService service;
	
	public static final String NODE_JS="C:/Program Files/nodejs/node.exe";
	public static final String APPIUM_JS="C:/Users/Lenovo/AppData/Local/Programs/appium-desktop"
			+ "/resources/app/node_modules/appium/build/lib/main.js";
	
	public void startAppiumServer(){
		service=AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingAnyFreePort().
				usingDriverExecutable(new File(NODE_JS)).withAppiumJS(new File(APPIUM_JS)));
		System.out.println("Appium server starting...");
		service.start();
		System.out.println("Appium server started");
	}
	
	public void stopAppiumServer(){
		System.out.println("Appium server Stopping...");
		service.stop();
		System.out.println("Appium server stopped");
	}
	
	@BeforeMethod
	public void setUp(){
		//stopAppiumServer();
		startAppiumServer();
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("automationName", GetPropertyValue.getValue("AutomationName"));
		dc.setCapability("deviceName", GetPropertyValue.getValue("DeviceName"));
		dc.setCapability("platformVersion", GetPropertyValue.getValue("PlatformVersion"));
		dc.setCapability("appPackage", GetPropertyValue.getValue("AppPackage"));
		dc.setCapability("appActivity", GetPropertyValue.getValue("AppActivity"));
		dc.setCapability("noReset", GetPropertyValue.getValue("NoReset"));
		dc.setCapability("platformName", GetPropertyValue.getValue("PlatformName"));
		try {
			driver=new AndroidDriver<MobileElement>(new URL(service.getUrl().toString()),dc);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	@AfterMethod
	public void tearDown(ITestResult result){
		if(result.isSuccess()){
			Reporter.log("Test Passed :)", true);
		}
		
		else{
			TakesScreenshot ts=(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File("./screenshots/"+result.getName()+".png"));
			} catch (IOException e) {
			}
		}
		
		if(!(driver==null)){
			driver.closeApp();
			System.out.println("App Closed");
			stopAppiumServer();
		}	
	}

}
