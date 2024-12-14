package StepsDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import saucedemoPages.CheckOutOverViewPage;
import saucedemoPages.CheckoutInformationPage;
import utils.DriverManager;

public class CheckOutOverViewSteps {
	
	private WebDriver driver;
	private WebDriverWait wait;
	 private CheckOutOverViewPage OverViewpage;

	    @Before
	    public void setUp() {
	        driver = DriverManager.getDriver();
	       OverViewpage = new CheckOutOverViewPage(driver);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	
	
	
	    @Then("I should be on Checkout :overview page")
	    public void i_should_be_on_checkout_overview_page() {
	    	WebElement title = driver.findElement(By.xpath("//span[@class='title']"));
	    	Assert.assertTrue("Title is not displayed!",
	    			driver.findElement(By.className("title")).isDisplayed());
	    	        
	    			// Print a stylized message indicating successful navigation
	    		    String message = "Checkout:Overview Page";
	    	        int width = 40; // Width of the border line
	    	        int padding = (width - message.length()) / 2;

	    	        System.out.println("=".repeat(width));
	    	        System.out.println(" ".repeat(padding) + message + " ".repeat(padding));
	    	        System.out.println("=".repeat(width));
	    	        
	    	        try {
	    	            Thread.sleep(1000); // Wait for 2 seconds
	    	        } catch (InterruptedException e) {
	    	            e.printStackTrace();
	    	        }  	            	 
	}
	    
	
	    
	    @Then("I click finish button")
	    public void i_click_finish_button() {
	    	  //scroll command
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("window.scrollTo({ top: window.scrollY - 500, behavior: 'smooth' })");
			   try {
			        Thread.sleep(1000); // Wait for 2 seconds
			    } catch (InterruptedException e) {
			        e.printStackTrace();
			    }
			    
	    	 OverViewpage.clickfinish();
	}
}


