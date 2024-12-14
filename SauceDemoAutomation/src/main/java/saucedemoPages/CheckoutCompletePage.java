package saucedemoPages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage {
	
	private WebDriver driver;

	//Locators for WebElements
    @FindBy(className = "title")
    private WebElement completetitle;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;
    
    @FindBy (className = "title")
    private WebElement displayproductpage;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Click Home Page Button
    public void clickBackHomeButton() {
        backHomeButton.click();
    }
    
    //Display Product Page 
    public void displayproductppage() {
    	displayproductpage.click();
    }   
}


