package com.hrms.utils;

import com.hrms.testbase.BaseClass;

public class TestClass extends BaseClass{

	public static void main(String[] args) {
		setUp();
		driver.getTitle();
		System.out.println(driver.getTitle());
	}

}
