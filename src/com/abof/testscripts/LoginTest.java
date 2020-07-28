package com.abof.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.abof.generic.BaseLib;
import com.abof.generic.WaitStatementLib;
import com.abof.pageobjects.HomeActivity;
import com.abof.pageobjects.LoginActivity;
import com.abof.pageobjects.SideMenuActivity;

public class LoginTest extends BaseLib{
	HomeActivity homeAct;
	SideMenuActivity sideMenuAct;
	LoginActivity loginAct;
	
	@Test(description="To validate valid login test")
	public void valideLoginTest(){
		homeAct=new HomeActivity(driver);
		WaitStatementLib.hWait(2);
		homeAct.clickOnHamburgerMenu();
		WaitStatementLib.hWait(2);
		sideMenuAct=new SideMenuActivity(driver);
		sideMenuAct.clickOnHiGurstToLogin();
		WaitStatementLib.hWait(2);
		loginAct=new LoginActivity(driver);
		WaitStatementLib.hWait(2);
		loginAct.login();
		WaitStatementLib.hWait(2);
		Assert.assertFalse(loginAct.verifyLogin(),"Login Failed");
		Reporter.log("Login Verified", true);
	}

}
