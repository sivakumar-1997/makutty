package radar;


	import static io.restassured.RestAssured.given;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.net.HttpURLConnection;
	import java.net.MalformedURLException;
	import java.net.URI;
	import java.net.URL;
	import java.time.Duration;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;
	import javax.swing.GroupLayout.Alignment;
	import org.apache.poi.sl.usermodel.VerticalAlignment;
	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.CellType;
	import org.apache.poi.ss.usermodel.HorizontalAlignment;
	//import org.apache.poi.xssf.usermodel.XSSFCell;
	//import org.apache.poi.xssf.usermodel.XSSFRow;
	//import org.apache.poi.xssf.usermodel.XSSFSheet;
	//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Cookie;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import io.github.bonigarcia.wdm.WebDriverManager;
	public class Fret {
		@Test
		public void sectionCreate() throws InterruptedException {
			String homePage = "https://live-deepa91657161909.pantheonsite.io/";
			String url = "";
			HttpURLConnection huc = null;
			int respCode = 200;
			WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver",
			// "/Users/fleetstudiotechnologies/Documents/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(homePage);
			driver.findElement(By.xpath("//a[normalize-space()='Log in']")).click();
			driver.findElement(By.xpath("//*[@id=\"edit-name\"]")).sendKeys("hpawar+sa@fleetstudio.com");
			driver.findElement(By.xpath("//input[@id='edit-pass']")).sendKeys("Hanmant@369");
			driver.findElement(By.xpath("//*[@class='cc_btn cc_btn_accept_all']")).click();
			driver.findElement(By.xpath("//input[@id='edit-submit']")).click();
			driver.findElement(By.xpath("//a[normalize-space()='Dashboard']")).click();
			Thread.sleep(3000);
			
			
			// get text of element and print
			// List<WebElement> allURLs =
			// driver.findElements(By.xpath("//div[@class='claro-details__wrapper
			// details-wrapper']//a"));
			
			List<WebElement> create_menu = driver
					.findElements(By.xpath("(//li[@class='menu-item menu-item--expanded'])[2]//a"));
			System.out.println("Total links on the Wb Page: " + create_menu.size());
			System.out.println("----Left Side Menu Links  1--");
			for (WebElement create_links : create_menu) {
				System.out.println(create_links.getAttribute("href"));
			}
			WebElement create_menu_bar= driver.findElement(By.xpath("//span[@class='top-level create-page']"));
			Actions ac = new Actions(driver);
			ac.moveToElement(create_menu_bar).build().perform();
			Thread.sleep(3000);
			
			List<WebElement> Section1 = driver.findElements(By.xpath(
			"//details[@id='block-claro-createcontent']//div[@class='claro-details__wrapper details-wrapper']//a"));
			System.out.println("Total links on the Wb Page: " + Section1.size());
			for (WebElement links : Section1) {
				System.out.println(links.getAttribute("href"));
			}
			
			/* compare  both Links here */
			
			System.out.println("--Checking Both Links Are Same Or Not--");
			if(create_menu.size()!=Section1.size()) {
				System.out.println("The Link Size Are Not Matching");
			}else {
				for(int i=0;i<create_menu.size();i++) {
					String list1=create_menu.get(i).getAttribute("href");
					System.out.println(" Left side Menu bar : " +list1);
					String list2=Section1.get(i).getAttribute("href");
					System.out.println(" Dashboard Links :" +list2);
					if(!list1.equals(list2)) {
						System.out.println("Both Links Are Not Equals");
						break;
					}
				}
				System.out.println("All Links are Equals");
			}
			
			
			for (int i = 0; i < Section1.size(); i++) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				// WebDriverWait wait = new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.elementToBeClickable(Section1.get(i)));
				url = Section1.get(i).getAttribute("href");
				if (url == null || url.isEmpty()) {
					System.out.println("URL is either not configured for anchor tag or it is empty");
					continue;
				}
				if (!url.startsWith(homePage)) {
					System.out.println("URL belongs to another domain, skipping it.");
					continue;
				}
				try {
					huc = (HttpURLConnection) (new URL(url).openConnection());
					huc.setRequestMethod("HEAD");
					huc.connect();
					respCode = huc.getResponseCode();
					System.out.println("Response code here "+huc.getResponseCode());
					if (respCode >= 400) {
						System.out.println(url + " is a broken link");
					} else {
						System.out.println(url + " is a valid link");
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", Section1.get(i));
				Thread.sleep(3000);
				try {
					String s = driver.findElement(By.xpath("//h1[1]")).getText();
					if (s == "Access Denied") {
						System.out.println("Access Denied- Notworking");
						driver.navigate().back();
					} else {
						System.out.println("Page Access is provided");
						driver.navigate().back();
					}
				} catch (Exception e) {
					System.out.println("Page Access is provided but no H1 tag");
					driver.navigate().back();
				}
			}
			
			
		}
	}