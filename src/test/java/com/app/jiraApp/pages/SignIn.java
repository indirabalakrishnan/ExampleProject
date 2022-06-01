package com.app.jiraApp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.JiraCredentials;

public class SignIn {

    WebDriver driver;

    public SignIn(WebDriver driver){
        this.driver = driver;
    }

    String username = "username";
    String continueBtn = "login-submit";
    String password = "password";
    String login = "login-submit";

    public WebElement username(){
        return driver.findElement(By.id(username));
    }
    public WebElement password(){
        return driver.findElement(By.id(password));
    }

    public WebElement continueBtn(){
        return driver.findElement(By.id(continueBtn));
    }
    public WebElement loginBtn(){
        return driver.findElement(By.id(login));
    }

    public void enterUsername(String username){
        username().sendKeys(username);
    }

    public void enterPassword(String password){
        password().sendKeys(password);
    }
    public void clickContinue(){
        continueBtn().click();
    }

    public YourWork clickLogin(){
        loginBtn().click();
        return new YourWork(driver);
    }

}
