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

    //Locator for all dealers names in arabic values
    By allDealersNames = By.cssSelector("main > div:nth-child(3) > div:nth-child(3) > section > ul > li > article > a > div > div:nth-child(2) > h3");

    //Method to get all dealers arabic names
    public void getDealersNames(List <String> dealersNamesList) {
        String dealerName;
        for(int i=0; i < driver.findElements(allDealersNames).size(); i++){
            dealerName = driver.findElements(allDealersNames).get(i).getText();
            dealersNamesList.add(dealerName);
        }
    }
}
