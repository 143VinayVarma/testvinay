--POM1---
package pom;;
////CUSREGExcel:

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Arrays;
public class CusRegExcel {         //Do not change the class name
public static XSSFWorkbook workbook;
public static XSSFSheet sheet;
public static FileInputStream fis;
//Use this declaration to store values parsed from excel
    public static String[] customerData=new String[5];
   
    public static String[] readExcelData(String fileName) throws IOException{   //Do not change the method signature
   
        //Implement code to read data from excel file. Store the values in 'customerData' array. Return the array. */
       fis = new FileInputStream(fileName);
workbook = new XSSFWorkbook(fis);
sheet= workbook.getSheet("customervalid");

XSSFRow rows= sheet.getRow(0);
int columnsCount=sheet.getRow(0).getPhysicalNumberOfCells();
   
        for (int j=0; j<columnsCount; j++) {
            XSSFCell cell = rows.getCell(j);
            DataFormatter formatter = new DataFormatter();
          customerData[j] = formatter.formatCellValue(cell);
           
        }  
        return customerData;


}

}


/////Selenium TestForm

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;

public class SeleniumTestForm {      //Do not change the class name
    public static WebDriver driver;
   
    public void createDriver() {                //Do not change the method signature
        //Implement code to create driver and assign it to 'static' driver variable
       driver= DriverSetup.getWebDriver();
    }

    public void testSeleniumTestForm() throws Exception {    //Do not change the method signature
    //Read the data from excel sheet. Sheet name is 'customervalid'
       //find the elements in the form and set values parsed from excel sheet. Submit the form for registration
           String path = System.getProperty("user.dir")+"/CustReg.xlsx";
        String[] customer = CusRegExcel.readExcelData(path);
       driver.findElement(By.xpath("//input[@name='cname']")).sendKeys(customer[0]);
        driver.findElement(By.xpath("//input[@name='age']")).sendKeys(customer[1]);
         driver.findElement(By.xpath("//input[@name='address']")).sendKeys(customer[2]);
          driver.findElement(By.xpath("//input[@name='phonenumber']")).sendKeys(customer[3]);
           driver.findElement(By.xpath("//input[@name='email']")).sendKeys(customer[4]);
            driver.findElement(By.id("submit")).click();
       
    }
    public void closeBrowser(){
        //close the browser
        driver.close();
    }

    public static void main(String[] args) throws Exception
{
   CusRegExcel customer = new CusRegExcel();
   //Add required code
   SeleniumTestForm stf= new SeleniumTestForm();
   stf.createDriver();
   stf.testSeleniumTestForm();
   stf.closeBrowser();
}
}




-------POM2------
package pom;;

import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestForm {          //DO NOT change the class name

    //Use this declarations to store respective values
    public static WebDriver driver;
    public static String result;
    public static String msg;
   
   
    public void createDriver() {
        //Implement code to create driver and assign it to 'static' driver variable
        driver= DriverSetup.getWebDriver();
       
    }

    public void testSeleniumTestForm(String weight,String transportMode)  throws Exception{
    //'weight' and 'transportMode' parameter are used to send the values to the form
        //find the elements in the form and set values as per description. Submit the form.
        //Find the element of the message displayed after submit. Store it in 'msg' variable.
        //Store the 'pass' or 'fail' in the 'result' variable
        driver.findElement(By.id("weight")).sendKeys(weight);
        driver.findElement(By.id(transportMode)).click();
         driver.findElement(By.id("calculate")).click();
        msg= driver.findElement(By.id("result")).getText();
        System.out.println(msg);
        if(msg.equals("Dear Customer, your total shipping cost is $200"))
   
        result ="pass";
   
    else
   
        result="fail";
   
        }
             
         
    public void closeBrowser(){
        //close the browser
        driver.close();
    }

    public static void main(String[] args) throws Exception
{

SeleniumTestForm st=new SeleniumTestForm();
//Add code here
st.createDriver();
st.testSeleniumTestForm("200","Air");
st.closeBrowser();


String path = System.getProperty("user.dir")+"/cargo.xlsx";
 System.out.println(result);
 CargoShipping.writeExcelData(path,result);




}
}


