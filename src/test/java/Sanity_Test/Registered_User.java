package Sanity_Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import net.sf.cglib.core.Local;
import PageFactory.ExtentFactory;
import org.testng.annotations.BeforeTest;
//import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;

public class Registered_User {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeMethod (groups = {"Sanity"})
	public void User_Login () throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDriving.properties");
				 
		prop.load(fis);
		
		
		driver.get(prop.getProperty("Url")); 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk"));
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement Login;
		Login = wait.until(ExpectedConditions.visibilityOfElementLocated (By.linkText("Login")));
		Login.click();
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//driver.findElement(By.linkText("Login")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.name("data[User][email]")).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.name("data[User][password]")).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath(".//*[@id='UserMysslLoginForm']/button")).click();
		
	}

	
	@AfterMethod (groups = {"Sanity"}, alwaysRun = true)
	public String User_Logout (ITestResult result) throws Exception {
		
	    //Take Screen Shots
	    String filename = result.getMethod().getMethodName() +".png";
	    String Directory = "c:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\Test ScreenShots\\";
		  
	    File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(Directory + filename));
		  
		String destination = Directory + filename;
		String path = destination;
		String imagePath = test.addScreenCapture(path);
		test.log(LogStatus.INFO, "Test Complete", imagePath);
		
		Thread.sleep(15000);
		driver.findElement(By.linkText("Logout")).click();
		test.log(LogStatus.INFO, "User Logged Out");
		
		report.endTest(test);
		report.flush();
		
		return destination;
		
	}
	
	
	@Test (priority = 1, groups = {"Sanity"})
	  public void Order_RapidSSL() throws Exception {
		 
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDriving.properties");
				 
		prop.load(fis);

		System.out.println("Order Cert Started!");
		
		test = report.startTest("Registered User Test --> Order_RapidSSL");
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate to product page//
		Thread.sleep(15000);
		driver.findElement(By.linkText("My Products")).click();
				
		//Click to Order RapidSSL Product
		Thread.sleep(15000);
		driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[3]/a")).click();
		test.log(LogStatus.INFO, "Product Page Opened");
		
		//Check Domain Name
		driver.findElement(By.name("data[Basket][common_name]")).sendKeys("ssl247.co.uk");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("check-cn-btn")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='BasketAddCertificateForm']/div[12]/input[1]")).click();
				
		//Choose 3year Duration Option
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("BasketYears3")).click();
				
		//Select Apache 2 Server and Add to basket
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement Servertype = driver.findElement(By.xpath(".//*[@id='BasketServerType']"));
		Select Type = new Select(Servertype);
		Type.selectByVisibleText("Apache 2");
		driver.findElement(By.id("addCertificateToBasket")).click();
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "Rapid SSL Pro Added To Basket");
				
		//Confirm Order Details
		driver.findElement(By.id("checkoutLink")).click();
				
		//Fill In Billing Retails
		driver.findElement(By.name("data[BasketContact][firstname]")).clear();
		driver.findElement(By.name("data[BasketContact][firstname]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][lastname]")).clear();
	    driver.findElement(By.name("data[BasketContact][lastname]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][phone]")).clear();
		
		driver.findElement(By.name("data[BasketContact][phone]")).sendKeys("0203MMM7610541");
	    driver.findElement(By.name("data[BasketContact][email]")).clear();
		driver.findElement(By.name("data[BasketContact][email]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][address_1]")).clear();
		driver.findElement(By.name("data[BasketContact][address_1]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][city]")).clear();
		driver.findElement(By.name("data[BasketContact][city]")).sendKeys("Lagos");
		WebElement Country = driver.findElement(By.name("data[BasketContact][country]"));
		Select CountryName = new Select(Country);
		CountryName.selectByVisibleText("Nigeria");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("notUsaStateInput")).clear();
		driver.findElement(By.id("notUsaStateInput")).sendKeys("Lagos");
		driver.findElement(By.id("BasketContactPostcode")).clear();
		driver.findElement(By.id("BasketContactPostcode")).sendKeys("EC1V 3RP");
		test.log(LogStatus.PASS, "Billing Page Completed and Order Confirmed");
				
		//Confirm input
		driver.findElement(By.xpath(".//*[@id='BasketContactForm']/div[8]/button")).click();
		
		/*----Complete Order----*/
		WebDriverWait wait = new WebDriverWait(driver, 50);	
		WebElement Button;
		Button = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@class='btn btn-success btn-small']")));
		Button.click();
		
		WebDriverWait wait2 = new WebDriverWait(driver, 50);	
		WebElement Csr;
		Csr = wait2.until(ExpectedConditions.visibilityOfElementLocated (By.id("CertificateDetailCsr")));
		Csr.sendKeys(prop.getProperty("Para1"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para2"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para3"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para4"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para5"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para6"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para7"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para8"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para9"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para10"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para11"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para12"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para13"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para14"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para15"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para16"));
		Csr.sendKeys(Keys.ENTER);
		Csr.sendKeys(prop.getProperty("Para17"));
		Csr.sendKeys(Keys.ENTER);
		
		WebElement Decoder = driver.findElement(By.xpath(".//*[@id='mainCertDetails']/a"));
		Decoder.click();
		
		WebElement DecoderStatus;
		DecoderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated (By.id("useCsrInfo")));
		DecoderStatus.click();
		Thread.sleep(10000);
		
		System.out.println("Sleep Over");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		
		Thread.sleep(10000);
		
		
		/*-----Fillm in Admin Tab-----------------------*/
		WebElement Admintab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[2]/a"));
		Admintab.click();
	
	    System.out.println("Admin Tab Clicked");
	   	
		WebElement Organization = driver.findElement(By.id("CertificateAdminOrganisation"));
		Organization.clear();
		Organization.sendKeys("SSL247 Ltd");
		
		WebElement Title = driver.findElement(By.id("CertificateAdminTitle"));
		Select Initials = new Select(Title);
		Initials.selectByVisibleText("Dr");
		
		WebElement Firstname = driver.findElement(By.id("CertificateAdminFirstname"));
		Firstname.sendKeys("Gideon");
		
		WebElement Lastname = driver.findElement(By.id("CertificateAdminLastname"));
		Lastname.sendKeys("Ogunleye");
		
		WebElement Email = driver.findElement(By.id("CertificateAdminEmail"));
		Email.sendKeys("qa@ssl247.co.uk");
		
		WebElement Phone = driver.findElement(By.id("CertificateAdminPhone"));
		Phone.sendKeys("02037610541");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		/*-----Fill in Tech Tab-----------------------------*/
		WebElement Techtab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[3]/a"));
		Techtab.click();
		
		WebElement TechOrganization = driver.findElement(By.id("CertificateTechOrganisation"));
		TechOrganization.clear();
		TechOrganization.sendKeys("SSL247 Ltd");
		
		WebElement TechTitle = driver.findElement(By.id("CertificateTechTitle"));
		Select TechInitials = new Select(TechTitle);
		TechInitials.selectByVisibleText("Dr");
		
		WebElement TechFirstname = driver.findElement(By.id("CertificateTechFirstname"));
		TechFirstname.clear();
		TechFirstname.sendKeys("Gideon");
		
		WebElement TechLastname = driver.findElement(By.id("CertificateTechLastname"));
		TechLastname.clear();
		TechLastname.sendKeys("Ogunleye");
		
		WebElement TechEmail = driver.findElement(By.id("CertificateTechEmail"));
		TechEmail.clear();
		TechEmail.sendKeys("qa@ssl247.co.uk");
		
		WebElement TechPhone = driver.findElement(By.id("CertificateTechPhone"));
		TechPhone.clear();
		TechPhone.sendKeys("02037610541");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		/*-----Click on Submit Button--------*/
		WebElement Submit = driver.findElement(By.xpath(".//*[@class='form-actions v-margin5 text-right']/button"));
		Submit.click();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	String SendStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();	
	  	Assert.assertTrue(SendStatus.contains("The certificate has been saved and is pending submission with the CA"));
	  	
	  	System.out.println("Order Cert Completed!");
				
		// Log Out
		//Thread.sleep(15000);
		//driver.findElement(By.linkText("Logout")).click();
		//Thread.sleep(15000);
		
	 }
	
	@Test (priority = 2, groups = {"Sanity"})
	  public void Create_User() throws Exception {
		 

		System.out.println("Create User Started!");
		test = report.startTest("Registered User Test --> Create User");
	    test.log(LogStatus.INFO, "User Logged in");
		
		//1-Navigate and click on My Users
		
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		WebElement Myusers;
		Myusers = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[21]/a")));
		Myusers.click();
		test.log(LogStatus.INFO, "My End Users Page Opened");
		
		//Thread.sleep(15000);
		//driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[21]/a")).click();
				
		//2-Navigate and Click on New Users
		Thread.sleep(5000);
		driver.findElement(By.linkText("New user")).click();
		test.log(LogStatus.INFO, "New User Form Opened");
				
		//3-Fill In Form With Required Information
		Thread.sleep(5000);
		WebElement UserRole = driver.findElement(By.xpath(".//*[@id='UserRole']"));
		Select Role = new Select(UserRole);
		Role.selectByValue("1");
		WebElement AccessLevel = driver.findElement(By.xpath(".//*[@id='UserAccessLevel']"));
		Select Level = new Select(AccessLevel);
		Level.selectByVisibleText("Standard User");
		driver.findElement(By.name("data[User][firstname]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[User][lastname]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[User][email]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[User][phone]")).sendKeys("0203MMM7610541");
		driver.findElement(By.name("data[User][address_1]")).clear();
		driver.findElement(By.name("data[User][address_1]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[User][city]")).clear();
		driver.findElement(By.name("data[User][city]")).sendKeys("Lagos");
		driver.findElement(By.name("data[User][postcode]")).clear();
		driver.findElement(By.name("data[User][postcode]")).sendKeys("EC1V 3RP");
		WebElement Country = driver.findElement(By.xpath(".//*[@id='UserCountry']"));
		Select CountryName = new Select(Country);
		CountryName.selectByVisibleText("Nigeria");
		test.log(LogStatus.PASS, "New User FRor Filled and Saved");
		
		 System.out.println("Create User Completed!");
		
	}
	
	@Test (priority = 3, groups = {"Sanity"}) 
	  public void Edit_User () throws Exception {
		

		System.out.println("Edit User Started!");
		
		test = report.startTest("Registered User Test --> Edit Users");
	    test.log(LogStatus.INFO, "User Logged in");
	    
		//Navigate to User Profiles
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		WebElement Myusers;
		Myusers = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[21]/a")));
		Myusers.click();
	    test.log(LogStatus.INFO, "User Profiles Page Opened");
		
		Thread.sleep(15000);
		driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[1]/ul[1]/li[21]/a")).click();
		
		//Edit User Profile
		Thread.sleep(15000);
		driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/div[2]/div[3]/div/address/div/a[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("data[User][firstname]")).clear();
		driver.findElement(By.name("data[User][firstname]")).sendKeys("qa@ssl247.co.uk");
		
		WebElement address = driver.findElement(By.xpath(".//*[@id='UserRole']"));
		//builder.click(address);
		//builder.build().perform();
		Select Role = new Select(address);
		Role.selectByIndex(0);
		
		driver.findElement(By.name("data[User][lastname]")).clear();
		driver.findElement(By.name("data[User][lastname]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[User][phone]")).clear();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.name("data[User][phone]")).sendKeys("02037610541");
		test = report.startTest("Registered User Test --> Create User");
	    test.log(LogStatus.PASS, "Test User Edited and Saved");
	    
	    
	    System.out.println("Edit User Completed!");
		
	}	
