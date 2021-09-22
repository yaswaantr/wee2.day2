package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImage {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Get URL
		driver.get("http://leafground.com/pages/Image.html");

		// click on the image to go home driver.findElement(By.xpath(
		driver.findElement(By.xpath("//label[text() = 'Click on this image to go home page']/following-sibling::img"))
				.click();

		driver.findElement(By.xpath("//h5[text()='Image']")).click();

		// Am I broken
		// WebElement image2 = driver.findElement(By.xpath("//label[text() = 'Click on
		// this image to go home page']/following-sibling::img"));
		WebElement image2 = driver
				.findElement(By.xpath("//label[text() = 'Am I Broken Image?']/following-sibling::img"));
		// String imgURL = image2.getAttribute("src");

		try {
			boolean imageDisplayed = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);",
					image2);
			if (imageDisplayed) {
				System.out.println("Image is not Broken");
			} else {
				System.out.println("Image is Broken");
			}
		} catch (Exception e) {
			System.out.println("Error Occured");
		}

		// Clicking using keyboard
		Actions a = new Actions(driver);
		a.moveToElement(driver
				.findElement(By.xpath("//label[text() = 'Click me using Keyboard or Mouse']/following-sibling::img")))
				.click().build().perform();

		driver.close();
	}
	
}