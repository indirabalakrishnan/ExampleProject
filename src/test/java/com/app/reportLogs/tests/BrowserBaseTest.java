package com.app.reportLogs.tests;

import com.app.reportLogs.BrowserLogs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BrowserBaseTest {
    Logger logger = LogManager.getLogger(BrowserBaseTest.class);
    WebDriver webDriver = WebDriverManager.chromedriver().create();

    @BeforeClass
    public void setUp(){
        logger.info("Before Class - Setup");
        webDriver.get("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/503");
    }

    @BeforeClass
    public void setDriver(ITestContext context){
        context.setAttribute("WebDriver", webDriver);
    }

    @AfterClass
    public void tearDown(){
        logger.info("After Class - TearDown");
        webDriver.quit();
    }
}
