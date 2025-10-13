package com.contactcars.pages;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.Random;

import com.aventstack.extentreports.Status;
import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsedCarsSEOPages extends TestBase{

    private Random rand = new Random();
    private String expected;
    private int priceTo;
    private int priceFrom;
    private int hitNumber;
    private int numberOfHits;
    private int numberOfMakesHits;
    private int numberOfModelsHits;
    private int numberOfYearsHits;
    private int numberOfTrimsHits;
    private int makeId = 0;
    private int modelId = 0;
    private int yearId = 0;
    private int trimId = 0;
    private WebElement makeElement;
    private WebElement modelElement;
    private WebElement yearElement;
    private WebElement trimElement;
    private WebElement element;
    private String makeName;
    private String modelName;
    private String yearName;
    private String trimName;
    private int makeNameNumberOfChars;
    private String make_URL;
    private boolean testDone;
    private boolean nextMakeSelected;
    private WebDriverWait wait ;
    By mainTabsSelector = By.cssSelector("#tabs > div > ul > li");
    By makeHitSelector = By.cssSelector("#tabs > div:nth-child(4) > ul > li");
    By otherSelectors = By.cssSelector("#tabs > div:nth-child(3) > ul > li");
    By showAllBrandsButton = By.cssSelector("#tabs > div:nth-child(4) > button");
    By otlobhaPromotionSection = By.cssSelector("body > main > div > div > div > div");
    By newCarsSEOPagesEntryPoint = By.cssSelector("body > main > div > div > div > div:nth-child(3)");
    By advancedFilterEntryPoint = By.cssSelector("body > main > div > div> div > div:nth-child(2)");
    By cardSelector = By.cssSelector("body > main > div> div > section > ul > li");
    By breadCrumb = By.cssSelector("div.bg-gray-200 > div > div.flex");

    public UsedCarsSEOPages() throws IOException {
    }

    public void clickOnShowAllBrandsButton (){
        driver.findElement(showAllBrandsButton).click();
    }

    public void clickOnOtlobhPromotionSection (){
        driver.findElement(otlobhaPromotionSection).click();
    }

    public void clickOnAdvancedFilterButton (){
        driver.findElement(advancedFilterEntryPoint).click();
    }

    public void clickOnNewCarsSEOPagesEntryPoint (){
        driver.findElement(newCarsSEOPagesEntryPoint).click();
    }

    public void clickOnMakeHit(int id) throws InterruptedException {
        driver.findElements(makeHitSelector).get(id).click();
        Thread.sleep(2000);
    }

    public void clickOnOtherSelector(int id) throws InterruptedException {
        driver.findElements(otherSelectors).get(id).click();
        Thread.sleep(2000);
    }

    public void chooseTab(int id){
        driver.findElements(mainTabsSelector).get(id).click();
    }

    public void makeModelYearTrimPath () throws InterruptedException {
        clickOnShowAllBrandsButton();
        numberOfMakesHits = driver.findElements(makeHitSelector).size();
        if (numberOfMakesHits == makeId){
            driver.findElements(breadCrumb).get(0);
        } else {
            makeName = driver.findElements(makeHitSelector).get(makeId).getText();
            clickOnMakeHit(makeId);
            getModelHitDetails();
        }
    }

    public void getModelHitDetails () throws InterruptedException {
        numberOfModelsHits = driver.findElements(otherSelectors).size();
        if (numberOfModelsHits == modelId) {
            makeId++;
            modelId = 0;
            driver.findElements(breadCrumb).get(1).click();
            makeModelYearTrimPath();
        } else {
            modelName = driver.findElements(otherSelectors).get(modelId).getText();
            clickOnOtherSelector(modelId);
            getYearHitDetails();
        }
    }
    public void getYearHitDetails () throws InterruptedException {
        numberOfYearsHits = driver.findElements(otherSelectors).size();
        if (numberOfYearsHits == yearId) {
            modelId++;
            yearId = 0;
            driver.findElements(breadCrumb).get(2).click();
            getModelHitDetails();
        } else {
            yearName = driver.findElements(otherSelectors).get(yearId).getText();
            clickOnOtherSelector(yearId);
            getTrimHitDetails();
        }
    }
    public void getTrimHitDetails () throws InterruptedException {
        numberOfTrimsHits = driver.findElements(otherSelectors).size();
        if (numberOfTrimsHits == trimId)
        {
            yearId++;
            trimId = 0;
            driver.findElements(breadCrumb).get(3).click();
            getYearHitDetails();
        } else {
            trimName = driver.findElements(otherSelectors).get(trimId).getText();
            clickOnOtherSelector(trimId);
            trimId++;
            driver.findElements(breadCrumb).get(4).click();
            getTrimHitDetails();
        }
    }

    /*public void selectMakeHit () throws InterruptedException, IOException {
        numberOfMakesHits = driver.findElements(makeHitSelector).size();
        for (int Make_i = 0; Make_i < numberOfMakesHits; Make_i++) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardSelector));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            makeElement = driver.findElements(makeHitSelector).get(Make_i);
            wait.until(ExpectedConditions.elementToBeClickable(makeElement));
            makeName = makeElement.getText();
            makeNameNumberOfChars = makeName.length();
            makeElement.click();
            makeName = makeName.replace(' ', '_');
            wait.until(ExpectedConditions.urlContains(makeName.toLowerCase()));
            make_URL = driver.getCurrentUrl();
            selectModelHit();
        }
    }

    public void selectModelHit () throws InterruptedException, IOException {
        numberOfModelsHits = driver.findElements(otherSelectors).size();
        for (int Model_i = 0 ; Model_i < numberOfModelsHits; Model_i++) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardSelector));
            modelElement = driver.findElements(otherSelectors).get(Model_i);
            modelName = modelElement.getText();
            modelName = modelName.substring(makeNameNumberOfChars+1,modelName.length()).replace(' ','_').replace('-','_');
            String hrefName = "[href='/en/used-cars/"+makeName.toLowerCase()+"-"+ modelName.toLowerCase()+"'"+"]";
            modelElement = driver.findElement(By.cssSelector(otherSelectors+" "+hrefName));
            wait.until(ExpectedConditions.visibilityOf(modelElement));
            wait.until(ExpectedConditions.elementToBeClickable(modelElement));
            modelElement.click();
            System.out.println("Webelement Locator: " + modelElement);
            wait.until(ExpectedConditions.urlContains(modelName.toLowerCase()));
            selectYearHit();
        }
        Thread.sleep(2000);
        element = driver.findElements(breadCrumb).get(1);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
    }

    public void selectYearHit () throws InterruptedException, IOException {
        numberOfYearsHits = driver.findElements(otherSelectors).size();
        for (int Year_i = 0 ; Year_i < numberOfYearsHits; Year_i++) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cardSelector));
            yearElement = driver.findElements(otherSelectors).get(Year_i);
            wait.until(ExpectedConditions.elementToBeClickable(yearElement));
            yearName = yearElement.getText().substring(yearElement.getText().length()-4, yearElement.getText().length());
            yearElement.click();
            wait.until(ExpectedConditions.urlContains(yearName.toLowerCase()));
            selectTrimHit();
        }
        Thread.sleep(2000);
        element = driver.findElements(breadCrumb).get(2);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(3000);
    }

    public void selectTrimHit () throws InterruptedException, IOException {
        wait.until(ExpectedConditions.urlContains("year"));
        numberOfTrimsHits = driver.findElements(otherSelectors).size();
        for (int Trim_i = 0 ; Trim_i < numberOfTrimsHits; Trim_i++) {
            trimElement = driver.findElements(otherSelectors).get(Trim_i);
            wait.until(ExpectedConditions.elementToBeClickable(trimElement));
            trimName = trimElement.getText();
            trimElement.click();
            trimName = trimName.replace('-','_').replace(' ','_').replace('/','_');
            wait.until(ExpectedConditions.urlContains(trimName.toLowerCase()));
            element = driver.findElements(breadCrumb).get(4);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        }
        Thread.sleep(2000);
        element = driver.findElements(breadCrumb).get(3);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
    }*/



    private void getHitDetails(String selector) throws InterruptedException, IOException {
        //Thread.sleep(2000);
        testDone = false;
        if (selector.contains("Area")) {
            if (driver.findElements(mainTabsSelector).size() == 2){
                driver.findElements(mainTabsSelector).get(0).click();
                //Thread.sleep(1000);
            } else {
                Actions actions = new Actions(driver);
                element = driver.findElement(breadCrumb);
                actions.moveToElement(element);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                //searchUsingGovernorateArea();
                testDone= true;
            }
        }
        if (testDone == false){
            hitNumber = getRandomHitNumber(selector, driver);
            if (hitNumber > 12 && nextMakeSelected == true && selector.contains("Make")) {
                clickOnShowAllBrandsButton();
            }
            element = driver.findElements(By.cssSelector(selector)).get(hitNumber);
            expected = element.getText();
            if (selector.contains("Price")){
                priceFrom = getPriceFrom();
                priceTo = getPriceTo();
            }
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            //Thread.sleep(1000);
        }
    }

    public int getRandomHitNumber (String selector, WebDriver driver) throws IOException {
        numberOfHits = driver.findElements(By.cssSelector(selector)).size();
        int i = rand.nextInt(numberOfHits) + 0;
        return i;
    }

    private int getPriceFrom (){
        int price = 0;
        if (expected.charAt(1) == 'k'){
            price = 0;
        } else if (expected.charAt(2) == 'k'){
            price = Integer.valueOf(expected.substring(0,2));
            price *= 1000;
        } else if (expected.charAt(3) == 'k'){
            price = Integer.valueOf(expected.substring(0,3));
            price *= 1000;
        } else if (expected.charAt(4) == 'k') {
            price = Integer.valueOf(expected.substring(0,3));
            price *= 1000;
        } else if (expected.charAt(1) == 'm') {
            price = Integer.valueOf(expected.substring(0,1));
            price *= 1000000;
        } else if (expected.charAt(3) == 'm') {
            price = Integer.valueOf(expected.substring(0,1) + expected.substring(2,3));
            price *= 100000;
        } else if (expected.charAt(0) == 'M') {
            price = 3000000;
        }
        return price;
    }

    private int getPriceTo (){
        if (expected.charAt(8) == 'k'){
            priceTo = Integer.valueOf(expected.substring(6,8));
            priceTo *= 1000;
        } else if (expected.charAt(9) == 'k'){
            priceTo = Integer.valueOf(expected.substring(7,9));
            priceTo *= 1000;
        } else if (expected.charAt(10) == 'k') {
            priceTo = Integer.valueOf(expected.substring(7,10));
            priceTo *= 1000;
        } else if (expected.charAt(11) == 'k') {
            priceTo = Integer.valueOf(expected.substring(8,11));
            priceTo *= 1000;
        } else if (expected.charAt(9) == 'm' && expected.charAt(1) == 'm') {
            priceTo = Integer.valueOf(expected.substring(6,7)+expected.substring(8,9));
            priceTo *= 100000;
        } else if (expected.charAt(9) == 'm') {
            priceTo = Integer.valueOf(expected.substring(8,9));
            priceTo *= 1000000;
        } else if (expected.charAt(9) == 'm' && expected.charAt(3) == 'm') {
            priceTo = Integer.valueOf(expected.substring(8,9));
            priceTo *= 100000;
        } else if (expected.charAt(11) == 'm') {
            priceTo = 50000000;
        }
        return  priceTo;
    }
}
