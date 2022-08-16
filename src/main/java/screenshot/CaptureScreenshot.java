package screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import browser.Browser;

public class CaptureScreenshot extends Browser{
	public static void screenShot(String name) throws Exception {		//String fileName
		try {
		//Converting WebDriver object to takeScreenshoot
		TakesScreenshot scrShot =((TakesScreenshot)driver); 
		
		//Calling the getScreenshotAs() method to create an image file
		File Src=scrShot.getScreenshotAs(OutputType.FILE);	
		
		//Giving the location
		String filePath = System.getProperty("user.dir")+"//Screenshots//"+name+".png";
																	   
		//Moving image file to new destination
		File Dest=new File(filePath);	 
	
		//copying file at destination
		FileUtils.copyFile(Src, Dest);
		}
		catch(Exception e)
		{
			System.out.println("Screen Capture");
		}
	}
}
