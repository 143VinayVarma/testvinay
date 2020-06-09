testing.xml
<?xml version="1.0" encoding="UTF-8"?>
<suite name="Suite" >
  <test name="Test">
    <classes>
        <!-- Add required entry -->
         <class name="Ex3TestNG">
         </class>
     </classes>
  </test> 
</suite> 

----------------------
Ex3TestNG.java
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

@Listeners(FeatureTest.class)       //DO NOT remove or alter this line. REQUIRED FOR TESTING
public class Ex3TestNG               //DO NOT Change the class Name
{
public static WebDriver driver;
static XSSFWorkbook wb;
static XSSFSheet sheet;
static XSSFRow row;
static XSSFCell cell;
static Object[][] str;
@BeforeSuite
public void createDriver() {           //DO NOT change the method signature
//Create driver and assign it to 'static' driver variable
DriverSetup d=new DriverSetup();
driver=d.getWebDriver();
}
   
@DataProvider(name="shipmentData")
public Object[][] shipmentData() throws Exception        //DO NOT change the method signature
{
//Parse data from Shipmentdetails.xlsx and return the 2-dimensional array
String path = System.getProperty("user.dir")+"/ShipmentDetails.xlsx";
File filePath = new File(path);
FileInputStream ExcelFile = new FileInputStream(filePath);
wb = new XSSFWorkbook(ExcelFile);
sheet = wb.getSheet("Data");
int numRows = sheet.getLastRowNum() + 1;
int numCols = sheet.getRow(0).getLastCellNum();
str = new Object[numRows][numCols];
for (int i = 1; i < numRows; i++) {
row = sheet.getRow(i);
for (int j = 0; j < numCols; j++) {
cell = row.getCell(j);
DataFormatter fmt = new DataFormatter();
String value = fmt.formatCellValue(cell);
str[i-1][j] = value;
System.out.println(str[i][j]);
}
}
return str;
}
//DO NOT change the method signature
@Test(dataProvider ="shipmentData")
void testShipment (String orginPort,String destinationPort,String railModeCharge,String roadModeCharge,String airModeCharge) throws InterruptedException
{
//Select the souce/destination as specified in description.
// Test the tabled data against the excel data as specified in description.
Select s=new Select(driver.findElement(By.xpath("//select[@name='origin_id']")));
s.selectByVisibleText("Mumbai");
Select e=new Select(driver.findElement(By.xpath("//select[@name='destination_id']")));
e.selectByVisibleText("New York");
System.out.println(orginPort);
driver.findElement(By.xpath("//input[@type='submit']")).click();
String rail=driver.findElement(By.xpath("(//table//tbody/tr/td[2])[1]")).getText();
String road=driver.findElement(By.xpath("(//table//tbody/tr/td[2])[2]")).getText();
String air=driver.findElement(By.xpath("(//table//tbody/tr/td[2])[3]")).getText();

try {
    Assert.assertEquals(railModeCharge, rail);
} catch (AssertionError a) {
    System.out.println("The Rail mode Charge doesnt match");
    throw a;
}
try {
    Assert.assertEquals(roadModeCharge, road);
} catch (AssertionError a) {
    System.out.println("The Road mode Charge doesnt match");
    throw a;
}
try {
    Assert.assertEquals(airModeCharge, air);
} catch (AssertionError a) {
    System.out.println("The Air mode Charge doesnt match");
    throw a;
}
}
public  void shipment() {
   //Invoke the test using TestNG ONLY HERE.
   TestNG t=new TestNG();
   t.setTestClasses(new Class[] {Ex3TestNG.class});
   try{
   t.run();
   }
   catch(Exception e){
       
   }
}
public static void main(String[] args) {
Ex3TestNG ex3=new Ex3TestNG();
   //Implement any required code.
   ex3.shipment();
}
}


----------------

Ex2TestNG.java
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.annotations.AfterTest;

@Listeners(FeatureTest.class)         //DO NOT remove or alter this line. REQUIRED FOR TESTING
public class Ex2TestNG {             //DO NOT Change the class Name
public static WebDriver driver;
String name;
String password;

@BeforeSuite
public void createDriver() {                  //DO NOT change the method signature
//Create driver and assign it to 'static' driver variable
driver= DriverSetup.getWebDriver();
}
@BeforeTest
public void resetName() {                   //DO NOT change the method signature
//NO implementation required. ONLY proper annotation is required.
}
@AfterTest
public void signin() {                       //DO NOT change the method signature
System.out.println("signin");
}
@Test(priority=1)
public void initializeName() {                //DO NOT change the method signature
name="Tom";
}
@Test(priority=0)
public void initializePassword() {           //DO NOT change the method signature
password="Tom";
}
@AfterSuite
public void closeBrowser() {                //DO NOT change the method signature
//close the driver
driver.close();
}
public void invokeTest() {                 //DO NOT change the method signature
//Implement code to invoke test using TestNG
TestNG testsuite=new TestNG();
testsuite.setTestClasses(new Class[] {
Ex2TestNG.class
});
try {
testsuite.run();
} catch(Exception e) {
}
}
public static void main(String[] args) {
Ex2TestNG ex2=new Ex2TestNG();
//Implement any required
ex2.invokeTest();
}
}


