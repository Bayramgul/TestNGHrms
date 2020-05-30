package com.hrms.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPageElemements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginPageTest_TestNG extends CommonMethods {
//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}

	@Test(groups="smoke")
	public void validAdminLogin() {
		LoginPageElemements login = new LoginPageElemements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		WaitandClick(login.loginBTN);

		String expectedUSer = "Welcome Admin";
		String actualUser = dashboard.welcome.getText();
		AssertJUnit.assertEquals(expectedUSer, actualUser, "Admin is not logged in");
		AssertJUnit.assertTrue(expectedUSer.contains(ConfigsReader.getProperty("username")));
	}

	@Test(groups="regression")
	public void InvalidPasswordAdminLogin() {

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "dbscjdkb");
		WaitandClick(login.loginBTN);

		AssertJUnit.assertTrue(login.errorMessage.isDisplayed());
		String expectedMessage = "Invalid credentials";
		String actualMessage = login.errorMessage.getText();
		AssertJUnit.assertEquals(actualMessage, expectedMessage);
		AssertJUnit.assertTrue(actualMessage.equals(actualMessage));

	}

	@Test(groups="regression")
	public void emptyUsername() {
		sendText(login.password, ConfigsReader.getProperty("password"));
		WaitandClick(login.loginBTN);
		String expectedMessage = "Username cannot be empty";
		String actualMessage = login.errorMessage.getText();
		AssertJUnit.assertEquals(actualMessage, expectedMessage, "Error Messages doesn't match");
	}

//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}

}
