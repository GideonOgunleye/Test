package Regression_Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Admin_User {
  public WebDriver driver;
	
  @Test (priority = 0, alwaysRun = true ,groups = {"Regression"}, dataProviderClass = Test_Data.class, dataProvider="Login_Data")
  public void Edit_User(String username, String password, String Url, String AdUsername, String AdPassword, String Validation, String Account_Name, String Account_User) throws Exception {
	  
	     driver.get(Url); 
		// driver.get(prop.getProperty("Url")); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		  
		 WebDriverWait wait = new WebDriverWait(driver, 20);	
		 WebElement LoginLink;
		 LoginLink = wait.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("a[href*='/myssl/login']")));
		 LoginLink.click();
						
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.name("data[User][email]")).sendKeys(AdUsername);
		 driver.findElement(By.name("data[User][password]")).sendKeys(AdPassword);
		 driver.findElement(By.xpath(".//*[@id='UserMysslLoginForm']/button")).click();
		 
		//Search For Test Account
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 driver.findElement(By.name("data[Account][query]")).sendKeys(Account_Name);
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 Thread.sleep(15000);
		 
		 Actions  Mouse=new Actions(driver);
	     WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	     Mouse.click(Dropdown);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	     Mouse.moveToElement(EyeIcon);
	     Mouse.click();
	     Mouse.perform();
	     
	     WebDriverWait wait3 = new WebDriverWait(driver, 20);	
		 WebElement Endusers;
		 Endusers = wait3.until(ExpectedConditions.visibilityOfElementLocated (By.cssSelector("a[href*='end-users']")));
		 Endusers.click();

/*
		 WebDriverWait wait4 = new WebDriverWait(driver, 20);	
		 WebElement users;
		 users = wait4.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@class='row v-margin']/div/div/address/strong")));
		 //users = wait4.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/h2")));
		 System.out.println("Text is:" + users.getText());
*/		 

		 
		 String UserVal = Account_User;
/*		 WebElement User1 = driver.findElement(By.xpath(".//*[@class='row v-margin']/div/div/address/strong"));
		 WebElement User2 = driver.findElement(By.xpath(".//*[@class='row v-margin']/div[1]/div/address/strong[1]"));
		 WebElement User3 = driver.findElement(By.xpath(".//*[@class='row v-margin']/div[2]/div/address/strong[1]"));
		 WebElement User4 = driver.findElement(By.xpath(".//*[@class='row v-margin']/div[3]/div/address/strong[1]"));
		 WebElement User5 = driver.findElement(By.xpath(".//*[@class='row v-margin']/div[4]/div/address/strong[1]"));
*/		
		 
		 if(driver.findElement(By.xpath(".//*[@class='row v-margin']/div/div/address/strong")).getText().equals(UserVal)){
			 
			 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			 Actions  actions=new Actions(driver);
		     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@class='btn-group pull-right']/button"));
		     actions.click(menuHoverLink);
		     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		     WebElement subLink=driver.findElement(By.cssSelector("a[href*='/end-users/edit']"));
		     actions.moveToElement(subLink);
		     actions.click();
		     actions.perform();
		     
		     //Edit User
		     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
			 Select Level = new Select(AccessLevel);
			 Level.selectByValue("1");
			 
			//Click Save User
			 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 
			}else if (driver.findElement(By.xpath(".//*[@class='row v-margin']/div[1]/div/address/strong[1]")).equals(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
			     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@class='btn-group pull-right']/button"));
			     actions.click(menuHoverLink);
			     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     WebElement subLink=driver.findElement(By.cssSelector("a[href*='/end-users/edit']"));
			     actions.moveToElement(subLink);
			     actions.click();
			     actions.perform();
			     
			     //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByValue("1");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
		 
			 }else if (driver.findElement(By.xpath(".//*[@class='row v-margin']/div[2]/div/address/strong[1]")).getText().equals(UserVal)) {
				
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
			     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@class='btn-group pull-right']/button"));
			     actions.click(menuHoverLink);
			     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     WebElement subLink=driver.findElement(By.cssSelector("a[href*='/end-users/edit']"));
			     actions.moveToElement(subLink);
			     actions.click();
			     actions.perform();
			     
			     //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByValue("1");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				
			 }else if (driver.findElement(By.xpath(".//*[@class='row v-margin']/div[3]/div/address/strong[1]")).getText().equals(UserVal)) {
		
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
			     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@class='btn-group pull-right']/button"));
			     actions.click(menuHoverLink);
			     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     WebElement subLink=driver.findElement(By.cssSelector("a[href*='/end-users/edit']"));
			     actions.moveToElement(subLink);
			     actions.click();
			     actions.perform();
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByValue("1");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
		
			 }else if (driver.findElement(By.xpath(".//*[@class='row v-margin']/div[4]/div/address/strong[1]")).getText().equals(UserVal)) {
				 
				 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				 Actions  actions=new Actions(driver);
			     WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@class='btn-group pull-right']/button"));
			     actions.click(menuHoverLink);
			     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			     WebElement subLink=driver.findElement(By.cssSelector("a[href*='/end-users/edit']"));
			     actions.moveToElement(subLink);
			     actions.click();
			     actions.perform();
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByValue("1");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 
	  }else  {
				 
				System.out.println("Quality Tester User Not Found");
				
			 }
		 
		 
		 System.out.println(Validation);
		 
		 Thread.sleep(5000);
		 driver.findElement(By.cssSelector("a[href*='/myssl/logout']")).click();
		 
		 
  }
 
 
  @AfterMethod (alwaysRun = true, groups = {"Regression"})
  public void Refresh_Page () throws Exception {
	  
		Thread.sleep(5000);
		driver.navigate().refresh();
  }
 

