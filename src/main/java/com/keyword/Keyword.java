package com.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Keyword {
	
	  @FindBy(how=How.XPATH,using="//*[@id='ap_email']") 
	  static WebElement b1;
	  
	  @FindBy(how=How.XPATH,using="//input[@id='continue']") 
	  static WebElement b2;
	  
	public static void enterusername() 
	  { 
		  b1.sendKeys("7083155351"); 
		  b2.click();
	  }
	  
	  @FindBy(how=How.XPATH,using="//*[@id='ap_password']") 
	  static WebElement b3;
	  @FindBy(how=How.XPATH,using="//input[@id='signInSubmit']") 
	  static WebElement b4; 
	  
	  public static void enteruserpassword() 
	  { 
		b3.sendKeys("Abc@123"); 
		b4.click();
	  }	  
		@FindBy(id="twotabsearchtextbox")
		static WebElement txtserach;
		
		@FindBy(css=".nav-input[type='submit']")
		static WebElement btnsearch;
		
		public static void searchproduct(String pname)
		{
			txtserach.sendKeys(pname);
			btnsearch.click();
		}
		
}

