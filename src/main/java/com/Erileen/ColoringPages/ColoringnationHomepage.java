package com.Erileen.ColoringPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.Erileen.BasePackage.TestBase;

public class ColoringnationHomepage extends TestBase {

	public ColoringnationHomepage() {
		PageFactory.initElements(wd, this);
	}

	Actions action = new Actions(wd);
	Scanner sc = new Scanner(System.in);

	@FindBy(css = "#recommended> div>p>a[href='/paw-patrol-coloring-pages']")
	private WebElement pawPatrol;

	@FindBy(css = "#fs-sticky-footer button[aria-label='Close Ad']")
	private WebElement stickyFooter;

	public void clickStickyFooter() {
		action.click(stickyFooter);
	}

	public void getListOfRecommendedAlbums() {

		List<WebElement> albumList = wd.findElements(By.cssSelector("#recommended> div>p>a"));
		for (int i = 0; i < albumList.size(); i++) {
			System.out.println("Album name: " + i + "  " + albumList.get(i).getText());
		}
	}

	public PawPatrolColoringPage clickPawPatrol() {
		wd.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(pawPatrol));
		action.moveToElement(pawPatrol).perform();
		action.click(pawPatrol).perform();

		return new PawPatrolColoringPage();
	}
}
