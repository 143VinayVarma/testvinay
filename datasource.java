XML Parsing -1
-------------------
NameLocator.java

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
public class NameLocator   //DO NOT Change the class Name
{
public static WebDriver driver;
public static XPath xpath;
public static Document doc;
public static DocumentBuilder dBuilder;
public WebDriver createDriver() //DO NOT change the method signature
{
  //Implement code to create Driver from DriverSetup, set to 'static' driver variable and return it
  DriverSetup d=new DriverSetup();
  driver=d.getWebDriver();
  return driver;
}
public XPath ReadFile(String xmlfileName,String id)throws XPathExpressionException, SAXException, Exception   //DO NOT change the method signature
    {
        //Implement code to read and assign the XPath object reference to xpath static variable
             File XmlFile = new File(xmlfileName);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                dBuilder = dbFactory.newDocumentBuilder();
                 doc = dBuilder.parse(XmlFile);
                 xpath =  XPathFactory.newInstance().newXPath();
                 return xpath;
   }
    public  String getFirstName(int id)throws Exception {
        //Implement code to return firstname from xml
          String expression = String.format("/UserDetails/User[@id='"+id+"']/Firstname");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String firstname = node.getTextContent();
        return firstname;
   }
    public  String getLastName(int id)throws Exception {
        //Implement code to return lastname from xml
         String expression = String.format("/UserDetails/User[@id='"+id+"']/Lastname");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
       String lastname = node.getTextContent();
       return lastname;
    }
    public  String getUserName(int id)throws Exception {
        //Implement code to return username from xml
           String expression = String.format("/UserDetails/User[@id='"+id+"']/Username");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String username = node.getTextContent();
         return username;
   }
    public  String getPassword(int id)throws Exception{
        //Implement code to return passworf from xml
          String expression = String.format("/UserDetails/User[@id='"+id+"']/Password");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String password = node.getTextContent();
         return password;
    }
      public  String  getMessage()throws  Exception{  
        //Implement code to submit form with values got from xml and return the success message printed on the page.
        String f=getFirstName(1);
        String l=getLastName(1);
        String u=getUserName(1);
        String p=getPassword(1);
        driver.findElement(By.id("firstname")).sendKeys(f);
        driver.findElement(By.id("lastname")).sendKeys(l);
        driver.findElement(By.id("username")).sendKeys(u);
        driver.findElement(By.id("pass")).sendKeys(p);
        driver.findElement(By.id("reg")).click();
        return "Registered Successfully";
    }
public static void main(String[] args) throws Exception
{
      NameLocator pagLocator=new NameLocator();
   pagLocator.ReadFile(System.getProperty("user.dir")+"/Userdetails.xml","1");
   pagLocator.getMessage();
   driver.close();
  //Implement the required code
   //Close the driver
}
}
---------------------------------------------------------------
XML -2 
FieldLocator.java
---------------------------------------------------
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
public class FieldLocator {  //DO NOT Change the class Name
  public static WebDriver driver;
	public static XPath xpath;
public static Document doc;
  public static DocumentBuilder dBuilder;
	public WebDriver createDriver() //DO NOT change the method signature
	{
	   //Implement code to create Driver from DriverSetup, set to 'static' driver variable and return it
	   DriverSetup d=new DriverSetup();
  driver=d.getWebDriver();
  return driver;
	}
public XPath ReadFile(String xmlfileName,String id)  throws XPathExpressionException, SAXException, Exception  //DO NOT change the method signature
    {
        //Implement code to read and return XPath object reference
        File XmlFile = new File(xmlfileName);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                dBuilder = dbFactory.newDocumentBuilder();
                 doc = dBuilder.parse(XmlFile);
                 xpath =  XPathFactory.newInstance().newXPath();
                  return xpath;
    }	
	public  String getCustomerName(int id) throws Exception{
        //Implement code to return customername from xml  
         String expression = String.format("/CustomerDetails/Customer[@id='"+id+"']/Customername");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String Customername = node.getTextContent();
        return Customername;
    }
    public  String getInvoiceNumber(int id) throws Exception{
       //Implement code to return invoicenumber from xml   
       String expression = String.format("/CustomerDetails/Customer[@id='"+id+"']/Invoicenumber");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String Invoicenumber = node.getTextContent();
        return Invoicenumber;
    }
    public  String getAmount(int id) throws Exception{
        //Implement code to return amount from xml 
        String expression = String.format("/CustomerDetails/Customer[@id='"+id+"']/Amount");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String Amount = node.getTextContent();
        return Amount;
    }
   public  String getMobileNumber(int id) throws Exception{
        //Implement code to return phone number from xml   
        String expression = String.format("/CustomerDetails/Customer[@id='"+id+"']/Mobilenumber");
        Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
        String Mobilenumber = node.getTextContent();
        return Mobilenumber;
    }
     public  String  getMessage() throws Exception{  
        //Implement code to submit form with values got from xml and return the success message printed on the page.
          String c=getCustomerName(1);
        String l=getInvoiceNumber(1);
        String a=getAmount(1);
        String m=getMobileNumber(1);
        driver.findElement(By.id("name")).sendKeys(c);
        driver.findElement(By.id("number")).sendKeys(l);
        driver.findElement(By.name("amount")).sendKeys(a);
        driver.findElement(By.name("num")).sendKeys(m);
        driver.findElement(By.id("submit")).click();
       return "Registered Successfully";
      }
     public static void main(String[] args) throws Exception
	{
	    FieldLocator pagLocator=new FieldLocator();
	   //Implement the required code
	    //Close the driver
	     pagLocator.ReadFile(System.getProperty("user.dir")+"/CustomerDetails.xml","1");
   pagLocator.getMessage();
   driver.close();
	} 
}

