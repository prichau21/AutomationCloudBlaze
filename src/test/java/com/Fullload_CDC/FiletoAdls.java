package com.Fullload_CDC;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IMonitoring;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class FiletoAdls extends ReuseFuntions implements IOnBoarding ,IMonitoring
{
static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");

  @Test(priority=1,groups= {"Smoke"})
   public static void verifySourceFile() throws InterruptedException
   {
	   
	 
    test = report.startTest("Verify Add File Source");
    driver.navigate().refresh();
    Thread.sleep(2000);
    driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
    driver.findElement(By.id("select-source")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathSource)).click();
    Thread.sleep(1500);
    driver.findElement(By.id("select-dataSourceTypeId")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath(xpathFile)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("select-subscriptionId")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
    //driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='Dev']")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","Name", 10));
    Thread.sleep(1000);
    driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","DescriptionSource", 2));
    Thread.sleep(1000);
    driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service", "UserName", 2));
    Thread.sleep(1000);
    driver.findElement(By.id("select-75")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathIRFroFile)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("Host")).sendKeys(reader.getCellData("Storage&Service","HostName", 3));
    Thread.sleep(1000);
 
    driver.findElement(By.id("select-79")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='menu-79']/div//li[text()='"+reader.getCellData("Storage&Service", "IntegrationRunTime", 2)+"']")).click();
    Thread.sleep(3000);
    //driver.findElement(By.id("ResourceGroupName")).sendKeys(reader.getCellData("Storage&Service","ResourceGroupName", 2));
     driver.findElement(By.xpath(xpathSubmitclick)).click();
     Thread.sleep(3000);
     
     driver.findElement(By.xpath(xpathYesBtnn)).click();
     
     WebDriverWait wait = new WebDriverWait(driver,60);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
     // click on the compose button as soon as the "compose" button is visible
     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
     Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
     test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
     Thread.sleep(2000);
} 
    
 @Test(priority =  2,dependsOnMethods = { "verifySourceFile" },groups = { "Smoke" })
    public static void verifyAddDestination() throws InterruptedException 
    {	  
	 
	 verifyDestinationADLS(10);
	       
    }
   
           @Test(priority = 3,dependsOnMethods = { "verifyAddDestination" },groups = { "Smoke" })
           public static void verifyAddDataFlow() throws InterruptedException, AWTException 
               {    
	             test = report.startTest("Verify Add DataFlow");
				 Thread.sleep(2000);
				 driver.findElement(By.xpath(xpathDataFlowPageLink)).click();
				 Thread.sleep(2000);
				 driver.findElement(By.xpath(xpathAddButton)).click();
				 Thread.sleep(3000);
                 driver.findElement(By.xpath(xpathFileToAdls)).click();
                 Thread.sleep(2500);
				 driver.findElement(By.id("name")).sendKeys(reader.getCellData("DataFlow","Name", 10));
	     		 Thread.sleep(2500);
	     	     driver.findElement(By.id("description")).sendKeys(reader.getCellData("DataFlow", "Description", 10));
				 Thread.sleep(2500);
				 driver.findElement(By.className("css-1hwfws3")).click();
				 Thread.sleep(4000);
				 driver.findElement(By.xpath("/html/body/div//form//div[text()='"+reader.getCellData("Storage&Service","Name", 10)+"']")).click();
				 Thread.sleep(2500);
				 driver.findElement(By.xpath(xpathAdlsDest)).click();
				 Thread.sleep(2500);
				 driver.findElement(By.xpath("//html/body/div//form//div[text()='"+reader.getCellData("Storage&Service","NameD", 10)+"']")).click();
				 Thread.sleep(1000);
                 driver.findElement(By.xpath(xpathselectFolder)).click();	 
				 
	             Thread.sleep(1000);
	    
	        	 driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[4]/div/div[1]/table/thead/tr/th[1]/span/span[1]/input")).click();
	             driver.findElement(By.xpath("(//*[@id='1'])[5]")).click();

	        	 Thread.sleep(2000);
	        	 
	        	 driver.findElement(By.xpath("(/html/body//button[text()='Save'])[3]")).click();
	
			  	 Thread.sleep(1000);
			  	 driver.findElement(By.xpath(xpathSaveButton)).click();
			     WebDriverWait wait = new WebDriverWait(driver,60);
			  	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
	        	
	             String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();

	    		
		    	 Assert.assertEquals(toaster,"Flow added successfully!","Record is not added succesfully ");	    	
		    	 test.log(LogStatus.PASS, "add Flow", "Flow is added Successfully Toaster message is displaying");
		    	 driver.navigate().refresh();
		    	 Thread.sleep(1000);
		    	 driver.findElement(By.xpath("//*[@id='root']/div//table//tbody//tr[1]//td[7]//button[@title='Publish flow']")).click();//publish Flow
		         Thread.sleep(4000);
		    	 driver.findElement(By.xpath(xpathYesBtn)).click();
		    	// WebDriverWait wait = new WebDriverWait(driver,60);
		    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
		    	 String toaster2 = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		         System.out.println(toaster2);
		         Assert.assertEquals(toaster2,"data flow published successfully","data flow is not published");
		         test.log(LogStatus.PASS, "Publish","data flow published successfully");
		        } 
          
           
               @Test(priority = 30, dependsOnMethods = { "verifyAddDataFlow" },groups = { "Smoke" })
               public static void verifyScheduledFlow() throws InterruptedException 
               { 
            	   verifyScheduledFlowR(10 ,2);
   		  
   			}
   			
          @Test(priority = 31, dependsOnMethods = { "verifyScheduledFlow" },groups = { "Smoke" })
           public static void verifyFlowOnMontioringScreen() throws InterruptedException  
           {    
        	  
        	  verifyFlowMontioringScreen(10);  
        	  
           }
}
        	    
      


           


