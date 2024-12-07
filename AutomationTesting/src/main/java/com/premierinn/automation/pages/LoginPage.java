package com.premierinn.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.premierinn.autoamtion.resuableComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//button[contains(@id,'log-in')]")
	WebElement loginButton;
	
	@FindBy(css="#email-input")
	WebElement loginemailInput;
	
	@FindBy(xpath=("//input[@id='password-input']"))
	WebElement passInput;
	
	@FindBy(xpath="//button[contains(@id,'submit-button')]")
	WebElement loginSubmit;
	
	@FindBy(css="a[id='sign-up']")
	WebElement signUplink;
	
	@FindBy(css="button[class*='menu-button css-1t34l1j']")
	WebElement titleclick;
	
	@FindBy(xpath="//input[contains(@id,'firstName')]")
	WebElement firstNameInput;
	
	
	@FindBy(xpath="//input[contains(@id,'lastName')]")
	WebElement lastNameInput;
	
	
	@FindBy(xpath="//input[contains(@id,'email')]")
	WebElement emailInput;
	
	@FindBy(xpath="//input[contains(@id,'password')]")
	WebElement password;
	
	@FindBy(xpath="//input[contains(@id,'confirmPassword')]")
	WebElement confpassword;
	
	@FindBy(css="div[class*='chakra-input__left-element css-13yevo']")
	WebElement phncCountryid;
	
	@FindBy(css=".chakra-input.css-cof57q")
	WebElement searchCountry;

	@FindBy(xpath="//span[text()='India']")
	WebElement selectPhnCountry;
	
	//LU5 5XE
	@FindBy(css="input[id='postcodeAddress']")
	WebElement selectPinCode;
	
	@FindBy(xpath="(//span[@class='chakra-checkbox__control css-10m01pv'])[1]")
	WebElement checkbox1;
	
	@FindBy(xpath="(//span[@class='chakra-checkbox__control css-10m01pv'])[2]")
	WebElement checkbox2;
	
	
	@FindBy(css="button[type='submit']")
	WebElement createAnAccountbtn;
	
	@FindBy(css="#accept-all-cookies-button")
	WebElement acceptCookies;
	
	@FindBy(css="#pi-notification-permission-popup-deny-btn")
	WebElement notificationDecline;
	
	
	
	public void UserSignIn(String Email,String Password) throws InterruptedException {
		
		//added wait 
		
		WaitUntilElementIsClickable(acceptCookies);
		WaitUntilElementIsClickable(notificationDecline);
		WaitUntilElementIsClickable(loginButton);
		acceptCookies.click();
		notificationDecline.click();
		loginButton.click();
		loginemailInput.sendKeys(Email);
		passInput.sendKeys(Password);
		loginSubmit.click();
		Thread.sleep(5000);
		
	}
public void CreateAnAccount(int titleIdx,String FirstName,String LastName,String Email,String Password,String Country,String PinCode) {
		
		//commonActions
	WaitUntilElementIsClickable(acceptCookies);
	WaitUntilElementIsClickable(notificationDecline);
	WaitUntilElementIsClickable(loginButton);
	acceptCookies.click();
	notificationDecline.click();
	loginButton.click();
	
	//This method Steps
	////
	   signUplink.click();
	   WaitUntilElementIsClickable(titleclick);
	   titleclick.click();
	   Select titleDropdown = new Select(titleclick);
	   titleDropdown.selectByIndex(titleIdx);; 
	    
	  

	    // Fill in the first name, last name, email, password, and confirm password fields
	    firstNameInput.sendKeys(FirstName);
	    lastNameInput.sendKeys(LastName);
	    emailInput.sendKeys(Email);
	    password.sendKeys(Password);
	    confpassword.sendKeys(Password);

	

	    // Handling the Search-and-Click Dropdown (phncCountryid):
	    phncCountryid.click();;  
	    // Type in the country name in the search field
	    searchCountry.sendKeys(Country);
	 // Wait for the country options to load and then click on the desired option
	    WaitUntilVisiblityOfElement(selectPhnCountry);
	    selectPhnCountry.click();

	    // Enter the postal code
	    //LU5 5XE
	    selectPinCode.sendKeys(PinCode);

	    // Click on the checkboxes
	    checkbox1.click();
	    checkbox2.click();

	    // Submit the form
	    createAnAccountbtn.click();
		
	}

	
	
	
	
	
}
