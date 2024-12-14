package saucedemoPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CheckOutOverViewPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(id="finish")
	private WebElement finishButton;
	
	
	public CheckOutOverViewPage(WebDriver driver) {
		this.driver=driver;
        PageFactory.initElements(driver, this);
    }
	
	
	public void clickfinish() {
		finishButton.click();
    }
	

}
