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

public class Subscription extends BaseClass implements IOnBoarding {

	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");

	@Test(priority = 1, groups = { "Smoke" })
	public void verifySubscriptionPage() throws InterruptedException {
		driver.navigate().refresh();
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
	@Test(priority = 2, dependsOnMethods = { "verifySubscriptionPage" }, groups = { "Smoke" })
	public static void verifyUrlOfSubscription() throws InterruptedException {

		test = report.startTest("Verify Url of Subscription  Page");

		// verify the Url of the page
		if (driver.getCurrentUrl().equals(xpathUrlOfSubscription)) {
			Assert.assertEquals(xpathUrlOfSubscription, driver.getCurrentUrl(), "URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
		} else {
			test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
		}
	}
	// verify BreadCrumbs

	// Verify Components of Subscription Page
	@Test(priority = 4, dependsOnMethods = { "verifyUrlOfSubscription" }, groups = { "Smoke" })
	public static void verifySubscriptionPageComponents() throws InterruptedException {

		test = report.startTest("Verify Components of Subscription  Page");

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

	// verify number of Records in Grid
	@Test(priority = 6, dependsOnMethods = { "verifyGridComponents" }, groups = { "Smoke" })
	public static void verifyNumberOfRecords() throws InterruptedException {
		test = report.startTest("Verify Numbers of Records In grid");
		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
		test.log(LogStatus.PASS, "Number of Rows In Grid", "" + rows + "rows In Grid is displaying");
	}
	
	
	
	@Test(priority = 7, dependsOnMethods = { "verifyNumberOfRecords" }, groups = { "Smoke" })
	public static void verifyOnClickOfCancelAllFieldShouldGetClear() throws InterruptedException 
	{
		
		test = report.startTest("Verify On Click Of Cancel All Fields Should Get Clear");
		driver.navigate().refresh();
		Thread.sleep(1000);
		
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
		if(driver.findElement(By.id(idName)).getAttribute("value").equals("") && driver.findElement(By.id(idSubScription)).getAttribute("value").equals("")&&
           driver.findElement(By.id(idDescription)).getAttribute("value").equals(""))
{
			 System.out.println("After cancel button all fields are getting blank");
			   test.log(LogStatus.PASS, "OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields Should get clear ");
		      }else
		      {
		    	  test.log(LogStatus.FAIL,"OnClickOfCancelAllFieldShouldGetClear","When user click on Cancel button ,all fields not  get clear"  );
		      }
}
		
		
	

	@Test(priority = 8, dependsOnMethods = { "verifyOnClickOfCancelAllFieldShouldGetClear" }, groups = { "Smoke" })
	public static void verifySubscriptionIsCreated() throws InterruptedException
	{
       test=report.startTest("Create Subscription");
		driver.navigate().refresh();
		Thread.sleep(3000);
		//boolean x=false;
		String name = reader.getCellData("Subscription", "Name", 2);
		System.out.println(name);
		driver.findElement(By.id(idName)).sendKeys(name);
		Thread.sleep(1000);
        String sID=reader.getCellData("Subscription", "SubscriptionId", 2);
		driver.findElement(By.id(idSubScription)).sendKeys(sID);
		Thread.sleep(1000);
	    String desc=reader.getCellData("Subscription", "Description", 2);
		driver.findElement(By.id(idDescription)).sendKeys(desc);
		Thread.sleep(1000);
		driver.findElement(By.id(idSubmitBtn)).click();
		Thread.sleep(1000);
		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		System.out.println(toaster);
        Assert.assertEquals(toaster,"Record successfully saved","Subscription is not added succesfully");
        test.log(LogStatus.PASS, "Subscription Added", "Subscription is added succesfully");
//		WebElement table = driver.findElement(By.xpath(xpathRowInGrid));
//		List<WebElement> list = table.findElements(By.xpath(xpathRowInGrid));
         
		/*System.out.println("Rows " + list.size());
		Thread.sleep(1000);
		for (int i = 1; i <= list.size(); i++) {
			if (driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr[" + i + "]//td[2]")).getText()
					.equals(name) && driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr[" + i + "]//td[3]")).getText()
							.equals(sID) && driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr[" + i + "]//td[4]")).getText().equals(desc))
			{
				test.log(LogStatus.PASS, "Add Record", "Record is added Sucessfully");
				System.out.println("record added");
				x=true;
			}
		}
		
		if(x!=true) {
			test.log(LogStatus.FAIL, "Add Record", "Record is not added Sucessfully");
			System.out.println(desc);
			System.out.println(sID);
			System.out.println("record has not been added");
		}*/
	}

	@Test(priority = 9, dependsOnMethods = { "verifySubscriptionIsCreated" }, groups = { "Smoke" })
	public static void verifyDeleteRecord() throws InterruptedException {
		
		Thread.sleep(1000);
		test=report.startTest("Delete Record");
				
		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
		Thread.sleep(1000);
	
		driver.findElement(By.xpath(xpathDelete)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(yesButton)).click();
		Thread.sleep(1000);
		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		 Assert.assertEquals(toaster,"Record Deleted Successfully","Record is not Deleted succesfully ");
	     test.log(LogStatus.PASS, "Delete Record", "Record is Deleted Successfully Toaster message is displaying");
		int rows2 = driver.findElements(By.xpath(xpathRowInGrid)).size();
		
		if (rows2 == rows - 1) {
			test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully");
		} else {
			test.log(LogStatus.FAIL, "Delete Record", "Record id not Deleted");
		}
		 
	}
	
	@Test(priority = 10, dependsOnMethods = { "verifyDeleteRecord" }, groups = { "Smoke" })
	public static void verifyEditButton() throws InterruptedException 
	{    
		 driver.navigate().refresh();
	     Thread.sleep(1000);
	     test=report.startTest("Edit Record");
		 driver.findElement(By.xpath(xpathEdit)).click();
		 driver.findElement(By.id(idName)).clear();
		 Thread.sleep(1000);
		 driver.findElement(By.id(idSubScription)).clear();
		 Thread.sleep(1000);
		 driver.findElement(By.id(idDescription)).clear();
	     Thread.sleep(1000);
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
		 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		 Assert.assertEquals(toaster,"Record Updated successfully","updation is not succesfully");
	     test.log(LogStatus.PASS, "Subscription Edit", "updation issuccesfully");
	   }
       }