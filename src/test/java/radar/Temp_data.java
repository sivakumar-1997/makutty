package radar;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Temp_data {
	public WebDriver driver;
 @Test(priority=1, enabled = false)
 public void data()
 {
	 
	 WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();	
	driver.get("https://app-next.wallyax.com/about-yourself");
	Select sell= new Select(driver.findElement(By.xpath("//select[@id='role']")));
	List<WebElement> findElements = sell.getOptions();
	for (WebElement webElement : findElements) {
		System.out.println(webElement.getText());
	}
	System.out.println("----------------------------------------------");
	Select sell1 = new Select(driver.findElement(By.xpath("//select[@id='domains']")));
	List<WebElement> findElements1 = sell1.getOptions();
	for (WebElement webElement : findElements1) {
		System.out.println(webElement.getText());//ul[@class='country-list ']
	}
	System.out.println("---------------------------");
	WebElement dre = driver.findElement(By.xpath("//div[starts-with(@class,'flag-dropdown')]"));
	dre.click();
	List<WebElement> clear = dre.findElements(By.tagName("li"));
	System.out.println(clear.size());
	for (WebElement webElement : clear) {
		System.out.println(webElement.getText());
		}
 }
	@Test
	public void reddy() {
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
			/*
			 * int r_size =
			 * driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
			 * System.out.println(r_size); int c_size =
			 * driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/th")).size();
			 * System.out.println(c_size); String s =
			 * driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[4]/td[1]")).
			 * getText(); System.out.println(s); for(int r = 2;r<=r_size;r++){ for(int c =
			 * 1;c<=c_size;r++) { String str =
			 * driver.findElement(By.xpath("//table[@id='customers']//tr["+r+"]//td["+c+"]")
			 * ).getText(); System.out.println(str); } }
			 */			
			List<WebElement> findElements = driver.findElements(By.xpath("//table[@id='customers']//tr/td"));
			for (WebElement webElement : findElements) {
				System.out.print(webElement.getText()+ " ");
			}
			/*
			 * for(int i=0;i<=findElements.size();i++) { for(int j=0;j<=1;j++) {
			 * driver.findElements(By.xpath("//table[@id='customers']//tr/td") } }
			 */
	}
	
 
}
