import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class amazon_Modules extends amazon_AutoScripts {
	/* Name of the module: launch URL
	 * Brief description: Launch URL 
	 * Arguments: URL --> String 
	 * Created By: Rohini Londhe 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void launch(String URL) throws IOException, InterruptedException {
		
		driver=new FirefoxDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	/* Name of the module: mousehover
	 * Brief description:Moving mouse over desired link or tab
	 * Arguments: obj--> WebElement, objName --> String 
	 * Created By: Rohini Londhe 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
	public static void mousehover(WebElement obj,String objName) throws IOException{
		String bgcolor= obj.getCssValue("background-color");
		System.out.println("Before mouse over color of " +objName +" is: " +bgcolor);
		
		Actions action =new Actions(driver);
		action.moveToElement(obj).build().perform();
		
		String bgcolor1= obj.getCssValue("color");
		System.out.println("After mouse over color of " +objName +" is highlighted and is: "+bgcolor1);
		Update_Report( "Pass", objName+ "is ",  "Highlighted after mouse over");
	}
		
	}

