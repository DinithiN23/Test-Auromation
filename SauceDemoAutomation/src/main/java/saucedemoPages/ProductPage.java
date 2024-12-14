package saucedemoPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProductPage {
	
	private WebDriver driver;
	
	//Locators for WebElements
	@FindBy(className = "inventory_list")
    private WebElement inventoryList;
	
	@FindBy(className = "shopping-cart-badge")  
    private WebElement shopping_cart_link;	
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
	private WebElement boltTShirtButton;	
	
	@FindBy(xpath = "//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")
	private WebElement addToCartBoltTShirt;
	 
	@FindBy(id = "shopping_cart_container")
	private WebElement cartButton;

	//Constructor to initialize elements and set up explicit wait.
	 public ProductPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 //get inventory list
	 public WebElement getInventoryList() {
		    return inventoryList;
		}
	     
	 //add Item to cart
	public void addItemToCart(String itemId) {
		
		//Add an item to the cart using explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement addToCartButton =wait.until(ExpectedConditions.elementToBeClickable(By.id(itemId)));
        addToCartButton.click();  
	}
	  
	//Click Cart Button
	public void clickCartButton() {
		cartButton.click();
        System.out.println("Navigated to the cart");
	} 
}
