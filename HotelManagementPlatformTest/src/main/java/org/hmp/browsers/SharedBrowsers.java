package org.hmp.browsers;

import org.hmp.page_objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by inet-tech on 14/02/17.
 */
public class SharedBrowsers {

    protected static WebDriver driver;
    private FileInputStream fis;
    private Properties config = new Properties();

    public SharedBrowsers initialiseBrowser() throws Exception {

        if(driver == null){

            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/environment_testdata.properties");
            config.load(fis);
        }
        if(config.getProperty("browser").equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chrome_browser/chromedriver");
            driver = new ChromeDriver();
        }else if (config.getProperty("browser").equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if (config.getProperty("browser").equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/ie_browser/Internetexplorer");
            driver = new InternetExplorerDriver();
        }else{
            throw new Exception("There is no such browser");
        }
        return new SharedBrowsers();
    }

    public BasePage setUpBrowser(){
        driver.manage().window().maximize();
        return new BasePage(driver);
    }


    public void tearDownBrowser(){
        if(driver != null){
            driver.quit();
        }
    }
}
