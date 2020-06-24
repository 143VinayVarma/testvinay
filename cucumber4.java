---stepdefinition.java---
package stepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;

public class StepDefinition {
	WebDriver driver;
	public static String result; 
	public static String weights;
	public static String trnsmode;
	@Before
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    	FirefoxBinary firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	firefoxOptions.setProfile(profile);
        driver=new FirefoxDriver(firefoxOptions);
	}
	@Given("^I have navigated to shipping application home page$")
	public void loadUrl(){
		driver.get("https://webapps.tekstac.com/CostCalculation/");	    
		System.out.println("Application is launched");
	}
	@When("^I enter \"(.*)\" and select \"(.*)\" Transport mode$")
	public void testCalculateCost(String weight, String transportmode){
		//Please fill the required codes
		weights = weight;
		trnsmode = transportmode;
		driver.findElement(By.id("weight")).clear();
        driver.findElement(By.id("weight")).sendKeys(weight);
        driver.findElement(By.id(trnsmode)).click();
        driver.findElement(By.id("calculate")).click();
		result = driver.findElement(By.id("result")).getText();		
	}
	@Then("^I validate the message with total shipping cost$")
	public void validateResult(){
		//Please fill the required codes
		if (weights.equalsIgnoreCase("100") && trnsmode.equalsIgnoreCase("air")) 
		{
			Assert.assertEquals("Dear Customer, your total shipping cost is $100", result);
        } 
        if (weights.equalsIgnoreCase("100") && trnsmode.equalsIgnoreCase("road"))
        {
			Assert.assertEquals("Dear Customer, your total shipping cost is $50", result);
        } 
        if (weights.equalsIgnoreCase("100") && trnsmode.equalsIgnoreCase("ship")) 
        {
			Assert.assertEquals("Dear Customer, your total shipping cost is $70", result);
        }
	}
	@After
	public void tearDown(){
		driver.quit();
	}
}


---shipping.feature---
#Please Do not change Feature Templet
Feature: Calculating Trasportation cost
#Please Do not change Scenario Outline Templet
Scenario: Calculate Shipping Cost by air
#Please Do not change Given Templet
Given I have navigated to shipping application home page
When I enter "100" and select "Air" Transport mode
#Please fill the Required code as per the Problem statement
#Please Do not change Scenario Outline Templet
Scenario: Calculate Shipping Cost by ship
#Please Do not change Given Templet
Given I have navigated to shipping application home page
When I enter "100" and select "Ship" Transport mode 
#Please fill the Required code as per the Problem statement
#Please Do not change Scenario Outline Templet
Scenario: Calculate Shipping Cost by road
#Please Do not change Given Templet
Given I have navigated to shipping application home page
When I enter "100" and select "Road" Transport mode
#Please fill the Required code as per the Problem statement
