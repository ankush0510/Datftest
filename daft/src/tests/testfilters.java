package tests;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import Pages.HomePage;
import Pages.ListingPage;

public class testfilters {

	public static WebDriver driver = null;
	public String baseUrl;

	@BeforeTest
	public void validfilter() {

		System.setProperty("webdriver.geckodriver.driver", "/Users/bharga02/Desktop/Task/geckodriver");

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		baseUrl = "https://www.daft.ie/";
		driver.get(baseUrl);
		
	}

	@Test
	public void testvalidfilter() {
		
		HomePage home = new HomePage();
		home.privacymessage();

		home.entercounty("Dublin");
		home.selectcounty();

		ListingPage listing = new ListingPage();
		listing.closepopup();
		listing.selectfilter();
		listing.enterkeyword("garage");
		listing.clickresult();
		listing.openproperty();
		listing.verifykeyword();

		// driver.quit();

	}
	
//	@AfterTest
//	
//	public void closebrowser() {
//		driver.quit();
//		
//	}

}

//	Launch the browser 
//	Go to Daft.ie
//	Verify if the webpage launches correctly
//
//	User is on the homepage
//	User clicks on the Rent option 
//	Enter Dublin in the Search box and click on search
//	Once the results are displayed, filter the results by ‘Garage’ keyword
//	Verify if the search results are filtered
//	Go to any property and verify if it has the garage.
