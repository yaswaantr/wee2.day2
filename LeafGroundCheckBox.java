package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBox {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Get URL
		driver.get("http://leafground.com/pages/checkbox.html");

		// Select the languages that you know?
		driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();

		// Confirm Selenium is checked
		WebElement selenium = driver.findElement(By.xpath("(//input[@type='checkbox'])[6]"));

		if (selenium.isSelected()) {
			System.out.println("Selenium Checkbox is selected");
		} else {
			System.out.println("Selenium Checkbox is not selected");
		}

		// DeSelect only checked
		WebElement deSelect = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		deSelect.sendKeys(Keys.SPACE);

		// Select all below checkboxes
		driver.findElement(By.xpath("(//input[@type='checkbox'])[9]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[10]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[11]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[12]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[13]")).click();
		driver.close();
	}

}
