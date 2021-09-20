package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsDuplicateLead {

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

		// Click on Leads Tab
		driver.findElement(By.linkText("Leads")).click();

		// Click on Find Leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

		// Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

		// capture the email
		driver.findElement(By.name("emailAddress")).sendKeys("abc");

		// click on find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// capturing name of first lead
		WebElement firstName = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]"));
		System.out.println("First Name of First Lead is : " + firstName.getText());
		String fn = firstName.getText();
		WebElement lastName = driver
				.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a)[1]"));
		System.out.println("Last Name of First Lead is : " + lastName.getText());
		String ln = lastName.getText();

		// click on first lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-lastName']/a)[1]")).click();

		// Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();

		// Verify title as duplicate lead & click new lead
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals("Duplicate Lead | opentaps CRM")) {
			driver.findElement(By.name("submitButton")).click();
		} else {
			System.out.println("Title does not matches hence submit button is not clicked");
		}

		// getting first name
		WebElement dFirstName = driver.findElement(By.id("viewLead_firstName_sp"));
		System.out.println("First Name of Duplicate First Lead is: " + dFirstName.getText());
		String dfn = dFirstName.getText();

		// getting last name
		WebElement dLastName = driver.findElement(By.id("viewLead_lastName_sp"));
		System.out.println("First Name of Duplicate First Lead is: " + dLastName.getText());
		String dln = dLastName.getText();

		// comparing names and printing output
		if (fn.contentEquals(dfn) && (ln.contentEquals(dln))) {
			System.out.println("Both Original and Duplicated Party Names are same");
		} else {
			System.out.println("Both Original and Duplicated Party names are not same");
		}
		driver.close();
	}

}