/*	
	@Test (priority = 5, groups = {"Sanity"}, enabled = false)
	  public void Order_Secure_SiteEV() throws Exception {
		
		report = ExtentFactory.getInstance(); 

		
		test = report.startTest("Registered User Test --> Order Secure Site Pro");
	    test.log(LogStatus.INFO, "User Logged in");
			
		//Navigate to Certificates
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Actions  actions=new Actions(driver);
		WebElement menuHoverLink=driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a"));
		actions.moveToElement(menuHoverLink);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    WebElement subLink=driver.findElement(By.xpath(".//*[@id='special-ul']/li[1]/ul/li[1]/a/span[1]"));
		actions.moveToElement(subLink);
		actions.click();
		actions.perform();
		test.log(LogStatus.INFO, "Certificates Page Opened");
				
		/*------Proposal for Symantec-Secure Site EV---------
		driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[5]/table/tbody/tr[2]/td/form[2]/table/tbody/tr/td[2]/input")).sendKeys("qa@ssl247.net");
		driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[5]/table/tbody/tr[2]/td/form[2]/table/tbody/tr/td[2]/a")).click();
		WebElement Yrs = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[5]/table/tbody/tr[2]/td/form[2]/table/tbody/tr/td[3]/select"));
		Select Amount = new Select(Yrs);
		Amount.selectByIndex(0);
		
		driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[5]/table/tbody/tr[2]/td/form[2]/table/tbody/tr/td[6]/button")).click();
		 test.log(LogStatus.INFO, "Secure Site EV Certificate Ordered");
	}
*/	
	
	
	@Test (priority = 5, groups = {"Sanity"})
	public void Domain_Name_Ordering () throws Exception {
		

		System.out.println("Domain Name Order Started!");
		
		test = report.startTest("Registered User Test --> Domain Name Ordering");
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate Domain Names Link on side bar
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("a[href*='domain-names']")).click();
		test.log(LogStatus.INFO, "Domain Names Page Opened");
				
		//Enter Domain Name to check availability
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id("check-domain-name")).sendKeys("ssl247.net");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@class='btn btn-ssl search-domain-box-button']")).click();
		Thread.sleep(10000);
		test.log(LogStatus.INFO, "Search for Domain Name in Search Field");
		
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		WebElement Result;
		Result = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[1]")));
		WebElement 	Avalability = driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[2]/span"));
				
		String oneVal = "ssl247.net";
		String twoVal = "Available";
		//WebElement 	Result = driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[1]"));
		//WebElement 	Avalability = driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[2]/span"));
		//Thread.sleep(5000);
				
		if(Result.getText().equals(oneVal)){
					
			System.out.println("Search Keyword is present");
			test.log(LogStatus.INFO, "Domain Name is Available");
			Thread.sleep(5000);
			
				}else {
					
					System.out.println("Search Keyword Not Present");
					test.log(LogStatus.FAIL, "Domain is Not Available");
					 /*Thread.sleep(1000);
					 driver.close();
					 Thread.sleep(1000);
					 driver.quit();*/
					 }
				
				if (Avalability.getText().equals(twoVal)){
					
					System.out.println("Domain Name is Avalable");
					test.log(LogStatus.INFO, "Domain Name is Available");
					driver.findElement(By.xpath(".//*[@id='domain-name-results']/tbody/tr[2]/td[4]/input")).click();
					driver.findElement(By.xpath(".//*[@id='domain-search-results']/div/button")).click();
					
				}else {
					
					System.out.println("Domain Name is Not Available");
					test.log(LogStatus.FAIL, "Domain is Not Available");
					Thread.sleep(1000);
					//driver.quit();
				}
				
				
		//Confirm Basket
		Thread.sleep(15000);
		driver.findElement(By.id("checkoutLink")).click();
		test.log(LogStatus.INFO, "Order Placed in Basket");
				
		//Fill In Billing Retails
		driver.findElement(By.name("data[BasketContact][firstname]")).clear();
		driver.findElement(By.name("data[BasketContact][firstname]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][lastname]")).clear();
		driver.findElement(By.name("data[BasketContact][lastname]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][phone]")).clear();
		driver.findElement(By.name("data[BasketContact][phone]")).sendKeys("0203MMM7610541");
		driver.findElement(By.name("data[BasketContact][email]")).clear();
		driver.findElement(By.name("data[BasketContact][email]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][address_1]")).clear();
		driver.findElement(By.name("data[BasketContact][address_1]")).sendKeys("qa@ssl247.co.uk");
		driver.findElement(By.name("data[BasketContact][city]")).clear();
		driver.findElement(By.name("data[BasketContact][city]")).sendKeys("Lagos");
		WebElement Country = driver.findElement(By.name("data[BasketContact][country]"));
		Select CountryName = new Select(Country);
		CountryName.selectByVisibleText("Nigeria");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("notUsaStateInput")).clear();
		driver.findElement(By.id("notUsaStateInput")).sendKeys("Lagos");
		driver.findElement(By.id("BasketContactPostcode")).clear();
		driver.findElement(By.id("BasketContactPostcode")).sendKeys("EC1V 3RP");
		
				
		//Confirm input
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='BasketContactForm']/div[8]/button")).click();
		test.log(LogStatus.INFO, "Order Confirmed");
		
		//Click Complete Button
		Thread.sleep(5000);
		//driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/div[1]/div/div[1]/table/tbody/tr[5]/td/a")).click();
		driver.findElement(By.xpath(".//*[@class='actions']/a")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//Click on Admin Tab
		driver.findElement(By.cssSelector("a[href*='#admin-domainName-edit-admin-contact-tab']")).click();
		
		//Fill in the Required Information
		WebElement AdContact = driver.findElement(By.xpath(".//*[@id='AdminContactUser']"));
		Select Name = new Select(AdContact);
		Name.selectByVisibleText("Mr Quality Assurance Tester");
		
		driver.findElement(By.id("AdminContactDialingCode")).sendKeys("475");
		
		//Click on Technical Tab
		driver.findElement(By.cssSelector("a[href*='#admin-domainName-edit-technical-contact-tab']")).click();
		
		//Fill in Required Information
		WebElement TechContact = driver.findElement(By.xpath(".//*[@id='TechnicalContactUser']"));
		Select TechName = new Select(TechContact);
		TechName.selectByVisibleText("Mr Quality Assurance Tester");
		
		driver.findElement(By.id("TechnicalContactDialingCode")).sendKeys("475");
		
		//Click on Owner Tab
		driver.findElement(By.cssSelector("a[href*='#admin-domainName-edit-owner-contact-tab")).click();
		
		//Fill in Required Information
		WebElement Owner = driver.findElement(By.xpath(".//*[@id='OwnerContactUser']"));
		Select OwnerName = new Select(Owner);
		OwnerName.selectByVisibleText("Mr Quality Assurance Tester");
				
		driver.findElement(By.id("OwnerContactDialingCode")).sendKeys("475");
		test.log(LogStatus.PASS, "Order Completed");
				
		//Click on Save Changes
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='DomainNameMysslEditForm']/div[2]/div[1]/button")).click();
		
		
		//Confirm Order is completed
