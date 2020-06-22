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


----------cc5----------------
	import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import java.io.FileReader;
import java.util.Iterator;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UserDetails {

    //use the below variable declarations
	public static WebDriver driver;
	public static JSONArray details;
	public static JSONObject jsonObject;
	public static String name,email,phone,age,password,hobby,gender,city,address;
	public static WebDriver createDriver() {    //Do not change the class name
		/* Create a driver. Assign it to static variable 'driver' and return it */
	    /* navigate to 'http://webapps.tekstac.com/FormRegistration/UserRegistration.html'  */
	    driver = DriverSetup.getWebDriver();
        driver.get("http://webapps.tekstac.com/FormRegistration/UserRegistration.html");
	    return driver;
	}	
	public JSONArray readFile(String fileName)throws Exception {   //Do not change the method signature
	    //Retrieve the json file name passed as 'fileName' parameter. Parse the json, store it in 'details' array and return it
	    JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(fileName);
        Object obj = jsonParser.parse(reader);
        jsonObject = (JSONObject) obj;
        details = (JSONArray) jsonObject.get("Userdetails");
        return details;
	}
	public String getName(int id) {   //Do not change the method signature
		//Parse the json to get 'Name' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        name = (String)values.get("Name");
        return name;
	}
	public String getEmail(int id) {   //Do not change the method signature
		//Parse the json to get 'Email' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        email = (String)values.get("Email");
        return email;
	}
	public String getPhone(int id) {     //Do not change the method signature   
		//Parse the json to get 'Phone' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        phone = (String)values.get("Phone");
        return phone;
	}
	public String getAge(int id) {         //Do not change the method signature
		//Parse the json to get 'Age' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        age = (String)values.get("Age");
        return age;
	}	
	public String getPassword(int id) {      //Do not change the method signature
	    //Parse the json to get 'Password' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        password = (String)values.get("Password");
        return password;
	}
	public String getHobbies(int id) {        //Do not change the method signature
		//Parse the json to get 'Hobbies' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        hobby = (String)values.get("Hobbies");
        return hobby;
	}
	public String getGender(int id) {          //Do not change the method signature
		//Parse the json to get 'Gender' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        gender = (String)values.get("Gender");
        return gender;
	}
	public String getCity(int id) {          //Do not change the method signature
		//Parse the json to get 'City' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        city = (String)values.get("City");
        return city;
	}
	public String getAddress(int id) {         //Do not change the method signature
		//Parse the json to get 'Address' value. Return it.
        //Parameter 'id' is the id in the Registration.json
        JSONObject values=(JSONObject)details.get(id);
        address = (String)values.get("Address");
        return address;
	}
	public String getMessage() {           //Do not change the method signature
		//Find the web elements in the page. Assign the respective values from json to the form.
        //Submit the form 
        //Locate the 'Registered Successfully' message and return it
        driver.findElement(By.id("uname")).sendKeys(getName(1));
        driver.findElement(By.id("uemail")).sendKeys(getEmail(1));
        driver.findElement(By.id("phone")).sendKeys(getPhone(1));
        driver.findElement(By.id("age")).sendKeys(getAge(1));
        driver.findElement(By.id("pass")).sendKeys(getPassword(1));
        List<WebElement> hobbies = driver.findElements(By.xpath("//label"));
        for(WebElement h:hobbies)
        {
            if((h.getText()).equalsIgnoreCase(getHobbies(1)))
            {
                h.click();
                break;
            }
        }
        List<WebElement> genders = driver.findElements(By.xpath("//label"));
        for(WebElement g:genders)
        {
            System.out.println("gender:"+g.getText());
            if((g.getText()).equalsIgnoreCase(getGender(1)))
            {
                g.click();
                break;
            }
        }
        WebElement c = driver.findElement(By.id("city"));
        Select s = new Select(c);
        s.selectByVisibleText(city);
        driver.findElement(By.name("address")).sendKeys(getAddress(1));
        driver.findElement(By.id("submit")).click();
        String text = driver.findElement(By.xpath("//h2")).getText();
        return text;
	}
	public static void main(String[] args) throws Exception {
		UserDetails fieldLocator = new UserDetails();
        //Add required code
		fieldLocator.createDriver();
        fieldLocator.readFile(System.getProperty("user.dir")+"/Registration.json");
        driver.close();
		}	
	}


----CC4--
	Objectives :
To understand the concept behind TestNG and working with data providers.
URL : http://webapps.tekstac.com/Agent_Registration/
Test Procedure:
    Use the template code.
   Only in the suggested section add the code to,
   In class Ex6TestNG
  1) Method 'createDriver'
       create the driver using class DriverSetup Assign it to static variable 'driver'.
  2) Method, 'agentRegistration'
    This method should parse data from Agent.xlsx.
    Annotate this method with  data provider name as "Agent".  Store the parsed data in a 2-D array variable,    'excelData' and return it.
  3) Method 'testAgent' 
      Annotate this method with data provider name as "Agent". Locate the form web elements. Send the excel data as value. Submit the form.
    4) Use the below methods to assert their respective values located on the "Registered Successfully" page   against the excel data,
