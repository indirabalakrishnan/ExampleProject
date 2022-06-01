package com.app.parallelTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ParallelTestListener implements ITestListener {
    ExtentReportManager extentReportManager = new ExtentReportManager();

    ExtentReports extentReports = extentReportManager.startExtent();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onTestStart(ITestResult iTestResult){
        ExtentTest test = extentReports.createTest(iTestResult.getMethod().getClass().getName() + ":" + iTestResult.getMethod().getMethodName());
        test.info("Info logs...");
        extentTest.set(test);
    }

    public void onTestSuccess(ITestResult iTestResult){
        extentTest.get().pass("Test Passed : " + iTestResult.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult iTestResult){
        extentTest.get().fail("Test Failed : " + iTestResult.getMethod().getMethodName());
    }

    public void onTestSkipped(ITestResult iTestResult){
        extentTest.get().fail("Test Skipped : " + iTestResult.getMethod().getMethodName());
    }

    public void onFinish(ITestContext iTestContext){
        extentReportManager.flushExtent();
    }
}
