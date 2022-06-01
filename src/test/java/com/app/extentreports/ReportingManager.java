package com.app.extentreports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReportingManager{
    WebDriver driver;

    public ReportingManager(WebDriver driver) {
        this.driver = driver;
    }

    public void attachScreenshot(WebDriver driver) throws IOException {
        File file = takeScreenshot(driver);
//        TestListener.attachScreenshot(file);
    }

    public File takeScreenshot(WebDriver driver) throws IOException {
        String fileName = "screenshot_debug_"+System.currentTimeMillis()+".png";
        String filepath = "/reports/screenshot/"+fileName;
        return takeScreenshot(driver, filepath);
    }

    public File takeScreenshot(WebDriver driver, String dest) throws IOException {
        File destination = new File(dest);
        File src = captureScreenshot(driver);
        FileUtils.copyFile(src, destination);
        return destination;
    }

    public File captureScreenshot(WebDriver driver){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        return src;
    }
}
