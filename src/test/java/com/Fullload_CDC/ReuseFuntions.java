package com.Fullload_CDC;

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

public class ReuseFuntions extends BaseClass implements IOnBoarding ,IMonitoring{
	 static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	
	 
	 
	
    
    //Verify and Validate Source creation of Mysql
    public static void verifySourceMysql(int i) throws InterruptedException 

    {   
    test = report.startTest("Verify MYSQL Source Creation");
    driver.navigate().refresh();
    Thread.sleep(3000);
    driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
    Thread.sleep(2000);
    driver.findElement(By.id("select-source")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathSource)).click();
    Thread.sleep(1500);
    driver.findElement(By.id("select-dataSourceTypeId")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath(xpathMysqlSource)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("select-subscriptionId")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
    //driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='Dev']")).click();

    Thread.sleep(1000);
    driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","Name", i));
    Thread.sleep(1000);
    driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","DescriptionSource", i));
    Thread.sleep(1000);
    driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service", "UserName", 11));
    Thread.sleep(1000);
    driver.findElement(By.id("select-165")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathIntegrationMysql)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("DbserverName")).sendKeys(reader.getCellData("Storage&Service","DBServerName", 11));
    Thread.sleep(1000);
    driver.findElement(By.id("Dbname")).sendKeys(reader.getCellData("Storage&Service", "DBName", 11));
    Thread.sleep(1000);
    driver.findElement(By.id("select-169")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='menu-169']/div//li[text()='"+reader.getCellData("Storage&Service", "IntegrationRunTime", 2)+"']")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("Port")).sendKeys(reader.getCellData("Storage&Service","PortNo", 11));
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathSubmitclick)).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathYesBtnn)).click();
    WebDriverWait wait = new WebDriverWait(driver,80);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
   // click on the compose button as soon as the "compose" button is visible
   String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	
   Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
  test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully");
   Thread.sleep(2000);
   }
   
    //Verify and validate Source Creation of SQL
    public static void verifySourceSQL(int i) throws InterruptedException 

    {

    test = report.startTest("Verify Add Source");
    driver.navigate().refresh();
    Thread.sleep(2000);
    driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
    driver.findElement(By.id("select-source")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathSource)).click();
    Thread.sleep(1500);
    driver.findElement(By.id("select-dataSourceTypeId")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath(xpathOnPremiseSql)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("select-subscriptionId")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
    //driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='Dev']")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","Name", i));
    Thread.sleep(1000);
    driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","DescriptionSource", 2));
    Thread.sleep(1000);
    driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service", "UserName", 2));
    Thread.sleep(1000);
    driver.findElement(By.id("select-33")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathPriyankaSystemKey)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("DbserverName")).sendKeys(reader.getCellData("Storage&Service","DBServerName", 2));
    Thread.sleep(1000);
    driver.findElement(By.id("Dbname")).sendKeys(reader.getCellData("Storage&Service", "DBName", 2));
    Thread.sleep(1000);
    driver.findElement(By.id("select-37")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='menu-37']/div//li[text()='"+reader.getCellData("Storage&Service", "IntegrationRunTime", 2)+"']")).click();
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
 
    
    
    public static void verifySourceOracle(int i) throws InterruptedException 

