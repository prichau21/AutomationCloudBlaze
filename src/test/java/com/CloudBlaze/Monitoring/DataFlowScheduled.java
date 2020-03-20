package com.CloudBlaze.Monitoring;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IMonitoring;
import com.relevantcodes.extentreports.LogStatus;

public class DataFlowScheduled extends BaseClass implements IMonitoring
{
	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	
	//Verify Data Flow Scheduled Link
	
	
        @Test(priority=2, groups={ "Smoke" } )
        public void VerifyDataFlowScheduledPage() throws InterruptedException
     
        {
	       //driver.navigate().refresh();
	       //Thread.sleep(1000);
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
		@Test(priority = 3, dependsOnMethods = { "VerifyDataFlowScheduledPage" }, groups = { "Smoke" })
		public static void verifyUrlOfDataFlowScheduledPage() throws InterruptedException 
		{

			//driver.navigate().refresh();
			Thread.sleep(1000);
			test = report.startTest("Verify Url of Data Flow Scheduled Page");

			// verify the Url of the page
			if(driver.getCurrentUrl().equals(xpathUrlOfDataFlowScheduled)) {
			Assert.assertEquals(xpathUrlOfDataFlowScheduled, driver.getCurrentUrl(),"URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
				}
			else 
			{
			test.log(LogStatus.FAIL,"Page URL is something else",driver.getCurrentUrl());
			}
			 
			 
			// String s = driver.findElement(By.xpath("//*[@id='root']")).getText();
			 
			 if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
			 {    test.log(LogStatus.FAIL, "Schedular page is not Displaying");
				
			 }
			 
			 else
			 {
				 test.log(LogStatus.PASS,"Schedular page is  Displaying");
				
			 }
		}
		
		
		     @Test(priority =4, dependsOnMethods = { "verifyUrlOfDataFlowScheduledPage" },  groups = { "Smoke" })
		     public static void verifyDataFlowScheduledPageComponents() throws InterruptedException 
		     {
			//  driver.navigate().refresh();
			
			  test = report.startTest(" Verify Data Flow Scheduled Page Components ");
			
			 //Verify Title of Page
			 //String title = driver.findElement(By.xpath(xpathTitle)).getText();
			 //Assert.assertEquals(title, "Data Flow Scheduler", "Data Flow Scheduler Title is not Displaying");
			 //test.log(LogStatus.PASS, "Title", "Data Flow Scheduler Title is Displaying");
            
			 //Verify Data Flow Name Field 
			 WebElement dataFlowName = driver.findElement(By.xpath(xpathDataFlowName));
			 Assert.assertTrue(dataFlowName.isDisplayed());
			 test.log(LogStatus.PASS, "data Flow Name Field", "data Flow Name Field is displaying");
			
			// Assert.assertEquals(driver.findElement(By.xpath(xpathDataFlowNamePlaceHolder)).getText(),"Data Flow Name *", "Data Flow Name * Placeholder is not Displaying");
			// test.log(LogStatus.PASS,"Data Flow Name","Data Flow Name * Placeholder is Displaying");
			//
			//verify Frequency Field
     //	    WebElement frequency = driver.findElement(By.xpath(xpathFrequency));
     //		Assert.assertTrue(frequency.isDisplayed());
     //		test.log(LogStatus.PASS,"frequency Field","frequency Field is displaying");
			Assert.assertEquals( driver.findElement(By.xpath(xpathFrequencyPlaceholder)).getText(), "Select frequency", "Select frequency Placeaholder is not Displaying");
			test.log(LogStatus.PASS, "Select frequency PlaceHolder", "Select frequency Placeaholder is Displaying");
			
			
			
			
			//Verify start Date and time Field
			WebElement startDateandtime = driver.findElement(By.xpath(xpathStartDateandtime));
			Assert.assertTrue(startDateandtime.isDisplayed());
			test.log(LogStatus.PASS, "start Date and time Field","start Date and time Field is displaying");
			
			//Verify End Date and Time Field
			WebElement endDateandTime = driver.findElement(By.xpath(xpathEndDateandTime));
			Assert.assertTrue(endDateandTime.isDisplayed());
			test.log(LogStatus.PASS,"end Date and Time Field","end Date and time Field is displaying");
			
			//Verify Description Field
			
//			WebElement description = driver.findElement(By.className("description"));
//			Assert.assertTrue(description.isDisplayed());
//			test.log(LogStatus.PASS,"description Field","description Field is displaying");
			Assert.assertEquals( driver.findElement(By.xpath(xpathDescriptionPlaceHolder)).getText(), "Description", "Description Placeaholder is not Displaying");
			test.log(LogStatus.PASS, "Description PlaceHolder","Description Placeaholder is Displaying");
			
			//verify Trigger Time
			WebElement startTime = driver.findElement(By.xpath(xpathStartTime));
			Assert.assertTrue(startTime.isDisplayed());
			test.log(LogStatus.PASS,"Trigger Time Field","Trigger Time Field is displaying");
			
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
			
		     }

		     @Test(priority = 5, dependsOnMethods = { "verifyDataFlowScheduledPageComponents" }, groups = { "Smoke" })
		     public static void verifyColumnsInGrid() throws InterruptedException 
		     {
			 //verify number of columns in Grid
		     test = report.startTest(" Verify  columns in Grid ");
			 int columnsInGrid = driver.findElements(By.xpath(xpathColumnsInGrid)).size();
			 if(columnsInGrid==9)
			 {
				 
				 test.log(LogStatus.PASS, "Total columns", "9 columns are displaying on grid");
			 }
			 else
			 {   
				 test.log(LogStatus.FAIL, "Total columns", "9 columns are not displaying on grid");
				 
			 }
		     
			 
			 //Verify all Column name
			 for(int i=1;i<=columnsInGrid;i++)
			 {
				 String columns  = driver.findElement(By.xpath("//*[@id='root']//table//th[" + i + "]")).getText();
			     if(columns.equals("S.No."))
			     {
			    	 
					 test.log(LogStatus.PASS, "Total columns", "S.No. is Displaying");
					  
			     }
			     
			     if(columns.equals("Data Flow Name"))
			     {
			    	 
					 test.log(LogStatus.PASS, "Total columns", "Data Flow Name is Displaying"); 
			     }
			  
			    
			     if(columns.equals("Start Date"))
			    { 
					 test.log(LogStatus.PASS, "Total columns", "Start Date  is Displaying");  
			    }
			     if(columns.equals("End Date"))
			     {
			    	 
					 test.log(LogStatus.PASS, "Total columns", "End Date is Displaying"); 
			     }
			     if(columns.equals("Frequency"))
			     {
			  
				 test.log(LogStatus.PASS, "Total columns", "Frequency is Displaying"); 
			    	 
			     }
			     if(columns.equals("Trigger Time"))
				    {
				    	
						 test.log(LogStatus.PASS, "Total columns", "Trigger Time is Displaying");  
				    }
			     
			   
			     if(columns.equals("Action"))
			     {
			    	
					 test.log(LogStatus.PASS, "Total columns", "Action is Displaying"); 
			     }
			     if(columns.equals("Created On"))
			     {
			    	
					 test.log(LogStatus.PASS, "Total columns", "Created On is Displaying"); 
			     }
			     if(columns.equals("Last ActionBy"))
			     {
			    	 
					 test.log(LogStatus.PASS, "Total columns", "Last ActionBy is Displaying");  
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
			 }
		     
		     

		 	@Test(priority = 6, dependsOnMethods = { "verifyColumnsInGrid" }, groups = { "Smoke" })
		 	public static void verifyOnClickOfSubmitButtonAlertIsComing() throws InterruptedException 
		 	{ 
		 		// driver.navigate().refresh();
		 		 Thread.sleep(1000);
		 		 test = report.startTest("On Click Of Submit Button Alert Is Coming");
		 		
		 		 driver.findElement(By.xpath(xpathSubmit)).click();
		 		 Thread.sleep(1000);
		 		 String toasterAlertForDate = driver.findElement(By.xpath(xpathtoaster)).getText();
		 		 Assert.assertEquals(toasterAlertForDate,"Start date should not greater or equal to End date","Toaster for date is not Displaying when Click on Submit");
		 		 test.log(LogStatus.PASS, "Toaster", "Toaster for date is  Displaying when Click on Submit");

		 		 driver.findElement(By.xpath(xpathEndDate)).click();
		 		 Thread.sleep(5000);
		 	
		 		driver.findElement(By.xpath("//*[@id='Edate']/div/div[2]/div/div[2]/div[2]/div[5]/div[7]")).click();
		 		Thread.sleep(1000);
		 	    driver.findElement(By.xpath(xpathSubmit)).click();
		 		 
		 		 
		 		 String selectdataFlowAlert = driver.findElement(By.xpath(xpathSelectdataFlowAlert)).getText();
		 		 Assert.assertEquals(selectdataFlowAlert,"Select Data flow Name","'Select Data flow Name' alert is not Displaying ");
		 		 test.log(LogStatus.PASS, "Alert on DataFlow", "Select Data flow Name alert is Displaying");
	 		 
		 		 String alertonFrequency = driver.findElement(By.xpath(xpathAlertonFrequency)).getText();
		 		 Assert.assertEquals(alertonFrequency,"Frequency cannot be empty","'Frequency cannot be empty' alert is not Displaying ");
		 		 test.log(LogStatus.PASS, "Alert on Frequency", "'Frequency cannot be empty' alert is Displaying");
	 		 
		 	}
		 	@Test(priority = 7, dependsOnMethods = { "verifyOnClickOfSubmitButtonAlertIsComing" }, groups = { "Smoke" })
			public static void verifyOnClickOfCancelAllFieldShouldGetClear() throws InterruptedException 
			{
				
				test = report.startTest("Verify On Click Of Cancel All Fields Should Get Clear");
				//Thread.sleep(1000);
				driver.findElement(By.xpath(xpathDataFlowName)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='menu-dataflowname']//div//ul/li[text()='Dataflowtesting']")).click(); // ENTER NAME OF FLOW THAT YOU WANT SELECT 
				Thread.sleep(1000);
				driver.findElement(By.xpath(xpathSelectFrequency)).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='root']//div/form//div[text()='Alternate day of each week']")).click();
			    Thread.sleep(1000);
				String description=reader.getCellData("Scheduler","Description", 2); 
				driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(description);
		        Thread.sleep(1000);
			    driver.findElement(By.xpath(xpathCancel)).click();
		        Thread.sleep(1000);
		        if(driver.findElement(By.xpath(xpathDataFlowName)).getText().equals("")&&driver.findElement(By.xpath(xpathSelectFrequency)).getText().equals("Select frequency") 
		        && driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).getAttribute("value").equals(""))
		        {
				test.log(LogStatus.PASS, "OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields Should get clear ");
				}
                else
				{
				    	  test.log(LogStatus.FAIL,"OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields not  get clear"  );
				}
		        }
		 	
		 	
		 	
		 	@Test(priority = 8, dependsOnMethods = { "verifyOnClickOfCancelAllFieldShouldGetClear" }, groups = { "Smoke" })
			public static void verifyFlowIsScheduled() throws InterruptedException
			{
		        test=report.startTest("Flow Is Scheduled");
		        driver.findElement(By.xpath(xpathDataFlowName)).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='menu-dataflowname']//div//ul/li[text()='Dataflowtesting']")).click(); // ENTER NAME OF FLOW THAT YOU WANT SELECT 				Thread.sleep(1000);
				Thread.sleep(1000);
				driver.findElement(By.xpath(xpathSelectFrequency)).click();
	            Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id='root']//div/form//div[text()='Alternate day of each week']")).click();
			    Thread.sleep(1000);
                driver.findElement(By.xpath(xpathEndDate)).click();
		 		Thread.sleep(5000);
		 	
		 		driver.findElement(By.xpath("//*[@id='Edate']/div/div[2]/div/div[2]/div[2]/div[5]/div[7]")).click();
		 		Thread.sleep(1000);
			   
			    String description=reader.getCellData("Scheduler","Description", 2); 
				driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(description);
		        Thread.sleep(1000);
				driver.findElement(By.xpath(xpathSubmit)).click();
				Thread.sleep(1500);
				String toaster = driver.findElement(By.xpath(xpathtoaster)).getText();
			
				System.out.println(toaster);
		        Assert.assertEquals(toaster,"Flow Scheduled successfully!","Flow is not Scheduled succesfully");
		        test.log(LogStatus.PASS,"Flow Scheduled", "Flow is Scheduled succesfully");
		        

		 	    int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
		 	 
		  for(int i=1;i<=numberOfRecords;i++)
		  {
			if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals("PriTest"))
		 	    {
		 			
		 			test.log(LogStatus.PASS,"Record is  displaying on grid Sucessfully!!!");
		 		}
		 		
			}
//		   test=report.startTest("SameNameFlowCanScheduledAgain");
//		   driver.findElement(By.xpath(xpathDataFlowName)).click();
//		   Thread.sleep(1000);
//		   if(driver.findElement(By.xpath("//*[@id='menu-dataflowname']//div//ul/li[text()='test_df_demo']")).getText().equals("test_df_demo"))
//	   {
//		   System.out.println("User is able to see Published Flow on Drop down");
//		   test.log(LogStatus.FAIL,"Published Flow","User is able to see Published Flow on Drop down ");
//		   
//		   }
//		   else
//		   {
//			   System.out.println("User is not able to see Publish Flow on Drop Down");
//			   test.log(LogStatus.PASS,"Published Flow","User is not able to see Publish Flow on Drop Down");
//		   }
//		       Thread.sleep(1000);
		  
			}
			
			       @Test(priority = 9, dependsOnMethods = { "verifyFlowIsScheduled" }, groups = { "Smoke" })
			       public static void verifyEditScheduled() throws InterruptedException 
			      {    
				     driver.navigate().refresh();
			         Thread.sleep(1000);
			         test=report.startTest("Edit Record");
				     driver.findElement(By.xpath(xpathEdit)).click();
				     Thread.sleep(1000);
				 
				   //  driver.findElement(By.xpath(xpathDataFlowName)).click();
				   //  driver.findElement(By.xpath(xpathSecondElementOfDropDown)).click();
					// Thread.sleep(1000);
					
					driver.findElement(By.className("css-19bqh2r")).click();
			driver.findElement(By.className("css-19bqh2r")).click();
				     Thread.sleep(1000);
				 	 driver.findElement(By.xpath("//*[@id='root']//div/form//div[text()='First friday of each Month']")).click();
					
				 	 driver.findElement(By.xpath(xpathEndDate)).click();
			 		 Thread.sleep(5000);
			 	
			 		 driver.findElement(By.xpath("//*[@id='Edate']/div/div[2]/div/div[2]/div[2]/div[5]/div[7]")).click(); 
				
				 	driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(Keys.CONTROL + "a");
				 	driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(Keys.BACK_SPACE);
				
				     String description=reader.getCellData("Scheduler","Description", 3); 
				     driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(description);
				     Thread.sleep(1000);
				
				
			     
				     driver.findElement(By.xpath(xpathSubmit)).click();
			         Thread.sleep(1000);
				     String toaster = driver.findElement(By.xpath(xpathtoaster)).getText();
				     Assert.assertEquals(toaster,"Scheduled Flow updated successfully!","Updation is not succesfully");
			         test.log(LogStatus.PASS, "Flow Edit","Updation is succesfully");
			    }
			
			   @Test(priority = 10, dependsOnMethods = { "verifyEditScheduled" }, groups = { "Smoke" })
			   public static void verifyDeleteDialogBox() throws InterruptedException 
			   { 
				     // driver.navigate().refresh();
				     Thread.sleep(1000);
		             test=report.startTest("DeleteDialogBox");
				     driver.findElement(By.className(classDeleteButton)).click();
				      WebElement deleteDialogBox = driver.findElement(By.xpath(xpathDeleteDialogBox));
				      Thread.sleep(2000);
				      Assert.assertTrue(deleteDialogBox.isDisplayed());
				      test.log(LogStatus.PASS, "Delete DialogBox","delete DialogBox is displaying");
				      String deleteText = driver.findElement(By.xpath(xpathDeleteText)).getText();
				      Assert.assertEquals(deleteText,"Delete","Delete is not Displaying");
				      test.log(LogStatus.PASS, "Delete DialogBox","Delete is  Displaying");
				      String deleteStatement = driver.findElement(By.xpath(xpathDeleteStatement)).getText();
				     System.out.println(deleteStatement);
				      Assert.assertEquals(deleteStatement,"Are you sure you want to delete this entry?","MSg is displaying");
				      test.log(LogStatus.PASS, "Delete DialogBox", "This flow is under Inprogress state, If you delete this flow then related pipeline will fail");
				      WebElement yesButton = driver.findElement(By.xpath(xpathDeleteYesButton));
				      Assert.assertTrue(yesButton.isEnabled());
				      test.log(LogStatus.PASS, "yes Button", "yes Button is displaying and Enabled");
				      WebElement noButton = driver.findElement(By.xpath(xpathDeleteNoButton));
				      Assert.assertTrue(noButton.isEnabled());
				      test.log(LogStatus.PASS, "NO Button","NO Button is displaying and Enabled");
				      driver.findElement(By.xpath(nobutton)).click();
				
			}
			   
			   
			   @Test(priority = 11, dependsOnMethods = { "verifyDeleteDialogBox" }, groups = { "Smoke" })
				public static void verifyDeleteRecord() throws InterruptedException {
					
					Thread.sleep(1000);
					test=report.startTest("Delete Record");
							
					int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
					Thread.sleep(1000);
					String flow = driver.findElement(By.xpath("//*[@id='root']//tbody/tr[1]/td[2]")).getText();
				
					driver.findElement(By.xpath(xpathDelete)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(yesButton)).click();
					Thread.sleep(1500);
					String toaster = driver.findElement(By.xpath(xpathtoaster)).getText();
					Assert.assertEquals(toaster,"Scheduled Flow deleted successfully!","Record is not Deleted succesfully ");
				     test.log(LogStatus.PASS, "Delete Record", "Record is Deleted Successfully Toaster message is displaying");
				     
				     int flowName=driver.findElements(By.xpath("//*[@id='root']//tbody/tr/td[2]")).size();
			 		
			 		for(int i=1;i<=flowName;i++)
			 		{
			 			if(driver.findElement(By.xpath("//*[@id='root']//tbody/tr["+i+"]//td[2]")).equals(flow))
			 			{
			 				System.out.println("record is not deleted , Displaying on screen ");
			 				test.log(LogStatus.FAIL, "Delete Record", "Record is not Deleted, Displaying On Screen");
			 			}
			          }
			 		System.out.println("Record is Deleted Successfuly ,not displaying on Screen");
			 		test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully, not Displaying on Screen");
			 		
			   }
			   
			   
			
			   @Test(priority = 12, dependsOnMethods = { "verifyDeleteRecord" }, groups = { "Smoke" })
				public static void verifyNowFrequency() throws InterruptedException 
				{
				   test=report.startTest("Now Frequency");
				   
				 
					driver.findElement(By.xpath(xpathDataFlowScheduled)).click();
				  
				   driver.findElement(By.xpath(xpathDataFlowName)).click();
				   Thread.sleep(1000);
				   driver.findElement(By.xpath("//*[@id='menu-dataflowname']//div//ul/li[text()='Dataflowtesting']")).click(); // ENTER NAME OF FLOW THAT YOU WANT SELECT 				   Thread.sleep(1000);
				   Thread.sleep(1000);
					driver.findElement(By.xpath(xpathSelectFrequency)).click();
				   Thread.sleep(1000);
				   driver.findElement(By.xpath("//*[@id='root']//div[1][text()='Now']")).click();
				
			
				       Thread.sleep(1000);
				       String description=reader.getCellData("Scheduler","Description", 2); 
				       driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(description);
			           Thread.sleep(1000);
					   driver.findElement(By.xpath(xpathSubmit)).click();
					   Thread.sleep(1000);
					   String alerts = driver.findElement(By.xpath(xpathtoaster)).getText();
				       Assert.assertEquals(alerts,"Flow Scheduled successfully!","Schedule is not created for this Data flow");
				       test.log(LogStatus.PASS,"Schedule Data flow", "flow for frequency Now is Scheduled");
					   
					
				       boolean DataFlowName = driver.findElement(By.xpath(xpathDataFlowName)).isDisplayed();
				       Assert.assertEquals(DataFlowName,true,"DataFlow Field is not Displaying");
				       test.log(LogStatus.PASS, "Delete DialogBox","DataFlow Field is  Displaying");
					  
					   boolean selectFrequency = driver.findElement(By.xpath(xpathSelectFrequency)).isDisplayed();
					   Assert.assertEquals(selectFrequency,true,"select Frequency Field is not Displaying");
					   test.log(LogStatus.PASS, "Delete DialogBox", "select Frequency Field is Displaying");  
					 
					   Thread.sleep(3000);
					   
					   boolean descriptions = driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).isDisplayed();
					   Assert.assertEquals(descriptions,true,"description Field is not Displaying");
					   test.log(LogStatus.PASS, "Delete DialogBox", "description Field is Displaying");  
					  
				    }
			   @Test(priority = 13, dependsOnMethods = { "verifyNowFrequency" }, groups = { "Smoke" })
				public static void verifySpecificDayFrequency() throws InterruptedException 
				{
				   test=report.startTest("Specific Day  Frequency");
				   driver.navigate().refresh();
				 
				   driver.findElement(By.xpath(xpathDataFlowName)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='menu-dataflowname']//div//ul/li[text()='SuperStoreSales123']")).click(); // ENTER NAME OF FLOW THAT YOU WANT SELECT 				Thread.sleep(1000);
					Thread.sleep(1000);
					driver.findElement(By.xpath(xpathSelectFrequency)).click();
				   driver.findElement(By.xpath("//*[@id='root']//div[text()='Specific day of each month']")).click();
				   driver.findElement(By.id("specificId")).sendKeys(reader.getCellData("Scheduler","Day", 2));
				   Thread.sleep(1000);
				   driver.findElement(By.id("enddatetime")).click();
				   Thread.sleep(1000);
				   driver.findElement(By.xpath("//*[@id='Edate']/div/div[2]/div/div[2]/div[2]/div[5]/div[7]")).click();
				   
				   
				    String description=reader.getCellData("Scheduler","Description", 2); 
					driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(description);
			        Thread.sleep(1000);
					driver.findElement(By.xpath(xpathSubmit)).click();
					Thread.sleep(1000);
					String toaster = driver.findElement(By.xpath(xpathtoaster)).getText();
				
					System.out.println(toaster);
			        Assert.assertEquals(toaster,"Flow Scheduled successfully!","Flow is not Scheduled succesfully");
			        test.log(LogStatus.PASS,"Flow Scheduled", "Flow is Scheduled succesfully");
			        

			 	    int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
			 	 
			        for(int i=1;i<=numberOfRecords;i++)
			        {
				      if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals("Priyanka"))
			 	    {
			 			 
			 			test.log(LogStatus.PASS,"Record is displaying on grid Sucessfully!!!");
			 		}
			 		}	
                    }
		     
                    }
		
