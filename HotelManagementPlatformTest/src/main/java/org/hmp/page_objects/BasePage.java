package org.hmp.page_objects;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by inet-tech on 14/02/17.
 */
public class BasePage {

    private FileInputStream fis;
    protected WebDriver driver;
    private Properties config = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;

        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/environment_testdata.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            config.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public HomePage loadHomePage(){
        driver.navigate().to(config.getProperty("appUrl"));

        return new HomePage(driver);
    }
}
