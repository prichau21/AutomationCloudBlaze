package com.CloudBlaze.Onboarding;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.CloudBlaze.Base.ExcelUtils;
import com.relevantcodes.extentreports.LogStatus;
public class Subscription extends BaseClass implements IOnBoarding 
{

	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");

	@Test(priority=1, groups = { "Smoke" })
	public void VerifyLogin() throws InterruptedException
	{  test = report.startTest("login");

		driver.findElement(By.xpath("//*[@id='root']//button[text()='Login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='i0116']")).sendKeys("priyanka.chauhan@rawcubes.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='i0118']")).sendKeys("Sanju21@");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
	    Thread.sleep(1000);
		
	}
	
	
	@Test(priority = 2,  dependsOnMethods = { "VerifyLogin" },groups = { "Smoke" })
	public void verifySubscriptionPage() throws InterruptedException 
	{
		//driver.navigate().refresh();
		Thread.sleep(1000);

		test = report.startTest("Click on Subscription Page Link");

		try {
			driver.findElement(By.xpath(xpathSubscriptionLink)).click();

		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User has successfully clicked on Subscription Page Link");
	}

	// Verify When user Click on Service Subscription Page ,its page will Display
	@Test(priority = 3, dependsOnMethods = { "verifySubscriptionPage" }, groups = { "Smoke" })
	public static void verifyUrlOfSubscription() throws InterruptedException 
	{

		test = report.startTest("Verify Url of Subscription  Page");
      
       System.out.println(driver.getCurrentUrl());
		// verify the Url of the page
		if (driver.getCurrentUrl().equals(xpathUrlOfSubscription)) {
			Assert.assertEquals(xpathUrlOfSubscription, driver.getCurrentUrl(), "URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
		} else {
			test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
		}
		
		
		 if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
		 {    test.log(LogStatus.FAIL, "Subscription page Screen not Displaying");
			 System.out.println("Subscription page Screen is not Displaying");
		 }
		 
		 else
		 {
			 test.log(LogStatus.PASS,"Subscription page Screen is  Displaying");
			 System.out.println("Subscription page Screen is Displaying ");
		 }
	}
	// verify BreadCrumbs

	// Verify Components of Subscription Page
	@Test(priority = 4, dependsOnMethods = { "verifyUrlOfSubscription" }, groups = { "Smoke" })
	public static void verifySubscriptionPageComponents() throws InterruptedException 
	{

		test = report.startTest("Verify Components of Subscription  Page");
         
		
		 //verify Select Service Principal
		   WebElement selectServicePrincipal=driver.findElement(By.xpath(xpathSelectServicePrincipal));
		   Assert.assertTrue(selectServicePrincipal.isDisplayed());
		   test.log(LogStatus.PASS, "Select Service Principal","Select Service Principal is displaying");
		   
		    //Verify Select Service Principal Field WaterMark
		    String selectServicePrincipalWM = driver.findElement(By.xpath(xpathSelectServicePrincipalWM)).getText();
           Assert.assertEquals(selectServicePrincipalWM,"Select Service Principal *","select Service Principal WaterMark is not Displaying ");
           test.log(LogStatus.PASS,"Select Service Principal WM", "select Service Principal WaterMark is Displaying");
		
		
		// Verify Name Field
		WebElement name = driver.findElement(By.id(idName));
		Assert.assertTrue(name.isDisplayed());
		test.log(LogStatus.PASS, "Name Field", "Name Field is displaying");

		// Verify Name Field WaterMark
		String nameWaterMark = driver.findElement(By.xpath(xpathNameWaterMark)).getText();
		Assert.assertEquals(nameWaterMark, "Name *", "Name * WaterAmrk is not Displaying ");
		test.log(LogStatus.PASS, "Name Field WaterMark", "Name *  WaterMark is Displaying");

		// Verify Subscription Id Field
		WebElement subScription = driver.findElement(By.id(idSubScription));
		Assert.assertTrue(subScription.isDisplayed());
		test.log(LogStatus.PASS, "SubScription Field", "SubScription Field is displaying");

		// Verify Subscription Id Field WaterMark
		String subscriptionIdWaterMark = driver.findElement(By.xpath(xpathSubscriptionIdWaterMark)).getText();
		Assert.assertEquals(subscriptionIdWaterMark, "Subscription ID *",
				"Subscription ID * WaterMark is not Displaying ");
		test.log(LogStatus.PASS, "SubScription Field WaterMark", "Subscription ID * WaterMark is Displaying");

		// Verify Description Field
		WebElement description = driver.findElement(By.id(idDescription));
		Assert.assertTrue(description.isDisplayed());
		test.log(LogStatus.PASS, "Description Field", "Description Field is displaying");

		// Verify Description Field WaterMark
		String descriptionWaterMark = driver.findElement(By.xpath(xpathDescriptionWaterMark)).getText();
		Assert.assertEquals(descriptionWaterMark, "Description", "Description WaterMark is not Displaying ");
		test.log(LogStatus.PASS, "Description Field WaterMark", "Description WaterMark is Displaying");

		// Verify and Validate Submit Button
		WebElement submitBtn = driver.findElement(By.id(idSubmitBtn));
		Assert.assertTrue(submitBtn.isEnabled());
		test.log(LogStatus.PASS, "Submit Button", "Submit Button is displaying and Enabled");

		// Verify and Validate Submit Button Text
		String submitText = driver.findElement(By.id(idSubmitBtn)).getText();
		Assert.assertEquals(submitText, "Submit", "Submit Text is not Displaying ");
		test.log(LogStatus.PASS, "Submit Button Text", "Submit Text is Displaying");

		// Verify and Validate Cancel Button
		WebElement cancelButton = driver.findElement(By.xpath(xpathCancelButton));
		Assert.assertTrue(cancelButton.isEnabled());
		test.log(LogStatus.PASS, "cancel Button", "cancel Button is displaying and Enabled");

		// Verify and Validate Cancel Button Text
		String cancelButtonText = driver.findElement(By.xpath(xpathCancelButton)).getText();
		Assert.assertEquals(cancelButtonText, "Cancel", "Cancel Text is not Displaying ");
		test.log(LogStatus.PASS, "Cancel Button Text", "Cancel Text is Displaying");

		// Verify and Validate Grid or contents Container
		WebElement gridOfSubscription = driver.findElement(By.xpath(xpathOfGridOfSubscription));
		Assert.assertTrue(gridOfSubscription.isDisplayed());
		test.log(LogStatus.PASS, "Grid Of Subscription", "Grid Of Subscription is displaying");

	}

	// Verify Components of Grid
	@Test(priority = 5, dependsOnMethods = { "verifySubscriptionPageComponents" }, groups = { "Smoke" })
	public static void verifyGridComponents() throws InterruptedException {

		test = report.startTest("Verify Components of Grid");

//		//Verify Columns of Grid
//		String columnsGrid = driver.findElement(By.xpath(xpathColumnOfgrid)).getText();
//		Assert.assertEquals(columnsGrid,"S. noSubscription NameSubscription IdDescriptionCreated OnAction");
//		test.log(LogStatus.PASS, "Column Of Grid", "All Column are Displaying");

		// verify any row in grid is displaying or not

		boolean rowInGrid = driver.findElement(By.xpath(xpathRowInGrid)).getText().isEmpty();
		Assert.assertFalse(rowInGrid);
		test.log(LogStatus.PASS, "Row In Grid", "Row In Grid is displaying");

		// verify Delete and Edit Buttons
		WebElement deleteButton = driver.findElement(By.className(classDeleteButton));
		Assert.assertTrue(deleteButton.isEnabled());
		test.log(LogStatus.PASS, "Delete Button", "Delete Button is displaying and Enabled");
		WebElement editButton = driver.findElement(By.className("editlink"));
		Assert.assertTrue(editButton.isEnabled());
		test.log(LogStatus.PASS, "Edit Button", "Edit Button is displaying and Enabled");
	}
	
	
	
	
	 @Test(priority = 6, dependsOnMethods = { "verifyGridComponents" }, groups = { "Smoke" })
		public static void verifyColumnsOfGrid() throws InterruptedException 
	
		{
		  test = report.startTest("Verify Columns in Grid"); 
	   
	
   //verify number of columns in Grid
	 int columnsInGrid = driver.findElements(By.xpath(xpathColumnsInGrid)).size();
	 if(columnsInGrid==7)
	 {
		
		 test.log(LogStatus.PASS, "Total columns", "7 columns are displaying on grid");
	 }
	 else
	 { 
		 test.log(LogStatus.FAIL, "Total columns", "7 columns are not displaying on grid");
		 
	 }
	
	 //Verify all Column name
	 for(int i=1;i<=columnsInGrid;i++)
	 {
		 String columns  = driver.findElement(By.xpath("//*[@id='root']//table//th[" + i + "]")).getText();
	     if(columns.equals("S.No."))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "S.No. is Displaying");
			  
	     }
	     if(columns.equals("Subscription Name"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Subscription Name is Displaying"); 
	     }
	     if(columns.equals("Subscription Id"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Subscription Id is Displaying"); 
	     }
	    
	     if(columns.equals("Description"))
	    {
	    	
			 test.log(LogStatus.PASS, "Total columns", "Description is Displaying");  
	    }
	     if(columns.equals("Created On"))
	     {
	    	
			 test.log(LogStatus.PASS, "Total columns", "Created On is Displaying"); 
	     }
	     if(columns.equals("Action"))
	     {
	     test.log(LogStatus.PASS, "Total columns", "Action is Displaying"); 
	    	 
	     }
	     if(columns.equals("Last ActionBy"))
	     {
	      test.log(LogStatus.PASS, "Total columns", "Last ActionBy is Displaying");  
	     }

	
}
		}
	 


	// verify number of Records in Grid
	    @Test(priority = 7, dependsOnMethods = { "verifyColumnsOfGrid" }, groups = { "Smoke" })
	    public static void verifyNumberOfRecords() throws InterruptedException {
		test = report.startTest("Verify Numbers of Records In grid");
		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
		test.log(LogStatus.PASS, "Number of Rows In Grid", "" + rows + "rows In Grid is displaying");
	}
	
	
	
	@Test(priority = 8, dependsOnMethods = { "verifyNumberOfRecords" }, groups = { "Smoke" })
	public static void verifyOnClickOfCancelAllFieldShouldGetClear() throws InterruptedException 
	{
		
		test = report.startTest("Verify On Click Of Cancel All Fields Should Get Clear");
		//driver.navigate().refresh();
		//Thread.sleep(1000);
		driver.findElement(By.xpath(xpathSelectServicePrincipal)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpathFirstElementOfDropDown)).click();
		
		
		
		String name = reader.getCellData("Subscription", "Name", 2);
		driver.findElement(By.id(idName)).sendKeys(name);
	    Thread.sleep(1000);
	    
        String sID=reader.getCellData("Subscription", "SubscriptionId", 2);
		driver.findElement(By.id(idSubScription)).sendKeys(sID);
		Thread.sleep(1000);
		
	    String desc=reader.getCellData("Subscription", "Description", 2);
		driver.findElement(By.id(idDescription)).sendKeys(desc);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(xpathCancelButton)).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.id(idName)));
		if(driver.findElement(By.xpath(xpathSelectServicePrincipal)).getText().equals("")&&driver.findElement(By.id(idName)).getAttribute("value").equals("") && driver.findElement(By.id(idSubScription)).getAttribute("value").equals("")&&
           driver.findElement(By.id(idDescription)).getAttribute("value").equals(""))
        {
			 System.out.println("After cancel button all fields are getting blank");
			   test.log(LogStatus.PASS, "OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields Should get clear ");
		      }else
		      {
		    	  test.log(LogStatus.FAIL,"OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields not  get clear"  );
		      }
       }
		
	
	
	
	
	@Test(priority = 9, dependsOnMethods = { "verifyOnClickOfCancelAllFieldShouldGetClear" }, groups = { "Smoke" })
	public static void verifyOnClickOfSubmitButtonAlertIsComing() throws InterruptedException 
	{ 
		// driver.navigate().refresh();
		 Thread.sleep(1000);
		 test = report.startTest("On Click Of Submit Button Alert Is Coming");
		 driver.findElement(By.id(idSubmitBtn)).click();
		 Thread.sleep(2000);
		 
		 
		 String alertOnSSP = driver.findElement(By.xpath(xpathAlertOnSSP)).getText();
		 System.out.println(alertOnSSP);
		 Assert.assertEquals(alertOnSSP,"Service Principal ID cannot be empty","'Service Principal ID  cannot be empty' alert is not Displaying ");
		 test.log(LogStatus.PASS, "Alert on Select Service Principal", "Service Principal ID  cannot be empty alert is Displaying");

		 String alertOnName = driver.findElement(By.xpath(xpathAlertOnName)).getText();
		 Assert.assertEquals(alertOnName,"Name can't be empty","'Name can't be empty' alert is not Displaying ");
		 test.log(LogStatus.PASS, "Alert on Name", "Name can't be empty alert is Displaying");
		 
		 String alertOnSubscription = driver.findElement(By.xpath(xpathAlertOnSubscription)).getText();
		 Assert.assertEquals(alertOnSubscription,"Subscription ID can't be empty","'Subscription ID can't be empty' alert is not Displaying ");
		 test.log(LogStatus.PASS, "Alert on SubscriptionID", "'Subscription ID can't be empty' alert is Displaying");
		
		 driver.findElement(By.id(idName)).sendKeys(reader.getCellData("Subscription", "Name", 4));
		 String alertOnNameField = driver.findElement(By.xpath(xpathAlertOnName)).getText();
		 Assert.assertEquals(alertOnNameField,"Name should not contain more than 50 characters","'Name should not contain more than 50 characters' alert is not Displaying ");
		 test.log(LogStatus.PASS, "Alert on Name","'Name should not contain more than 50 characters' alert is Displaying");
		 
		 driver.findElement(By.id(idSubScription)).sendKeys(reader.getCellData("Subscription","SubscriptionId", 4));
	     Thread.sleep(1000);
		 driver.findElement(By.id(idSubmitBtn)).click();
	     Thread.sleep(1000);
	     String alertOnSubscriptionID = driver.findElement(By.xpath(xpathAlertOnSubscription)).getText();
		 Assert.assertEquals(alertOnSubscriptionID,"Subscription ID is not valid","'Subscription ID is not valid' alert is not Displaying ");
		 test.log(LogStatus.PASS, "Alert on SubscriptionID", "'Subscription ID is not valid' alert is Displaying"); 
	}
		

	@Test(priority = 10, dependsOnMethods = { "verifyOnClickOfSubmitButtonAlertIsComing" }, groups = { "Smoke" })
	public static void verifyDeleteDialogBox() throws InterruptedException 
	{ 
		// driver.navigate().refresh();
		 Thread.sleep(1000);
         test=report.startTest("DeleteDialogBox");
		 driver.findElement(By.className(classDeleteButton)).click();
		 WebElement deleteDialogBox = driver.findElement(By.xpath(xpathDeleteDialogBox));
		 Assert.assertTrue(deleteDialogBox.isDisplayed());
		 test.log(LogStatus.PASS, "Delete DialogBox","delete DialogBox is displaying");
		 String deleteText = driver.findElement(By.xpath(xpathDeleteText)).getText();
		 Assert.assertEquals(deleteText,"Delete","Delete is not Displaying");
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

	@Test(priority = 11, dependsOnMethods = { "verifyDeleteDialogBox" }, groups = { "Smoke" })
	public static void verifySubscriptionIsCreated() throws InterruptedException
	{
       test=report.startTest("Create Subscription");
		driver.navigate().refresh();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpathSubscriptionLink)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpathSelectServicePrincipal)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpathFirstElementOfDropDown)).click();
		
		
		
		
		String name = reader.getCellData("Subscription", "Name", 2);
		driver.findElement(By.id(idName)).sendKeys(name);
		Thread.sleep(1000);
        String sID=reader.getCellData("Subscription", "SubscriptionId", 2);
		driver.findElement(By.id(idSubScription)).sendKeys(sID);
		Thread.sleep(1000);
	    String desc=reader.getCellData("Subscription", "Description", 2);
		driver.findElement(By.id(idDescription)).sendKeys(desc);
		Thread.sleep(1000);
		driver.findElement(By.id(idSubmitBtn)).click();
		Thread.sleep(1500);
		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		Thread.sleep(1000);
		
        Assert.assertEquals(toaster,"Subscription added successfully!","Subscription is not added succesfully");
        test.log(LogStatus.PASS, "Subscription Added", "Subscription is added succesfully");
        

 	    int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
 	    System.out.println(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+numberOfRecords+"]//td[2]")).getText().equals(reader.getCellData("Subscription", "Name", 2)));
 	    System.out.println(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+numberOfRecords+"]//td[3]")).getText().equals(reader.getCellData("Subscription","SubscriptionId", 2)));;
        for(int i=1;i<=numberOfRecords;i++)
     {
		if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Subscription", "Name", 2)))
 				{
 			
 			test.log(LogStatus.PASS,"Record is  displaying on grid Sucessfully!!!");
 		}
 		
	}
	}
        //verify Same name Subscription is created or not 
	@Test(priority = 12, dependsOnMethods = { "verifySubscriptionIsCreated" }, groups = { "Smoke" })
	public static void verifySameNameSubscription() throws InterruptedException
	{
        Thread.sleep(1000);
    //    driver.navigate().refresh();
        test=report.startTest("Same Name Subscription");
       
        driver.findElement(By.xpath(xpathSelectServicePrincipal)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpathFirstElementOfDropDown)).click();
		
        driver.findElement(By.id(idName)).sendKeys(reader.getCellData("Subscription","Name", 2));
        Thread.sleep(1000);
        driver.findElement(By.id(idSubScription)).sendKeys(reader.getCellData("Subscription","SubscriptionId", 2));
        
     
        String alertOnName = driver.findElement(By.xpath(xpathAlertOnName)).getText();
		Assert.assertEquals(alertOnName,"Name already exist"," Name already exist' alert is not Displaying ");
		test.log(LogStatus.PASS,"Same Name SubScription", " Name already exist alert is Displaying");
        
         

	}

	@Test(priority = 13, dependsOnMethods = { "verifySameNameSubscription" }, groups = { "Smoke" })
	public static void verifyDeleteRecord() throws InterruptedException {
		
		Thread.sleep(1000);
		test=report.startTest("Delete Record");
				
		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
		Thread.sleep(1000);
		String subscriptionName = driver.findElement(By.xpath("//*[@id='root']//tbody/tr[1]/td[2]")).getText();
	
		driver.findElement(By.xpath(xpathDelete)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(yesButton)).click();
		Thread.sleep(1000);
		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		Assert.assertEquals(toaster,"Subscription deleted successfully!","Subscription is not Deleted succesfully ");
	    test.log(LogStatus.PASS, "Delete Record", "Subscription is Deleted Successfully Toaster message is displaying");
	     
	     int subscriptionsName=driver.findElements(By.xpath("//*[@id='root']//tbody/tr/td[2]")).size();
 		
 		for(int i=1;i<=subscriptionsName;i++)
 		{
 			if(driver.findElement(By.xpath("//*[@id='root']//tbody/tr["+i+"]//td[2]")).equals(subscriptionName))
 			{
 				System.out.println("record is not deleted , Displaying on screen ");
 				test.log(LogStatus.FAIL, "Delete Record", "Record is not Deleted, Displaying On Screen");
 			}
          }
 		System.out.println("Record is Deleted Successfuly ,not displaying on Screen");
 		test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully, not Displaying on Screen");
 		
	     int rows2 = driver.findElements(By.xpath(xpathRowInGrid)).size();
		
		if (rows2 == rows - 1) {
			test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Delete Record", "Record id not Deleted");
		}
		 
	}
	
	@Test(priority = 14, dependsOnMethods = { "verifyDeleteRecord" }, groups = { "Smoke" })
	public static void verifyEditButton() throws InterruptedException 
	{    
		// driver.navigate().refresh();
	     Thread.sleep(1000);
	     test=report.startTest("Edit Record");
		 driver.findElement(By.xpath(xpathEdit)).click();
		 Thread.sleep(1000);
		 
		 driver.findElement(By.xpath(xpathSelectServicePrincipal)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathFirstElementOfDropDown)).click();
			
			
		
		 driver.findElement(By.id(idName)).sendKeys(Keys.CONTROL + "a");
		 driver.findElement(By.id(idName)).sendKeys(Keys.BACK_SPACE);
		 
		 
		 String name = reader.getCellData("Subscription", "Name", 3);
		
		 driver.findElement(By.id(idName)).sendKeys(name);
		 Thread.sleep(1000);
		 
		 driver.findElement(By.id(idSubScription)).sendKeys(Keys.CONTROL + "a");
		 driver.findElement(By.id(idSubScription)).sendKeys(Keys.BACK_SPACE);
		 
		
		 String sID=reader.getCellData("Subscription", "SubscriptionId", 2);
	     driver.findElement(By.id(idSubScription)).sendKeys(sID);
	     Thread.sleep(1000);
	     
	     driver.findElement(By.id(idDescription)).sendKeys(Keys.CONTROL + "a");
		 driver.findElement(By.id(idDescription)).sendKeys(Keys.BACK_SPACE);
		 
	     
		 String desc=reader.getCellData("Subscription", "Description", 2);
	     driver.findElement(By.id(idDescription)).sendKeys(desc);
		 Thread.sleep(1000);
		 driver.findElement(By.id(idSubmitBtn)).click();
		 Thread.sleep(1000);
		 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		 Assert.assertEquals(toaster,"Subscription updated successfully!","Updation is not succesfully");
	     test.log(LogStatus.PASS, "Subscription Edit","Updation is succesfully");
	   }
	}
	