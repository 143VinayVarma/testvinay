---Namelocator.java---
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class NameLocator 
{
	String fName = "";  
	static WebDriver driver;  
	
	public WebDriver setupDriver()
	{
	    DriverSetup setupDriver = new DriverSetup();
	    driver = setupDriver.getWebDriver();
	    /*Invoke the getWebDriver method from the DriverSetup File*/
	    return driver;
	}
	public String getNameLocator()
	{
       /*Identify the Firstname
	     Get the placeholder value
         Store the placeholder value in the static variable fName.*/
         setupDriver();
         fName = driver.findElement(By.name("fname")).getAttribute("placeholder");
       return fName;
	}
	
	public static void main(String[] args)
	{
	    NameLocator namLocator=new NameLocator();
	    String name=namLocator.getNameLocator();
	    System.out.println("The name is "+name);
	}
}


---Pagelocator.java---
//Add required imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageLocator    //DO NOT Change the class Name
{
    static String lName;
    static WebDriver driver;
	
	public WebDriver createDriver()  //DO NOT change the method signature
	{
	   DriverSetup setup = new DriverSetup();
	   driver = setup.getWebDriver(); 
	   //Invoke getWebDriver method from DriverSetup and return it
	   return driver;
	}
	
	public WebElement getPageLocator(WebDriver driver)  //DO NOT change the method signature
	{
	    WebElement element = driver.findElement(By.id("lastname"));
	    return element;
	   /*Replace this comment by the code statement to get the WebElement of 'Lastname'*/
	   /*Find the element by id */
	   
	}
	public String getName(WebElement element)  //DO NOT change the method signature
	{
	    lName = element.getAttribute("placeholder");
	    System.out.println("The name is"+lName);
	    return lName;
	    //Get the attribute value from the element and return it
	}
	
	public static void main(String[] args){
	    PageLocator pl=new PageLocator();
	    pl.createDriver();
	    WebElement ele = pl.getPageLocator(driver);
	    pl.getName(ele);
	    //Add required code
	}
}


----Regitration.java---
/* IMPORTANT:- DriverSetup --getWebDriver()
-------------------------------------------------
PLEASE DO NOT MAKE ANY CHANGES OR MOFICATIONS IN THIS PROGRAM */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class DriverSetup
{ 
    private static WebDriver driver;
    public static WebDriver getWebDriver()
	{
		System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
	    FirefoxProfile profile=new FirefoxProfile();
	    //profile.setPreference("marionette.logging", "TRACE");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		firefoxOptions.setProfile(profile);
	    driver=new FirefoxDriver(firefoxOptions);
	    return driver;
	}
}

