package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
public class LoginPageElemements extends CommonMethods {
	//@FindBy() is an interface/tecnique help us to locate the element 
	@FindBy(id="txtUsername")
	public WebElement username;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(id=("btnLogin"))
	public WebElement loginBTN;
	
	@FindBy(xpath=("//div[@id='divLogo']/img"))
	public WebElement logoSyntax;
	
	@FindBy (id=("spanMessage"))
	public WebElement errorMessage;
	
	
	public LoginPageElemements(){//once we locate elements we Use PageFactory to initialize all elements on this page
		PageFactory.initElements(BaseClass.driver, this);//avoid driver.findElement
	}
	public void login() {
		
		sendText(username, ConfigsReader.getProperty("username"));
		sendText(password, ConfigsReader.getProperty("password"));
		loginBTN.click();
	}
}
