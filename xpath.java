---cssselector---
//Add required imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class CSSLocator     //DO NOT change the class name
{
    static WebDriver driver;
    String username;
    static WebElement element;
	public WebDriver createDriver()  //DO NOT change the method signature
	{
	    DriverSetup setup = new DriverSetup();
	    driver = setup.getWebDriver();
	    return driver;
	   //Implement code to create Driver from DriverSetup and return it
	}
	
	public WebElement getCSSLocator(WebDriver driver)  //DO NOT change the method signature
	{
	   element = driver.findElement(By.cssSelector("input#username"));
	   /*Replace this comment by the code statement to get the Web element of username*/
	   /*Find and return the element */ 
	   return element;
	}
	
	public String getName(WebElement element)  //DO NOT change the method signature
	{
	    username = element.getAttribute("placeholder");
	    System.out.println(username);
	    //Get the attribute value from the element and return it
	    return username;
	}
	
    public static void main(String[] args){
	    CSSLocator pl=new CSSLocator();
	    pl.createDriver();
	    pl.getCSSLocator(driver);
	    pl.getName(element);
	    //Add required code
	}
}

---AbsoluteXpath---
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//Add required imports
public class AbsoluteXpathLocator extends DriverSetup //DO NOT Change the class Name
{
    static WebDriver driver;
    static WebElement logo;
    public WebDriver createDriver()
    {
       //Implement code to create Driver from DriverSetup and return it
        driver = DriverSetup.getWebDriver();
        return driver;
    }
    public WebElement getAbsoluteXpathLocator(WebDriver driver)//DO NOT change the method signature
    {
       /*Replace this comment by the code statement to get the Web element of logo */
       /*Find and return the element */ 
       logo = driver.findElement(By.xpath("/html/body/form/div/img"));
        return logo;
    }
    public String getName(WebElement element)    //DO NOT change the method signature
    {
        //Get the attribute value from the element and return it
        String imageSrcvalue = element.getAttribute("src");
        return imageSrcvalue;
    }
    public static void main(String[] args){
        AbsoluteXpathLocator pl=new AbsoluteXpathLocator();
       //Add required code 
       pl.createDriver();
        pl.getAbsoluteXpathLocator(driver);
        pl.getName(logo);
    }
}


---RelativeXpath---
//Add required imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
public class RelativeXpathLocator    //DO NOT Change the class Name
{
    static WebDriver driver;
    static WebElement element;
    String username;
	public WebDriver createDriver()    //DO NOT change the method signature
	{
	    DriverSetup setup = new DriverSetup();
	    driver = setup.getWebDriver();
	    return driver;
	   //Implement code to create Driver from DriverSetup and return it
	}
	public WebElement getRelativeXpathLocator(WebDriver driver)//DO NOT change the method signature
	{
	    element = driver.findElement(By.xpath("//td[contains(text(),'SivaKumar')]"));
	    return element;
	   /*Replace this comment by the code statement to get the Web element */
	   /*Find and return the element */
  }
	public String getName(WebElement element)//DO NOT change the method signature
	{
	    username = element.getText();
	    return username;
	    //Get the attribute value from the element and return it
	}
   public static void main(String[] args){
	    RelativeXpathLocator pl=new RelativeXpathLocator();
	    pl.createDriver();
	    pl.getRelativeXpathLocator(driver);
	    pl.getName(element);
	    //Add required code
	}
}

