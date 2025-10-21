package com.contactcars.utils;

import com.contactcars.pages.CradPaymentGateway;
import com.contactcars.pages.WalletPaymentGateway;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

public class PaymentUtils  {

    private final WebDriver driver;

    public PaymentUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void payWithCard() throws IOException {
        //Creating object of card payment gateway page
        CradPaymentGateway card = new CradPaymentGateway();
        card.enterCardNumber(CsvUtils.getVariableValueFromSheet1("Card No"));
        card.enterCardName(CsvUtils.getVariableValueFromSheet1("Card Name"));
        card.enterCardDate(CsvUtils.getVariableValueFromSheet1("Date"));
        card.enterCardCVV(CsvUtils.getVariableValueFromSheet1("CVV"));
        card.clickPay();
    }


    // Pay with wallet
    public void payWithWallet() throws IOException {
        WalletPaymentGateway wallet = new WalletPaymentGateway();

        try {
            wallet.enterMPin(CsvUtils.getVariableValueFromSheet1("Mpin"));
            wallet.enterOtp(CsvUtils.getVariableValueFromSheet1("WalletOTP"));
            wallet.clickPay();
        } catch (NoSuchElementException e) {
            driver.navigate().refresh();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='mpin']")));

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

            wallet.enterMPin(CsvUtils.getVariableValueFromSheet1("Mpin"));
            wallet.enterOtp(CsvUtils.getVariableValueFromSheet1("WalletOTP"));
            wallet.clickPay();
        }
    }

}
