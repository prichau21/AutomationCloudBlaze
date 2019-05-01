package com.CloudBlaze.Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.CloudBlaze.PageObjects.ILoginLogout;
import com.relevantcodes.extentreports.LogStatus;


public class LoginLogout extends BaseClass implements ILoginLogout
{
	static Logger log = Logger.getLogger("devpinoyLogger");
	
	//To Login into Application
	public static void ExecuteLogin(WebDriver driver) throws Exception 
	{
		try {
			String UserName=CloudBlazeConstants.Username;
			String UserPwd=CloudBlazeConstants.Password;
			
			//test.log(LogStatus.INFO, "Login with User name",UserName);
			 
			driver.findElement(By.xpath(txtbx_UserName)).sendKeys(UserName);
			driver.findElement(By.xpath(txtbx_Password)).sendKeys(UserPwd);
			driver.findElement(By.xpath(btn_LogIn)).click();
			//test.log(LogStatus.INFO, "User has clicked on Login button");
		} catch (Exception e) {
			log.error("Some exception happened",e);
		//	test.log(LogStatus.ERROR, "Some exception happened",e);
			e.printStackTrace();
		}
	}
	
	//Method to Logout from Application
	public static void ExecuteLogout(WebDriver driver) throws Exception
	{
		try {
			test=report.startTest("Logout from Application");
			//driver.findElement(By.xpath(userMenu)).click();
			driver.findElement(By.xpath(logoutLnk)).click();
			test.log(LogStatus.INFO, "User has clicked on Logout button");
		} catch (Exception e) {
			log.error("Some exception happened",e);
			test.log(LogStatus.FAIL, "Some exception happened",e);
			e.printStackTrace();
		}
	}
	
}


