package StepsDefinition;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import utils.DriverManager;

public class Hooks {
	
	 @Before
	    public void setup() {
	        //setup timeout
	        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	    }

	    @After
	    public void tearDown(Scenario scenario) {
	        if (scenario.isFailed()) {
	        	//capture and attach screenshot if the scenario fails.
	            final byte[] screenshots = ((TakesScreenshot) DriverManager.getDriver())
	                .getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshots, "image/png", "Failed Screenshot");
	        }
	        //Quit WebDriver instance.
	        DriverManager.quitDriver();
	    }

}
