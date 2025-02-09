package com.Erileen.Util;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Erileen.BasePackage.TestBase;

public class UtilMethods extends TestBase {

	public static Actions actions = new Actions(wd);

	public static int IMPLICIT_WAIT = 10;
	public static int PAGE_LOAD_TIMEOUT = 10;

	// Javascript Executor will got the WebElement to perform click function
	public static void javascriptClick(WebElement element) {
		je.executeScript("arguments[0].click();", element);
	}

	// Javascript Executor will scroll to the WebElement if its not visible on the
	// font
	public static void scrollIntoViewUsingJavascript(WebElement element) {
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Webdriver Click on Element
	public static void clickOnElement(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	// Waits
	public static WebElement waitForElementToBeVisible(WebElement element, Duration timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
	}

	public static Boolean waitForElementToBeSelectable(WebElement element, Duration timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds)
				.until(ExpectedConditions.elementSelectionStateToBe(element, false));
	}

	// Action methods
	public static void moveToElement(WebElement element) {

		actions.moveToElement(element).build().perform();
	}

	public static void scrollToElement(WebElement element) {
		actions.scrollToElement(element).build().perform();
	}

	// Webdriver Send Keys
	public static void sendData(WebElement element, String data) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(data);
	}

	// Get Text
	public static void getData(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	// Select methods
	public static void selectFromDropDownUsingIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);

	}

	public static void selectFromDropDownUsingVisibleText(WebElement element, String text) {
		new Select(element).deselectByVisibleText(text);

	}

	public static Alert waitForAlertToBePresent(Duration timeOutInSeconds) {
		return new WebDriverWait(wd, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
	}

}
