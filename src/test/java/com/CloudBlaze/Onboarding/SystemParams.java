package com.CloudBlaze.Onboarding;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class SystemParams extends BaseClass implements IOnBoarding
{
@Test(priority=1,groups= { "Smoke" })
public void verifySystemParamsPage() throws InterruptedException
{
	driver.navigate().refresh();
	Thread.sleep(1000);
	test = report.startTest("Click on System Params Link");

	try {
		driver.findElement(By.xpath(xpathSystemParamsLink)).click();

	} 
	catch (ElementNotVisibleException e)
	{
	e.printStackTrace();
	}
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "User has successfully clicked on System Params Page Link");
}
//Verify When user Click on System ParamsPage ,its page will Display 
	@Test(priority = 2, dependsOnMethods = { "verifySystemParamsPage" }, groups = { "Smoke" })
	public static void verifyUrlOfSystemParams() throws InterruptedException 
	{

		
		driver.navigate().refresh();
		Thread.sleep(3000);
		test = report.startTest("Verify Url of System Params  Page");
       
		// verify the Url of the page
		if(driver.getCurrentUrl().equals(xpathUrlOfSystemParams)) {
		Assert.assertEquals(xpathUrlOfSystemParams, driver.getCurrentUrl(),"URL is not matching");
		test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
			}
		else 
		{
	    test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
		}
     }
	@Test(priority = 3, dependsOnMethods = { "verifyUrlOfSystemParams" }, groups = { "Smoke" })
	public static void verifySystemParamsComponents() throws InterruptedException 
	{

		String title = driver.findElement(By.xpath(xpathTitleOfPage)).getText();
		Assert.assertEquals(title, "System Parameter", "System Parameter Title is not Displaying");
		test.log(LogStatus.PASS, "Title", "System Parameter Title is Displaying");
        
		//Verify subscription Name Field 
		WebElement subscriptionName = driver.findElement(By.xpath(xpathSubscriptionName));
		Assert.assertTrue(subscriptionName.isDisplayed());
		test.log(LogStatus.PASS, "subscription Name Field", "subscription Name Field is displaying");
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathSubscriptionNameText)).getText(), "Subscription Name", "Subscription Name Placeaholder is not Displaying");
		test.log(LogStatus.PASS,"Subscription Name", "Subscription Name Placeaholder is Displaying");
		
		
		//Verify Service Principal Field
		WebElement servicePrincipal = driver.findElement(By.xpath(xpathServicePrincipal));
		Assert.assertTrue(servicePrincipal.isDisplayed());
		test.log(LogStatus.PASS, "service Principal Field", "service Principal Field is displaying");
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathServicePrincipalText)).getText(),"Service Principal","Service Principal Placeaholder is not Displaying");
		test.log(LogStatus.PASS, "Service Principal","Service Principal Placeaholder is Displaying");
		
		
		//Verify Resource Group Name
		WebElement resourceGroupname = driver.findElement(By.xpath(xpathResourceGroupname));
		Assert.assertTrue(resourceGroupname.isDisplayed());
		test.log(LogStatus.PASS, "service Principal Field", "resource Group name Field is displaying");
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathResourceGroupnameText)).getText() ,"ResourceGroupName","ResourceGroupName Placeaholder is not Displaying");
		test.log(LogStatus.PASS, "ResourceGroupName", "ResourceGroupName Placeaholder is Displaying");
		
		
		
		//verify Tenant ID
		WebElement tenantId = driver.findElement(By.xpath(xpathTenantId));
		Assert.assertTrue(tenantId.isDisplayed());
		test.log(LogStatus.PASS, "tenant Id Field", "tenant Id Field is displaying");
		
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathTenantIdText)).getText(),"TenantID", "TenantID Placeaholder is not Displaying");
		test.log(LogStatus.PASS, "TenantID", "TenantID Placeaholder is Displaying");
		
		//verify Data factory Name
		WebElement dataFactoryName = driver.findElement(By.xpath(xpathDataFactoryName));
		Assert.assertTrue(dataFactoryName.isDisplayed());
		test.log(LogStatus.PASS, "data Factory Name Field", "data Factory Name Field is displaying");
		
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathDataFactoryNameText)).getText(),"DataFactoryName", "DataFactoryName Placeholder is not Displaying");
		test.log(LogStatus.PASS, "DataFactoryName", "DataFactoryName Placeholder is Displaying");
		
		
		//verify KeyVault
		WebElement keyVault = driver.findElement(By.xpath(xpathKeyVault));
		Assert.assertTrue(keyVault.isDisplayed());
		test.log(LogStatus.PASS, "key Vault Field", "key Vault Field is displaying");
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathKeyVaultText)).getText() , "KeyVault", "KeyVault Placeholder is not Displaying");
		test.log(LogStatus.PASS, "KeyVault", "KeyVault Placeholder is Displaying");
		
		//verify Primary email
		WebElement primaryEmail = driver.findElement(By.xpath(xpathPrimaryEmail));
		Assert.assertTrue(primaryEmail.isDisplayed());
		test.log(LogStatus.PASS, "primary Email Field", "primary Email Field is displaying");
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathPrimaryEmailText)).getText(), "PrimaryEmail", "PrimaryEmail Placeholder is not Displaying");
		test.log(LogStatus.PASS, "PrimaryEmail","PrimaryEmail Placeholder is Displaying");
		
		//verify Secondary Email 
		WebElement secondaryEmail = driver.findElement(By.xpath(xpathSecondaryEmail));
		Assert.assertTrue(secondaryEmail.isDisplayed());
		test.log(LogStatus.PASS, "secondary Email Field", "secondary Email Field is displaying");
		
		Assert.assertEquals(driver.findElement(By.xpath(xpathSecondaryEmailText)).getText(),"SecondaryEmail", "SecondaryEmail Placeaholder is not Displaying");
		test.log(LogStatus.PASS, "SecondaryEmail", "SecondaryEmail Placeaholder is Displaying");
	
		
		//verify Submit button
		boolean submitButton = driver.findElement(By.xpath(xpathSubmitButton)).isEnabled();
		Assert.assertEquals(submitButton,true, "submit Button is not Displaying or Disabled");
		test.log(LogStatus.PASS, "submit Button", "submit Button is Displaying and Enabled");
        
		String submitText = driver.findElement(By.xpath(xpathSubmitButton)).getText();
		Assert.assertEquals(submitText, "Submit", "Submit Text is not Displaying");
		test.log(LogStatus.PASS, "Submit Text", "Submit Text is Displaying");
		
		//Cancel Button
		boolean cancel = driver.findElement(By.xpath(xpathCancel_Button)).isEnabled();
		Assert.assertEquals(cancel,true, "cancel Button is not Displaying or Disabled");
		test.log(LogStatus.PASS, "cancel Button", "cancel Button is Displaying and Enabled");
		
		String cancelText = driver.findElement(By.xpath(xpathCancel_Button)).getText();
		Assert.assertEquals(cancelText, "Cancel", "Cancel Text is not Displaying");
		test.log(LogStatus.PASS, "Cancel Text", "Cancel Text is Displaying");
		
		
	}
	@Test(priority = 4, dependsOnMethods = { "verifySystemParamsComponents" }, groups = { "Smoke" })
	public static void verifyGrid() throws InterruptedException 
	{
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
		    	 System.out.println("S.No. is Displaying");
				 test.log(LogStatus.FAIL, "Total columns", "S.No. is Displaying");
				  
		     }
		     if(columns.equals("Subscription Name"))
		     {
		    	 System.out.println("Subscription Name is Displaying");
				 test.log(LogStatus.FAIL, "Total columns", "Subscription Name is Displaying"); 
		     }
		     if(columns.equals("Subscription Id"))
		    {
		    	 System.out.println("Subscription Id is Displaying");
				 test.log(LogStatus.FAIL, "Total columns", "Subscription Id is Displaying");  
		    }
		     if(columns.equals("Description"))
		    {
		    	 System.out.println("Description is Displaying");
				 test.log(LogStatus.FAIL, "Total columns", "Description is Displaying");  
		    }
		     if(columns.equals("Created On"))
		     {
		    	 System.out.println("Created On is Displaying");
				 test.log(LogStatus.FAIL, "Total columns", "Created On is Displaying"); 
		     }
		     if(columns.equals("Action"))
		     {
		     System.out.println("Action is Displaying");
			 test.log(LogStatus.FAIL, "Total columns", "Action is Displaying"); 
		    	 
		     }
		     
		 }

        }
	   @Test(priority = 5, dependsOnMethods = { "verifyGrid" }, groups = { "Smoke" })
	   public static void verifyAnyRecordInGrid() throws InterruptedException 
	
	  {
		WebElement recordInGrid  = driver.findElement(By.xpath(xpathRecordInGrid));
		Assert.assertTrue(recordInGrid.isDisplayed());
		test.log(LogStatus.PASS, "recordInGrid", "record In Grid is/are displaying");
	  }
	 @Test(priority = 6, dependsOnMethods = { "verifyAnyRecordInGrid" }, groups = { "Smoke" })
	 public static void verifyEditFunctionality()
	 {
		driver.findElement(By.xpath(xpathClickEdit)).click();
		
	 }
	
}

