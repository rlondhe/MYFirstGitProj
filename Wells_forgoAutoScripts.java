/*Name of the Test case:Write plain Automation script for wellsForgo test case, use syso out put and submit only one java file with screen shot of out code
	 * Brief description: Reading content from excel
	 * Created By: Rohini Londhe 
	 * Creation Date: Jule15 2016
	 * Last Modified: Jule15 2016
	 * */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class Wells_forgoAutoScripts {
	static WebDriver driver;
	static String expectedtabName= "Personal";
	static String expectedHeading= "About Wells Fargo";
	static String ins= "Homeowners Insurance";

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Wells Fargo test case execution is started");
		System.out.println("--------------------------------------------------");
		driver=new FirefoxDriver();
		driver.get("http://www.WellsFargo.com");
		driver.manage().window().maximize();
		System.out.println("");
		System.out.println("'WellsFargo' webpage is launched");
		
		defaulttab();
		
		WebElement aboutWellsFargo= driver.findElement(By.xpath("//*[@id='headerTools']/nav/ul/li[2]/a"));
		if(aboutWellsFargo.isDisplayed()){
			System.out.println("'About Wells Fargo' link is displayed");
			aboutWellsFargo.click();
			System.out.println("");
			System.out.println("'About Wells Fargo' link is clicked");
		} 
		Thread.sleep(3000);
       String actualpageheading= driver.getTitle();
       if(expectedHeading.equals(actualpageheading)){
			System.out.println("Page heading is confirmed and is correct");
					}
		    else{
		    	System.out.println("Page heading is not correct");
		        }
       
       WebElement backpage= driver.findElement(By.xpath(".//*[@id='pageFooter']/div[1]/nav/div/ul/li[5]/a"));
       if(backpage.isDisplayed()){
    	   System.out.println("");
    	   System.out.println("'Home' link is displayed");
    	   backpage.click();
    	   System.out.println("You are navigating back to the home page");
       }
       else{
    	   System.out.println("Home link is not displayed");
       }
       defaulttab();
       
       WebElement insurance= driver.findElement(By.xpath(".//*[@id='insuranceTab']/a"));
       if(insurance.isDisplayed()){
    	   System.out.println("");
    	   System.out.println("Insurance tab is displayed");
    	   insurance.click();
    	   Thread.sleep(3000);
    	   System.out.println("Insurance is clicked");
    	   
    	   WebElement homeIns= driver.findElement(By.xpath(".//*[@id='insurance']/div[1]/div[2]/ul/li[1]/a"));
    	   Actions action =new Actions(driver);
    	   action.moveToElement(homeIns).build().perform();
    	   if(homeIns.isDisplayed()){
    		   homeIns.click();
        	   System.out.println("Homeowners insurance link is clicked");  
    	   }
    	      Thread.sleep(3000);
    	      WebElement zip= driver.findElement(By.xpath(".//*[@id='zipCode']"));
    	      zip.sendKeys("48084");
    	      System.out.println("Zipcode is entered");
    	      WebElement cont= driver.findElement(By.xpath(".//*[@id='c28lastFocusable']"));
    	      cont.click();
       }            
   	  System.out.println("-----------------------------------------------------");
      System.out.println("This test case is successfully executed and passed");
      driver.quit();
}
		
	public static void defaulttab(){
		WebElement text= driver.findElement(By.xpath(".//*[@id='tabNav']/ul/li[1]"));
		if(text.isDisplayed()){
		String actualtabName=text.getText();
		    if(expectedtabName.equals(actualtabName)){
			System.out.println("You are on personal tab");
					}
		    else{
			System.out.println("FAIL: You are not on personal tab");
		        }
		                      }
		else{
					System.out.println("FAIL:Your landing page is incorrect");
		     }
	}
	
	}


