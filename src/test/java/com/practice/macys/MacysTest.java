package com.practice.macys;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class MacysTest 
{	
	WebDriver driver= new FirefoxDriver();
	HomePage hp;
	ResultPage rp;
	
	
	
	//@Parameters({"url"})
	@BeforeTest(alwaysRun=true)
	public void setUp() throws IOException 
	{	//setup
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Rajneesh Mehta\\Desktop\\Selenium\\gecko\\geckodriver.exe");
		String url= "https://www.macys.com/";
		driver.get(url);
		hp=new HomePage(driver);
		rp=new ResultPage(driver);
		
		
	}

	@Test(priority=0,testName = "TC01", description = "verify Result items count")
	public void resultItemCount()
	{
		try
		{	
			hp.navToJuniorJeans();		//navigate to Jeans Page
			int expectedCount= rp.expectedItemCount(driver);	//get no. of items expected
			System.out.println(expectedCount);
			assertTrue(rp.checkIf200(expectedCount));
//			int [] resultArray= rp.resultItemCount(driver);//get actual item count	
//			assertEquals(expectedCount,resultArray[1]);	// verify if expected is same as actual
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	@AfterTest
	public void closeDriver()
	{
		driver.close();

	}

}
