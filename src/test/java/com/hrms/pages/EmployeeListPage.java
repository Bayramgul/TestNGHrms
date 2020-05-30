package com.hrms.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class EmployeeListPage extends com.hrms.utils.CommonMethods{
	@FindBy (id="menu_pim_addEmployee")
	public WebElement addEmployee;
	
	@FindBy (id="empsearch_employee_name_empName")
	public WebElement EmpName;
	
	@FindBy (id="empsearch_id")
	public WebElement EmpID;
	
	@FindBy (id="empsearch_employee_status")
	public WebElement EmpStatusDD;
	
	@FindBy (id="empsearch_termination")
	public WebElement includeDD;
	
	@FindBy (id="empsearch_supervisor_name")
	public WebElement supervisorNM;
	
	@FindBy (id="empsearch_job_title")
	public WebElement jobTitleDD;
	
	@FindBy (id="empsearch_sub_unit")
	public WebElement subUnitDD;
	
	@FindBy (id="searchBtn")
	public WebElement searchBtn;
	
	@FindBy (id="resetBtn")
	public WebElement resetBtn;
	
	@FindBy (id="btnAdd")
	public WebElement btnAdd;
	
	@FindBy (id="btnDelete")
	public WebElement btnDelete;
	
	@FindBy(xpath="//li[@class='next']//a[1]")
	public WebElement nextPageClick;
	
	@FindBy(xpath="//li[@class='last']//a[1]")
	public WebElement lastPageClick;
	
	@FindBy(id="resultTable")
	public WebElement table;
	
	@FindBy(xpath="//table[@id='resultTable']/thead")
	public WebElement thead;
	
	public EmployeeListPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	public List<WebElement> tableRow(){
		List<WebElement> tableRows=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		return tableRows;
	}
}
