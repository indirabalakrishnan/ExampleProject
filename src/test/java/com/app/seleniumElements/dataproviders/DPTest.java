//package com.app.seleniumElements.dataproviders;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import ui.pom.Registration;
//
//import java.time.Duration;
//
//public class DPTest {
//
//    public WebDriver driver;
//
//    public WebElement getDeleteIcon(String fName) {
//        return driver.findElement(By.xpath("//div[@class='rt-td'][text()='" + fName + "']/parent::*/child::div[7]//span[contains(@id,'delete-record')]"));
//    }
//
//    public WebElement firstNameValue(String fName) {
//        return driver.findElement(By.xpath("//div[@class='rt-td'][text()='" + fName + "']"));
//    }
//
//    public void deleteRecord(Registration registration){
//        getDeleteIcon(registration.getFirstName()).click();
//    }
//
//    public void addRecord(Registration registration){
//        driver.findElement(By.id("addNewRecordButton")).click();
//        driver.findElement(By.id("firstName")).sendKeys(registration.getFirstName());
//        driver.findElement(By.id("lastName")).sendKeys(registration.getLastName());
//        driver.findElement(By.id("userEmail")).sendKeys(registration.getEmail());
//        driver.findElement(By.id("age")).sendKeys(registration.getAge());
//        driver.findElement(By.id("salary")).sendKeys(registration.getSalary());
//        driver.findElement(By.id("department")).sendKeys(registration.getDepartment());
//        driver.findElement(By.id("submit")).click();
//    }
//
//    @BeforeTest
//    public void setUp(){
//        ChromeOptions chromeOptions = new ChromeOptions();
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver(chromeOptions);
//        Duration duration = Duration.ofSeconds(10);
//        driver.manage().timeouts().implicitlyWait(duration);
//        driver.get("https://demoqa.com/webtables");
//        driver.manage().window().maximize();
//    }
//
//    @DataProvider(name = "dataName1")
//    public static Object[][] data1(){
//        return new Object[][]{
//                {"A", "B", "a@test.com", "23", "1000", "IT"},
//                {"A2", "B2", "a2@test.com", "23", "1000", "IT"}
//        };
//    }
//
//    @DataProvider(name = "dataName2")
//    public static Object[][] data2(){
//        return new Object[][]{
//                {new Registration("A", "B", "a@test.com", "23", "1000", "IT")},
//                {new Registration("A2", "B2", "a2@test.com", "23", "1000", "IT")}
//        };
//    }
//
//    @Test(dataProvider = "dataName1")
//    public void addRecordTest(String s1, String s2, String s3, String s4, String s5, String s6){
//        Registration registration = new Registration(s1, s2, s3, s4, s5, s6);
//        addRecord(registration);
//        Assert.assertTrue(firstNameValue(registration.getFirstName()).isDisplayed());
////        deleteRecord(registration);
//    }
//
//    @Test(dataProvider = "dataName2")
//    public void addRecordTest2(Registration registration){
//        addRecord(registration);
//        Assert.assertTrue(firstNameValue(registration.getFirstName()).isDisplayed());
////        deleteRecord(registration);
//    }
//
//    @Test(dataProvider = "dataName3", dataProviderClass = DPClass.class)
//    public void addRecordTest3(Registration registration){
//        addRecord(registration);
//        Assert.assertTrue(firstNameValue(registration.getFirstName()).isDisplayed());
////        deleteRecord(registration);
//    }
//
//    @Test(dataProvider = "dataName4", dataProviderClass = DPClass.class)
//    public void addRecordTest4(String s1, String s2, String s3, String s4, String s5, String s6){
//        Registration registration = new Registration(s1, s2, s3, s4, s5, s6);
//        addRecord(registration);
//        Assert.assertTrue(firstNameValue(registration.getFirstName()).isDisplayed());
////        deleteRecord(registration);
//    }
//
//
//    @AfterTest
//    public void tearDown(){
////        driver.quit();
//    }
//}
