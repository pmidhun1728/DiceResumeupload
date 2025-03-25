package org.commons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class Base {

    private WebDriver driver;

    @BeforeClass
    public WebDriver getDriver(){
        if(driver==null){
        setup();
        }
     return driver;
    }
         public void setup(){

             String browser = ConfigReader.getProperties("browser");
             String url = ConfigReader.getProperties("url");
             if(browser==null||browser.isEmpty()){
                 throw  new RuntimeException("browser not found in config file");
             }

             if("chrome".equalsIgnoreCase(browser)){
                 WebDriverManager.chromedriver().setup();
                 ChromeOptions options = new ChromeOptions();
                 driver = new ChromeDriver(options);
             } else if ("firefox".equalsIgnoreCase(browser)){
                 WebDriverManager.firefoxdriver().setup();
                 FirefoxOptions options = new FirefoxOptions();
                 driver = new FirefoxDriver(options);
             }

             driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
             driver.get(url);
         }

         @AfterClass
        public void logout(){
        if(driver!=null){
            driver.quit();
            driver =null;
        }
         }
}
