package Regression_Test;

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

public class Order_Products {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
	@BeforeMethod (groups = {"Regression"})
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

	
	@AfterMethod (groups = {"Regression"}, alwaysRun = true)
	public String User_Logout (ITestResult result) throws Exception {
		
	
	    //Take Screen Shots
	    //String filename = result.getMethod().getMethodName() +".png";
		String filename = result.getEndMillis() + ".png";
	    String Directory = "c:\\Users\\Gideon Okunleye\\Documents\\Testing Documents\\Regression ScreenShots\\";
		  
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
	
	
	@Test (priority = 1, groups = {"Regression"},dataProviderClass = Order_Products_Data.class, dataProvider="OrderProduct_Data")
	  public void Order_Certificates(String Product, String ProductLink) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C://Users//Gideon Okunleye//workspace//SSL247_Test//DataDriving.properties");
				 
		prop.load(fis);
		
		report = ExtentFactory.getInstance2();
		
		System.out.println(ProductLink + " Order Has Started.............");
		test = report.startTest(Product);
	    test.log(LogStatus.INFO, "User Logged in");
		
		//Navigate to product page//
		Thread.sleep(15000);
		driver.findElement(By.linkText("My Products")).click();
		
		//Click to Order RapidSSL Product
		WebElement Link1 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[1]/td[1]"));
		WebElement Link2 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[2]/td[1]"));
		WebElement Link3 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[3]/td[1]"));
		WebElement Link4 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[4]/td[1]"));
		WebElement Link5 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[5]/td[1]"));
		WebElement Link6 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[6]/td[1]"));
		WebElement Link7 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[7]/td[1]"));
		WebElement Link8 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[8]/td[1]"));
		WebElement Link9 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[9]/td[1]"));
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		
		WebElement Link10 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[10]/td[1]"));
		WebElement Link11 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[11]/td[1]"));
		//WebElement Link16 = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[1]"));
		
		if (Link1.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[1]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link2.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[2]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
		
			}else if (Link3.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[3]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			}else if (Link4.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[4]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link5.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[5]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link6.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[6]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			
			}else if (Link7.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[7]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
		
			}else if (Link8.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[8]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			
			}else if (Link9.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[9]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
			
			}else if (Link10.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[10]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
				
			}else if (Link11.getText().contains(ProductLink)) {
				
				System.out.println(ProductLink + " Found");
				driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[11]/td[2]/a")).click();
				test.log(LogStatus.INFO, "Product Page Opened");
/*			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			
			}else if () {
			*/
		}else {
			
			System.out.println("Product Not Found");
			test.log(LogStatus.FAIL, "Product Not Found");
			
		}

	/*	
		Thread.sleep(15000);
		WebElement Link = driver.findElement(By.xpath(".//*[@id='SSLCertificate']/table/tbody/tr[16]/td[3]/a"));
		Link.click();
		test.log(LogStatus.INFO, "Product Page Opened");
	*/	
		//Check Domain Name
		driver.findElement(By.name("data[Basket][common_name]")).sendKeys("ssl247.net");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("check-cn-btn")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//*[@id='BasketAddCertificateForm']/div[12]/input[1]")).click();

/*		
		//Choose 3year Duration Option
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("BasketYears3")).click();
*/
		
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
		//test.log(LogStatus.PASS, "Billing Page Completed and Order Confirmed");
		
		
	  	//Assert.assertTrue(SendStatus.contains("The certificate has been saved and is pending submission with the CA"));
	  			
		//Confirm input
		driver.findElement(By.xpath(".//*[@id='BasketContactForm']/div[8]/button")).click();
		
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	WebElement OrderStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]"));
	  	String CheckStatus = "Thank You. Your order has been placed.";
	  	
	  	if (OrderStatus.getText().contains(CheckStatus)) {
	  		
	  		test.log(LogStatus.PASS, " Order Placed");
	  		System.out.println(ProductLink + " Order Placed");
	  		
	  	}else {
	  		
	  		test.log(LogStatus.FAIL, "Order NOT Placed");
	  		System.out.println(ProductLink + " Order NOT Placed");
	  		System.out.println("Test area Shows:" + OrderStatus.getText());
	  		
	  	}
	  	
	  	
	  	
	  
		/*----Complete Order----*/

  	
		WebDriverWait wait = new WebDriverWait(driver, 50);	
		
/*		WebElement Button;
		Button = wait.until(ExpectedConditions.visibilityOfElementLocated (By.xpath(".//*[@class='btn btn-success btn-small']")));
		Button.click();
*/
	  	
