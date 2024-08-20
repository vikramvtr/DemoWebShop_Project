package com.qsp.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qsp.objectrepository.HomePage;
import com.qsp.objectrepository.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public FileUtility fileUtility;
	public HomePage homepage;
	public LoginPage loginpage;
	public JavaUtility SystemTime;
	public ExcelUtility excelutility;
	public static ExtentReports extReport;
	public ExtentTest  test;

	@BeforeSuite
	public void reportConfig()
	{
		SystemTime = new JavaUtility();
		String timestamp = SystemTime.getSystemTime();
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/ExtentReports_"+timestamp+".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}


	@Parameters("Browser")
	@BeforeClass
	public void LaunchBrowser(@Optional("chrome")String browserName) throws IOException
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver= new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		fileUtility = new FileUtility();
		String url = fileUtility.getDataFromProperty("url");
		driver.get(url);
	}
	@BeforeMethod
	public void LoginPages() throws IOException 
	{
		String email = fileUtility.getDataFromProperty("email");
		String pwd = fileUtility.getDataFromProperty("pwd");
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);


		homepage.getLoginLink().click();
		loginpage.getEmailTextField().sendKeys(email);
		loginpage.getPasswordTextField().sendKeys(pwd);
		loginpage.getLoginButton().click();
	}
	@AfterMethod
	public void LogoutPage()
	{
		homepage.getLoginOutLink();
	}
	@AfterClass
	public void ClosePage()
	{
		driver.quit();
	}
	@AfterSuite
	public void reportBackup()
	{
		extReport.flush();
	}
}
