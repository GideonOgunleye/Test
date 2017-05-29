package Regression_Test;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Order_Products_Data {
	
	@DataProvider (name ="OrderProduct_Data")
	public static Object[][] testData(){
		Object[][] obj = new Object[11][2];
		
		/*---------1st Parameter-------------*/	
		//Product Name
		obj[0][0]="Order Products Test --> Order_Symantec Secure Site";
		//Product Link
		obj[0][1]= "Symantec Secure Site";
		
		/*---------2rd Parameter-------------*/	
		//Product Name
		obj[1][0]="Order Products Test --> Order_Symantec Secure Site EV";
		//Product Link
		obj[1][1]= "Symantec Secure Site EV";
		
		/*---------3rd Parameter-------------*/	
		//Product Name
		obj[2][0]="Order Products Test --> Order_Symantec Secure Site Pro ";
		//Product Link
		obj[2][1]= "Symantec Secure Site Pro";
		
		/*---------4th Parameter-------------*/	
		//Product Name
		obj[3][0]="Order Products Test --> Order_Symantec Secure Site Pro EV ";
		//Product Link
		obj[3][1]= "Symantec Secure Site Pro EV";
		
		/*---------5th Parameter-------------*/	
		//Product Name
		obj[4][0]="Order Products Test --> Order_Thawte SSL Web Server ";
		//Product Link
		obj[4][1]= "Thawte SSL Web Server";
		
		/*---------6th Parameter-------------*/	
		//Product Name
		obj[5][0]="Order Products Test --> Order_Thawte SSL Web Server EV ";
		//Product Link
		obj[5][1]= "Thawte SSL Web Server EV";
		
		/*---------7th Parameter-------------*/	
		//Product Name
		obj[6][0]="Order Products Test --> Order_Thawte SSL123 ";
		//Product Link
		obj[6][1]= "Thawte SSL123";
		
		/*---------8th Parameter-------------*/	
		//Product Name
		obj[7][0]="Order Products Test --> GeoTrust QuickSSL Premium ";
		//Product Link
		obj[7][1]= "GeoTrust QuickSSL Premium";
		
		/*---------9th Parameter-------------*/	
		//Product Name
		obj[8][0]="Order Products Test --> GeoTrust True BusinessID ";
		//Product Link
		obj[8][1]= "GeoTrust True BusinessID";
		
		/*---------10th Parameter-------------*/	
		//Product Name
		obj[9][0]="Order Products Test --> GeoTrust True BusinessID EV  ";
		//Product Link
		obj[9][1]= "GeoTrust True BusinessID EV";
		
		/*---------11th Parameter-------------*/	
		//Product Name
		obj[10][0]="Order Products Test --> GeoTrust True BusinessID Multi-Domain";
		//Product Link
		obj[10][1]= "GeoTrust True BusinessID Multi-Domain";
		
		
	    
		return obj;
		
		
	}
}
