package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPageObjects;
import practice.TrialMethods;

public class GoogleSearchPageTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		googleSearchTest();
	}
	 
	public static void googleSearchTest() throws InterruptedException {
		
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);
		
	    Thread.sleep(2000);
	    searchPageObj.clickSearchButton();
	}

}
