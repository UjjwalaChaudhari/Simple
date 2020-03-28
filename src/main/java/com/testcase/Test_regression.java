package com.testcase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.keyword.Constant;
import com.keyword.Homepage;
import com.keyword.Keyword;

import Fileutility.PropertiesFile;

public class Test_regression 
{
	 //Open Url with Chrome
	 @BeforeSuite 
	 public void Tc_01() throws InterruptedException 
	 {
	 Homepage.openbrowser("Chrome"); Homepage.openurl("https://www.amazon.in");
	 Constant.driver.manage().window().maximize();
	 Constant.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	 System.out.println("amazon 1"); 
	 }
	 
	 //Login in with firefox for parallel testing
	 @Test(enabled=false)
	 public void Tc() throws InterruptedException 
	 {
	 Homepage.openbrowser("Firefox"); Homepage.openurl("https://www.amazon.com");
	 Constant.driver.manage().window().maximize();
	 Constant.driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	 System.out.println("amazon 2");
	 Homepage.clickitem(PropertiesFile.getLocator("lgn")[0],PropertiesFile. getLocator("lgn")[1]);
	 Homepage.enterText(PropertiesFile.getLocator("email")[0],PropertiesFile.getLocator("email")[1],"7083155351");
	 Homepage.clickitem(PropertiesFile.getLocator("ck1")[0],PropertiesFile.getLocator("ck1")[1]);
	 Homepage.enterText(PropertiesFile.getLocator("pwd")[0],PropertiesFile.getLocator("pwd")[1],"Abc@123");
	 Homepage.clickitem(PropertiesFile.getLocator("ck2")[0],PropertiesFile.getLocator("ck2")[1]); 
	 Homepage.tearDown(); 
	 }
	 
	 //Login in and select Watch Item for search and take screenshot
	 
	  @Test(enabled=false) 
	  public void Tc_02() { 
	  try {
	  Constant.driver.findElement(By.xpath("//*[@id='nav-link-accountList']")).click(); 
	  System.out.println("Login click");
	  PageFactory.initElements(Constant.driver,Keyword.class);
	  Keyword.enterusername(); 
	  System.out.println("Enter Username");
	  Thread.sleep(1000); Keyword.enteruserpassword();
	  System.out.println("Enter Password"); 
	  Thread.sleep(5000);
	  System.out.println("Login successful"); 
	  Keyword.searchproduct("Watch");
	  Homepage.down(); 
	  Homepage.takescreenshot();
	  System.out.println("Product enter to watcch"); 
	  Thread.sleep(1000);
	  Homepage.up(); 
	  Homepage.Returnhomepage(); 
	  } 
	  catch(Exception e) {
	  e.printStackTrace(); 
	  }
 }
	  
	  //Select TODAYDEAL menu and click and take capturescreen
	  @Test(priority=1) 
	  public void Tc_03() 
	  { 
	try {
	  Homepage.clickitem(PropertiesFile.getLocator("todaydeal")[0],PropertiesFile.getLocator("todaydeal")[1]); 
	  Thread.sleep(3000); 
	  Homepage.down();
	  Homepage.capturescreen(); 
	  Thread.sleep(3000); 
	  Homepage.up();
	  Homepage.Returnhomepage(); 
	  } 
	  catch (Exception e) { 
	   e.printStackTrace();
	  System.out.println("Error"); 
	  }
	  }
	  
	  //Drop-Down list and select item
	  
	 @Test(priority=3) 
	 public void Tc_04() throws InterruptedException 
	 { 
	  Select book=new Select(Constant.driver.findElement(By.xpath("//*[@id='searchDropdownBox']")));
	  book.selectByVisibleText("Amazon Fashion");
	  System.out.println("select Amazon Fashion");
	  Homepage.enterText(PropertiesFile.getLocator("amazondress")[0],PropertiesFile.getLocator("amazondress")[1],"Dresses for Women");
	  Homepage.clickitem(PropertiesFile.getLocator("submit")[0],PropertiesFile.getLocator("submit")[1]); System.out.println("select dress");
	  Homepage.Returnhomepage(); 
	 }
	 
    
	//---------------------------------------------------------------------------------------
	@Test(dataProvider="Data")
	public void showdata(String uname,String pass) {
		System.out.println("username-"+uname+"passwd--"+pass);
	}
	@DataProvider(name="Data")
	public String[][] provider() throws IOException {
		String[][] data=null;
		FileInputStream fis =null; 
		Workbook book = null;
		try {
		fis=new FileInputStream("E:\\Java\\com.simplehybrid\\src\\test\\resources\\Data.xlsx");
		book=new XSSFWorkbook(fis);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		XSSFSheet sheet=(XSSFSheet) book.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		Row row=sheet.getRow(0);
		 data= new String[rows][row.getLastCellNum()];
		 for (int i = 1; i <=rows; i++) {
			  row = sheet.getRow(i);
			int cells=row.getLastCellNum();
			for (int j = 0; j <cells; j++) {
				XSSFCell cell =(XSSFCell) row.getCell(j);
				
				DataFormatter d=new DataFormatter();			   
				data[i-1][j]=d.formatCellValue(cell);
			}
		}
		return data;


	}
//----------------------------------------------------------------------------------------
	
	
	
	  //Closed Browser
	  
	  @AfterTest public void Tc_10() throws InterruptedException 
	  {
	  Homepage.tearDown(); 
	  }
	 
		
}