package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

	 private static  WebDriver driver;
	 
	  public static WebDriver getDriver() {
		  
	        if (driver == null) {	            
	        	 ChromeOptions options = new ChromeOptions();
	        	 options.addArguments("--start-maximized");
	        	 options.addArguments("--remote-allow-origins=*");
	        	 
	        	 //Initialize driver with chromeOptions
	             driver = new ChromeDriver();
	             driver.manage().window().maximize();
	             driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	         } 
	        
	        return driver;
	  }
	  
	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	            String message = "WebDriver has been quit.";
	            int width = 40; // Width of the border line
	            int padding = (width - message.length()) / 2;

	            System.out.println("=".repeat(width));
	            System.out.println(" ".repeat(padding) + message + " ".repeat(padding));
	            System.out.println("=".repeat(width));

	        }
	    }
	    
	    // Screenshot utility method
	    public static void captureScreenshot(String stepName) {
	        try {
	            File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	            File destination = new File("screenshots/" + stepName + ".png"); // Save in the "screenshots" folder
	            FileUtils.copyFile(screenshot, destination);
	            System.out.println("Screenshot saved: " + destination.getAbsolutePath());
	        } catch (IOException e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	        }
	    }
	}