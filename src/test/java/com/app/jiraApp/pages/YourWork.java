package com.app.jiraApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourWork {
    WebDriver driver;
    public YourWork(WebDriver driver){
        this.driver = driver;
    }
    String yourWork = "css-1w30wgl";
    String projectName = "//div[contains(@class, 'sc-1lkicgf-2')]";
    public WebElement yourWork(){
        return driver.findElement(By.className(yourWork));
    }
    public WebElement projectName(){
        return driver.findElement(By.xpath(projectName));
    }
    public String getYourWork(){
        return yourWork().getText();
    }
    public void clickProjectTitle(){
        projectName().click();
    }
}
