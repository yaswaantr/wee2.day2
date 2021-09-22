package week2.day2.assignment;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundHyperlinks {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Get URL
		driver.get("http://leafground.com/pages/Link.html");

		// Go to Home Page
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();

		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();

		// Find where am supposed to go without clicking me?
		WebElement webLink2 = driver
				.findElement(By.xpath("//a[text() = 'Find where am supposed to go without clicking me?']"));
		String nav = webLink2.getAttribute("href");
		System.out
				.println("On Clicking Find where am supposed to go without clicking me? Link should be navigated to : "
						+ nav + '\n');

		// Verify am I broken?
		WebElement webLink3 = driver.findElement(By.xpath("//a[text() = 'Verify am I broken?']"));
		String url = webLink3.getAttribute("href");
		verifyLinks(url);

		// Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();

		// How many links are available in this page?
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// List<WebElement> links = driver.findElements(By.xpath("//a"));
		int linkCount = links.size();
		System.out.println("No of Links : " + linkCount);

		driver.close();
	}

	public static void verifyLinks(String url) {

		HttpURLConnection huc = null;

		{
			try

			{

				huc = (HttpURLConnection) (new URL(url).openConnection());

				huc.setRequestMethod("HEAD");

				huc.connect();

				int respCode = huc.getResponseCode();

				System.out.println("response code of " + url + " is :" + respCode);

				if (respCode >= 400) {
					System.out.println(url + " is a broken link" + '\n');
				} else {
					System.out.println(url + " is a valid link" + '\n');
				}

			} catch (Exception e) {
				System.out.println("Error Occured");
			}
		}

	}
}