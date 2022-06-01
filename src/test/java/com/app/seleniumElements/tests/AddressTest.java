package com.app.seleniumElements.tests;

import com.app.seleniumElements.pages.AddressPage;
import com.app.seleniumElements.pom.Address;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AddressTest extends BaseTest{

    AddressPage addressPage = new AddressPage(driver);

    @Test
    public void createAddressTest(){
        Address address = new Address("Indira", "Balakrishnan", "CNKRoad", "Chennai" , "600005");
        String actual = addressPage.addAddress(address);
        Assert.assertEquals(actual, "records successfully created");
    }

    @Test
    public void deleteAddress(){
        Address address = new Address("Indira", "Balakrishnan", "CNKRoad", "Chennai" , "600005");
        String successMessage = addressPage.addAddress(address);
        String deleteMessage = addressPage.deleteAddress(address.getFirstName());
        Assert.assertEquals(deleteMessage, "Records successfully deleted");
    }

    @Test
    public void editAddress(){
        Address address = new Address("Indira", "Balakrishnan", "CNKRoad", "Chennai" , "600005");
        String successMessage = addressPage.addAddress(address);
        address.setCity("Bangalore");
        address.setPincode("560001");
        String editMessage = addressPage.editAddress(address, address.getFirstName());
        Assert.assertEquals(editMessage, "Records successfully edited");
    }

    @Test
    public void showAddress(){
        Address address = new Address("Indira", "Balakrishnan", "CNKRoad", "Chennai" , "600005");
        String successMessage = addressPage.addAddress(address);
        String showValue = addressPage.showAddress(address.getFirstName());
        Assert.assertEquals(showValue, address.getFirstName());
    }
}
