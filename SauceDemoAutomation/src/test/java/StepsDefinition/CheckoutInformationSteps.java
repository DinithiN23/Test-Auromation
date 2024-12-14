package StepsDefinition;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import saucedemoPages.CartPage;
import saucedemoPages.CheckoutInformationPage;
import utils.DriverManager;

public class CheckoutInformationSteps {
	
	
	private WebDriver driver;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        checkoutInformationPage = new CheckoutInformationPage(driver);
    }
	
	@Then("I should be on the checkout:your information page")
	public void i_should_be_on_the_checkout_your_information_page() {
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		Assert.assertTrue("Title is not displayed!",
				driver.findElement(By.className("title")).isDisplayed());
		        
				// Print a stylized message indicating successful navigation
			    String message = "Checkout : Your Infromation";
		        int width = 40; // Width of the border line
		        int padding = (width - message.length()) / 2;

		        System.out.println("=".repeat(width));
		        System.out.println(" ".repeat(padding) + message + " ".repeat(padding));
		        System.out.println("=".repeat(width));
	}

	@Then("I enter customer information")
	public void i_enter_customer_information(io.cucumber.datatable.DataTable dataTable) {	
	   List<Map<String, String>> data = dataTable.asMaps(String.class,String.class);
	   for(Map<String,String> customerInfo : data) {
		   
		   String firstNameInput = customerInfo.get("FirstName");
		   driver.findElement(By.id("first-name")).clear();
		   
		   String lastNameInput=customerInfo.get("LastName");
		   driver.findElement(By.id("last-name")).clear();
		   
		   String postalCodeInput =customerInfo.get("ZipCode");
		   driver.findElement(By.id("postal-code")).clear();
		   
		   try {
		        Thread.sleep(1000); // Wait for 2 seconds
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }

		   
		// Fill customer information using the Page Object
		   checkoutInformationPage.enterCustomerInformation(firstNameInput, lastNameInput, postalCodeInput);
		// Capture a screenshot of the login page
	        DriverManager.captureScreenshot("Info_page");
	   }
	}
	   
	@And("I click continue")
	public void i_click_continue() {
		checkoutInformationPage.clickContinue();
	   
	}

	

	

}
