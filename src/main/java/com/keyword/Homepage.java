package com.keyword;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homepage {
	
	public static void openbrowser(String bname)
	{
		switch(bname)
		{
		 case "Chrome":
			System.out.println("Opening chrome");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
			Constant.driver=new ChromeDriver();
			break;
				
		 case "Firefox":
			 System.out.println("Opening Firefox");
			 System.setProperty("webdriver.gecko.driver","E:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			 Constant.driver= new FirefoxDriver();
			 //driver1.get("http:\\www.google.com");
			 break;
		}
	}
	public static void openurl(String url)
	{
		Constant.driver.get(url);
	}
	//----------------------------------------------------------------------------------------------
			//Properties file:--
			private static void getWebElement(String locatorType,String locatorValue) 
			   {
			 	   switch(locatorType) 
				   {
				    	   case "XPATH":
							   Constant.driver.findElement(By.xpath(locatorValue)).click();
						   break;
						   case "CSS":
							   Constant.driver.findElement(By.cssSelector(locatorValue)).click();;
						   break;
						   case "ID":
							   Constant.driver.findElement(By.id(locatorValue)).click();
						   break;
						   case "LINKTEXT":
							   Constant.driver.findElement(By.linkText(locatorValue)).click();
						   break;
						   case "PARTIALLLINKTEXT":
							   Constant.driver.findElement(By.partialLinkText(locatorValue)).click();
						   break;
						   case "CLASS":
							   Constant.driver.findElement(By.className(locatorValue)).click();
						   break;
						   default:
							   System.err.println("Invalide locator name:"+locatorType+",Excepted:CSS.Xpath,LinkText,Partiall link text,class name");
						   break;
				    }
			      }
			//_______________________________________________________________________________________
			
			private static void getWebElement(String locatorType,String locatorValue,String txt) 
			   {
				   switch(locatorType) 
				   {
				    	   case "XPATH":
							   Constant.driver.findElement(By.xpath(locatorValue)).sendKeys(txt);
						   break;
						   case "CSS":
							   Constant.driver.findElement(By.cssSelector(locatorValue)).sendKeys(txt);
						   break;
						   case "ID":
							   Constant.driver.findElement(By.id(locatorValue)).sendKeys(txt);
						   break;
						   case "LINKTEXT":
							   Constant.driver.findElement(By.linkText(locatorValue)).sendKeys(txt);
						   break;
						   case "PARTIALLLINKTEXT":
							   Constant.driver.findElement(By.partialLinkText(locatorValue)).sendKeys(txt);
						   break;
						   case "CLASS":
							   Constant.driver.findElement(By.className(locatorValue)).sendKeys(txt);
						   break;
						   default:
							   System.err.println("Invalide locator name:"+locatorType+",Excepted:CSS.Xpath,LinkText,Partiall link text,class name");
						   break;
				    }
				  }
//-----------------------------------------------------------------------------------------------
			
			public static void enterText(String locatorType,String locatorValue,String texttoenter) 
			{
				   getWebElement(locatorType, locatorValue,texttoenter);
				  
			}
			public static void clickitem(String locatorType,String locatorValue) 
			{
				   getWebElement(locatorType,locatorValue);
			}
//-----------------------------------------------------------------------------------------
			//Take a screen shot
		public static void takescreenshot() throws IOException 
		{
			File scr = ((TakesScreenshot)Constant.driver).getScreenshotAs(OutputType.FILE);
		    String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		    System.out.println(""+filename);
		    File dest = new File("filePath/" + filename);
		    FileUtils.copyFile(scr, dest);
		    System.out.println(""+dest);
		 }
		
//----------------------------------------------------------------------------------------
		//take  screen shot
		public static void capturescreen() throws IOException
		{
			Robot robo;
			int count=1;
			try {
			robo = new Robot();
			Rectangle rect=new Rectangle();
			rect.setFrame(0,0,600,600);
			BufferedImage img=robo.createScreenCapture(rect);
			ImageIO.write(img,"PNG", new File("E:\\Java\\com.simplehybrid\\ScreenShot\\Scanned Documents.UsingRobot.png"+count));
			count++;
			} 
			catch (AWTException e) 
			{
				e.printStackTrace();
			}
		}
//--------------------------------------------------------------------------------------
		//Scroll the page Up and Down
		
		public static void up() 
		{
			 JavascriptExecutor js = (JavascriptExecutor)Constant.driver;
		     js.executeScript("window.scrollBy(0,-2000)", "");
		}
		 public static void down() 
		 {
			 JavascriptExecutor js1 = (JavascriptExecutor)Constant.driver;
			 js1.executeScript("window.scrollBy(0,2000)", "");
		 }
	
//--------------------------------------------------------------------------------------------------		 
		 //closed driver and browser
		 
		 public static void tearDown() throws InterruptedException
			{
			     Thread.sleep(3000);
				 Constant.driver.close();
			     Constant.driver.quit();
			 }
//--------------------------------------------------------------------------------------------------
		 public static void Returnhomepage()
			{
				JavascriptExecutor js = (JavascriptExecutor)Constant.driver;
				js.executeScript("window.history.go(-1)");
				System.out.println("Amazon Homepage");
			}
			
}
