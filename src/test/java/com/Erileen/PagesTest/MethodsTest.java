package com.Erileen.PagesTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Erileen.BasePackage.TestBase;

public class MethodsTest extends TestBase {

	Actions action;
	JavascriptExecutor je;

	@BeforeMethod
	public void initialisation() {
		structureInitialisation();
		wd.get(properties.getProperty("demoQa"));
		wait = new WebDriverWait(wd, Duration.ofMillis(1000));

		wd.manage().window().maximize();

	}

	@Test
	public void basicsTest() throws Exception {

		je = (JavascriptExecutor) wd;

		wait.until(ExpectedConditions.elementToBeClickable(wd.findElement(By.cssSelector(
				"#app div[class='category-cards'] div[class='card mt-4 top-card']:nth-of-type(1) div[class='card-body']"))));

		je.executeScript("arguments[0].scrollIntoView(true);", wd.findElement(By.cssSelector(
				" #app div[class='category-cards'] div[class='card mt-4 top-card']:nth-of-type(1) div[class='card-body']")));

		// Elements on landing page
		wd.findElement(By.cssSelector(
				" #app div[class='category-cards'] div[class='card mt-4 top-card']:nth-of-type(1) div[class='card-body']"))
				.click();

		// Forms
		je.executeScript("arguments[0].scrollIntoView(true);",
				wd.findElement(By.cssSelector("#app div[class='accordion'] > div:nth-of-type(2)")));
		action = new Actions(wd);
		action.moveToElement(wd.findElement(By.cssSelector("#app div[class='accordion'] > div:nth-of-type(2)")))
				.perform();
		wd.findElement(By.cssSelector("#app div[class='accordion'] > div:nth-of-type(2)")).click();

		// Practice Form Left pannel
		wd.findElement(By.cssSelector("#app div[class='accordion'] > div:nth-of-type(2) > div")).click();

		// FirstName
		WebElement firstName = wd.findElement(By.id("firstName"));
		je.executeScript("arguments[0].scrollIntoView(true);", firstName);
		firstName.sendKeys("Erileen Kaur");

		// Date of Birth
		je.executeScript("arguments[0].scrollIntoView(true);", wd.findElement(By.id("dateOfBirthInput")));
		wd.findElement(By.id("dateOfBirthInput")).click();

		// Select Month/Year/Date

		Select selectMonth = new Select(
				wd.findElement(By.cssSelector("select[class='react-datepicker__month-select']")));
		selectMonth.selectByIndex(0);

		WebElement year = wd.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
		wait.until(ExpectedConditions.elementToBeClickable(year));
		Select selectYear = new Select(year);
		selectYear.selectByValue("2095");

		// click on Date
		wd.findElement(By.cssSelector("div[class='react-datepicker__month'] > div:nth-of-type(5) div:nth-of-type(3)"))
				.click();

		wd.navigate().to("https://ca.finance.yahoo.com/");
//		Thread.sleep(500);

		wd.navigate().back();

		System.out.println("Current URL: " + wd.getCurrentUrl());
		System.out.println("Current page title: " + wd.getTitle());
		System.out.println("Current instance of browser: " + wd.getWindowHandle());

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