/*
  @Test (groups = {"Regression"})
  public void Edit_User() throws Exception{
	  
	//Search For UK Test User
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 driver.findElement(By.name("data[Account][query]")).sendKeys("Uk Test");
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 Thread.sleep(15000);
		 
		 Actions  Mouse=new Actions(driver);
	     WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	     Mouse.click(Dropdown);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	     Mouse.moveToElement(EyeIcon);
	     Mouse.click();
	     Mouse.perform();
		  
		 WebDriverWait wait = new WebDriverWait(driver, 20);	
		 WebElement Endusers;
		 Endusers = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainContainer']/div[7]/div[1]/ul/li[22]/a")));
		 Endusers.click();
		  
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
		     
		     //Edit User
		     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
			 Select Level = new Select(AccessLevel);
			 Level.selectByVisibleText("Super User");
			 
			//Click Save User
			 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 
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
			     
			     //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				
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
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
		
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
				 
				 //Edit User
			     WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
				 Select Level = new Select(AccessLevel);
				 Level.selectByVisibleText("Super User");
				 
				//Click Save User
				 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/button")).click();
				 
			 }else  {
				 
				System.out.println("Quality Tester User Not Found");
				
			 }
  
  }
*/  
  
 /*
  @Test (groups = {"Regression"})
  public void Issue_Proposal () throws Exception {
	  
	//Navigate to User Account, Search for User and Click View
			driver.findElement(By.linkText("Client accounts")).click();
			driver.findElement(By.name("data[Account][query]")).sendKeys("uk test");
			driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();	
			Thread.sleep(10000);
			driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();	
			Thread.sleep(10000);
			
			//Navigate to Proposals Section 
			driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[1]/ul/li[17]/a")).click();	
			Thread.sleep(10000);
			
			//Click on New Proposal
			driver.findElement(By.xpath(".//*[@id='mainContainer']/div[7]/div[2]/div[1]/div[2]/div/div/a")).click();	
			Thread.sleep(10000);
			
			//Fill in required information
			WebElement Product = driver.findElement(By.id("BasketItem1ProductTypeId"));
			Select ProductName = new Select(Product);
			ProductName.selectByVisibleText("SSL Certificate");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			WebElement ProductType = driver.findElement(By.id("productSelect1"));
			Select Type = new Select(ProductType);
			Type.selectByVisibleText("RapidSSL Pro");
			Thread.sleep(10000);
			
			driver.findElement(By.name("data[BasketItem][1][quantity]")).clear();
			driver.findElement(By.name("data[BasketItem][1][quantity]")).sendKeys("3");
			
			WebElement Duration = driver.findElement(By.name("data[BasketItem][1][years]"));
			Select DurationNo = new Select(Duration);
			DurationNo.selectByVisibleText("3 years");
			Thread.sleep(10000);
			
			driver.findElement(By.id("BasketItem1CommonName")).sendKeys("ssl247-testing.co.uk");
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
			driver.findElement(By.id("ProposalCalculatePrices")).click();
			Thread.sleep(10000);
			
			//Click Save
			driver.findElement(By.id("ProposalSave")).click();
  } 
  
 */
  
 /*
  @Test (groups = {"Regression"})
  public void Send_Fulfillment_Email() throws Exception {
	  
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
	  	
	  	//Select Account Name from for field
	  	WebElement ForField = driver.findElement(By.xpath(".//*[@id='CertificateField']"));
		Select Options = new Select(ForField);
		Options.selectByVisibleText("Account name");
		
		//Select Issued from Status Field
		WebElement StatusField = driver.findElement(By.xpath(".//*[@id='CertificateStatusId']"));
		Select StatusOptions = new Select(StatusField);
		StatusOptions.selectByVisibleText("Issued");
		
	    //Enter Account Name into form field and Click Search
		driver.findElement(By.xpath(".//*[@id='CertificateQuery']")).sendKeys("UK Test");
		driver.findElement(By.xpath(".//*[@id='CertificateAdminIndexForm']/div[2]/div[2]/div[5]/button[1]")).click();	
		//Thread.sleep(5000);
		
		
		//Wait for Certificate page to appear 
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		WebElement Result;
		Result = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")));
		
		String AccountName = "UK TEST";
		String Status = "Issued";
		WebElement Col1 = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[2]"));
		WebElement StatusCol = driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[5]"));

		
		if (Col1.getText().contains(AccountName)){
			
			System.out.println("Account Found");
			
			if (StatusCol.getText().equals(Status)) {
				
				System.out.println("issued Cert found");
				//driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();	
				Result.click();
			}else {
				
				System.out.println("No issued cert present");
				//driver.close();
			}
			
		}else {
			
			System.out.println("Account Not Found");
			//driver.close();
		}
		

		//Click on Send Fulfillment Email Link
		Thread.sleep(10000);
		driver.findElement(By.cssSelector("a[href*='#sendFulfillmentEmail']")).click();
		
		//Fill In required information
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='CertificateNotes']")).clear();
		driver.findElement(By.xpath(".//*[@id='CertificateNotes']")).sendKeys("Test Note");
		
		WebElement EmailField = driver.findElement(By.xpath(".//*[@id='CertificateEmail']"));
		Select EmailAdd = new Select(EmailField);
		EmailAdd.selectByVisibleText("qa@ssl247.co.uk - technical contact");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='CertificateOneOffEmail']")).sendKeys("qa@ssl247.co.uk");
		
		driver.findElement(By.xpath(".//*[@id='sendFulfillmentEmail']/form/div[4]/button")).click();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	String SendStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
	  	Assert.assertTrue(SendStatus.contains("Certificate has been emailed to qa@ssl247.co.uk"));
		
		
		//*----Verify Sent Email is in Outgoing emails
		
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
		
	  	String SubjectCol = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[1]")).getText();
	  	
	  	Assert.assertTrue(SubjectCol.contains("Your 1 year(s) GlobalSign DomainSSL SSL certificate for *.ssl247.co.uk has been issued"));
	  	
	  //Delete Outgoing Emails Afterwards
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[5]/a")).click();
	  	
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	driver.switchTo().alert().accept();
	  	
	  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	String Confirmation = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
	  	Assert.assertTrue(Confirmation.contains("Email deleted"));
	  
  }
  
 */
  
 /*
  @Test (groups = {"Regression"})
  public void Send_Change_Password_Request_Email() throws Exception {
	  
		//Navigate to User Account, Search for User and Click View
		driver.findElement(By.linkText("Client accounts")).click();
		driver.findElement(By.name("data[Account][query]")).sendKeys("uk test");
		driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();	
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();	
		Thread.sleep(10000);
		
		//Navigate to User Profiles
		//Search For UK Test User
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 driver.findElement(By.name("data[Account][query]")).sendKeys("Uk Test");
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 Thread.sleep(15000);
		 
		 Actions  Mouse=new Actions(driver);
	     WebElement Dropdown=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/button"));
	     Mouse.click(Dropdown);
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	     WebElement EyeIcon=driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[9]/div/ul/li[1]/a"));
	     Mouse.moveToElement(EyeIcon);
	     Mouse.click();
	     Mouse.perform();
		  
		 WebDriverWait wait = new WebDriverWait(driver, 20);	
		 WebElement Endusers;
		 Endusers = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainContainer']/div[7]/div[1]/ul/li[22]/a")));
		 Endusers.click();
		  
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
				 
				 
			 }else  {
				 
				System.out.println("Quality Tester User Not Found");
				
			 }
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.findElement(By.xpath(".//*[@id='UserAdminEditForm']/div[2]/a")).click();
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.switchTo().alert().accept();
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String Confirmation = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
		 Assert.assertTrue(Confirmation.contains("A reset password has been sent to qa@ssl247.co.uk"));
		 
		 
		 /*--------Force Email Out to User from test environment
		 
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
			
		 String EmailCol = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[6]/div/div/table/tbody/tr[1]/td[2]")).getText();		
		 Assert.assertTrue(EmailCol.contains("qa@ssl247.co.uk"));
		 
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("a[href*='view']")).click();
		 
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.cssSelector("a[href*='send']")).click();	
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.switchTo().alert().accept();
		 
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 String SendConfirm = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
		 Assert.assertTrue(SendConfirm.contains("Email was sent"));
  }
*/

  @BeforeTest (groups = {"Regression"})
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
		 
		 //System.out.println("Admin Module Test is Running.....");
  }

  @AfterTest (groups = {"Regression"})
  public void afterTest() throws Exception {
	  
	  Thread.sleep(1000);
	  
	//User Log Out
	  Thread.sleep(5000);
	  //driver.findElement(By.cssSelector("a[href*='/myssl/logout']")).click();
	  driver.quit();
		 
	// System.out.println("Admin Module Test is Complete!");
  }

}
