package com.abof.generic;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class AppUtils {
	public AndroidDriver<MobileElement> driver;
	
	public AppUtils(AndroidDriver<MobileElement> driver){
		this.driver=driver;
	}
	
	public void verSwipe(int n){
		for (int i = 0; i < n; i++) {
			Dimension d = driver.manage().window().getSize();
			int startHeight = (int) (d.getHeight() * 0.7);
			int endHeight = (int) (d.getHeight() * 0.3);
			driver.swipe(0, startHeight, 0, endHeight, 1000);
		}
	}
	
	public void horizontalSwipe(int swipeCount){
		for (int i = 0; i < swipeCount; i++) {
			Dimension d = driver.manage().window().getSize();
			int startHeight = (int) (d.getWidth() * 0.8);
			int endHeight = (int) (d.getWidth() * 0.2);
			driver.swipe(startHeight, 0, endHeight, 0, 3000);
		}
	}
	
	public void screenRotate(String orientation){
		if(orientation.equalsIgnoreCase("LANDSCAPE")){
		driver.rotate(ScreenOrientation.LANDSCAPE);
		}
		else if(orientation.equalsIgnoreCase("PORTRAIT")){
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
	}
	
	public void hideKeyboard(){
		driver.hideKeyboard();
	}
	
	public void deviceLock(){
		if(!driver.isLocked()){
		driver.lockDevice();
		}
	}
	
	public void scrollUsingUiScrollable(String text){
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))."
				+ "scrollIntoView(new UiSelector().text('"+text+"'))");
	}
	
	public String getCurrnetActivity(){
		String activity = driver.currentActivity();
		return activity;
	}
	
	public void pressBack(){
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
	
	public void tapUsingCoordinate(int x, int y){
		TouchAction ta=new TouchAction(driver);
		ta.tap(x,y).waitAction(2000).perform();
	}
	
	public void clickSearchFromKeypad(){
		driver.pressKeyCode(AndroidKeyCode.ENTER);
	}

}
