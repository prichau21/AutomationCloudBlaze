package com.CloudBlaze.Onboarding;

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

public class CustomOperation extends BaseClass implements IOnBoarding 
    {
	
	static ExcelUtils reader = new ExcelUtils(System.getProperty("user.dir") + "/TestData/TestData.xlsx");
	 boolean status=false;
	
	@Test(priority=1, groups = { "Smoke" })
	public void VerifyLogin() throws InterruptedException
	{  test = report.startTest("login");

		driver.findElement(By.xpath("//*[@id='root']//button[text()='Login']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='i0116']")).sendKeys("priyanka.chauhan@rawcubes.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//*[@id='i0118']")).sendKeys("Sanju21@");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='idSIButton9']")).click();
	    Thread.sleep(1000);
	}
	//Verify Custom Operation Page Link 
	 @Test(priority=2 ,dependsOnMethods = { "VerifyLogin" },groups= { "Smoke" })
		public void verifyCustomOperationPage() throws InterruptedException 
		{
			driver.navigate().refresh();
			Thread.sleep(1000);
			test=report.startTest("Click on Custom Operation Link");
			try
			{
				driver.findElement(By.xpath(xpathCustomoperationLink)).click();
			}
		   
		    catch (ElementNotVisibleException e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "User has successfully clicked on Custom Operation Page Link");
	}
		 //Verify When user Click on Custom Operation  Link ,Custom Operation Page will Display 
		@Test(priority = 3, dependsOnMethods = { "verifyCustomOperationPage" },groups = { "Smoke" })
		public static void verifyUrlOfCustomOperationPage() throws InterruptedException 
		{

			//driver.navigate().refresh();
			Thread.sleep(3000);
			test = report.startTest("Verify Url of Custom Operation Page");

			// verify the Url of the page
			 if(driver.getCurrentUrl().equals(xpathUrlOfCustomOperation)) {
			Assert.assertEquals(xpathUrlOfCustomOperation, driver.getCurrentUrl(),"URL is not matching");
			test.log(LogStatus.PASS, "Page URL is Correct", driver.getCurrentUrl());
				}
			else {
			test.log(LogStatus.FAIL, "Page URL is something else", driver.getCurrentUrl());
			}
			 
			 
			 if(driver.findElement(By.xpath("//*[@id='root']")).getText().equals(""))
			 {    test.log(LogStatus.FAIL, "Custom Operation page Screen not Displaying");
				 System.out.println("Custom Operation page Screen is not Displaying");
			 }
			 
			 else
			 {
				 test.log(LogStatus.PASS,"Custom Operation page Screen is  Displaying");
				 System.out.println("Custom Operation page Screen is Displaying ");
			 }
             }
		
		
		@Test(priority = 4, dependsOnMethods = { "verifyUrlOfCustomOperationPage" },groups = { "Smoke" })
		public static void verifyCustomOperationComponents() throws InterruptedException 
		{
			test = report.startTest("Verify Components  of Custom Operation Page");
			
			String title = driver.findElement(By.xpath(xpathTitle)).getText();
			Assert.assertEquals(title,"Custom Operation","Custom Operation Title is not Displaying");
			test.log(LogStatus.PASS,"Title","Custom Operation Title is Displaying");
	        
			//Verify Select Type DropDown
			WebElement selectType = driver.findElement(By.xpath(xpathSelectType));
			Assert.assertTrue(selectType.isDisplayed());
			test.log(LogStatus.PASS,"Select Type Field","Select Type Field is displaying");
			
			
			
			Assert.assertEquals(driver.findElement(By.xpath(xpathSelecttypeWM)).getText(), "Select Type *", "Select Type * Placeaholder is not Displaying");
			test.log(LogStatus.PASS,"Select Type", "Select Type * Placeaholder is Displaying");
			

			Assert.assertEquals(driver.findElement(By.xpath(xpathSubmitButtonCO)).getText(),"Submit","Submit Button is not Displaying");
			test.log(LogStatus.PASS,"Button", "Submit Button is Displaying");
			
			Assert.assertEquals(driver.findElement(By.xpath(xpathCancelButtonCO)).getText(),"Cancel","Cancel Button is not Displaying");
			test.log(LogStatus.PASS,"Cancel", "Cancel Button is Displaying");
			
			
			// Verify and Validate Grid or contents Container
			WebElement gridOfCustOpr = driver.findElement(By.xpath(xpathOfGridOfCO));
			Assert.assertTrue(gridOfCustOpr.isDisplayed());
			test.log(LogStatus.PASS, "Grid Of Custom Operation", "Grid Of Custom Operation is displaying");

			
     }
		// Verify Components of Grid
		@Test(priority = 5, dependsOnMethods = { "verifyCustomOperationComponents" },groups = { "Smoke" })
		public static void verifyGridComponents() throws InterruptedException {

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
	      if(columnsInGrid==8)
	       {
		
		    test.log(LogStatus.PASS, "Total columns", "8 columns are displaying on grid");
	       
	       }
	     else
	         { 
	 	 test.log(LogStatus.FAIL, "Total columns", "8 columns are not displaying on grid");
		 
	         }
	
	 //Verify all Column name
	 for(int i=1;i<=columnsInGrid;i++)
	 {
		 String columns  = driver.findElement(By.xpath("//*[@id='root']//table//th[" + i + "]")).getText();
	     if(columns.equals("S.No."))
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
	    
	     if(columns.equals("Command"))
	    {
	    	
			 test.log(LogStatus.PASS, "Total columns", "Command is Displaying");  
	    }
	     if(columns.equals("Class Name"))
	     {
	    	
			 test.log(LogStatus.PASS, "Total columns", "Class Name is Displaying"); 
	     }
	     if(columns.equals("Folder Path"))
	     {
	     test.log(LogStatus.PASS, "Total columns", "Folder Path is Displaying"); 
	    	 
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
	    public static void verifyNumberOfRecords() throws InterruptedException {
		test = report.startTest("Verify Numbers of Records In grid");
		int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
		test.log(LogStatus.PASS, "Number of Rows In Grid", "" + rows + "rows In Grid is displaying");
	}
		@Test(priority = 8, dependsOnMethods = { "verifyNumberOfRecords" },groups = { "Smoke" })
		public static void verifyOnClickOfSubmitButtonAlertIsComing() throws InterruptedException 
		{ 
			// driver.navigate().refresh();
			 Thread.sleep(1000);
			 test = report.startTest("On Click Of Submit Button Alert Is Coming");
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(2000);
			 
			 
			 String alertOnSelectType = driver.findElement(By.xpath(alertOnSubmit)).getText();
	         Assert.assertEquals(alertOnSelectType,"Select type cannot be empty","Select type cannot be empty' alert is not Displaying ");
			 test.log(LogStatus.PASS, "Alert on Submit button", "Select type cannot be empty alert is Displaying");
             Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathCancelButtonCO)).click();
			 Thread.sleep(1500);
//			  String alert = driver.findElement(By.xpath(alertOnSubmit)).getText();
//			  boolean f = alert.isEmpty();
//			  System.out.println(f);
//			 Assert.assertEquals(alert,true,"On Click of Cancel Button Alert is not getting hide");
//			 test.log(LogStatus.PASS,"Alert is getting Hide","On Click of Cancel Button Alert is getting hide");
			 
		}
		@Test(priority = 9, dependsOnMethods = { "verifyOnClickOfSubmitButtonAlertIsComing" },groups = { "Smoke" })
		public static void verifyFieldsOfJar() throws InterruptedException 
		{
			
			 Thread.sleep(1000);
			 test = report.startTest("Verify fields Of Jar Type");
			 driver.findElement(By.xpath(xpathClickonType)).click();
			 driver.findElement(By.xpath(xpathSelectJar)).click();
			 String jar = driver.findElement(By.xpath(xpathjar)).getText();
			 Assert.assertEquals(jar,"Jar","Jar Type is not Displaying ");
			 test.log(LogStatus.PASS, "Jar Fields", "Jar Type is Displaying");
             Thread.sleep(1000);
			 boolean namej = driver.findElement(By.xpath(xpathNameJ)).isDisplayed();
			 Assert.assertEquals(namej, true,"Name Field is not Displaying!!");
			 test.log(LogStatus.PASS,"Jar Fields","Name Field is Displaying");
			 boolean descj = driver.findElement(By.xpath(xpathDescriptionJ)).isDisplayed();
			 Assert.assertEquals(descj, true,"Description Field is not Displaying!!");
			 test.log(LogStatus.PASS,"Jar Fields","Description Field is Displaying");
			 boolean classNamej = driver.findElement(By.xpath(xpathClassNameJ)).isDisplayed();
			 Assert.assertEquals(classNamej, true,"Class Name is not Displaying!!");
			 test.log(LogStatus.PASS,"Jar Fields","Class Name Field is Displaying");
			 boolean parameterj=driver.findElement(By.name("Parameters")).isDisplayed();
			 Assert.assertEquals(parameterj, true,"Add Parameter button  is not Displaying!!");
			 test.log(LogStatus.PASS,"Jar Fields","Add Parameter button is Displaying");
			 boolean appendLibraries=driver.findElement(By.name("AppendLibraries")).isDisplayed();
			 Assert.assertEquals(appendLibraries, true,"appendLibraries button  is not Displaying!!");
			 test.log(LogStatus.PASS,"Jar Fields","appendLibraries button is Displaying");
			 boolean submitBtn=driver.findElement(By.xpath(xpathSubmitButtonCO)).isDisplayed();
			 Assert.assertEquals(submitBtn, true,"submitBtn is not Displaying!!");
			 test.log(LogStatus.PASS,"Jar Fields","submitBtn is Displaying");
			 boolean cancelBtn=driver.findElement(By.xpath(xpathCancelButtonCO)).isDisplayed();
			 Assert.assertEquals(cancelBtn, true,"cancelBtn is not Displaying!!");
			 test.log(LogStatus.PASS,"Jar Fields","cancelBtn is Displaying");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(1000);
			 String nameAlert = driver.findElement(By.xpath(xpathnameAlert)).getText();
		     Assert.assertEquals(nameAlert,"Name cannot empty","'Name cannot empty' alert is not Displaying ");
			 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Name cannot empty' alert is Displaying");
             Thread.sleep(1000);
             String classnameAlert = driver.findElement(By.xpath(xpathClassnameAlert)).getText();
		     Assert.assertEquals(classnameAlert,"Class Name cannot empty","'Class Name cannot empty' alert is not Displaying ");
			 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Class Name cannot empty' alert is Displaying");
             Thread.sleep(1000);
             
             
		}
         @Test(priority = 10, dependsOnMethods = { "verifyFieldsOfJar" },groups = { "Smoke" })
         public static void verifyFieldsOfPython() throws InterruptedException 
         {
        	 Thread.sleep(1000);
			 test = report.startTest("Verify fields Of Python Type");
			 driver.findElement(By.xpath(xpathClickonType)).click();
			 driver.findElement(By.xpath(xpathSelectPython)).click();
			 String python = driver.findElement(By.xpath(xpathjar)).getText();
			 Assert.assertEquals(python,"Python","Python Type is not Displaying ");
			 test.log(LogStatus.PASS, "Python Fields", "Python Type is Displaying");
             Thread.sleep(1000);
             boolean namej = driver.findElement(By.xpath(xpathNameJ)).isDisplayed();
			 Assert.assertEquals(namej, true,"Name Field is not Displaying!!");
			 test.log(LogStatus.PASS,"Python Fields","Name Field is Displaying");
			 boolean descj = driver.findElement(By.xpath(xpathDescriptionJ)).isDisplayed();
			 Assert.assertEquals(descj, true,"Description Field is not Displaying!!");
			 test.log(LogStatus.PASS,"Python Fields","Description Field is Displaying");
			 boolean scriptFile = driver.findElement(By.xpath(xpathScriptFile)).isDisplayed();
			 Assert.assertEquals(scriptFile, true,"script File is not Displaying!!");
			 test.log(LogStatus.PASS,"Python Fields","script File Field is Displaying");
			 boolean parameterj=driver.findElement(By.name("Parameters")).isDisplayed();
			 Assert.assertEquals(parameterj, true,"Add Parameter button  is not Displaying!!");
			 test.log(LogStatus.PASS,"Python Fields","Add Parameter button is Displaying");
			 boolean appendLibraries=driver.findElement(By.name("AppendLibraries")).isDisplayed();
			 Assert.assertEquals(appendLibraries, true,"appendLibraries button  is not Displaying!!");
			 test.log(LogStatus.PASS,"Python Fields","appendLibraries button is Displaying");
			 boolean submitBtn=driver.findElement(By.xpath(xpathSubmitButtonCO)).isDisplayed();
			 Assert.assertEquals(submitBtn, true,"submitBtn is not Displaying!!");
			 test.log(LogStatus.PASS,"Python Fields","submitBtn is Displaying");
			 boolean cancelBtn=driver.findElement(By.xpath(xpathCancelButtonCO)).isDisplayed();
			 Assert.assertEquals(cancelBtn, true,"cancelBtn is not Displaying!!");
			 test.log(LogStatus.PASS,"Python Fields","cancelBtn is Displaying"); 
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(1500);
			 String nameAlert = driver.findElement(By.xpath(xpathnameAlert)).getText();
		     Assert.assertEquals(nameAlert,"Name cannot empty","'Name cannot empty' alert is not Displaying ");
			 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Name cannot empty' alert is Displaying");
             Thread.sleep(1000);
             String scriptFileLocation = driver.findElement(By.xpath(xpathScriptFileLocation)).getText();
		     Assert.assertEquals(scriptFileLocation,"Script file Location cannot empty","'Script file Location cannot empty' alert is not Displaying ");
			 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Script file Location cannot empty' alert is Displaying");
             Thread.sleep(1000);
         }
         @Test(priority = 11, dependsOnMethods = { "verifyFieldsOfPython" },groups = { "Smoke" })
         public static void verifyFieldsOfNotebook() throws InterruptedException 
         {
        	 
        	 Thread.sleep(1000);
			 test = report.startTest("Verify fields Of Notebook Type");
			 driver.findElement(By.xpath(xpathClickonType)).click();
			 driver.findElement(By.xpath(xpathSelectNotebook)).click(); 
			 String notebook = driver.findElement(By.xpath(xpathjar)).getText();
			 Assert.assertEquals(notebook,"Notebook","Notebook Type is not Displaying ");
			 test.log(LogStatus.PASS, "Notebook Fields", "Notebook Type is Displaying");
             Thread.sleep(1000);
             boolean namej = driver.findElement(By.xpath(xpathNameJ)).isDisplayed();
			 Assert.assertEquals(namej, true,"Name Field is not Displaying!!");
			 test.log(LogStatus.PASS,"Notebook Fields","Name Field is Displaying");
			 boolean descj = driver.findElement(By.xpath(xpathDescriptionJ)).isDisplayed();
			 Assert.assertEquals(descj, true,"Description Field is not Displaying!!");
			 test.log(LogStatus.PASS,"Notebook Fields","Description Field is Displaying");
			 boolean scriptFile = driver.findElement(By.xpath(xpathScriptFile)).isDisplayed();
			 Assert.assertEquals(scriptFile, true,"script File is not Displaying!!");
			 test.log(LogStatus.PASS,"Notebook Fields","script File Field is Displaying");
			 boolean parameterj=driver.findElement(By.name("Parameters")).isDisplayed();
			 Assert.assertEquals(parameterj, true,"Add Parameter button  is not Displaying!!");
			 test.log(LogStatus.PASS,"Notebook Fields","Add Parameter button is Displaying");
			 boolean appendLibraries=driver.findElement(By.name("AppendLibraries")).isDisplayed();
			 Assert.assertEquals(appendLibraries, true,"appendLibraries button  is not Displaying!!");
			 test.log(LogStatus.PASS,"Notebook Fields","appendLibraries button is Displaying");
			 boolean submitBtn=driver.findElement(By.xpath(xpathSubmitButtonCO)).isDisplayed();
			 Assert.assertEquals(submitBtn, true,"submitBtn is not Displaying!!");
			 test.log(LogStatus.PASS,"Notebook Fields","submitBtn is Displaying");
			 boolean cancelBtn=driver.findElement(By.xpath(xpathCancelButtonCO)).isDisplayed();
			 Assert.assertEquals(cancelBtn, true,"cancelBtn is not Displaying!!");
			 test.log(LogStatus.PASS,"Notebook Fields","cancelBtn is Displaying"); 
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(1000);
			 String nameAlert = driver.findElement(By.xpath(xpathnameAlert)).getText();
		     Assert.assertEquals(nameAlert,"Name cannot empty","'Name cannot empty' alert is not Displaying ");
			 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Name cannot empty' alert is Displaying");
             Thread.sleep(1000);
             String scriptFileLocation = driver.findElement(By.xpath(xpathScriptFileLocation)).getText();
		     Assert.assertEquals(scriptFileLocation,"Script file Location cannot empty","'Script file Location cannot empty' alert is not Displaying ");
			 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Script file Location cannot empty' alert is Displaying");
             Thread.sleep(1000);
			 
        }
         @Test(priority = 12, dependsOnMethods = { "verifyFieldsOfNotebook" },groups = { "Smoke" })
         public static void verifyFieldsOfExe() throws InterruptedException 
         {
         Thread.sleep(1000);
		 test = report.startTest("Verify fields Of Exe Type");
		 driver.findElement(By.xpath(xpathClickonType)).click();
		 driver.findElement(By.xpath(xpathSelectExe)).click(); 
		 String exe = driver.findElement(By.xpath(xpathjar)).getText();
		 Assert.assertEquals(exe,"Exe","Exe Type is not Displaying ");
		 test.log(LogStatus.PASS, "Exe Fields", "Exe Type is Displaying");
         Thread.sleep(1000);
         boolean namej = driver.findElement(By.xpath(xpathNameJ)).isDisplayed();
		 Assert.assertEquals(namej, true,"Name Field is not Displaying!!");
		 test.log(LogStatus.PASS,"Exe Fields","Name Field is Displaying");
		 boolean descj = driver.findElement(By.xpath(xpathDescriptionJ)).isDisplayed();
		 Assert.assertEquals(descj, true,"Description Field is not Displaying!!");
		 test.log(LogStatus.PASS,"Exe Fields","Description Field is Displaying");
		 boolean command = driver.findElement(By.xpath(xpathCommand)).isDisplayed();
		 Assert.assertEquals(command, true,"command Field is not Displaying!!");
		 test.log(LogStatus.PASS,"Exe Fields","command Field is Displaying");
		 boolean scriptFile = driver.findElement(By.xpath(xpathScriptFile)).isDisplayed();
		 Assert.assertEquals(scriptFile, true,"script File is not Displaying!!");
		 test.log(LogStatus.PASS,"Exe Fields","script File Field is Displaying");
		 boolean parameterj=driver.findElement(By.name("Parameters")).isDisplayed();
		 Assert.assertEquals(parameterj, true,"Add Parameter button  is not Displaying!!");
		 test.log(LogStatus.PASS,"Exe Fields","Add Parameter button is Displaying");
		 boolean submitBtn=driver.findElement(By.xpath(xpathSubmitButtonCO)).isDisplayed();
		 Assert.assertEquals(submitBtn, true,"submitBtn is not Displaying!!");
		 test.log(LogStatus.PASS,"Exe Fields","submitBtn is Displaying");
		 boolean cancelBtn=driver.findElement(By.xpath(xpathCancelButtonCO)).isDisplayed();
		 Assert.assertEquals(cancelBtn, true,"cancelBtn is not Displaying!!");
		 test.log(LogStatus.PASS,"Exe Fields","cancelBtn is Displaying"); 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
		 Thread.sleep(1000);
		 String nameAlert = driver.findElement(By.xpath(xpathnameAlert)).getText();
	     Assert.assertEquals(nameAlert,"Name cannot empty","'Name cannot empty' alert is not Displaying ");
		 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Name cannot empty' alert is Displaying");
         Thread.sleep(1000);
         String commandAlert = driver.findElement(By.xpath(xpathCommandAlert)).getText();
	     Assert.assertEquals(commandAlert,"Command cannot empty","'Command cannot empty' alert is not Displaying ");
		 test.log(LogStatus.PASS, "Alerts on Jar Type", "'Command cannot empty' alert is Displaying");
         Thread.sleep(1000);
		 }
         @Test(priority = 13, dependsOnMethods = { "verifyFieldsOfExe" },groups = { "Smoke" })
         public static void verifyFieldsOfParameters() throws InterruptedException 
         {
         Thread.sleep(1000);
         test = report.startTest("Verify fields Of Parameters");
         driver.findElement(By.xpath(xpathClickonType)).click();
         Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSelectJar)).click();
		 Thread.sleep(1000);
		 driver.findElement(By.name("Parameters")).click();
		 boolean nameP=driver.findElement(By.xpath(xpathNameP)).isDisplayed();
		 Assert.assertEquals(nameP, true,"name Field is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","name Field is Displaying"); 
		 
		 boolean selectType=driver.findElement(By.id("select-Type")).isDisplayed();
		 Assert.assertEquals(selectType, true,"select Type Field is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","selectType Field is Displaying"); 
		 
		 driver.findElement(By.id("select-Type")).click();
		 int datatypeSize = driver.findElements(By.xpath("//*[@id='menu-Type']//ul//li")).size();
		 if(datatypeSize==7)
		 {
		 for(int i=1;i<=7;i++)
			 
		 {
		 String datatypes=driver.findElement(By.xpath(" //*[@id='menu-Type']//ul//li["+i+"]")).getText();
		 if(datatypes.equals("string"))
		 {
			test.log(LogStatus.PASS,"Types","String is Displaying ");
		 }
		 if(datatypes.equals("int"))
		 {
			test.log(LogStatus.PASS,"Types","int is Displaying ");
		 }
		 if(datatypes.equals("bigint"))
		 {
			test.log(LogStatus.PASS,"Types","bigint is Displaying ");
		 }
		 if(datatypes.equals("bit"))
		 {
			test.log(LogStatus.PASS,"Types","bit is Displaying ");
		 }
		 if(datatypes.equals("decimal"))
		 {
			test.log(LogStatus.PASS,"Types","decimal is Displaying ");
		 }
		 if(datatypes.equals("double"))
		 {
			test.log(LogStatus.PASS,"Types","double is Displaying ");
		 }
		 if(datatypes.equals("float"))
		 {
			test.log(LogStatus.PASS,"Types","float is Displaying ");
		 }
		 }
		 }
		 boolean selector=driver.findElement(By.xpath(("//*[@id='PramRequired']"))).isEnabled();
		 Assert.assertEquals(selector,true,"selector is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","selector is Displaying"); 
		 
		 boolean deleteP=driver.findElement(By.xpath("//*[@id='root']//div//a[@color='primary']")).isEnabled();
		 Assert.assertEquals(deleteP, true,"Delete Button is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","Delete Button  is Displaying"); 
		
	     }
         
         
         
         
         
         
         @Test(priority = 14, dependsOnMethods = { "verifyFieldsOfParameters" },groups = { "Smoke" })
         public static void verifyFieldsOflibrary() throws InterruptedException 
         {
         Thread.sleep(1000);
         driver.navigate().refresh();
         test = report.startTest("Verify fields Of Library");
         Thread.sleep(1000);
         driver.findElement(By.xpath(xpathClickonType)).click();
         Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSelectJar)).click();
		 Thread.sleep(1000);
		
         driver.findElement(By.xpath("//*[@id='root']//button[text()='Append Libraries +']")).click();

		 Thread.sleep(1000);
		 driver.findElement(By.id("select-libraryType")).click();
		 driver.findElement(By.xpath(xpathLibraryJ)).click();
		 
		 boolean jarDbfsuri=driver.findElement(By.name("Dbfsuri")).isDisplayed();
		 Assert.assertEquals(jarDbfsuri, true,"Dbfsuri Field under jar library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","Dbfsuri Field under jar library type is Displaying"); 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
		 String alertOnDbfs=driver.findElement(By.xpath(xpathAlertOnDbfs)).getText();
		 Assert.assertEquals(alertOnDbfs,"DBFS URI cannot be empty","'DBFS URI cannot be empty',alert is not displaying!!!");
		 test.log(LogStatus.PASS,"Library Alert","'DBFS URI cannot be empty',alert isdisplaying!!!");
		 
		 Thread.sleep(1000);
		 driver.findElement(By.id("select-libraryType")).click();
		 driver.findElement(By.xpath(xpathEggJ)).click();
		 boolean eggDbfsuri=driver.findElement(By.name("Dbfsuri")).isDisplayed();
		 Assert.assertEquals(eggDbfsuri, true,"Dbfsuri Field under egg library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","Dbfsuri Field under egg library type is Displaying"); 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
		 String alertOnDbfsuri=driver.findElement(By.xpath(xpathAlertOnDbfs)).getText();
		 Assert.assertEquals(alertOnDbfsuri,"DBFS URI cannot be empty","'DBFS URI cannot be empty',alert is not displaying!!!");
		 test.log(LogStatus.PASS,"Library Alert","'DBFS URI cannot be empty',alert isdisplaying!!!");
		 
		 
		 Thread.sleep(1000);
		 driver.findElement(By.id("select-libraryType")).click();
		 driver.findElement(By.xpath(xpathPypiTypeN)).click();
		 boolean pckage=driver.findElement(By.name("Package")).isDisplayed();
		 Assert.assertEquals(pckage, true,"package Field under pypi library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","package Field under pypi library type is Displaying"); 
		 boolean repository = driver.findElement(By.name("Repository")).isDisplayed();
		 Assert.assertEquals(repository, true,"repository Field under pypi library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","repository Field under pypi library type is Displaying"); 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
		 String alertonPackage=driver.findElement(By.xpath(xpathAlertonPackage)).getText();
		 Assert.assertEquals(alertonPackage,"Package cannot be empty","'Package cannot be empty',alert is not displaying!!!");
		 test.log(LogStatus.PASS,"Library Alert","'Package cannot be empty',alert is displaying!!!");
		 
		 
		 Thread.sleep(1000);
		 driver.findElement(By.id("select-libraryType")).click();
		 driver.findElement(By.xpath(xpathMaven)).click();
		 boolean coordinates=driver.findElement(By.name("Coordinates")).isDisplayed();
		 Assert.assertEquals(coordinates, true,"coordinates Field under maven library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","coordinates Field under maven library type is Displaying"); 
		 boolean repositoryM = driver.findElement(By.name("Repository")).isDisplayed();
		 Assert.assertEquals(repositoryM, true,"repository Field under maven library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","repository Field under maven library type is Displaying"); 
		 boolean exclusion =driver.findElement(By.name("Exclusion")).isDisplayed();
		 Assert.assertEquals(exclusion, true,"exclusion Field under maven library type is not Displaying!!");
		 test.log(LogStatus.PASS,"exclusion Fields","exclusion Field under maven library type is Displaying"); 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
		 Thread.sleep(1000);
		 String alertonCoordinates=driver.findElement(By.xpath(xptahAlertonCoordinates)).getText();
		 Assert.assertEquals(alertonCoordinates,"Coordinates cannot be empty","'Coordinates cannot be empty',alert is not displaying!!!");
		 test.log(LogStatus.PASS,"Library Alert","'Coordinates cannot be empty',alert isdisplaying!!!");
		 
		 
		 Thread.sleep(1000);
		 driver.findElement(By.id("select-libraryType")).click();
		 driver.findElement(By.xpath(xpathCran)).click();
		 boolean repositoryC = driver.findElement(By.name("Repository")).isDisplayed();
		 Assert.assertEquals(repositoryC, true,"repository Field under Cran library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","repository Field under Cran library type is Displaying"); 
		 boolean pckageC=driver.findElement(By.name("Package")).isDisplayed();
		 Assert.assertEquals(pckageC, true,"package Field under Cran library type is not Displaying!!");
		 test.log(LogStatus.PASS,"Parameters Fields","package Field under Cran library type is Displaying"); 
		 boolean delete = driver.findElement(By.xpath(xpathDelete)).isEnabled();
		 Assert.assertEquals(delete, true,"delete Button is not Displaying!!");
		 test.log(LogStatus.PASS,"delete Button","delete Button is Displaying"); 
		 Thread.sleep(1000);
		 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
		 Thread.sleep(1000);
		 String alertonpackage=driver.findElement(By.xpath(xpathAlertonPackage)).getText();
		 Assert.assertEquals(alertonpackage,"Package cannot be empty","'Package cannot be empty',alert is not displaying!!!");
		 test.log(LogStatus.PASS,"Library Alert","'Package cannot be empty',alert isdisplaying!!!");
		 
		 
		}
         
         @Test(priority = 15, dependsOnMethods = { "verifyFieldsOflibrary" },groups = { "Smoke" })
         public static void verifyAddRecordOfJar() throws InterruptedException 
         {   	 
        	 
        	 
        	 Thread.sleep(1000);
        	 test = report.startTest("Verify Add Record Of Exe Type");
    		 driver.findElement(By.xpath(xpathClickonType)).click();
    		 driver.findElement(By.xpath(xpathSelectJar)).click();
    		 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathNameJ)).sendKeys(reader.getCellData("Operations","Name", 2));
	         Thread.sleep(1000);
	         driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Operations", "Description", 2));
			 driver.findElement(By.xpath(xpathClassNameJ)).sendKeys(reader.getCellData("Operations", "ClassName", 2));
			 driver.findElement(By.name("Parameters")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathNameP)).sendKeys(reader.getCellData("Operations", "name", 2));
			 Thread.sleep(1000);
			 driver.findElement(By.id("select-Type")).click();
			 driver.findElement(By.xpath(xpathStringtype)).click();
			 Thread.sleep(1000);
			 driver.findElement(By.name("AppendLibraries")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.id("select-libraryType")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathLibraryJ)).click();
			 driver.findElement(By.name("Dbfsuri")).sendKeys(reader.getCellData("Operations","Dbfsuri",2));
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(1000);
			 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		     Thread.sleep(1000); 
			 Assert.assertEquals(toaster,"Operation added successfully!","operation is not added succesfully");
		     test.log(LogStatus.PASS, "Opeartion Jar Added", "Operation is added succesfully");
		     int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	   
	     	     for(int i=1;i<=numberOfRecords;i++)
	     	      {
	     		   
	             if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 2)))
	                	{
	     			    test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	     		        }
	            
	     	      }
              }
         
         
         
	     	    @Test(priority = 16, dependsOnMethods = { "verifyAddRecordOfJar" },groups = { "Smoke" })
	            public static void verifyEditRecordOfJar() throws InterruptedException 
	            {   	     
                 Thread.sleep(1000);
                 boolean status=false;
        	      test = report.startTest("Verify Edit Record Of Jar Type");
        	      Thread.sleep(1000);
        	      driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr//td[2][text()='Union -jar']/..//td[8]//a[1]")).click();
        	      driver.findElement(By.xpath(xpathNameJ)).sendKeys(Keys.CONTROL + "a");
        		  driver.findElement(By.xpath(xpathNameJ)).sendKeys(Keys.BACK_SPACE);
       		      Thread.sleep(1000);
     			   driver.findElement(By.xpath(xpathNameJ)).sendKeys(reader.getCellData("Operations","Name", 6));
     	          Thread.sleep(1000);
    	          driver.findElement(By.id("Description")).sendKeys(Keys.CONTROL + "a");
   			      driver.findElement(By.id("Description")).sendKeys(Keys.BACK_SPACE);
   			      Thread.sleep(1000);
    			  driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Operations", "Description", 6));     			 
     			  driver.findElement(By.xpath(xpathClassNameJ)).sendKeys(Keys.CONTROL + "a");
  			      driver.findElement(By.xpath(xpathClassNameJ)).sendKeys(Keys.BACK_SPACE);
  			      
   			      Thread.sleep(1000);
     			  driver.findElement(By.xpath(xpathClassNameJ)).sendKeys(reader.getCellData("Operations", "ClassName", 6));
     			  driver.findElement(By.name("Parameters")).click();
     			  Thread.sleep(1000);
     			  //driver.findElement(By.xpath(xpathNameP)).sendKeys(reader.getCellData("Operations", "name", 6));
     			  // Thread.sleep(1000);
                  driver.findElement(By.xpath("(//*[@id='root']/div//a[@color='primary'])[2]")).click();
                  Thread.sleep(1000);
     			  driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
     			  Thread.sleep(1000);
   			      String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
 		          Thread.sleep(1000); 
  			      Assert.assertEquals(toaster,"Operation updated successfully!","operation is not updated succesfully");
 		          test.log(LogStatus.PASS, "Opeartion Jar updated", "Operation is updated succesfully");
   		          int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
   	     	   
  	     	     for(int i=1;i<=numberOfRecords;i++)
   	     	      {
   	     		   
   	             if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 6)))
   	                	{
   	     			    test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");   	     		        }
   	           status=true ;
   			    }
   	     
        if(!status)  
           
        {
       	test.log(LogStatus.FAIL,"Record is  not displaying in grid Sucessfully or Record is not Updated!!!");
        }
  	     
		   }    
	     	  
	     	    
	     	   @Test(priority = 17, dependsOnMethods = { "verifyEditRecordOfJar" },groups = { "Smoke" })
	            public static void verifyDeleteRecordOfJar() throws InterruptedException 
	            { 
	     		     Thread.sleep(1000);
	     		     test = report.startTest("Verify Delete Record Of Jar Type");
        	         Thread.sleep(1000);
        	         int rows = driver.findElements(By.xpath(xpathRowInGrid)).size();
        			 Thread.sleep(1000);
        		    	String jar="Union-jar-Updated"; 
        			//String subscriptionName = driver.findElement(By.xpath("//*[@id='root']//tbody/tr[1]/td[2]")).getText();
        			 driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr//td[2][text()='Union-jar-Updated']/..//td[8]//a[2]")).click();
        			Thread.sleep(1500);
        			WebElement deleteDialogBox = driver.findElement(By.xpath(xpathDeleteDialogBox));
	     			 Assert.assertTrue(deleteDialogBox.isDisplayed());
	     			 test.log(LogStatus.PASS, "Delete DialogBox","delete DialogBox is displaying");
	     			 String deleteText = driver.findElement(By.xpath(xpathDeleteText)).getText();
	     			 Assert.assertEquals(deleteText,"Delete","Delete is not Displaying");
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
	     			driver.findElement(By.xpath(xpathDeleteYesButton)).click();
        			Thread.sleep(1000);
        			String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
        			Assert.assertEquals(toaster,"Operation deleted successfully!","Operation is not Deleted succesfully ");
        			System.out.println(" Operation Deleted ...");
        		    test.log(LogStatus.PASS, "Delete Record", "Operation is Deleted Successfully Toaster message is displaying");
        		     
        		     int oprnName=driver.findElements(By.xpath("//*[@id='root']//tbody/tr/td[2]")).size();
        	 		
        	 		for(int i=1;i<=oprnName;i++)
        	 		{
        	 			if(driver.findElement(By.xpath("//*[@id='root']//tbody/tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations","Name", 6)))
        	 			{
        	 				System.out.println("record is not deleted , Displaying on screen ");
        	 				test.log(LogStatus.FAIL, "Delete Record", "Record is not Deleted, Displaying On Screen");
        	 			}
        	          }
        	 		System.out.println("Record is Deleted Successfuly ,not displaying on Screen");
        	 		test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully, not Displaying on Screen");
        	 		
        		     int rows2 = driver.findElements(By.xpath(xpathRowInGrid)).size();
        			
        			if (rows2 == rows - 1) {
        				test.log(LogStatus.PASS, "Delete Record", "Record is deleted Sucessfully");
        			} else {
        				test.log(LogStatus.FAIL, "Delete Record", "Record id not Deleted");
        			}
        			 
        		}   

	           @Test(priority = 18, dependsOnMethods = { "verifyEditRecordOfJar" },groups = { "Smoke" })
               public static void verifyAddRecordOfPython() throws InterruptedException 
              
	           {   	 
        	 
        	 Thread.sleep(1000);
			 test = report.startTest("Verify Add Record Of Python Type");
			 driver.findElement(By.xpath(xpathClickonType)).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSelectPython)).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Operations","Name", 3));
			 Thread.sleep(1000);
			 driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Operations","Description ", 3));
			 Thread.sleep(1000);
			 driver.findElement(By.id("FolderPath")).sendKeys(reader.getCellData("Operations","Script",3));
			 Thread.sleep(1000);
