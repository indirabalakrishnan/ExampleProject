package com.app.seleniumElements.pageElements;

import com.app.seleniumElements.pom.Registration;
import com.app.seleniumElements.tests.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;

public class webTables extends BaseTest {

    public WebDriver driver;

    public WebElement getNoData(){
       return driver.findElement(By.className("rt-noData"));
    }

    public WebElement getDeleteIcon(String fName) {
        return driver.findElement(By.xpath("//div[@class='rt-td'][text()='" + fName + "']/parent::*/child::div[7]//span[contains(@id,'delete-record')]"));
    }

    public WebElement getEditIcon(String fName) {
        return driver.findElement(By.xpath("//div[@class='rt-td'][text()='" + fName + "']/parent::*/child::div[7]//span[contains(@id,'edit-record')]"));
    }

    public WebElement firstNameValue(String fName) {
        return driver.findElement(By.xpath("//div[@class='rt-td'][text()='" + fName + "']"));
    }

    @BeforeTest
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        Duration duration = Duration.ofSeconds(10);
        driver.manage().timeouts().implicitlyWait(duration);
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        logger.info("Opened browser and url");
    }

    public void addRecord(Registration registration){
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(registration.getFirstName());
        driver.findElement(By.id("lastName")).sendKeys(registration.getLastName());
        driver.findElement(By.id("userEmail")).sendKeys(registration.getEmail());
        driver.findElement(By.id("age")).sendKeys(registration.getAge());
        driver.findElement(By.id("salary")).sendKeys(registration.getSalary());
        driver.findElement(By.id("department")).sendKeys(registration.getDepartment());
        driver.findElement(By.id("submit")).click();
        logger.info("Record added");
    }

    public void editRecord(Registration registration){
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(registration.getFirstName());
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(registration.getLastName());
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys(registration.getEmail());
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(registration.getAge());
        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("salary")).sendKeys(registration.getSalary());
        driver.findElement(By.id("department")).clear();
        driver.findElement(By.id("department")).sendKeys(registration.getDepartment());
        driver.findElement(By.id("submit")).click();
        logger.info("Record edited");
    }

    public void searchRecord(Registration registration){
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        searchBox.sendKeys(registration.getFirstName());
    }

    public void deleteRecord(Registration registration){
        getDeleteIcon(registration.getFirstName()).click();
    }

    public void editRecord(Registration registration, String fName){
        getEditIcon(fName).click();
        editRecord(registration);
    }

    public boolean checkRecordPresent(String fName){
        try{
            driver.findElement(By.xpath("//div[@class='rt-td'][text()='" + fName + "']"));
            return true;
        }catch (NoSuchElementException e){
            logger.error("Element not found");
            return false;
        }
    }

    @Test
    public void addRecordTest(){
        extentTest = extentReports.createTest("addRecordTest");
        Registration registration = new Registration("A", "B", "a@test.com", "23", "10000", "it");
        addRecord(registration);
        Assert.assertTrue(firstNameValue(registration.getFirstName()).isDisplayed());
        deleteRecord(registration);
    }

    @Test
    public void deleteRecordTest(){
        extentTest = extentReports.createTest("deleteRecordTest");
        Registration registration = new Registration("A", "B", "a@test.com", "23", "10000", "it");
        addRecord(registration);
        deleteRecord(registration);
        Assert.assertFalse(checkRecordPresent(registration.getFirstName()));
    }

    @Test
    public void editRecordTest(){
        extentTest = extentReports.createTest("editRecordTest");
        Registration registration = new Registration("A", "B", "a@test.com", "23", "10000", "it");
        addRecord(registration);
        Registration editRegistration = new Registration("A1", "B1", "a1@test.com", "23", "10000", "it");
        editRecord(editRegistration, registration.getFirstName());
        Assert.assertTrue(firstNameValue(editRegistration.getFirstName()).isDisplayed());
        Assert.assertFalse(checkRecordPresent(registration.getFirstName()));
        deleteRecord(editRegistration);
    }

    @Test
    public void searchRecordTest(){
        extentTest = extentReports.createTest("searchRecordTest");
        Registration registration = new Registration("searchA", "searchB", "a@test.com", "23", "10000", "it");
        addRecord(registration);
        searchRecord(registration);
        Assert.assertTrue(checkRecordPresent(registration.getFirstName()));
        deleteRecord(registration);
        Assert.assertFalse(checkRecordPresent(registration.getFirstName()));
        Assert.assertEquals(getNoData().getText(), "No rows found");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
