package com.CloudBlaze.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class DataSources extends BaseClass implements IOnBoarding {

	// Verify DataSource Page Link
	@Test(priority = 1, groups = { "Smoke" })
	public void verifyDataSourcesPageLink() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		test = report.startTest("Click on Data Sources Page Link");

		try {
			driver.findElement(By.xpath(xpathDataSourcePageLink)).click();

		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User has successfully clicked on Data Sources Page Link");
	}

	 //Verify When user Click on Data Source  Link ,its Page will Display 
	@Test(priority = 2, dependsOnMethods = { "verifyDataSourcesPageLink" }, groups = { "Smoke" })
	public static void verifyUrlOfDataSources() throws InterruptedException 
	{

		
		driver.navigate().refresh();
		Thread.sleep(3000);
		test = report.startTest("Verify Url of Data Sources Page");
        
		// verify the Url of the page
		if(driver.getCurrentUrl().equals(xpathUrlOfDataSources)) {
		Assert.assertEquals(xpathUrlOfDataSources, driver.getCurrentUrl(),"URL is not matching");
		test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
			}
		else 
		{
	    test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
		}
}
	
}
