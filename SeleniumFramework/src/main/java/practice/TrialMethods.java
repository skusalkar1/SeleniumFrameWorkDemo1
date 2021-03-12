package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrialMethods {
	WebDriver driver;
	
	public static void clickElement(WebDriver driver,WebElement element) {		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

	}
	public void SendKeys(WebDriver driver,WebElement element,String text) {		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(text);

	}
	
	//POM-- Login Page Class
	//1.Elements
	//2.Methods
	//User name cha webelemt is present 
	//clickElement(driver,usernasme);
	//SendKeys(driver,usernasme,mayur);
	//clickElement(driver,pwd);
	
	
}
