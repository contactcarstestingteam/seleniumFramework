package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class OtlobhaForm1stStep extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public OtlobhaForm1stStep(WebDriver driver) throws IOException {
        super();
    }

    //Locator for country drop down
    By country = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(4) > div > input");

    //Locator for all countries values
    By allCountries = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(4) > div > ul > li");

    //Locator for make drop down
    By make = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(6) > div > input");

    //Locator for all makes values
    By allMakes = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(6) > div > ul > li");

    //Locator for model drop down
    By model = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(7) > div > input");

    //Locator for all models values
    By allModels = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(7) >div > ul > li");

    //Locator for agency radio button
    By agency = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(8) > div > div > div > label > input ");

    //Locator for year drop down
    By year = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(9) > div > input");

    //Locator for all years values
    By allYears = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(9) > div > ul > li");

    //Locator for trim drop down
    By trim = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(10) > div > input");

    //Locator for all trims values
    By allTrims = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(10) > div > ul > li");

    //Locator for next button
    By nextButton = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(12) > button ");

    //Locator for agree terms and conditions button
    By agreeButton = By.cssSelector("main > div > div:nth-child(2) > div  > div > div > button");

    //Method to click on country drop down
    public void clickCountry() {
        driver.findElement(country).click();
    }

    //Method to choose country value
    public void chooseCountryValue(int index) {
        driver.findElements(allCountries).get(index).click();
    }

    //Method to click on make drop down
    public void clickMake() {
        driver.findElement(make).click();
    }

    //Method to choose make value
    public void chooseMakeValue(int index) {
        driver.findElements(allMakes).get(index).click();
    }

    //Method to click on model drop down
    public void clickModel() {
        driver.findElement(model).click();
    }

    //Method to choose model value
    public void chooseModelValue(int index) {
        driver.findElements(allModels).get(index).click();
    }

    //Method to click on agency radio button
    public void clickAgency() {
        driver.findElement(agency).click();
    }

    //Method to click on year drop down
    public void clickYear() {
        driver.findElement(year).click();
    }

    //Method to choose year value
    public void chooseYearValue(int index) {
        driver.findElements(allYears).get(index).click();
    }

    //Method to click on trim drop down
    public void clickTrim() {
        driver.findElement(trim).click();
    }

    //Method to choose trim value
    public void chooseTrimValue(int index) {
        driver.findElements(allTrims).get(index).click();
    }

    //Method to click on next button
    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    //Method to click on agree terms and conditions button
    public void clickAgree() {
        driver.findElement(agreeButton).click();
    }
}
