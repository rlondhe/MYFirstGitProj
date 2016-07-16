import java.io.IOException;
import java.util.List;
//import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazon_AutoScripts extends amazon_ReusableMethods{
	static WebDriver driver;
//Test ID 001: Launch The Amazon Application
public static void Launch_Amazon_application() throws IOException, InterruptedException{
	startReport("Launch Amazon application","C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("http://www.amazon.com/");
	Update_Report( "Pass", "Launch Amazon application",  "Amazon application is launched");
	bw.close();
	driver.quit();
	}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 002: Verify Drop Down Option after Iphone  is Typed in Search 
public static void searchbox() throws IOException, InterruptedException{
startReport("Searchbox","C:/Users/rohin/Desktop/SeleniumTest/Report");	
String dropdownentries1= "iphone 6s case in All Departments";
String dropdownentries2= "iphone 6s case in Electronics";
String dropdownentries3= "iphone 6s case in Cell Phones & Accessories";
                    
amazon_Modules.launch("http://www.amazon.com/");

WebElement search= driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
enterText(search, "Iphone", "Iphone");
Thread.sleep(1000);

WebElement dd1= driver.findElement(By.id("issDiv0"));
validateentry(dd1, dropdownentries1);

WebElement dd2= driver.findElement(By.id("issDiv1"));
validateentry(dd2, dropdownentries2);

WebElement dd3= driver.findElement(By.id("issDiv2"));
validateentry(dd3, dropdownentries3);

bw.close();
driver.quit();
}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 003:Click on Search Button after "Iphone " is entered and confirm 
public static void searchprop() throws IOException, InterruptedException{
	String expectedsearchresult="\"Iphone\"";
	startReport("searchprop","C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("http://www.amazon.com/");
	
	WebElement search= driver.findElement(By.xpath(".//*[@id='twotabsearchtextbox']"));
	enterText(search, "Iphone", "Iphone");
	Thread.sleep(1000);
	
	WebElement searchbutton=driver.findElement(By.xpath(".//*[@id='nav-search']/form/div[2]/div/input"));
	
	amazon_Modules.mousehover(searchbutton, "Search");
	
	Update_Report( "Pass", "SearchButton",  "Search Button highlighted");
	clickElement(searchbutton,"Search Button");
	
	WebElement searchresult= driver.findElement(By.xpath(".//*[@id='bcKwText']/span"));
	validateentry(searchresult, expectedsearchresult);
	System.out.println("Results for iphone are displayed");	
	
	bw.close();
	driver.close();
	}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 004: Verify Show results for Column on the left -"Cell Phones & Accessories "Header 
public static void mouseover_CellPhonesheader() throws IOException, InterruptedException{
	startReport("mouseover_CellPhonesheader" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("http://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone");
	
	WebElement cellphone= driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[3]/a/span[1]"));
	WebElement accessories= driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[4]/a/span[1]"));
	WebElement cellCases = driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[5]/a/span[1]"));
	WebElement seeMore= driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
	
	amazon_Modules.mousehover(cellphone, "cellphone");
	amazon_Modules.mousehover(accessories, "accessories");
	amazon_Modules.mousehover(cellCases, "cellCases");
	amazon_Modules.mousehover(seeMore,"seeMore");
	
	bw.close();
	driver.quit();
	
}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 005: Verify Show results for Column  on the left -" Computers & Accessories "Header 
public static void Computers_Accessories() throws IOException, InterruptedException{
startReport("Computers_Accessories" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
amazon_Modules.launch("https://www.amazon.com/s/ref=nb_sb_ss_i_1_15?url=search-alias%3Dcomputers&field-keywords=computer+components&sprefix=computer+compon%2Cundefined%2C180");

WebElement components= driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[4]/a/span[1]"));
WebElement computerCases=driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[11]/a/span[1]"));

amazon_Modules.mousehover(components,"Computer components");
amazon_Modules.mousehover(computerCases, "Computer cases");
bw.close();
driver.quit();

}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 006: Verify Show results for Column  on the left -" Computers & Accessories "Header
public static void electronics() throws IOException, InterruptedException{
	startReport("Electronics" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("https://www.amazon.com/gp/search/ref=sr_hi_1?rh=n%3A172282%2Ck%3Aelectronics&keywords=electronics&ie=UTF8&qid=1468635949");
	
	WebElement officeElectronics= driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[3]/a/span[1]"));
	WebElement audiospeakers= driver.findElement(By.xpath(".//*[@id='refinements']/div[2]/ul[1]/li[6]/a/span[1]"));
	WebElement seeMoresub = driver.findElement(By.xpath(".//*[@id='seeAllDepartmentClosed1']/li/span/a/span[2]"));
	
	amazon_Modules.mousehover(officeElectronics,"office Electronics");
	amazon_Modules.mousehover(audiospeakers,"audiospeakers");
	amazon_Modules.mousehover(seeMoresub,"seeMore sub-catagories");
	bw.close();
	driver.quit();
}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 007: Verify Show results for Column  on the left -"  Refine by "Header 
public static void refinedby() throws IOException, InterruptedException{
	startReport("refinedby" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("https://www.amazon.com/s/ref=nb_sb_noss_2?url=search-alias%3Daps&field-keywords=iphone&ajr=2");
	
	Thread.sleep(3000);
	try{
		WebElement amezon_prime= driver.findElement(By.xpath(".//*[@id='ref_2470954011']/li/a/img[1]"));
		deSelectCheckBox(amezon_prime, "amezon_prime");
		}catch(Throwable e){
				}
		
	WebElement Eligible_FreeShipping = driver.findElement(By.xpath(".//*[@id='ref_2491144011']/li/a/img"));
	deSelectCheckBox(Eligible_FreeShipping, "Eligible for Free Shipping");
	
	WebElement internationalShipping = driver.findElement(By.xpath(".//*[@id='ref_2944662011']/li/a/span"));
	deSelectCheckBox(internationalShipping, "Amezon Global Eligible");
	
	WebElement pkgOptions = driver.findElement(By.xpath(".//*[@id='ref_7252854011']/li/a/span[1]"));
	deSelectCheckBox(pkgOptions, "Frustration free packaging");
	
	WebElement brand= driver.findElement(By.xpath(".//*[@id='refinements']/h2[3]"));
	if(brand.isDisplayed()){
		List <WebElement> allbrands=driver.findElements(By.xpath(".//*[@id='ref_2528832011']/li"));
		for(int i=0;i<allbrands.size()-1;i++){
			String text=allbrands.get(i).getText();
			amazon_Modules.mousehover(allbrands.get(i),text);
			deSelectCheckBox(allbrands.get(i), text);
		}
		
		WebElement memory= driver.findElement(By.xpath(".//*[@id='refinements']/h2[4]"));
		if(memory.isDisplayed()){
			List <WebElement> alltypes=driver.findElements(By.xpath(".//*[@id='ref_7805160011']/li"));
			for(int i=0;i<alltypes.size();i++){
				String text=alltypes.get(i).getText();
				amazon_Modules.mousehover(alltypes.get(i),text);
				deSelectCheckBox(alltypes.get(i), text);
			}	
			
		}		
		WebElement avg_customer_reiew= driver.findElement(By.xpath(".//*[@id='refinements']/h2[13]"));
		if(avg_customer_reiew.isDisplayed()){
			List <WebElement> allreviews=driver.findElements(By.xpath(".//*[@id='ref_2491147011']/li"));
			for(int i=0;i<allreviews.size();i++){
				String text=allreviews.get(i).getText();
				amazon_Modules.mousehover(allreviews.get(i),text);
							}	
		}
				
		driver.quit();
		bw.close();
			}
	}	
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 007: TC01 (Check MainTab)
public static void allLinksonMainpage() throws IOException, InterruptedException{
	startReport("allLinksonMainpage" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("https://www.amazon.com/");
	
	WebElement department =driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
	amazon_Modules.mousehover(department,"Department");
	
	WebElement list= driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]"));
	String[] expecteditems={"Amazon Video","Digital & Prime Music","Appstore for Android","Amazon Photos & Drive","Kindle E-readers & Books","Fire Tablets","Fire TV","Echo & Alexa","Books & Audible","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools","Beauty, Health & Grocery","Toys, Kids & Baby","Clothing, Shoes & Jewelry","Sports & Outdoors","Automotive & Industrial","Handmade","Home Services","Credit & Payment Products"};
	
	validateDropdownentry(list,expecteditems,"Department entries");
	
	WebElement container = driver.findElement(By.xpath(".//*[@id='nav-xshop-container']"));
	List <WebElement> linklist = container.findElements(By.tagName("a"));
	for(int i=0;i<linklist.size();i++)
	{
		WebElement link = linklist.get(i);
		amazon_Modules.mousehover(link,"Links");
		System.out.println(linklist.get(i).getText() + " is available for click");
	}
	
	WebElement container1 = driver.findElement(By.xpath(".//*[@id='nav-tools']"));
	List <WebElement> linklist1 = container1.findElements(By.tagName("a"));
	for(int i=0;i<linklist1.size();i++)
	{
	WebElement link1 = linklist1.get(i);
	amazon_Modules.mousehover(link1,"Links");
	System.out.println(linklist1.get(i).getText() + " is clicked");
	}
	
	
	bw.close();
	driver.quit();
}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 009: Validate 'Department' dropdown list
public static void deptdropdown() throws IOException, InterruptedException{
	startReport("Department_dropdown" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("https://www.amazon.com");
	Thread.sleep(3000);	

	WebElement department =driver.findElement(By.xpath(".//*[@id='nav-link-shopall']/span[2]"));
	amazon_Modules.mousehover(department,"Department");
	
	WebElement list= driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]"));
	String[] expecteditems={"Amazon Video","Digital & Prime Music","Appstore for Android","Amazon Photos & Drive","Kindle E-readers & Books","Fire Tablets","Fire TV","Echo & Alexa","Books & Audible","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools","Beauty, Health & Grocery","Toys, Kids & Baby","Clothing, Shoes & Jewelry","Sports & Outdoors","Automotive & Industrial","Handmade","Home Services","Credit & Payment Products"};
	
	validateDropdownentry(list,expecteditems,"Department entries");
	System.out.println("");
	System.out.println("All entries in the Departmentdropdown are matched");
	bw.close();
	driver.quit();
}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 010: Validate 'Your Account' dropdown list
public static void accountdropdown() throws InterruptedException, IOException{
	startReport("Account_dropdown" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("https://www.amazon.com");
	Thread.sleep(3000);
	
	String[] expecteditems1= {"Sign in","New customer? Start here.","Your Account","Your Orders","Your Lists","Your Recommendations","Your Subscribe & Save Items","Your Digitial Subscriptions","Your Service Requests","Your Prime Membership","Your Garage","Register for a Business Account","Your Amazon Credit Card Accounts","Manage Your Content and Devices","Your Video Subscriptions","Your Prime Music","Your Music Library","Your Amazon Drive","Your Prime Video","Your Kindle Unlimited","Your Watchlist","Your Video Library","Your Android Apps & Devices"};
	
	WebElement acc = driver.findElement(By.xpath(".//*[@id='nav-link-yourAccount']"));
	amazon_Modules.mousehover(acc,"Your Account");
	
	WebElement accbox =driver.findElement(By.xpath(".//*[@id='nav-flyout-yourAccount']"));
	
	List <WebElement> accentries= accbox.findElements(By.tagName("a"));
	
			for(int i=0;i<accentries.size();i++){
				String match= accentries.get(i).getText();
			if(match.equals(expecteditems1[i]));
			{
				Update_Report("Pass", "validate Dropdown entry",  "Expected menu item:" +match + "is matched to actual item: "+expecteditems1[i]);
							}
						}
			
			System.out.println("");
			System.out.println("All entries in the Account dropdown are matched");
			bw.close();
			driver.close();
			
}
/*---------------------------------------------------------------------------------------------------------------------*/
// Test ID 011: TC04 (Validate 'Try Prime' dropdown list)
public static void tryprime() throws IOException, InterruptedException{
	
	startReport("tryprime" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("https://www.amazon.com");
	Thread.sleep(3000);
	
	WebElement tp = driver.findElement(By.xpath(".//*[@id='nav-link-prime']/span[2]"));
	amazon_Modules.mousehover(tp,"Try Prime");
	
	bw.close();
	driver.quit();
}
/*---------------------------------------------------------------------------------------------------------------------*/
//Test ID 012:TC05 (Validate 'Lists' dropdown list)
public static void listdropdown() throws IOException, InterruptedException{
	startReport("listdropdown" ,"C:/Users/rohin/Desktop/SeleniumTest/Report");
	amazon_Modules.launch("https://www.amazon.com");
	Thread.sleep(3000);
	
String[] expecteditems2= {"Create a List","Find a List or Registry","Find a Gift","Save Items from the Web","Install Amazon Assistant","Wedding Registry","Baby Registry","Kids' Birthdays","School Lists","Friends & Family Gifting","Pantry Lists","Your Hearts (in Fashion)" };

WebElement listbox = driver.findElement(By.xpath(".//*[@id='nav-link-wishlist']"));
amazon_Modules.mousehover(listbox,"List");       

Thread.sleep(3000);

WebElement list= driver.findElement(By.xpath(".//*[@id='nav-flyout-wishlist']/div[2]"));
validateDropdownentry2(list,expecteditems2,"List entries");

System.out.println("");
System.out.println("All entries in the List dropdown are matched");

bw.close();
driver.quit();
}
}












































//String bgcolor= searchbutton.getCssValue("background-color");
//System.out.println("Before mouse hover color is " +bgcolor);
//
//Actions action =new Actions(driver);
//action.moveToElement(searchbutton).build().perform();
//
//String bgcolor1= searchbutton.getCssValue("background-color");
//System.out.println("After mouse hover color is " +bgcolor1);

