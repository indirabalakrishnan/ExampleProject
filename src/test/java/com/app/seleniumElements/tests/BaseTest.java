package com.app.seleniumElements.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest{

    public static Logger logger = LogManager.getLogger(BaseTest.class);

    public WebDriver driver;
    ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

    @BeforeTest
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        Duration duration = Duration.ofSeconds(10);
        driver.manage().timeouts().implicitlyWait(duration);
        driver.get("http://a.testaddressbook.com/");
        driver.manage().window().maximize();
        login();
        logger.info("Login successful");
    }

    public void login(){
        driver.findElement(By.id("sign-in")).click();
        driver.findElement(By.id("session_email")).sendKeys("kexesobepu@zsero.com");
        driver.findElement(By.id("session_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.findElement(By.linkText("Addresses")).click();
        logger.info("Username and Password entered");
    }

    @AfterTest
    public void tearDown(){

    }

    @BeforeClass
    public void setExtentReport(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/extent/report.html");
        extentSparkReporter.config().setDocumentTitle("AutomationReport");
        extentSparkReporter.config().setReportName("FunctionalReport");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("Tester", "Indira");
        extentReports.setSystemInfo("date", String.valueOf(System.currentTimeMillis()));
    }

    @AfterMethod
    public void extentTearDown(ITestResult testResult) throws IOException {
        if(testResult.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, "Test Case is FAILED :" + testResult.getName());
            extentTest.log(Status.FAIL, "Exception thrown :" + testResult.getThrowable());
            String screenshotPath = takeScreenshot(driver, testResult.getName());
            extentTest.addScreenCaptureFromPath(screenshotPath);
//            extentTest.fail(excelUtils.screenshot(testResult.getName()));
        } else if (testResult.getStatus() == ITestResult.SKIP){
            extentTest.log(Status.SKIP, "Test Case is SKIPPED :" + testResult.getName());
        } else if (testResult.getStatus() == ITestResult.SUCCESS){
            extentTest.log(Status.PASS, "Test Case is PASSED :" + testResult.getName());
        }
    }

    @AfterTest
    public void endReport(){
        extentReports.flush();
    }

    public String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/screenshots/"+screenshotName+dateName+".png";
        File fileDestination = new File(destination);
        FileUtils.copyFile(source, fileDestination);
        return destination;
    }
}