---Pagenavigation----
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class NameLocator 
{
	static String page1, page2,page3,page4,page5,baseUrl;
	static WebDriver driver;
	
	public WebDriver setupDriver()
	{
	    DriverSetup setup = new DriverSetup();
	    driver = setup.getWebDriver();
	    return driver;
	    /*Replace this comment by the code statement to get the driver*/
	    
	}
	public void navigate1() 
	{
	    baseUrl = "https://selenium.dev/";
	    driver.navigate().to(baseUrl);
	    /*Replace this comment by the code statement to navigate to baseUrl */
	    
	}
	public void getPageTitle1()
	{
	    page1 = driver.getTitle();
	    /*Replace this comment by the code statement to get page title of  "https://selenium.dev/"*/
	    /* Assign the page title to variable 'page1' */
	    
	}
	public void navigate2()
	{
	    driver.navigate().to("https://www.google.co.in/");
	    /*Replace this comment by the code statement to navigate to https://www.google.co.in/ */
        
	}
	public void getPageTitle2()
	{
	    page2 = driver.getTitle();
	    /*Replace this comment by the code statement to get page title of  https://www.google.co.in/ */
	    /* Assign the page title to variable 'page2' */
        
	}
	public void navigateBack()
	{
	    driver.navigate().back();
	    /*Replace this comment by the code statement to navigate back */
       
	}
	public void getPageTitle3()
	{
	    page3 = driver.getTitle();
	    /*Replace this comment by the code statement to get page title of backed page */
	    /* Assign the page title to variable 'page3' */
        
	}
	public void navigateForward()
	{
	    driver.navigate().forward();
	    /*Replace this comment by the code statement to navigate forward */
        
	}
	public void getPageTitle4()
	{
	    page4 = driver.getTitle();
	    /*Replace this comment by the code statement to get page title of the forwarded page */
	    /* Assign the page title to variable 'page4' */
        
	}
	public void refreshPage()
	{
	    driver.navigate().refresh();
	    /*Replace this comment by the code statement to refresh the page */
       
	}
	public void getPageTitle5()
	{
	    page5 = driver.getTitle();
	    /*Replace this comment by the code statement to get page title of refreshed page */
	    /* Assign the page title to variable 'page5' */
        
	}

	
	public static void main(String[] args)
	{
	    NameLocator namLocator=new NameLocator();
	    namLocator.setupDriver();
	    namLocator.navigate1();
	    namLocator.getPageTitle1();
	    namLocator.navigate2();
	    namLocator.getPageTitle2();
	    namLocator.navigateBack();
	    namLocator.getPageTitle3();
	    namLocator.navigateForward();
	    namLocator.getPageTitle4();
	    namLocator.refreshPage();
	    namLocator.getPageTitle5();
	}
}

----RegistrationBasic----
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Registration 
{
	String fName;
	static WebDriver driver;
	static String baseUrl; 
	
public WebDriver setupDriver()
	{
	    DriverSetup setup = new DriverSetup();
	    driver = setup.getWebDriver();
	    baseUrl = "http://webapps.tekstac.com/Shopify/";
	    driver.get(baseUrl);
	    /* Invoke the getWebDriver method 
	       Set value of BaseUrl
	       Launch the app using get() with baseUrl */
	     return driver;
	}
	
	public void setElements()
	{
	    driver.findElement(By.id("firstname")).sendKeys("Rahul");
	    driver.findElement(By.id("lastname")).sendKeys("Dravid");
	    driver.findElement(By.id("username")).sendKeys("Rahul Dravid");
	    driver.findElement(By.id("pass")).sendKeys("gentlemancrickter");
	    driver.findElement(By.id("reg")).click();
	    /*Using the driver, Find the elements by id 
	      Set the values to the elements
	      Register the form*/
	}
	
	public static void main(String[] args)
	{
	    Registration reg=new Registration();
	    reg.setupDriver();
	    reg.setElements();
	}
}

---RegistrationAdvance---
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Registration 
{
	static WebDriver driver;
	static String baseUrl; 
	
	public WebDriver setupDriver()
	{
	    DriverSetup setup = new DriverSetup();
	    driver = setup.getWebDriver();
	    baseUrl = "http://webapps.tekstac.com/Shopify/";
	    driver.get(baseUrl);
	    //Assign the value for baseUrl
	    /* Get the driver, and launch the app using get() with baseUrl */
	     return driver;
	}
	
	public void setElements()
	{
	    driver.findElement(By.id("firstname")).sendKeys("Mithali");
	    driver.findElement(By.id("lastname")).sendKeys("Raj");
	    driver.findElement(By.id("username")).sendKeys("Mithali Raj");
	    Select select = new Select(driver.findElement(By.id("selectcity")));
	    select.selectByVisibleText("Chennai");
	    driver.findElement(By.xpath("//input[@value='female']")).click();
	    driver.findElement(By.id("pass")).sendKeys("MR@123");
	    driver.findElement(By.id("reg")).click();
	    /*Using the driver, Find the elements by id and send the values to the elements*/
 	}
	
	public static void main(String[] args)
	{
	    Registration reg=new Registration();
	    reg.setupDriver();
	    reg.setElements();
	}
}
