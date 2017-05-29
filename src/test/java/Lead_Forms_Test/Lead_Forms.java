package Lead_Forms_Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Lead_Forms {
	public WebDriver driver;
	
 @BeforeMethod 
 public void Open_Browser(){
	 
	//Open Browser
	String baseUrl = "https://staging-hc.ssl247.co.uk";
	driver.get(baseUrl);
	driver.manage().window().maximize();
	 
 }
	
  @Test
  public void Get_in_touch_Form() throws Exception {
			
	//Navigate to support Link
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='mainNavigation']/li[13]/a")).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
	//Navigate to get in touch form
	driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[6]/div/textarea")).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
	//Fill in form fields
	WebElement Title = driver.findElement(By.xpath(".//*[@id='title']"));
	Select Tl = new Select(Title);
	Tl.selectByVisibleText("Mr");
	driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[2]/div/input")).sendKeys("QA");
	driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[3]/div/input")).sendKeys("Tester");
	driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[4]/div/input")).sendKeys("qa@ssl247.co.uk");
	driver.findElement(By.xpath(".//*[@id='contactRightFields']/div[6]/div/textarea")).sendKeys("Testing!!!");
    Thread.sleep(5000);
	driver.findElement(By.xpath(".//*[@id='contactformright']/div[3]/button[1]")).click();
  }
  
  @Test
  public void Download_Form() {
  }
  
  @Test
  public void Send_Your_Comment_Form() {
  }
  
  @Test
  public void Ask_Your_Question_Form() {
  }
  
  @Test
  public void Request_a_Free_Proposal_Form() {
	  
  }
  
  @Test
  public void Request_a_Free_Bronchure () {
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		 driver = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() throws Exception {
	  
	  Thread.sleep(1000);
		 driver.quit();
  }

}
