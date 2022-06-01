package com.app.extentreports;

import com.app.annotations.customAnnotations.Jira;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener extends TestListenerUtil implements ITestListener{
    Logger logger = LogManager.getLogger(TestListener.class);
    ExtentReportManager extentReportManager = new ExtentReportManager();
    ExtentReports extentReports = extentReportManager.startExtent();
    static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        test.info("Test Started");
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed : " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail("Test Failed : " + result.getMethod().getMethodName());
        Jira jira = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Jira.class);

        extentTest.get().info(result.getTestClass().getRealClass().getSimpleName());
        extentTest.get().info(jira.id());
        extentTest.get().info("Test Failed : " + getHyperLink(jira.id()));

        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver");

//        WebDriver webDriver = (WebDriver) result.getInstance();
//        List<LogEntry> logEntries = webDriver.manage().logs().get(LogType.BROWSER);
//        List<LogEntry> logEntries = browserLogs((WebDriver)result.getInstance());

        File file = null;
        try {
            file = writeFile(browserLogs(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.get().info("BrowserLogs Attachment : " + fileAttachmentLink(file));
        try {
            File file1 = new File(takeScreenshot(driver));
            extentTest.get().info("Screenshot : "+ fileAttachmentLink(file1));
            extentTest.get().info(getScreenshotAsMedia(file1));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped : " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReportManager.flushExtent();
    }

}