		try {
			
			if (driver.findElement(By.xpath(".//*[@class='btn btn-success btn-small']")).isDisplayed()) {
			
				System.out.println("Account Has Enough Funds");
				test.log(LogStatus.PASS, " Account Has Enough Funds");
				driver.findElement(By.xpath(".//*[@class='btn btn-success btn-small']")).click();
				
			}
		
		}catch(Exception e) {
			System.out.println("Account Does Not Have Enough Funds");
			test.log(LogStatus.FAIL, "Account Does Not Have Enough Funds");
		
			}
		
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
		
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
		
		Thread.sleep(10000);
		
		
		/*-----Fillm in Admin Tab-----------------------*/
		WebElement Admintab = driver.findElement (By.xpath(".//*[@class='tabbable v-margin5']/ul/li[2]/a"));
		Admintab.click();
	
	    System.out.println("Admin Tab Clicked");
	    
	    WebElement ContactSelect = driver.findElement(By.xpath(".//*[@id='CertificateAdminContact']"));
		Select Initials = new Select(ContactSelect);
		Initials.selectByVisibleText("Quality Assurance Tester");
	   	
		WebElement Organization = driver.findElement(By.id("CertificateAdminOrganisation"));
		Organization.clear();
		Organization.sendKeys("SSL247 Ltd");

/*		
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
*/		
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
		
		
		
		try {
				if (driver.findElement(By.xpath(".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[4]/a")).isDisplayed()) {
				
					System.out.println("Organisation Tab is Present");
					driver.findElement(By.xpath(".//*[@id='CertificateMysslEditForm']/div[2]/div[2]/ul/li[4]/a")).click();
					driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
					driver.findElement(By.xpath(".//*[@id='CertificateOrganisationLegalName']")).clear();
					driver.findElement(By.xpath(".//*[@id='CertificateOrganisationLegalName']")).sendKeys("SSL247 Ltd");
					System.out.println("Organisation Legal Name Field Filled");
				}
			
			}catch(Exception e) {
				System.out.println("Organisation Tab is not Present");
			
				}

		
		try {
			if (driver.findElement(By.xpath(".//*[@id='CertificateOrganisationCategory']")).isDisplayed()) {
			
				System.out.println("Organisation Category is Present");
				WebElement Category = driver.findElement(By.xpath(".//*[@id='CertificateOrganisationCategory']"));
				Select Level = new Select(Category);
				Level.selectByVisibleText("Other registered business");
				
				driver.findElement(By.xpath(".//*[@id='CertificateOrganisationRegistrationNumber']")).clear();
				driver.findElement(By.xpath(".//*[@id='CertificateOrganisationRegistrationNumber']")).sendKeys("01234567");
			}
		
		}catch(Exception e) {
			System.out.println("Organisation Category is not Present");
		
			}
		
		
		/*-----Click on Submit Button--------*/
		WebElement Submit = driver.findElement(By.xpath(".//*[@class='form-actions v-margin5 text-right']/button"));
		Submit.click();
		
		//System.out.println(ProductLink + " Order Has Ended!!");
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  	WebElement SendStatus = driver.findElement(By.xpath("html/body/div[4]/p[1]"));
	  	String Status = "The certificate has been saved and is pending submission with the CA";
	  	//Assert.assertTrue(SendStatus.contains("The certificate has been saved and is pending submission with the CA"));
	  	
	  	if (SendStatus.getText().contains(Status)) {
	  		
	  		test.log(LogStatus.PASS, "Product Successfully Ordered with CA");
	  		System.out.println(ProductLink + " Successfully Ordered With CA");
	  		System.out.println(ProductLink + " Order Has Ended!!");
	  		
	  	}else {
	  		
	  		test.log(LogStatus.FAIL, "Product NOT Successfully Ordered with CA");
	  		System.out.println(ProductLink + " NOT Successfully Ordered With CA");
	  		System.out.println(ProductLink + " Order Has Ended!!");
	  	}
	  	
		// Log Out
		//Thread.sleep(15000);
		//driver.findElement(By.linkText("Logout")).click();
		//Thread.sleep(15000);
		
	 }
		
	
	  @BeforeTest (groups = {"Regression"})
	  public void beforeTest() throws IOException, Exception {
		
		 /*----Firefox Driver------*/
		 //System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		// driver = new FirefoxDriver(); 
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
		 
		 System.out.println("Order Products Regression Test is Running.....");
		 
		 
		 
	  }
	  
	  @AfterTest (groups = {"Regression"})
	  public void afterTest() throws Exception {
		  
		 Thread.sleep(1000);
		 
		 //report.endTest(test);
		 driver.quit();
		 System.out.println("Order Products Regression Test is Compete!");
		
  }
	  
	
}
