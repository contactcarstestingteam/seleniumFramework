package com.contactcars.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionUtils {

    private WebDriver driver;
    private WaitUtils wait;

    public ActionUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 30);
    }

    public void buttonClick(By locator) {
        WebElement element = wait.waitForElementClickable(locator);
        element.click();
    }

    public void type(By locator, String text) {
        WebElement element = wait.waitForElementVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void chooseValue(By locator, String value) {
        List<WebElement> elements = wait.waitForAllElementsVisible(locator);
        elements.stream()
                .filter(e -> e.getText().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Value not found: " + value))
                .click();
    }

}
