package saucedemoPages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	//Locators for WebElements
	 @FindBy(id = "checkout")
	 private WebElement checkoutButton;
	 
	 @FindBy(className = "cart_item")
	    private List<WebElement> cartItems;
	 
	//Constructor to initialize elements and set up explicit wait.
	 public CartPage(WebDriver driver) {
		 this.driver = driver;
		 this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 PageFactory.initElements(driver, this);
	 }
	 
	 //Click CheckoutButton
	 public void clickCheckoutButton() {
		// wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
	     checkoutButton.click();
	    }
	 
	  //Verify if on the cart page
	 public boolean isCartPage() {
	        return driver.getCurrentUrl().contains("/cart.html");
	    }
	 
	 //Get the count of items in the cart
	    public int getCartItemCount() {
	    	wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
	        return cartItems.size();
	    }

	 // Check if the cart is empty
	    public boolean isCartEmpty() {
	    	return getCartItemCount() == 0;
	    }
}