----------------
Ex1TestNG.java
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

//ADD the required TestNG annotations on respective methods
public class Ex1TestNG {         //DO NOT Change the class Name
	
	//Do NOT change these below declarations.
	public static WebDriver driver; 
	String name;
	String password;
	
@BeforeSuite
public void createDriver() {         //DO NOT change the method signature
//Implement code to create Driver from DriverSetup and assign it to 'static' driver variable
driver= DriverSetup.getWebDriver();
    }
@Test(groups={"init"})
public void initializeName() {         //DO NOT change the method signature
name="Tom";
}
@Test(groups={"init"})
public void initializePassword() {    //DO NOT change the method signature      
password="Tom";
}
@Test(dependsOnGroups={"init"})
public void signin() {               //DO NOT change the method signature
System.out.println("signin");
}
@AfterSuite
public void closeBrowser() {         //DO NOT change the method signature
driver.close();
}

public static void main(String[] args){          //DO NOT change the method signature
   Ex1TestNG page=new Ex1TestNG();
   //Implement the required code
   page.createDriver();
   page.initializeName();
   page.initializePassword();
   page.signin();
   page.closeBrowser();   
}
}




------Ex4TestNG------
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

@Listeners(FeatureTest.class)         //DO NOT remove or alter this line. REQUIRED FOR TESTING
public class Ex4TestNG               //DO NOT Change the class Name
{
	public static WebDriver driver;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    static XSSFRow row;
    static XSSFCell cell;
    static Object[][] str;
    static int numRows;
    static int numCols;

    @BeforeSuite
    public void createDriver() {         //DO NOT change the method signature
		//Create driver and assign it to 'static' driver variable
		DriverSetup d=new DriverSetup();
        driver=d.getWebDriver();
    }
	
	@DataProvider(name="commodityData")
	public Object[][] commodityData() throws Exception  //DO NOT change the method signature
	{
	    //Parse data from CommodityDetails.xlsx and return the 2-dimensional array
	    //Parse data from Shipmentdetails.xlsx and return the 2-dimensional array
	    
	    String path = System.getProperty("user.dir")+"/CommodityDetails.xlsx";
        File filePath = new File(path);
        FileInputStream ExcelFile = new FileInputStream(filePath);
        wb = new XSSFWorkbook(ExcelFile);
        sheet = wb.getSheet("Data");
        numRows = sheet.getLastRowNum() + 1;
        numCols = sheet.getRow(0).getLastCellNum();
        str = new Object[numRows][numCols];
        for (int i = 1; i < numRows; i++) {
        row = sheet.getRow(i);
        for (int j = 0; j < numCols; j++) {
        cell = row.getCell(j);
        DataFormatter fmt = new DataFormatter();
        String value = fmt.formatCellValue(cell);
        str[i-1][j] = value;
        System.out.println(str[i][j]);
        }
        }
        return str;
    }

    @Test(dataProvider ="commodityData")
	void testCommodity (String name,String weight,String length,String width,String height) throws InterruptedException
	{
	    //Pass the form data parsed from excel sheet and submit form
	    //Find the elements of the newly displayed row on the page and compare the values against the excel data as mentioned in the description
	    
		for (int k=1; k<=numRows; k++) 
		{
        String name1 = driver.findElement(By.xpath("//*[@id='name']")).getText();
        String weight1=driver.findElement(By.xpath("//*[@id='weight']")).getText();
        String length1=driver.findElement(By.xpath("//*[@id='length']")).getText();
		String width1=driver.findElement(By.xpath("//*[@id='width']")).getText();
        String height1=driver.findElement(By.xpath("//*[@id='height']")).getText();
        //driver.findElement(By.xpath("//input[@type='submit']")).click();
		try {
            Assert.assertEquals(name, name1);
        } catch (AssertionError a) {
            System.out.println("name doesnt match");
            throw a;
        }
		try {
            Assert.assertEquals(weight, weight1);
        } catch (AssertionError a) {
            System.out.println("weight doesnt match");
            throw a;
        }
        try {
            Assert.assertEquals(length, length1);
        } catch (AssertionError a) {
            System.out.println("length doesnt match");
            throw a;
        }
        try {
            Assert.assertEquals(width, width1);
        } catch (AssertionError a) {
            System.out.println("width doesnt match");
            throw a;
        }
        try {
            Assert.assertEquals(height, height1);
            } catch (AssertionError a) {
            System.out.println("height doesnt match");
            throw a;
        }
		}
    }
	public  void commodity() {
	    //Invoke the test using TestNG ONLY HERE.
	    TestNG t=new TestNG();
        t.setTestClasses(new Class[] {Ex4TestNG.class});
        try{
            t.run();
        }
        catch(Exception e){
        }
	}
	public static void main(String[] args) {
		Ex4TestNG ex4=new Ex4TestNG();
	    //Implement any required code.  
	    ex4.commodity();
	}
}
