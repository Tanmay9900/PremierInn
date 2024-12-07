package com.premierinn.automation.TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class BaseTest {
	 public WebDriver driver;
	 
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(options); // Initialize Chrome browser
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(); // Initialize Firefox browser
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver(); // Initialize Edge browser
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser); // Handle invalid browsers
        }

        driver.manage().window().maximize(); // Maximize the browser window
    }
	@AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser and clean up resources
        }
    }
}
