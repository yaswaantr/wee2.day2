package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Launch URL
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");

		// Capturing Details
		driver.findElement(By.name("UserFirstName")).sendKeys("Jane");
		driver.findElement(By.name("UserLastName")).sendKeys("Rycraft");
		driver.findElement(By.name("UserEmail")).sendKeys("jane.rycraft@rbs.co.uk");

		WebElement jobTitle = driver.findElement(By.name("UserTitle"));
		Select jobTitleDrop = new Select(jobTitle);
		jobTitleDrop.selectByVisibleText("IT Manager");

		driver.findElement(By.name("CompanyName")).sendKeys("Royal Bank of Scotland");

		WebElement employees = driver.findElement(By.name("CompanyEmployees"));
		Select employeeDrop = new Select(employees);
		employeeDrop.selectByValue("1600");

		driver.findElement(By.name("UserPhone")).sendKeys("+449876543210");

		WebElement country = driver.findElement(By.name("CompanyCountry"));
		Select countryDropSelect = new Select(country);
		countryDropSelect.selectByVisibleText("United Kingdom");

		driver.findElement(By.name("CompanyCountry")).sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//input[@id='SubscriptionAgreement']/following-sibling::div")).click();

		Thread.sleep(2000);
		
		driver.close();

		/*
		 * WebElement chkBox = driver.findElement(By.xpath(
		 * "//input[@id='SubscriptionAgreement']/following-sibling::div"));
		 * System.out.println("The checkbox is selection state is - " +
		 * chkBox.isDisplayed()); if (chkBox.isDisplayed() == true) { chkBox.click();
		 */

		/*
		 * WebElement chkBox = driver.findElement(By.xpath(
		 * "//input[@id='SubscriptionAgreement']/following-sibling::div"));
		 * System.out.println("The checkbox is selection state is - " +
		 * chkBox.isSelected()); if (chkBox.isSelected()==false) { chkBox.click(); }
		 */

	}

}