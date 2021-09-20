package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch URL
		driver.get("https://www.opencart.com/index.php?route=account/register");

		// Fill in Form
		driver.findElement(By.id("input-username")).sendKeys("Testerabc");
		driver.findElement(By.id("input-firstname")).sendKeys("Tester");
		driver.findElement(By.id("input-lastname")).sendKeys("abc");
		driver.findElement(By.id("input-email")).sendKeys("testerabc@xyz.com");

		WebElement country = driver.findElement(By.id("input-country"));
		Select countryDrop = new Select(country);
		countryDrop.selectByIndex(9);

		driver.findElement(By.id("input-password")).sendKeys("testerabc");
	
	}

}
