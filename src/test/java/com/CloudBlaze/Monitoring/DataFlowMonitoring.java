package com.CloudBlaze.Monitoring;

import static org.junit.Assert.assertArrayEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IMonitoring;
import com.relevantcodes.extentreports.LogStatus;

public class DataFlowMonitoring extends BaseClass implements IMonitoring{
	
	
	
	@Test(priority=2, groups = { "Smoke" })
	public void VerifyLinkandUrl() throws InterruptedException
	{ 
	test=report.startTest("Monitoring Page Link");
	
    driver.navigate().refresh();
    Thread.sleep(3000);
    try
       {
    	driver.findElement(By.xpath(xpathMonitoringlink)).click();
     }
     catch(ElementNotVisibleException e)
     {
	   e.printStackTrace();
    }
       Thread.sleep(2000);
       test.log(LogStatus.PASS, "User has successfully clicked on Monitoring Page Link");
   }
   @Test(priority=3, groups= {"Smoke"},dependsOnMethods= {"VerifyLinkandUrl"})
   public void VerifyUrlOfPage() throws InterruptedException
   {
	   test=report.startTest("Verify Url Of Page");
	   driver.navigate().refresh();
	   Thread.sleep(1000);
	   if(driver.getCurrentUrl().equals(xpathMonitoringUrl))
	   {
		  test.log(LogStatus.PASS, "Correct Url of Monitoring page is Displaying");
	   }
	   else
	   {
		   test.log(LogStatus.FAIL, "Incorrect Url of Monitoring Page is Displaying");
	   }
	   
   }
   @Test(priority=4,groups= {"Smoke"},dependsOnMethods= {"VerifyUrlOfPage"})
   public void VerifyComponentsOfMonitoring() throws InterruptedException
   
   {
	   test=report.startTest("Components of Monitoring Page");
	   driver.navigate().refresh();
	   Thread.sleep(1000);
	   String title = driver.findElement(By.xpath(xpathMonitoringTitle)).getText();
	   Assert.assertEquals(title,"Data flow Monitoring","title is not Displaying or wrong title is displaying");
	   test.log(LogStatus.PASS,"Monitoring","Data Flow Monitoring title is Displaying");
	   
	   String dataFlowScheduledTitle = driver.findElement(By.xpath(xpathDataFlowScheduledTitle)).getText();
	   Assert.assertEquals(dataFlowScheduledTitle,"Total DataFlow Scheduled","Total Data Flow Scheduled is not Displaying or wrong title is displaying");
	   test.log(LogStatus.PASS,"Monitoring","Total Data Flow Scheduled is Displaying");
	   
	   String rowsTransferredtitle = driver.findElement(By.xpath(xpathRowsTransferredtitle)).getText();
	   Assert.assertEquals(rowsTransferredtitle,"Total No of Rows Transferred (Millions)","Total No of Rows Transferred (millions) is not Displaying or wrong title is displaying");
	   test.log(LogStatus.PASS,"Monitoring","Total No of Rows Transferred (millions) is Displaying");
	   
	   String amountOfDatatransferred = driver.findElement(By.xpath(xpathAmountOfDatatransferred)).getText();
	   Assert.assertEquals(amountOfDatatransferred,"Amount of Data Transferred (GB)","Amount of Data Transferred (gb) is not Displaying or wrong title is displaying");
	   test.log(LogStatus.PASS,"Monitoring","Amount of Data Transferred (gb) title is Displaying");
	  
	   String rowsSurfaced = driver.findElement(By.xpath(xpathRowsSurfaced)).getText();
	   Assert.assertEquals(rowsSurfaced,"Total No of Rows Surfaced (Millions )","Total No of Rows Surfaced (Millions ) is not Displaying or wrong title is displaying");
	   test.log(LogStatus.PASS,"Monitoring","Total No of Rows Surfaced (Millions ) is Displaying");
	   
       boolean searchBy = driver.findElement(By.id("select-searchBy")).isDisplayed();
       Assert.assertEquals(searchBy, true,"Search By Field is not Displaying");
       test.log(LogStatus.PASS,"Monitoring","Search By Field is Displaying");
       
       boolean search = driver.findElement(By.id("SearchDataFlow")).isDisplayed();
       Assert.assertEquals(search,true,"search field is not Displaying");
       test.log(LogStatus.PASS,"Monitoring","search Field is displaying");
       
       boolean startDateLabel = driver.findElement(By.xpath(xpathStartdatelabel)).isDisplayed();
       Assert.assertEquals(startDateLabel, true,"startdateLabel is not Displaying");
       test.log(LogStatus.PASS, "Monitoring","startdateLabel is Displaying");
       
       
       boolean startDateTime = driver.findElement(By.id("startdatetime")).isDisplayed();
       Assert.assertEquals(startDateTime,true,"Start Date time Field is not Displaying");
       test.log(LogStatus.PASS,"Monitoring","Start date time field is Displaying");
       
       boolean enddateLabel = driver.findElement(By.xpath(xpathEnddateLabel)).isDisplayed();
       Assert.assertEquals(enddateLabel,true,"enddateLabel is not Displaying");
       test.log(LogStatus.PASS, "Monitoring","enddateLabel is Displaying");
       
       
       boolean endDateTime = driver.findElement(By.id("enddatetime")).isDisplayed();
       Assert.assertEquals(endDateTime, true,"End date time is not Displaying");
       test.log(LogStatus.PASS,"Monitoring","End date time is Displaying");
       
       boolean status = driver.findElement(By.id("select-SelectStatus")).isDisplayed();
       Assert.assertEquals(status, true,"status is not Displaying");
       test.log(LogStatus.PASS,"Monitoring","status is Displaying");
       
       //Buttons
      
       boolean searchBtn = driver.findElement(By.id("addSearch")).isDisplayed();
       Assert.assertEquals(searchBtn, true,"Search Button is not Displaying");
       test.log(LogStatus.PASS, "Monitoring","Search Button is Displaying");
       
       boolean clearBtn =driver.findElement(By.xpath(xpathClearBtn)).isDisplayed();
       Assert.assertEquals(clearBtn,true,"Clear Button is not Displaying");
       test.log(LogStatus.PASS, "Monitoring","Clear Button is Displaying");
       
       boolean refreshBtn =driver.findElement(By.xpath(xpathRefreshBtn)).isDisplayed();
       Assert.assertEquals(refreshBtn,true,"refresh Button is not Displaying");
       test.log(LogStatus.PASS, "Monitoring","refresh Button is Displaying");
       
   }
   
