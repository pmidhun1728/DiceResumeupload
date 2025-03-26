package org.test;

import org.commons.Base;
import org.openqa.selenium.WebDriver;
import org.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {

    private WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void initializeDriver(){
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }


    @Test
    public void login() throws InterruptedException {

        loginPage.login("midhun.pavuluru@gmail.com", "");
        loginPage.clickProfilePage();
        loginPage.clickUploadNewResume();
    }

}
