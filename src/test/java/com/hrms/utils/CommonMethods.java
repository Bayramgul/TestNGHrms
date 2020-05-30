package com.hrms.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {
	/**
	 * Method that clears and sends keys
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * Method checks if radio is enabled and clicks it
	 * 
	 * @param radiOrCheckbox
	 * @param value
	 */
	public static void clickRadiOrCheckbox(List<WebElement> radiOrCheckbox, String value) {// pass the list of
																							// Webelemnts,
		String actualValue;
		for (WebElement el : radiOrCheckbox) {
			actualValue = el.getAttribute("value").trim();// in case there is space infront or after
			if (actualValue.equals(value) && el.isEnabled()) {
				el.click();
				break;
			}
		}
	}

	/**
	 * Method will click the button with the help of inner text
	 * 
	 * @param buttons
	 * @param text
	 */
	public static void clickButton(List<WebElement> buttons, String text) {
		for (WebElement button : buttons) {
			String BtnText = button.getText();
			if (BtnText.equals(text)) {
				button.click();
				break;
			}
		}
	}

	public static void selectDDValue(List<WebElement> element, String text) {// pass list of DDs and visible text there
		for (WebElement el : element) {
			String Innertext = el.getText();
			if (Innertext.equals(text)) {
				el.click();
			}
		}
	}

	/**
	 * Method that checks if text is there and then selects it
	 */

	public static void selectDDValue(WebElement element, String textToSelect) {// passing element and visible text
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement el : options) {
				if (el.getText().equals(textToSelect)) {
					select.selectByVisibleText(textToSelect);
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	public static void selectDDValue(WebElement element, int index) {
		try {
			Select select = new Select(element);
			int size = select.getOptions().size();
			if (size > index) {// anything you enter as index should be less than total number of elements
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods that accepts alerts and catches exception is alert if alert not
	 * present
	 */
	public static void acceptAlert() {

		try {
			Alert alert = driver.switchTo().alert();// if alert is not there JVM might throw an Exception
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods that dismisses alerts and catches exception is alert if alert not
	 * present
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();// if alert is not there JVM might throw an Exception
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();

		}
		return alertText;
	}

	public static void SendAlertText(String Text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(Text);

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch from webpage to frame using name or id
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch from webpage to frame using webelement
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch from webpage to frame using index
	 * 
	 * @param index
	 */

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches focus to the child window
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void WaitandClick(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitUntilpresenceOfElement(By locator) {
		getWaitObject().until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * Method that will click the link by its tagName
	 * 
	 * @param tagName
	 * @param text
	 */
	public static void selectLinkByTagName(String tagName, String text) {// pass link tag and partial Text
		List<WebElement> links = driver.findElements(By.tagName(tagName));
		for (WebElement link : links) {
			String innerText = link.getText();
			if (innerText.equals(text)) {
				link.click();
			}
		}
	}

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	public static void scrollElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

public static void scrollDown(int pixel) {
	getJSObject().executeScript("window.scrollBy(0,"+ pixel+")");
}
public static void scrollUp(int pixel) {
	getJSObject().executeScript("window.scrollBy(0,-"+ pixel+")");
}
public static void sleep (long millis) {
	try{
		
		Thread.sleep(millis*1000);
	}catch(InterruptedException ie) {
		System.out.println(ie);
	}}

	/**
	 * A method that would switch focus to multiple windows
	 * 
	 * @return set of multiple windows
	 */

	public static Set<String> WindowsHandle() {
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
		}
		return windows;
	}
//	public static void TakesScreenshot(String fileName) {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File screen = ts.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(screen, new File(fileName));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	//}
	public static void takesScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screen = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screen, new File("screenshots/HRMS/"+fileName+".png"));
		} catch (IOException e) {
			System.out.println("Couldn't take screenshot");
			e.printStackTrace();
		
		}
	}
}
