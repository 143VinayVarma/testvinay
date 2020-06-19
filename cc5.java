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
