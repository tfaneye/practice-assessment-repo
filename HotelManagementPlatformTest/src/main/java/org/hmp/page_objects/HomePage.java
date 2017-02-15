package org.hmp.page_objects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by inet-tech on 14/02/17.
 */
public class HomePage extends BasePage {


    private By loginfield = By.linkText("Login");
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButtonField = By.id("doLogin");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public DataEntryPage goToDataEntryPage(String username, String password){
        String mainHandle = driver.getWindowHandle();
        driver.findElement(loginfield).click();
        Set<String> handles = driver.getWindowHandles();
        for(String handle : handles){
            if(!handle.equalsIgnoreCase(mainHandle)){
                driver.switchTo().window(handle);
            }
        }

        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButtonField).click();
        driver.switchTo().window(mainHandle);
        return new DataEntryPage(driver);
    }
}