/*		
		String OrderStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]")).getText();					 
		Assert.assertTrue(OrderStatus.contains("Validation complete, order will be processed shortly, thank you.")); 				
*/
		WebElement OrderStatus;
		OrderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath("html/body/div[4]/p[1]")));
		String StatusVal = "Validation complete, order will be processed shortly, thank you.";
				
		if(OrderStatus.getText().contains(StatusVal)){
					
			test.log(LogStatus.PASS, "Domain Name Order Successfull");
			
				}else {
					
					System.out.println("Order Status is:"+OrderStatus.getText());
					test.log(LogStatus.FAIL, "Domain Name Order Failed");
					
					 }
				
				
	/*			
		//Click Payment required link 
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/div[1]/div/div[1]/table/tbody/tr[5]/td/a")).click();
				
		//Confirm That Payment Page Opens
		String AssertPage = "Ledger";
		WebElement Ledger = driver.findElement(By.xpath(".//*[@id='mainContainer']/div[4]/div[2]/h2"));
				
		if (Ledger.getText().equals(AssertPage)){
					
			System.out.println("Payment Page Loaded");
					
					
		}else {
					
			System.out.println("Payment Page didnt load");
		}
	*/			
		
		
		System.out.println("Domain Name Order Started!");
	}
	
	  @BeforeTest (groups = {"Sanity"})
	  public void beforeTest() throws IOException, Exception {
		
		 /*----Firefox Driver------*/
		 //System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		// driver = new FirefoxDriver(); 
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
		 
		 report = ExtentFactory.getInstance(); 
		 
		 System.out.println("Registered User Module Test is Running.....");
		 
		 
		/*-------- //Log in As Administrator
		 Properties prop = new Properties();
		 FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDrivingAdmin.properties");
					 
		 prop.load(fis);

		 driver.get(prop.getProperty("Url")); 
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 String title = driver.getTitle();				 
		 Assert.assertTrue(title.contains("SSL Certificates: Buy Symantec, Thawte, Apache SSL Cert, GlobalSign, GeoTrust, RapidSSL- SSL247.co.uk")); 
						
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Login")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.name("data[User][email]")).sendKeys(prop.getProperty("Username"));
		 driver.findElement(By.name("data[User][password]")).sendKeys(prop.getProperty("Password"));
		 driver.findElement(By.xpath(".//*[@id='UserMysslLoginForm']/button")).click();
		 
		//Search For UK Test User
		 driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[2]/a")).click();
		 driver.findElement(By.name("data[Account][query]")).sendKeys("Uk Test");
		 driver.findElement(By.xpath(".//*[@id='AccountAdminIndexForm']/div[2]/div[1]/button")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//*[@id='DataTables_Table_0']/tbody/tr[1]/td[8]/a/i")).click();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.findElement(By.linkText("Account end users")).click();
		 
		//Navigate to Edit User
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
		 
		 //User Log Out
		 Thread.sleep(15000);
		 driver.findElement(By.linkText("Logout")).click();----*/
		 
	  }
	  
	  @AfterTest (groups = {"Sanity"})
	  public void afterTest() throws Exception {
		  
		 Thread.sleep(1000);
		 
		 //report.endTest(test);
		
		 driver.quit();
		 System.out.println("Registered User Module Test is Compete!");
		
  }
	  
	
}
