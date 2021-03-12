package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	ExtentTest test1;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extentReports.html");

		// create extent reports and attach reporters
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test1() {
		test1 = extent.createTest("Google search test one", "this is test to validate google search");
		driver.get("https://google.com");
		test1.pass("Navigated to google,com");
		
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test1.pass("Entered text in searchbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("pressed keyboar enter key");

	}
	
	@AfterTest
	public void TearDown() {
		
		driver.close();
		driver.quit();
		test1.pass("closed the browser");
	}

	@AfterSuite
	public void tearDown() {
		extent.flush();

	}

}
