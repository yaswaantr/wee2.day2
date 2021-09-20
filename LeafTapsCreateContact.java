package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsCreateContact {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		// Initial Login
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		// click CRMSFA Link
		driver.findElement(By.xpath("//div[@id='label']/a")).click();

		// Click on Contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		// Click on Create contract
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();

		// Filling details in create contact
		driver.findElement(By.id("firstNameField")).sendKeys("Claire");
		driver.findElement(By.id("lastNameField")).sendKeys("Brown");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Claire");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Brown");
		driver.findElement(By.id("createContactForm_personalTitle")).sendKeys("Mrs.");
		driver.findElement(By.id("createContactForm_birthDate")).sendKeys("09/30/85");
		driver.findElement(By.id("createContactForm_generalProfTitle")).sendKeys("Mrs. Claire Brown");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("IT Manager");
		driver.findElement(By.id("createContactForm_description")).sendKeys(
				"IT managers are responsible for coordinating, planning, and leading computer-related activities in an organization.");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("clire.brown@test.com");

		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select statedrop = new Select(state);
		statedrop.selectByVisibleText("New York");

		// Submit
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		// Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

		// Editing Form again
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys(
				"IT managers are responsible for coordinating, planning, and leading computer-related activities in an organization.");
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// title of the page
		String pageTitle = driver.getTitle();
		System.out.println("Page Tile is : " + pageTitle);

		// Logout
		driver.findElement(By.xpath("//img[@alt='opentaps CRM']")).click();
		driver.findElement(By.className("decorativeSubmit")).click();

		// close browser
		driver.close();

	}

}
