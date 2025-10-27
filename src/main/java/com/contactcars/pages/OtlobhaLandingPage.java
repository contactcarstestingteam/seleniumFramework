package com.contactcars.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class OtlobhaLandingPage {

    private WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public OtlobhaLandingPage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

    //Locator for request new car button
    static By requestNewCarButton = By.cssSelector("div > div > div > div > button > span.whitespace-nowrap");

    //Method to click on request new car button
    public void clickRequestNewCarButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(requestNewCarButton));
        button.click();
    }
}
