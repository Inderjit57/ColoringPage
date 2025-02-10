package com.W3School.Pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Erileen.BasePackage.TestBase;
import com.Erileen.Util.UtilMethods;

public class W3schoolHomepage extends TestBase {

	public W3schoolHomepage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "navbtn_tutorials")
	WebElement tutorialIcon;

	@FindBy(css = "#tutorials_list > div:nth-of-type(2)> div:nth-of-type(1) >div")
	List<WebElement> listHtmlAndCss;

	List<String> newList = new ArrayList<String>(); // Adding all the values from above listHtmlAndCss

	public void clickTutorial() {
		UtilMethods.clickOnElement(tutorialIcon);
	}

	// This methods is getting the list of all HTMl and CSS tutorials present
	public void getAllTutorialList() {

		System.out.println("Number of tutorials: " + listHtmlAndCss.size());
		System.out.println("Tutorial List:");
		for (int i = 0; i < listHtmlAndCss.size(); i++) {
			System.out.println(listHtmlAndCss.get(i).getAttribute("data-name"));
			newList.add(listHtmlAndCss.get(i).getAttribute("data-name"));

			if (newList.contains("colors")) {
				System.out.println("Element found in the list");
				listHtmlAndCss.get(i).click();
				System.out.println(wd.getCurrentUrl());
				break;
			} else
				continue;

		}
			
		//Work in progress to click on the element after finding in the List
//			Iterator<String> newListIterator = newList.iterator();
//			Iterator<WebElement> tutorialListIterator = listHtmlAndCss.iterator();
//			
//			while(newListIterator.hasNext()) {
//				if (newList.contains("colors")) {
//					System.out.println("Element found in the list");
//					tutorialListIterator =listHtmlAndCss.iterator();
//					while(tutorialListIterator.hasNext()) {
//						System.out.println(listHtmlAndCss.get(listHtmlAndCss.indexOf("color")));
//					}
//					break;
//				} else
//					continue;
//			}
	}
}
