package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch URL
		driver.get("http://leafground.com/pages/Edit.html");

		// Enter your email id
		driver.findElement(By.id("email")).sendKeys("test@testleaf.com");

		// Append a text and press keyboard tab
		WebElement append = driver.findElement(By.xpath("//input[@value='Append ']"));
		append.click();
		append.sendKeys("Hello", Keys.TAB);
		

		// Get default text entered
		WebElement clear = driver.findElement(By.xpath("(//input[@name='username'])[1]"));
		System.out.println("The default text entered is : " + clear.getAttribute("value"));

		// clear text
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();

		// Confirm that edit field is disabled
		WebElement display = driver.findElement(By.xpath("//input[@disabled='true']"));
		if (display.isEnabled() == false) {
			System.out.println("Edit field is disabled");
		} else {
			System.out.println("Edit filed is not disabled");
		}
		driver.close();
	}

}