//			 driver.findElement(By.name("Parameters")).click();
//			 driver.findElement(By.xpath(xpathNameP)).sendKeys(reader.getCellData("Operations", "name", 3));
//			 Thread.sleep(1000);
//			 driver.findElement(By.id("select-Type")).click();
//			 driver.findElement(By.xpath(xpathInttype)).click();
//			 Thread.sleep(1000);
//			 driver.findElement(By.name("AppendLibraries")).click();
//			 Thread.sleep(1000);
//			 driver.findElement(By.id("select-libraryType")).click();
//			 driver.findElement(By.xpath(xpathEggJ)).click();
//			 driver.findElement(By.name("Dbfsuri")).sendKeys(reader.getCellData("Operations","Dbfsuri",2));
//			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(1000);
			 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		     Thread.sleep(1000); 
			 Assert.assertEquals(toaster,"Operation added successfully!","operation is not added succesfully");
		     test.log(LogStatus.PASS, "Opeartion Python Added", "Operation is added succesfully");
		     int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	   
	     	     for(int i=1;i<=numberOfRecords;i++)
	     	      {
	     		   
	             if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 3)))
	                		{
	     			          test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	     		            }
                  } 
                  }  
            @Test(priority = 19, dependsOnMethods = { "verifyAddRecordOfPython" },groups = { "Smoke" })
            public static void verifyEditRecordOfPython() throws InterruptedException 
            {   	 
           Thread.sleep(1000);
           boolean status=false;
		   test = report.startTest("Verify Edit Record Of Python Type");
		   Thread.sleep(1000);
 	       driver.findElement(By.xpath("//*[@id='root']//div//table/tbody/tr[1]/td[8]/a[1]")).click();
 	       driver.findElement(By.id("Name")).sendKeys(Keys.CONTROL + "a");
 		   driver.findElement(By.id("Name")).sendKeys(Keys.BACK_SPACE);
 		   Thread.sleep(1000);
 		   driver.findElement(By.id("Name")).sendKeys(reader.getCellData("Operations","Name", 7));
 		   Thread.sleep(1000);
 		   driver.findElement(By.id("Description")).sendKeys(Keys.CONTROL + "a");
		   driver.findElement(By.id("Description")).sendKeys(Keys.BACK_SPACE);
		   Thread.sleep(1000);
		   driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Operations","Description ", 7));
		   Thread.sleep(1000);
		   driver.findElement(By.id("FolderPath")).sendKeys(Keys.CONTROL + "a");
		   driver.findElement(By.id("FolderPath")).sendKeys(Keys.BACK_SPACE);
		   Thread.sleep(1000);
		   driver.findElement(By.id("FolderPath")).sendKeys(reader.getCellData("Operations","Script",7));
		   Thread.sleep(1000);
		   driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			  Thread.sleep(1000);
		      String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	          Thread.sleep(1000); 
		      Assert.assertEquals(toaster,"Operation updated successfully!","operation is not updated succesfully");
	          test.log(LogStatus.PASS, "Opeartion Jar updated", "Operation is updated succesfully");
	          int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
     	   
    	     for(int i=1;i<=numberOfRecords;i++)
     	      {
     		   
             if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 7)))
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
         
         @Test(priority = 20, dependsOnMethods = { "verifyEditRecordOfPython" },groups = { "Smoke" } )
         public static void verifyAddRecordOfNoteBook() throws InterruptedException 
         {   	 
        	 

        	 Thread.sleep(1000);
			 test = report.startTest("Verify Add Record Of Notebook Type");
			 driver.findElement(By.xpath(xpathClickonType)).click();
			 driver.findElement(By.xpath(xpathSelectNotebook)).click(); 
			 driver.findElement(By.xpath(xpathNameJ)).sendKeys(reader.getCellData("Operations","Name",4));
			 driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Operations","Description ", 4));
		     driver.findElement(By.xpath(xpathScriptFile)).sendKeys(reader.getCellData("Operations","Script",4));
			 driver.findElement(By.name("Parameters")).isDisplayed();
			 Thread.sleep(1000);
			 driver.findElement(By.name("Parameters")).click();
			 driver.findElement(By.xpath(xpathNameP)).sendKeys(reader.getCellData("Operations", "name", 4));
			 Thread.sleep(1000);
			 driver.findElement(By.id("select-Type")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathDecimaltypeN)).click();
			 Thread.sleep(1000);
			 driver.findElement(By.name("AppendLibraries")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.id("select-libraryType")).click();
			 driver.findElement(By.xpath(xpathPypiTypeN)).click();
			 driver.findElement(By.name("Package")).sendKeys(reader.getCellData("Operations", "Package", 4));
			 driver.findElement(By.name("Repository")).sendKeys(reader.getCellData("Operations", "Repostiory",4));
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(1000);
			 String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		     Thread.sleep(1000); 
			 Assert.assertEquals(toaster,"Operation added successfully!","operation is not added succesfully");
		     test.log(LogStatus.PASS, "Opeartion Notebook Added", "Operation is added succesfully");
		     int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	   
	     	     for(int i=1;i<=numberOfRecords;i++)
	     	      {
	     		   
	                 if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 3)))
	                		{
	     			    test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	     		        }     
    
    
    }
         } 
         @Test(priority = 21, dependsOnMethods = { "verifyAddRecordOfNoteBook" },groups = { "Smoke" })
         public static void verifyEditRecordOfNoteBook() throws InterruptedException 
         { 
        	    Thread.sleep(1000);
        	    boolean status=false;
			    test = report.startTest("Verify Edit Record Of Notebook Type");
			    Thread.sleep(1000);
	 	       driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr//td[2][text()='Addition-Notebook']/..//td[8]//a[1]")).click();
	 	       driver.findElement(By.xpath(xpathNameJ)).sendKeys(Keys.CONTROL + "a");
	 		   driver.findElement(By.xpath(xpathNameJ)).sendKeys(Keys.BACK_SPACE);
	 		   Thread.sleep(1000);
			   driver.findElement(By.xpath(xpathNameJ)).sendKeys(reader.getCellData("Operations","Name",8));
			   Thread.sleep(1000);
			   driver.findElement(By.id("Description")).sendKeys(Keys.CONTROL + "a");
	 		   driver.findElement(By.id("Description")).sendKeys(Keys.BACK_SPACE);
	 		   Thread.sleep(1000);
			   driver.findElement(By.id("Description")).sendKeys(reader.getCellData("Operations","Description ", 8));
			   Thread.sleep(1000);
			   driver.findElement(By.xpath(xpathScriptFile)).sendKeys(Keys.CONTROL + "a");
	 		   driver.findElement(By.xpath(xpathScriptFile)).sendKeys(Keys.BACK_SPACE);
	 		   Thread.sleep(1000);
			   driver.findElement(By.xpath(xpathScriptFile)).sendKeys(reader.getCellData("Operations","Script",8));
			   
			   driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
				  Thread.sleep(1000);
			      String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		          Thread.sleep(1000); 
			      Assert.assertEquals(toaster,"Operation updated successfully!","operation is not updated succesfully");
		          test.log(LogStatus.PASS, "Opeartion Jar updated", "Operation is updated succesfully");
		          int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	   
	    	     for(int i=1;i<=numberOfRecords;i++)
	     	      {
	     		   
	             if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 7)))
	                	{
	     			    test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");   	     		        }
	           
	             status=true ;
     			    }
     	     
          if(!status)  
             
          {
         	test.log(LogStatus.FAIL,"Record is  not displaying in grid Sucessfully or Record is not Updated!!!");
          }
    	     
	     	     
	         
	    	      
			   }     
	         
	     @Test(priority = 22, dependsOnMethods = { "verifyEditRecordOfNoteBook" },groups = { "Smoke" })
         public static void verifyAddRecordOfExe() throws InterruptedException 
         {   	 
        	 

        	     Thread.sleep(1000);
			     test = report.startTest("Verify Add Record Of Exe Type");
			     Thread.sleep(1000);
				 
				 driver.findElement(By.xpath(xpathClickonType)).click();
				 Thread.sleep(1000);
				 driver.findElement(By.xpath(xpathSelectExe)).click(); 
			     driver.findElement(By.xpath(xpathNameJ)).sendKeys(reader.getCellData("Operations","Name",5));
				 driver.findElement(By.xpath(xpathDescriptionJ)).sendKeys(reader.getCellData("Operations","Description ",5));
				 driver.findElement(By.xpath(xpathCommand)).sendKeys(reader.getCellData("Operations", "Command", 5));
				 driver.findElement(By.xpath(xpathScriptFile)).sendKeys(reader.getCellData("Operations","Script",5));
				
			     driver.findElement(By.name("Parameters")).click();
			     Thread.sleep(1000);
			   
			     driver.findElement(By.xpath(xpathNameP)).sendKeys(reader.getCellData("Operations", "name", 5));
			     Thread.sleep(1000);
			     driver.findElement(By.id("select-Type")).click();
			     Thread.sleep(1000);
			     driver.findElement(By.xpath(xpathDecimaltypeN)).click();
			     Thread.sleep(1000);
			     driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			     Thread.sleep(1000);
			     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
		         Thread.sleep(1000); 
			     Assert.assertEquals(toaster,"Operation added successfully!","operation is not added succesfully");
		         test.log(LogStatus.PASS, "Opeartion Exe Added", "Operation is added succesfully");
		          int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
	     	   
	     	     for(int i=1;i<=numberOfRecords;i++)
	     	      {
	     		  if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 5)))
	              {
	     	      test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");
	     		  }
	     		  
	              }
	     	      }

         @Test(priority = 23, dependsOnMethods = { "verifyAddRecordOfExe" },groups = { "Smoke" })
         public static void verifyEditRecordOfExe() throws InterruptedException 
         {   	 
        	 Thread.sleep(1000);
        	 boolean status=false;
		     test = report.startTest("Verify Edit Record Of Exe Type");
		     Thread.sleep(1000);
		     driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr//td[2][text()='Subtraction-Exe']/..//td[8]//a[1]")).click();
	 	     driver.findElement(By.xpath(xpathNameJ)).sendKeys(Keys.CONTROL + "a");
	 		 driver.findElement(By.xpath(xpathNameJ)).sendKeys(Keys.BACK_SPACE);
	 		 Thread.sleep(1000);
	 		 driver.findElement(By.xpath(xpathNameJ)).sendKeys(reader.getCellData("Operations","Name",9));
	 		 driver.findElement(By.xpath(xpathDescriptionJ)).sendKeys(Keys.CONTROL + "a");
	 		 driver.findElement(By.xpath(xpathDescriptionJ)).sendKeys(Keys.BACK_SPACE);
	 		 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathDescriptionJ)).sendKeys(reader.getCellData("Operations","Description ",9));
			 driver.findElement(By.xpath(xpathCommand)).sendKeys(Keys.CONTROL + "a");
		 	 driver.findElement(By.xpath(xpathCommand)).sendKeys(Keys.BACK_SPACE);
		     Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathCommand)).sendKeys(reader.getCellData("Operations", "Command", 9));
			 driver.findElement(By.xpath(xpathScriptFile)).sendKeys(Keys.CONTROL + "a");
		 	 driver.findElement(By.xpath(xpathScriptFile)).sendKeys(Keys.BACK_SPACE);
		 	 Thread.sleep(1000);
			 driver.findElement(By.xpath(xpathScriptFile)).sendKeys(reader.getCellData("Operations","Script",9));
			 driver.findElement(By.xpath(xpathSubmitButtonCO)).click();
			 Thread.sleep(1000);
		     String toaster = driver.findElement(By.xpath(toasterRecordSaved)).getText();
	         Thread.sleep(1000); 
		     Assert.assertEquals(toaster,"Operation updated successfully!","operation is not updated succesfully");
	         test.log(LogStatus.PASS, "Opeartion Jar updated", "Operation is updated succesfully");
	         int numberOfRecords = driver.findElements(By.xpath("//*[@id='root']//table//tbody//tr")).size();
     	   
    	     for(int i=1;i<=numberOfRecords;i++)
     	      {
     		   
              if(driver.findElement(By.xpath("//*[@id='root']//table//tbody//tr["+i+"]//td[2]")).getText().equals(reader.getCellData("Operations", "Name", 9)))
                	{
     			    test.log(LogStatus.PASS,"Record is  displaying in grid Sucessfully!!!");   	     		        }
           
             status=true ;
 			    }
 	     
      if(!status)  
         
      {
     	test.log(LogStatus.FAIL,"Record is  not displaying in grid Sucessfully or Record is not Updated!!!");
      }
	  }     
      }
