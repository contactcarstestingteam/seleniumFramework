package com.contactcars.base;

import com.contactcars.utils.ExtentReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


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

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportUtils.startReporter();  // Initialize Extent
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportUtils.tearDown(); // Write report
    }

    // Close Chrome window
    public void quitChrome() {
        driver.quit();
    }
}
