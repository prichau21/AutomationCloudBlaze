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
		
		
		@Test(priority=3,dependsOnMethods={"verifyUrlOfHomePage"},groups= {"Smoke"})
		public static void VerifyLinksOnPage()
		{
			test = report.startTest("Home Page Components");
			String home = driver.findElement(By.xpath(xpathHome)).getText();
			Assert.assertEquals(home,"Home","Home Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","Home Page Link is Displaying");
            
            String systemParam = driver.findElement(By.xpath(xpathSystemParam)).getText();
			Assert.assertEquals(systemParam,"System Parameter","systemParam Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","systemParam Page Link is Displaying");
            
            String servicePrincipal = driver.findElement(By.xpath(xpathServicePrincipal)).getText();
			Assert.assertEquals(servicePrincipal,"Service Principal","servicePrincipal Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","servicePrincipal Page Link is Displaying");
            
            String subscription = driver.findElement(By.xpath(xpathSubscription)).getText();
			Assert.assertEquals(subscription,"Subscription","Subscription Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","Subscription Page Link is Displaying");
            
            String storageandServices = driver.findElement(By.xpath(xpathStorageandServices)).getText();
			Assert.assertEquals(storageandServices,"Storages & Services","Storages & Services Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","Storages & Services Page Link is Displaying");
            
            String cstoptr = driver.findElement(By.xpath(xpathcstoptr)).getText();
			Assert.assertEquals(cstoptr,"Custom Operation","cstoptr Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","cstoptr Page Link is Displaying");
            
            String dataFlow = driver.findElement(By.xpath(xpathDataFlow)).getText();
			Assert.assertEquals(dataFlow,"Data Flow","dataFlow Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","dataFlow Page Link is Displaying");
            

            String scheduler = driver.findElement(By.xpath(xpathScheduler)).getText();
			Assert.assertEquals(scheduler,"Scheduler","scheduler Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","scheduler Page Link is Displaying");
            

            String monitoring = driver.findElement(By.xpath(xpathMonitoring)).getText();
			Assert.assertEquals(monitoring,"Dataflow Monitoring","monitoring Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","monitoring Page Link is Displaying");
            

            String organizationinfo = driver.findElement(By.xpath(xpathorganizationinfo)).getText();
			Assert.assertEquals(organizationinfo,"Organization Info","organizationinfo Page Link is Displaying");
            test.log(LogStatus.PASS, "HOME","organizationinfo Page Link is Displaying");
            
            
            
            
		}
		}
		
        
		

