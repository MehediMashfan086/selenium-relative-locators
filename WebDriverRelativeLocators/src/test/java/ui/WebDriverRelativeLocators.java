package ui;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverRelativeLocators {
	public static String browser = "firefox";
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("https://www.saucedemo.com/v1/");
		By userNameLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
		driver.findElement(userNameLocator).sendKeys("standard_user");
		
		By passwordLocator = RelativeLocator.with(By.tagName("input")).below(userNameLocator);
		driver.findElement(passwordLocator).sendKeys("secret_sauce");
		
		By LoginButtonLocator = RelativeLocator.with(By.tagName("input")).below(passwordLocator);
		driver.findElement(LoginButtonLocator).click();
		
		Thread.sleep(Duration.ofMillis(2000));
		driver.close();


	}

}
