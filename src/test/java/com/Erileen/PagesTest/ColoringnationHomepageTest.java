package com.Erileen.PagesTest;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Erileen.BasePackage.TestBase;
import com.Erileen.ColoringPages.ColoringnationHomepage;

public class ColoringnationHomepageTest extends TestBase {

	ColoringnationHomepage coloringnationHomepage;
	SoftAssert sf = new SoftAssert();

	@BeforeMethod
	public void initialisation() {
		structureInitialisation();

		wd.get(properties.getProperty("coloringnation"));

		wd.manage().window().maximize();

		coloringnationHomepage = new ColoringnationHomepage();

	}

	@Test
	public void coloringnationTest() {

		try {
			coloringnationHomepage.clickStickyFooter();
			coloringnationHomepage.getListOfRecommendedAlbums();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("OOOOOPPPPPPPSSSSS");
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
