package com.app.reportLogs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

public class BrowserLogs {

    public static void main(String[] args) throws IOException {
        Logger logger = LogManager.getLogger(BrowserLogs.class);
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/503");
        Logs logs = webDriver.manage().logs();
        System.out.println(webDriver.manage().logs().getAvailableLogTypes());
        LogEntries logEntries = logs.get(LogType.BROWSER);
        System.out.println("==================================");
        for (LogEntry logEntry : logEntries) {
            logger.info("My logs here");
            System.out.println(logEntry.getTimestamp() + ":" + logEntry.getLevel() + ":" + logEntry.getMessage());
        }
        System.out.println("==================================");

        List<LogEntry> failedLogEntries = logEntries.getAll().stream().filter(logEntry -> logEntry.getLevel().equals(Level.SEVERE)).collect(Collectors.toList());
        System.out.println("==================================");
        System.out.println(failedLogEntries);
        System.out.println("==================================");
        writeFile(failedLogEntries);
    }

    public static String getDirectoryPath(){
        String appPath = "/Users/indiramb/Neev_Projects/UIAutomationPipelineDemo";
        if (System.getProperty("appPath")==null)
            return appPath + Constants.REPORTING_DIR + Constants.BROWSER_LOGS_DIR ;
        else return System.getProperty("appPath") + Constants.REPORTING_DIR + Constants.BROWSER_LOGS_DIR;
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

    public static void writeFile(List<LogEntry> logEntries) throws IOException {
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
    }

    public static String fileAttachmentLink(String path){
        return "<a href = '"+path+"'>" + path + "</a>";
    }
}
