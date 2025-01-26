package com.Erileen.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Erileen.BasePackage.TestBase;

public class PawPatrolColoringPage extends TestBase {

	public PawPatrolColoringPage() {
		PageFactory.initElements(wd, this);
	}
	
	Actions action = new Actions(wd);

	@FindBy(css = "#album> div[class='thumbnail side-corner-tag']>a[href='/coloring-page/1679287?album=paw-patrol-coloring-pages']")
	WebElement skye;
	
	@FindBy(css = "#creative>iframe")
	WebElement iframe;
	
	@FindBy(css= "#dismiss-button")
	WebElement dismissButton;
	
	public void switchToAlert() {

//	action.moveToLocation(0, 0)

	}
	
	public void clickSkye() {
		wd.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(skye));
//		action.scrollToElement(skye);
		skye.click();
	}

}
