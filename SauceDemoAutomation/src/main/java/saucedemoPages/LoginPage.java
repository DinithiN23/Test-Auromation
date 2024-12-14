package saucedemoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
		private WebDriver driver;

		//Locators for user name, password, and login button
	    @FindBy(id = "user-name")  
	    private WebElement usernameInput;

	    @FindBy(id = "password") 
	    private WebElement passwordInput;

	    @FindBy(id = "login-button")
	    private WebElement loginButton;
	  
	    //Constructor to initialize elements and set up explicit wait.
	    public LoginPage(WebDriver driver) {
	    	if (driver == null) {
	            throw new IllegalArgumentException("WebDriver cannot be null");
	    	}
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    	//Navigates to the login page
	    public void navigateToLoginPage() {
	        driver.get("https://www.saucedemo.com/");
	    }
	    
	    //Enter the user name
	    public void usernameInput(String username) {
	    	usernameInput.clear();
	    	usernameInput.sendKeys(username);
	    	//System.out.println("Username entered: " + username);	    	
	    }

	    	//Enter the password
	    public void passwordInput(String password) {
	    	passwordInput.clear();
	    	passwordInput.sendKeys(password);
	    	//System.out.println("Password entered: " + password);
	    }

	    //Click Login button
	    public void clickLoginButton() {
	        loginButton.click();
	        System.out.println("Login button clicked.");
	    }
}


