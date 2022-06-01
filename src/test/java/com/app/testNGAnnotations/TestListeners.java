package com.app.testNGAnnotations;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    ExtentReportManager extentReportManager = new ExtentReportManager();

    private ExtentReports extentReports = extentReportManager.startExtent();
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getTestClass().getName() + "::" + result.getMethod().getMethodName());
        test.info("Test Started : " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Case Passed :"+ result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        extentTest.get().fail("Test Case Failed :"+ result.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult result) {
        extentTest.get().info("Test Case Skipped :"+ result.getMethod().getMethodName());
    }

    public void onFinish(ITestContext iTestContext){
        extentReports.flush();
    }
}

