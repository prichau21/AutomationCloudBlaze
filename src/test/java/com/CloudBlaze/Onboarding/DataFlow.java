package com.CloudBlaze.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class DataFlow extends BaseClass implements IOnBoarding

{
	//Verify DataFlow Page Link 
	@Test(priority=1 ,groups= { "Smoke" })
	public void verifyDataFlowPage() throws InterruptedException 
	{
		driver.navigate().refresh();
		Thread.sleep(1000);
		test=report.startTest("Click on DataFlow Page Link");
		try
		{
			driver.findElement(By.xpath(xpathDataFlowPageLink)).click();
		}
	   
	    catch (ElementNotVisibleException e) {
		e.printStackTrace();
	}
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "User has successfully clicked on Data Flow Page Link");
    }
	 //Verify When user Click on Data Flow  Link ,Data Flow Page will Display 
	@Test(priority = 2, dependsOnMethods = { "verifyDataFlowPage" }, groups = { "Smoke" })
	public static void verifyUrlOfDataFlowPage() throws InterruptedException 
	{

		driver.navigate().refresh();
		Thread.sleep(3000);
		test = report.startTest("Verify Url of Data Flow Page");

		// verify the Url of the page
		if(driver.getCurrentUrl().equals(xpathUrlOfDataFlow))
		{
		Assert.assertEquals(xpathUrlOfDataFlow, driver.getCurrentUrl(),"URL is not matching");
		test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
		}
		else
		{
		test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
		}
        }
		
	    }

