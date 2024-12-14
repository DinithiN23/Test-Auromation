package StepsDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import saucedemoPages.CartPage;
import utils.DriverManager;

public class CartSteps {
	
	private WebDriver driver;
    private CartPage cartPage;

    @Before
    public void setUp() {
        driver = DriverManager.getDriver();
        cartPage = new CartPage(driver);
    }
	
	

	@Then("I should be on the cart page")
	public void i_should_be_on_the_cart_page() {
		WebElement title = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
		Assert.assertTrue("Title is not displayed!",
		driver.findElement(By.className("title")).isDisplayed());
		            
		    			// Print a stylized message indicating successful navigation
		    		    String message = "Your Cart Page";
		    	        int width = 40; // Width of the border line
		    	        int padding = (width - message.length()) / 2;

		    	        System.out.println("=".repeat(width));
		    	        System.out.println(" ".repeat(padding) + message + " ".repeat(padding));
		    	        System.out.println("=".repeat(width));
	}

	@Then("I should see the selected items in cart")
	public void i_should_see_the_selected_items_in_cart() {
		int itemCount = cartPage.getCartItemCount();
        Assert.assertTrue("Cart is empty, no items found!", itemCount > 0);
        System.out.println("Verified that the cart contains " + itemCount + " item(s).");
        try {
            Thread.sleep(2000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
     // Capture a screenshot of the login page
        DriverManager.captureScreenshot("Cart_page");

	    
	}

	@When("I click the Checkout button")
	public void i_click_the_checkout_button() {
		 try {
		        Thread.sleep(3000); // Wait for 3 seconds
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		    
		cartPage.clickCheckoutButton();
		
	    
	}


}
