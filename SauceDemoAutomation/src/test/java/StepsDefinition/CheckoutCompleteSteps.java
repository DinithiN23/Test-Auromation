package StepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import saucedemoPages.CheckoutCompletePage;
import utils.DriverManager;

public class CheckoutCompleteSteps {
	
	 private WebDriver driver;
	   
	    
	  @Before
	    public void setUp() {
	        driver = DriverManager.getDriver();
	        //checkoutCompletePage = new CheckoutCompletePage(driver);
	    }
	
	  @Then("I should be on Checkout: complete page")
	  public void i_should_be_on_checkout_complete_page() {
	        
	        // Verify complete text
	        WebElement title = driver.findElement(By.className("title"));
	        Assert.assertTrue("Title is not displayed!",
	        		driver.findElement(By.className("title")).isDisplayed());
	                
	        		// Print a stylized message indicating successful navigation
	        	    String message = "Checkout:Complete Page";
	                int width = 40; // Width of the border line
	                int padding = (width - message.length()) / 2;

	                System.out.println("=".repeat(width));
	                System.out.println(" ".repeat(padding) + message + " ".repeat(padding));
	                System.out.println("=".repeat(width));
	                try {
	                    Thread.sleep(1000); // Wait for 1 seconds
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	             // Capture a screenshot of the login page
	                DriverManager.captureScreenshot("complete_page");
	    }

	  @Then("I click back home button")
	  public void i_click_back_home_button() {
	        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
	        backHomeButton.click();
	        try {
	            Thread.sleep(1000); // Wait for 1 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }     
	    }
	  
	  @Then("I should be on Product page again")
	  public void i_should_be_on_product_page_again() {
		  WebElement productsTitle = driver.findElement(By.className("title"));
		    Assert.assertTrue("Products page title not displayed", productsTitle.isDisplayed());
		    Assert.assertEquals("Products", productsTitle.getText());
		    try {
		        Thread.sleep(1000); // Wait for 1 seconds
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
	  }	  
}



