package com.hrms.testbase;

public class Constants {

	//first we are creating constants for the path for chrome and gecko driver,and path for configuration file
public static final  String CHROME_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver 3";
public static final  String GECKO_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver 2";
public static final  String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/config/privateinfo.properties";
public static final String EXCELDATA_FILEPATH=System.getProperty("user.dir")+"Test.xlsx";
public static final  int IMPLICIT_WAIT_TIME=10;
public static final int EXPLICIT_WAIT_TIME=25;

public static void main (String []args) {
	System.out.println(EXCELDATA_FILEPATH);
}
}
