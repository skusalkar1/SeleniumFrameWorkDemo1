package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsDemo {
	
		  
		  public static final String USERNAME = "skusalkar1";
		  public static final String ACCESS_KEY = "https://skusalkar1:df1ebb88-0e22-42b7-9bbd-7e2b37693ab0@ondemand.us-west-1.saucelabs.com:443/wd/hub";
		  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		  
		  public static void main(String[] args)  throws Exception {
		  
		    DesiredCapabilities caps = DesiredCapabilities.chrome();
		    caps.setCapability("platform", "Windows 10");
		    caps.setCapability("version", "latest");
		    caps.setCapability("name", "GoogleTest1");
		  
		    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		    
		    driver.get("https://google.com");
			System.out.println(driver.getTitle());
			driver.findElement(By.name("q")).sendKeys("Automation step by step");
			Thread.sleep(3000);
			driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
			
			driver.quit();

}}
