package com.app.extentreports;

import com.app.reportLogs.Constants;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class TestListenerUtil {

    public String getJiraLink(String id){
        String url = "https://rishaan123.atlassian.net/browse/";
        String link = url + id;
        return link;
    }

    public String getHyperLink(String id){
        String link = "<a href=\"" + getJiraLink(id) + "\">"+id+"</a>";
        return link;
    }

    public File takeScreenshot(String methodName, WebDriver driver) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshot/"+methodName+"_"+System.currentTimeMillis());
        FileUtils.copyFile(src, dest);
        return dest;
    }

    public static void attachScreenshot(File screenshot, ThreadLocal<ExtentTest> extentTest){
        Media media = MediaEntityBuilder.createScreenCaptureFromPath(screenshot.getPath()).build();
        extentTest.get().info(media);
        extentTest.get().info("<a href='" + screenshot.getPath() + "'>" + screenshot + "</a>");
    }

    public static List<LogEntry> browserLogs(WebDriver webDriver){
        Logs logs = webDriver.manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        System.out.println("==================================");
        for (LogEntry logEntry : logEntries) {
            System.out.println(logEntry.getTimestamp() + ":" + logEntry.getLevel() + ":" + logEntry.getMessage());
        }
        System.out.println("==================================");

        List<LogEntry> failedLogEntries = logEntries.getAll().stream().filter(logEntry -> logEntry.getLevel().equals(Level.SEVERE)).collect(Collectors.toList());
        System.out.println("==================================");
        System.out.println(failedLogEntries);
        System.out.println("==================================");
        return logEntries.getAll();
    }

    public static List<LogEntry> networkLogs(WebDriver webDriver) {
        Logs logs = webDriver.manage().logs();
        LogEntries logEntries = logs.get(LogType.PERFORMANCE);
        return logEntries.getAll();
    }

    public static String getDirectoryPath(){
        String appPath = "/Users/indiramb/Neev_Projects/UIAutomationPipelineDemo";
        if (System.getProperty("appPath")==null)
            return appPath + Constants.REPORTING_DIR + Constants.BROWSER_LOGS_DIR ;
        else return System.getProperty("appPath") + Constants.REPORTING_DIR + Constants.BROWSER_LOGS_DIR;
    }

    public static String getScreenshotDirectoryPath(){
        String appPath = "/Users/indiramb/Neev_Projects/UIAutomationPipelineDemo";
        if (System.getProperty("appPath")==null)
            return appPath + Constants.REPORTING_DIR + Constants.SCREENSHOTS_DIR ;
        else return System.getProperty("appPath") + Constants.REPORTING_DIR + Constants.SCREENSHOTS_DIR;
    }

    public static File createFile(String path) {
        checkDirectory(getDirectoryPath());
        File myObj = null;
        try {
            myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return myObj;
    }

    public static String getFilePath(){
        String appPath = "/Users/indiramb/Neev_Projects/UIAutomationPipelineDemo";
        if (System.getProperty("appPath")==null)
            return appPath + Constants.REPORTING_DIR + Constants.BROWSER_LOGS_DIR + "/browserLogs_" + System.currentTimeMillis() + ".csv";
        else return System.getProperty("appPath") + Constants.REPORTING_DIR + Constants.BROWSER_LOGS_DIR + "/browserLogs_" + System.currentTimeMillis() + ".csv";
    }

    public static void checkDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()){
            directory.mkdir();
        }
    }

    public static File writeFile(List<LogEntry> logEntries) throws IOException {
        File file = createFile(getFilePath());
        if (file.isFile()) {
            FileWriter fileWriter = new FileWriter(file);
            for (LogEntry logEntry : logEntries) {
                fileWriter.write((int) logEntry.getTimestamp());
                fileWriter.write(",");
                fileWriter.write(String.valueOf(logEntry.getLevel()));
                fileWriter.write(",");
                fileWriter.write(logEntry.getMessage());
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } else {
            System.out.println("File is not created");
        }
        return file;
    }

    public static String fileAttachmentLink(File file){
        return "<a href = '"+file.getPath()+"'>" + file + "</a>";
    }

    public String takeScreenshot(WebDriver driver) throws IOException {
        String fileName = "/screenshot_debug_"+System.currentTimeMillis()+".png";
        String filepath = getScreenshotDirectoryPath()+fileName;
        File file =  takeScreenshot(driver, filepath);
        return fileAttachmentLink(file);
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

    public static Media getScreenshotAsMedia(File file){
        Media media = MediaEntityBuilder.createScreenCaptureFromPath(file.getPath()).build();
        return media;
    }
}
