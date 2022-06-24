package com.app.cv;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        HashMap<String,Object> chromePrefs = new HashMap<>();
        chromePrefs.put("plugins.always_open_pdf_externally", true);
        chromePrefs.put("download.default_directory", "/Users/indiramb/Downloads/5E");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get("http://chettinadvidyashram.in/chettinad/chettinadvidyashram/stuindex.aspx");
        login();
        selectWorkSheet();
    }

    public void login(){
        String username = "38293";
        String password = "01112016";
        WebElement userId = driver.findElement(By.id("ContentPlaceHolder1_txtstuid"));
        WebElement pwd = driver.findElement(By.id("ContentPlaceHolder1_txtpass"));
        WebElement submit = driver.findElement(By.id("ContentPlaceHolder1_btnstudent"));
        userId.sendKeys(username);
        pwd.sendKeys(password);
        submit.click();
    }

    public void selectWorkSheet(){
        WebElement workSheet = driver.findElement(By.id("btnhw"));
        workSheet.click();
    }

    public String getUrl(int rowNumber){
        WebElement viewLink = driver.findElement(By.xpath("//table[@id=\"ContentPlaceHolder1_gv1\"]/tbody/tr["+rowNumber+"]/td[6]/a"));
        return viewLink.getAttribute("href");
    }

    public String getSubjectCode(int rowNumber){
        WebElement code = driver.findElement(By.xpath("//table[@id=\"ContentPlaceHolder1_gv1\"]/tbody/tr["+rowNumber+"]/td[3]"));
        return code.getText();
    }

    public String getFileName(int rowNumber){
        return driver.findElement(By.xpath("//table[@id=\"ContentPlaceHolder1_gv1\"]/tbody/tr["+rowNumber+"]/td[5]")).getText();
    }

    public void startDownload() throws InterruptedException, IOException {
        String link;
        String code;
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"ContentPlaceHolder1_gv1\"]/tbody/tr"));
        for (int i=2; i< rows.size(); i++) {
            link = getUrl(i);
            code = getSubjectCode(i);
            if(link!=null) {
                driver.get(link);
                TimeUnit.SECONDS.sleep(3);
                copyFileToSpecificFolder(getFileName(i), code);
            }
        }
    }

    public void copyFileToSpecificFolder(String fileName, String code) throws IOException {
        File folder = new File("/Users/indiramb/Downloads/5E");
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println("File " + files[i].getName());
                File src = new File("/Users/indiramb/Downloads/5E/"+files[i].getName());
                File dest = new File("/Users/indiramb/Downloads/5E/"+code+"/"+fileName+".pdf");
                FileUtils.copyFile(src, dest);
                src.delete();
            } else if (files[i].isDirectory()) {
                System.out.println("Directory " + files[i].getName());
            }
        }
    }

    public String getYouTubeLink(int rowNumber){
        return driver.findElement(By.xpath("//table[@id=\"ContentPlaceHolder1_gv1\"]/tbody/tr["+rowNumber+"]/td[7]/a")).getAttribute("href");
    }

    public void createFiles() throws IOException {
        String path = "/Users/indiramb/Downloads/5E/";
        new File(path + "YouTube").mkdirs();
        path = "/Users/indiramb/Downloads/5E/YouTube/";
        for (Subject subject: Subject.values()) {
            File file = new File(path + subject.toString() + ".txt");
            file.createNewFile();
        }
    }

    public void copyYouTubeLink() throws IOException {
        createFiles();
        String code;
        String fileName;
        String youTubeLink;
        String path = "/Users/indiramb/Downloads/5E/YouTube/";
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id=\"ContentPlaceHolder1_gv1\"]/tbody/tr"));
        for (int i = 2; i < rows.size(); i++) {
            code = getSubjectCode(i);
            fileName = getFileName(i);
            youTubeLink = getYouTubeLink(i);
            if ( youTubeLink != null){
                File file = new File(path+code+".txt");
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(code + " : " + fileName + " : " + youTubeLink);
                fileWriter.write("\n");
                fileWriter.flush();
            }
        }
    }
}