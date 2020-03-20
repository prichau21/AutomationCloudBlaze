
//SQL TO ADLS INGESTION FROM SEVICES TO MONITORING PAGE

package com.Fullload_CDC;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IMonitoring;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.mysql.cj.jdbc.Driver;
import com.relevantcodes.extentreports.LogStatus;
public class FullLoad extends ReuseFuntions implements IOnBoarding ,IMonitoring{
static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");

	
	@Test(priority=21,groups = { "Smoke" })
     public static void verifySystemParams() throws InterruptedException 
   {    
		 test =report.startTest("Verify System Parameter");
		 driver.navigate().refresh();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(xpathSystemParamsLink)).click();
		 Thread.sleep(3000);
		 String tenantId = driver.findElement(By.xpath("//*[@id='0']")).getAttribute("value");
		 System.out.println("TenantID == "+tenantId);
	     if(tenantId.isEmpty())
	   {
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
	  else
	   {
		 System.out.println("Fileds are not Blankin System Parameter Pge");
		 test.log(LogStatus.PASS,"Fields are not Blank in System Parameter Page");
	   }

       }
	 
	 @Test(priority=22, dependsOnMethods = { "verifySystemParams" } ,groups = { "Smoke" })
     public static void verifyServicePrinciple() throws InterruptedException 
   {    
		 test =report.startTest("Verify Service Principal");
		 driver.navigate().refresh();
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathServicePrincipalLink)).click();
		 Thread.sleep(2000);
		 String servicePrinciple = driver.findElement(By.xpath("//*[@id='root']//div/table/tbody//td[2]")).getText();
		 System.out.println("Service Principle == "+servicePrinciple);
		 if(servicePrinciple.isEmpty())
		 {
			   driver.findElement(By.id(idOfName)).sendKeys(reader.getCellData("ServicePrincipal","Name", 2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.id(idOfApplicationID)).sendKeys(reader.getCellData("ServicePrincipal","ApplicationID",2));
	     		Thread.sleep(1000);
	     		driver.findElement(By.id(idOfDescription)).sendKeys(reader.getCellData("ServicePrincipal","Description",2));
	     		Thread.sleep(1000);
	     		
	     		driver.findElement(By.xpath(xpathPlusButton)).click();
	     		Thread.sleep(1000);
  	     	    driver.findElement(By.xpath(xpathKeyField)).sendKeys("TestingKey");
  	     	    Thread.sleep(1000);
  	     	    driver.findElement(By.xpath(xpathKeyValue)).sendKeys("TestingValue"); 
  	         	Thread.sleep(1000);
  	     	    driver.findElement(By.xpath(xpathSubmitBtnForKeyGeneration)).click();
  	     	
  	     	    //driver.findElement(By.id(idOfKey)).sendKeys(reader.getCellData("ServicePrincipal","Key", 2));
	     	    //	Thread.sleep(1000);	
	     		
	     		
	     		driver.findElement(By.xpath(xpathSubmitButtonSP)).click();
	     		Thread.sleep(1500);
	    		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	    		
	            Assert.assertEquals(toaster,"Service Principal added successfully!","Service Principal is not added succesfully");
	            test.log(LogStatus.PASS, "Service Principal Added", "Service Principal is added succesfully");
	          
	     	    int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	    System.out.println();
	     	    
	     	    for(int i1=1;i1<=numberOfRecords;i1++)
	     	     {
	     		   
	                 if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i1+"]//td[2]")).getText().equals(reader.getCellData("ServicePrincipal", "Name", 2))&&
	     			    driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i1+"]//td[3]")).getText().equals(reader.getCellData("ServicePrincipal","Description", 2)))
	     				{
	     			    test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	     		        }
	             }
		         }
		     else
		        {
			    System.out.println("Fileds are not Blank in Service Principle Page");
			    test.log(LogStatus.PASS,"Fields are not Blank in Service  Principle Page");
		       }
   
   
   }
	 
	 @Test(priority=23, dependsOnMethods = { "verifyServicePrinciple" } ,groups = { "Smoke" })
     public static void verifySubscription() throws InterruptedException 
     {   
		 test =report.startTest("Verify Subscription");
		 driver.navigate().refresh();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(xpathSubscriptionLink)).click();
		 String subscription = driver.findElement(By.xpath("//*[@id='root']//div/table/tbody/tr//td[text()='"+reader.getCellData("Subscription","SubscriptionId", 5)+"']")).getText();
		 System.out.println("Subscription ==  "+subscription);
		 if(subscription.isEmpty())
		 {
			    driver.findElement(By.xpath(xpathQaspServiceprincipal)).click();
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
				System.out.println("toaster message is"+ toaster);
		        Assert.assertEquals(toaster,"Subscription added successfully!","Subscription is not added succesfully");
		        test.log(LogStatus.PASS, "Subscription Added", "Subscription is added succesfully");
		        
		 }
		else
		{
			 System.out.println("Fields are not Blank in Subscription Page");
			 test.log(LogStatus.PASS,"Fields are not Blank in Subscription Page");
		}
   }
	 @Test(priority=24, dependsOnMethods = { "verifySubscription" } ,groups = { "Smoke" })
     public static void verifyAddDataFactory() throws InterruptedException 
   {   
		 test =report.startTest("Verify Add Services");
		 driver.navigate().refresh();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
		 
		 Thread.sleep(2000);
		 String dataFactory = driver.findElement(By.xpath(xpathDatafactory)).getText();
		
		 System.out.println("Data Factory" + dataFactory);
		 if(dataFactory.isEmpty())
		 {
		
		 driver.findElement(By.id("select-source")).click();
		 driver.findElement(By.xpath(xpathServices)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.id("select-dataSourceTypeId")).click();
		 driver.findElement(By.xpath(xpathDataFactory)).click();
		 driver.findElement(By.id("select-subscriptionId")).click();
	     driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
		 driver.findElement(By.id("ResourceGroupName")).sendKeys(reader.getCellData("Storage&Service","RGN", 2));
		 driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","DFN", 2));
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitStorageService)).click();
		 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
			
		 Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
		 test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
		 Thread.sleep(1000);
		 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	 	 System.out.println();
		 Thread.sleep(1000);
	 	 boolean status = false;
		for(int i=1;i<=numberOfRecords;i++)
	 	    {
	 		   
	         if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[1]")).getText().equals(reader.getCellData("Storage&Service", "DFN", 2)))
	 		{
	 			test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	 			status=true ;
	   	    }
	 	    } 
	        if(!status)  
	           
	        {
	       	test.log(LogStatus.FAIL,"Record is  not displaying in grid Sucessfully or Record is not Updated!!!");
	        }
	        
	        
		 }
		 else
		 {
			 System.out.println("Data factory is Already there");
		     test.log(LogStatus.PASS,"Data factory is Already there");
			 
		 }
	        
	        }
	 //add Send grid
	
	 @Test(priority=25, dependsOnMethods = { "verifyAddDataFactory" } ,groups = { "Smoke" })
     public static void verifyAddSendgrid() throws InterruptedException 
   {   
	 test =report.startTest("Verify Add Send Grid");
	 driver.navigate().refresh();
	 Thread.sleep(3000); 
	 
	 
	 String sendgrid = driver.findElement(By.xpath(xpathSendgrids)).getText();
	 if(sendgrid.isEmpty())
	 {
	 driver.findElement(By.id("select-source")).click();
	 driver.findElement(By.xpath(xpathServices)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.id("select-dataSourceTypeId")).click();
	 driver.findElement(By.xpath(xpathSendgrid)).click();
	 driver.findElement(By.id("select-subscriptionId")).click();
     driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
     Thread.sleep(1000);
     driver.findElement(By.id("Email")).sendKeys(reader.getCellData("Storage&Service", "Email", 2));//email
     driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service", "Name", 3));
     driver.findElement(By.xpath(xpathKeyIcon)).click();
     Thread.sleep(1000);
     driver.findElement(By.name("secretKey_error_text")).sendKeys(reader.getCellData("Storage&Service", "SecretKey", 3));
     driver.findElement(By.name("secretValue_error_text")).sendKeys(reader.getCellData("Storage&Service","Secretvalue", 3));
     Thread.sleep(1000);
     driver.findElement(By.xpath(xpathSubmitKey)).click();
     Thread.sleep(1000);
     driver.findElement(By.id("HostName")).sendKeys(reader.getCellData("Storage&Service","HostName", 2));
     Thread.sleep(1000);
     driver.findElement(By.id("PortNumber")).sendKeys(reader.getCellData("Storage&Service","PortNo", 2));
     Thread.sleep(1000);
     
     driver.findElement(By.xpath(xpathSubmitStorageService)).click();
	 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		
	 Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
	 test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
	 Thread.sleep(1000);
	 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
 	 System.out.println();
	 Thread.sleep(1000);
 	 boolean status = false;
	for(int i=1;i<=numberOfRecords;i++)
 	    {
 		   
         if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[1]")).getText().equals(reader.getCellData("Storage&Service", "Name", 3)))
 		{
 			test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
 			status=true ;
   	    }
 	    } 
        if(!status)  
           
        {
       	test.log(LogStatus.FAIL,"Record is  not displaying in grid Sucessfully or Record is not Updated!!!");
    
        }}
	 
	 
	 else
	 {
		 System.out.println("Grid is Already Created");
	     test.log(LogStatus.PASS,"Grid is Already Created");
		 
	 }
   }
	 // Add Azure Function
	 @Test(priority=26, dependsOnMethods = { "verifyAddSendgrid" } ,groups = { "Smoke" })
     public static void verifyAddAzureFunction() throws InterruptedException 
	 
     {
		 test =report.startTest("Verify Add Azure Function");
		 driver.navigate().refresh();
		 Thread.sleep(3000); 
		 String azureFnctn = driver.findElement(By.xpath(xpathAzureFunctions)).getText();
		 if(azureFnctn.isEmpty())
		 {
		 
		 driver.findElement(By.id("select-source")).click();
		 driver.findElement(By.xpath(xpathServices)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.id("select-dataSourceTypeId")).click();
		 driver.findElement(By.xpath(xpathAzureFunction)).click();
		 driver.findElement(By.id("select-subscriptionId")).click();
	     driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
	     Thread.sleep(1000);
	     driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","Azure Function", 2));
         driver.findElement(By.id("FunctionAppUrl")).sendKeys(reader.getCellData("Storage&Service","Azure Function", 3));   
         Thread.sleep(1000);
         driver.findElement(By.xpath(xpathPlusbuttonAzureFunction)).click();
         Thread.sleep(1000);
         driver.findElement(By.id("secretKey_error_text")).sendKeys("AzureFunctionKey");
         driver.findElement(By.id("secretValue_error_text")).sendKeys("k9/qdcG4k0RVQ20q21cuD40umjf5FTxgA7o7FjFowmaB/BF9reiT7w==");
         Thread.sleep(1000);
         driver.findElement(By.xpath(xpathSubmitButtonAFkey)).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(xpathSubmitStorageService)).click();
         
         }
		 
		 else
		 {
			 System.out.println("Azure Function is Already Created");
		     test.log(LogStatus.PASS,"Azure Function is Already Created");
			 
		 }
     }
	 
	 @Test(priority = 27, dependsOnMethods = { "verifyAddAzureFunction" } ,groups = { "Smoke" })
     public static void verifySourceAdd() throws InterruptedException 
   {    
		 verifySourceSQL(2);
   } 
	    
	 @Test(priority =  28,dependsOnMethods = { "verifySourceAdd" },groups = { "Smoke" })
	    public static void verifyAddDestination() throws InterruptedException 
	    {	  verifyDestinationADLS(2);
		        }
	   
	           @Test(priority = 29,dependsOnMethods = { "verifyAddDestination" },groups = { "Smoke" })
               public static void verifyAddDataFlow() throws InterruptedException, AWTException 
                   {    
		             test = report.startTest("Verify Add DataFlow");
					 Thread.sleep(2000);
					 driver.findElement(By.xpath(xpathDataFlowPageLink)).click();
					 Thread.sleep(2000);
					 driver.findElement(By.xpath(xpathAddButton)).click();
					 Thread.sleep(3000);
                     driver.findElement(By.xpath(xpathCreateDataFlow)).click();
                     Thread.sleep(2500);
					 driver.findElement(By.id("name")).sendKeys(reader.getCellData("DataFlow","Name", 2));
		     		 Thread.sleep(2500);
		     	     driver.findElement(By.id("description")).sendKeys(reader.getCellData("DataFlow", "Description", 2));
					 Thread.sleep(2500);
					 driver.findElement(By.className("css-1hwfws3")).click();
					 Thread.sleep(4000);
					 driver.findElement(By.xpath("/html/body/div//form//div[text()='"+reader.getCellData("DataFlow","Source", 2)+"']")).click();
					 Thread.sleep(2500);
					 driver.findElement(By.xpath(xpathAdlsDest)).click();
					 Thread.sleep(2500);
					 driver.findElement(By.xpath("//html/body/div//form//div[text()='"+reader.getCellData("Storage&Service","NameD", 2)+"']")).click();
					 Thread.sleep(1000);
                     driver.findElement(By.xpath(xpathSelectTableLink)).click();	 
					 String tableName = driver.findElement(By.xpath(xpathTableName)).getText();
					 Assert.assertEquals(tableName,"Table Name", "Table Name Column is Not displaying");
					 test.log(LogStatus.PASS,"Table Columns","Table Column is displaying");
					 String CDC = driver.findElement(By.xpath(xpathCDC)).getText();
					 Assert.assertEquals(CDC,"CDC","CDC Name Column is Not displaying");
					 test.log(LogStatus.PASS,"Table Columns","CDC Column is displaying");
					 
					 
					 String TDR = driver.findElement(By.xpath(xpathTDR)).getText();
					 Assert.assertEquals(TDR,"Track Deleted Records", "Track Deleted Records Name Column is Not displaying");
					 test.log(LogStatus.PASS,"Table Columns","Track Deleted Records Column is displaying");
					 
					 String doCleansing = driver.findElement(By.xpath(xpathDoCleansing)).getText();
					 Assert.assertEquals(doCleansing,"DoCleansing", "DoCleansing Column is Not displaying");
					 test.log(LogStatus.PASS,"Table Columns","DoCleansing Column is displaying");
					 
					 String schemaPropogated = driver.findElement(By.xpath(xpathSchemaPropogated)).getText();
					 Assert.assertEquals(schemaPropogated,"Schema Propagated", "Schema Propagated Column is Not displaying");
					 test.log(LogStatus.PASS,"Table Columns","Schema Propagated Column is displaying");
					 
					 String whereClause= driver.findElement(By.xpath(xpathWhereClause)).getText();
					 Assert.assertEquals(whereClause,"Where clause", "Where clause Column is Not displaying");
					 test.log(LogStatus.PASS,"Table Columns","Where clause Column is displaying");
		             Thread.sleep(1000);
		             driver.findElement(By.xpath(xpathSelectTableLink)).click();	 
		        	 String tableNames = driver.findElement(By.xpath(xpathTableName)).getText();
		        	 Assert.assertEquals(tableNames,"Table Name", "Table Name Column is Not displaying");
		        	 test.log(LogStatus.PASS,"Table Columns","Table Column is displaying");
		        	 
		        	driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[4]/div/div[1]/table/thead/tr/th[1]/span/span[1]/input")).click();
		             driver.findElement(By.xpath("(//*[@id='1'])[5]")).click();

		        	  Thread.sleep(2000);
		        	 
		        	 driver.findElement(By.xpath("(/html/body//button[text()='Save'])[3]")).click();
		        	 
		        	 Thread.sleep(1000);
		        	 
		        	 //custom activity Field is Displaying
		        	 boolean customActivity = driver.findElement(By.id("select-customActivity")).isDisplayed();
		        	 Assert.assertEquals(customActivity,true,"customActivity field is Displaying!!");
		        	 test.log(LogStatus.PASS,"Data Flow","Custom Activity Field is displaying");
		        	 
		        	 boolean addbtn = driver.findElement(By.xpath(xpathcstmadd)).isEnabled();
		        	 Assert.assertEquals(addbtn,false,"Add button is displaing and disabled");
		        	 test.log(LogStatus.PASS,"Data Flow","Add button is displaing and disabled");
		        	 
		        	 driver.findElement(By.id("select-customActivity")).click();
		        	 Thread.sleep(1000);
		        	 
		        	 driver.findElement(By.xpath("//*[@id='menu-customActivity']//li[text()='"+(reader.getCellData("Operations","Name", 2)+"']"))).click();
		        	 Thread.sleep(1000);
		        	 driver.findElement(By.xpath(xpathcstmadd)).click();
		        	 Thread.sleep(5000);
		        	 
                 // driver.findElement(By.xpath("//input[@id='1']")).click();
		        //	 Thread.sleep(1000);
		        	 
		        	// driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[7]/div/div[2]/table/tbody/tr[1]/td[2]/div/div/input")).click();
		        	// driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[7]/div/div[2]/table/tbody/tr[1]/td[2]/div/div/input")).sendKeys("CopyFull");
		        	 driver.findElement(By.xpath("//*[@class='sub-table']//input[@id='1']")).click();
		        	 Thread.sleep(1000);
		        	 driver.findElement(By.xpath("//*[@class='sub-table']//input[@id='1']")).sendKeys("CreateTableFromStaging");
		        	 Thread.sleep(1000);
		        	 driver.findElement(By.xpath("//*[@class='sub-table']//input[@id='2']")).sendKeys("CopyFull");
		        	 Thread.sleep(1000);
		        	 
		        	 
		        	// driver.findElement(By.id("select-customActivity")).click();
		        	// Thread.sleep(1000);
		        	 
		        	// driver.findElement(By.xpath("//*[@id='menu-customActivity']//li[text()='"+(reader.getCellData("Operations","Name",4)+"']"))).click();
		        	// Thread.sleep(1000);
		        	// driver.findElement(By.xpath(xpathcstmadd)).click();
		        	// Thread.sleep(1000);
		        	/* Robot robot = new Robot();
		        	  for(int i=1;i<3;i++)
		        	  {
		        	   robot.keyPress(KeyEvent.VK_CONTROL);
		        	   robot.keyPress(KeyEvent.VK_SUBTRACT);
		        	   robot.keyRelease(KeyEvent.VK_SUBTRACT);
		        	   robot.keyRelease(KeyEvent.VK_CONTROL);  
		        	  }
		        	 Thread.sleep(1000);
		        	 driver.findElement(By.xpath("(//*[@class='sub-table']//input[@id='1'])[2]")).click();
		        	 Thread.sleep(1000);
		        	 driver.findElement(By.xpath("(//*[@class='sub-table']//input[@id='1'])[2]")).sendKeys("CreateTableFromStaging");
		        	 Thread.sleep(1000);
		        	 driver.findElement(By.xpath("(//*[@class='sub-table']//input[@id='2'])[2]")).sendKeys("CopyFull");
		        	 Thread.sleep(1000);*/
		        	 
		        	 driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[7]/div[1]/div[1]/div/div[1]/div/div/input")).sendKeys("1");
		        	 Thread.sleep(1000);
		        	 //driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[7]/div[2]/div[1]/div/div[1]/div/div/input")).sendKeys("2");
		        	 

				  	 Thread.sleep(1000);
				  	 driver.findElement(By.xpath(xpathSaveButton)).click();
				  	 Thread.sleep(1600);
		        	
		        	 
		             String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();

		    		
			    	 Assert.assertEquals(toaster,"Flow added successfully!","Record is not added succesfully ");	    	
			    	 test.log(LogStatus.PASS, "add Flow", "Flow is added Successfully Toaster message is displaying");
			    	 driver.navigate().refresh();
			    	 Thread.sleep(1000);
			    	 driver.findElement(By.xpath("//*[@id='root']/div//table//tbody//tr[1]//td[7]//button[@title='Publish flow']")).click();//publish Flow
			         Thread.sleep(4000);
			    	 driver.findElement(By.xpath(xpathYesBtn)).click();
			    	 WebDriverWait wait = new WebDriverWait(driver,60);
			    	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
			    	 String toaster2 = driver.findElement(By.xpath(toasterRecordSaved)).getText();
			         System.out.println(toaster2);
			         Assert.assertEquals(toaster2,"data flow published successfully","data flow is not published");
			         test.log(LogStatus.PASS, "Publish","data flow published successfully");
			        } 
	          
	           
	               @Test(priority = 30, dependsOnMethods = { "verifyAddDataFlow" },groups = { "Smoke" })
                   public static void verifyScheduledFlow() throws InterruptedException 
                   { 
	            	   verifyScheduledFlowR(2 ,2);
	   		  
	   		  
	   			}
	   			
	          @Test(priority = 31, dependsOnMethods = { "verifyScheduledFlow" },groups = { "Smoke" })
               public static void verifyFlowOnMontioringScreen() throws InterruptedException  
               {    
	        	  verifyFlowMontioringScreen(2);   
	        	    
        	  
}
	        	    
}


               
