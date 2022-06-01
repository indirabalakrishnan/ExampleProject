package com.app.testNGAnnotations;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest2 {

    public ExtentReportManager extentReportManager = new ExtentReportManager();
    public ExtentTest extentTest;
    public WebDriver driver;
    public String BASE_URL = "https://www.google.com";

    @BeforeClass
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get(BASE_URL);
        driver.manage().window().maximize();

        extentReportManager.startExtent();
    }

    @AfterMethod
    public void updateReport(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            extentTest.pass("Test Case Passed :"+ result.getName());
        } else if (result.getStatus() == ITestResult.SKIP){
            extentTest.skip("Test Case Skipped :"+ result.getName());
        } else if (result.getStatus() == ITestResult.FAILURE){
            extentTest.fail("Test case FAILED :" + result.getName());
//            extentTest.addScreenCaptureFromPath(getScreenshotPath());
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        extentReportManager.flushExtent();
    }
}
