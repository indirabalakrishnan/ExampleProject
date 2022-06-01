package com.app.jiraApp;

import com.app.annotations.customAnnotations.Jira;
import com.app.extentreports.ReportingManager;
import com.app.jiraApp.pages.SignIn;
import com.app.jiraApp.pages.YourWork;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverLogLevel;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Endpoint;
import utils.ReadYaml;

import java.io.IOException;

public class BaseTest{
    WebDriver driver;

    Logger logger = LogManager.getLogger(BaseTest.class);
    ReportingManager reportingManager = new ReportingManager(driver);

    public String baseUrl = Endpoint.baseURL;

    @BeforeClass
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().create();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.setLogLevel(ChromeDriverLogLevel.ALL);

        driver = ChromeDriver.builder().build();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        logger.info("Chrome Browser Opened Successfully");
        YourWork yourWork = signIn(driver);
        Thread.sleep(5000);
        if (yourWork.getYourWork().equals("Your work")){
            yourWork.clickProjectTitle();
        } else {
            throw new Exception("Your work page didnt load up");
        }
    }

    public YourWork signIn(WebDriver driver) throws IOException, InterruptedException {
        SignIn signIn = new SignIn(driver);
        ReadYaml readYaml = new ReadYaml();
        signIn.enterUsername(readYaml.getUserName());
        signIn.clickContinue();
        Thread.sleep(3000);
        signIn.enterPassword(readYaml.getPassword());
        logEntries();
        networkLogs();
        return signIn.clickLogin();
    }

    public void logEntries(){
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for(LogEntry logEntry : logEntries){
            logger.info(logEntry.getTimestamp() + " : " + logEntry.getLevel() + " : "+logEntry.getMessage());
        }
    }

    public void networkLogs(){
        LogEntries logEntries = driver.manage().logs().get(LogType.PERFORMANCE);
        for(LogEntry logEntry : logEntries){
            logger.info(logEntry.getTimestamp() + " : " + logEntry.getLevel() + " : "+logEntry.getMessage());
        }    }

    @Jira(id = "RR-2")
    @Test
    public void signInTest() throws IOException {
        System.out.println("Hi");
        reportingManager.attachScreenshot(driver);
    }
}
