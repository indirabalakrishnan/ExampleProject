package com.app.seleniumElements.pages;

import com.app.seleniumElements.pom.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage {

    public WebDriver driver;

    @FindBy(id = "first_name")
    WebElement firstname1;

    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By add = By.id("address");
    private By city = By.id("city");
    private By pincode = By.id("pincode");
    private By newAddress = By.linkText("New Address");
    private By submitButton = By.id("btn-primary");
    private By displayMessage = By.id("error_explanation");
    private By firstNameValue = By.xpath("//span[@text()='firstNameValue']");

    public AddressPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickNewAddressLink(){
        driver.findElement(newAddress).click();
    }

    public String enterNewAddressDetails(Address address){
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(address.getFirstName());

        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(address.getLastName());

        driver.findElement(add).clear();
        driver.findElement(add).sendKeys(address.getAddress());

        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(address.getCity());

        driver.findElement(pincode).clear();
        driver.findElement(pincode).sendKeys(address.getPincode());

        driver.findElement(submitButton).click();

        return driver.findElement(displayMessage).getText();
    }

    public String addAddress(Address address){
        clickNewAddressLink();
        return enterNewAddressDetails(address);
    }

    public String editAddress(Address address, String fName){
        driver.findElement(By.id("//td[text()='"+fName+"']//following-sibling::td/a[text()='Edit']")).click();
        return enterNewAddressDetails(address);
    }

    public String deleteAddress(String fName){
        driver.findElement(By.id("//td[text()='"+fName+"']//following-sibling::td/a[text()='Destroy']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        return driver.findElement(displayMessage).getText();
    }

    public String showAddress(String fName){
        driver.findElement(By.id("//td[text()='"+fName+"']//following-sibling::td/a[text()='Show']")).click();
        return driver.findElement(firstNameValue).getText();
    }

}
