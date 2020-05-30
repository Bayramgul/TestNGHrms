package com.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	public static Properties prop;
		/**
		 * This method will read properties
		 * @param key
		 * @return
		 */
	//what we need for reading configuration file ? 1. we need fileInputStream with filePath 
	// and we pass filePath in parameters so later it can be updated by user
	
public static void readProperties(String filePath) {

	try {
		FileInputStream fis=new FileInputStream(filePath);
		prop=new Properties();
		prop.load(fis);
	}catch(FileNotFoundException e) {//there is high possibility that path might be wrong and exception might occur so we need to handle it
		e.printStackTrace();//with try and catch for 
	}catch(IOException e) {
		e.printStackTrace();
	}
}
/**
 * This method will return value of specified key 
 * @param key
 * @return
 */
//2. We need Properties class object
public static String getProperty(String key) {
	
	return prop.getProperty(key);
}
}
