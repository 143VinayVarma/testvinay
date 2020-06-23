---Stepdefinition---
package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;
import java.util.List;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;
	@Given("^Start firefox browser and open the application$")
	public void SetUp() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		FirefoxProfile profile = new FirefoxProfile();
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setProfile(profile);
		driver = new FirefoxDriver(firefoxOptions);
		driver.get("https://webapps.tekstac.com/shippingDetails/");
	}
	@When("^Test the text in H2 tag and the \"([^\"]*)\" for ShipmentID$")
	public void testShippingDetails(String arg1) throws Throwable {
		System.out.println("h2 tag name:: " + driver.findElement(By.tagName("h2")).getText());
	}
	@Then("^Validate the Customer name \"([^\"]*)\" is displayed$")
	public void validateResult(String arg1) throws Throwable {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int i = links.size();
		for (int j = 0; j < i; j++) {
			if (links.get(j).getText().equals("6543217")) {
				driver.findElement(By.linkText(links.get(j).getText())).click();
			}
		}
		System.out.println("Customer name of 6543217 link:: "
				+ driver.findElement(By.xpath("/html/body/div[1]/div/table/tbody/tr[2]/td[2]")).getText());
			}
	@Then("^Quit the browser$")
	public void Quit_the_browser() throws Throwable {
		driver.close();
	}
}



------Shipping feature-----
#Please Do not change Feature Templet
Feature: To Test the Shipping details in DATAX Shipping Company
  #Please Do not change Scenario Outline Templet
  Scenario Outline: 'Ship Details' is tested in this Senario 
    #Please Do not change Given Templet
    Given Start firefox browser and open the application		
	When Test the text in H2 tag and the "6543217" for ShipmentID
    Then Validate the Customer name "Maya" is displayed
    Then Quit the browser
 	Examples:
    	| ShipmentID |
    	|  6543217   |
