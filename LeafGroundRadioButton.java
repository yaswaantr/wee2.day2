package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundRadioButton {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Get URL
		driver.get("http://leafground.com/pages/radio.html");

		// Are you enjoying the class
		driver.findElement(By.xpath("//input[@id='yes']")).click();

		// Find default selected radio button
		WebElement radio = driver.findElement(By.xpath("(//input[@value='1'])[2]"));
		WebElement radio1 = driver.findElement(By.xpath("(//input[@value='0'])[2]"));
		if (radio.isSelected()) {
			System.out.println("Checked Radio Button is selected by Default");
		} else if (radio1.isSelected()) {
			System.out.println("Unchecked Radio Button is selected by Default");
		}

		// Select your age group (Only if choice wasn't selected)
		int Age = 20;

		if (Age <= 20) {
			driver.findElement(By.xpath("(//input[@value=0])[3]")).click();
		} else if (Age > 40) {
			driver.findElement(By.xpath("//input[@value='2']")).click();
		}
	driver.close();
	}
}
