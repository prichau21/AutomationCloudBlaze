package com.CloudBlaze.Onboarding;

import java.util.List;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class Home extends BaseClass implements IOnBoarding{
	
	
		// Verify Home Page Link
		@Test(priority = 1, groups = { "Smoke" })
		public void verifyHomePageLink() throws InterruptedException 
		 
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
			test = report.startTest("Click on Home Page Link");

			try {
				driver.findElement(By.xpath(xpathHomePageLink)).click();

			} 
			catch (ElementNotVisibleException e)
			{
			e.printStackTrace();
			}
			Thread.sleep(2000);
			test.log(LogStatus.PASS, "User has successfully clicked on Home Page Link");
		}
		
		
		
		
		//Verify When user Click on Home Page ,Home Page will Display 
		@Test(priority = 2, dependsOnMethods = { "verifyHomePageLink" }, groups = { "Smoke" })
		public static void verifyUrlOfHomePage() throws InterruptedException 
		{

			driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Url of Home Page");

			// verify the url of the page
			 if(driver.getCurrentUrl().equals(urlHomePage))
			 {
			Assert.assertEquals(urlHomePage, driver.getCurrentUrl(), "URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
			}
			else {
			test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
			}

		
		}
		//verify the BreadCrumbs Home/Home is displaying or not 
		@Test(priority = 3, dependsOnMethods = { "verifyUrlOfHomePage" }, groups = { "Smoke" })
		public static void verifyBreadCrumbsOfHomePage() throws InterruptedException 
		{
		String expected = "Home/Home";
		test.log(LogStatus.INFO, "Expected Breadcrumbs", expected);
	
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[@id='root']//ol"));
		for(int i=0;i<=1;i++)
		{
			String w = allOptions.get(i).getText();
			
		}


		
		}
}

