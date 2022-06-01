package com.app.parallelTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager {
    public String reportPath = System.getProperty("user.dir")+"/reports/Automation_Report_"+getUniqueName()+".html";

    ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;

    public ExtentReports startExtent(){
        extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentSparkReporter.config().setReportName("Regression Report");
        extentSparkReporter.config().setDocumentTitle("Regression Test");
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

    public String getUniqueName(){
        return new SimpleDateFormat().format(new Date()).replaceAll("[^\\dA-Za-z]|PM|AM", "");
    }
}
