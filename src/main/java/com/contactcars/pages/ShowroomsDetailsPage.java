package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;

import java.io.IOException;

public class ShowroomsDetailsPage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public ShowroomsDetailsPage() throws IOException {
        super();
    }

    // Locator for showroom name
    By name = By.cssSelector("div > section > div > div > div > div > h1");

    // Locator for branches tab
    By branches = By.xpath("//label[@for = 'branches']");

    // Locator for contact us tab
    By contactUs = By.xpath("//label[@for = 'contact']");

    // Method to get showroom name
    public String getName() {
        return driver.findElement(name).getText();
    }

    // Method to click on brnaches tab
    public void clickBranches() {
        driver.findElement(branches).click();
    }

    // Method to click on contact us tab
    public void clickContactUs() {
        driver.findElement(contactUs).click();
    }
}
