package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class WalletPaymentGateway extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public WalletPaymentGateway() throws IOException {
        super();
    }

    //Locator for user pin
    By mPin = By.id("userPin");

    //Locator for user otp
    By otp = By.id("userOTP");

    //Locator for pay button
    By payButton = By.id("Pbutton");

    //Method to enter user pin
    public void enterMPin(String userPin) {
        driver.findElement(mPin).sendKeys(userPin);
    }

    //Method to enter user otp
    public void enterOtp(String userOtp) {
        driver.findElement(otp).sendKeys(userOtp);
    }

    //Method to click on pay button
    public void clickPay() {
        driver.findElement(payButton).click();
    }
}
