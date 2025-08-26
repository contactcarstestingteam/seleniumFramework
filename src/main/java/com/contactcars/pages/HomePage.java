package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public HomePage() throws IOException {
        super();
    }

    //Locator for skip button in notification pop up
    By skipButton = By.cssSelector("body > div:last-child > div:nth-child(2) > button:last-child");

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

    //Locator for dealer ads section
    By dealerAds = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a");

    //Locator for all dealer ads prices
    By allAdsprices = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > div > span");

    //Locator for all dealer ads makes
    By allAdsMakes = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > h2 > span(1)");

    //Locator for all dealer ads models
    By allAdsModels = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > h2 > span(2)");

    //Locator for all dealer ads years
    By allAdsYears = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > h2 > span(3)");

    //Locator for all dealer ads names
    By allAdsNames = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > div > div > span");

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

    //Method to wait until dealer ads section appears
    public void waitDealerAds() {
        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use Explicit Wait to wait for a specific condition
        wait.until(ExpectedConditions.visibilityOfElementLocated(dealerAds));
    }

    //Method to get text for all dealer ads prices
    public void getAdsPrices() {
        List<WebElement> prices = driver.findElements(allAdsprices);
        for (int i = 0; i <= prices.size(); i++) {
            prices.get(i).getText();
        }
    }

    //Method to get text for all dealer ads makes
    public void getAdsMakes() {
        List<WebElement> makes = driver.findElements(allAdsMakes);
        for (int i = 0; i <= makes.size(); i++) {
            makes.get(i).getText();
        }
    }

    //Method to get text for all dealer ads models
    public void getAdsModels() {
        List<WebElement> models = driver.findElements(allAdsModels);
        for (int i = 0; i <= models.size(); i++) {
            models.get(i).getText();
        }
    }

    //Method to get text for all dealer ads years
    public void getAdsYears() {
        List<WebElement> years = driver.findElements(allAdsYears);
        for (int i = 0; i <= years.size(); i++) {
            years.get(i).getText();
        }
    }

    //Method to get text for all dealer ads names
    public void getAdsNames() {
        List<WebElement> names = driver.findElements(allAdsNames);
        for (int i = 0; i <= names.size(); i++) {
            names.get(i).getText();
        }
    }

}

