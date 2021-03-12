package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;

public class GoogleSearchTest {
	
	private static WebDriver driver=null;
	
	public static void main(String[] args) throws InterruptedException {
		googleSearch();
		
	}
	
	public static void googleSearch() throws InterruptedException {
		
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		GoogleSearchPage.textbox_serach(driver).sendKeys("Automation step by step");
		Thread.sleep(2000);
		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
		
	}
}
