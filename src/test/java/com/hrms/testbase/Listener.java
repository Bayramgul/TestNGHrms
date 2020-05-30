package com.hrms.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonMethods;
//Test start first in xml file, bcuz we're specifying configuration
//based on the actions performed in class, listener responds by implementing certain actions
//for ex: if test case passes give me screenshot,if fails print on the console 
//TestNG Listeners listens every event that happens within your TestNG framework
//Listeners can be implemented on the class level(individual to each class) and project level(applicable for all test classes)
/*
 * Steps:
1. Create a Listener class that will be implementing ITestListener Interface
2. Provide logic for methods we need (on passing, on failure, before starting)
3. Specify listener in configurations (xml file) before test after suite

In order for listeners to work we MUST execute test from the xml.file
NOTE:we use overridden methods inside Listeners class in TestNG
 */
public class Listener extends CommonMethods implements ITestListener{
	@Override
		public void onStart(ITestContext context) {
			System.out.println("Functionality Testing started");//runs only one time
		}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Functionality Testing finished");
	}
@Override
public void onTestStart(ITestResult result) {//runs before each test 
	System.out.println("Test Started "+ result.getName());
}
@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed "+ result.getName());
		CommonMethods.takesScreenshot("/passed/"+result.getName());
	} 
@Override
	public void onTestFailure(ITestResult result) {
	System.out.println("Test Failed "+ result.getName());
	CommonMethods.takesScreenshot("/failed/"+result.getName());
	}

}
