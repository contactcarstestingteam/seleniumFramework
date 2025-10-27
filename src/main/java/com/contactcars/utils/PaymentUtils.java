package com.contactcars.utils;

import com.contactcars.pages.CardPaymentGateway;
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
    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();

    public PaymentUtils(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    public void payWithCard() throws IOException {
        //Creating object of card payment gateway page
        CardPaymentGateway card = new CardPaymentGateway();
        card.enterCardNumber(csv.getVariableValueFromSheet1("Card No"));
        card.enterCardName(csv.getVariableValueFromSheet1("Card Name"));
        card.enterCardDate(csv.getVariableValueFromSheet1("Date"));
        card.enterCardCVV(csv.getVariableValueFromSheet1("CVV"));
        card.clickPay();
    }


    // Pay with wallet
    public void payWithWallet() throws IOException {
        WalletPaymentGateway wallet = new WalletPaymentGateway();

        try {
            wallet.enterMPin(csv.getVariableValueFromSheet1("Mpin"));
            wallet.enterOtp(csv.getVariableValueFromSheet1("WalletOTP"));
            wallet.clickPay();
        } catch (NoSuchElementException e) {
            driver.navigate().refresh();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='mpin']")));

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

            wallet.enterMPin(csv.getVariableValueFromSheet1("Mpin"));
            wallet.enterOtp(csv.getVariableValueFromSheet1("WalletOTP"));
            wallet.clickPay();
        }
    }

}
