package StepsDefinition;


import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import saucedemoPages.LoginPage;
import utils.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
	
	private WebDriver driver;
	private LoginPage loginPage; //Page object representing the logic page.
	
	//Default user name and password
	private static final String USERNAME = "standard_user";
    private static final String PASSWORD = "secret_sauce";

    //@Before hook initializes the WebDriver and login page before any scenario
    @Before
    public void setup() {
        driver = DriverManager.getDriver();  //Get WebDriver instance from DriverManager
        loginPage = new LoginPage(driver);	//Initialize the LoginPage object
    }
    
    //step definition for navigating to the login page
	@Given("I am on the Saucedemo login page")
	public void  i_am_on_the_saucedemo_login_page() {
		loginPage.navigateToLoginPage();	
		Assert.assertTrue("Login logo is not displayed!",
		driver.findElement(By.className("login_logo")).isDisplayed());
		
		// Print a stylized message indicating successful navigation
	    String message = "Login SauceDemo";
        int width = 40; // Width of the border line
        int padding = (width - message.length()) / 2;

        System.out.println("=".repeat(width));
        System.out.println(" ".repeat(padding) + message + " ".repeat(padding));
        System.out.println("=".repeat(width));
       
	}

	@When("I login with username {string} and password {string}")
	public void  i_login_with_username_and_password(String string, String string2) {
		loginPage = new LoginPage(driver);
        loginPage.usernameInput(USERNAME); 
        loginPage.passwordInput(PASSWORD);
        try {
            Thread.sleep(1000); // Wait for 1 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     // Capture a screenshot of the login page
        DriverManager.captureScreenshot("login_page");

        loginPage.clickLoginButton();
        System.out.println("Login using : " + USERNAME +  " and password: " + PASSWORD);
		
		}
	
	
}
