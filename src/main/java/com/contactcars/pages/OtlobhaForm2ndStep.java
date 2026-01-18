package com.contactcars.pages;

import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class OtlobhaForm2ndStep {

    private WebDriver driver;
    private WaitUtils wait;

    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();

    //Constructor that will be automatically called as soon as the object of the class is created
    public OtlobhaForm2ndStep(WebDriver driver) throws IOException {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 30);
    }

    //Locator for promo code field
    By promoCode = By.cssSelector("#promoCode");

    //Locator for apply promo code button
    By applyPromoCode = By.cssSelector("form > div:nth-child(1) > div > button");

    //Locator for delete promo code button
    By deletePromCode = By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div > div > button");

    //Locator for wallet option
    By walletOption = By.cssSelector("form > div:nth-child(2) > div > label:nth-child(2)");

    //Locator for submit button
    By submitButton = By.cssSelector("form > div.bg-white-900.p-3.mt-5 > div:last-child > button:last-child");

    //Locator for wallet number field
    By walletNumber = By.id("wallet-number");

    //Locator for proceed to pay button
    By proceedToPay = By.cssSelector("div.flex.flex-col.items-center.mt-6 > div > button");

    //Locator for fawry option
    By FawryOption= By.cssSelector("form > div:nth-child(2) > div > label:nth-child(3)");

    //Locator for Bank Card
    By BackCardOption = By.cssSelector("div:nth-child(2) > div > label:nth-child(1)");


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
//    public void chooseWallet() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement wallet = wait.until(ExpectedConditions.elementToBeClickable(walletOption));
//        wallet.click();
//    }

    public void chooseWallet() {
        WebElement wallet = wait.waitForElementClickable(walletOption);
        wallet.click();
    }

    //Method to click on submit button
//    public void clickSubmit() {
//        driver.findElement(submitButton).click();
//    }
    public void clickSubmit() {
        WebElement submitBtn = wait.waitForElementClickable(submitButton);
        submitBtn.click();
    }

    //Method to enter wallet number
//    public void enterWalletNumber(String mobileNo) {
//
//        driver.findElement(walletNumber).sendKeys(mobileNo);
//    }
    public void enterWalletNumber(String mobileNo) {
        WebElement walletField = wait.waitForElementVisible(walletNumber);
        walletField.clear();
        walletField.sendKeys(mobileNo);
    }

    //    public void clickProceedToPay() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement pay = wait.until(ExpectedConditions.elementToBeClickable(proceedToPay));
//        pay.click();
//    }

    public void clickProceedToPay() {
        WebElement pay = wait.waitForElementClickable(proceedToPay);
        pay.click();
    }

//    public void ChooseFawry() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement wallet = wait.until(ExpectedConditions.elementToBeClickable(FawryOption));
//        wallet.click();
//    }

    public void ChooseFawry() {
        WebElement wallet = wait.waitForElementClickable(FawryOption);
        wallet.click();
    }

    //Method TO choose Bank Card
//    public void ChooseBankCard() {
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//        WebElement BankCard = wait.until(ExpectedConditions.elementToBeClickable(BackCardOption));
//        BankCard.click();
//    }

    public void ChooseBankCard() {
        WebElement BankCard = wait.waitForElementClickable(BackCardOption);
        BankCard.click();
    }

    //Check on success page
//    public void CheckUrl() throws InterruptedException {
//        String expectedPartialUrl = csv.getVariableValueFromSheet1("OtlobhaSuccessURL");
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        boolean urlMatched = wait.until(ExpectedConditions.urlContains(expectedPartialUrl));
//
//        String actualUrl = driver.getCurrentUrl();
//        System.out.println("Actual URL: " + actualUrl);
//
//        Assert.assertTrue(actualUrl.contains(expectedPartialUrl), "URL doesn't contain expected value");
//
//        Thread.sleep(5000); //wait
//    }

    public void CheckUrl() throws InterruptedException {
        String expectedPartialUrl = csv.getVariableValueFromSheet1("OtlobhaSuccessURL");

        boolean urlMatched = wait.waitForUrlContains(expectedPartialUrl);

        String actualUrl = driver.getCurrentUrl();
        System.out.println("Actual URL: " + actualUrl);

        Assert.assertTrue(actualUrl.contains(expectedPartialUrl), "URL doesn't contain expected value");

        Thread.sleep(5000); //wait
    }

}
