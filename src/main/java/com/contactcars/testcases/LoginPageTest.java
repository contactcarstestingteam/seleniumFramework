package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginPageTest extends TestBase {

    public LoginPageTest() throws IOException {
        super();
    }

    @Test
    public static void login() throws InterruptedException {
        initializationOnChrome(prop.getProperty("url"));
        Thread.sleep(5000);
        WebElement loginLink = driver.findElement(By.cssSelector("header > div > div:nth-child(3) > button"));
        loginLink.click();
        Thread.sleep(5000);
        WebElement mobileNumber = driver.findElement(By.id("mobile"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        mobileNumber.sendKeys(sheet.getRow(1).getCell(0).toString());
        loginButton.click();
        Thread.sleep(5000);
        WebElement otb = driver.findElement(By.id("otp-number"));
        WebElement confirmButton = driver.findElement(By.cssSelector("body > div:last-child > div > div > div:nth-child(2) > form > button:nth-of-type(2)"));
        otb.sendKeys(sheet.getRow(1).getCell(1).toString());
        confirmButton.click();
            if (!driver.findElements(By.cssSelector("body > div > div > div > div:nth-child(5) > button")).isEmpty()){
                driver.findElement(By.cssSelector("body > div > div > div > div:nth-child(5) > button")).click();
            }
    }
}

