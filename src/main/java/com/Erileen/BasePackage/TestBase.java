package com.Erileen.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	public static  Wait<WebDriver> wait;
	public static WebDriverManager webDriverManager;
	public FileInputStream file;

	public static Properties properties;

	public TestBase() {
		try {
			properties = new Properties();
			file = new FileInputStream("src//main//java//com//Erileen//Configuration//config.properties");
			properties.load(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
			e.printStackTrace();
		}

	}

	public void structureInitialisation() {

//		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");

		webDriverManager.chromedriver().setup();
		wd = new ChromeDriver();
		
	}

	public void tearDown() {
		wd.quit();
	}

}
