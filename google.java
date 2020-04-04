package AA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class google {

	    public static void main(String[] args) {         

	    			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
	                WebDriver driver = new ChromeDriver();

	                System.out.println("Chrome is opened");

	                driver.get("http://www.google.com");

	                System.out.println("Google is selected");

	// Find the text input element by its name

	               WebElement element = driver.findElement(By.name("q"));

	// Enter something to search

	               element.sendKeys("Cheese!");            

	//Now submit the form to get the result from the element
	               element.submit();

	 // Check the title of the page

	               System.out.println("Page title is: " + driver.getTitle());

	               }

}

