package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.hrms.utils.ConfigsReader;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod(alwaysRun=true) // to make method run before every method
	public static WebDriver setUp() {// we changed the return type to WebDriver
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);// calling the readProperties method from
																		// ConfigsReader class
		// System.setProperty(C, value)
		// to have all must steps for reading a configs file, FileInputStream,
		// Properties and prop.(load)
		switch (ConfigsReader.getProperty("browser")) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
		PageInitializer.initialize();// we have to call the initialize method to initialize pages
		return driver;
	}

	@AfterMethod(alwaysRun=true) // to make method run before every method
	public static void tearDown() {

		if (driver != null) {
			driver.quit();
		}
	}

	public static void sleep(long millis) {
		try {

			Thread.sleep(millis * 1000);
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
	}

}
