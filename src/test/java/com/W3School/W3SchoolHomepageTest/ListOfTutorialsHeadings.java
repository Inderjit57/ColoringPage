package com.W3School.W3SchoolHomepageTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Erileen.BasePackage.TestBase;
import com.W3School.Pages.W3schoolHomepage;

public class ListOfTutorialsHeadings extends TestBase {

	W3schoolHomepage w3schoolHomepage;

	@BeforeMethod
	public void intializations() {
		structureInitialisation();

		wd.get(properties.getProperty("w3school"));
		wd.manage().window().maximize();
		w3schoolHomepage = new W3schoolHomepage();
	}

	@Test
	public void getListOfTutorialsTest() {
		w3schoolHomepage.clickTutorial();
		w3schoolHomepage.getAllTutorialList();

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
