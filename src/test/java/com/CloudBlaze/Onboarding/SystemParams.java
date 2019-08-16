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

    public class SystemParams extends BaseClass implements IOnBoarding {
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
	
    
    
    
    @Test(priority=2,groups= { "Smoke" })
	public void verifySystemParameterPage() throws InterruptedException
	{
		
		Thread.sleep(1000);
		test = report.startTest("Click on System Parameter Page Link");
		try {
			  driver.findElement(By.xpath(xpathSystemParamsLink)).click();
			} 
		catch (ElementNotVisibleException e)
		    {
		e.printStackTrace();
		     }
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User has successfully clicked on System Paramater Page Link");
	}
	
	
	    //Verify When user Click on Service Principal Page ,it will Display 
		@Test(priority = 3, dependsOnMethods = { "verifySystemParameterPage" }, groups = { "Smoke" })
		public static void verifyUrlOfSystemParameter() throws InterruptedException 
		{
            driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Url of System Parameter  Page");
	        
			// verify the Url of the page
			if(driver.getCurrentUrl().equals(xpathUrlOfSystemParams))
			{
			Assert.assertEquals(xpathUrlOfSystemParams, driver.getCurrentUrl(),"URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
			}
			else 
			{
		    test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
			}
			
			 if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
			 {    test.log(LogStatus.FAIL, "System Parameter Screen not Displaying");
				 System.out.println("System Parameter  page Screen is not Displaying");
			 }
			 
			 else
			 {
				 test.log(LogStatus.PASS,"System Parameter  page Screen is  Displaying");
				 System.out.println("System Parameter page Screen is Displaying ");
			 }
			 }
	@Test(priority =4, dependsOnMethods = { "verifyUrlOfSystemParameter" },groups = { "Smoke" })
	public static void verifySystemParamsComponents() throws InterruptedException 
	{
		test = report.startTest("Verify Components of System Parameter Page");
		String title = driver.findElement(By.xpath(xpathTitleOfPage)).getText();
		Assert.assertEquals(title, "System Parameter", "System Parameter Title is not Displaying");
		test.log(LogStatus.PASS, "Title", "System Parameter Title is Displaying");
        
	    //verify Tenant ID
		WebElement tenantId = driver.findElement(By.name("tenantID"));
		Assert.assertTrue(tenantId.isDisplayed());
		test.log(LogStatus.PASS, "tenant Id Field", "tenant Id Field is displaying");
		
		
		//verify Primary email
		WebElement primaryEmail = driver.findElement(By.name("PrimaryEmails"));
		Assert.assertTrue(primaryEmail.isDisplayed());
		test.log(LogStatus.PASS, "primary Email Field", "primary Email Field is displaying");
		
		
		
		//verify Secondary Email 
		WebElement secondaryEmail = driver.findElement(By.name("SecondaryEmails"));
		Assert.assertTrue(secondaryEmail.isDisplayed());
		test.log(LogStatus.PASS, "secondary Email Field", "secondary Email Field is displaying");
		
		
	
		//verify Submit button
		boolean submitButton = driver.findElement(By.xpath(xpathSubmitButton)).isEnabled();
		Assert.assertEquals(submitButton,true, "submit Button is not Displaying or Disabled");
		test.log(LogStatus.PASS, "submit Button", "submit Button is Displaying and Enabled");
        
		String submitText = driver.findElement(By.xpath(xpathSubmitButton)).getText();
		Assert.assertEquals(submitText, "Update", "Submit Text is not Displaying");
		test.log(LogStatus.PASS, "Submit Text", "Submit Text is Displaying");
		
		//Cancel Button
		boolean cancel = driver.findElement(By.xpath(xpathCancel_Button)).isEnabled();
		Assert.assertEquals(cancel,true, "cancel Button is not Displaying or Disabled");
		test.log(LogStatus.PASS, "cancel Button", "cancel Button is Displaying and Enabled");
		
		String cancelText = driver.findElement(By.xpath(xpathCancel_Button)).getText();
		Assert.assertEquals(cancelText, "Cancel", "Cancel Text is not Displaying");
		test.log(LogStatus.PASS, "Cancel Text", "Cancel Text is Displaying");
		
		}
/*	
	@Test(priority =5, dependsOnMethods = { "verifySystemParamsComponents" },groups = { "Smoke" })
	public static void verifyAddSystemParameters() throws InterruptedException 
		
	{

		test = report.startTest("Verify Add System Parameters");
		
		 driver.findElement(By.name("tenantID")).sendKeys(reader.getCellData("SystemParam","TenantId",2));
		 Thread.sleep(1000);		
		 driver.findElement(By.name("PrimaryEmails")).sendKeys(reader.getCellData("SystemParam","PrimaryEmail",2));
		 Thread.sleep(1000);	
		 driver.findElement(By.name("SecondaryEmails")).sendKeys(reader.getCellData("SystemParam","SecondaryEmail",2));
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButton)).click();
		 Thread.sleep(1500);

	     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		
	     Assert.assertEquals(toaster,"System Parameter added successfully!","Record is not added succesfully ");	    	
    	 test.log(LogStatus.PASS, "Added System Parameter", "Record is added Successfully Toaster message is displaying");
    
	}
	
	
	

	@Test(priority =6, dependsOnMethods = { "verifySystemParamsComponents" },groups = { "Smoke" })
	public static void verifyUpdateSystemParameters() throws InterruptedException 
		
	{

		test = report.startTest("Verify Update System Parameters");
		 driver.findElement(By.name("tenantID")).sendKeys(Keys.CONTROL+"a");
		 driver.findElement(By.name("tenantID")).sendKeys(Keys.BACK_SPACE);
		 driver.findElement(By.name("tenantID")).sendKeys(reader.getCellData("SystemParam","TenantId",3));
		 Thread.sleep(1000);	
		 driver.findElement(By.name("PrimaryEmails")).sendKeys(Keys.CONTROL+"a");
		 driver.findElement(By.name("PrimaryEmails")).sendKeys(Keys.BACK_SPACE);
		 driver.findElement(By.name("PrimaryEmails")).sendKeys(reader.getCellData("SystemParam","PrimaryEmail",3));
		 Thread.sleep(1000);	
		 driver.findElement(By.name("SecondaryEmails")).sendKeys(Keys.CONTROL+"a");
		 driver.findElement(By.name("SecondaryEmails")).sendKeys(Keys.BACK_SPACE);
		 driver.findElement(By.name("SecondaryEmails")).sendKeys(reader.getCellData("SystemParam","SecondaryEmail",3));
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButton)).click();
		 Thread.sleep(1500);

	     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		
         Assert.assertEquals(toaster,"System Parameter updated successfully!","Record is not updated succesfully ");	    	
    	 test.log(LogStatus.PASS, "Update System Parameter", "Record is updated Successfully Toaster message is displaying");
    	 
	}
	
	
	*/
	@Test(priority =5, dependsOnMethods = { "verifySystemParamsComponents" },groups = { "Smoke" })
	public static void verifyAlertOnSystemParameters() throws InterruptedException 
	{
		 test = report.startTest("Verify Alert On System Parameters");
		 driver.findElement(By.name("tenantID")).sendKeys(Keys.CONTROL+"a");
		 driver.findElement(By.name("tenantID")).sendKeys(Keys.BACK_SPACE);
		 Thread.sleep(1000);
		 String alertOnTenantID = driver.findElement(By.xpath(xpathAlertOnTenantID)).getText();
		 Assert.assertEquals(alertOnTenantID,"tenantID cannot empty","Alert on Tenant id is Not Displaying");
		 test.log(LogStatus.PASS,"Alert","Alert on Tenant id is Displaying");
		 driver.findElement(By.name("tenantID")).sendKeys("sjdhajsgdajds");
		 String invalidTenantId = driver.findElement(By.xpath(xpathInvalidTenantId)).getText();
		 Assert.assertEquals(invalidTenantId,"tenantID is not valid","User is able to enter Invalid tenant ID");
		 test.log(LogStatus.PASS,"alert","User is not able to Enter invalid Id ,Alert is Coming");
		 
		 driver.findElement(By.name("PrimaryEmails")).sendKeys(Keys.CONTROL+"a");
		 driver.findElement(By.name("PrimaryEmails")).sendKeys(Keys.BACK_SPACE);
		 Thread.sleep(1000);
		 String alertOnPrimaryMail = driver.findElement(By.id("1-helper-text")).getText();
		 Assert.assertEquals(alertOnPrimaryMail,"PrimaryEmails cannot empty","Alert on PrimaryEmails is Not Displaying");
		 test.log(LogStatus.PASS,"Alert","Alert on PrimaryEmails is Displaying");
		 driver.findElement(By.name("PrimaryEmails")).sendKeys("dhsjdhjsdgfdsf");
		 
         String invalidPrimMail = driver.findElement(By.id("1-helper-text")).getText();
         Assert.assertEquals(invalidPrimMail,"PrimaryEmails is not valid", "User is able to add invalid Id");
         test.log(LogStatus.PASS,"Alert","User is Not able to add invalid Email , Alert is Displaying");
		 
		 
		 driver.findElement(By.name("SecondaryEmails")).sendKeys(Keys.CONTROL+"a");
		 driver.findElement(By.name("SecondaryEmails")).sendKeys(Keys.BACK_SPACE);
		 Thread.sleep(1000);
	     driver.findElement(By.name("SecondaryEmails")).sendKeys("abcdefghijklmn");
	     Thread.sleep(1000);
	     String alertonSecMail = driver.findElement(By.id("2-helper-text")).getText();
	     Assert.assertEquals(alertonSecMail,"SecondaryEmails is not valid","Alert is not Displaying under Sec Email Field");
	     test.log(LogStatus.PASS,"alert","Alert is Displaying under Sec Email Field");
	     
	}
		
	
	
}

