package com.app.seleniumElements.pageElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class click {

    public WebDriver driver;
    String doubleClickMessage = "You have done a double click";
    String rightClickMessage = "You have done a right click";
    String dynamicClickMessage = "You have done a dynamic click";

    @BeforeTest
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        Duration duration = Duration.ofSeconds(10);
        driver.manage().timeouts().implicitlyWait(duration);
        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();
    }

    public WebElement doubleClickButton(){
        return driver.findElement(By.id("doubleClickBtn"));
    }

    public WebElement rightClickButton(){
        return driver.findElement(By.id("rightClickBtn"));
    }

    public WebElement dynamicClickButton(){
        return driver.findElement(By.id("EaMVf"));
    }

    public String doubleClickMessage(){
        return driver.findElement(By.id("doubleClickMessage")).getText();
    }

    public String rightClickMessage(){
        return driver.findElement(By.id("rightClickMessage")).getText();
    }

    public String dynamicClickMessage(){
        return driver.findElement(By.id("dynamicClickMessage")).getText();
    }

    public void doubleClick(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.doubleClick(webElement).perform();
    }

    public void rightClick(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.contextClick(webElement).perform();
    }

    public void dynamicClick(WebElement webElement){
        webElement.click();
    }

    @Test
    public void clickTest(){
        doubleClick(doubleClickButton());
        Assert.assertEquals(doubleClickMessage(), doubleClickMessage);
        rightClick(rightClickButton());
        Assert.assertEquals(rightClickMessage(), rightClickMessage);
        dynamicClickButton().click();
        Assert.assertEquals(dynamicClickMessage(), dynamicClickMessage);
    }


    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