/// CargoShipping:
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class CargoShipping   //DO NOT change the class name
{
public static XSSFSheet sheet;
public static File file;
public static FileInputStream fis;
public static FileOutputStream fos;

public static XSSFWorkbook wb;
public static Row row;
public static Cell cell;
   
    public static void writeExcelData(String fileName,String result) throws Exception { //Do not change the method signature
        //Write the Test result to the excel sheet
    file= new File(fileName);
   
    fis= new FileInputStream(file);
    wb= new XSSFWorkbook(fis);
    sheet= wb.getSheet("TestCase");
   
    row= sheet.createRow(0);
    cell= row.createCell(0);
    cell.setCellValue(result);
    fos= new FileOutputStream(file);
    wb.write(fos);
    fos.close(); 
    }
   
}


---POI-1---
///cusregex
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class CusRegExcel {  
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fis;
	    public static Object[][] readExcelData(String sheetName){ //DO NOT change the method signature
	//Implement code to read data from excel sheet in a 2-D array. Return the array

	int rows= sheet.getPhysicalNumberOfRows();
	int columns=sheet.getRow(0).getPhysicalNumberOfCells();
	String[][] excelData = new String[rows][columns];
	   
	   
	    for (int i=0; i<rows; i++) {
	        XSSFRow row = sheet.getRow(i);
	        for (int j=0; j<columns; j++) {
	            XSSFCell cell = row.getCell(j);
	            DataFormatter formatter = new DataFormatter();
	          excelData[i][j] = formatter.formatCellValue(cell);
	           
	        }  
	     
	    }
	return excelData;

	    }

	 

	    public static String getExcelPath(String sheetName) throws Exception
	    {
	   //Implement code to locate the excel file. Return the filepath
	 String path=System.getProperty("user.dir")+"/CustReg.xlsx";
	// String path="CustReg.xlsx";
	fis = new FileInputStream(path);
	workbook = new XSSFWorkbook(fis);
	sheet= workbook.getSheet(sheetName);
	return path;
	   
	   
	    }

	    public static void main(String[] args) throws Exception
	{
	   CusRegExcel customer = new CusRegExcel();
	   //Add required code
	  customer. getExcelPath("customervalid");
	   
	 Object cust[][]=customer.readExcelData("customervalid");
	}

}




-----POI2-----
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.*;

public class CusRegExcel {     //DO NOT change the class name
public static XSSFWorkbook workbook;
public static File file;
public static FileInputStream fis;
public static FileOutputStream fos;
public static Workbook wb;
public static Sheet sh;
public static Cell cell;
public static Row row;

    //Wrire the below values into excel sheet. DO NOT change the values
    static String[] fields1 = new String[] { "Tester", "32" , "XYZ", "2323245235", "test1@gmail.com"};
static String[] fields2 = new String[] { "Tester1", "33" , "ABC", "4323245125", "test2@gmail.com"};
static String[] fields3 = new String[] { "Tester2", "34" , "KLM", "1323245235", "test3@gmail.com"};
         
    public static String getExcelPath(String sheetName) {          //DO NOT change the method signature
   //Implement code to locate excelsheet.
   //Return the filepath
   String path=System.getProperty("user.dir")+"/CustReg.xlsx";
   try
   {
   file= new File(path);
fis = new FileInputStream(file);
wb = WorkbookFactory.create(fis);
sh= wb.getSheet(sheetName);
   }
   catch(Exception e)
   {
      System.out.println("file not found");
   }
   finally
   {
return path;
   }
}

    public static void writeExcelData(String sheetName) throws Exception {         //DO NOT change the method signature
   //Implement code to write the given fields1,fields2,fields3 data to excel sheet.
   //Write from row zero(without any headers)
int rowCount= sh.getLastRowNum();
    row =sh.createRow(++rowCount);
    for(int i=0;i<fields1.length;i++)
    {
       cell= row.createCell(i);
       cell.setCellValue(fields1[i]);
    }
    row =sh.createRow(++rowCount);
    for(int i=0;i<fields2.length;i++)
    {
       cell= row.createCell(i);
       cell.setCellValue(fields2[i]);
    }
    row =sh.createRow(++rowCount);
    for(int i=0;i<fields3.length;i++)
    {
       cell= row.createCell(i);
       cell.setCellValue(fields3[i]);
    }
   fos= new FileOutputStream(file);
   wb.write(fos);
   fos.close();
   
            }
   
   
    public static void main(String[] args) throws Exception
{
   CusRegExcel customer = new CusRegExcel();
   //Add required code
   customer.getExcelPath("customervalid");
   customer.writeExcelData("customervalid");
}
}
