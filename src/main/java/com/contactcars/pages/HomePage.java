package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class HomePage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage(WebDriver driver) throws IOException {
        super();
    }

    //Locator for skip button in notification pop up
    By skipButton = By.cssSelector("body > div > div > div:nth-child(2) > button:nth-child(2)");

    //Locator for login button
    By loginLink = By.cssSelector("header > div > div:nth-child(3) > button");

    //Locator for no thanks button
    By noThanksButton = By.cssSelector("body > div > div > div > div:nth-child(5) > button");

    //Locator for services link
    By servicesLink = By.cssSelector("header > nav > div > ul > li:nth-child(4) > span");

    //Locator for otlobha button
    By otlobhaButton = By.cssSelector("header > nav > div > ul > li:nth-child(4) > div > div > div > a > span");

    //Locator for showrooms link
    By showroomsLink = By.cssSelector("header > nav > div > ul > li:nth-child(5) > a");

    //Method to click on skip button in notification pop up
    public void clickSkip() {
        driver.findElement(skipButton).click();
    }

    //Method to click login link
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    //Method to click on no thanks button button
    public void clickNoThanks() {
       if(!driver.findElements(noThanksButton).isEmpty()) {
           driver.findElement(noThanksButton).click();
       }
    }

    //Method to hover on services link
    public void hoverOnServicesLink() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(servicesLink)).build().perform();
    }

    //Method to click on otlobha button
    public void clickOtlobhaButton() {
        driver.findElement(otlobhaButton).click();
    }

    //Method to click on showrooms link
    public void clickShowroomsLink() {
        driver.findElement(showroomsLink).click();
    }
}

