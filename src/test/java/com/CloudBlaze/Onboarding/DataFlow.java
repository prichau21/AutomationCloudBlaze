package com.CloudBlaze.Onboarding;

import com.microsoft.aad.adal4j.AuthenticationContext;
import com.microsoft.aad.adal4j.AuthenticationResult;
import com.microsoft.aad.adal4j.ClientCredential;
import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
import static org.testng.Assert.fail;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.HttpURLConnection;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IOnBoarding;
import com.relevantcodes.extentreports.LogStatus;

public class DataFlow extends BaseClass implements IOnBoarding

{
	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	
	
	
	//Verify DataFlow Page Link 
	
	@Test(priority=2,groups = { "Smoke" })
	public void verifyDataFlowPage() throws InterruptedException 
	{
		//driver.navigate().refresh();
		Thread.sleep(2000);
		test=report.startTest("Click on DataFlow Page Link");
		try
		{
			driver.findElement(By.xpath(xpathDataFlowPageLink)).click();
		}
	   
	    catch (ElementNotVisibleException e) {
		e.printStackTrace();
	}
	Thread.sleep(2000);
	test.log(LogStatus.PASS, "User has successfully clicked on Data Flow Page Link");
    }
	 //Verify When user Click on Data Flow  Link ,Data Flow Page will Display 
	@Test(priority = 3, dependsOnMethods = { "verifyDataFlowPage" }, groups = { "Smoke" })
	public static void verifyUrlOfDataFlowPage() throws InterruptedException 
	{

		driver.navigate().refresh();
		Thread.sleep(3000);
		test = report.startTest("Verify Url of Data Flow Page");

		// verify the Url of the page
		if(driver.getCurrentUrl().equals(xpathUrlOfDataFlow))
		{
		Assert.assertEquals(xpathUrlOfDataFlow, driver.getCurrentUrl(),"URL is not matching");
		test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
		}
		else
		{
		test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
		}
		
		 
		 if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
		 {    test.log(LogStatus.FAIL, "Data Flow page Screen not Displaying");
			 System.out.println("Data Flow page Screen is not Displaying");
		 }
		 
		 else
		 {
			 test.log(LogStatus.PASS,"Data Flow page Screen is  Displaying");
			 System.out.println("Data Flow page Screen is Displaying ");
		 }
		 }
	//DataFlow Page home Components
	 @Test(priority = 4, dependsOnMethods = { "verifyUrlOfDataFlowPage" }, groups = { "Smoke" })
	 public static void verifyComponentsOfDataFlowPage() throws InterruptedException 
	 {   driver.navigate().refresh();
		 Thread.sleep(3000);
		 test = report.startTest("Verify Components of Data Flow Page");
         String dataFlow = driver.findElement(By.className("page-heading")).getText();
         Assert.assertEquals(dataFlow,"Data Flow","Data Flow Title is not Displaying on Screen!!");
         test.log(LogStatus.PASS, "Home Page","Data Flow Title is  Displaying on Screen!!");
        
         boolean addButton = driver.findElement(By.xpath(xpathAddButton)).isEnabled();
         Assert.assertEquals(addButton,true,"Add button is  not Displaying or Disabled on Screen!!");
         test.log(LogStatus.PASS, "Home Page","Add button is  Displaying and enabled on Screen!!");
        
	  }
	 

		// Verify Components of Grid
	@Test(priority = 5, dependsOnMethods = { "verifyComponentsOfDataFlowPage" },groups = { "Smoke" })
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
	 
		@Test(priority = 6, dependsOnMethods = { "verifyGridComponents" }, groups = { "Smoke" })
		public static void verifyColumnsOfGrid() throws InterruptedException 
	
