import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class amazon_ReusableMethods {
	
	static BufferedWriter bw = null;
	static BufferedWriter bw1 = null;
	static String htmlname;
	static String objType;
	static String objName;
	static String TestData;
	static String rootPath;
	static int report;


	static Date cur_dt = null;
	static String filenamer;
	static String TestReport;
	int rowcnt;
	static String exeStatus = "True";
	static int iflag = 0;
	static int j = 1;

	static String fireFoxBrowser;
	static String chromeBrowser;

	static String result;

	static int intRowCount = 0;
	static String dataTablePath;
	static int i;
	static String browserName;

	@Test
	public void test() throws Exception {

		startReport("Decending order sort","C:/Users/rohin/Documents/Selenium_Session/Report");

		Update_Report( "Pass", "Decending order sort",  "Decending order sort executing is complete.");
		bw.close();
	}
	/* Name of the Method: startReport
	 * Brief description: Start creating a report 
	 * Arguments: scriptName --> String , ReportsPath --> String 
	 * Created By: Rohini Londhe 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */

	public static void startReport(String scriptName, String ReportsPath) throws IOException{

		String strResultPath = null;


		String testScriptName =scriptName;


		cur_dt = new Date(); 
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String strTimeStamp = dateFormat.format(cur_dt);

		if (ReportsPath == "") { 

			ReportsPath = "C:\\";
		}

		if (ReportsPath.endsWith("\\")) { 
			ReportsPath = ReportsPath + "\\";
		}

		strResultPath = ReportsPath + "Log" + "/" +testScriptName +"/"; 
		File f = new File(strResultPath);
		f.mkdirs();
		htmlname = strResultPath  + testScriptName + "_" + strTimeStamp 
				+ ".html";



		bw = new BufferedWriter(new FileWriter(htmlname));

		bw.write("<HTML><BODY><TABLE BORDER=0 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TABLE BORDER=0 BGCOLOR=BLACK CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR><TD BGCOLOR=#FF5733 WIDTH=27%><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>Browser Name</B></FONT></TD><TD COLSPAN=6 BGCOLOR=#66699><FONT FACE=VERDANA COLOR=WHITE SIZE=2><B>"
				+ "FireFox " + "</B></FONT></TD></TR>");
		bw.write("<HTML><BODY><TABLE BORDER=1 CELLPADDING=3 CELLSPACING=1 WIDTH=100%>");
		bw.write("<TR COLS=7><TD BGCOLOR=#33E9FF WIDTH=3%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>SL No</B></FONT></TD>"
				+ "<TD BGCOLOR=#33E9FF WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Step Name</B></FONT></TD>"
				+ "<TD BGCOLOR=#33E9FF WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Execution Time</B></FONT></TD> "
				+ "<TD BGCOLOR=#33E9FF WIDTH=10%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Status</B></FONT></TD>"
				+ "<TD BGCOLOR=#33E9FF WIDTH=47%><FONT FACE=VERDANA COLOR=BLACK SIZE=2><B>Detail Report</B></FONT></TD></TR>");


	}

	public static void Update_Report(String Res_type,String Action, String result) throws IOException {
		String str_time;
		Date exec_time = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		str_time = dateFormat.format(exec_time);
		if (Res_type.startsWith("Pass")) {
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ "Passed"
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = GREEN>"
					+ result + "</FONT></TD></TR>");

		} else if (Res_type.startsWith("Fail")) {
			exeStatus = "Failed";
			report = 1;
			bw.write("<TR COLS=7><TD BGCOLOR=#EEEEEE WIDTH=3%><FONT FACE=VERDANA SIZE=2>"
					+ (j++)
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+Action
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2>"
					+ str_time
					+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=10%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
					+ "<a href= "
					+ htmlname
					+ "  style=\"color: #FF0000\"> Failed </a>"

				+ "</FONT></TD><TD BGCOLOR=#EEEEEE WIDTH=30%><FONT FACE=VERDANA SIZE=2 COLOR = RED>"
				+ result + "</FONT></TD></TR>");

		} 
	}
	/* Name of the Method: enterText
	 * Brief description: Enter text value to text boxes 
	 * Arguments: obj --> WebElement, textVal --> text to be entered, objName --> Object Name
	 * Created By: Rohini Londhe 
	 * Creation Date: July 15 2016
	 * Last Modified: July 15 2016
	 * */
