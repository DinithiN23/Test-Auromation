package saucedemoPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutInformationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Locators for WebElement
	@FindBy(id="first-name")
	private WebElement firstNameInput;
	
	@FindBy(id = "last-name")
	private WebElement lastNameInput;
	
	@FindBy(id = "postal-code")
	private WebElement postalCodeInput;
	
	@FindBy(id="continue")
	private WebElement continueInfoButton;
	
	public CheckoutInformationPage(WebDriver driver) {
		this.driver = driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

	//Enter Customer Details with Explicit time
    public void enterCustomerInformation(String firstName, String lastName, String zipCode) {
    	wait.until(ExpectedConditions.visibilityOf(firstNameInput));
    	firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        
        wait.until(ExpectedConditions.visibilityOf(lastNameInput));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        
        wait.until(ExpectedConditions.visibilityOf(postalCodeInput));
        postalCodeInput.clear();
        postalCodeInput.sendKeys(zipCode);
        
        System.out.println("Customer information entered: " + firstName + " " + lastName + " " + zipCode);
    }

    //Click Continue Button
    public void clickContinue() {
    	continueInfoButton.click();
    }
}
