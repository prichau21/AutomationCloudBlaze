package com.Fullload_CDC;
//import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.CloudBlaze.Base.BaseClass;
import com.CloudBlaze.Base.ExcelUtils;
import com.CloudBlaze.PageObjects.IMonitoring;
import com.CloudBlaze.PageObjects.IOnBoarding;
//import com.mongodb.connection.Connection;
import com.relevantcodes.extentreports.LogStatus;

public class OracleToAdlsCDC extends ReuseFuntions implements IOnBoarding ,IMonitoring
{
static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
//Connection con = DriverManager.getConnection(URL, "userid", "password" );
	
		
     @Test(priority = 1,groups = { "Smoke" })
	     public static void verifySourceAdd() throws InterruptedException 
	   {    
	        
        	verifySourceOracle(9);
	   
	    } 
	 
	  
	    @Test(priority =  2, dependsOnMethods = {"verifySourceAdd"},groups = { "Smoke" })
	    public static void verifyAddDestination() throws InterruptedException 
	    {	 verifyDestinationADLS(9);
	        }
	
	 
		           @Test(priority = 3,dependsOnMethods = { "verifyAddDestination" }, groups = { "Smoke" })
	               public static void verifyAddDataFlow() throws InterruptedException 
	                 {    
			  
			   	      
					     test = report.startTest("Verify Add DataFlow");
						 Thread.sleep(3500);
						 driver.findElement(By.xpath(xpathDataFlowPageLink)).click();
						 Thread.sleep(3500);
					  	driver.findElement(By.xpath(xpathAddButton)).click();
						 Thread.sleep(3500);
			             driver.findElement(By.xpath(xpathOracletoadlsCreate)).click();
			             Thread.sleep(3500);
						 driver.findElement(By.id("name")).sendKeys(reader.getCellData("DataFlow","Name", 9));
			     		 Thread.sleep(4000);
			     	
						 driver.findElement(By.id("description")).sendKeys(reader.getCellData("DataFlow", "Description", 9));
						 Thread.sleep(4000);
						
						 driver.findElement(By.className("css-1hwfws3")).click();
						 Thread.sleep(3000);
						 driver.findElement(By.xpath("/html/body/div//form//div[text()='"+reader.getCellData("Storage&Service","Name", 9)+"']")).click();
						 Thread.sleep(2500);
						
						 driver.findElement(By.xpath(xpathAdlsDest)).click();						
						 Thread.sleep(1500);
						 driver.findElement(By.xpath("//html/body/div//form//div[text()='"+reader.getCellData("Storage&Service","NameD", 9)+"']")).click();
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
			             			 
			             driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[4]/div/div[1]/table/thead/tr/th[1]/span/span[1]/input")).click();//to uselect all tables
			             Thread.sleep(1000);
			             //driver.findElement(By.xpath("(/html/body/div//table/tbody/tr//td[2][text()='superstoresales'])[2]/preceding-sibling::td")).click();
			             driver.findElement(By.xpath("(/html/body/div//table/tbody/tr//td[2][text()='"+reader.getCellData("DataFlow","Tablename",9)+"'])[2]/preceding-sibling::td")).click();// to select store table
			             Thread.sleep(1000);

						 driver.findElement(By.xpath("((/html/body/div//table/tbody/tr//td[2][text()='"+reader.getCellData("DataFlow","Tablename",9)+"'])[2]/following-sibling::td)[1]//span")).click();// to on CDC option 
						 Thread.sleep(1000);
						 driver.findElement(By.xpath("((/html/body/div//table/tbody/tr//td[2][text()='"+reader.getCellData("DataFlow","Tablename",9)+"'])[2]/following-sibling::td)[2]//span")).click();//on track delete Record
						 Thread.sleep(1000);
                         driver.findElement(By.xpath("((/html/body/div//table/tbody/tr//td[2][text()='"+reader.getCellData("DataFlow","Tablename",9)+"'])[2]/following-sibling::td)[3]//span")).click();//on Do Cleansing
                         Thread.sleep(1000);
                         driver.findElement(By.xpath("((/html/body/div//table/tbody/tr//td[2][text()='"+reader.getCellData("DataFlow","Tablename",9)+"'])[2]/following-sibling::td)[4]//span")).click();//click on Schema Propogated
						 Thread.sleep(3000);
	                    // driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[4]/div/div[1]/div[1]/table/tbody/tr[10]/td[2]/button")).click(); // to click on [|] sign to see columns
			             driver.findElement(By.xpath("(/html/body/div//table/tbody/tr//td[2][text()='"+reader.getCellData("DataFlow","Tablename",9)+"'])[2]/child::button")).click();  // to click on [|] sign to see columns
						 Thread.sleep(1000);
			              
			             driver.findElement(By.name("22")).click();// select Incremental Column 
			             Thread.sleep(3000);
			              
			             driver.findElement(By.xpath("/html/body//div[4]//div[2]/div/button[text()='Save']")).click(); //save columns
						 boolean cancel = driver.findElement(By.xpath("(/html/body/div//button[text()='Cancel'])[3]")).isEnabled();
						 Assert.assertEquals(cancel, true,"Cancel button is not Displaying or Disabled");
						 test.log(LogStatus.PASS,"Cancel","Cancel button is Displaying and Enabled");
						 
						 boolean save =  driver.findElement(By.xpath("(/html/body//button[text()='Save'])[3]")).isEnabled();
						 Assert.assertEquals(save, true,"save button is not Displaying or Disabled");
						 test.log(LogStatus.PASS,"save","save button is Displaying and Enabled");
						
					     Thread.sleep(3000);
						 driver.findElement(By.xpath("(/html/body//button[text()='Save'])[3]")).click();
						 
						 Thread.sleep(1000);
						 driver.findElement(By.xpath(xpathSaveButton)).click();
						 Thread.sleep(1500);
					     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
			    		
				    	 Assert.assertEquals(toaster,"Flow added successfully!","Record is not added succesfully ");	    	
				    	 test.log(LogStatus.PASS, "add Flow", "Flow is added Successfully Toaster message is displaying");
				    	 driver.navigate().refresh();
				    	 
				    	 driver.findElement(By.xpath("//*[@id='root']/div//div[4]/table/tbody/tr[1]/td[7]/button[@title='Publish flow']")).click(); //publish Flow 
				    	 Thread.sleep(1000);
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
		        	  
		        	   
		        	   verifyScheduledFlowR(9 ,2);
		   		       
		   		       String connectionUrl =
		   	                "jdbc:sqlserver://cloudblazenewuiserver.database.windows.net:1433;"
		   	                + "database=CloudBlazeDBNewWorkingNotebook;"
		   	                + "user=cbadmin@cloudblazenewuiserver;"
		   	                + "password=Cblaze@123;"
		   	                + "encrypt=true;"
		   	                + "trustServerCertificate=true;"
		   	                + "hostNameInCertificate=*.database.windows.net;"
		   	                + "loginTimeout=30;";
		   		   
		   	        try (Connection connection = DriverManager.getConnection(connectionUrl);
		   	        Statement statement = connection.createStatement();) {

		   	        String selectSql = "update [Scheduling].[DataflowExeuctionCalendar] set currentsnapshotdate='2019-12-03'  where DataflowId=1824";//NEED TO ADD DATAFLOW ID AND DATE
		   	        statement.executeQuery(selectSql);

		   	        }
		   	        
		   	        catch (SQLException e)
		   	        {
		   	            e.printStackTrace();
		   	        }
		   	           
		            }
		   			
