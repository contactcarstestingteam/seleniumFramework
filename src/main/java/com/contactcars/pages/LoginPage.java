package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public LoginPage() throws IOException {
        super();
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
    public void enterMobileNumber(String mobileNo) {
        driver.findElement(mobileNumber).sendKeys(mobileNo);
    }

    //Method to click on login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    //Method to enter mobile number
    public void enterOtp(String otp) {
        driver.findElement(oneTimePassword).sendKeys(otp);
    }

    //Method to click on confirm button
    public void clickConfirm() {
        driver.findElement(confirmButton).click();
    }


}
