package assignments.week5.day1.assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseServiceIncidentClass {
	public ChromeDriver driver;
	public static String incidentNumber;
	
	@BeforeMethod
	public void preCondition() {
		
		System.out.println("Launch ServiceNow application");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev60180.service-now.com/navpage.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Login with valid credentials
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("SelTesting1!");
		driver.findElement(By.id("sysverb_login")).click();
		

		// Enter Incident in filter navigator and press enter
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.id("filter")).sendKeys(Keys.ENTER);
		

	}
	
	@AfterMethod
	public void postCondition() {
		System.out.println("Closing ServiceNow application");
		driver.close();

	}
	
	
	
	

}