public static void enterText(WebElement obj, String textVal, String objName) throws IOException{
		
	if(obj.isDisplayed()){
		obj.sendKeys(textVal);
		Update_Report("Pass", "enterText", textVal+ "  is entered in " + objName + " field");
	}else{
		Update_Report("Fail", "enterText", objName + " field is not displayed please check your application ");
	}
	
}
/* Name of the Method: clickElement
 * Brief description: Click on Web Button 
 * Arguments: obj --> WebElement Object,objName --> Object Name
 * Created By: Rohini Londhe 
 * Creation Date: July 15 2016
 * Last Modified: July 15 2016
 * */
public static void clickElement(WebElement obj, String objName) throws IOException{
	if(obj.isDisplayed()){
		obj.click();
		Update_Report("Pass", "clickElement", objName+ " is clicked");
}
	else{
		Update_Report("Fail", "clickElement", objName+" is not clicked");
	}
}
/* Name of the Method: ValidateErrorMessage
 * Brief description: validating Text message
 * Arguments: obj --> WebElement,expectedTextmsg--> String, objName --> String Name
 * Created By: Rohini Londhe 
 * Creation Date: July 15 2016
 * Last Modified: July 15 2016
 * */
public static void validateErrorMessage(WebElement obj, String expectedTextmsg, String objName ) throws IOException{
	 if(obj.isDisplayed()){
		String actucalTextmessage= obj.getText().trim();
		 //Update_Report("PASS", objName, "is displayed");
		 if(expectedTextmsg.equals(actucalTextmessage)){
		 Update_Report("Pass", "validateErrorMessage", " is matched with" +expectedTextmsg);
	  }else{
		  Update_Report("Fail", "validateErrorMessage",actucalTextmessage+ " is not matched with " +expectedTextmsg);
	  }
	 }
		 else{
			 Update_Report("Fail", "validateErrorMessage" , objName+" is not displayed. Please check your application");
		 }
	 }
/* Name of the Method: checkBoxselection
 * Brief description: Select Check box
 * Arguments: obj --> WebElement Object,objName --> String
 * Created By: Rohini Londhe 
 * Creation Date: July 15 2016
 * Last Modified: July 15 2016
 * */
public static void checkBoxselection(WebElement obj, String textVal) throws IOException{
	if(obj.isDisplayed()){
		Update_Report("Pass", "checkBoxselection",textVal +"  is displayed");
         if(obj.isSelected()){
	       Update_Report("Pass", "checkBoxselection",textVal +"  is seleced bydefault");
                             }
         else{
	     Update_Report("Fail", "checkBoxselection",textVal+ "  is not seleced bydefault");
	     obj.click();
	     Update_Report("Fail", "checkBoxselection",textVal+ "  is now seleced ");
}
}
}
/* Name of the Method: deSelectCheckBox
 * Brief description: De-select Check box
 * Arguments: obj --> WebElement ,textVal --> String
 * Created By: Rohini Londhe 
 * Creation Date: July 15 2016
 * Last Modified: July 15 2016
 * */
public static void deSelectCheckBox(WebElement obj, String textVal) throws IOException{
	if(obj.isDisplayed()){
		Update_Report("Pass", "deSelectCheckBox",textVal +"  is displayed");
         if(!obj.isSelected()){
	       Update_Report("Pass", "deSelectCheckBox",textVal +"  is deseleced bydefault");
                             }
         else  {
	     Update_Report("Fail", "deSelectCheckBox",textVal+ "  is  deseleced bydefault");
	     obj.click();
               }
                       }
}
/* Name of the Method: Select_user_menu_username_drop down
 * Brief description: Select user menu for <username> drop down
 * Arguments: obj --> WebElement ,textVal --> String
 * Created By: Rohini Londhe 
 * Creation Date: Jule 15 2016
 * Last Modified: Jule 15 2016
 * */
public static void validateDropdownentry(WebElement obj, String[]expecteditems, String objname) throws IOException{
	String[] actualStr = obj.getText().split("[\\r\\n]+");//check split function again
	if(obj.isDisplayed()){
		for(int i = 0; i < expecteditems.length-1; i++){

			if(actualStr[i].equals(expecteditems[i])){
				Update_Report("Pass", "validate Dropdown entry",  "Expected menu item is: "  +expecteditems[i]+ " is matched to actual item: "+actualStr[i]);

			}
			else{
				Update_Report("Fail", "validate Dropdown entry",  "Expected menu item is: "  +expecteditems[i]+ " is not matched to actual item: "+actualStr[i]);

			}

}
	}

}
/*Name of the Method: validateDropdownentry2
 * Brief description:  validate entry from the dropdown list
 * Arguments: dtTablePath -->selectFromDropDowselectFromDropDow String ,sheetName --> String
 * Created By: Rohini Londhe 
 * Creation Date: Jule 15 2016
 * Last Modified: Jule 15 2016
 * */
