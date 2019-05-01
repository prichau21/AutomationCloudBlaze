package com.CloudBlaze.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

    public class ServicePrincipal extends BaseClass implements IOnBoarding {

	
	
	
	
	
	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	@Test(priority=1,groups= { "Smoke" })
	public void verifyServicePrincipalPage() throws InterruptedException
	{
		driver.navigate().refresh();
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
		@Test(priority = 2, dependsOnMethods = { "verifyServicePrincipalPage" }, groups = { "Smoke" })
		public static void verifyUrlOfServicePrincipal() throws InterruptedException 
		{

			
			driver.navigate().refresh();
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
	      }
//BreadCrumbs
//		public String idOfApplicationID="servicePrincipalId";
//		public String xpathOfApplicationWM="//*[@id='root']//label[text()='ApplicationID']";
//		public String idOfDescription="description";
//		public String xpathOfDescription="//*[@id='root']//label[text()='Description']";
//		public String idOfKey="servicePrincipalKey";
//		public String xpaOfKeyWM="//*[@id=
//		
		
		@Test(priority = 3, dependsOnMethods = { "verifyUrlOfServicePrincipal" }, groups = { "Smoke" })
		public static void verifyComponentsOfServicePrincipal() throws InterruptedException 
		{

			driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Components of Service Principal  Page");
			
			     //verify Title of Page
			    String titleOfSPD = driver.findElement(By.xpath(xpathTitleOfSPD)).getText();
	            Assert.assertEquals(titleOfSPD,"Add ServicePrincipal Details","Add ServicePrincipal Details Title is not Displaying ");
	            test.log(LogStatus.PASS, "Add ServicePrincipal Details Title", "Add ServicePrincipal Details Title is Displaying");
	         

	 		   //verify Select Subscription Field
	 		   WebElement selectSubscription=driver.findElement(By.id(idOfSSelectSubscription));
	 		   Assert.assertTrue(selectSubscription.isDisplayed());
	 		   test.log(LogStatus.PASS, "Select Subscription Field", "Select Subscription Field is displaying");
	 		
	 		    //Verify Select Subscription Field WaterMark
	 		    String selectSubscriptionWM = driver.findElement(By.xpath(xpathOfSelectSubscriptiomWM)).getText();
	            Assert.assertEquals(selectSubscriptionWM,"SelectSubscription","Select Subscription WaterMark is not Displaying ");
	            test.log(LogStatus.PASS, "Select Subscription WaterMark", "Select Subscription  WaterMark is Displaying");

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
	   		    test.log(LogStatus.PASS, "ApplicationID Field", "ApplicationID Field is displaying");
	   		
	   		    //Verify ApplicationID WaterMark
	   		     String applicationWM = driver.findElement(By.xpath(xpathOfApplicationWM)).getText();
	            Assert.assertEquals(applicationWM,"ApplicationID *","Application Water Mark is not Displaying ");
	            test.log(LogStatus.PASS, "Application Field WaterMark","Application Water Mark is Displaying");

	    		//verify Description Field 
	    		WebElement description=driver.findElement(By.id(idOfDescription));
	    		Assert.assertTrue(description.isDisplayed());
	    		test.log(LogStatus.PASS, "Description Field", "Description Field is displaying");
	    		
	    		//Verify Description Field WaterMark
	    		 String descriptionWM = driver.findElement(By.xpath(xpathOfDescription)).getText();
	             Assert.assertEquals(descriptionWM,"Description","Description Water Mark is not Displaying ");
	             test.log(LogStatus.PASS, "Description Field WaterMark", "Description Water Mark is Displaying");

	     		//verify Key Field 
	     		WebElement key=driver.findElement(By.id(idOfKey));
	     		Assert.assertTrue(key.isDisplayed());
	     		test.log(LogStatus.PASS, "Key Field", "Key Field is displaying");
	     		
         		//Verify Key Field WaterMark
	     		 String keyWM = driver.findElement(By.xpath(xpathOfKeyWM)).getText();
     	     	 Assert.assertEquals(keyWM,"Key *","Key * WaterMark is not Displaying");
                 test.log(LogStatus.PASS,"Key Field WaterMark", "Key * WaterMark is Displaying");
	     		
	     		//Verify Grid 
	     		WebElement gridOfSp=driver.findElement(By.xpath(xpathOfGridOfSp));
	     		Assert.assertTrue(gridOfSp.isDisplayed());
	     		test.log(LogStatus.PASS, "Grid Of Service Principal", "Grid Of Service Principal is displaying");
	     		
	     		//Verify Submit and Cancel Button 
	     		 WebElement submitButton=driver.findElement(By.className(xpathSubmitButtonSP));
	             Assert.assertTrue(submitButton.isEnabled());
	    	     test.log(LogStatus.PASS, "submit Button", "submit Button is displaying and Enabled");
	    	     
	             WebElement cancelButton=driver.findElement(By.className(xpathCancelbutton));
	             Assert.assertTrue(cancelButton.isEnabled());
	    	     test.log(LogStatus.PASS, "cancel Button", "cancel Button is displaying and Enabled");
	     		
		   }
		       //Verify Components Of Grid
	     	    @Test(priority = 4, dependsOnMethods = { "verifyComponentsOfServicePrincipal" }, groups = { "Smoke" })
	    		public static void verifyComponentsOfGrid() throws InterruptedException 
	    		{
	     	    driver.navigate().refresh();
	    		Thread.sleep(3000);	
	     	    test = report.startTest("Verify Components of Grid Page");
	     		//Verify Columns of Grid
	     		String columnsGrid= driver.findElement(By.xpath(xpathColumnOfgrid)).getText();
	     	    Assert.assertEquals(columnsGrid,"S. no ServicePrincipal Name Description Created On Action","Some Column are not Displaying ");
	     	    test.log(LogStatus.PASS,"Column Of Grid", "All Column are Displaying");	
	     		
	     	   //verify any row in grid is displaying or not 
	     		boolean rowInGrid = driver.findElement(By.xpath(xpathRowInGrid)).getText().isEmpty();
	     		Assert.assertFalse(rowInGrid);
	     	test.log(LogStatus.PASS, "Row In Grid", "Row In Grid is displaying");
	    		}
	     	@Test(priority = 5, dependsOnMethods = { "verifyComponentsOfGrid" }, groups = { "Smoke" })
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
	     	
	     	
	     	@Test(priority = 6, dependsOnMethods = { "verifyEditDeleteButtons" }, groups = { "Smoke" })
	     	public static void verifyFieldsDataGetClearOnCancelClick() throws InterruptedException 
    		{
	     		driver.findElement(By.id(idOfSSelectSubscription)).click();
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(xpathFirstSubscriptionFromDropDown)).click();
	     		driver.findElement(By.xpath(idOfName)).sendKeys(reader.getCellData("ServicePrincipal","Name", 2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(idOfApplicationID)).sendKeys(reader.getCellData("ServicePrincipal","ApplicationID",2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(idOfDescription)).sendKeys(reader.getCellData("ServicePrincipal","Description",2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(idOfKey)).sendKeys(reader.getCellData("ServicePrincipal","Key", 2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.className(xpathCancelbutton)).click();
	     		
	     		if((driver.findElement(By.id(idOfSSelectSubscription)).getText().equals(" ") && driver.findElement(By.xpath(idOfName)).getText().equals("")&& 
	     		driver.findElement(By.xpath(idOfApplicationID)).getText().equals("") && driver.findElement(By.xpath(idOfDescription)).getText().equals("") &&
	     		driver.findElement(By.xpath(idOfKey)).getText().equals(" ")))
	     		{
	     			System.out.println("When Click on Cancel Button all Filled Fields are get cleared");
	     			 test.log(LogStatus.PASS, "Clear Field","When Click on Cancel Button all Filled Fields are get cleared");
		                
	     		}
	     		else
	     		{
	     			test.log(LogStatus.FAIL,"When click on cancel button, filled fields are not get cleared");
	     		}
	     		
    		}
	     	@Test(priority = 7, dependsOnMethods = { "verifyFieldsDataGetClearOnCancelClick" }, groups = { "Smoke" })
	     	public static void verifyAddServicePrincipal() throws InterruptedException 
    		{
	     		driver.findElement(By.id(idOfSSelectSubscription)).click();
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(xpathFirstSubscriptionFromDropDown)).click();
	     		driver.findElement(By.xpath(idOfName)).sendKeys(reader.getCellData("ServicePrincipal","Name", 2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(idOfApplicationID)).sendKeys(reader.getCellData("ServicePrincipal","ApplicationID",2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(idOfDescription)).sendKeys(reader.getCellData("ServicePrincipal","Description",2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.xpath(idOfKey)).sendKeys(reader.getCellData("ServicePrincipal","Key", 2));
	     		Thread.sleep(1000);	
	     		driver.findElement(By.className(xpathSubmitButtonSP)).click();
	     		Thread.sleep(3000);
	     		int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     		if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+numberOfRecords+"]//td[2]")).getText().equals(reader.getCellData("ServicePrincipal", "Name", 2))
	     		&& driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+numberOfRecords+"]//td[3]")).getText().equals(reader.getCellData("ServicePrincipal", "Description", 2)))
	     		{
	     			System.out.println("Record is added Successfully");
	     			test.log(LogStatus.PASS,"Record is added sucessfully and is displaying in grid");
	     		}
	     		else
	     		{
	     			test.log(LogStatus.FAIL,"Record is not added sucessfully or is not displaying in grid");
	     		} 
	     		
	     		
	     		if(driver.findElement(By.xpath(toasterRecordSaved)).getText().equals("Record successfully saved"))
	     				{
	     			     test.log(LogStatus.PASS,"Record successfully saved Toaster is Displaying ");
	     			
	     				}
	     		else
	     		{
	     			test.log(LogStatus.FAIL,"Record successfully saved Toaster is not displaying");
	     		}
    		
    		}    
	    	@Test(priority = 8, dependsOnMethods = { "verifyAddServicePrincipal" }, groups = { "Smoke" })
	     	public static void verifyEditServicePrincipal() throws InterruptedException 
    		{
            } 
            }     	








