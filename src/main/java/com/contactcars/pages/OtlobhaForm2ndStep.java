package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;

import java.io.IOException;

public class OtlobhaForm2ndStep extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public OtlobhaForm2ndStep() throws IOException {
        super();
    }

    //Locator for promo code field
    By promoCode = By.id("promoCode");

    //Locator for apply promo code button
    By applyPromoCode = By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div > div > button");

    //Locator for delete promo code button
    By deletePromCode = By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div > div > button");

    //Locator for wallet option
    By walletOption = By.cssSelector("form > div:nth-child(2) > div > label:nth-child(2)");

    //Locator for submit button
    By submitButton = By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > button");

    //Locator for wallet number field
    By walletNumber = By.id("wallet-number");

    //Locator for proceed to pay buttom
    By proceedToPay = By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div:nth-child(4) > div > div:nth-child(2) > div > button");

    //Method to enter promo code
    public void enterPromoCode(String code) {
        driver.findElement(promoCode).sendKeys(code);
    }

    //Method to click on apply promo code button
    public void clickApplyPromoCode() {
        driver.findElement(applyPromoCode).click();
    }

    //Method to click on delete  promo code button
    public void clickDeletePromoCode() {
        driver.findElement(deletePromCode).click();
    }

    //Method to choose wallet option
    public void chooseWallet() {
        driver.findElement(walletOption).click();
    }

    //Method to click on submit button
    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    //Method to enter wallet number
    public void enterWalletNumber(String mobileNo) {
        driver.findElement(walletNumber).sendKeys(mobileNo);
    }

    //Method to click on proceed to pay button
    public void clickProceedToPay() {
        driver.findElement(proceedToPay).click();
    }

}
