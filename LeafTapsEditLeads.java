package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafTapsEditLeads {

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

		// Enter First Name
		driver.findElement(By.xpath("//input[@id='ext-gen248']")).sendKeys("Hari");

		// click of find lead
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		// click on first resulting lead
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

		// verify title of resulting page & click edit
		String pageTitle = driver.getTitle();
		if (pageTitle.contentEquals("View Lead | opentaps CRM")) {
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
		} else {
			System.out.println("Title does not matches hence edit button is not clicked");
		}

		// Change Company name
		WebElement oldName = driver.findElement(By.id("updateLeadForm_companyName"));
		System.out.println("Current Comany Name is : " + oldName.getAttribute("value"));
		oldName.clear();
		oldName.sendKeys("SSS Bank");
		//driver.findElement(By.id("updateLeadForm_companyName")).clear();
		//driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Hello");

		// Click on Update button
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		// verify company name is updated
		WebElement name = driver.findElement(By.id("viewLead_companyName_sp"));
		String companyName = name.getText();
		String cn = companyName.replaceAll("[\\d, ()]", " ");
		System.out.println("The updated company name is: " + cn);

		driver.close();
	}

}
