package com.Erileen.PagesTest;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Erileen.BasePackage.TestBase;
import com.Erileen.ColoringPages.ColoringnationHomepage;
import com.Erileen.ColoringPages.PawPatrolColoringPage;

public class ColoringnationHomepageTest extends TestBase{
	
	ColoringnationHomepage coloringnationHomepage;
	PawPatrolColoringPage patrolColoringPage;
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
			patrolColoringPage = coloringnationHomepage.clickPawPatrol();
			patrolColoringPage.switchToAlert();
			
			patrolColoringPage.clickSkye();
			sf.assertEquals(wd.getTitle(), "Skye Coloring Page - Coloring Nation", "Not a Skye page");
			sf.assertAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("OOOOOPPPPPPPSSSSS");
			e.printStackTrace();
		}
		
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
//		tearDown();
	}
	
	

}
