package com.Fullload_CDC;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IMonitoring;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class MysqlToAdlsDM extends ReuseFuntions implements IOnBoarding , IMonitoring{
	
	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
    @Test(priority=1, groups = { "Smoke" })
	public static void verifySourceMySql() throws InterruptedException 
  {    
     
    	verifySourceMysql(17);
 

 }
    @Test(priority = 2, dependsOnMethods = { "verifySourceMySql" },groups = { "Smoke" })
    public static void verifyAddDestination() throws InterruptedException 
    {	 verifyDestinationADLS(17);
	        }
	        
         @Test(priority = 3, dependsOnMethods = { "verifyAddDestination" },groups = { "Smoke" })
        public static void verifyAddDataFlow() throws InterruptedException, AWTException 
          {    
          test = report.startTest("Verify Add DataFlow for MYSQl to adls Full load");
		 	 Thread.sleep(3000);
			 driver.findElement(By.xpath(xpathDataFlowPageLink)).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath(xpathAddButton)).click();
			 Thread.sleep(3000);
             driver.findElement(By.xpath(xpathMysqltoadlsDM)).click();
             Thread.sleep(2500);
			 driver.findElement(By.id("name")).sendKeys(reader.getCellData("DataFlow","Name", 17));
  		     Thread.sleep(2500);
  	
			 driver.findElement(By.id("description")).sendKeys(reader.getCellData("DataFlow", "Description", 11));
			 Thread.sleep(2500);
			
			 driver.findElement(By.className("css-1hwfws3")).click();
			 Thread.sleep(4000);
			 driver.findElement(By.xpath("/html/body/div//form//div[text()='"+reader.getCellData("Storage&Service","Name", 17)+"']")).click();
			 Thread.sleep(2500);
			
			 driver.findElement(By.xpath(xpathAdlsDest)).click();
			 Thread.sleep(1500);
			 driver.findElement(By.xpath("//html/body/div//form//div[text()='"+reader.getCellData("Storage&Service","NameD", 17)+"']")).click();
			 Thread.sleep(1000);
		
			 driver.findElement(By.xpath(xpathSelectTableLink)).click();	 
			 String tableName = driver.findElement(By.xpath(xpathTableName)).getText();
			 Assert.assertEquals(tableName,"Table Name", "Table Name Column is Not displaying");
			 test.log(LogStatus.PASS,"Table Columns","Table Column is displaying");
			 
			 String CDC = driver.findElement(By.xpath(xpathCDC)).getText();
			 Assert.assertEquals(CDC,"CDC","CDC Name Column is Not displaying");
			 test.log(LogStatus.PASS,"Table Columns","CDC Column is displaying");
			 
			 
			 String whereClause= driver.findElement(By.xpath(xpathWhereClause)).getText();
			 Assert.assertEquals(whereClause,"Where clause", "Where clause Column is Not displaying");
			 test.log(LogStatus.PASS,"Table Columns","Where clause Column is displaying");
             Thread.sleep(1000);
         	 
		     driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[4]/div/div[1]/table/thead/tr/th[1]/span/span[1]/input")).click();
             driver.findElement(By.xpath("(//*[@id='1'])[5]")).click();
		     Thread.sleep(2000);
			 driver.findElement(By.xpath("(/html/body//button[text()='Save'])[3]")).click();
			 

		  	 Thread.sleep(1000);
		  	 driver.findElement(By.xpath(xpathSaveButton)).click();
		  	 Thread.sleep(1600);
		     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
 		
	    	 Assert.assertEquals(toaster,"Flow added successfully!","Record is not added succesfully ");	    	
	    	 test.log(LogStatus.PASS, "add Flow", "Flow is added Successfully Toaster message is displaying");
	    	 driver.navigate().refresh();
	    	 driver.findElement(By.xpath("//*[@id='root']/div//div[4]/table/tbody/tr[1]/td[7]/button[@title='Publish flow']")).click();//publish Flow
	    	 // driver.findElement(By.xpath("//*[@id='root']//main//div//table//tbody/tr[1]/td[6]/button")).click();
	    	 Thread.sleep(2000);
	    	 driver.findElement(By.xpath(xpathYesBtn)).click();
	    	 WebDriverWait wait = new WebDriverWait(driver,60);
	    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
	    	 String toaster2 = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	    	 System.out.println(toaster2);
	         Assert.assertEquals(toaster2,"data flow published successfully","data flow is not published");
	         test.log(LogStatus.PASS, "Publish","data flow published successfully");
	      } 
           
             @Test(priority = 4, dependsOnMethods = { "verifyAddDataFlow" },groups = { "Smoke" })
             public static void verifyScheduledFlow() throws InterruptedException 
             {   
 	   
            	 verifyScheduledFlowR(17 ,2);
	  
	  
		}
		
   @Test(priority = 5, dependsOnMethods = { "verifyScheduledFlow" },groups = { "Smoke" })
    public static void verifyFlowOnMontioringScreen() throws InterruptedException  
    {    

	   verifyFlowMontioringScreen(17);   
	}
	
	
}
