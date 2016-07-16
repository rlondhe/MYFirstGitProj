import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class amazon_exeEngine {
	
	public static void main(String[] args) throws IOException, InterruptedException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	
	String[][] recData=amazon_AutoScripts.readExcel("C:/Users/rohin/Desktop/SeleniumTest/Q2/TestSuit.xls","Sheet1");
  
		String amazon_autoScript;
		String runNorun;
		
		for(int i=1;i<recData.length;i++){
		runNorun=recData[i][1];
			if(runNorun.equalsIgnoreCase("Y")){
				amazon_autoScript=recData[i][2];			
				Method ts= amazon_AutoScripts.class.getMethod(amazon_autoScript);
				ts.invoke(ts);
				amazon_AutoScripts.writeexcel("C:/Users/rohin/Desktop/SeleniumTest/Q2/TestSuit.xls","Sheet1",i,3,"Pass");
							}
		}				
			
		}
	}
	







	//amazon_AutoScripts.Launch_Amazon_application();
			//amazon_AutoScripts.searchbox();
			//amazon_AutoScripts.searchprop();
			//amazon_AutoScripts.searchprop();
			//amazon_AutoScripts.mouseover_CellPhonesheader();
			//amazon_AutoScripts.Computers_Accessories();
			 // amazon_AutoScripts.electronics();
			 //amazon_AutoScripts.refinedby();
			//amazon_AutoScripts.allLinksonMainpage();
			//amazon_AutoScripts.deptdropdown();
			  //amazon_AutoScripts.accountdropdown();
			 // amazon_AutoScripts.tryprime();
			//amazon_AutoScripts.listdropdown();
					