public static void validateDropdownentry2(WebElement obj, String[]expecteditems, String objname) throws IOException{
	String[] actualStr = obj.getText().split("[\\r\\n]+");//check split function again
	if(obj.isDisplayed()){
		for(int i = 0; i < expecteditems.length; i++){

			if(actualStr[i].equals(expecteditems[i])){
				Update_Report("Pass", "validate Dropdown entry",  "Expected menu item is: "  +expecteditems[i]+ " is matched to actual item: "+actualStr[i]);

			}
			else{
				Update_Report("Fail", "validate Dropdown entry",  "Expected menu item is: "  +expecteditems[i]+ " is not matched to actual item: "+actualStr[i]);

			}

}
	}

}
/*Name of the Method: Read excel
 * Brief description: Reading content from excel
 * Arguments: dtTablePath --> String ,sheetName --> String
 * Created By: Rohini Londhe 
 * Creation Date: Jule 15 2016
 * Last Modified: Jule 15 2016
 * */
public static String[][] readExcel(String dtTablePath, String sheetName) throws IOException
{
	
    File XLFile =new File(dtTablePath);
	
	FileInputStream XLDoc = new FileInputStream(XLFile);
	
	HSSFWorkbook wb = new HSSFWorkbook(XLDoc);
	
	HSSFSheet sheet= wb.getSheet(sheetName);
	
	int rowcount= sheet.getLastRowNum()+1;
	int colcount= sheet.getRow(0).getLastCellNum();// not getting why we haven't added +1 to column count
	
	String[][] Cellcontent= new String[rowcount][colcount];
		
	for(int i=0; i<rowcount;i++)
	{
		for(int j=0; j<colcount;j++){
		    Cellcontent[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
				}
		
	}
	return Cellcontent;
	
	}
/*Name of the Method: Write excel
 * Brief description: Write content into excel
 * Arguments: dtTablePath --> String ,sheetName --> String
 * Created By: Rohini Londhe 
 * Creation Date: Jule 15 2016
 * Last Modified: Jule 15 2016
 * */
public static void writeexcel(String dtTablePath, String sheetName, int irow, int icol, String textvalue) throws IOException{
	
    File XLFile =new File(dtTablePath);
	
	FileInputStream XLDoc = new FileInputStream(XLFile);
	
	HSSFWorkbook wb = new HSSFWorkbook(XLDoc);
	
	HSSFSheet sheet= wb.getSheet(sheetName);
	
	HSSFRow row =sheet.getRow(irow);
	
	HSSFCell cell=row.getCell(icol);
	cell.setCellValue(HSSFCell.CELL_TYPE_STRING);
	cell.setCellValue(textvalue);
	FileOutputStream fout= new FileOutputStream(dtTablePath);
	wb.write(fout);
	fout.flush();
	fout.close();

	}
/*Name of the Method:selectFromDropDown
 * Brief description:  select From DropDown
 * Arguments: dtTablePath -->selectFromDropDowselectFromDropDow String ,sheetName --> String
 * Created By: Rohini Londhe 
 * Creation Date: Jule 15 2016
 * Last Modified: Jule 15 2016
 * */
public static void selectFromDropDown(WebElement obj, String selectItem, String objname) throws Exception{
	if(obj.isDisplayed()){
		Select items = new Select(obj);
		items.selectByVisibleText(selectItem);
		Update_Report("Pass", "selectFromDropDown",  "Menu item is: "  +selectItem+ " is Selected");
		
	}
	else{
		Update_Report("Fail", "selectFromDropDown",  objname + " DropDown menu is not displayed please check your application");
	}
	
}
/*Name of the Method:validateentry
 * Brief description:  validate entry int the dropdown list
 * Arguments: dtTablePath -->selectFromDropDowselectFromDropDow String ,sheetName --> String
 * Created By: Rohini Londhe 
 * Creation Date: Jule 15 2016
 * Last Modified: Jule 15 2016
 * */
public static void validateentry(WebElement obj, String dropdownentry) throws IOException{
	if(obj.isDisplayed()){
		 String actualmsg=obj.getText().trim();
		
		 if(dropdownentry.equals(actualmsg)){
			 Update_Report("Pass", "validateentry", dropdownentry+" is matched with "+actualmsg );	 
		 }
		 else{
			 Update_Report("Fail", "validateentry", dropdownentry+" is not matched with "+actualmsg );	
		 }
		 }
	else{
		Update_Report("Fail", "validateentry", dropdownentry+ " is not displayed. Please contact your system administrator"  );
	}
		
}


}
