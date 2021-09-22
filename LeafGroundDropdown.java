package week2.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropdown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Get URL
		driver.get("http://leafground.com/pages/Dropdown.html");

		// by Index
		WebElement dropOne = driver.findElement(By.id("dropdown1"));
		Select dropOneList = new Select(dropOne);
		dropOneList.selectByIndex(3);

		// by text
		WebElement dropTwo = driver.findElement(By.name("dropdown2"));
		Select dropTwoList = new Select(dropTwo);
		dropTwoList.selectByVisibleText("Selenium");

		// by value
		WebElement dropThree = driver.findElement(By.id("dropdown3"));
		Select dropThreeList = new Select(dropThree);
		dropThreeList.selectByValue("4");

		// no of count
		Select count = new Select(driver.findElement(By.className("dropdown")));
		List<WebElement> countOne = count.getOptions();
		System.out.println("No of options is : " + (countOne.size() - 1));

		// send keys to select
		driver.findElement(By.xpath("//div[@class='example'][5]/select")).sendKeys("UFT/QTP");

		// select ur option
		WebElement option = driver.findElement(By.xpath("//div[@class='example'][6]/select"));
		Select optionList = new Select(option);
		optionList.selectByVisibleText("Appium");
		optionList.selectByVisibleText("Selenium");
		optionList.selectByVisibleText("Loadrunner");

		driver.close();
	}

}
