package radar;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static io.restassured.RestAssured.given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.bytebuddy.NamingStrategy.Suffixing.BaseNameResolver.ForGivenType;

public class Maragatham {
	public WebDriver driver;

	@Test()
	public void reddy() {
		 WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			//login 
			driver.get("https://live-deepa91657161909.pantheonsite.io/user/login?destination=/user/login");
			WebElement w1 = driver.findElement(By.xpath("//input[@id='edit-name']"));
			w1.sendKeys("hpawar+sa@fleetstudio.com");
			WebElement w2 = driver.findElement(By.xpath("//input[@id='edit-pass']"));
			w2.sendKeys("Hanmant@369");
			//popup
			driver.findElement(By.xpath("//button[text()='Got it!']")).click();
			WebDriverWait wd = new WebDriverWait(driver,Duration.ofSeconds(20));
			//submit button
			wd.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='edit-submit']")));
			WebElement w3 = driver.findElement(By.xpath("//input[@id='edit-submit']"));
			w3.click();
			//bread crumb click
			driver.findElement(By.xpath("//a[@class='top-level dashboard']")).click();
			//"manage" all items 
			List<WebElement> findElements = driver.findElements(By.xpath("//details[@id='block-claro-storemanagement']//ul"));
			for (WebElement webElement : findElements) {
				System.out.println(webElement.getText());
			}	
			System.out.println(findElements.size());
			for(int i = 1;i<=findElements.size();i++) {
				for(int j=1;j<=i;j++) {
					driver.findElement(By.xpath("//details[@id='block-claro-storemanagement']//ul/li["+j+"]")).click();
					String s = driver.getCurrentUrl();
					System.out.println(s);
					ValidatableResponse statusCode = given().when().get(s).then().statusCode(403);
				System.out.println(statusCode);
				}
				WebDriverWait wd1 = new WebDriverWait(driver,Duration.ofSeconds(20));
				wd1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Dashboard' and @class='breadcrumb__link']")));
				driver.findElement(By.xpath("//a[text()='Dashboard' and @class='breadcrumb__link']")).click();
			}
}
}
