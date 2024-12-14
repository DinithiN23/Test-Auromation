package StepsDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import saucedemoPages.ProductPage;
import utils.DriverManager;

public class ProductSteps {
	
	private WebDriver driver;
	private ProductPage productPage;
	
	// Constants for product IDs
	private static final String ITEM_1 = "add-to-cart-sauce-labs-bolt-t-shirt"; 
    private static final String ITEM_2 = "add-to-cart-test.allthethings()-t-shirt-(red)";

    @Before
    public void setup() {
        driver = DriverManager.getDriver();
        productPage = new ProductPage(driver);     
    }
	
	@Given("I am on the Products page")
    public void i_am_on_products_page() {
		 // Verify the Products page title is displayed
		Assert.assertTrue("Title is not displayed!",
		driver.findElement(By.className("title")).isDisplayed());
        
		// Print a stylized message indicating successful navigation
		String message = "Product Page";
		int width = 40; // Width of the border line
		int padding = (width - message.length()) / 2;

		System.out.println("=".repeat(width));
		System.out.println(" ".repeat(padding) + message + " ".repeat(padding));
		System.out.println("=".repeat(width));
		
		// Capture a screenshot of the login page
        DriverManager.captureScreenshot("Product_page");
	}
	
	@When("I add following items to cart")
	public void i_add_following_items_to_cart() {
		 // Add the first item to the cart
		productPage.addItemToCart(ITEM_1);
		System.out.println("Added item 1: Sauce Labs Bolt T-Shirt");
		try {
	        Thread.sleep(1000); // Wait for 2 seconds
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

		//scroll command
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollTo({ top: window.scrollY + 500, behavior: 'smooth' })");  //Scroll Down
		   
		   try {
		        Thread.sleep(1000); // Wait for 2 seconds
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		    
		  
		 // Add the second item to the cart
	    productPage.addItemToCart(ITEM_2);
	    System.out.println("Added item 2: Test.AllTheThings() T-Shirt (Red)");
	    
	    // Scroll back up by 500 pixels
	    js.executeScript("window.scrollTo({ top: window.scrollY - 500, behavior: 'smooth' })"); // Scroll up
		   
		   try {
		        Thread.sleep(1000); // Wait for 2 seconds
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		        
	    //Wait for the inventory list to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.visibilityOf(productPage.getInventoryList()));
	}

	//Click on the cart button to proceed to the cart page
	@When("I click the cart button")
	public void i_click_the_cart_button() {
		productPage.clickCartButton();	
	    
	}	 
}

