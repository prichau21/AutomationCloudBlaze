package com.CloudBlaze.Onboarding;
//import org.json.simple.parser.*; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import com.google.gson.Gson;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.microsoft.azure.storage.blob.ListBlobItem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IOnBoarding;

//import com.blobread.ObjectMapper;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.relevantcodes.extentreports.LogStatus;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

//import com.microsoft.aad.adal4j.AuthenticationContext;
//import com.microsoft.aad.adal4j.AuthenticationResult;
//import com.microsoft.aad.adal4j.ClientCredential;a
import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
public class DataSources extends BaseClass implements IOnBoarding {
	 
	private static final CloudBlockBlob Null = null;
	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	
	

	
	// Verify DataSource Page Link
	@Test(priority = 1, groups = { "Smoke" })
	public void verifyDataSourcesPageLink() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		test = report.startTest("Click on Data Sources Page Link");

		try {
			driver.findElement(By.xpath(xpathDataSourcePageLink)).click();

		} catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User has successfully clicked on Data Sources Page Link");
	}
	 //Verify When user Click on Data Source  Link ,its Page will Display 
		@Test(priority = 2, dependsOnMethods = { "verifyDataSourcesPageLink" }, groups = { "Smoke" })
		public static void verifyUrlOfDataSources() throws InterruptedException 
		    {

			
			driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Url of Data Sources Page");
	        
			// verify the Url of the page
			if(driver.getCurrentUrl().equals(xpathUrlOfDataSources)) {
			Assert.assertEquals(xpathUrlOfDataSources, driver.getCurrentUrl(),"URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
				}
			else 
			{
		    test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
			}
			
			
			 if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
			 {    test.log(LogStatus.FAIL, "Storgae and Servies page Screen not Displaying");
				 System.out.println("Storgae and Servies Screen is not Displaying");
			 }
			 
			 else
			 {
				 test.log(LogStatus.PASS,"Storgae and Servies page Screen is  Displaying");
				 System.out.println("Storgae and Servies page Screen is Displaying ");
			 }
			 }
			
	 
		//STorage and Service Page home Components
		 @Test(priority = 3, dependsOnMethods = { "verifyUrlOfDataSources" }, groups = { "Smoke" })
		 public static void verifyComponentsOfStoragePage() throws InterruptedException 
		 {   driver.navigate().refresh();
			 Thread.sleep(3000);
			 test = report.startTest("Verify Components of Storage Page");
	         String storage = driver.findElement(By.className("page-heading")).getText();
	         Assert.assertEquals(storage,"Storages & Services","Storages & Services Title is not Displaying on Screen!!");
	         test.log(LogStatus.PASS, "Home Page","Storages & Services Title is  Displaying on Screen!!");
	         
	         //Submitt button
	         boolean submitBtn = driver.findElement(By.xpath(xpathSubmitBtn)).isEnabled();
	         Assert.assertEquals(submitBtn,true,"submitBtn button is  not Displaying or Disabled on Screen!!");
	         test.log(LogStatus.PASS, "Home Page","submitBtn button is  Displaying and enabled on Screen!!");
	        //Cancel Button
	         boolean cancelBtn = driver.findElement(By.xpath(xpathCancelBtn)).isEnabled();
	         Assert.assertEquals(cancelBtn,true,"cancelBtn button is  not Displaying or Disabled on Screen!!");
	         test.log(LogStatus.PASS, "Home Page","cancelBtn button is  Displaying and enabled on Screen!!");
	         
	         //Select Source Drop Down
	         
	         boolean selectSource=driver.findElement(By.id("select-source")).isDisplayed();
	         Assert.assertEquals(selectSource,true,"select Source Drop Down is not Disaplaying!!");
	         test.log(LogStatus.PASS,"Home Page","select Source Drop Down is Displaying");
	         
	         //Select type
	         boolean selectType = driver.findElement(By.id("select-dataSourceTypeId")).isDisplayed();
	         Assert.assertEquals(selectType, true,"Select Type is not displaying!!");
	         test.log(LogStatus.PASS,"Home Page","Select Type Field is Displaying");
	         
	         //Subscription name
	         boolean subName = driver.findElement(By.id("select-subscriptionId")).isDisplayed();
	         Assert.assertEquals(subName, true,"Subscription Name is not displaying!!");
	         test.log(LogStatus.PASS,"Home Page","Subscription Name Field is Displaying");
	         
	         boolean label = driver.findElement(By.xpath(xpathSourceDestinationLabel)).isDisplayed();
	         Assert.assertEquals(label, true,"Source/Destination Label is not displaying!!");
	         test.log(LogStatus.PASS,"Home Page","Source/Destination Label is Displaying");
	         
	         
		  }
		

			// Verify Components of Grid
		@Test(priority = 4, dependsOnMethods = { "verifyComponentsOfStoragePage" },groups = { "Smoke" })
			public static void verifyGridComponents() throws InterruptedException 
			{

				test = report.startTest("Verify Components of Grid");

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
		

		@Test(priority = 5, dependsOnMethods = { "verifyGridComponents" }, groups = { "Smoke" })
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
	 	     if(columns.equals("Name"))
	 	     {
	 	    	 
	 			 test.log(LogStatus.PASS, "Total columns", "Name is Displaying");
	 			  
	 	     }
	 	     if(columns.equals("Description"))
	 	     {
	 	    	 
	 			 test.log(LogStatus.PASS, "Total columns", "Description is Displaying"); 
	 	     }
	 	     if(columns.equals("Type"))
	 	     {
	 	    	 
	 			 test.log(LogStatus.PASS, "Total columns", "Type is Displaying"); 
	 	     }
	 	     
	 	     if(columns.equals("Connection Type"))
	 	     {
	 	    	 test.log(LogStatus.PASS, "Total columns", "Connection Type is Displaying");  
	 	     }
	 	   
	 	     if(columns.equals("CreatedOn"))
	 	     {
	 	    	
	 			 test.log(LogStatus.PASS, "Total columns", "Created On is Displaying"); 
	 	     }
	 	     if(columns.equals("Last ActionBy"))
	 	     {
	 	      test.log(LogStatus.PASS, "Total columns", "Last ActionBy is Displaying");  
	 	     }
	 	     if(columns.equals("Action"))
	 	     {
	 	     test.log(LogStatus.PASS, "Total columns", "Action is Displaying"); 
	 	    	 
	 	     }
	 	
	          }

	 		}
		@Test(priority = 6, dependsOnMethods = { "verifyColumnsOfGrid" },groups = { "Smoke" })
	    public static void verifyNumberOfRecords() throws InterruptedException 
		
		{
		
		test = report.startTest("Verify Numbers of Records In grid");
		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
		test.log(LogStatus.PASS, "Number of Rows In Grid", "" + rows + "rows In Grid is displaying");
	    }
		
		@Test(priority = 7, dependsOnMethods = { "verifyNumberOfRecords" },groups = { "Smoke" })
	    public static void verifyDataFactoryFields() throws InterruptedException 
		{    
			
			  if(driver.findElement(By.xpath("//*[@id='root']//div/table/tbody//td[3][text()='datafactory']")).isDisplayed())
        {
         System.out.println("Data Factory is Already created");
         test.log(LogStatus.PASS,"Data Factory","Data Factory is Already created");
	
        } 
        else
         {
			
			 boolean status=false;
			 test = report.startTest("Verify DataFactory Fields"); 	
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
			 driver.findElement(By.xpath(xpathSubmit)).click();
			 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
				
			 Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
			 test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
			 Thread.sleep(1000);
			 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
		 	 System.out.println();
			 Thread.sleep(1000);
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
		        }
		
		
			
		
		//Linked Service of DataFactory-Config Databricks
		@Test(priority = 8, dependsOnMethods = { "verifyDataFactoryFields"},groups = { "Smoke" })
	    public static  void sendGetConfigDataBricks() throws Exception {
			Thread.sleep(2000);
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			  String urlLS="https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/configdatabricks_configdatabricks_22?api-version=2018-06-01";
			 // String urlLS=" https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/sourceauto12345678_sqlserver_5?api-version=2018-06-01";
			  URL objLS = new URL(urlLS);
				HttpURLConnection conLS = (HttpURLConnection) objLS.openConnection();
				conLS.setRequestMethod("GET");
				conLS.setRequestProperty("Content-Type", "application/json");
				conLS.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
				//add request header
				conLS.setRequestProperty("User-Agent", USER_AGENT);
			    String messageLSs = conLS.getResponseMessage();
			    System.out.println("Message For Sendget request for CONFIG DATABRICKS LS : "+messageLSs);
			 	int responseCodeLS = conLS.getResponseCode();
			 	System.out.println("Sending 'GET' request for CONFIG DATABRICKS LS : " + urlLS);
			 	System.out.println("Response Code For LS for CONFIG DATABRICKS : " + responseCodeLS);
	     }
		
		
		//Linked Service of DataFactory-Config Sql
		@Test(priority = 9, dependsOnMethods = { "sendGetConfigDataBricks"},groups = { "Smoke" })
	    public static  void sendGetConfigSql() throws Exception {
			Thread.sleep(2000);
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			  String urlLS="https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/configsql_configsql_21?api-version=2018-06-01";
			 // String urlLS=" https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/sourceauto12345678_sqlserver_5?api-version=2018-06-01";
			  URL objLS = new URL(urlLS);
				HttpURLConnection conLS = (HttpURLConnection) objLS.openConnection();
				conLS.setRequestMethod("GET");
				conLS.setRequestProperty("Content-Type", "application/json");
				conLS.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
				//add request header
				conLS.setRequestProperty("User-Agent", USER_AGENT);
			    String messageLSs = conLS.getResponseMessage();
			    System.out.println("Message For Sendget request for CONFIG SQL LS : "+messageLSs);
			 	int responseCodeLS = conLS.getResponseCode();
			 	System.out.println("Sending 'GET' request for CONFIG SQL LS : " + urlLS);
			 	System.out.println("Response Code For LS for CONFIG SQL : " + responseCodeLS);
	     }
		//Linked Service of DataFactory-Config Blob
		@Test(priority = 10, dependsOnMethods = { "sendGetConfigSql"},groups = { "Smoke" })
	    public static  void sendGetConfigBlob() throws Exception {
			    Thread.sleep(2000);
			    test = report.startTest("Verify Linked Service Deleted");
			    String USER_AGENT = "Mozilla/5.0";
			    String urlLS="https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/configblob_configblob_20?api-version=2018-06-01";
			    // String urlLS=" https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/sourceauto12345678_sqlserver_5?api-version=2018-06-01";
			    URL objLS = new URL(urlLS);
				HttpURLConnection conLS = (HttpURLConnection) objLS.openConnection();
				conLS.setRequestMethod("GET");
				conLS.setRequestProperty("Content-Type", "application/json");
				conLS.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
				//add request header
				conLS.setRequestProperty("User-Agent", USER_AGENT);
			    String messageLSs = conLS.getResponseMessage();
			    System.out.println("Message For Sendget request for CONFIG Blob LS : "+messageLSs);
			 	int responseCodeLS = conLS.getResponseCode();
			 	System.out.println("Sending 'GET' request for CONFIG Blob LS : " + urlLS);
			 	System.out.println("Response Code For LS for CONFIG Blob : " + responseCodeLS);
	     }
		
		
		
		//batch linked Services
		@Test(priority = 11, dependsOnMethods = { "sendGetConfigBlob" },groups = { "Smoke" })
	           public static  void sendGetBatch() throws Exception {
			  Thread.sleep(2000);
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			  String urlLS="https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/"+reader.getCellData("Storage&Service", "BGName", 2)+"_batch_14?api-version=2018-06-01";
			 // String urlLS=" https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/sourceauto12345678_sqlserver_5?api-version=2018-06-01";
			  URL objLS = new URL(urlLS);
				HttpURLConnection conLS = (HttpURLConnection) objLS.openConnection();
				conLS.setRequestMethod("GET");
				conLS.setRequestProperty("Content-Type", "application/json");
				conLS.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
				//add request header
				conLS.setRequestProperty("User-Agent", USER_AGENT);
			    String messageLSs = conLS.getResponseMessage();
			    System.out.println("Message For Sendget requesst is BATCH LS : "+messageLSs);
			 	int responseCodeLS = conLS.getResponseCode();
			 	System.out.println("Sending 'GET' request to URL BATCH LS : " + urlLS);
			 	System.out.println("Response Code For BATCH LS  : " + responseCodeLS);
			     }
		
		
		
			 
		@Test(priority = 12, dependsOnMethods = { "sendGetBatch" },groups = { "Smoke" })
	    public static void verifyGridFields() throws InterruptedException 
		{  
			

			  if(driver.findElement(By.xpath("//*[@id='root']//div/table/tbody//td[3][text()='sendgrid']")).isDisplayed())
      {
       System.out.println("SendGrid is Already created");
       test.log(LogStatus.PASS,"SendGrid","SendGrid is Already created");
	
      } 
      else
       {
			
			
			
			
			 test = report.startTest("Verify Validate SendGrid"); 	
			 boolean status=false;
			 	
			 driver.findElement(By.id("select-source")).click();
			 driver.findElement(By.xpath(xpathServices)).click();
			 Thread.sleep(1000);
			 driver.findElement(By.id("select-dataSourceTypeId")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSendgrid)).click();
			 Thread.sleep(1000);
			 driver.findElement(By.id("select-subscriptionId")).click();
		     driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
		     Thread.sleep(1000);
		     driver.findElement(By.id("Email")).sendKeys(reader.getCellData("Storage&Service", "Email", 2));
		     driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service", "UserName", 7));
		     driver.findElement(By.id("select-160")).click();
		     Thread.sleep(1000);
		    // driver.findElement(By.name("secretKey")).sendKeys(reader.getCellData("Storage&Service", "SecretKey", 3));
		   // driver.findElement(By.name("secretValue")).sendKeys(reader.getCellData("Storage&Service","Secretvalue", 3));
		  //   Thread.sleep(1000);
		    // driver.findElement(By.xpath(xpathSubmitKey)).click();
		     //Thread.sleep(1000);
		     driver.findElement(By.xpath("//*[@id='menu-160']/div//ul/li[text()='emailserverkey']")).click();
		     driver.findElement(By.id("HostName")).sendKeys(reader.getCellData("Storage&Service","HostName", 2));
		     Thread.sleep(1000);
		     driver.findElement(By.id("PortNumber")).sendKeys(reader.getCellData("Storage&Service","PortNo", 2));
		     Thread.sleep(1000);
		    
		     driver.findElement(By.xpath(xpathSubmit)).click();
			 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		      Thread.sleep(1500);
			 Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
			 test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
			 Thread.sleep(1000);
			 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
		 	 System.out.println();
			 Thread.sleep(1000);
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
		        }
		        }
			 
		}
		
		
		
		@Test(priority = 13, dependsOnMethods = {"verifyGridFields"},groups = { "Smoke" })
	    public static void verifyValidationsForSource() throws InterruptedException 
	    {
			 test = report.startTest("Verify Validation"); 	
			 
			 //Click Source/Destination -Source/Destination/Service are Displaying
			 
			driver.findElement(By.id("select-source")).click();
	        driver.findElement(By.xpath(xpathsource)).click();
	        Thread.sleep(1000);
	        driver.findElement(By.id("select-dataSourceTypeId")).click();
	        driver.findElement(By.xpath(xpathonPremiseSql)).click();
	      // For Source Fields
	        boolean subscriptionId = driver.findElement(By.id("select-subscriptionId")).isDisplayed();
	        Assert.assertEquals(subscriptionId, true,"Subscription Name Field is not Displaying");
	        test.log(LogStatus.PASS,"Source Components","Subscription Name Field is Displaying");
	        
	        boolean name = driver.findElement(By.id("Name")).isDisplayed();
	        Assert.assertEquals(name, true,"Name Field is  not displaying!!");
	        test.log(LogStatus.PASS,"Source Components","Name Field is Displaying");
	         
	        boolean description = driver.findElement(By.id("Description")).isDisplayed();
	        Assert.assertEquals(description,true,"Description Field is not Dispalying");
	        test.log(LogStatus.PASS,"Source Components","Description Field is Displaying");
	       
	        boolean userName = driver.findElement(By.id("UserName")).isDisplayed();
	        Assert.assertEquals(userName,true,"UserName Field is not Dispalying");
	        test.log(LogStatus.PASS,"Source Components","UserName Field is Displaying");
	       
	        boolean password = driver.findElement(By.id("select-33")).isDisplayed();
	        Assert.assertEquals(password,true,"password Field is not Dispalying");
	        test.log(LogStatus.PASS,"Source Components","password Field is Displaying");
	        
	        boolean dbserverName = driver.findElement(By.id("DbserverName")).isDisplayed();
	        Assert.assertEquals(dbserverName,true,"DbserverName Field is not Dispalying");
	        test.log(LogStatus.PASS,"Source Components","DbserverName Field is Displaying");
	       
	        boolean Dbname = driver.findElement(By.id("Dbname")).isDisplayed();
	        Assert.assertEquals(Dbname,true,"Dbname Field is not Dispalying");
	        test.log(LogStatus.PASS,"Source Components","Dbname Field is Displaying");
	       
	        boolean integration = driver.findElement(By.id("select-37")).isDisplayed();
	        Assert.assertEquals(integration,true,"integration Field is not Dispalying");
	        test.log(LogStatus.PASS,"Source Components","integration Field is Displaying");
	        
	        
	        
	        driver.findElement(By.xpath(xpathSubmit)).click();
	        String alertonSub = driver.findElement(By.xpath(xpathalertonSub)).getText();
	        Assert.assertEquals(alertonSub, "Subscription Name cannot be empty","InCorrect Alert is Diaplaying Under Subscription Name Field");
	        test.log(LogStatus.PASS, "Alert","Correct Alert is Diaplaying Under Subscription Name ");
	        
	        driver.findElement(By.id("select-subscriptionId")).click();

	        Thread.sleep(1000);
	   	    driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
	   	    Thread.sleep(1000);
	        driver.findElement(By.xpath(xpathSubmit)).click();
	        
	        String alertonName = driver.findElement(By.xpath(xpathAlertonName)).getText();
	        Assert.assertEquals(alertonName,"Name cannot be empty","alertonName  is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertonName Field is Displaying");
	        
	        String alertOnUserName = driver.findElement(By.xpath(xpathAlertOnUserName)).getText();
	        Assert.assertEquals(alertOnUserName,"UserName cannot be empty","alertOnUserName  is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertOnUserName Field is Displaying");
	        
	        String alertonPassword = driver.findElement(By.xpath(xpathAlertonPassword)).getText();
	        Assert.assertEquals(alertonPassword,"Password cannot be empty","alertonPassword  is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertonPassword  is Displaying");
	        
	        String alertOnDbServerName = driver.findElement(By.xpath(xpathAlertOnDbServerName)).getText();
	        Assert.assertEquals(alertOnDbServerName,"DbserverName cannot be empty","alertOnDbServerName  is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertOnDbServerName is Displaying");
	        
	        String alertOnDB = driver.findElement(By.xpath(xpathAlertOnDB)).getText();
	        Assert.assertEquals(alertOnDB,"Dbname cannot be empty","alertOnDB is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertOnDB is Displaying");
	        
	        String alertOnIntegration = driver.findElement(By.xpath(xpathAlertOnIntegration)).getText();
	        Assert.assertEquals(alertOnIntegration,"Integration RunTime cannot be empty","alertOnIntegration is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertOnIntegration is Displaying");
	  
	    
	        
	    }
		@Test(priority = 14, dependsOnMethods = {"verifyValidationsForSource"},groups = { "Smoke" })
	    public static void verifyValidationsForDestination() throws InterruptedException 
	    {
			 test = report.startTest("Verify Validation Of Dedstination"); 	
			 
			 //Click Source/Destination -Source/Destination/Service are Displaying
			 
			driver.findElement(By.id("select-source")).click();
			Thread.sleep(2000);
	        driver.findElement(By.xpath(xpathDestinnation)).click();
	        Thread.sleep(3000);
	        driver.findElement(By.id("select-dataSourceTypeId")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(xpathAzureDataLake)).click();
	      // For Destination Fields
	        boolean subscriptionId = driver.findElement(By.id("select-subscriptionId")).isDisplayed();
	        Assert.assertEquals(subscriptionId, true,"Subscription Name Field is not Displaying");
	        test.log(LogStatus.PASS,"Destination Components","Subscription Name Field is Displaying");
	        
	        boolean name = driver.findElement(By.id("Name")).isDisplayed();
	        Assert.assertEquals(name, true,"Name Field is  not displaying!!");
	        test.log(LogStatus.PASS,"Destination Components","Name Field is Displaying");
	         
	        boolean description = driver.findElement(By.id("Description")).isDisplayed();
	        Assert.assertEquals(description,true,"Description Field is not Dispalying");
	        test.log(LogStatus.PASS,"Destination Components","Description Field is Displaying");
	       Thread.sleep(1000);
	        boolean dataLakeStoreUri = driver.findElement(By.id("DataLakeStoreUri")).isDisplayed();
	        Assert.assertEquals(dataLakeStoreUri,true,"dataLakeStoreUri Field is not Dispalying");
	        test.log(LogStatus.PASS,"Destination Components","dataLakeStoreUri Field is Displaying");
	       
	       
	       
	        
	        driver.findElement(By.xpath(xpathSubmit)).click();
	    
	  
	        String alertonName = driver.findElement(By.xpath(xpathAlertonName)).getText();
	        Assert.assertEquals(alertonName,"Name cannot be empty","alertonName  is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertonName Field is Displaying");
	        
	        
	        String alertOnDatalakeUri = driver.findElement(By.xpath(xpathAlertOnDatalakeUri)).getText();
	        Assert.assertEquals(alertOnDatalakeUri,"DataLakeStoreUri cannot be empty","alertOnDatalakeUri  is not Dispalying");
	        test.log(LogStatus.PASS,"Alert","alertOnDatalakeUri is Displaying");
	       }
		   @Test(priority =  15, dependsOnMethods = {"verifyValidationsForDestination"},groups = { "Smoke" })
	       public static void verifyAddDestination() throws InterruptedException 
	       {	 
			 
			 boolean status=false;
			 test = report.startTest("Verify Add Destination"); 	
			 driver.navigate().refresh();
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
			 driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","NameD", 2));
			 driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","Description",2));
			 driver.findElement(By.id("DataLakeStoreUri")).sendKeys(reader.getCellData("Storage&Service","DataStorage", 2));
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSubmit)).click();
			 Thread.sleep(1000);
			 String cnfrmBox = driver.findElement(By.xpath(xpathaddupdate)).getText();
			 Assert.assertEquals(cnfrmBox,"Add/Update","Add/Update is displaying on confirmation box");
			 test.log(LogStatus.PASS, "Confirmation box ","Add/Update is displaying on confirmation box");
			 
		
			 String confrmationtext = driver.findElement(By.xpath(xpathConfirmationtext)).getText();	
			 Assert.assertEquals(confrmationtext,"Are you sure you want to Submit this entry?","Are you sure you want to Submit this entry? is displaying");
			 test.log(LogStatus.PASS,"Confirmation box "," 'Are you sure you want to Submit this entry?' is displaying");
			 
			 
			 Thread.sleep(1000);
	        
			 
			 driver.findElement(By.xpath(xpathYesbtn)).click();
			 driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
				
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

		 @Test(priority = 16, dependsOnMethods = { "verifyAddDestination" },groups = { "Smoke" })
         public static void verifySourceAdd() throws InterruptedException 
       {    
	        boolean status=false;
	        test = report.startTest("Verify Add Source");
	
	        driver.navigate().refresh();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath(xpathDataSourcePageLink)).click();
	        driver.findElement(By.id("select-source")).click();
	        driver.findElement(By.xpath(xpathSource)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.id("select-dataSourceTypeId")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(xpathOnPremiseSql)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.id("select-subscriptionId")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='"+reader.getCellData("Storage&Service","Subscription",2)+"']")).click();
	 //driver.findElement(By.xpath("//*[@id='menu-subscriptionId']//li[text()='Dev']")).click();

	 Thread.sleep(1000);
	 driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Storage&Service","Name", 2));
	 Thread.sleep(1000);
	 driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Storage&Service","Description", 2));
	 Thread.sleep(1000);
	 driver.findElement(By.id("UserName")).sendKeys(reader.getCellData("Storage&Service", "UserName", 2));
	 Thread.sleep(1000);
	 
	 driver.findElement(By.id("select-33")).click();
     Thread.sleep(1000);
     if(driver.findElement(By.xpath(xpathPriyankaSystemKey)).isDisplayed())
     {
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
     driver.findElement(By.xpath(xpathSubmitclick)).click();
     Thread.sleep(3000);
     
     driver.findElement(By.xpath(xpathYesBtnn)).click();
     
     WebDriverWait wait = new WebDriverWait(driver,60);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
     // click on the compose button as soon as the "compose" button is visible
     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
     Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
     test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
     Thread.sleep(2000);}
     else
     {
	  driver.findElement(By.xpath(xpathSecureKey)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.name("secretKey")).sendKeys(reader.getCellData("Storage&Service","SecretKey",2));
	 Thread.sleep(1000);
	 driver.findElement(By.name("secretValue")).sendKeys(reader.getCellData("Storage&Service","Secretvalue" ,2));
	 Thread.sleep(1000);
	 driver.findElement(By.xpath(xpathSubmitKey)).click();
	 Thread.sleep(1000);
	 driver.findElement(By.id("DbserverName")).sendKeys(reader.getCellData("Storage&Service","DBServerName", 2));
	 Thread.sleep(1000);
	 driver.findElement(By.id("Dbname")).sendKeys(reader.getCellData("Storage&Service", "DBName", 2));
	 Thread.sleep(1000);
	 driver.findElement(By.id("select-37")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id='menu-37']/div//li[text()='"+reader.getCellData("Storage&Service", "IntegrationRunTime", 2)+"']")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.id("ResourceGroupName")).sendKeys(reader.getCellData("Storage&Service","ResourceGroupName", 2));
	 driver.findElement(By.xpath(xpathSubmit)).click();
	 //Thread.sleep(3000);
     WebDriverWait wait = new WebDriverWait(driver,60);
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(toasterRecordSaved)));
     // click on the compose button as soon as the "compose" button is visible
	 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		
	 Assert.assertEquals(toaster,"Service/Storage added successfully!","Service/Storage  is not added succesfully ");
	 test.log(LogStatus.PASS, "add Service/Storage ", "Service/Storage  is added Successfully Toaster message is displaying");
	 Thread.sleep(1000);
	 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
 	 System.out.println();
	 Thread.sleep(1000);
 	 for(int i=1;i<=numberOfRecords;i++)
 	  {
 		   
         if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[1]")).getText().equals(reader.getCellData("Storage&Service", "Name", 2))&&
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
}
	@Test(priority = 17, dependsOnMethods = { "verifySourceAdd" },groups = { "Smoke" })
    public static void verifyReadBlob() throws InterruptedException, URISyntaxException, StorageException, InvalidKeyException 
    { 
		 test = report.startTest("Verify Created Blob");
		
	 TimeUnit.MINUTES.sleep(2);
    	 String storageConnectionString ="DefaultEndpointsProtocol=http;" +"AccountName=cb0oanfb2ihritaicfgsa;" +"AccountKey=2QC18Yh+kYU1QM47dlq+kSDLUNS8Lpy5qc8HQO1j8cUB/VwuBwQxcl7vB+cSke5IGlhAJwZqqBTMPN60mB5dfw==";
    	
    	 
		 DateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		 DateFormat day = new SimpleDateFormat("dd");
		 Date date = new Date();
			
    	 try
			 {
				 CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
				 CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
			     CloudBlobContainer container = blobClient.getContainerReference("schema");
			    // CloudBlockBlob st = container.getBlockBlobReference("metadata/source/cloudblazedb/201907/29/metadata.txt");
			     String Src = reader.getCellData("Storage&Service", "Name", 2);
			     Thread.sleep(2000);
                 CloudBlockBlob st = container.getBlockBlobReference("metadata/"+Src+"/cloudblazedb/"+dateFormat.format(date)+"/"+day.format(date)+"/metadata.txt");
               
                 if( st.exists() )
                 {
                	 System.out.println("Blob File Created");
                	 test.log(LogStatus.PASS, "Blob File Created");
                 }
                else
                 {
                	System.out.println("Blob File is empty ");
                	test.log(LogStatus.FAIL, "Blob File is empty ");
                 }
			 }	 
			 
	 catch (Exception e)
			 {
			     //Output the stack trace.
			   e.printStackTrace();
			 }
			 
			     }
    
	@Test(priority = 18,dependsOnMethods = { "verifyReadBlob" }, groups = { "Smoke" })
   
	 public static String GetAzureToken() throws InterruptedException 
			 {
		try {
			AuthenticationContext context = new AuthenticationContext("https://login.windows.net/75d882a4-ad3a-4376-a4aa-0a65afef99d2",false,Executors.newFixedThreadPool(1));
			
			ClientCredential cd=new ClientCredential("7493db8d-2b3e-4b43-a02e-5f8ec31ddadf","+aLJ8PY2yIk0e/RflXGNY5UYakx40BJIiwo109cTwbE=");
			AuthenticationResult result = context.acquireToken("https://management.azure.com/", cd, null).get();

			return result.getAccessToken();
		
		}   
		    catch (Exception e) {
			e.printStackTrace();
		}
		return "";
			 }
			 
	
	@Test(priority = 19,groups = { "Smoke" })
    public static  void sendGetrequest() throws Exception {
		 test = report.startTest("Verify Send Request");
		  String USER_AGENT = "Mozilla/5.0";
			String url = "https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/pipelines/"+reader.getCellData("Storage&Service", "Name", 2)+"_metadataextractor?api-version=2018-06-01";
			//String url = "http://www.google.com/search?q=mkyong";
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
			//add request header
			con.setRequestProperty("User-Agent", USER_AGENT);
		    String message = con.getResponseMessage();
		    
		    
		    System.out.println("Message For Sendget requesst is : "+message);
		    test.log(LogStatus.PASS, "Message For Sendget requesst is ",message);
			int responseCode = con.getResponseCode();
			System.out.println("Sending 'GET' request to URL : " + url);
			test.log(LogStatus.PASS, "Sending 'GET' request to URL  ",url);
			System.out.println("Response Code is  : " + responseCode);
	        BufferedReader in = new BufferedReader(
			new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			//print result
			System.out.println(response.toString());

		 }
	    @Test(priority = 20, dependsOnMethods = { "sendGetrequest" },groups = { "Smoke" })

	    public static void sendingPostRequest() throws Exception 
	    {
	    test = report.startTest("Verify Status of pipeline");
	    String url = "https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/queryPipelineRuns?api-version=2018-06-01";
	    
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection)
	    obj.openConnection();
	    // Setting basic post request
	    con.setRequestMethod("POST");
	    con.setRequestProperty("User-Agent", "Mozilla/5.0");
	    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
	    con.setRequestProperty("Content-Type","application/json");
	    con.setRequestProperty("Authorization", "Bearer " + GetAzureToken());
	    String postJsonData = "{'lastUpdatedAfter': '2019-08-1T00:36:44.3345758Z','lastUpdatedBefore': '2019-08-2T00:49:48.3686473Z','filters': [{'operand': 'PipelineName','operator': 'Equals','values': ['"+reader.getCellData("Storage&Service", "Name", 2)+"_metadataextractor']}]}";
	   //String postJsonData = "{'lastUpdatedAfter': '2019-07-31T00:36:44.3345758Z','lastUpdatedBefore': '2019-08-1T00:49:48.3686473Z','filters': [{'operand': 'PipelineName','operator': 'Equals','values': ['sourceauto123_metadataextractor']}]}";
	    // Send post request
	    con.setDoOutput(true);
	    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	    wr.writeBytes(postJsonData);
	    wr.flush();
	    wr.close();
	  
	    int responseCode = con.getResponseCode();
	    System.out.println("Sending 'POST' request to URL : " + url);
	    test.log(LogStatus.PASS, "Sending 'POST' request to URL  ",url);
	    System.out.println("Post Data : " + postJsonData);
	    test.log(LogStatus.PASS, "Post Data :' request to URL  ",url);
	    System.out.println("Response Code : " + responseCode);
	   
	    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    String output;
	    StringBuffer response = new StringBuffer();
	  
	    while ((output = in.readLine()) != null) 
	    {
	     response.append(output);
	    }
	    in.close();
	    //printing result from response
	  
	   System.out.println("Status of all pipelines"+response.toString());
	   
	   //JSONObject jsonObject = new JSONObject(response.toString());
		org.json.JSONObject jsonObject =  new org.json.JSONObject(response.toString());
		JSONArray array = jsonObject.getJSONArray("value");
		System.out.println("length"+array.length());
		for (int i = 0; i < array.length(); i++) 
		{
			    System.out.println(array.get(i));
				org.json.JSONObject object = array.getJSONObject(i);
				System.out.println("Run Id Of Pipeline "+object.getString("runId"));
				System.out.println("Status Of Pipeline "+object.getString("status"));
				org.json.JSONObject object2 = object.getJSONObject("parameters");
			    System.out.println("Data_source_Name =>"+object2.getString("data_source_name"));
		
			
      }}
	    
	    @Test(priority = 21, dependsOnMethods = { "sendingPostRequest" },groups = { "Smoke" })

	    public static void deleteSource() throws Exception
	    { 
	    	
	    	test = report.startTest("Verify Delete record and Delete pipeline");
	    	//driver.findElement(By.xpath("//*[@id='root']/div/div/main/div[2]/div[9]/div/table/tbody/tr[1]/td[6]/a[2]")).click();
	    	driver.findElement(By.xpath(xpathDeleteRecord)).click();
	    	Thread.sleep(1000);
	    	
	    	//driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[3]/button[1]")).click();
	    	driver.findElement(By.xpath(xpathYesButton)).click();
	    	Thread.sleep(1000);
	    //	String toaster = driver.findElement(By.id("message-id")).getText();
    		
    		//Assert.assertEquals(toaster,"Service/Storage deleted successfully!","Service/Storage is not Deleted succesfully ");
    	   // test.log(LogStatus.PASS, "Delete Record", "Service/Storage is Deleted Successfully Toaster message is displaying");
    	  //  Thread.sleep(1000);
    	 
	}
	    

		@Test(priority = 22, dependsOnMethods = { "deleteSource"},groups = { "Smoke" })
	    public static  void PipelineDeleted() throws Exception {
			
			Thread.sleep(2000);
			
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			  String url = "https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/pipelines/"+reader.getCellData("Storage&Service", "Name", 2)+"_metadataextractor?api-version=2018-06-01";
			 
			 // String urlLS=" https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/sourceauto12345678_sqlserver_5?api-version=2018-06-01";
			  URL objLS = new URL(url);
				HttpURLConnection conLS = (HttpURLConnection) objLS.openConnection();
				conLS.setRequestMethod("GET");
				conLS.setRequestProperty("Content-Type", "application/json");
				conLS.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
				//add request header
				conLS.setRequestProperty("User-Agent", USER_AGENT);
			    String messageLSs = conLS.getResponseMessage();
			    System.out.println("Message For Sendget requesst is Pipeline : "+messageLSs);
			 	int responseCodeLS = conLS.getResponseCode();
			 	System.out.println("Sending 'GET' request to URL  Pipeline : " + url);
			 	System.out.println("Response Code For Pipeline  : " + responseCodeLS);
			
			
		}
		
		@Test(priority =23, dependsOnMethods = { "deleteSource"},groups = { "Smoke" })
	    public static  void sendGetLS() throws Exception {
			Thread.sleep(2000);
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			  String urlLS="https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/"+reader.getCellData("Storage&Service", "Name", 2)+"_sqlserver_5?api-version=2018-06-01";
			 // String urlLS=" https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/sourceauto12345678_sqlserver_5?api-version=2018-06-01";
			  URL objLS = new URL(urlLS);
				HttpURLConnection conLS = (HttpURLConnection) objLS.openConnection();
				conLS.setRequestMethod("GET");
				conLS.setRequestProperty("Content-Type", "application/json");
				conLS.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
				//add request header
				conLS.setRequestProperty("User-Agent", USER_AGENT);
			    String messageLSs = conLS.getResponseMessage();
			    System.out.println("Message For Sendget requesst is LS : "+messageLSs);
			 	int responseCodeLS = conLS.getResponseCode();
			 	System.out.println("Sending 'GET' request to URL  LS : " + urlLS);
			 	System.out.println("Response Code For LS  : " + responseCodeLS);
	     }
		
		

		@Test(priority = 24, dependsOnMethods = { "sendGetLS"},groups = { "Smoke" })
	    public static  void sendGetDS() throws Exception 
		
		{
		
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			 // String urlLS="https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/"+reader.getCellData("Storage&Service", "Name", 2)+"_sqlserver_5/?api-version=2018-06-01";
			  String urlLS="https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/datasets/"+reader.getCellData("Storage&Service", "Name", 2)+"_sqlserver_5?api-version=2018-06-01";
			  // String urlLS=" https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/linkedservices/sourceauto12345678_sqlserver_5?api-version=2018-06-01";
			  URL objLS = new URL(urlLS);
				HttpURLConnection conLS = (HttpURLConnection) objLS.openConnection();
				conLS.setRequestMethod("GET");
				conLS.setRequestProperty("Content-Type", "application/json");
				conLS.setRequestProperty("Authorization", "Bearer " + GetAzureToken()); 
				//add request header
				conLS.setRequestProperty("User-Agent", USER_AGENT);
			    String messageLSs = conLS.getResponseMessage();
			    System.out.println("Message For Sendget requesst is DataSet : "+messageLSs);
			    test.log(LogStatus.PASS, "Message For Sendget requesst is DataSet :  ",messageLSs);
			 	int responseCodeLS = conLS.getResponseCode();
			 	System.out.println("Sending 'GET' request to URL  DataSet : " + urlLS);
			 	test.log(LogStatus.PASS, "Sending 'GET' request to URL  DataSet : ",urlLS);
			 	System.out.println("Response Code For DataSet  : " + responseCodeLS);
			 	
	     }
		
		
}
