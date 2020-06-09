---address book ----
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressBook extends DriverSetup {           //DO NOT change the class name
    static WebDriver driver;
    public WebDriver createDriver()
    {
       //Create driver, store in in static variable 'driver' and return it
        driver = DriverSetup.getWebDriver();
        return driver;
    }
    
    public void setNewFormValues(String nickname,String contact,String company,String city,String country,String type)
    {
        //Find the form elements and set values by passing those values from 'main' method. 
        //Submit form to add the details
        driver.findElement(By.id("nickname")).sendKeys(nickname);
        driver.findElement(By.id("contact")).sendKeys(contact);
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("type")).sendKeys(type);
        driver.findElement(By.id("add")).click();
    }
    
    public WebElement getNewNickName() {
        //Find and return the 'nickname' web element of the row displayed after first submit
        WebElement nickname = driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[1]"));
        return nickname;
    }
    public WebElement getNewContact() {
        //Find and return the 'contact' web element of the row displayed after first submit
        WebElement contact = driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[2]"));
        return contact;
    }
    public WebElement getNewCompany() {
        //Find and return the 'company' web element of the row displayed after first submit
        WebElement company = driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[3]"));
        return company;
    }
    public WebElement getNewCity() {
        //Find and return the 'city' web element of the row displayed after first submit
        WebElement city = driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[4]"));
        return city;
    }
    public WebElement getNewCountry() {
        //Find and return the 'country' web element of the row displayed after first submit
        WebElement country = driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[5]"));
        return country;
    }
    public WebElement getNewType() {
        //Find and return the 'type' web element of the row displayed after first submit
        WebElement type = driver.findElement(By.xpath("//*[@id='result']/table/tbody/tr[2]/td[6]"));
        return type;
    }
    public void editDetails() {
        //Find the first radio button and click 
        //Find edit button and click
        driver.findElement(By.id("radio0")).click();
        driver.findElement(By.id("edit")).click();
    }
    public String getEditNickName() {
        //Find and return the 'nickname' value in the edit box in the form after cicking edit
        String nickname = driver.findElement(By.id("nickname")).getAttribute("value");
        return nickname;
    }
    public String getEditContact() {
        //Find and return the 'contact' value in the edit box in the form after cicking edit
        String contact = driver.findElement(By.id("contact")).getAttribute("value");
        return contact;
    }
    public String EditNewCompany() {
        //Find and return the 'company' value in the edit box in the form after cicking edit
        String company = driver.findElement(By.id("company")).getAttribute("value");
        return company;
    }
    public String getEditCity() {
        //Find and return the 'city' value in the edit box in the form after cicking edit
        String city = driver.findElement(By.id("city")).getAttribute("value");
        return city;
    }
    public String getEditCountry() {
        //Find and return the 'country' value in the edit box in the form after cicking edit
        String country = driver.findElement(By.id("country")).getAttribute("value");
        return country;
    }
    public String getEditType() {
        //Find and return the 'type' value in the edit box in the form after cicking edit
        String type = driver.findElement(By.id("type")).getAttribute("value");
        return type;
    }
    public void setUpdateFormValues(String nickname,String contact,String company,String city,String country,String type)
    {
        //Set form values to update and submit (by passing those values from 'main' method). 
        driver.findElement(By.id("nickname")).clear();
        driver.findElement(By.id("nickname")).sendKeys(nickname);
        driver.findElement(By.id("contact")).clear();
        driver.findElement(By.id("contact")).sendKeys(contact);
        driver.findElement(By.id("company")).clear();
        driver.findElement(By.id("company")).sendKeys(company);
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("country")).clear();
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("type")).clear();
        driver.findElement(By.id("type")).sendKeys(type);
        driver.findElement(By.id("add")).click();
    }
    public void deleteDetails() {
        //Find the SECOND row of address displayed and click the radio button
        //Find delete button and click to delete SECOND row
        driver.findElement(By.id("radio1")).click();
        driver.findElement(By.id("delete")).click();
    }
    public static void main(String[] args) {
        AddressBook ab=new AddressBook();
        //Add required code
        ab.createDriver();
        ab.setNewFormValues("Test", "Automation", "CTS", "Mysore", "India", "Office");
        ab.getNewNickName();
        ab.getNewContact();
        ab.getNewCompany();
        ab.getNewCity();
        ab.getNewCountry();
        ab.getNewType();
        ab.editDetails();
        ab.getEditNickName();
        ab.getEditContact();
        ab.EditNewCompany();
        ab.getEditCity();
        ab.getEditCountry();
        ab.getEditType();
        ab.setUpdateFormValues("Automation", "Test", "CTS", "Mysore", "India", "office");    
        ab.setNewFormValues("Selenium", "Automation", "CTS", "Banglore", "India", "Office");
        ab.deleteDetails();        
    }
}

