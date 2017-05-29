package Regression_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test_Data {
	
	@DataProvider (name ="Login_Data")
	public static Object[][] testData(){
		Object[][] obj = new Object[4][8];
		
		/*---------1st Parameter-------------*/	
		//Username
		obj[0][0]="qa@ssl247.co.uk";
		//Password
		obj[0][1]="Test1234";
		//Url
		obj[0][2]="https://staging-hc.ssl247.co.uk/";
		
		//AdminUser
		obj[0][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[0][4]="GrEu4Uy6";
		
		//Test Validation
	    obj[0][5]="UK Test Complete";
	    
	    //Test Account
	    obj[0][6]="UKTE001";
	    obj[0][7]="Quality Assurance Tester";
		
		
	/*---------2nd Parameter-------------*/		
		//Username
		obj[1][0]="qa@ssl247.fr";
		//Password
		obj[1][1]="Test1234";
		//Url
		obj[1][2]="https://staging-hc.ssl247.fr/";
		
		//AdminUser
		obj[1][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[1][4]="GrEu4Uy6";
		
		//Test Validation
		obj[1][5]="France Test Complete";
		
		//Test Account
	    obj[1][6]="FRTE001";
	    obj[1][7]="Quality French Testing";
		
	/*---------3rd Parameter-------------*/	
		//Username
		obj[2][0]="qa@ssl247.dk";
		//Password
		obj[2][1]="Test1234";
		//Url
		obj[2][2]="https://staging-hc.ssl247.dk/";
		
		//AdminUser
		obj[2][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[2][4]="GrEu4Uy6";
		
		//Test Validation
		obj[2][5]="Denmark Test Complete";
	
		//Test Account
	    obj[2][6]="DENM001";
	    obj[2][7]="Denmark Quality tester";
	    
	/*---------4th Parameter-------------*/	
		//Username
		obj[3][0]="qa@ssl247.ae";
		//Password
		obj[3][1]="Test1234";
		//Url
		obj[3][2]="https://staging-hc.ssl247.be/";
		
		//AdminUser
		obj[3][3]="gogunleye@ssl247.co.uk";
		//Admin Password
		obj[3][4]="GrEu4Uy6";
		
		//Test Validation
		obj[3][5]="Belgium Test Complete";
	
		//Test Account
	    obj[3][6]="BELG003";
	    obj[3][7]="Belgian Quality Testing";
	    
	    
		return obj;
		
		
	}
}
