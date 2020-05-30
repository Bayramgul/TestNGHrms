package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class ViewPersonalDetails {
	@FindBy(id="personal_txtEmpFirstName")
	public WebElement empFirstName;
	
	@FindBy(id="personal_txtEmpLastName")
	public WebElement empLastName;
	
	@FindBy(id="personal_txtEmployeeId")
	public WebElement empID;
	
	@FindBy(id="profile-pic")
	public WebElement profilePic;//including first and lastname
	
	@FindBy(id="personal_cmbNation")
	public WebElement nationalityDD;
	
	@FindBy(name="personal[optGender]")
	public  List<WebElement> genderRadioGroup; 
	
	public ViewPersonalDetails() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
}
