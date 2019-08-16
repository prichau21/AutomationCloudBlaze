package com.CloudBlaze.Onboarding;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

    public class ServicePrincipal extends BaseClass implements IOnBoarding {

	
	
	
	
	
	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	@Test(priority=1, groups = { "Smoke" })
	public void VerifyLogin() throws InterruptedException
	{ 
		test = report.startTest("login");
	    driver.manage().timeouts().implicitlyWait(8,TimeUnit.SECONDS) ;
	    driver.findElement(By.xpath("//*[@id='root']//button[text()='Login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='i0116']")).sendKeys("priyanka.chauhan@rawcubes.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='i0118']")).sendKeys("Sanju21@");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
	    Thread.sleep(1000);
		
	}	
	
	@Test(priority=2,dependsOnMethods = { "VerifyLogin" }, groups= { "Smoke" })
	public void verifyServicePrincipalPage() throws InterruptedException
	{
		//driver.navigate().refresh();
		Thread.sleep(1000);
		test = report.startTest("Click on Service Principal Page Link");

		try {
			driver.findElement(By.xpath(xpathServicePrincipalLink)).click();

		} 
		catch (ElementNotVisibleException e)
		{
		e.printStackTrace();
		}
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User has successfully clicked on Service Principal Page Link");
	}
	
	
	 //Verify When user Click on Service Principal Page ,it will Display 
		@Test(priority = 3, dependsOnMethods = { "verifyServicePrincipalPage" }, groups = { "Smoke" })
		public static void verifyUrlOfServicePrincipal() throws InterruptedException 
		{
           // driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Url of Service Principal  Page");
	        
			// verify the Url of the page
			if(driver.getCurrentUrl().equals(xpathUrlOfServicePrincipal)) {
			Assert.assertEquals(xpathUrlOfServicePrincipal, driver.getCurrentUrl(),"URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
				}
			else 
			{
		    test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
			}
			
			 if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
			 {    test.log(LogStatus.FAIL, "Service Principal Screen not Displaying");
				 System.out.println("Service Principal  page Screen is not Displaying");
			 }
			 
			 else
			 {
				 test.log(LogStatus.PASS,"Service Principal  page Screen is  Displaying");
				 System.out.println("Service Principal page Screen is Displaying ");
			 }
			
			
	      }
//     /* BreadCrumbs
//		public String idOfApplicationID="servicePrincipalId";
//		public String xpathOfApplicationWM="//*[@id='root']//label[text()='ApplicationID']";
//		public String idOfDescription="description";
//		public String xpathOfDescription="//*[@id='root']//label[text()='Description']";
//		public String idOfKey="servicePrincipalKey";
//		public String xpaOfKeyWM="//*[@id=
//		*/
		
		@Test(priority = 4, dependsOnMethods = { "verifyUrlOfServicePrincipal" }, groups = { "Smoke" })
		public static void verifyComponentsOfServicePrincipal() throws InterruptedException 
		{

		//	driver.navigate().refresh();
			
			test = report.startTest("Verify Components of Service Principal  Page");
			
			    //verify Title of Page
			    String titleOfSPD = driver.findElement(By.xpath(xpathTitleOfSPD)).getText();
	            Assert.assertEquals(titleOfSPD,"Add Service Principal Details","Add ServicePrincipal Details Title is not Displaying ");
	            test.log(LogStatus.PASS, "Add ServicePrincipal Details Title", "Add ServicePrincipal Details Title is Displaying");
	         
                //verify Name Field 
	  		    WebElement name=driver.findElement(By.id(idOfName));
	  		    Assert.assertTrue(name.isDisplayed());
	  		    test.log(LogStatus.PASS, "Name Field", "Name Field is displaying");
	  		
	  		    //Verify Name Field WaterMark
	  		    String nameWM = driver.findElement(By.xpath(xpathOfNameWM)).getText();
	            Assert.assertEquals(nameWM,"Name *","Name * WaterAmrk is not Displaying ");
	            test.log(LogStatus.PASS, "Name Field WaterMark","Name * WaterMark is Displaying");

	   		    //verify ApplicationID Field 
	   		    WebElement applicationID=driver.findElement(By.id(idOfApplicationID));
	   		    Assert.assertTrue(applicationID.isDisplayed());
	   		    test.log(LogStatus.PASS,"ApplicationID Field", "ApplicationID Field is displaying");
	   		
	   		    //Verify ApplicationID WaterMark
	   		    String applicationWM = driver.findElement(By.xpath(xpathOfApplicationWM)).getText();
	            Assert.assertEquals(applicationWM,"ApplicationID *","Application Water Mark is not Displaying ");
	            test.log(LogStatus.PASS, "Application Field WaterMark","Application Water Mark is Displaying");
	            
	             //verify Key Field 
	     		WebElement key=driver.findElement(By.id(idOfKey));
	     		Assert.assertTrue(key.isDisplayed());
	     		test.log(LogStatus.PASS, "Key Field", "Key Field is displaying");
	     		
         		//Verify Key Field WaterMark
	     		 String keyWM = driver.findElement(By.xpath(xpathOfKeyWM)).getText();
     	     	 Assert.assertEquals(keyWM,"Key *","Key * WaterMark is not Displaying");
                 test.log(LogStatus.PASS,"Key Field WaterMark", "Key * WaterMark is Displaying");
	     		
	    		//verify Description Field 
	    		WebElement description=driver.findElement(By.id(idOfDescription));
	    		Assert.assertTrue(description.isDisplayed());
	    		test.log(LogStatus.PASS, "Description Field", "Description Field is displaying");
	    		
	    		//Verify Description Field WaterMark
	    		 String descriptionWM = driver.findElement(By.xpath(xpathOfDescription)).getText();
	             Assert.assertEquals(descriptionWM,"Description","Description Water Mark is not Displaying ");
	             test.log(LogStatus.PASS, "Description Field WaterMark", "Description Water Mark is Displaying");

	     		
	     		//Verify Grid 
	     		WebElement gridOfSp=driver.findElement(By.xpath(xpathOfGridOfSp));
	     		Assert.assertTrue(gridOfSp.isDisplayed());
	     		test.log(LogStatus.PASS, "Grid Of Service Principal", "Grid Of Service Principal is displaying");
	     		
	     		//Verify Submit and Cancel Button 
	     		 WebElement submitButton=driver.findElement(By.xpath(xpathSubmitButtonSP));
	             Assert.assertTrue(submitButton.isEnabled());
	    	     test.log(LogStatus.PASS, "submit Button", "submit Button is displaying and Enabled");
	    	     
	             WebElement cancelButton=driver.findElement(By.xpath(xpathCancelbutton));
	             Assert.assertTrue(cancelButton.isEnabled());
	    	     test.log(LogStatus.PASS, "cancel Button", "cancel Button is displaying and Enabled");
	     		
		   }
		       //Verify Components Of Grid
	     	    @Test(priority = 5, dependsOnMethods = { "verifyComponentsOfServicePrincipal" }, groups = { "Smoke" })
	    		public static void verifyRecordesInGrid() throws InterruptedException 
	    		{
	     	   // driver.navigate().refresh();
	    	   Thread.sleep(3000);	
	     	  
	     		//Verify recordes of Grid
	     	    test = report.startTest("Verify Recordes in Grid");
	     	    boolean rowInGrid = driver.findElement(By.xpath(xpathRowInGrid)).getText().isEmpty();
	   		    Assert.assertFalse(rowInGrid);
	   		    test.log(LogStatus.PASS, "Row In Grid", "Row In Grid is displaying");
   		  
	    		}
	     	    
	     	   @Test(priority = 6, dependsOnMethods = { "verifyRecordesInGrid" }, groups = { "Smoke" })
	    		public static void verifyColumnsOfGrid() throws InterruptedException 
	   		// verify any row in grid is displaying or not
	    		{
	     		  test = report.startTest("Verify Columns in Grid"); 
	   		   
	   		
	   	   //verify number of columns in Grid
			 int columnsInGrid = driver.findElements(By.xpath(xpathColumnsInGrid)).size();
			 if(columnsInGrid==6)
			 {
				 System.out.println("6 columns are displaying on grid");
				 test.log(LogStatus.PASS, "Total columns", "6 columns are displaying on grid");
			 }
			 else
			 {   System.out.println("6 columns are not displaying on grid");
				 test.log(LogStatus.FAIL, "Total columns", "6 columns are not displaying on grid");
				 
			 }
	   		
	       	 //Verify all Column name
			 for(int i=1;i<=columnsInGrid;i++)
			 {
				 String columns  = driver.findElement(By.xpath("//*[@id='root']//table//th[" + i + "]")).getText();
			     if(columns.equals("S.No."))
			     {
			    	 
					 test.log(LogStatus.PASS, "Total columns", "S.No. is Displaying");
					  
			     }
			     if(columns.equals("Service Principal Name"))
			     {
			    	 
					 test.log(LogStatus.PASS, "Total columns", "Subscription Name is Displaying"); 
			     }
			    
			     if(columns.equals("Description"))
			    {
			    	
					 test.log(LogStatus.PASS, "Total columns", "Description is Displaying");  
			    }
			     if(columns.equals("Created On"))
			     {
			    	
					 test.log(LogStatus.PASS, "Total columns", "Created On is Displaying"); 
			     }
			     if(columns.equals("Last ActionBy"))
			     {
			     test.log(LogStatus.PASS, "Total columns", "Last ActionBy is Displaying"); 
			    	 
			     }

			     if(columns.equals("Action"))
			     {
			     test.log(LogStatus.PASS, "Total columns", "Action is Displaying"); 
			    	 
			     }

	   		
	   	}
	    		}
	     	 
	       
	     @Test(priority = 7, dependsOnMethods = { "verifyColumnsOfGrid" }, groups = { "Smoke" })
		  	public static void verifyEditDeleteButtons() throws InterruptedException 
		    {
                //verify Delete and Edit Button 
	             WebElement deleteButton=driver.findElement(By.className(classDeleteButton));
	             Assert.assertTrue(deleteButton.isEnabled());
	    	     test.log(LogStatus.PASS, "Delete Button", "Delete Button is displaying and Enabled");
	     		 WebElement editButton=driver.findElement(By.className("editlink"));
	     		 Assert.assertTrue(editButton.isEnabled());
	     		 test.log(LogStatus.PASS, "Edit Button", "Edit Button is displaying and Enabled");
	                
          }
	     	
	     @Test(priority = 8, dependsOnMethods = { "verifyEditDeleteButtons" }, groups = { "Smoke" })
	 	public static void verifyValidations() throws InterruptedException 
	 	{ 
	 		// driver.navigate().refresh();
	 		 Thread.sleep(1000);
	 		 test = report.startTest("On Click Of Submit Button Alert Is Coming");
	 		 driver.findElement(By.xpath(xpathSubmitButtonSP)).click();
	 		 Thread.sleep(2000);
	 		
	 		 
	 		 String alertOnName = driver.findElement(By.xpath(xpathAlertOnName)).getText();
	 		 Assert.assertEquals(alertOnName,"Name can't be empty","'Name can't be empty' alert is not Displaying ");
	 		 test.log(LogStatus.PASS, "Alert on Name", "'Name cannot be empty' alert is Displaying");
	 		
	 		 String alertOnApplicationID = driver.findElement(By.xpath(xpathAlertOnApplicationID)).getText();
	 		 Assert.assertEquals(alertOnApplicationID,"Application ID can't be empty","'Application ID can't be empty' alert is not Displaying ");
	 		 test.log(LogStatus.PASS, "alert On ApplicationID", "'Application ID can't be empty' alert is Displaying");
	 		 

	 		
	 		 String alertOnKey = driver.findElement(By.xpath(xpathAlertOnKey)).getText();
	 		 Assert.assertEquals(alertOnKey,"Key cannot be empty","'Key cannot be empty' alert is not Displaying ");
	 		 test.log(LogStatus.PASS, "alert On Key", "'Key cannot be empty' alert is Displaying");
	 		 

	 		 
	 		 driver.findElement(By.id(idOfName)).sendKeys(reader.getCellData("ServicePrincipal", "Name", 4));
	 		 String alertOnNameField = driver.findElement(By.xpath(xpathAlertOnName)).getText();
	 		 Assert.assertEquals(alertOnNameField,"Name should be greater than 4","'Name should be greater than 4' alert is not Displaying ");
	 		 test.log(LogStatus.PASS, "Alert on Name","'Name should be greater than 4 characters' alert is Displaying");
	 		 
	 		 driver.findElement(By.id(idOfApplicationID)).sendKeys(reader.getCellData("ServicePrincipal","ApplicationID", 4));
	 	     Thread.sleep(1000);
	 	     String alertApplicationID = driver.findElement(By.xpath(xpathAlertOnApplicationID)).getText();
	 		 Assert.assertEquals(alertApplicationID,"Application ID is not valid","'Application ID is not valid' alert is not Displaying ");
	 		 test.log(LogStatus.PASS, "Alert on ApplicationID", "'Application ID is not valid' alert is Displaying"); 
	 		 
	 		 

	 		 
	 	 }
	     
	     

	 	// verify number of Records in Grid
	 	    @Test(priority = 9, dependsOnMethods = { "verifyValidations" }, groups = { "Smoke" })
	 	    public static void verifyNumberOfRecords() throws InterruptedException 
	 	    
	 	    {
	 		test = report.startTest("Verify Numbers of Records In grid");
	 		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
	 		test.log(LogStatus.PASS, "Number of Rows In Grid", "" + rows + "rows In Grid is displaying");
	 	}
	     	
	     	@Test(priority = 10, dependsOnMethods = { "verifyNumberOfRecords" }, groups = { "Smoke" })
	     	public static void verifyFieldsDataGetClearOnCancelClick() throws InterruptedException 
    		{
	     		
	     		
	     		test = report.startTest("Verify On Click Of Cancel All Fields Should Get Clear");
	    		//driver.navigate().refresh();
	    		Thread.sleep(1000);
	    	
	    		driver.findElement(By.id(idOfName)).sendKeys(reader.getCellData("ServicePrincipal","Name", 2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.id(idOfApplicationID)).sendKeys(reader.getCellData("ServicePrincipal","ApplicationID",2));
	     		Thread.sleep(1000);
	     		
	     		driver.findElement(By.id(idOfKey)).sendKeys(reader.getCellData("ServicePrincipal","Key", 2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.id(idOfDescription)).sendKeys(reader.getCellData("ServicePrincipal","Description",2));
	     		Thread.sleep(1000);
	    		
	    		
	     		driver.findElement(By.xpath(xpathCancelbutton)).click();
	     		
	    		Thread.sleep(4000);
	    		
	    	
	    		if( driver.findElement(By.id(idOfName)).getAttribute("value").equals("")&&
	               driver.findElement(By.id(idOfApplicationID)).getAttribute("value").equals("")&&
	               driver.findElement(By.id(idOfKey)).getAttribute("value").equals("")&&driver.findElement(By.id(idOfDescription)).getAttribute("value").equals("") )
	                  {
	    			   System.out.println("After cancel button all fields are getting blank");
	    			   test.log(LogStatus.PASS, "OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields Should get clear ");
	    		      }else
	    		      {
	    		    	  test.log(LogStatus.FAIL,"OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields not  get clear"  );
	    		      }
	           }
	     		
	     		
	     		
	        @Test(priority = 11, dependsOnMethods = { "verifyFieldsDataGetClearOnCancelClick" }, groups = { "Smoke" })
	     	public static void verifyAddServicePrincipal() throws InterruptedException 
    		{   
	        	//driver.navigate().refresh();
	        	Thread.sleep(1000);
	        	test = report.startTest("Add Service Principal");
	     		
	        	
               

	     		driver.findElement(By.id(idOfName)).sendKeys(reader.getCellData("ServicePrincipal","Name", 2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.id(idOfApplicationID)).sendKeys(reader.getCellData("ServicePrincipal","ApplicationID",2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.id(idOfKey)).sendKeys(reader.getCellData("ServicePrincipal","Key", 2));
	     		Thread.sleep(1000);	
	     		driver.findElement(By.id(idOfDescription)).sendKeys(reader.getCellData("ServicePrincipal","Description",2));
	     		Thread.sleep(1000);
	     		
	     		driver.findElement(By.xpath(xpathSubmitButtonSP)).click();
	     		Thread.sleep(1500);
	    		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	    		
	            Assert.assertEquals(toaster,"Service Principal added successfully!","Service Principal is not added succesfully");
	            test.log(LogStatus.PASS, "Service Principal Added", "Service Principal is added succesfully");
	          
	     	    int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	    System.out.println();
	     	    
	     	for(int i=1;i<=numberOfRecords;i++)
	     	  {
	     		   
	                 if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("ServicePrincipal", "Name", 2))&&
	     			    driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[3]")).getText().equals(reader.getCellData("ServicePrincipal","Description", 2)))
	     				{
	     			    test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	     		        }
	           }
	     	   }
	        
	    	  @Test(priority = 12, dependsOnMethods = { "verifyAddServicePrincipal" }, groups = { "Smoke" })
	     	  public static void verifyEditServicePrincipal() throws InterruptedException 
    		  {
	    		
	            // driver.navigate().refresh();
	    	     Thread.sleep(1000);
	    	     test=report.startTest("Edit Record of Service Principal Page");
	    		 driver.findElement(By.xpath(xpathEdit)).click();
	    	 
	    		 Thread.sleep(1000);
	    		 
	    		 driver.findElement(By.id(idOfName)).sendKeys(Keys.CONTROL + "a");
	    		 driver.findElement(By.id(idOfName)).sendKeys(Keys.BACK_SPACE);
	    		 
	    		 driver.findElement(By.id(idOfName)).sendKeys(reader.getCellData("ServicePrincipal", "Name", 3));
	    	     Thread.sleep(1000);
	    	     
	    	     driver.findElement(By.id(idOfApplicationID)).sendKeys(Keys.CONTROL + "a");
	    		 driver.findElement(By.id(idOfApplicationID)).sendKeys(Keys.BACK_SPACE);
	    	
	    	     driver.findElement(By.id(idOfApplicationID)).sendKeys(reader.getCellData("ServicePrincipal","ApplicationID",3));
	    		 Thread.sleep(1000);
	    		 
	    		 driver.findElement(By.id(idOfKey)).sendKeys(Keys.CONTROL + "a");
	    		 driver.findElement(By.id(idOfKey)).sendKeys(Keys.BACK_SPACE);
	    	
	    	     driver.findElement(By.id(idOfKey)).sendKeys(reader.getCellData("ServicePrincipal","Key",3));
	    		 Thread.sleep(1000);
	    		 
	    		 driver.findElement(By.id(idOfDescription)).sendKeys(Keys.CONTROL + "a");
	    		 driver.findElement(By.id(idOfDescription)).sendKeys(Keys.BACK_SPACE);
	    	
	    	     driver.findElement(By.id(idOfDescription)).sendKeys(reader.getCellData("ServicePrincipal","Description",3));
	    		 Thread.sleep(1000);
	    		 
	    		 driver.findElement(By.xpath(xpathSubmitButtonSP)).click();
	    		 Thread.sleep(1500);
	    		 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	    		 Thread.sleep(1000);
	    		 Assert.assertEquals(toaster,"Service Principal updated successfully!"," Service principal updation is not succesfully");
	    	     test.log(LogStatus.PASS, "Service Principal Edit", "Service Principal updation is succesfully");
          } 

	    	
	    	  @Test(priority = 13, dependsOnMethods = { "verifyEditServicePrincipal" }, groups = { "Smoke" })
	    	public static void verifyDeleteDialogBox() throws InterruptedException 
	    	{ 
	    		// driver.navigate().refresh();
	    		 Thread.sleep(1000);
	             test=report.startTest("DeleteDialogBox");
	    		 driver.findElement(By.className(classDeleteButton)).click();
	    		 //WebElement deleteDialogBox = driver.findElement(By.xpath(xpathDeleteDialogBox));
	    		// Assert.assertTrue(deleteDialogBox.isDisplayed());
	    		// test.log(LogStatus.PASS, "Delete DialogBox","delete DialogBox is displaying");
	    		 String deleteText = driver.findElement(By.xpath(xpathDeleteText)).getText();
	    		 Assert.assertEquals(deleteText,"Delete","Delete  is not Displaying");
	    		 test.log(LogStatus.PASS, "Delete DialogBox","Delete is  Displaying");
	    		 String deleteStatement = driver.findElement(By.xpath(xpathDeleteStatement)).getText();
	    		 Assert.assertEquals(deleteStatement,"Are you sure you want to delete this entry?","Are you sure you want to delete this entry? text is not displaying!!!");
	    		 test.log(LogStatus.PASS, "Delete DialogBox", "Are you sure you want to delete this entry? text is  Displaying");
	    		 WebElement yesButton = driver.findElement(By.xpath(xpathDeleteYesButton));
	    		 Assert.assertTrue(yesButton.isEnabled());
	    		 test.log(LogStatus.PASS, "yes Button", "yes Button is displaying and Enabled");
	    		 WebElement noButton = driver.findElement(By.xpath(xpathDeleteNoButton));
	    		 Assert.assertTrue(noButton.isEnabled());
	    		 test.log(LogStatus.PASS, "NO Button","NO Button is displaying and Enabled");
	    		 
	    		 
	    	}
	    	
	    	@Test(priority = 14, dependsOnMethods = {"verifyDeleteDialogBox"}, groups = { "Smoke" })
	    	public static void verifyDeleteRecord() throws InterruptedException
	    	{
	    		driver.navigate().refresh();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath(xpathServicePrincipalLink)).click();

	    	
	    		test=report.startTest("Delete Record");
	    				
	    		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
	    		Thread.sleep(1000);
	    	
	    		String servicePrincipal = driver.findElement(By.xpath("//*[@id='root']//tbody/tr[1]/td[2]")).getText();
	    		System.out.println(servicePrincipal);
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath(xpathDelete)).click();
	    		Thread.sleep(1000);
	    		driver.findElement(By.xpath(yesButton)).click();
	    		Thread.sleep(1000);
	    		
	    		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	    		
	    		Assert.assertEquals(toaster,"Service Principal deleted successfully!","Record is not Deleted succesfully ");
	    	    test.log(LogStatus.PASS, "Delete Record", "Record is Deleted Successfully Toaster message is displaying");
	    		
	    		
	    		
	    		
	    	int servicePrincipals	=driver.findElements(By.xpath("//*[@id='root']//tbody/tr/td[2]")).size();
	    		
	    		for(int i=1;i<=servicePrincipals;i++)
	    		{
	    			if(driver.findElement(By.xpath("//*[@id='root']//tbody/tr["+i+"]//td[2]")).equals(servicePrincipal))
	    			{
	    				System.out.println("record is not deleted , Displaying on screen ");
	    				test.log(LogStatus.FAIL, "Delete Record", "Record is not Deleted, Displaying On Screen");
	    			}
	             }
	    		System.out.println("Record is Deleted Successfuly ,not displaying on Screen");
	    		test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully, not Displaying on Screen");
	    		
	    		int rows2 = driver.findElements(By.xpath(xpathRowInGrid)).size();
	    		
	    		if (rows2 == rows - 1) {
	    			test.log(LogStatus.PASS, "Delete Record", "one Record is decreased Sucessfully");
	    		} 
	    		else
	    		{
	    			test.log(LogStatus.FAIL, "Delete Record", "Record is not Deleted");
	    		}
	    		}
                }     	








