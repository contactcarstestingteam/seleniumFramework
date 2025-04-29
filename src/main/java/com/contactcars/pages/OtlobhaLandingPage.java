package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class OtlobhaLandingPage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public OtlobhaLandingPage(WebDriver driver) throws IOException {
        super();
    }

    //Locator for request new car button
    By requestNewCarButton = By.cssSelector("main > div:nth-child(2) > section:nth-child(1) > div > div > div > div > div > div > a");

    //Method to click on request new car button
    public void clickRequestNewCarButton() {
        driver.findElement(requestNewCarButton).click();
    }

}
