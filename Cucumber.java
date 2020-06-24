--L2C1--
---shippingJuint.java---
package testRunner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue={"stepDefinition"})
public class ShippingJunit {
}

---Shipping.feature---
Feature: To Test the Shipping details in DATAX Shipping Company
  #Please Do not change Scenario Outline Templet
  Scenario Outline: Title of your scenario outline 
    #Please Do not change Given Templet
    Given Start firefox browser and open the application
    When  Test the text in H2 tag and the "6543217" for ShipmentID
    Then Validate the Customer name "Maya" is displayed
    Then Quit the browser
    
    Examples:
    |Shipment Id|
    |6543217	|
	
---stepDefinition.java----
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.*;
public class StepDefinition {
	WebDriver driver;
    @Given("^Start firefox browser and open the application$")
    public void SetUp() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    	FirefoxBinary firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	firefoxOptions.setProfile(profile);
        driver=new FirefoxDriver(firefoxOptions);
	    driver.get("https://webapps.tekstac.com/shippingDetails/");
    }
    @When("^Test the text in H2 tag and the \"([^\"]*)\" for ShipmentID$")
    public void  testShippingDetails(String arg1) throws Throwable {
	    //Please fill the required codes
	    String H2tag = driver.findElement(By.xpath("//h2")).getText();
	    Assert.assertEquals("Shipping Details", H2tag);
	    String ShipmentID = driver.findElement(By.xpath("//div[@id='shippingTable']/table/tbody/tr[2]/td[1]/a")).getText();
	    Assert.assertEquals(arg1, ShipmentID);
    }
    @Then("^Validate the Customer name \"([^\"]*)\" is displayed$")
    public void  validateResult(String arg1) throws Throwable {
        //Please fill the required codes
        driver.findElement(By.xpath("//div[@id='shippingTable']/table/tbody/tr[2]/td[1]/a")).click();
	    String customerName = driver.findElement(By.xpath("//div[@id='result']/table/tbody/tr[2]/td[1]")).getText();
	    Assert.assertEquals("Maya", customerName);
    }
    @Then("^Quit the browser$")
    public void Quit_the_browser() throws Throwable {
        driver.close();
    }
}


--L2C2--
---user.feature---
Scenario: Validate Shipment status and details with enrolled User Details.
    #Please Do not change Given Templet
	Given User loads the application and navigate to home page
	When  User enters "Shamili" on the tracking page
	Then following should be displayed	
    |Name 		 |Shamili            |
	|Shipment Id |SHIP1236           |
	|Phone Number|9224158877         |
	|E-mail      |shamili93@gamil.com|
	
---StepDefinition---
package stepDefinition;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.*;

public class StepDefinition {
	WebDriver driver;
	String text;
	@Given("^User loads the application and navigate to home page$")
	public void setUp(){		
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    	FirefoxBinary firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	firefoxOptions.setProfile(profile);
        driver=new FirefoxDriver(firefoxOptions);
		driver.get("https://webapps.tekstac.com/Handling_Reg_Expression");
		System.out.println("Application is launched");
	}
	@When("^User enters \"([^\"]*)\" on the tracking page$")
	public void testUserDetails(String Name){
		//Please fill the required codes
		driver.findElement(By.id("userId")).sendKeys(Name);
		driver.findElement(By.id("track")).click();
	}
	@Then("^following should be displayed$")
	public void validateResult(DataTable ShipmentDetails) {
		//Please fill the required codes
		List<List<String>> data = ShipmentDetails.raw();
		text = driver.findElement(By.id("result")).getText();
		Assert.assertTrue(text.contains(data.get(1).get(0)));  
		Assert.assertTrue(text.contains(data.get(1).get(1)));
		Assert.assertTrue(text.contains(data.get(1).get(2)));
		Assert.assertTrue(text.contains(data.get(1).get(3)));
	}
	@After
	public void closeDriver(){
		driver.quit();
	}
}

--L2C3--
---discount.feature---
#Please Do not change Scenario Outline Templet
Feature: DATAX Shipping Discount calculation.
#Please Do not change Scenario Outline Templet
Scenario Outline: Validate Shipping company offers discount for different weights and Distances.
    #Please Do not change Given Templet
	Given User loads the application and navigate to DATAX shipping company home
	When User enters "<weight>" and "<distance>" on Company Offers Discount page
	Then The text "<discount>" should be displayed
	Examples:
	|weight|distance|discount|
	|100   |200     |Datax shipping company offers discount|
	|80	   |500     |Datax shipping company offers discount|
	|120   |520     |Datax shipping company offers discount|
	|300   |200     |Datax shipping company offers discount|
	
---nodiscount.feature---
#Please Do not change Scenario Outline Templet
Feature: DATAX Shipping Discount calculation.
#Please Do not change Scenario Outline Templet
Scenario Outline: Validate Shipping company doesn't offers discount for different weights and Distances.
    #Please Do not change Given Templet
	Given User navigates to DATAX shipping company home
    When User enters "<weight>" and "<distance>"
	Then The text "<noDiscount>" should be present
	Examples:
	|weight|distance|noDiscount|
	|60	   |110     |Datax shipping offers no discount|
	|50	   |150     |Datax shipping offers no discount|	
---discountstepdefinition.java---
package stepDefinition;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;
import cucumber.api.java.en.*;

public class DiscountStepDefinition {
	WebDriver driver;
	String text;
	@Given("^User loads the application and navigate to DATAX shipping company home$")
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    	FirefoxBinary firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	firefoxOptions.setProfile(profile);
        driver=new FirefoxDriver(firefoxOptions);
		driver.get("https://webapps.tekstac.com/CompanyOffersDiscount/");
		System.out.println("Application is launched");
	}
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" on Company Offers Discount page$")
	public void testDiscount(String weight, String distance) {	
	    //Please fill the required codes
		driver.findElement(By.xpath("//input[@id='weight']")).sendKeys(weight);
		driver.findElement(By.xpath("//input[@id='distance']")).sendKeys(distance);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}
	@Then("^The text \"([^\"]*)\" should be displayed$")
	public void validateResult(String message) {
		//Please fill the required codes
		String actual = driver.findElement(By.xpath("//div[@id='result']")).getText();
		//Assert.assertTrue(text.contains(Message));
		Assert.assertEquals(actual, message);
		driver.quit();
	}
}

---noDiscountstepdefiniton.java---
package stepDefinition;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.FirefoxBinary;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class NodiscountStepDefinition {
	WebDriver driver;
	String text;
	@Given("^User navigates to DATAX shipping company home$")
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    	FirefoxBinary firefoxBinary = new FirefoxBinary();
    	firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	firefoxOptions.setBinary(firefoxBinary);
    	firefoxOptions.setProfile(profile);
        driver=new FirefoxDriver(firefoxOptions);
		driver.get("https://webapps.tekstac.com/CompanyOffersDiscount/");
		System.out.println("Application is launched");
	}
	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void testNodiscount(String weight, String distance) {
		//Please fill the required codes
		driver.findElement(By.xpath("//input[@id='weight']")).sendKeys(weight);
		driver.findElement(By.xpath("//input[@id='distance']")).sendKeys(distance);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}
	@Then("^The text \"([^\"]*)\" should be present$")
	public void validateResult(String message) {
		//Please fill the required codes
		String actual = driver.findElement(By.xpath("//div[@id='result']")).getText();
		//Assert.assertTrue(text.contains(Message));
		Assert.assertEquals(actual, message);
		driver.quit();
	}
}
	
--L2C4--
---stepDefinition.java---
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

---shipping.java---
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
