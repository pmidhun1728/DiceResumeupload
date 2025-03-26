package org.pages;

import org.commons.Base;
import org.openqa.selenium.*;
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

    public void clickUploadNewResume() throws InterruptedException {

        String cssSelectorForHost1 = "dhi-candidates-wired-candidate-profile[class='theme-candidates hydrated']";
        String cssSelectorForHost2 = " dhi-candidates-candidate-profile:nth-child(2) > article:nth-child(1) > div:nth-child(3) > seds-container:nth-child(1) > seds-row:nth-child(1) > seds-column:nth-child(1) > dhi-candidates-wired-candidate-profile-resume:nth-child(1) > dhi-candidates-candidate-profile-resume:nth-child(1) > dhi-candidates-card:nth-child(1) > div:nth-child(2) > div:nth-child(1) > dhi-candidates-candidate-profile-resume-field:nth-child(1) > div:nth-child(1) > div:nth-child(3) > dhi-candidates-file-upload-button:nth-child(1) > label:nth-child(1) > seds-button:nth-child(2)";
        Thread.sleep(1000);
        SearchContext shadow0 = driver.findElement(By.cssSelector("dhi-candidates-wired-candidate-profile[class='theme-candidates hydrated']"))
                .getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow0.findElement(By.cssSelector(" dhi-candidates-candidate-profile:nth-child(2) > article:nth-child(1) > div:nth-child(3) > seds-container:nth-child(1) > seds-row:nth-child(1) > seds-column:nth-child(1) > dhi-candidates-wired-candidate-profile-resume:nth-child(1) > dhi-candidates-candidate-profile-resume:nth-child(1) > dhi-candidates-card:nth-child(1) > div:nth-child(2) > div:nth-child(1) > dhi-candidates-candidate-profile-resume-field:nth-child(1) > div:nth-child(1) > div:nth-child(3) > dhi-candidates-file-upload-button:nth-child(1) > label:nth-child(1) > seds-button:nth-child(2)"))
                .getShadowRoot();
        Thread.sleep(1000);
        shadow1.findElement(By.cssSelector(".seds-button.seds-button-secondary")).click();

        WebElement uploadElement = driver.findElement(By.id("uploadFileInput"));
        uploadElement.sendKeys("Users\\midhunpavuluru\\Downloads\\MIDHUN PAVULURU_resume.pdf");
    }



    public void login(String user, String password) {
        enterUsername(user);
        enterPassword(password);
        clickSubmitButton();
    }
}