   @Test(priority = 5, dependsOnMethods = { "VerifyComponentsOfMonitoring" }, groups = { "Smoke" })
   public static void verifyColumnsInGrid() throws InterruptedException 
   {
	 //verify number of columns in Grid
   test = report.startTest(" Verify  columns in Grid ");
	// int columnsInGrid = driver.findElements(By.xpath(xpathColumnsInGrid)).size();
//	 if(columnsInGrid==13)
//	 {
//		 
//		 test.log(LogStatus.PASS, "Total columns", "13 columns are displaying on grid");
//	 }
//	 else
//	 {   
//		 test.log(LogStatus.FAIL, "Total columns", "13 columns are not displaying on grid");
//		 
//	 }
   
	 
	 //Verify all Column name
	 for(int i=2;i<=11;i++)
	 {
		 String columns  = driver.findElement(By.xpath("//*[@id='root']//div/main/div[2]/div/div/div/table/thead/tr/th["+i+"]")).getText();
	     if(columns.equals("S.No."))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "S.No. is Displaying");
			  
	     }
	     
	     if(columns.equals("DataFlow Name"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Data Flow Name is Displaying"); 
	     }
	  
	    
	     if(columns.equals("Source Name"))
	    { 
			 test.log(LogStatus.PASS, "Total columns", "Source Name is Displaying");  
	    }
	     if(columns.equals("DataFlow Type"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "DataFlow Type is Displaying"); 
	     }
	     if(columns.equals("Start Time"))
	     {
	  
		 test.log(LogStatus.PASS, "Total columns", "Run Start Time is Displaying"); 
	    	 
	     }
	     
	   
	     if(columns.equals("Snapshot Date"))
	     {
	    	
			 test.log(LogStatus.PASS, "Total columns", "Snapshot Date is Displaying"); 
	     }
	     if(columns.equals("Completed Time"))
	     {
	    	
			 test.log(LogStatus.PASS, "Total columns", "Completed Time  is Displaying"); 
	     }
	     if(columns.equals("Row Managed"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Row Managed is Displaying");  
	     }
	     if(columns.equals("Status"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Status is Displaying");  
	     }
	     if(columns.equals("Action"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Action is Displaying");  
	     }
	 }
	  
	   Thread.sleep(2000);
       if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
	   {    
		   test.log(LogStatus.FAIL, "Schedular page is not Displaying");
	   }
	  else
	   {
		 test.log(LogStatus.PASS,"Schedular page is  Displaying");
		 
	   }
         test=report.startTest("Search By Field Monitoring Page");
         driver.findElement(By.id("select-searchBy")).click();
         Thread.sleep(2000);
         boolean none = driver.findElement(By.xpath(xpathNone)).isDisplayed();
         Assert.assertEquals(none, true,"None option is not Displaying");
         test.log(LogStatus.PASS, "Search Field","None option is Displaying!!");
         
         boolean dataFlow = driver.findElement(By.xpath(xpathDataFlow)).isDisplayed();
         Assert.assertEquals(dataFlow, true,"dataFlow option is not Displaying");
         test.log(LogStatus.PASS, "Search Field","dataFlow option is Displaying!!");
         
         boolean dataSource = driver.findElement(By.xpath(xpathDataSource)).isDisplayed();
         Assert.assertEquals(dataSource, true,"dataSource option is not Displaying");
         test.log(LogStatus.PASS, "Search Field","dataSource option is Displaying!!");
         
         boolean table = driver.findElement(By.xpath(xpathTable)).isDisplayed();
         Assert.assertEquals(table, true,"table option is not Displaying");
         test.log(LogStatus.PASS, "Search Field","table option is Displaying!!");
        
         test=report.startTest("Status of Monitoring Page");
         Thread.sleep(2000);
         driver.navigate().refresh();
         Thread.sleep(2000);
         driver.findElement(By.id("select-SelectStatus")).click();
         Thread.sleep(3000);;
         boolean succeeded = driver.findElement(By.xpath(xpathSucceeded)).isDisplayed();
         Assert.assertEquals(succeeded, true,"Succeeded Status is not Displaying!!");
         test.log(LogStatus.PASS, "Status","Succeeded Status is Displaying!!");
         
         boolean failed = driver.findElement(By.xpath(xpathFailed)).isDisplayed();
         Assert.assertEquals(failed, true,"failed Status is not Displaying!!");
         test.log(LogStatus.PASS, "Status","failed Status is Displaying!!");
         
         boolean inprogress = driver.findElement(By.xpath(xpathInprogress)).isDisplayed();
         Assert.assertEquals(inprogress, true,"inprogress Status is not Displaying!!");
         test.log(LogStatus.PASS, "Status","inprogress Status is Displaying!!");
         
         boolean cancelled = driver.findElement(By.xpath(xpathCancelled)).isDisplayed();
         Assert.assertEquals(cancelled, true,"cancelled Status is not Displaying!!");
         test.log(LogStatus.PASS, "Status","cancelled Status is Displaying!!");
         
   }
   
       }




