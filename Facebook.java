package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch URL
		driver.get("https://en-gb.facebook.com/");

		// click create new account
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

		// Entering Details
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Martin");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Francis");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9999999999");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Password01");

		// DOB
		WebElement day = driver.findElement(By.id("day"));
		Select daydrop = new Select(day);
		daydrop.selectByIndex(25);

		WebElement month = driver.findElement(By.id("month"));
		Select monthdrop = new Select(month);
		monthdrop.selectByValue("10");

		WebElement year = driver.findElement(By.id("year"));
		Select yeardrop = new Select(year);
		yeardrop.selectByVisibleText("1987");

		// RadioButton (Female)
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();

		/*
		 * //RadioButton (male)
		 * driver.findElement(By.xpath("//label[text()='Male']/following-sibling::input"
		 * )).click();
		 */
	}

}