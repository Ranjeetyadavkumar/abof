package com.abof.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import com.abof.generic.ExcelUtlities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginActivity {
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='sleCustomerMobNo']")
	private MobileElement mobNumber;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='sleCustomerPassword']")
	private MobileElement pwd;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Login']")
	private MobileElement loginBtn;
	
	
	
	public LoginActivity(AndroidDriver<MobileElement> driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/**
	 * @Desc: Method Will Login the App.
	 */
	public void login(){
		mobNumber.sendKeys(ExcelUtlities.readData("Sheet1", 1, 0));
		pwd.sendKeys(ExcelUtlities.readData("Sheet1", 1, 1));
		
		loginBtn.click();
	}
	
	public boolean verifyLogin(){
		try {
			if(loginBtn.isDisplayed()){
				return true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
