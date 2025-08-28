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

    List<String> priceValues = new ArrayList<>();
    List<String> makeValues = new ArrayList<>();
    List<String> modelValues = new ArrayList<>();
    List<String> yearValues = new ArrayList<>();
    List<String> nameValues = new ArrayList<>();


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


    //Locator for dealer ads section
    By dealerAds = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a");

    //Locator for all dealer ads prices
    By allAdsprices = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > div > span");

    //Locator for all dealer ads makes
    By allAdsMakes = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > h2 > span:first-child");

    //Locator for all dealer ads models
    By allAdsModels = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > h2 > span:nth-child(2)");

    //Locator for all dealer ads years
    By allAdsYears = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > a:nth-child(2) > h2 > span:last-child");

    //Locator for all dealer ads names
    By allAdsNames = By.cssSelector("main > section:nth-child(5) > div > div > div > div > div > div > div > div > span");


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


    //Method to wait until dealer ads section appears
    public void waitDealerAds() {
        // Create a WebDriverWait instance
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use Explicit Wait to wait for a specific condition
        wait.until(ExpectedConditions.visibilityOfElementLocated(dealerAds));
    }

    //Method to get text for all dealer ads prices
    public List<String> getAdsPrices() {
        List<WebElement> prices = driver.findElements(allAdsprices);
        for (int i = 0; i < prices.size(); i++) {
            String price = prices.get(i).getText().replaceAll(",", "");
            if(driver.getCurrentUrl().equals(getVariableValueFromSheet1("URL"))){
                priceValues.add(price.replaceAll(" ج.م.", ""));
            } else if(driver.getCurrentUrl().equals(getVariableValueFromSheet1("URLEn"))) {
                priceValues.add(price.replaceAll("EGP", ""));
            }
        }
        return priceValues;
    }

    //Method to get text for all dealer ads makes
    public List <String> getAdsMakes() {
        List<WebElement> makes = driver.findElements(allAdsMakes);
        for (int i = 0; i < makes.size(); i++) {
            makeValues.add(makes.get(i).getText());
        }
        return makeValues;
    }

    //Method to get text for all dealer ads models
    public List<String> getAdsModels() {
        List<WebElement> models = driver.findElements(allAdsModels);
        for (int i = 0; i < models.size(); i++) {
            modelValues.add(models.get(i).getText());
        }
        return modelValues;
    }

    //Method to get text for all dealer ads years
    public List<String> getAdsYears() {
        List<WebElement> years = driver.findElements(allAdsYears);
        for (int i = 0; i < years.size(); i++) {
            yearValues.add(years.get(i).getText());
        }
        return yearValues;
    }

    //Method to get text for all dealer ads names
    public List<String> getAdsNames() {
        List<WebElement> names = driver.findElements(allAdsNames);
        for (int i = 0; i < names.size(); i++) {
            nameValues.add(names.get(i).getText());
        }
        return nameValues;
    }

}

