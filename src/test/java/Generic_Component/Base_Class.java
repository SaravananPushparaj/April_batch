package Generic_Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {
	
	public Process process;
	public AppiumDriver driver;
	
	Utility_Class c1= new Utility_Class();
	//start the appium server
	public void Start_Appiumserver() throws IOException, InterruptedException
	{
		
		String start_server="D:\\Appium\\node.exe   D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		
		process=Runtime.getRuntime().exec(start_server);
		
		if(process!=null)
		{
			System.out.println("Appium Started");
		}
		else
		{
			System.out.println("NOT started Appium");
		}
		
		Thread.sleep(15000);
		
	}
	
	//stop the appium server
	public void StopAppiumServer() throws InterruptedException
	{
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(5000);
			System.out.println("Appium server Stopped");
		}
	}
	
	
	
	public void InitApp() throws IOException
	{
		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName", "GT-I9300I");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.4");
		
		System.out.println(c1.reading_properties("Package_name"));
		System.out.println(c1.reading_properties("Activity_name"));
		
		capabilities.setCapability("appPackage",c1.reading_properties("Package_name") );
		capabilities.setCapability("appActivity",c1.reading_properties("Activity_name") );
		
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
	}
	
	public void Explicit_wait(WebElement ele,long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver,T1);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	
	public void Snapshot(String TC_ID, String Order) throws IOException
	{
		
		Date date= new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		File file= new File(dateformat.format(date)+".png");
		
		
		TakesScreenshot screenshot= (TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshotAs, new File("D:\\BB_Project\\Screenshot\\" +TC_ID+"-"+Order+"-"+file ));
		
	}
	
	
	
}
