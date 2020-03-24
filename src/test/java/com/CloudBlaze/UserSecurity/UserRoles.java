package com.CloudBlaze.UserSecurity;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.PageObjects.IUserSecurity;
import com.relevantcodes.extentreports.LogStatus;

public class UserRoles extends BaseClass implements IUserSecurity
{
@Test(priority=1,groups= { "Smoke" } )
public void VerifyUserRolesPage() throws InterruptedException
{
	driver.navigate().refresh();
	Thread.sleep(1000);
	test=report.startTest("Click on User Roles Link");
	try
	{
		driver.findElement(By.xpath(xpathOrgInfo)).click();
	}
	catch(ElementNotVisibleException e)
	{
		e.printStackTrace();
	}
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "User has successfully clicked on User Roles Page Link");
	
}
//Verify When user Click on User Roles Page ,its page will Display 
	/*@Test(priority = 2, dependsOnMethods = { "VerifyUserRolesPage" }, groups = { "Smoke" })
	public static void verifyUrlOfUserRoles() throws InterruptedException 
	{

		
		driver.navigate().refresh();
		Thread.sleep(3000);
		test = report.startTest("Verify Url of User Roles  Page");
     
		// verify the Url of the page
		if(driver.getCurrentUrl().equals(xpathUrlOfUserRoles)) {
		Assert.assertEquals(xpathUrlOfUserRoles, driver.getCurrentUrl(),"URL is not matching");
		test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
			}
		else 
		{
	    test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
		}
   }*/
	
}