{
    	
    test = report.startTest("Verify Add Source");
    driver.navigate().refresh();
    Thread.sleep(2000);
    driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
    driver.findElement(By.id("select-source")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathSource)).click();
    Thread.sleep(1500);
    driver.findElement(By.id("select-dataSourceTypeId")).click();
    Thread.sleep(1500);
    driver.findElement(By.xpath(xpathOnPremiseoracle)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("select-subscriptionId")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
   //driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='Dev']")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","Name", i));
    Thread.sleep(1000);
    driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","DescriptionSource", 5));
    Thread.sleep(1000);
    driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service", "UserName", 5));
    Thread.sleep(1000);
    driver.findElement(By.id("select-173")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathOraclePckey)).click();
    Thread.sleep(1000);
    driver.findElement(By.id("DbserverName")).sendKeys(reader.getCellData("Storage&Service","DBServerName", 5));
    Thread.sleep(1000);
    driver.findElement(By.id("SID")).sendKeys(reader.getCellData("Storage&Service", "DBName", 5));
    Thread.sleep(1000);
    driver.findElement(By.id("select-177")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id='menu-177']/div//li[text()='"+reader.getCellData("Storage&Service", "IntegrationRunTime", 2)+"']")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("Port")).sendKeys(reader.getCellData("Storage&Service","PortNo", 5));
    Thread.sleep(1000);
   //driver.findElement(By.id("ResourceGroupName")).sendKeys(reader.getCellData("Storage&Service","ResourceGroupName", 2));
    driver.findElement(By.xpath(xpathSubmitclick)).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath(xpathYesBtnn)).click();
    WebDriverWait wait = new WebDriverWait(driver,80);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
   // click on the compose button as soon as the "compose" button is visible
    String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();

   Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
   test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully");
   Thread.sleep(2000);

}
    
    
    public static void verifyDestinationSQL(int j) throws InterruptedException 


   {
	
   boolean status=false;
   test = report.startTest("Verify Add Destination"); 	
   driver.navigate().refresh();
   driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
   Thread.sleep(1000);
   driver.findElement(By.id("select-source")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath(xpathDestinnation)).click();
   Thread.sleep(1000);
   driver.findElement(By.id("select-dataSourceTypeId")).click();
   driver.findElement(By.xpath(xpathAzureSql)).click();
   Thread.sleep(1000);
   driver.findElement(By.id("select-subscriptionId")).click();
   driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
   Thread.sleep(1000);
   driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","NameD",j));
   driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","Description",5));
   driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service","UserName",6));
   driver.findElement(By.id("select-9")).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath(xpathAzureSqlPass)).click();
   Thread.sleep(1000);
   driver.findElement(By.id("DbserverName")).sendKeys(reader.getCellData("Storage&Service","DBServerName", 6));
   driver.findElement(By.id("Dbname")).sendKeys(reader.getCellData("Storage&Service","DBName", 6));
   Thread.sleep(2000);
   driver.findElement(By.xpath(xpathSubmitclick)).click();
   Thread.sleep(1000);
   driver.findElement(By.xpath(xpathYesBtnn)).click();
   WebDriverWait wait = new WebDriverWait(driver,60);
   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
   String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
   System.out.println(toaster);
   Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
   test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
   Thread.sleep(1000);
   int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
   System.out.println();
   Thread.sleep(1000);
   for(int i=1;i<=numberOfRecords;i++)
    {
	   
    if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[1]")).getText().equals(reader.getCellData("Storage&Service", "NameD", 2))&&
		driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Storage&Service","Description", 2)))
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



  public static void verifyDestinationADLS(int j) throws InterruptedException 

{
	
 boolean status=false;
 test = report.startTest("Verify Add Destination of ADLS"); 	
 driver.navigate().refresh();
 driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
 driver.findElement(By.id("select-source")).click();
 Thread.sleep(1000);
 driver.findElement(By.xpath(xpathDestinnation)).click();
 Thread.sleep(1000);
 driver.findElement(By.id("select-dataSourceTypeId")).click();
 Thread.sleep(1000);
 driver.findElement(By.xpath(xpathAzureDataLake)).click();
 Thread.sleep(1000);
 driver.findElement(By.id("select-subscriptionId")).click();
 driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
 Thread.sleep(1000);
 driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","NameD", j));
 driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","Description",11));
 driver.findElement(By.id("DataLakeStoreUri")).sendKeys(reader.getCellData("Storage&Service","DataStorage", 2));
 Thread.sleep(1000);
 driver.findElement(By.xpath(xpathSubmitclick)).click();
 Thread.sleep(1500);
 driver.findElement(By.xpath(xpathYesBtnn)).click();
 WebDriverWait wait = new WebDriverWait(driver,60);
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved))); 
 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
 System.out.println("yoo"+toaster);
 Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
 test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
 Thread.sleep(1000);
 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
 System.out.println();
 Thread.sleep(1000);
 for(int i=1;i<=numberOfRecords;i++)
    {
	   
    if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[1]")).getText().equals(reader.getCellData("Storage&Service", "NameD", 2))&&
		driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Storage&Service","Description", 2)))
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
  
  
  
  //Verify and validate Flow is Scheduling
  public static void verifyScheduledFlowR(int i ,int j) throws InterruptedException 
  {   

	 test = report.startTest("Verify Scheduled DataFlow");
   driver.navigate().refresh();
   Thread.sleep(3000);
	 driver.findElement(By.xpath(xpathDataFlowScheduled)).click();
	 Thread.sleep(2000);
	 driver.findElement(By.id("select-dataflowname")).click();
	 Thread.sleep(2000);
	 driver.navigate().refresh();
	 Thread.sleep(2000);
	 driver.findElement(By.id("select-dataflowname")).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@id='menu-dataflowname']//div//li[text()='"+reader.getCellData("DataFlow","Name", i)+"']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(xpathSelectFrequency)).click();
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[@id='root']//div/form//div[text()='Now']")).click();
 
   String description=reader.getCellData("Scheduler","Description", j); 
	 driver.findElement(By.xpath("//*[@id='root']//*[@name='description']")).sendKeys(description);
   Thread.sleep(1000);
	 driver.findElement(By.id("addScheduler")).click();
	 Thread.sleep(1000);
	 String toaster = driver.findElement(By.xpath(xpathtoaster)).getText();

	 System.out.println(toaster);
   Assert.assertEquals(toaster,"Flow Scheduled successfully!","Flow is not Scheduled succesfully");
   test.log(LogStatus.PASS,"Flow Scheduled", "Flow is Scheduled succesfully");
 }  

	 //verify and validate Monitoring Screen
	 public static void verifyFlowMontioringScreen( int i) throws InterruptedException  
	  {    
		test = report.startTest("Verify Flow On monitoring Page");
		Thread.sleep(10000);
		driver.findElement(By.xpath(xpathMonitoringPagelink)).click();
		Thread.sleep(50000);
	    driver.navigate().refresh();
	    Thread.sleep(50000);
	    driver.navigate().refresh();
		    
		    driver.findElement(By.xpath("(//*[@id='root']//div//tr/td[3][text()='"+reader.getCellData("DataFlow","Name", i)+"'])[1]")).isDisplayed();
		    test.log(LogStatus.PASS,"Monitoring Page","Flow is Displaying on Monitoring Screen");
		    System.out.println("Flow is Displaying on Monitoring Screen");
		    int count = 0;
		    while(count == 0)
		    { 
			     Thread.sleep(4000);
		     driver.navigate().refresh();
		     System.out.println("Inprogress loop-----------------");
		     String statusofpl = driver.findElement(By.xpath("(//*[@id='root']/div//table/tbody//tr/td[3][text()='"+reader.getCellData("DataFlow","Name", i)+"'])[1]/..//td[10]")).getText();
		     System.out.println("print status" +statusofpl);
		     if(statusofpl.equals("InProgress"))
		     {
		    	count=0;
		    	System.out.println("still in progress");
		     }
		     else
		     {
		    	 count = 1;
		    	 System.out.println("Status"+ driver.findElement(By.xpath("(//*[@id='root']/div//table/tbody//tr/td[3][text()='"+reader.getCellData("DataFlow","Name", i)+"'])[1]/..//td[10]")).getText());
		     }
		     // statusofpl = driver.findElement(By.xpath("//*[@id='root']//table/tbody/div[1]/tr/td[10]")).getText();
		     // Thread.sleep(3000);
		     }
	         System.out.println("Status is " + driver.findElement(By.xpath("(//*[@id='root']/div//table/tbody//tr/td[3][text()='"+reader.getCellData("DataFlow","Name", i)+"'])[1]/..//td[10]")).getText());
	         String Status=driver.findElement(By.xpath("(//*[@id='root']/div//table/tbody//tr/td[3][text()='"+reader.getCellData("DataFlow","Name", 13)+"'])[1]/..//td[10]")).getText();
		     test.log(LogStatus.PASS,"Status of Flow is" +Status);         
	}
		    
	 
	 
  
}