testName
testUserName
testPhone
testEmail  
In case of assert failure, add the custom failure message mentioned in the code snippet.
     5) Method 'checkAgent'   => Invoke the TestNG ONLY using this method
Excel Sheet Name : agent


------testing.xml----------
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" >
  <test name="Test">
    <classes>
       <!--  Add Required Code -->
       <class name="Ex6TestNG">
         </class>
     </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

-------driversetup.java------------
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
	    String baseUrl = "http://webapps.tekstac.com/Agent_Registration/";
	    driver.get(baseUrl);
	    return driver;
	}
}

---------Ex6TestNG.java----------
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.TestNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import junit.framework.Assert;

@Listeners(FeatureTest.class)            //DO NOT remove or alter this line. REQUIRED FOR TESTING
public class Ex6TestNG                //DO NOT Change the class Name
{ 
	public static WebDriver driver;
	static String[][] excelData = null;  
	public static String filePath;
    public void createDriver(){  //DO NOT change the method signature
	    //Create driver and assign it to 'static' driver variable
	     driver=DriverSetup.getWebDriver();
	}
	
	@DataProvider(name = "Agent")
	public Object[][] agentRegistration() throws java.io.IOException {   //DO NOT change the method signature
		//Parse data from Agent.xlsx, store in excelData variable and return the 2-dimensional array
		//Parse data from Agent.xlsx, store in excelData variable and return the 2-dimensional array
		File file1 = new File("Agent.xlsx");
		filePath = file1.getAbsolutePath();
    	System.out.println(filePath);
    	FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		System.out.println("fpath " + filePath);
		int sheetcount = workbook.getNumberOfSheets();
		System.out.println("sheetcount " + sheetcount);
		XSSFSheet testSheet = workbook.getSheetAt(0);
		int numRows = testSheet.getLastRowNum() + 1;
		int numCols = testSheet.getRow(0).getLastCellNum();
		System.out.println(numRows);
		System.out.println(numCols);
		excelData = new String[numRows][numCols];
		System.out.println("Populating Array");
		for (int k = 0; k < numRows; k++) {
			XSSFRow row = testSheet.getRow(k);
			for (int j = 0; j < numCols; j++) {
				XSSFCell cell = row.getCell(j);
				//excelData[k][j] = cell.toString();
				excelData[k][j]=(j==4)?
                row.getCell(j).getRawValue():
                row.getCell(j).toString();
          		System.out.println(excelData[k][j]);
			}
		}
		return excelData;   
	}
	
	@Test(dataProvider="Agent",priority=0)
	void testAgent (String Fname,String Lname,String Uname,String pwd, String phone, String email){ //DO NOT change the method signature
		//Annotate this method with data provider name as "Agent". Add 'priority=0'
		//Fill the form using data parsed from excel and submit
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(Fname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Lname);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Uname);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@name='phonenumber']")).sendKeys(phone);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
		driver.findElement(By.id("submit")).click();
	}
	
	@Test(testName="testName",priority=1)
	void testName (){   //DO NOT change the method signature
	    // Locate the first name in "Registered Successfully page". Assert it against the excel data.Set 'Name doesnt match 'custom failure message in assert 
	    String eName1 =  driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]")).getText();
		String[] eName = eName1.split(" ");
		Assert.assertEquals("Name doesnt match",excelData[0][0], eName[0]);
    }
	
	@Test(testName="testUserName",priority=2)
	void testUserName (){   //DO NOT change the method signature
		// Locate the user name in "Registered Successfully page". Assert it against the excel data.Set 'Username doesnt match 'custom failure message in assert
		String eUserName =  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText();
		Assert.assertEquals("Username doesnt match",excelData[0][2], eUserName);
	}
	@Test(testName="testPhone",priority=3)
	void testPhone(){  //DO NOT change the method signature
		// Locate the phone in "Registered Successfully page". Assert it against the excel data.Set 'Phone doesnt match 'custom failure message in assert
		String ePhone =  driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]")).getText();
		Assert.assertEquals("Phone doesnt match",excelData[0][4], ePhone);
	}
	@Test(testName="testEmail",priority=5)
	void testEmail(){   //DO NOT change the method signature
        // Locate the email in "Registered Successfully page". Assert it against the excel data.Set 'Email doesnt match 'custom failure message in assert
        String eMail1 =  driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]")).getText();
        Assert.assertEquals("Email doesnt match",excelData[0][5], eMail1);
	}
	
	public void checkAgent() {            //DO NOT change the method signature
	    //Invoke the test using TestNG ONLY HERE.
	    TestNG testSuite = new TestNG();
		testSuite.setTestClasses(new Class[] { Ex6TestNG.class });
		testSuite.run();
	}
	
	public static void main(String[] args) throws Exception  {
	    Ex6TestNG ex5=new Ex6TestNG();
	    //Add required code here
	    ex5.createDriver();
	    ex5.agentRegistration();
		//ex5.checkAgent();
	}	
}



