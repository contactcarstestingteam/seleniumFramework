package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;

import java.io.IOException;

public class CradPaymentGateway extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public CradPaymentGateway() throws IOException {
        super();
    }

    //Locator for card number
    By cardNumber = By.xpath("//input [@name = 'number']");

    //Locator for card holder name
    By cardHolder = By.xpath("//input [@name = 'name']");

    //Locator for card expiry date
    By date = By.xpath("//input [@name = 'expiry']");

    //Locator for card cvv
    By cvv = By.xpath("//input [@name = 'cvc']");

    // Locator for pay button
    By submit = By.id("submitButton");


    //Method to enter card number
    public void enterCardNumber(String cardNo) {
        driver.findElement(cardNumber).sendKeys(cardNo);
    }

    //Method to enter card holder name
    public void enterCardName(String cardName) {
        driver.findElement(cardHolder).sendKeys(cardName);
    }

    //Method to enter card expiry date
    public void enterCardDate(String cardDate) {
        driver.findElement(date).sendKeys(cardDate);
    }

    //Method to enter card cvv
    public void enterCardCVV(String cardCVV) {
        driver.findElement(cvv).sendKeys(cardCVV);
    }

    //Method to click on pay button
    public void clickPay() {
        driver.findElement(submit).click();
    }

}
