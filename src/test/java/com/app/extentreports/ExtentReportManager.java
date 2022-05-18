package com.app.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class ExtentReportManager {
    ExtentSparkReporter extentSparkReporter;
    ExtentReports extentReports;
    String filepath = System.getProperty("user.dir")+"/reports/Automation_report_"+getUniqueFileName()+".html";

    public ExtentReports startExtent(){
        extentSparkReporter = new ExtentSparkReporter(filepath);
        extentSparkReporter.config().setReportName("Automation");
        extentSparkReporter.config().setDocumentTitle("NeevTraining");
        extentSparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "Indira");
        extentReports.setSystemInfo("Date", String.valueOf(System.currentTimeMillis()));
        return extentReports;
    }

    public void flushExtent(){
        extentReports.flush();
    }

    public String getUniqueFileName(){
        return new SimpleDateFormat().format(new Date()).replaceAll("[^\\dA-Za-z]|PM|AM", "");
    }
}

