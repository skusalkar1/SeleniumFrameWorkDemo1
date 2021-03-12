package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {

	/*
	 * public static void main(String[] args) {
	 * 
	 * String excelPath =
	 * "C:\\Users\\shubham.r.kusalkar\\Documents\\ShubhamJavaWorkSpace\\SeleniumFramework\\excel\\data.xlsx";
	 * 
	 * testData(excelPath, "Sheet1"); }
	 */
	
	WebDriver driver =null;
	
	@BeforeTest
	public void setUpTest() {
		
		String ProjectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		
			System.setProperty("webdriver.chrome.driver", ProjectPath + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		
	}
	
	
	
	@Test(dataProvider="test1data")
	public void test1(String username,String password) throws InterruptedException {
		
		System.out.println(username+" | "+password);
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		Thread.sleep(2000);
	}
	
	
	
	@DataProvider(name="test1data")
	public Object[][] getData() {
		
		String excelPath = "C:\\Users\\shubham.r.kusalkar\\Documents\\ShubhamJavaWorkSpace\\SeleniumFramework\\excel\\data.xlsx";
		
		Object data[][] = testData(excelPath, "Sheet1");
		return data; 
	}
	
	
	public Object[][] testData(String excelPath, String sheetName) {


		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount= excel.getRowCount();
		int colCount = excel.getColCount();
		
		
		Object data[][] = new Object[rowCount-1][colCount];
		

		for (int i=1;i<rowCount;i++)
		{
			for (int j=0;j<colCount;j++) {

				String cellData = excel.getCellDataString(i, j);

				System.out.print(cellData+" | ");
				
				data[i-1][j] = cellData;
			}

    System.out.println();
		}
		return data;
	}
	

}
