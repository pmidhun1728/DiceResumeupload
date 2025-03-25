package org.pages;

import org.commons.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage  {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//input[@id='react-aria-:Rd7rkqfncq:']")
    private WebElement userNameTextBox;

    @FindBy(xpath = "//input[@type=\"password\"]")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//span[text()=\"Continue\"]")
    private WebElement continueButton;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(), 'Go to my profile')]")
    private WebElement goToProfile;



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String user) {
        wait.until(ExpectedConditions.elementToBeClickable(userNameTextBox));
        userNameTextBox.click();
        userNameTextBox.clear();
        userNameTextBox.sendKeys(user);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordTextBox));
        passwordTextBox.click();
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        passwordTextBox.submit();
    }

    public void clickProfilePage() {
        wait.until(ExpectedConditions.elementToBeClickable(goToProfile));
        goToProfile.click();

    }

    public void login(String user, String password) {
        enterUsername(user);
        enterPassword(password);
        clickSubmitButton();
    }
}