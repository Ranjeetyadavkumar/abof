package com.abof.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * 
 * @author kanhaiya
 * @Data: 25/05/19
 *
 */
public class WaitStatementLib {
	
	/**
	 * @Author: kanhaiya
	 * @param sec
	 * @return void
	 * @Desc: Method will wait for given time
	 */
	public static void hWait(int sec){
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void iWait(int sec, AndroidDriver<MobileElement> driver){
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public static void eWait(int sec, AndroidDriver<MobileElement> driver, MobileElement ele){
		WebDriverWait wait=new WebDriverWait(driver,sec);
		wait.until(ExpectedConditions.visibilityOf(ele));	
	}

}
