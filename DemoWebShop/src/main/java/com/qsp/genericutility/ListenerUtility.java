package com.qsp.genericutility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerUtility extends BaseClass implements ITestListener {
    private WebDriverUtility webDriverUtility;

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test in ExtentReports for each test method
        test = extReport.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Test Script has failed", true);

        String methodName = result.getName();
        webDriverUtility = new WebDriverUtility(driver);
        String screenshotPath = null;
        try {
            screenshotPath = webDriverUtility.takeScreenshot(driver, methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Log the failure in ExtentReports and attach the screenshot
        if (screenshotPath != null) {
            test.fail("Test failed").addScreenCaptureFromPath(screenshotPath);
        } else {
            test.fail("Test failed but screenshot was not taken due to an error.");
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test Script has passed", true);

        String methodName = result.getName();
        webDriverUtility = new WebDriverUtility(driver);
        String screenshotPath = null;
        try {
            screenshotPath = webDriverUtility.takeScreenshot(driver, methodName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Log the success in ExtentReports and attach the screenshot
        if (screenshotPath != null) {
            test.pass("Test passed").addScreenCaptureFromPath(screenshotPath);
        } else {
            test.pass("Test passed but screenshot was not taken due to an error.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test Script was skipped", true);
        test.skip("Test skipped");
    }
}
