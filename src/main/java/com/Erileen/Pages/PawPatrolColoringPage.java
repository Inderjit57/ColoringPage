package com.Erileen.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Erileen.BasePackage.TestBase;

public class PawPatrolColoringPage extends TestBase {

	public PawPatrolColoringPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#album> div[class='thumbnail side-corner-tag']>a[href='/coloring-page/1679287?album=paw-patrol-coloring-pages']")
	WebElement skye;
	
	public void clickSkye() {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("")));
		skye.click();
	}

}
