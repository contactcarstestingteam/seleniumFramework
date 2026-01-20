package com.contactcars.pages;

import com.contactcars.utils.ActionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InsurancePage {
    private WebDriver driver;
    private ActionUtils actions;

    public InsurancePage(WebDriver driver) {
        this.driver = driver;
        actions = new ActionUtils(driver);
    }


    //Locator for insure your car button
    By insureYourCarButton = By.cssSelector("main > div > div > button");

    //Locator for car owner field
    By carOwner = By.cssSelector("form > div > div > input");

    //Locator for mobile number field
    By mobileNumber = By.cssSelector("form > div > div:nth-child(2) > input");

    //Locator for car price field
    By carPrice = By.cssSelector("form > div > div:nth-child(3) > div > input");

    //Locator for car make drop down
    By carMake = By.cssSelector("form > div > div:nth-child(4) > div > input");

    //Locator for all car makes values
    By allCarMakes = By.cssSelector("form > div > div:nth-child(4) > div > ul > li");

    //Locator for car model drop down
    By carModel = By.cssSelector("form > div > div:nth-child(5) > div > input");

    //Locator for all car models values
    By allCarModels = By.cssSelector("form > div > div:nth-child(5) > div > ul > li");

    //Locator for car year drop down
    By carYear = By.cssSelector("form > div > div:nth-child(6) > div > input");

    //Locator for all car years values
    By allCarYears = By.cssSelector("form > div > div:nth-child(6) > div > ul > li");

    //Locator for submit button
    By submitButton = By.cssSelector("form > div > button");

    //Method to insure your car
    public void insureCarRequest(String name, String mobile, String price, String makeName, String modelName, String year) {
        actions.buttonClick(insureYourCarButton);
        actions.type(carOwner, name);
        actions.type(mobileNumber, mobile);
        actions.type(carPrice, price);
        actions.buttonClick(carMake);
        actions.chooseValue(allCarMakes, makeName);
        actions.buttonClick(carModel);
        actions.chooseValue(allCarModels, modelName);
        actions.buttonClick(carYear);
        actions.chooseValue(allCarYears, year);
        actions.buttonClick(submitButton);
    }

}


