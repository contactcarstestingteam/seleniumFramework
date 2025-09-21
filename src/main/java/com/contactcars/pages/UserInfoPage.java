package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UserInfoPage extends TestBase{

    public UserInfoPage() throws IOException {
    }

    // UI Locators
     By nameLocator = By.cssSelector("div.container.w-full.flex.justify-center > div > div.hidden.md\\:flex.lg\\:sticky.lg\\:top-\\[102px\\].h-auto.lg\\:w-1\\/4.w-full.lg\\:h-fit > div > div > div > h3");
     By phoneLocator = By.cssSelector("div.txt-sm.font-medium.text-dark-blue-600");
    By areaLocator = By.cssSelector("input[placeholder='مثال : مدينة نصر']");
    By governorateLocator = By.cssSelector("input[placeholder='مثال : القاهرة']");


    // UI Methods
    public String getUiName() {
        return driver.findElement(nameLocator).getText();
    }

    public String getUiPhone() {
        return driver.findElement(phoneLocator).getText();
    }

    public String getUiArea() {
        WebElement areaInput = driver.findElement(areaLocator);
        return areaInput.getAttribute("value");
    }

    public String getUiGovernorate() {
        WebElement governorateInput = driver.findElement(governorateLocator);
        return governorateInput.getAttribute("value");
    }

}
