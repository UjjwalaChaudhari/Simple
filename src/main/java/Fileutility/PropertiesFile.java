package Fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.keyword.Constant;

public class PropertiesFile {
	public static String getProperty(String key) 
	{
		String value=null;
		try {
			Constant.fis=new FileInputStream("E:\\Java\\com.simplehybrid\\src\\test\\resources\\OR.properties");
            Constant.prop=new Properties();
            Constant.prop.load(Constant.fis);
            value=Constant.prop.getProperty(key);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Unable to open repository");
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public static String getProperty(String key,String filepath) 
	{
		String value=null;
		try {
			Constant.fis = new FileInputStream(filepath);
			Constant.prop=new Properties();
			Constant.prop.load(Constant.fis);
            value=Constant.prop.getProperty(key);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File"+filepath+"not found");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println("unable to load File"+filepath);
			e.printStackTrace();
		}
		return value;	
	}
	public static String[] getLocator(String key)
	{
		String[] value=null;
		try {
			Constant.fis=new FileInputStream("E:\\Java\\com.simplehybrid\\src\\test\\resources\\OR.properties");
			Constant.prop=new Properties();
			Constant.prop.load(Constant.fis);
            String part=Constant.prop.getProperty(key);
            value=part.split("##");
            System.out.println("Locator Type:"+value[0]);
            System.out.println("Locator Value:"+value[1]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return value;	
   }		

}
