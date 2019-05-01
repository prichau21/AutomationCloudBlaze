package com.CloudBlaze.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class CustomOperation extends BaseClass implements IOnBoarding 
     {
	    //Verify Custom Operation Page Link 
		@Test(priority=1 ,groups= { "Smoke" })
		public void verifyCustomOperationPage() throws InterruptedException 
		{
			driver.navigate().refresh();
			Thread.sleep(1000);
			test=report.startTest("Click on Custom Operation Link");
			try
			{
				driver.findElement(By.xpath(xpathCustomoperationLink)).click();
			}
		   
		    catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User has successfully clicked on Custom Operation Page Link");
	}
		 //Verify When user Click on Custom Operation  Link ,Custom Operation Page will Display 
		@Test(priority = 2, dependsOnMethods = { "verifyCustomOperationPage" }, groups = { "Smoke" })
		public static void verifyUrlOfCustomOperationPage() throws InterruptedException 
		{

			driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Url of Custom Operation Page");

			// verify the Url of the page
			 if(driver.getCurrentUrl().equals(xpathUrlOfCustomOperation)) {
			Assert.assertEquals(xpathUrlOfCustomOperation, driver.getCurrentUrl(),"URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
				}
			else {
			test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
			}
}
}
