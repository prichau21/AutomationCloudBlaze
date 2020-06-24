package com.CloudBlaze.Base;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseClass {

	// *****Declaration & Definition of basic things like Driver, Browser, Extent
	// Reports*******//

	public static WebDriver driver;
	public static Properties Credential = null;
	public static ExtentTest test;
	public static ExtentReports report;
	public static WebDriverWait wait;

	@Parameters("env")
	@BeforeTest(alwaysRun = true)
	public void init(String env) throws Exception {
		// test=report.startTest("Launching the browser!!!");
		Credential = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/Properties/Credential.properties");
		Credential.load(ip);

		if (Credential.get("Browser").toString().equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Browser is " + "Firefox");
		}

		else if (Credential.get("Browser").toString().equals("chrome")) {
			String driverPath = getChromeDriverPath();
			System.out.println("Browser is " + "Chrome");

			if (env.contains("https://cloudblaze-ui-react.azurewebsites.net/#")) {
				System.out.println("Environment is Test (i.e.," + env + ")");
			}
			 else {
				System.out.println("Something wrong with the env URL");
			}

			if (driverPath.equals("\\Drivers\\chromedriver.exe")) 
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
				driver = new ChromeDriver();
			}else if (driverPath.equals("/Drivers/chromedriverLinux")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + driverPath);
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.NONE);
				options.addArguments("start-maximized"); // open Browser in maximized mode
                options.addArguments("enable-automation"); 
				options.addArguments("disable-infobars"); // disabling info bars
				options.addArguments("--disable-extensions"); // disabling extensions
				options.addArguments("--headless");
				 options.addArguments("--disable-browser-side-navigation"); 
				    options.addArguments("--disable-gpu");
				options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
				options.addArguments("--no-sandbox"); // Bypass OS security model

				driver = new ChromeDriver(options);
			} else {
				test.log(LogStatus.ERROR, "Launching Browser", "Unable to Launch Browser");
			}

		}

		else if (Credential.get("Browser").toString().equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/Drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("Browser is " + "IE");
		}

		else if (Credential.get("Browser").toString().equals("MSEdge")) {
			System.setProperty("webdriver.edge.driver",
					System.getProperty("user.dir") + "Drivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			System.out.println("Browser is " + "MSEdge");

		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// Maximizing & Opening the respective browser
		  driver.manage().window().maximize();
		 // WebDriverWait wait = new WebDriverWait(driver, 20);
		 //  WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='root']//button[text()='Login']")));
		// driver.get(DatablazeConstants.Dev);
		   driver.get(env);
	//	LoginLogout.ExecuteLogin(driver);
		   
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
		    driver.navigate().refresh();
	}

	public static String getChromeDriverPath() {
		String OS = System.getProperty("os.name");

		if (OS.contains("Window")) {
			System.out.println("OS is " + OS);
			return "\\Drivers\\chromedriver.exe";  //changd
		} // else if (OS.contains("Mac")) {
			// return "libs/chromedriver_mac"
			// }
		else {
			System.out.println("OS is " + OS);
			return "/Drivers/chromedriverLinux";
		}

	}

	// Login into Application
	// @BeforeTest(alwaysRun = true)
	public void Login() throws Exception {
		// test=report.startTest("Login into Application");
		LoginLogout.ExecuteLogin(driver);
		// System.out.println("Login Successful");
		// test.log(LogStatus.PASS, "User has successfully Login into Application");
	}

	// Logout from Application.
	// @AfterSuite(alwaysRun = true)
	public void Logout() throws Exception {
		LoginLogout.ExecuteLogout(driver);
		// System.out.println("Logout Successful");
		test.log(LogStatus.PASS, "User has successfully Logout from Application");
	}

	@Parameters("env")
	@BeforeTest(alwaysRun = true)
	public static void Report(String env) 
	{
		DateFormat df = new SimpleDateFormat("_dd-MM-yyyy_hh-mm-ss");
		String timeStamp = df.format(new Date());
		String currentDir1 = System.getProperty("user.dir") + "/Reports/TestReport";
		String finalPath = currentDir1 + timeStamp + "_.html";
		report = new ExtentReports(finalPath, true);

		// comment below two lines to get the reports with TimeStamps
		String currentDir2 = System.getProperty("user.dir") + "/Reports/TestReport.html";
		report = new ExtentReports(currentDir2, true);

		report.addSystemInfo("Host Name", "CloudBlaze").addSystemInfo("Environment", env).addSystemInfo("OS", "Linux")
				.addSystemInfo("User Name", "Priyanka Chauhan");
		report.loadConfig(new File(System.getProperty("user.dir") + "/Properties/extent-config.xml"));

	}

	

	// Implementing Report Generation
	@AfterMethod(alwaysRun = true)
	public static void getResult(ITestResult result) throws Exception 
	{
		if (result.getStatus() == ITestResult.FAILURE) {
		test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			// To capture screenshot path and store the path of the screenshot in the string
			// "screenshotPath"
			// We do pass the path captured by this method in to the extent reports using
			// "logger.addScreenCapture" method.
			String screenshotPath = getScreenshot(driver, result.getName());
			// To add it in the extent report
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
		} 
		else if (result.getStatus() == ITestResult.SKIP) {
		test.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS) {
		test.log(LogStatus.PASS, "Test Case Ran is " + result.getName());
		} 
		else if (result.getStatus() == ITestResult.SUCCESS_PERCENTAGE_FAILURE) {
		test.log(LogStatus.INFO, "Test Case Success Perccentage_failure is" + result.getName());
		} 
		else {
		test.log(LogStatus.UNKNOWN, "Something wrong happened");
		}
	}

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Reports/FailedTestsScreenshots/" + screenshotName + " "
				+ dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	//@AfterSuite(alwaysRun = true)
	//public void tearDown() {
//	report.flush();
	//test.log(LogStatus.INFO, "Reports has been Flushed");
//	}
	}