-------------------------
JSON-1 fieldLocator.java
--------------------------------------
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class FieldLocator //DO NOT Change the class Name
{
	JSONArray address;
	public static WebDriver driver;
	public static JSONArray addressBook;
	public static JSONObject jsonObject;
	public static JSONParser parser;
	public static Object obj;
	public static JSONObject o;
	String nickName;
	String ContactName;
	String city;
	String type;
 public void createDriver() //DO NOT change the method signature
	{
	   //Implement code to create Driver from DriverSetup and set to 'static' driver variable
	  driver= DriverSetup.getWebDriver();
	}
	
	public JSONArray ReadFile(String fileName)  throws Exception //DO NOT change the method signature
    {
        //Implement code to read and return addresses as JSON array 
        JSONParser parser= new JSONParser();
    obj= parser.parse(new FileReader(fileName));
      jsonObject =(JSONObject)obj;
        addressBook=(JSONArray)jsonObject.get("Addresses");
        System.out.println(addressBook.size());
return addressBook;        
   }
    public String getNickName(int id) {
	  //Implement code to return nickname from address
     o=(JSONObject)addressBook.get(id-1);
        String ID=""+id+"";
        nickName =(String)o.get("NickName");
        System.out.println("nickname" + nickName);
        return nickName;
    }

	public String getContactName(int id) {
		//Implement code to return contactname from address
		o=(JSONObject)addressBook.get(id-1);
        String ID=""+id+"";
    ContactName =(String)o.get("ContactName");
        System.out.println("contactName" + ContactName);
        return ContactName;
	}

	public String getCity(int id) {
		//Implement code to return city from address
			o=(JSONObject)addressBook.get(id-1);
        String ID=""+id+"";
    city =(String)o.get("City");
        System.out.println("city" + city);
        return city;
	}

	public String getType(int id) {
		//Implement code to return type from address
			o=(JSONObject)addressBook.get(id-1);
        String ID= ""+id+"";
    type =(String)o.get("Type");
        System.out.println("Type" + type);
        return type;
	}

	public String getMessage() {
		//Implement code to submit form with values got from json and return the success message printed on the page.
		driver.findElement(By.id("nickname")).sendKeys(nickName);
			driver.findElement(By.id("contact")).sendKeys(ContactName);
				driver.findElement(By.id("city")).sendKeys(city);
					driver.findElement(By.id("type")).sendKeys(type);
						driver.findElement(By.id("add")).click();
						return "Registered successfully";
	}

	public static void main(String[] args) throws Exception{
		FieldLocator pagLocator=new FieldLocator();
	   //Implement the required code
	    //Close the driver
	    String path=System.getProperty("user.dir")+"/AddressBook.json";
	    pagLocator.createDriver();
	    pagLocator.ReadFile(path);
	    for(int i=1;i<addressBook.size();i++)
{
    pagLocator.getNickName(i);
    pagLocator.getContactName(i);
    pagLocator.getCity(i);
    pagLocator.getType(i);
    pagLocator.getMessage();
    
    }
    driver.close();
}
}

