package com.contactcars.utils;

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

    public void buttonClick(WebElement element) {
        wait.waitForPageToLoad(30);
        wait.waitForElementClickable(element);
        element.click();
    }

    public void type(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void chooseValue(List<WebElement> elements, int index) {
        wait.waitForAllElementsVisible(elements);
        elements.get(index).click();
    }

}
