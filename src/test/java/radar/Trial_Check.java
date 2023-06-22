package radar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Trial_Check {
	WebDriver driver;
	String[][] clear = { { "sivskumar@gmail.com", "freddy@gmail.com" }, { "xyz@gmail.com", "1234567" },
			{ "dreffety@gmail.com", "1234567" } };

	@BeforeSuite
	public void browser_launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		String path = System.getProperty("C:\\Users\\FleetStudio-19\\Desktop");
		try {
			FileInputStream fir = new FileInputStream(path);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "data", invocationCount = 10)
	public void freddy(String name, String number) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login&language=en-gb");
		WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
		email.sendKeys(name);
		WebElement pass = driver.findElement(By.xpath("//input[@id='input-password']"));
		pass.sendKeys(number);
		Workbook wb = new XSSFWorkbook();

	}

	@DataProvider
	public String[][] data() {
		return clear;
	}


	@AfterSuite
	public void quitingbrowser() {
		driver.quit();
	}

}