-----------------------------
Json-2 NAMElOCATOR.JAVA
--------------------------------
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class NameLocator //DO NOT Change the class Name
{
	JSONArray address;
	public static WebDriver driver;
	public static JSONArray agent;
	public static JSONObject jsonObject;
	public static JSONParser parser;
	public static Object obj;
	public static JSONObject o;
	String FirstName;
	String LastName;
	String UserName;
	String Password;
	String PhoneNumber;
	String Email ;
 public void createDriver() //DO NOT change the method signature
	{
	     driver= DriverSetup.getWebDriver();
	   //Implement code to create Driver from DriverSetup and set to 'static' driver variable
	}
	
	public JSONArray ReadFile(String fileName)  throws Exception //DO NOT change the method signature
    {
        //Implement code to read and return agents as JSON array 
        JSONParser parser= new JSONParser();
    obj= parser.parse(new FileReader(fileName));
      jsonObject =(JSONObject)obj;
        agent=(JSONArray)jsonObject.get("Agents");
        System.out.println(agent.size());
return agent;  
    }
    public String getFirstName(int id) {
		//Implement code to return firstname from agent
		o=(JSONObject)agent.get(id-1);
        String ID=""+id+"";
        FirstName =(String)o.get("FirstName");
        System.out.println("nickname" + FirstName);
        return FirstName;
	}

	public String getLastName(int id) {
		//Implement code to return lastname from agent
			o=(JSONObject)agent.get(id-1);
        String ID=""+id+"";
        LastName =(String)o.get("LastName");
        System.out.println("LastName" + LastName);
        return LastName;
	}

	public String getUserName(int id) {
	//Implement code to return username from agent
	o=(JSONObject)agent.get(id-1);
        String ID=""+id+"";
        UserName =(String)o.get("UserName");
        System.out.println("UserName" + UserName);
        return UserName;
	}

	public String getPhoneNumber(int id) {
		//Implement code to return phonenumber from agent
		o=(JSONObject)agent.get(id-1);
        String ID=""+id+"";
        PhoneNumber =(String)o.get("PhoneNumber");
        System.out.println("PhoneNumber" + PhoneNumber);
        return PhoneNumber;
	}
	
	public String getPassword(int id) {
		//Implement code to return password from agent
			o=(JSONObject)agent.get(id-1);
        String ID=""+id+"";
        Password =(String)o.get("Password");
        System.out.println("Password" + Password);
        return Password;
	}
	public String getEmail(int id) {
		//Implement code to return email from agent
			o=(JSONObject)agent.get(id-1);
        String ID=""+id+"";
        Email =(String)o.get("Email");
        System.out.println("Email" + Email);
        return Email;
	}
	public String getMessage() {
		//Implement code to submit form with values got from json and return the success message printed on the page.
driver.findElement(By.name("firstname")).sendKeys(FirstName);
			driver.findElement(By.name("lastname")).sendKeys(LastName);
				driver.findElement(By.name("username")).sendKeys(UserName);
					driver.findElement(By.name("password")).sendKeys(PhoneNumber);
						driver.findElement(By.name("phonenumber")).sendKeys(Password);
						driver.findElement(By.name("email")).sendKeys(Email);
						return "Registered successfully";
	}

	public static void main(String[] args) throws Exception{
		NameLocator nameLocator = new NameLocator();
		//Implement the required code
	    //Close the driver
	    String path=System.getProperty("user.dir")+"/AgentDetail.json";
	    nameLocator.createDriver();
	    nameLocator.ReadFile(path);
	    for(int i=1;i<agent.size();i++)
{
    nameLocator.getFirstName(i);
    nameLocator.getLastName(i);
   nameLocator.getUserName(i);
   nameLocator.getPhoneNumber(i);
    nameLocator.getPassword(i);
    nameLocator.getEmail(i);
    nameLocator.getMessage();
   }
    driver.close();
}
}