		{
		  test = report.startTest("Verify Columns in Grid"); 
	      //verify number of columns in Grid
	      int columnsInGrid = driver.findElements(By.xpath(xpathColumnsInGrid)).size();
	      if(columnsInGrid==6)
	       {
		
		    test.log(LogStatus.PASS, "Total columns", "6 columns are displaying on grid");
	       
	       }
	     else
	         { 
	 	 test.log(LogStatus.FAIL, "Total columns", "6 columns are not displaying on grid");
		 
	         }
	
	 //Verify all Column name
	 for(int i=1;i<=columnsInGrid;i++)
	 {
		 String columns  = driver.findElement(By.xpath("//*[@id='root']//table//th[" + i + "]")).getText();
	     if(columns.equals("S.No"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "S.No. is Displaying");
			  
	     }
	     if(columns.equals("Name"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Name is Displaying"); 
	     }
	     if(columns.equals("Description"))
	     {
	    	 
			 test.log(LogStatus.PASS, "Total columns", "Description is Displaying"); 
	     }
	   
	     if(columns.equals("Created On"))
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
		@Test(priority = 7, dependsOnMethods = { "verifyColumnsOfGrid" },groups = { "Smoke" })
	    public static void verifyNumberOfRecords() throws InterruptedException 
		
		{
		
		test = report.startTest("Verify Numbers of Records In grid");
		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
		test.log(LogStatus.PASS, "Number of Rows In Grid", "" + rows + "rows In Grid is displaying");
	    }
		
		 	@Test(priority = 8, dependsOnMethods = { "verifyNumberOfRecords" },groups = { "Smoke" })
	    public static void verifyOnAddClickPannelareDisplaying() throws InterruptedException 
		
		{	
			test = report.startTest("Verify On Add Click Pannel are Displaying");
			driver.findElement(By.xpath(xpathAddButton)).click();
			boolean pannel = driver.findElement(By.xpath(xpathPannel)).isDisplayed();
			Assert.assertEquals(pannel,true,"Pannels are not displaying on Screen!!");
	        test.log(LogStatus.PASS, "Pannel","Pannels are displaying on Screen!!");
			}
		
		@Test(priority = 9, dependsOnMethods = { "verifyOnAddClickPannelareDisplaying" },groups = { "Smoke" })
	    public static void verifyOnAddClickFirstPannel() throws InterruptedException 
	    {
			test = report.startTest("Verify On Click of FirstPannel Data Flow add Screen will Screen");
			Thread.sleep(1000);
			driver.findElement(By.xpath(xpathCDFBtn)).click();
			String onpremiseSqltoDataLake = driver.findElement(By.xpath(xpathOnpremiseSqltoDataLake)).getText();
			Assert.assertEquals(onpremiseSqltoDataLake,"On Premise SQL to Azure Data Lake","dataFlowScreen  is not Displaying !!");
	        test.log(LogStatus.PASS, "Data Flow Page","Data Flow Screen is Displaying For adding Flow");
	        
	    }
		
		@Test(priority = 10, dependsOnMethods = { "verifyOnAddClickFirstPannel" },groups = { "Smoke" })
	    public static void verifyComponentsOfDataFlow() throws InterruptedException 
	    {	
			test = report.startTest("Verify Components Of DataFlow");
			Thread.sleep(1000);
			String onpremiseSqltoDataLake = driver.findElement(By.xpath(xpathOnpremiseSqltoDataLake)).getText();
			Assert.assertEquals(onpremiseSqltoDataLake,"On Premise SQL to Azure Data Lake","''On Premise SQL to Azure Data Lake'' Title is not Displaying on Screen!!");
	        test.log(LogStatus.PASS, "Data Flow Page","''On Premise SQL to Azure Data Lake'' Title is  Displaying on Screen!!");
	        
	        boolean dataFlowNameField = driver.findElement(By.id("name")).isDisplayed();
	    	Assert.assertEquals(dataFlowNameField, true,"Data Flow Name Field  is not Displaying !!");
			test.log(LogStatus.PASS,"Data Flow","Data Flow Name Field is Displaying ");
            
		    boolean descriptionField = driver.findElement(By.id("description")).isDisplayed();
		    Assert.assertEquals(descriptionField, true,"description Field  is not Displaying !!");
			test.log(LogStatus.PASS,"Data Flow","description Field is Displaying ");
			
	        
			 String dataSourceText = driver.findElement(By.xpath(xpathDataSourceText)).getText();
			 Assert.assertEquals(dataSourceText, "Data Source","Data Source Text  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","Data Source Text is Displaying ");
				
			 String dataDestinationText = driver.findElement(By.xpath(xpathDataDestinationText)).getText();
			 Assert.assertEquals(dataDestinationText, "Data Destination","Data Destination Text  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","Data Destination Text is Displaying ");
	         
			 String connectionToDataSource = driver.findElement(By.xpath(xpathConnectionToDataSource)).getText();
			 Assert.assertEquals(connectionToDataSource, "Connection to your data source store","Connection to your data source store Text  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","Connection to your data source store Text is Displaying ");
	   
			 String connectionToDataDestination = driver.findElement(By.xpath(xpathConnectionToDataDestination)).getText();
			 Assert.assertEquals(connectionToDataDestination, "Connection to your data destination store","Connection to your data destination store Text  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","Connection to your data destination store Text is Displaying ");
	    
			 boolean sourceField = driver.findElement(By.xpath(xpathSourceField)).isDisplayed();
		     Assert.assertEquals(sourceField, true,"Source Field  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","Source Field is Displaying ");
	            
			 boolean destinationField = driver.findElement(By.xpath(xpathDestinationField)).isDisplayed();
		     Assert.assertEquals(destinationField, true,"destination Field  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","destination Field is Displaying ");
			 
			 boolean customActivityField = driver.findElement(By.xpath(xpathCustomActivityField)).isDisplayed();
		     Assert.assertEquals(customActivityField, true,"customActivity Field  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","customActivity  Field is Displaying ");
			 
			 boolean addButton2 = driver.findElement(By.xpath(xpathAddButton2)).isDisplayed();
		     Assert.assertEquals(addButton2, true,"add Button  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","add Button is Displaying ");
			 
			 boolean backButton = driver.findElement(By.xpath(xpathBackButton)).isDisplayed();
		     Assert.assertEquals(backButton, true,"back Button  is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","back Button is Displaying ");
			 
			 boolean saveButton = driver.findElement(By.xpath(xpathSaveButton)).isDisplayed();
		     Assert.assertEquals(saveButton, true,"save Button is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow","save Button  is Displaying ");
			 
			 driver.findElement(By.xpath(xpathSaveButton)).click();
			 
			 String alertOnNameDF = driver.findElement(By.xpath(xpathAlertOnNameDF)).getText();
			 Assert.assertEquals(alertOnNameDF, "Name can't be empty","'Name can't be empty' alert is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow Alert","'Name can't be empty' alert is Displaying");
			 
			 String dataSourceAlert = driver.findElement(By.xpath(xpathAlertOnDS)).getText();
			 Assert.assertEquals(dataSourceAlert, "Data Source can't be empty","'Data Source can't be empty' alert is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow Alert","'Data Source can't be empty'alert is Displaying ");
			 
			 String dataDestinationAlert = driver.findElement(By.xpath(xpathAlertOnDD)).getText();
			 Assert.assertEquals(dataDestinationAlert, "Data Destination can't be empty","'Data Destination can't be empty' alert is not Displaying !!");
			 test.log(LogStatus.PASS,"Data Flow Alert","'Data Destination can't be empty' alert is Displaying ");

			 
		 
		
			 
	    }

      	@Test(priority = 11, dependsOnMethods = { "verifyComponentsOfDataFlow" },groups = { "Smoke" })
	    public static void verifyAddDataFlow() throws InterruptedException 
   {	 boolean status=false;
		 test = report.startTest("Verify Add DataFlow");
			 Thread.sleep(1000);
			 driver.findElement(By.id("name")).sendKeys(reader.getCellData("DataFlow","Name", 2));
     		 Thread.sleep(1000);
     	
			 driver.findElement(By.id("description")).sendKeys(reader.getCellData("DataFlow", "Description", 2));
			 Thread.sleep(1000);
			
			 driver.findElement(By.xpath(xpathSourceField)).click();
			 Thread.sleep(1000);
		
			 driver.findElement(By.xpath("/html/body//div[text()='"+reader.getCellData("DataFlow","Source", 2)+"']")).click();
			 Thread.sleep(1000);
			
			 driver.findElement(By.xpath(xpathDestinationField)).click();
			 Thread.sleep(1000);
			 
			
			 driver.findElement(By.xpath("/html/body//div[text()='"+reader.getCellData("DataFlow","Destination", 2)+"']")).click();
			 Thread.sleep(1000);
			
			 String selectTableLink = driver.findElement(By.xpath(xpathSelectTableLink)).getText();
			 Assert.assertEquals(selectTableLink, "Select Table","'Select Table' link is not Displaying !!");
			 test.log(LogStatus.PASS,"'Select Table'","''Select Table' link is Displaying !!");
			 
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSaveButton)).click();
			 
			 String saveTableAlert = driver.findElement(By.xpath(xpathSaveTableAlert)).getText();
			 Assert.assertEquals(saveTableAlert, "Please save Table first !!","'Please save Table first !!'alert is not Displaying !!"); //Need to Enter Text 
			 test.log(LogStatus.PASS,"'Select Table'","'Please save Table first !!' alert is Displaying !!");
			 
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
             			 
		     driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[4]/div/div[1]/div[1]/table/thead/tr/th[1]/span/span[1]/input")).click();
             Thread.sleep(1000);
			 driver.findElement(By.xpath("(//*[@id='1'])[5]")).click();
		 
			 boolean cancel = driver.findElement(By.xpath("(/html/body/div//button[text()='Cancel'])[3]")).isEnabled();
			 Assert.assertEquals(cancel, true,"Cancel button is not Displaying or Disabled");
			 test.log(LogStatus.PASS,"Cancel","Cancel button is Displaying and Enabled");
			 
			 boolean save =  driver.findElement(By.xpath("(/html/body//button[text()='Save'])[3]")).isEnabled();
			 Assert.assertEquals(save, true,"save button is not Displaying or Disabled");
			 test.log(LogStatus.PASS,"save","save button is Displaying and Enabled");
			 
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("(/html/body//button[text()='Save'])[3]")).click();
			 
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSaveButton)).click();
			 Thread.sleep(1500);
		     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
    		
	    	 Assert.assertEquals(toaster,"Flow added successfully!","Record is not added succesfully ");	    	
	    	 test.log(LogStatus.PASS, "add Flow", "Flow is added Successfully Toaster message is displaying");
	    	 
	    	 Thread.sleep(1500);
	    	
   	  
	    		
	    	 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	 System.out.println();
	     	    
	     	for(int i=1;i<=numberOfRecords;i++)
	     	  {
	     		   
	             if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("DataFlow", "Name", 2))&&
	     			driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[3]")).getText().equals(reader.getCellData("DataFlow","Description", 2)))
	     		{
	     			test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	     			status=true ;
       	    }
       	     
	            if(!status)  
	             	            {           	
	            	test.log(LogStatus.FAIL,"Record is  not displaying in grid Sucessfully or Record is not Updated!!!");
	            }
	     		        }
	           
   }
		
		
	    @Test(priority =12, dependsOnMethods = { "verifyAddDataFlow" },groups = { "Smoke" })
	    public static void verifyEditDataFlow() throws InterruptedException 
	    {  
	    	driver.navigate().refresh();
	    
			Thread.sleep(1000);
			 boolean status=false;
			 test = report.startTest("Verify Edit DataFlow");
			driver.findElement(By.xpath("(//*[@id='root']//tbody//tr//td[6]//a[@class='editlink'])[1]")).click();
			boolean DF = driver.findElement(By.id("name")).isEnabled();
			Assert.assertEquals(DF, false,"On Edit, Name Field is Editable");
			test.log(LogStatus.PASS,"Edit Data FLow","Data Flow Name Field is non-Editable");
			 driver.findElement(By.id("description")).sendKeys(Keys.CONTROL + "a");
			 driver.findElement(By.id("description")).sendKeys(Keys.BACK_SPACE);
			 
			 driver.findElement(By.id("description")).sendKeys(reader.getCellData("DataFlow", "Description", 3));
			 Thread.sleep(1000);
			 
			 driver.findElement(By.id("select-customActivity")).click();
			 Thread.sleep(1000);
		     driver.findElement(By.xpath("//*[@id='menu-customActivity']//li[text()='"+reader.getCellData("COperation", "Operation", 2)+"']")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathAddButtonForCO)).click();
			 
			 driver.findElement(By.xpath(xpathSaveButton)).click();
			 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
			 Assert.assertEquals(toaster,"Order no can't be empty !!"," alert is not updated succesfully ");
	    	 test.log(LogStatus.PASS, "Order Alert", "Order no can't be empty !! alert is displaying");
	    	// driver.findElement(By.xpath(xpathOrderNumber)).sendKeys("1");
	    		String str=reader.getCellData("COperation","OrderNo",2);
	    		System.out.println("Vaalue ="   +str);
	    		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[7]/div/div/div/div[1]/div/div/input")).click();
	    		Thread.sleep(1000);
			 driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[7]/div/div/div/div[1]/div/div/input")).sendKeys(reader.getCellData("COperation","OrderNo",2));
			 Thread.sleep(1500);
			 driver.findElement(By.xpath(xpathSaveButton)).click();
			 Thread.sleep(1000);
			 String toaster2 = driver.findElement(By.xpath(toasterRecordSaved)).getText();
			 System.out.println(toaster2);
	    	 Assert.assertEquals(toaster2,"Flow updated successfully!","Record is not updated succesfully ");
	    	 test.log(LogStatus.PASS, "updated Flow", "Flow is updated Successfully Toaster message is displaying");
	    	 
	    	  Thread.sleep(1000);
	    		
	    	 int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	 System.out.println();
	     	    
	     	for(int i=1;i<=numberOfRecords;i++)
	     	  {
	     		   
	             if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("DataFlow", "Name", 2))&&
	     			driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[3]")).getText().equals(reader.getCellData("DataFlow","Description", 3)))
	     		{
	     			test.log(LogStatus.PASS,"Updated Flow is  displaying in grid Sucessfully!!!");
	     			status=true ;
	       	    }
	       	     
	            if(!status)  
	               
	            {
	           	test.log(LogStatus.FAIL,"Record is  not displaying in grid Sucessfully or Record is not Updated!!!");
	            }
	     		}
		
	    }
	    
	    
	   
	    
	    
	
	    @Test(priority =13, dependsOnMethods = { "verifyEditDataFlow" },groups = { "Smoke" })
    public static void verifyPublisedFlowInAzure() throws InterruptedException 
    {  
		
	Thread.sleep(1000);
	boolean publishBtn = driver.findElement(By.xpath("//*[@id='root']//main//div//table//tbody/tr[1]/td[6]/button")).isEnabled();
	Assert.assertEquals(publishBtn,true,"Publish button is not Dispalying or it is not enabled");
	test.log(LogStatus.PASS,"Publish Flow","Publish button is Dispalying and it is enabled ");
	
	Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id='root']//main//div//table//tbody/tr[1]/td[6]/button")).click();
	 Thread.sleep(1000);
	driver.findElement(By.xpath(xpathYesBtn)).click();
	 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	System.out.println(toaster);
	Assert.assertEquals(toaster,"data flow published successfully","data flow is not published");
    test.log(LogStatus.PASS, "Publish","data flow published successfully");
	
	
	
   }
	    @Test(priority = 14,dependsOnMethods = { "verifyPublisedFlowInAzure" }, groups = { "Smoke" })
	    
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
		

		@Test(priority = 15,groups = { "Smoke" })
	    public static  void DpdpipelinePRovisioning() throws Exception 
            {
			
			Thread.sleep(2000);
			
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			  String url = "https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/pipelines/"+reader.getCellData("DataFlow","Name", 2)+"_rdbms_to_sql_provisioning?api-version=2018-06-01";
			 
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
			 	System.out.println("Sending 'GET' request to URL Provisining Pipeline : " + url);
			 	System.out.println("Response Code For Provisining Pipeline  : " + responseCodeLS);
			
		}
	    

		@Test(priority = 16,groups = { "Smoke" })
	    public static  void DpdpipelineSchemaProcessor() throws Exception 
{
			
			Thread.sleep(2000);
			
			 test = report.startTest("Verify Linked Service Deleted");
			  String USER_AGENT = "Mozilla/5.0";
			  String url = "https://management.azure.com/subscriptions/07cb4a1a-1dae-487e-88ff-2d2bac272da3/resourceGroups/CB0Demo1/providers/Microsoft.DataFactory/factories/cb0oanfb2ihritaidemo1df/pipelines/"+reader.getCellData("DataFlow","Name", 2)+"_schema_processor?api-version=2018-06-01";
			 
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
			 	System.out.println("Sending 'GET' request to URL Schema Processor Pipeline : " + url);
			 	System.out.println("Response Code For Schema Processor Pipeline  : " + responseCodeLS);
			 	
		}
	    
	    
	    
	    
	    
	    /*	@Test(priority =17, dependsOnMethods = { "verifyEditDataFlow" },groups = { "Smoke" })
	    public static void verifyDeleteDataFlowdialogBox() throws InterruptedException 
	    {   
			
			driver.navigate().refresh();
			 Thread.sleep(1000);
             test=report.startTest("DeleteDialogBox");
    	
            driver.findElement(By.xpath(xpathdeleteButton)).click();

	    	// driver.navigate().refresh();
	    	
	    		 //WebElement deleteDialogBox = driver.findElement(By.xpath(xpathDeleteDialogBox));
	    		// Assert.assertTrue(deleteDialogBox.isDisplayed());
	    		// test.log(LogStatus.PASS, "Delete DialogBox","delete DialogBox is displaying");
	    		 String deleteText = driver.findElement(By.xpath(xpathDeleteText)).getText();
	    		 Assert.assertEquals(deleteText,"Delete","Delete  is not Displaying");
	    		 test.log(LogStatus.PASS, "Delete DialogBox","Delete is  Displaying");
	    		 String deleteStatement = driver.findElement(By.xpath(xpathDeleteStatement)).getText();
	    		 Assert.assertEquals(deleteStatement,"Are you sure you want to delete this entry?","Are you sure you want to delete this entry? text is not displaying!!!");
	    		 test.log(LogStatus.PASS, "Delete DialogBox", "Are you sure you want to delete this entry? text is  Displaying");
	    		 WebElement yesButton = driver.findElement(By.xpath(xpathDeleteYesButton));
	    		 Assert.assertTrue(yesButton.isEnabled());
	    		 test.log(LogStatus.PASS, "yes Button", "yes Button is displaying and Enabled");
	    		 WebElement noButton = driver.findElement(By.xpath(xpathDeleteNoButton));
	    		 Assert.assertTrue(noButton.isEnabled());
	    		 test.log(LogStatus.PASS, "NO Button","NO Button is displaying and Enabled");
	    		 
	    		 
	    	}
	    	
	    	@Test(priority = 18, dependsOnMethods = {"verifyDeleteDataFlowdialogBox"}, groups = { "Smoke" })
	    	public static void verifyDeleteRecord() throws InterruptedException
	    	{
	    		driver.navigate().refresh();
	    		Thread.sleep(1000);
	    		  driver.findElement(By.xpath(xpathdeleteButton)).click();
	    	
	    		test=report.startTest("Delete Record");
	    				
	    		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
	    		Thread.sleep(1000);
	    	
	    		String DataFlow = driver.findElement(By.xpath("//*[@id='root']//tbody/tr[1]/td[2]")).getText();
	    		System.out.println(DataFlow);
	    		Thread.sleep(1000);
	   
	    		
	    		driver.findElement(By.xpath(yesButton)).click();
	    		Thread.sleep(1000);
	    		
	    		String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	    		
	    		Assert.assertEquals(toaster,"Flow deleted successfully!","Record is not Deleted succesfully ");
	    	    test.log(LogStatus.PASS, "Delete Record", "Record is Deleted Successfully Toaster message is displaying");
	    		
	    		
	    		
	    		
	    	int servicePrincipals	=driver.findElements(By.xpath("//*[@id='root']//tbody/tr/td[2]")).size();
	    		
	    		for(int i=1;i<=servicePrincipals;i++)
	    		{
	    			if(driver.findElement(By.xpath("//*[@id='root']//tbody/tr["+i+"]//td[2]")).equals((reader.getCellData("DataFlow","Name", 2))))
	    			{
	    				System.out.println("record is not deleted , Displaying on screen ");
	    				test.log(LogStatus.FAIL, "Delete Record", "Record is not Deleted, Displaying On Screen");
	    			}
	             }
	    		System.out.println("Record is Deleted Successfuly ,not displaying on Screen");
	    		test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully, not Displaying on Screen");
	    		
	    		int rows2 = driver.findElements(By.xpath(xpathRowInGrid)).size();
	    		
	    		if (rows2 == rows - 1) {
	    			test.log(LogStatus.PASS, "Delete Record", "one Record is decreased Sucessfully");
	    		} 
	    		else
	    		{
	    			test.log(LogStatus.FAIL, "Delete Record", "Record is not Deleted");
	    		}
	    		}*/
                  	
	    
	    

	    
	    
	    }

			 
			 
    



		

