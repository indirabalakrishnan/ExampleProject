//package com.app.seleniumElements.utils;
//
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.model.Media;
//import org.apache.commons.io.FileUtils;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class excelUtils {
//    public static void readFromExcel() throws Exception {
//        String FILE_PATH = "/Users/indiramb/Downloads/JavaAmazonAWSAccess/src/test/java/ui/dataproviders/Data.xlsx";
//        try {
//            FileInputStream fileInputStream = new FileInputStream(FILE_PATH);
//            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
//            XSSFSheet sheet = workbook.getSheet("Registration");
//            XSSFRow row = sheet.getRow(0);
//        }catch (FileNotFoundException e){
//            throw new Exception("File Not found Exception");
//        }
//    }
//    public static void main(String a[]) throws Exception {
//        readFromExcel();
//    }
//
//    public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
//        String dateName = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
//        TakesScreenshot screenshot = (TakesScreenshot) driver;
//        File source = screenshot.getScreenshotAs(OutputType.FILE);
//        String destination = System.getProperty("user.dir")+"/screenshots/"+screenshotName+dateName+".png";
//        File fileDestination = new File(destination);
//        FileUtils.copyFile(source, fileDestination);
//        return destination;
//    }
//
//    public static Media screenshot(String screenshotName){
//        String dateName = new SimpleDateFormat("yyyyMMddmmss").format(new Date());
//        return MediaEntityBuilder.createScreenCaptureFromPath(screenshotName+dateName+".png").build();
//    }
//}
