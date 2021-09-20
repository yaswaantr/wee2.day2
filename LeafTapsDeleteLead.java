package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsDeleteLead {

	public static void main(String[] args) throws InterruptedException {

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

		// Click on Leads Tab
		driver.findElement(By.linkText("Leads")).click();

		// Click on Find Leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		// Enter Phone Number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876");

		// Click on Find Leads Button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// Get First Lead ID WebElement leadId =
		Thread.sleep(2000);
		WebElement leadId = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String str = leadId.getAttribute("href");
		String number = str.replaceAll("[\\D]", "");
		System.out.println("First Lead ID is: " + number);

		// click on first Lead ID:
		leadId.click();

		// Delete the entry
		driver.findElement(By.xpath("//a[text() = 'Delete']")).click();

		// Click Find Leads:
		driver.findElement(By.xpath("//a[text() = 'Find Leads']")).click();

		// Enter captured Id
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(number);

		// Find the lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// No records to display
		WebElement norecords = driver.findElement(By.xpath("//div[text()='No records to display']"));
		if (norecords.isDisplayed() == true) {
			System.out.println("Lead Id " + number + " is deleted successfully");
		}
		driver.close();
	}
}
