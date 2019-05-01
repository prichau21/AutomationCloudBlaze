package com.CloudBlaze.Monitoring;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IMonitoring;
import com.relevantcodes.extentreports.LogStatus;

public class DataFlowScheduled extends BaseClass implements IMonitoring
{//Verify Data Flow Scheduled Link
@Test(priority=1,groups= { "Smoke" } )
public void VerifyDataFlowScheduledPage() throws InterruptedException
{
	driver.navigate().refresh();
	Thread.sleep(1000);
	test=report.startTest("Click on Data Flow Scheduled Link");
	try
	{
		driver.findElement(By.xpath(xpathDataFlowScheduled)).click();
	}
	catch(ElementNotVisibleException e)
	{
		e.printStackTrace();
	}
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "User has successfully clicked on Data Flow Scheduled Page Link");
	
}
       //Verify When user Click on Data Flow Scheduled Link ,Data Flow Scheduled Page will Display 
		@Test(priority = 2, dependsOnMethods = { "VerifyDataFlowScheduledPage" }, groups = { "Smoke" })
		public static void verifyUrlOfDataFlowScheduledPage() throws InterruptedException 
		{

			driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Url of Data Flow Scheduled Page");

			// verify the Url of the page
			 if(driver.getCurrentUrl().equals(xpathUrlOfDataFlowScheduled)) {
			Assert.assertEquals(xpathUrlOfDataFlowScheduled, driver.getCurrentUrl(),"URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
				}
			else {
			test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
			}
}
		
		
		@Test(priority = 3, dependsOnMethods = { "verifyUrlOfDataFlowScheduledPage" }, groups = { "Smoke" })
		public static void verifyDataFlowScheduledPageComponents() throws InterruptedException 
		{
			driver.navigate().refresh();
			Thread.sleep(1000);
			
			//Verify Title of Page
			String title = driver.findElement(By.xpath(xpathTitle)).getText();
			Assert.assertEquals(title, "Data Flow Scheduler", "Data Flow Scheduler Title is not Displaying");
			test.log(LogStatus.PASS, "Title", "Data Flow Scheduler Title is Displaying");
            
			//Verify Data Flow Name Field 
			WebElement dataFlowName = driver.findElement(By.xpath(xpathDataFlowName));
			Assert.assertTrue(dataFlowName.isDisplayed());
			test.log(LogStatus.PASS, "data Flow Name Field", "data Flow Name Field is displaying");
			
			Assert.assertEquals(driver.findElement(By.xpath(xpathDataFlowNamePlaceHolder)).getText(), "PrimaryEmail", "PrimaryEmail Placeholder is not Displaying");
			test.log(LogStatus.PASS,"PrimaryEmail","PrimaryEmail Placeholder is Displaying");
			
			//Verify start Date and time Field
			WebElement startDateandtime = driver.findElement(By.xpath(xpathStartDateandtime));
			Assert.assertTrue(startDateandtime.isDisplayed());
			test.log(LogStatus.PASS, "start Date and time Field","start Date and time Field is displaying");
			
			//Verify End Date and Time Field
			WebElement endDateandTime = driver.findElement(By.xpath(xpathEndDateandTime));
			Assert.assertTrue(endDateandTime.isDisplayed());
			test.log(LogStatus.PASS,"end Date and Time Field","end Date and time Field is displaying");
			
			//Verify Description Field
			WebElement description = driver.findElement(By.className("description"));
			Assert.assertTrue(description.isDisplayed());
			test.log(LogStatus.PASS,"description Field","description Field is displaying");
			if(description.getAttribute("placeholder").contains("description"))
			{
			test.log(LogStatus.PASS,"placeholder","placeholder description is displaying");
			}
			else
			{
				test.log(LogStatus.FAIL,"placeholder","placeholder description is not displaying");
			}
			//verify Frequency Field
			WebElement frequency = driver.findElement(By.xpath(xpathFrequency));
			Assert.assertTrue(frequency.isDisplayed());
			test.log(LogStatus.PASS,"frequency Field","frequency Field is displaying");
			Assert.assertEquals( driver.findElement(By.xpath(xpathFrequencyPlaceholder)).getText(), "Frequency", "Frequency Placeaholder is not Displaying");
			test.log(LogStatus.PASS, "Frequency PlaceHolder", "Frequency Placeaholder is Displaying");
			
			
			//verify Start Time
			WebElement startTime = driver.findElement(By.xpath(xpathStartTime));
			Assert.assertTrue(startTime.isDisplayed());
			test.log(LogStatus.PASS,"start Time Field","start Time Field is displaying");
			
			//Submit button 
			boolean submit = driver.findElement(By.xpath(xpathSubmit)).isEnabled();
			Assert.assertEquals(submit,true, "submit Button is not Displaying or Disabled");
			test.log(LogStatus.PASS, "submit Button", "submit Button is Displaying and Enabled");
            
			String submitText = driver.findElement(By.xpath(xpathSubmit)).getText();
			Assert.assertEquals(submitText, "Submit", "Submit Text is not Displaying");
			test.log(LogStatus.PASS, "Submit Text", "Submit Text is Displaying");
			
			//Cancel Button
			boolean cancel = driver.findElement(By.xpath(xpathCancel)).isEnabled();
			Assert.assertEquals(cancel,true, "cancel Button is not Displaying or Disabled");
			test.log(LogStatus.PASS, "cancel Button", "cancel Button is Displaying and Enabled");
			
			String cancelText = driver.findElement(By.xpath(xpathCancel)).getText();
			Assert.assertEquals(cancelText, "Cancel", "Cancel Text is not Displaying");
			test.log(LogStatus.PASS, "Cancel Text", "Cancel Text is Displaying");
			
			 //verify number of columns in Grid
			 int columnsInGrid = driver.findElements(By.xpath(xpathColumnsInGrid)).size();
			 if(columnsInGrid==7)
			 {
				 System.out.println("7 columns are displaying on grid");
				 test.log(LogStatus.PASS, "Total columns", "7 columns are displaying on grid");
			 }
			 else
			 {   System.out.println("7 columns are not displaying on grid");
				 test.log(LogStatus.FAIL, "Total columns", "7 columns are not displaying on grid");
				 
			 }
			 
			 //Verify all Column name
			 for(int i=1;i<=columnsInGrid;i++)
			 {
				 String columns  = driver.findElement(By.xpath("//*[@id='root']//table//th[" + i + "]")).getText();
			     if(columns.equals("S.No."))
			     {
			    	 System.out.println("S.No. is Displaying");
					 test.log(LogStatus.FAIL, "Total columns", "S.No. is Displaying");
					  
			     }
			     if(columns.equals("Data Flow Name"))
			     {
			    	 System.out.println("Data Flow Name is Displaying");
					 test.log(LogStatus.FAIL, "Total columns", "Data Flow Name is Displaying"); 
			     }
			     if(columns.equals("Description"))
			    {
			    	 System.out.println("Description is Displaying");
					 test.log(LogStatus.FAIL, "Total columns", "Description is Displaying");  
			    }
			     if(columns.equals("Start Date and Time"))
			    {
			    	 System.out.println("Start Date and Time is Displaying");
					 test.log(LogStatus.FAIL, "Total columns", "Start Date and Time is Displaying");  
			    }
			     if(columns.equals("End Date and Time"))
			     {
			    	 System.out.println("End Date and Time is Displaying");
					 test.log(LogStatus.FAIL, "Total columns", "End Date and Time is Displaying"); 
			     }
			     if(columns.equals("Frequency"))
			     {
			     System.out.println("Frequency is Displaying");
				 test.log(LogStatus.FAIL, "Total columns", "Frequency is Displaying"); 
			    	 
			     }
			     if(columns.equals("Action"))
			     {
			    	 System.out.println("Action is Displaying");
					 test.log(LogStatus.FAIL, "Total columns", "Action is Displaying"); 
			     }
			 }
		}
}