		          @Test(priority = 5,dependsOnMethods = { "verifyScheduledFlow" }, groups = { "Smoke" })
	               public static void verifyDataFlowOnMontioringScreen() throws InterruptedException  
	               {
		        	  verifyFlowMontioringScreen(9);
	               }
		        	    
		       	  
		       
 
             @Test(priority = 6,dependsOnMethods = { "verifyDataFlowOnMontioringScreen" },groups = { "Smoke" })
             public static void verifyDeleteScheduledFlow() throws InterruptedException  
            {   
	          test= report.startTest("ReSccheduling Flow");
	          driver.navigate().refresh();
	          Thread.sleep(2000);
	          driver.findElement(By.xpath(xpathDataFlowScheduled)).click();
	          Thread.sleep(1000);
	          driver.findElement(By.xpath("//*[@id='root']//div/table/tbody/tr[1]/td[2][text()='"+reader.getCellData("DataFlow","Name", 9)+"']/..//a[2]")).click();
	          Thread.sleep(1000);
	          driver.findElement(By.xpath(xpathYesButn)).click();
	          driver.findElement(By.id("select-dataflowname")).click();
		      Thread.sleep(1000);
			  driver.navigate().refresh();
			  Thread.sleep(1000);
			   
            }
    
    
            @Test(priority = 7, dependsOnMethods = { "verifyDeleteScheduledFlow" },groups = { "Smoke" })
	        public static void verifyRescheduled() throws InterruptedException  
	        { 
			    verifyScheduledFlowR(9 ,2);
				
				String connectionUrl =
	   	                "jdbc:sqlserver://cloudblazenewuiserver.database.windows.net:1433;"
	   	                + "database=CloudBlazeDBNewWorkingNotebook;"
	   	                + "user=cbadmin@cloudblazenewuiserver;"
	   	                + "password=Cblaze@123;"
	   	                + "encrypt=true;"
	   	                + "trustServerCertificate=true;"
	   	                + "hostNameInCertificate=*.database.windows.net;"
	   	                + "loginTimeout=30;";
				 try (Connection connection = DriverManager.getConnection(connectionUrl);
			   	         Statement statement = connection.createStatement();) {

			   	            
			   	            String selectSql = "update [Scheduling].[DataflowExeuctionCalendar] set currentsnapshotdate='2019-12-04'  where DataflowId=1824";//NEED TO ADD DATAFLOW ID AND DATE
			   	             statement.executeQuery(selectSql);

			   	           
			   	        }
			   	       
			   	        catch (SQLException e) {
			   	            e.printStackTrace();
			   	        }
			   		        
			   				
			   		  
        }
			   		 @Test(priority = 8,dependsOnMethods = { "verifyRescheduled" }, groups = { "Smoke" })
		               public static void verifyFlowOnMontioringScren() throws InterruptedException  
		               {  
			   			 verifyFlowMontioringScreen(9);
		               }
        }
			   		
		        
	      
	    
       
