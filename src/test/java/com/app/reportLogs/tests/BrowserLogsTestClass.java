package com.app.reportLogs.tests;

import com.app.annotations.customAnnotations.Jira;
import com.app.reportLogs.BrowserLogs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserLogsTestClass extends BrowserBaseTest{
    @Test
    @Jira(id = "RR-2")
    public void logsTest(){
        logger.info("@Test");
        Assert.assertTrue(false);
    }

    @Test
    @Jira(id = "RR-1")
    public void logsTest2(){
        logger.info("@Test");
        Assert.assertTrue(true);
    }
}
