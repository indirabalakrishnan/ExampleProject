package com.app.seleniumElements.actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
Action need build and perform.
Actions perform will do build itself.
 */

public class DragAndDrop {
    WebDriver driver;
    WebElement source;
    WebElement target;
    Actions actions;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        source = driver.findElement(By.id("draggable"));
        target = driver.findElement(By.id("droppable"));
        actions = new Actions(driver);
    }

    @Test
    public void dragAndDropTest(){
        actions.dragAndDrop(source, target).perform();
        System.out.println(target.getText());
    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}

