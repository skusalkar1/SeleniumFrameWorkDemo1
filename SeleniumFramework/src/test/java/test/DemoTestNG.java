package test;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import pages.GoogleSearchPage;

public class DemoTestNG {

	private static WebDriver driver = null;
	public static String browserName=null;

	@BeforeTest
	public void setUpTest() {
		
		String ProjectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			
			//write a code to invoke firefox driver
			//System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
			//driver = new ChromeDriver();	
		}
		
		System.out.println(ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public static void googleSearch() throws InterruptedException {

		driver.get("https://google.com");

		GoogleSearchPage.textbox_serach(driver).sendKeys("Automation step by step");
		Thread.sleep(2000);
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.close();
		driver.quit();
		PropertiesFile.setProperties();
		
	}
}
