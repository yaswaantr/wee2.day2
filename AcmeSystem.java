package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSystem {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch URL
		driver.get("https://acme-test.uipath.com/login");

		// Login Details:
		driver.findElement(By.name("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.name("password")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// get title of the page and print
		String pageTitle = driver.getTitle();
		System.out.println("Title of the page is: " + pageTitle);

		// Logout
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();

		driver.close();

	}

}
