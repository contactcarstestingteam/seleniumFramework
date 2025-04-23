package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.valensas.undetected.chrome.driver.ChromeDriverBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OtlobhaPageTest extends TestBase {

    public OtlobhaPageTest() throws IOException {
        super();
    }

    @Test
    public void openOtlobhaLandingPage() throws InterruptedException {
        com.contactcars.testcases.LoginPageTest.login();
        Thread.sleep(5000);
//        WebElement carsLink = driver.findElement(By.cssSelector("header > nav > div > ul > li:nth-child(4) > span"));
//        action.moveToElement(carsLink).build().perform();
        WebElement servicesLink = driver.findElement(By.cssSelector("header > nav > div > ul > li:nth-child(4) > span"));
        Actions action = new Actions(driver);
        action.moveToElement(servicesLink).build().perform();
        WebElement otlobha = driver.findElement(By.cssSelector("header > nav > div > ul > li:nth-child(4) > div > div > div > a > span"));
        otlobha.click();
    }

    @Test
    public void openOtlobhaForm() throws InterruptedException {
        openOtlobhaLandingPage();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement requestNewCarButton = driver.findElement(By.cssSelector("main > div:nth-child(2) > section:nth-child(1) > div > div > div > div > div > div > a"));
        requestNewCarButton.click();
    }

    @Test
    public void addNewRequest() throws InterruptedException {
       openOtlobhaForm();
       // first step
        WebElement country = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(4) > div > input"));
        country.click();
        List<WebElement> allCountries = driver.findElements(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(4) > div > ul > li"));
        allCountries.get(0).click();

        WebElement make = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(6) > div > input"));
        make.click();
        List<WebElement> allMakes = driver.findElements(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(6) > div > ul > li"));
        allMakes.get(0).click();

        WebElement model = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(7) > div > input"));
        model.click();
        List<WebElement> allModels = driver.findElements(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(7) >div > ul > li"));
        allModels.get(0).click();

        WebElement agency = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(8) > div > div > div > label > input "));
        agency.click();

        WebElement year = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(9) > div > input"));
        year.click();
        List<WebElement> allYears = driver.findElements(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(9) > div > ul >li"));
        allYears.get(1).click();

        WebElement trim = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(10) > div > input"));
        trim.click();
        List<WebElement> allTrims= driver.findElements(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(10) > div > ul > li"));
        allTrims.get(0).click();

        WebElement next = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(12) > button "));
        next.click();
        Thread.sleep(5000);
        // terms and conditions popup
        WebElement agree = driver.findElement(By.cssSelector("main > div > div:nth-child(2) > div  > div > div > button"));
        agree.click();
        Thread.sleep(5000);
        // second step - promocode
        WebElement promoCode = driver.findElement(By.id("promoCode"));
        promoCode.sendKeys(sheet.getRow(1).getCell(8).toString());
//        promoCode.sendKeys("otbfree");
        WebElement apply = driver.findElement(By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div > div > button"));
        apply.click();
        Thread.sleep(5000);
        // second step - wallet
        WebElement deletePromoCode = driver.findElement(By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div > div > button"));
        deletePromoCode.click();
        WebElement wallet = driver.findElement(By.cssSelector("form > div:nth-child(2) > div > label:nth-child(2)"));
        wallet.click();
        WebElement submit = driver.findElement(By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > button"));
        submit.click();
        Thread.sleep(5000);
        WebElement mobileNumber = driver.findElement(By.id("wallet-number"));
        mobileNumber.sendKeys(sheet.getRow(1).getCell(5).toString());
//        mobileNumber.sendKeys("01010101010");
        WebElement proceedToPay = driver.findElement(By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div:nth-child(4) > div > div:nth-child(2) > div > button"));
        proceedToPay.click();
        Thread.sleep(5000);
        //payment gateway
        WebElement mPin = driver.findElement(By.id("userPin"));
        mPin.sendKeys(sheet.getRow(1).getCell(6).toString());
//        mPin.sendKeys("123456");
        WebElement otp = driver.findElement(By.id("userOTP"));
        otp.sendKeys(sheet.getRow(1).getCell(7).toString());
//        otp.sendKeys("123456");
        WebElement pay = driver.findElement(By.id("Pbutton"));
        pay.click();
    }

}