-----CC3----
CargoShipping
================================================================================
import java.io.File;
import java.io.FileInputStream;
import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.poi.ss.usermodel.*;
public class CargoShipping {
                // Location of the excel file
                public static String filePath = null;
                static XSSFWorkbook wb;
                static XSSFSheet sheet;
                static XSSFRow rowvalue;
                static XSSFCell cellvalue;
                static FileOutputStream fos;
                static FileInputStream excelFile;
                static Object[][] str;
                public static String getExcelPath(String firstSheetName) throws IOException {
                                // get the file path of the excel sheet
                                filePath = System.getProperty("user.dir")+"/cargo.xlsx";
                                File file = new File(filePath);
                                FileInputStream excelFile = new FileInputStream(file);
                                wb = new XSSFWorkbook(excelFile);
                                if(wb.getSheet(firstSheetName)==null)
                                {
                                                sheet = wb.createSheet(firstSheetName);
                                }
                                /*for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                                            System.out.println("Sheet name: " + wb.getSheetName(i));
                                                if((wb.getSheetName(i)).equalsIgnoreCase(firstSheetName))
                                                {
                                                                wb.removeSheetAt(i);
                                                }
                               }*/
                                return filePath;
                }
                public static Object[][] readExcelData(String firstSheetName) throws Exception {
                            // read the data from excel sheet and store it in 2-D array. Return the array
                                sheet = wb.getSheet(firstSheetName);
                                int numRows = sheet.getLastRowNum() + 1;
                                int numCols = sheet.getRow(0).getLastCellNum();
                                str = new Object[numRows][numCols];
                                for (int i = 0; i < numRows; i++) {
                                                rowvalue = sheet.getRow(i);
                                                for (int j = 0; j < numCols; j++) {
                                                                cellvalue = rowvalue.getCell(j);
                                                                DataFormatter fmt = new DataFormatter();
                                                                String value = fmt.formatCellValue(cellvalue);
                                                                str[i][j] = value;
//                                                            System.out.println(str[i][j]);
                                                }
                                }
                                return str;
                }
                public static void writeExcelData(String firstSheetName, String displayMsg,String testCaseResult,int row) throws Exception
                {
                                //Write the display message and test result in the new sheet 'customervalid1'
                                sheet = wb.getSheet(firstSheetName);
                                int firstColumn = 0;
                                if(displayMsg.equalsIgnoreCase("Dear Customer, your total shipping cost is $200"))
                                {
                                                rowvalue = sheet.createRow(row);
                                                cellvalue = rowvalue.createCell(firstColumn);
                                                cellvalue.setCellValue(displayMsg);
                                                cellvalue = rowvalue.createCell(++firstColumn);
                                                cellvalue.setCellValue(testCaseResult);
                                }
                               else if(displayMsg.equalsIgnoreCase("Dear Customer, your total shipping cost is $50"))
                                {
                                               rowvalue = sheet.createRow(row);
                                                cellvalue = rowvalue.createCell(firstColumn);
                                                cellvalue.setCellValue(displayMsg);
                                                cellvalue = rowvalue.createCell(++firstColumn);
                                                cellvalue.setCellValue(testCaseResult);
                                }
                                fos = new FileOutputStream(filePath);
                                wb.write(fos);
               }
}

================================================================================
SeleniumTestForm
================================================================================
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class SeleniumTestForm {     //DO NOT change the class name
    public static WebDriver driver;
    public static String result1;       //Store the message displayed on the page after submit
    public static String result2;
   public void createDriver() {
                //Create driver and store in in static variable 'driver'
                WebDriver driver = DriverSetup.getWebDriver();
    }
    public void testSeleniumTestForm(String weight, String transportMode) throws Exception {
                                // Pass the weight and transpot mode read from excel sheet to this method.
                                // Send these data to form and submit.
                                // Retrieve the message displayed on page after submit. Store it in variable
                                // 'result1'
                                // Assert the message retrieved with expected.
                                // Write the data, message retrieved and "Test Passed" or "Test Failed" to a new
                                // sheet 'customervalid1'
                                driver.findElement(By.id("weight")).clear();
                                driver.findElement(By.id("weight")).sendKeys(weight);
                                driver.findElement(By.id(transportMode)).click();
                                driver.findElement(By.id("calculate")).click();
                                result1 = driver.findElement(By.id("result")).getText();
                                String expectedText1 = "Dear Customer, your total shipping cost is $200";
                                String expectedText2 = "Dear Customer, your total shipping cost is $50";
                                if (result1.equalsIgnoreCase(expectedText1) || result1.equalsIgnoreCase(expectedText2)) {
                                                result2 = "true";
                                } else {
                                                result2 = "false";
                               }
                                if(transportMode.equalsIgnoreCase("air"))
                                {
                                                CargoShipping.writeExcelData("customervalid1", result1, result2, 0);
                               }
                                else
                                {
                                                CargoShipping.writeExcelData("customervalid1", result1, result2, 1);
                                }
                }
                public static void main(String[] args) throws Exception {
                                SeleniumTestForm st = new SeleniumTestForm();
                                // Add code here
                                st.createDriver();
                                CargoShipping.getExcelPath("customervalid1");
                                st.testSeleniumTestForm("200", "air");
                                st.testSeleniumTestForm("100", "road");
                               CargoShipping.readExcelData("customervalid1");
                }
}
