package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageFactory.ExtentFactory;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class Admin_User {
  WebDriver driver;
  ExtentReports report;
  ExtentTest test;
	
  @BeforeMethod (groups = {"Sanity"})
  public void Admin_Login() throws Exception {
	  
	//Log in As Administrator
		 Properties prop = new Properties();
		 FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDrivingAdmin.properties");
		 
		 //test = report.startTest("Admin_Login");
		 //test.log(LogStatus.INFO, "Browser Started...");
		 
		 prop.load(fis);
		 
		 report = ExtentFactory.getInstance(); 

		 driver.get(prop.getProperty("Url")); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String title = driver.getTitle();				 
		 Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
						
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Login")).click();
		// test.log(LogStatus.INFO, "Click on login Link");
		 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.name("data[User][email]")).sendKeys(prop.getProperty("Username"));
		 //test.log(LogStatus.INFO, "Enter Admin Username");
		 
		 driver.findElement(By.name("data[User][password]")).sendKeys(prop.getProperty("Password"));
		 //test.log(LogStatus.INFO, "Enter Admin Password");
		 
		 driver.findElement(By.xpath(".//*[@id='UserMysslLoginForm']/button")).click();
		 //test.log(LogStatus.INFO, "Click on Login Button");
		 
		 
  }
  
  @AfterMethod (alwaysRun = true, groups = {"Sanity"})
  public String Log_Out (ITestResult result) throws Exception {
	  
	  //Take Screen Shots
	  String filename = result.getMethod().getMethodName() +".png";
	  String Directory = "c:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\Test ScreenShots\\";
	  
	  File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(sourceFile, new File(Directory + filename));
	  
	  String destination = Directory + filename;
	  String path = destination;
	  String imagePath = test.addScreenCapture(path);
	  test.log(LogStatus.INFO, "Test Complete", imagePath);
	  
	  
	  /*User Log Out*/
	  Thread.sleep(15000);
	  driver.findElement(By.linkText("Logout")).click();
	  test.log(LogStatus.INFO, "Admin User Logged Out");
	  
	  report.endTest(test);
	  report.flush();
	  return destination;
  }
  
  @Test (groups = {"Sanity"})
  public void Edit_Account_User() throws Exception{
	  
	//Search For UK Test User
	     test = report.startTest("Admin Test --> Edit User");
	     test.log(LogStatus.INFO, "Admin User Logged in");
	  
	  
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 test.log(LogStatus.INFO, "Click on clients Accounts Link");
		 
		 driver.findElement(By.name("data[Account][query]")).sendKeys("Uk Test");
		 test.log(LogStatus.INFO, "Click on Search Query and Enter UK Test");
		 
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 test.log(LogStatus.INFO, "Click on Update Button");
		 
		 Thread.sleep(15000);
		 test.log(LogStatus.INFO, "Search Resusult is Displayed");
		 
		 Actions  Mouse=new Actions(driver);
	     WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	     Mouse.click(Dropdown);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	     Mouse.moveToElement(EyeIcon);
	     Mouse.click();
	     Mouse.perform();
	     test.log(LogStatus.INFO, "Click on UK Test Account in search Result");
		  
		 WebDriverWait wait = new WebDriverWait(driver, 20);	
		 WebElement Endusers;
		 Endusers = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainContainer']/div[7]/div[1]/ul/li[22]/a")));
		 Endusers.click();
		 test.log(LogStatus.INFO, "Click on Account End Users link on the side bar Menu");
		  
		 String UserVal = "Quality Assurance Tester";
		 WebElement User = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/strong[1]"));
		 WebElement User2 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/strong[1]"));
		 WebElement User3 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/strong[1]"));
		 WebElement User4 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[4]/div/address/strong[1]"));
		 
		 if(User.getText().equals(UserVal)){
				
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 Actions  actions=new Actions(driver);
		     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button"));
		     actions.click(menuHoverLink);
		     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		     WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
		     actions.moveToElement(subLink);
		     actions.click();
		     actions.perform();
		     test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
		     
		     //Edit User
		     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
			 Select Level = new Select(AccessLevel);
			 Level.selectByVisibleText("Super User");
			 test.log(LogStatus.INFO, "Change Access Level to Super User");
			 
			//Click Save User
			 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
			 test.log(LogStatus.INFO, "Click Submit Chnages Button");
			 
			 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
			 
			}else if (User2.getText().equals(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
			     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/button"));
			     actions.click(menuHoverLink);
			     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/ul/li[1]/a"));
			     actions.moveToElement(subLink);
			     actions.click();
			     actions.perform();
			     test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
			     
			     //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 test.log(LogStatus.INFO, "Change Access Level to Super User");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
			 }else if (User3.getText().equals(UserVal)) {
		
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
				 WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/button"));
				 actions.click(menuHoverLink);
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/ul/li[1]/a"));
				 actions.moveToElement(subLink);
				 actions.click();
				 actions.perform();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 test.log(LogStatus.INFO, "Change Access Level to Super User");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
		
			 }else if (User4.getText().equals(UserVal)) {
				 
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
				 WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[]/div/address/div[2]/div/button"));
				 actions.click(menuHoverLink);
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
				 actions.moveToElement(subLink);
				 actions.click();
				 actions.perform();
				 test.log(LogStatus.INFO, "Navigate to Quality Assurance Tester User and Click Edit");
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 test.log(LogStatus.INFO, "Change Access Level to Super User");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 test.log(LogStatus.INFO, "Click Submit Chnages Button");
				 
				 test.log(LogStatus.PASS, "Test User Account Edited and Saved");
				 
			 }else  {
				 
				test.log(LogStatus.FAIL, "Test User Account not Found"); 
				System.out.println("Quality Tester User Not Found");
				
			 }
  
		 
		 
		 //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		//FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
		//Reporter.log(path);
/*		
		 String filename = "User_Edit.png";
		 String Directory = "c:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\Test ScreenShots\\";
		  
		 File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(sourceFile, new File(Directory + filename));
*/		  

		 
  }
  
  @Test (groups = {"Sanity"})
  public void Create_Proposal () throws Exception {
	  
	//Navigate to User Account, Search for User and Click View
	  		test = report.startTest("Admin Test -->  Create a Proposal");
	  		test.log(LogStatus.INFO, "Admin User Logged in");
	  
			driver.findElement(By.linkText("Client accounts")).click();
			//test.log(LogStatus.INFO, "Click on User Account Link");
			
			driver.findElement(By.name("data[Account][query]")).sendKeys("uk test");
			//test.log(LogStatus.INFO, "Enter UK Test Account in Query Field");
			
			driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();	
			//test.log(LogStatus.INFO, "Click on Update Button");
			
			Thread.sleep(10000);
			driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();
			test.log(LogStatus.INFO, "User Account Page Opened");
			Thread.sleep(10000);
			
			//Navigate to Proposals Section 
			driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[1]/ul/li[17]/a")).click();
			Thread.sleep(10000);
			test.log(LogStatus.INFO, "Proposal Page Opened");
			
			//Click on New Proposal
			driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[1]/div[2]/div/div/a")).click();
			Thread.sleep(10000);
			//test.log(LogStatus.INFO, "Click on New Proposal Button");
			
			//Fill in required information
			WebElement Product = driver.findElement(By.id("BasketItem1ProductTypeId"));
			Select ProductName = new Select(Product);
			ProductName.selectByVisibleText("SSL Certificate");
			//test.log(LogStatus.INFO, "Select SSL Certificate");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			WebElement ProductType = driver.findElement(By.id("productSelect1"));
			Select Type = new Select(ProductType);
			Type.selectByVisibleText("RapidSSL Pro");
			//test.log(LogStatus.INFO, "Select RapidSSL Pro");
			Thread.sleep(10000);
			
			driver.findElement(By.name("data[BasketItem][1][quantity]")).clear();
			driver.findElement(By.name("data[BasketItem][1][quantity]")).sendKeys("3");
			//test.log(LogStatus.INFO, "Enter 3 in Quantity Field");
			
			WebElement Duration = driver.findElement(By.name("data[BasketItem][1][years]"));
			Select DurationNo = new Select(Duration);
			DurationNo.selectByVisibleText("3 years");
			//test.log(LogStatus.INFO, "Select 3 Years in Years Field");
			Thread.sleep(10000);
			
			driver.findElement(By.id("BasketItem1CommonName")).sendKeys("ssl247-testing.co.uk");
			//test.log(LogStatus.INFO, "Fill in Common Name Field");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.findElement(By.id("ProposalCalculatePrices")).click();
			//test.log(LogStatus.INFO, "Click on Calculate Prices Button");
			Thread.sleep(10000);
			
			//Click Save
			driver.findElement(By.id("ProposalSave")).click();
			test.log(LogStatus.INFO, "Click on Save Proposal Button");
			test.log(LogStatus.PASS, "Proposal Created and Saved Successfully");
  } 
  
  @Test (groups = {"Sanity"})
  public void Send_Fulfillment_Email() throws Exception {
	  
	    test = report.startTest("Admin Test -->  Send Fullfillement Email");
	    test.log(LogStatus.INFO, "Admin User Logged in");
	  
	    //Navigate to products link
	  	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  	Actions  actions=new Actions(driver);
	  	WebElement ProductsLink=driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[3]/a"));
	  	actions.moveToElement(ProductsLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	WebElement CertificatesLink=driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[3]/ul/li[1]/a"));
	    actions.moveToElement(CertificatesLink);
	  	actions.click();
	  	actions.perform();
	  	test.log(LogStatus.INFO, "Opened Search Products Page");
	  	
	  	//Select Account Name from for field
	  	WebElement ForField = driver.findElement(By.xpath(".//*[@id='CertificateField']"));
		Select Options = new Select(ForField);
		Options.selectByVisibleText("Account name");
		//test.log(LogStatus.INFO, "Select Account Name from For Field");
		
		//Select Issued from Status Field
		WebElement StatusField = driver.findElement(By.xpath(".//*[@id='CertificateStatusId']"));
		Select StatusOptions = new Select(StatusField);
		StatusOptions.selectByVisibleText("Issued");
		//test.log(LogStatus.INFO, "Select Issued from Status Field");
		
	    //Enter Account Name into form field and Click Search
		driver.findElement(By.xpath(".//*[@id='CertificateQuery']")).sendKeys("UK Test");
		driver.findElement(By.xpath(".//*[@id='CertificateAdminIndexForm']/div[2]/div[2]/div[5]/button[1]")).click();	
		//test.log(LogStatus.INFO, "Enter UK Test into Account Name Field and Click Search Butoon");
		//Thread.sleep(5000);
		
		
		//Wait for Certificate page to appear 
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		WebElement Result;
		Result = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")));
		Result.getText();
		//test.log(LogStatus.INFO, "Wait For Result page to appear");
		
		String AccountName = "UK Test01";
		String Status = "Issued";
		WebElement Col1 = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[2]"));
		WebElement Col2 = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[2]"));
		WebElement StatusCol = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[5]"));
		WebElement StatusCo2 = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[5]"));
		
		if (Col1.getText().contains(AccountName)){
			
			System.out.println("Account Found in col 1");
			
			if (StatusCol.getText().equals(Status)) {
				
				System.out.println("issued Cert found in col 1");
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();
				test.log(LogStatus.INFO, "Clicked on Issued Certificate in first column of result");
				
			}else{
				
				System.out.println("No issued cert present in col 1");
				//driver.close();
			}
			
		}else if(Col2.getText().contains(AccountName)){
			
				System.out.println("Account Found in col 2");
			
			if (StatusCo2.getText().equals(Status)) {
				
				System.out.println("issued Cert found in col 2");
				driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[2]/td[8]/a/i")).click();
				test.log(LogStatus.INFO, "Clicked on Issued Certificate in Second column of result");
				
			}else {
				
				System.out.println("No issued cert present in col 2");
				//driver.close();
				}
			
		}else  {
			 
			System.out.println("Quality Tester User With Issued Cert Not Found");
			test.log(LogStatus.FAIL, "Test User with Issued Cert Not Found");
			
		 }

	
		//Click on Send Fulfillment Email Link
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("a[href*='#sendFulfillmentEmail']")).click();
		test.log(LogStatus.INFO, "Clicked on Send Fulfillment");
		
		//Fill In required information
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='CertificateNotes']")).clear();
		driver.findElement(By.xpath(".//*[@id='CertificateNotes']")).sendKeys("Test Note");
		
		
		WebElement EmailField = driver.findElement(By.xpath(".//*[@id='CertificateEmail']"));
		Select EmailAdd = new Select(EmailField);
		EmailAdd.selectByVisibleText("gogunleye@ssl247.co.uk");
		//test.log(LogStatus.INFO, "Selected Test User from drop down list");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='CertificateOneOffEmail']")).sendKeys("qa@ssl247.co.uk");
		//test.log(LogStatus.INFO, "Entered Email in email field");
		
		driver.findElement(By.xpath(".//*[@id='sendFulfillmentEmail']/form/div[4]/button")).click();
		test.log(LogStatus.INFO, "Filled In Required information in form and Clicked");
		//test.log(LogStatus.INFO, "Clicked on Send Button");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	String SendStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
	  	Assert.assertTrue(SendStatus.contains("Certificate has been emailed to qa@ssl247.co.uk"));
	  	test.log(LogStatus.PASS, "Message Sent");
		
		
		/*----Verify Sent Email is in Outgoing emails--------*/
		
		//Navigate to Outgoing Emails Link
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  	Actions  action2=new Actions(driver);
	  	WebElement CMSLink=driver.findElement(By.cssSelector("a[href*='/admin/websites/index']"));
	  	action2.moveToElement(CMSLink);
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	WebElement OutgoingEmailsLink=driver.findElement(By.cssSelector("a[href*='/admin/outgoing_emails/index']"));
	    action2.moveToElement(OutgoingEmailsLink);
	  	action2.click();
	  	action2.perform();
	  	test.log(LogStatus.INFO, "Navigated to Outgoing emails Page");
		
	  	String SubjectCol = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[1]")).getText();
	  	
	  	Assert.assertTrue(SubjectCol.contains("Your 1 year(s) GlobalSign DomainSSL SSL certificate for *.ssl247.co.uk has been issued"));
	  	test.log(LogStatus.PASS, "Varified email is present");
	  	
	  //Delete Outgoing Emails Afterwards
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[5]/a")).click();
	  	
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	driver.switchTo().alert().accept();
	  	
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	String Confirmation = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
	  	Assert.assertTrue(Confirmation.contains("Email deleted"));
	  	test.log(LogStatus.INFO, "Deleted Email from Outgoing emails");
	  
  }
  
  
  @Test (groups = {"Sanity"})
  public void Send_Change_Password_Request_Email() throws Exception {
	  
	    test = report.startTest("Admin Test --> Change Password Request Email");
	    test.log(LogStatus.INFO, "Admin User Logged in");
	  
/*		//Navigate to User Account, Search for User and Click View
		driver.findElement(By.linkText("Client accounts")).click();
		test.log(LogStatus.INFO, "CLick on Client Account Link");
		
		driver.findElement(By.name("data[Account][query]")).sendKeys("uk test");
		test.log(LogStatus.INFO, "Type 'UK Test' in Search Query Field");
		
		driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();	
		test.log(LogStatus.INFO, "Click on Update Button");
		Thread.sleep(10000);
		
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();
		test.log(LogStatus.INFO, "Click on Uk Test Account in result Column to View");
		Thread.sleep(10000);
*/		
		//Navigate to User Profiles
		//Search For UK Test User
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 test.log(LogStatus.INFO, "Account Search Page Opened");
		 
		 driver.findElement(By.name("data[Account][query]")).sendKeys("Uk Test");
		 //test.log(LogStatus.INFO, "Type 'UK Test' in Search Query Field");
		 
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 //test.log(LogStatus.INFO, "Type 'UK Test' in Search Query Field");
		 Thread.sleep(15000);
		 
		 Actions  Mouse=new Actions(driver);
	     WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	     Mouse.click(Dropdown);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	     Mouse.moveToElement(EyeIcon);
	     Mouse.click();
	     Mouse.perform();
	     test.log(LogStatus.INFO, "UK Test Account Found and Opened");
		  
		 WebDriverWait wait = new WebDriverWait(driver, 20);	
		 WebElement Endusers;
		 Endusers = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainContainer']/div[7]/div[1]/ul/li[22]/a")));
		 Endusers.click();
		 test.log(LogStatus.INFO, "Opened Account End Users Page");
		  
		 String UserVal = "Quality Assurance Tester";
		 WebElement User = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/strong[1]"));
		 WebElement User2 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/strong[1]"));
		 WebElement User3 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/strong[1]"));
		 WebElement User4 = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[4]/div/address/strong[1]"));
		 
		 if(User.getText().equals(UserVal)){
				
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 Actions  actions=new Actions(driver);
		     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/button"));
		     actions.click(menuHoverLink);
		     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		     WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
		     actions.moveToElement(subLink);
		     actions.click();
		     actions.perform();
		     test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
		     
				 
			}else if (User2.getText().equals(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
			     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/button"));
			     actions.click(menuHoverLink);
			     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[2]/div/address/div[2]/div/ul/li[1]/a"));
			     actions.moveToElement(subLink);
			     actions.click();
			     actions.perform();
			     test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
			     
				
			 }else if (User3.getText().equals(UserVal)) {
		
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
				 WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/button"));
				 actions.click(menuHoverLink);
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[3]/div/address/div[2]/div/ul/li[1]/a"));
				 actions.moveToElement(subLink);
				 actions.click();
				 actions.perform();
				 test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
				 
		
			 }else if (User4.getText().equals(UserVal)) {
				 
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
				 WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[]/div/address/div[2]/div/button"));
				 actions.click(menuHoverLink);
				 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				 WebElement subLink=driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[2]/div[1]/div/address/div[2]/div/ul/li[1]/a"));
				 actions.moveToElement(subLink);
				 actions.click();
				 actions.perform();
				 test.log(LogStatus.INFO, "Clicked on Edit Button of UK Test User");
				 
				 
			 }else  {
				 
				System.out.println("Quality Tester User Not Found");
				test.log(LogStatus.FAIL, "Test User Not Found");
			 }
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/a")).click();
		 //test.log(LogStatus.INFO, "Clicked on Send Change Password Email Button");
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.switchTo().alert().accept();
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String Confirmation = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
		 Assert.assertTrue(Confirmation.contains("A reset password has been sent to qa@ssl247.co.uk"));
		 test.log(LogStatus.PASS, "Send Change Password Email Request Successfully Sent");
		 
		 
		 /*--------Force Email Out to User from test environment------------*/
		 
		//Navigate to Outgoing Emails Link
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 Actions  action2=new Actions(driver);
		 WebElement CMSLink=driver.findElement(By.cssSelector("a[href*='/admin/websites/index']"));
		 action2.moveToElement(CMSLink);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 WebElement OutgoingEmailsLink=driver.findElement(By.cssSelector("a[href*='/admin/outgoing_emails/index']"));
		 action2.moveToElement(OutgoingEmailsLink);
		 action2.click();
		 action2.perform();
		 test.log(LogStatus.INFO, "Navigateed to Outgoing Emails Page");
			
		 String EmailCol = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[2]")).getText();		
		 Assert.assertTrue(EmailCol.contains("qa@ssl247.co.uk"));
		 test.log(LogStatus.PASS, "Email Found in Outgoing Emails");
	
	/*	 
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("a[href*='view']")).click();
		 
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("a[href*='send']")).click();	
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.switchTo().alert().accept();
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String SendConfirm = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
		 Assert.assertTrue(SendConfirm.contains("Email was sent"));
	*/
		 
  }
  
  @BeforeTest (groups = {"Sanity"})
  public void beforeTest() {
	  
	     System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
		
		 

		//report = new ExtentReports("C:\\Users\\Gideon Okunleye\\workspace\\SSL247_Test\\test-output\\Extent Report\\Admin_User.html"); 
		 //test = report.startTest("Verify Test");
		 //test.log(LogStatus.INFO, "Browser Started...");
		 //test = report.startTest("Admin Module");
		 System.out.println("Admin Module Test is Running.....");
  }

  @AfterTest (groups = {"Sanity"})
  public void afterTest() throws Exception {
	  
	  Thread.sleep(1000);
	  //report.endTest(test);
	  
	  driver.quit();
	  System.out.println("Admin Module Test is Complete!");
		
  }
 
}
