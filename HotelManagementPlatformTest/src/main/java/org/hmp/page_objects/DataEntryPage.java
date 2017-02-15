package org.hmp.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by inet-tech on 14/02/17.
 */
public class DataEntryPage extends BasePage {

    private By hotelNameField = By.id("hotelName");
    private By addressField = By.id("address");
    private By ownerField = By.id("owner");
    private By phoneNumberField = By.id("phone");
    private By emailField = By.id("email");
    private By createButtonField = By.id("createHotel");


    public DataEntryPage(WebDriver driver) {
        super(driver);
    }

    public DataEntryPage populateEntryDetails(String hotelName, String address, String owner,
                                              String phoneNumber, String email){
        driver.findElement(hotelNameField).sendKeys(hotelName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(ownerField).sendKeys(owner);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(emailField).sendKeys(email);

        driver.findElement(createButtonField).click();

        return new DataEntryPage(driver);
    }

    public boolean validateEntry(String name){
        return driver.getPageSource().toLowerCase().contains(name.toLowerCase());
    }

    public boolean validateLogin(String logout) {
        return driver.getPageSource().toLowerCase().contains(logout.toLowerCase());
    }
}
