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
    public static String result;
    
    public void createDriver() {
    	//Create driver and store in in static variable 'driver'
    	  driver= DriverSetup.getWebDriver();
    }

   
    public void testSeleniumTestForm(String weight,String transportMode) throws Exception {
    	//Pass the weight and transpot mode read from excel sheet to this method.
    	//Send these data to form and submit. 
    	//Retrieve the message displayed on page after submit. Store it in variable 'result1'
    	//Assert the message retrieved with expected.
    	//Write the data, message retrieved and "Test Passed" or "Test Failed" to a new sheet 'customervalid1'
    	driver.findElement(By.id("weight")).sendKeys(weight);
        driver.findElement(By.id(transportMode)).click();
        driver.findElement(By.id("calculate")).click();
        result1= driver.findElement(By.id("result")).getText();
        System.out.println(result1);
		//*[@id="result"]
		if(result1.equals("Dear Customer, your total shipping cost is $200"))
		{
			result ="pass";
			result1 = "Dear Customer, your total shipping cost is $200";
		}else if (result1.equals("Dear Customer, your total shipping cost is $50"))
		{
			result ="pass";
			result1 = "Dear Customer, your total shipping cost is $50";
		}
		else
			result="fail";
    }
    
    public static void main(String[] args) throws Exception 
	{ 				
		SeleniumTestForm st=new SeleniumTestForm();
		//Add code here
		st.createDriver();
        st.testSeleniumTestForm("200","Air");
        String path = System.getProperty("user.dir")+"/cargo.xlsx";
        CargoShipping.writeExcelData(path, result1, result,0);
	}
}

-------------
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CargoShipping    //DO NOT change the class name
{
	
	//Location of the excel file
    public static String filePath = null;
    public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static File file;
	public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCell cell1;
    
    public static Row row1;
    public static Cell cell11;
    public static Cell cell12;
	
    public static void getExcelPath(String firstSheetName)  {
    String path=System.getProperty("user.dir")+"/cargo.xlsx";
	
	 try {
            fis = new FileInputStream(path);
	       
        } catch(FileNotFoundException fnfe) { 
            System.out.println(fnfe.getMessage());
        } 
	 try {
			workbook = new XSSFWorkbook(fis);
	        sheet= workbook.getSheet(firstSheetName);
		}
			catch(IOException e) {
			e.printStackTrace();
		}
    }
    
    public static Object[][] readExcelData(String firstSheetName) throws Exception 
    {
    //read the data from excel sheet and store it in 2-D array. Return the array
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
    
    public static void writeExcelData(String firstSheetName, String displayMsg,String testCaseResult,int row) throws Exception 
    {
	//Write the display message and test result in the new sheet 'customervalid1'
	//Write the Test result to the excel sheet
    file= new File(firstSheetName);   
    fis= new FileInputStream(file);
    workbook= new XSSFWorkbook(fis);
    sheet= workbook.createSheet(customervalid1");   
    row1= sheet.createRow(row);
	row1.createCell(0).setCellValue(displayMsg);        
    row1.createCell(1).setCellValue(testCaseResult);
    /*
    cell11= row1.createCell(0);
	cell12= row1.createCell(1);
	cell11.setCellValue(displayMsg);
    cell12.setCellValue(testCaseResult);
	*/
    fos= new FileOutputStream(file);
    workbook.write(fos);
    fos.close(); 
	}
}
