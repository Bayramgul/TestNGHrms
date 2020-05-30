package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.ConfigsReader;
//POM is design pattern, why we need it?-->code redundancy 
//How to use it?: 1)with the help of @FindBy annotation to find and declare WebElements; 2) we use PageFactory.initElements() to initilize webelemnts 
//inside of Constructor
public class AddEmployeePage extends com.hrms.utils.CommonMethods{
	@FindBy (id="menu_pim_addEmployee")
	public WebElement addEmployee;
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(id="lastName")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='employeeId']")
	public WebElement empId;
	
	@FindBy(id="photofile")
	public WebElement photofile;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy(id="chkLogin")
	public WebElement checkLogn;
	
	@FindBy(id="user_name")
	public WebElement userName;
	
	@FindBy(id="user_password")
	public WebElement userPassword;
	
	@FindBy(id="re_password")
	public WebElement confirmPasswrd ;
	
	@FindBy(xpath="//span[@for='firstName']")
	public WebElement ErrorMsgFirstNm;//Required
	
	@FindBy(xpath="//span[@for='lastName']")
	public WebElement ErrorMsgLastNm;//Required
	
	@FindBy(xpath="//span[@for='user_name']")
	public WebElement usrNamErrorMesg;//Should have at least 5 characters
	
	@FindBy(xpath="//span[@for='user_password']")
	public WebElement pswordErrorMesg;//Your password must contain a lower-case letter, an upper-case letter, a digit and a special character. Try a different password.
	
	@FindBy(xpath="//span[@for='re_password']")
	public WebElement ConfirmPswordErrorM;//Passwords do not match
	 
	public AddEmployeePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	public void addEmp() {
		sendText(firstName, ConfigsReader.getProperty("firstname"));
		sendText(lastName, ConfigsReader.getProperty("lastname"));
		WaitandClick(btnSave);
	}
	/** This method will create employee login credentials
	 */
	public void createEmpLoginCR() {
		sendText(userName, ConfigsReader.getProperty("empUserName"));
		sendText(userPassword, ConfigsReader.getProperty("empPassword"));
		sendText(confirmPasswrd, ConfigsReader.getProperty("empPassword"));
		WaitandClick(btnSave);
	}
}
