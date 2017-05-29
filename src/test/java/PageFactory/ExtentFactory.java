package PageFactory;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance() {
		ExtentReports extent;
		String Path = "C:\\Users\\Gideon Okunleye\\workspace\\SSL247_Test\\test-output\\Extent Report\\Sanity Test(9526).html";
		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance2() {
		ExtentReports extent;
		String Path = "C:\\Users\\Gideon Okunleye\\workspace\\SSL247_Test\\test-output\\Extent Report\\Regression TestV.html";
		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}
	
	public static ExtentReports getInstance3() {
		ExtentReports extent;
		String Path = "C:\\Users\\Gideon Okunleye\\workspace\\SSL247_Test\\test-output\\Extent Report\\Sanity Test.html";
		extent = new ExtentReports (Path, false);
		
		
		return extent;

	}


}
