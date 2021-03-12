package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import net.bytebuddy.asm.Advice.Local;

public class ExtendReportsBasicDemo {
	
	private static WebDriver driver=null;

	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter("extentReports.html");
		
		//create extent reports and attach reporters
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//create toggle for given test
		
		ExtentTest test1 = extent.createTest("Google search test one", "this is test to validate google search");
		
		String ProjectPath = System.getProperty("user.dir");
		System.out.println(ProjectPath);
		System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("https://google.com");
		test1.pass("Navigated to google,com");
		
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test1.pass("Entered text in searchbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("pressed keyboar enter key");
		
		driver.close();
		driver.quit();
		test1.pass("closed the browser");
		
		
		
		
		//calling flush writes everything into log
		extent.flush();

	}

}
