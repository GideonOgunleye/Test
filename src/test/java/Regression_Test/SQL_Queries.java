package Regression_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageFactory.ExtentFactory;

import org.testng.annotations.BeforeSuite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class SQL_Queries {
	public WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	  @Test (priority = 1, groups = {"SQL"})
	  public void SQL_Certificate_Order () throws SQLException, ClassNotFoundException {
		  
			//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"		
	      String dbUrl = "jdbc:mysql://notcraft-prod.covetytyjb4n.eu-west-1.rds.amazonaws.com";					

			//Database Username		
			String username = "gogunleye";	
	      
			//Database Password		
			String password = "n8hY5HqCkd7suLSM";				

			//Query to Execute		
			//String query = "select *  from bakewell_staging_go.accounts Where account_code ='QUAL017';";	
			String query2 = "delete from bakewell_staging_go.certificates Where common_name ='ssl247.co.uk';";
	      
		    //Load mysql jdbc driver		
	 	    Class.forName("com.mysql.jdbc.Driver");			
	 
	 		//Create Connection to DB		
	  	Connection con = DriverManager.getConnection(dbUrl,username,password);
	  	Statement stmt = con.createStatement();	
	  	stmt.execute(query2);
	  	System.out.println("Certificate Has Been Deleted");		
		con.close();		
		  
	  }	
	 
}
