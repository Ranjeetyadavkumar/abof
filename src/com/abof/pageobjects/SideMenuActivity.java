package com.abof.pageobjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SideMenuActivity {
	
	@AndroidFindBy(xpath="//android.view.View[@resource-id='aLoggedinStatus']")
	private MobileElement hiGuestBtn;
	
	public SideMenuActivity(AndroidDriver<MobileElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnHiGurstToLogin(){
		hiGuestBtn.click();
	}

}
