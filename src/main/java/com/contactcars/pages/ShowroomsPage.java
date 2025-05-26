package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public class ShowroomsPage extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public ShowroomsPage() throws IOException {
        super();
    }

    // Locator for showroom name text field
    By showroomName = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div > input");

    // Locator for country drop down
    By country = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div > input");

    // Locator for all countries
    By allCountries = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(2) > div > ul > li");

    // Locator for area drop down
    By area = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(3) > div > input");

    // Locator for all areas
    By allAreas = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(3) > div > ul > li");

    // Locator for make drop down
    By make = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(4) > div > input");

    // Locator for all makes
    By allMakes = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(4) > div > ul > li");

    // Locator for new radio button
    By newStatus = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(5) > label:nth-child(2)");

    // Locator for used radio button
    By usedStatus = By.cssSelector("main > div:nth-child(3) > div:nth-child(2) > div > div:nth-child(5) > label:last-child");

    // Locator for all dealers names in arabic values
    By allDealersNames = By.cssSelector("main > div:nth-child(3) > div:nth-child(3) > section > ul > li > article > a > div > div:nth-child(2) > h3");

    // Method to enter showroom name
    public void enterShowroomName(String name) {
        driver.findElement(showroomName).sendKeys(name);
    }

    // Method to click on country drop down
    public void clickCountry() {
        driver.findElement(country).click();
    }

    // Method to choose country value
    public void chooseCountryValue(int index) {
        driver.findElements(allCountries).get(index).click();
    }

    // Method to click on area drop down
    public void clickArea() {
        driver.findElement(area).click();
    }

    // Method to choose area value
    public void chooseAreaValue(int index) {
        driver.findElements(allAreas).get(index).click();
    }

    // Method to click on make drop down
    public void clickMake() {
        driver.findElement(make).click();
    }

    // Method to choose make value
    public void chooseMakeValue(int index) {
        driver.findElements(allMakes).get(index).click();
    }

    // Method to click on new radio button
    public void clickNew() {
        driver.findElement(newStatus).click();
    }

    // Method to click on used radio button
    public void clickUsed() {
        driver.findElement(usedStatus).click();
    }

    // Method to get all dealers arabic names
    public void getDealersNames(List <String> dealersNamesList) {
        String dealerName;
        for(int i=0; i < driver.findElements(allDealersNames).size(); i++){
            dealerName = driver.findElements(allDealersNames).get(i).getText();
            dealersNamesList.add(dealerName);
        }
    }
}