---RegEx---
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NameLocator {      //DO NOT change the class name
  public static String baseUrl; //Assign 'http://webapps.tekstac.com/Handling_Regular_Expression/' for baseUrl
  public static WebDriver driver;
	public static WebElement element;
	public static WebElement nameelement;
	public static WebElement shipmentelement;
	public static WebElement emailelement;
	public static String eMail;
	public static String shipmentid;
	public WebDriver createDriver()
	{
	    DriverSetup setup = new DriverSetup();
	    driver = setup.getWebDriver();
	    baseUrl = "http://webapps.tekstac.com/Handling_Regular_Expression/";
	    return driver;
	    //Create driver. Assign it to static variable 'driver' and return it
	}
 public void navigate(WebDriver driver){
	    driver.get(baseUrl);
	     //Navigate to the baseUrl
	}
  	public void setFormValues(WebDriver driver)
	{
	    driver.findElement(By.id("userId")).sendKeys("Shamili");
	    driver.findElement(By.id("track")).click();
	    //set the value for 'Shipment for user' and submit form
	}
   public WebElement getNameResultElement(WebDriver driver) {
        nameelement = driver.findElement(By.xpath("//*[@id='result']//td[contains(text(),'Shamili')]"));
        return nameelement;
        //Find the element of 'Shamili' and return it
    }
    public WebElement getShipmentResultElement(WebDriver driver) {
        shipmentelement = driver.findElement(By.xpath("//*[@id='result']//div[contains(text(),'SHIP1236')]"));
        shipmentid = shipmentelement.getText();
        return shipmentelement;
         //Find the element of 'SHIP1236' and return it
    }
    public WebElement getEmailResultElement(WebDriver driver) {
        emailelement = driver.findElement(By.xpath("//*[@id='result']//div[contains(text(),'shamili93@gamil.com')]"));
        eMail = emailelement.getText();
        return emailelement;
        //Find the element of 'shamili93@gamil.com' and return it
    }
     public boolean validateEmail(String eMailID) {
       //Validate email using regex. 
       boolean val = eMailID.matches("\\b[A-Z0-9a-z-]+@[a-z]+\\.[a-z]{2,4}\\b");
       return val;
    }
    public boolean validateShipmentId(String shipmentId) {
        //Validate shipmentId using regex
        boolean val = shipmentId.matches("[A-Z0-9]{8}");
        return val;
    }    
    public static void main(String[] args)
	{
	    NameLocator reg=new NameLocator();
	    reg.createDriver();
	    reg.navigate(driver);
	    reg.setFormValues(driver);
	    reg.getNameResultElement(driver);
	    reg.getShipmentResultElement(driver);
	    reg.getEmailResultElement(driver);
	    reg.validateEmail(eMail);
	    reg.validateShipmentId(shipmentid);
	     //Add required code here
	}
}

---Xpathancestor---
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

public class NameLocator      //DO NOT Change the class name
{
    //Use the declared variables for stroing required values
	static String fName;
	static WebDriver driver;
	
	public WebDriver setupDriver()           //DO NOT Change the method Signature
	{
	    DriverSetup setup = new DriverSetup();
	    driver = setup.getWebDriver();
	    driver.get("http://webapps.tekstac.com/AddressBook/");
	    return driver;
	    /* Replace this comment by the code statement to create and return the driver */
	    /* Naviaget to the url 'http://webapps.tekstac.com/AddressBook/'  */
	    
	}
	public String getNameLocator()              //DO NOT Change the method Signature
	{
	   fName = driver.findElement(By.xpath("//td[text()='NickName']//ancestor::div")).getText(); 
	   driver.quit();
	   return fName;
	   /*Using the driver, Find the element ancestor and its text and assign the text to 'fName' */
       /*Close the driver*/
      
	}
	
	public static void main(String[] args)
	{
	    NameLocator namLocator=new NameLocator();
	    namLocator.setupDriver();
	    namLocator.getNameLocator();
	    //Add required code here
	}
}

---alerts---
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;

public class AlertTest extends DriverSetup   //DO NOT Change the class Name
{
    public static WebDriver driver;
    public WebDriver createDriver()  //DO NOT change the method signature
    {
       //Implement code to create Driver from DriverSetup, assign it to 'static' variable and return it
        
        driver = DriverSetup.getWebDriver();
        return driver;

 

    }
    public Alert getAlertElement(WebDriver driver)   //DO NOT change the method signature
    {
        //Find the 'click' buttton and click it.
        //Locate the 'Alert' element and return it
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        //Switching to alert
        Alert alert = driver.switchTo().alert();
        return alert;
         }
    public static void main(String[] args)  throws InterruptedException  //DO NOT change the method signature
    {      
        AlertTest at=new AlertTest();
        //Implement code here
        at.createDriver();
        at.getAlertElement(driver);
    }
}
