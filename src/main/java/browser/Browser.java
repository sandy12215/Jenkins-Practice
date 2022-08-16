package browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Demo.Demo;
import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Browser {
	public static WebDriver driver;	
	public static WebDriverWait wait;
	public static ExtentHtmlReporter reporter= new ExtentHtmlReporter("./Extentreports/extentreport.html");
	public static ExtentReports extent= new ExtentReports();
	/*
	 * WebDriver Setup Selection Method
	 */
	public static WebDriver setDriver() {
		Demo.log4jMethod(2);
		extent.attachReporter(reporter);
		ExtentTest logger= extent.createTest("Opening browser extent test");
		logger.log(Status.INFO, "Opening browser");
		
		try {
			Demo.log4jMethod(1);
			String browserChoice = Browser.fileProperties("browser");//chrome
			if (browserChoice.equals("chrome")) {
				driver = setChromeDriver();
			} else if (browserChoice.equals("firefox")) {
				driver = setFirefoxDriver();
			} else if (browserChoice == "Edge") {
				driver = setEdgeDriver();
			} else 
			{ 
				System.out.println("Invalid data...");
			}
			logger.log(Status.PASS, "Opening browser passed");
		}catch (Exception e)
		{
			Demo.log4jMethod(4);
			logger.log(Status.FAIL, "Open browser failed!");
			System.out.println("Browser Input");
			System.out.println(e);
		}
		extent.flush();
		return driver;
	}
		
	/*
	 *  ChromeDriver Setup Method
	 */
	public static WebDriver setChromeDriver() {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}catch(Exception e)
		{
			System.out.println("Chrome");
			System.out.println(e);
		}
		return driver;
	}

	// Internet Explorer Driver Setup Method
	public static WebDriver setFirefoxDriver() {
		try {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}catch(Exception e)
		{
			System.out.println("Firefox");
			System.out.println(e);
		}
		return driver;
	}

	// Microsoft Edge Driver Setup Method
	public static WebDriver setEdgeDriver() {
		try {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}catch(Exception e)
		{
		System.out.println("Edge");
		System.out.println(e);
		}
		return driver;
	}
	
	
	public static String fileProperties(String propertiesData)//browser
	{
		String returnData = null;
		String searchData = propertiesData;//browser
		try {
			String filelocation = System.getProperty("user.dir") + "\\src\\main\\resources\\configuration.properties";
			File file = new File(filelocation);
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileinput);
			returnData = prop.getProperty(searchData); //browser
			}catch(Exception e)
			{
			System.out.println("Properties");
			}
		return returnData;
	}

	// Url Setup Method
	public static void getUrl(String url) throws Exception {
		try {		
			driver.manage().window().maximize();
			driver.navigate().to(url);
		}catch(Exception e)
		{
			System.out.println("URL Method");
		}
	}
	
	// Method to get title of the browser window
	public static String getTitle() throws Exception {
		String actualTitle = driver.getTitle();
		return actualTitle;			
	}
	
	// Driver Close Method
	public static void closeBrowser() {
		try {
			driver.quit();
		}catch(Exception e)
		{
			System.out.println("closing");
		}
	}
}
