package com.contactcars.pages;

import com.contactcars.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class LoginPage extends HomePage {

    private WebDriver driver;
    private WaitUtils wait;

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
        this.wait = new WaitUtils(driver, 30);
    }

    //Locator for mobile number
    By mobileNumber = By.id("mobile");

    //Locator for login buttom
    By loginButton = By.xpath("//button[@type = 'submit']");

    //Locator for otp
    By oneTimePassword = By.id("otp-number");

    //Locator for confirm button
    By confirmButton = By.cssSelector("body > div:last-child > div > div > div:nth-child(2) > form > button:nth-of-type(2)");

    //Method to enter mobile number
//    public void enterMobileNumber(String mobileNo) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));
//        mobileInput.sendKeys(mobileNo);
//    }
    public void enterMobileNumber(String mobileNo) {
        WebElement mobileInput = wait.waitForElementVisible(mobileNumber);
        mobileInput.sendKeys(mobileNo);
    }

    //Method to click on login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    //Method to enter mobile number
//    public void enterOtp(String otp) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(oneTimePassword));
//        otpInput.sendKeys(otp);
////        driver.findElement(oneTimePassword).sendKeys(otp);
//    }
public void enterOtp(String otp) {
    WebElement otpInput = wait.waitForElementVisible(oneTimePassword);
    otpInput.sendKeys(otp);
}

    //Method to click on confirm button
//    public void clickConfirm() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.cssSelector("body > div:last-child > div > div > div:nth-child(2) > form > button:nth-of-type(2)")
//        ));
//        confirmButton.click();
//    }

//    public void clickConfirm() {
//        WebElement confirmBtn = wait.waitForElementClickable(confirmButton);
//        confirmBtn.click();
//    }
    public void clickConfirm() {
        WebElement confirmBtn = wait.waitForElementClickable(confirmButton);
        confirmBtn.click();

        wait.waitForUrlNotContains("login");
    }

//    public void loginScenario() throws InterruptedException {
//        clickLoginLink();
//       // Thread.sleep(5000);
//        enterMobileNumber(csv.getVariableValueFromSheet1("MobileNo"));
//        clickLogin();
//       // Thread.sleep(5000);
//        enterOtp(csv.getVariableValueFromSheet1("OTP"));
//        clickConfirm();
//      //  Thread.sleep(5000);
//        clickNoThanks();
//    }

    public void loginScenario() {

        wait.waitForElementClickable(loginLink);
        clickLoginLink();
        enterMobileNumber(csv.getVariableValueFromSheet1("MobileNo"));
        clickLogin();
        enterOtp(csv.getVariableValueFromSheet1("OTP"));
        clickConfirm();
        clickNoThanks();
    }

}
