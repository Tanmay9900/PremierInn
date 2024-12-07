package com.premierinn.automation.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.premierinn.automation.TestComponents.BaseTest;
import com.premierinn.automation.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	 @DataProvider(name = "loginCredentials")
	    public Object[][] loginData() {
	        return new Object[][] {
	            {"tseducation11@gmail.com", "Manisha@11"},
	            {"user2@example.com", "Password123"},
	            {"user3@example.com", "Pass@456"}
	        };
	    }
	
	
	@Test(dataProvider="loginCredentials" ,threadPoolSize = 3)
	public  void LoginTest1(String email, String password) throws InterruptedException {
		
		
		
		driver.get("https://www.premierinn.com/gb/en/home.html");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.UserSignIn(email,password);
		Thread.sleep(5000);

	}

	@Test
	public void CreateAccountTest() {
		driver.manage().window().maximize();
		ChromeOptions options = new ChromeOptions();
       
        options.setAcceptInsecureCerts(true);
		driver.get("https://www.premierinn.com/gb/en/home.html");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.CreateAnAccount(0,
				"Tanmay",
				"Sonar", 
				"tseducation11@gmail.com", 
				"Manisha@11", "India",
				"LU5 5XE");
		
	}
	
	
	
}