---dynamic xpath---
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleWindows {           //Do not change the class name
  //Use these declarations to store respective values
  static String parentWinHandle;
  static String childWinHandle;
  static WebDriver driver;
		
	public WebDriver createDriver()      //Do not change the method signature
	{
	  /* Replace this comment by the code statement to create driver, assign it to 'static' variable and return the driver */
	  /* Use the URL, 'http://webapps.tekstac.com/FormRegistration/indexemi.html' */
		DriverSetup setup = new DriverSetup();
		driver = setup.getWebDriver();
		driver.get("http://webapps.tekstac.com/FormRegistration/indexemi.html");
		return driver;
	}
	 
    public String  getParentWindow() throws Exception {        //Do not change the method signature
      // Get  Parent Window Handle as string and return it
     	parentWinHandle = driver.getWindowHandle();
    	return parentWinHandle;
    }
    
    public String  getChildWindow() throws Exception {         //Do not change the method signature
      // Click the href link. Find the child window's handle and return it.
      //Hint: WAIT for child page to load and find the child window handle. 
     	driver.findElement(By.xpath("/html/body/p/a")).click();
    	Thread.sleep(5000);
    	Set<String> window = driver.getWindowHandles();
	  	Iterator<String> it=window.iterator();
		  parentWinHandle = it.next();
	  	childWinHandle = it.next();
	  	driver.switchTo().window(childWinHandle);
		  return childWinHandle;
    }
    
    public WebDriver  getBackParent(String parentWinHandle) throws Exception {        //Do not change the method signature
      //Switch back to parent window and return its webdriver
     	driver.switchTo().window(parentWinHandle);
    	return driver;
    }
    
    public String  getChildWindowTitle() throws Exception {
      //Get Child Window's title and return it
     	driver.switchTo().window(childWinHandle);
    	String childTitle = driver.getTitle();
    	return childTitle;
    }
    
    public void minimizeWindow() throws Exception{       //Do not change the method signature
      //Minimize the current window
    	Point p = new Point(0,3000);
      //Minimize the current window to the set position
     	driver.manage().window().setPosition(p);
    }
    
    public void maximizeWindow() throws Exception{       //Do not change the method signature
      //Maximize the current window. Use BUILT-IN method.
     	driver.manage().window().maximize();
    }
    
    public void resizeWindow() {             //Do not change the method signature
      //Resize the current window to width=1200, height=800
    	Dimension d = new Dimension(1200,800);
     	//Resize current window to the set dimension
     	driver.manage().window().setSize(d);
    }
    
    public static void main(String[] args) throws Exception{
	    MultipleWindows win=new MultipleWindows();
	    //Implement code here
	    win.createDriver();
	    win.getParentWindow();
	    win.getChildWindow();
	    win.getChildWindowTitle();
	    win.minimizeWindow();
	    win.maximizeWindow();
	    win.resizeWindow();
	    win.getBackParent(parentWinHandle);
	}
}
