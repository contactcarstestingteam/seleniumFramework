package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

public class LoginPage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginPage() throws IOException {
        super();
    }

    //Locator for mobile number
    static By mobileNumber = By.id("mobile");

    //Locator for login buttom
    static By loginButton = By.xpath("//button[@type = 'submit']");

    //Locator for otp
    static By oneTimePassword = By.id("otp-number");

    //Locator for confirm button
    By confirmButton = By.cssSelector("body > div:last-child > div > div > div:nth-child(2) > form > button:nth-of-type(2)");

    //Method to enter mobile number
    public static void enterMobileNumber(String mobileNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumber));
        mobileInput.sendKeys(mobileNo);
    }

//    public void enterMobileNumber(String mobileNo) {
//        driver.findElement(mobileNumber).sendKeys(mobileNo);
//    }



    //Method to click on login button
    public static void clickLogin() {
        driver.findElement(loginButton).click();
    }

    //Method to enter mobile number
    public static void enterOtp(String otp) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement otpInput = wait.until(ExpectedConditions.visibilityOfElementLocated(oneTimePassword));
        otpInput.sendKeys(otp);
//        driver.findElement(oneTimePassword).sendKeys(otp);
    }

    //Method to click on confirm button
    public static void clickConfirm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("body > div:last-child > div > div > div:nth-child(2) > form > button:nth-of-type(2)")
        ));
        confirmButton.click();
    }
}
