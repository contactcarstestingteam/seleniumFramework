package com.contactcars.pages;

import com.contactcars.base.TestBase;
import com.contactcars.testcases.LoginPageTest;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static com.contactcars.pages.LoginPage.clickConfirm;
import static com.contactcars.pages.LoginPage.clickLogin;

public class HomePage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage() throws IOException {
        super();
    }

    //Locator for login button
static By loginLink = By.cssSelector("header > div > div:nth-child(3) > button");

    //Locator for no thanks button
    By noThanksButton = By.cssSelector("body > div > div > div > div:nth-child(5) > button");

    //Locator for services link
    static By servicesLink = By.cssSelector("header > nav > div > ul > li:nth-child(4) > span");

    //Locator for otlobha button
    static By otlobhaButton = By.cssSelector("header > nav > div > ul > li:nth-child(4) > div > div > div > a > span");

    //Locator for showrooms link
    By showroomsLink = By.cssSelector("header > nav > div > ul > li:nth-child(5) > a");


    //Method to click login link
    public static void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    //Method to click on no thanks button
    public void clickNoThanks() {
       if(!driver.findElements(noThanksButton).isEmpty()) {
           driver.findElement(noThanksButton).click();
       }
    }

    //Method to hover on services link
    public static void hoverOnServicesLink() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(servicesLink)).build().perform();
    }

    //Method to click on otlobha button
    public static void clickOtlobhaButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(otlobhaButton));
        button.click();
    }

    //Method to click on showrooms link
    public void clickShowroomsLink() {
        driver.findElement(showroomsLink).click();
    }

}

