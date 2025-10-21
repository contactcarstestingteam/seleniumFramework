package com.contactcars.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
 
    public static WebDriver driver;

    // Initialize web driver
    public static WebDriver driverInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    // Open Website
    public static void openChrome(String url) {
        driver.get(url);
    }

    // Close Chrome window
    public void quitChrome() {
        driver.quit();
    }
}
