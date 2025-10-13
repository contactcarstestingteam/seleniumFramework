package com.contactcars.pages;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.contactcars.base.TestBase;
import com.contactcars.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsedCarsSEOPages {

    private WebDriver driver;
    private WaitUtils waitUtils = new WaitUtils(driver,10);
    private Random rand = new Random();
    private String expected;
    private int priceTo;
    private int priceFrom;
    private int hitNumber;
    private int numberOfHits;
    private List<WebElement> makes;
    private List<WebElement> models;
    private List<WebElement> years;
    private List<WebElement> trims;
    private int makeId;
    private int modelId;
    private int yearId;
    private int trimId;

    private WebElement element;
    private String makeName;
    private String modelName;
    private String yearName;
    private String trimName;
    private int makeNameNumberOfChars;
    private String make_URL;
    private boolean testDone;
    private boolean nextMakeSelected;
    private static final By mainTabsSelector = By.cssSelector("#tabs > div > ul > li");
    private static final By makeHitSelector = By.cssSelector("#tabs > div:nth-child(4) > ul > li");
    private static final By otherSelectors = By.cssSelector("#tabs > div:nth-child(3) > ul > li");
    private static final By showAllBrandsButton = By.cssSelector("#tabs > div:nth-child(4) > button");
    private static final By otlobhaPromotionSection = By.cssSelector("body > main > div > div > div > div");
    private static final By newCarsSEOPagesEntryPoint = By.cssSelector("body > main > div > div > div > div:nth-child(3)");
    private static final By advancedFilterEntryPoint = By.cssSelector("body > main > div > div> div > div:nth-child(2)");
    private static final By cardSelector = By.cssSelector("body > main > div> div > section > ul > li");
    private static final By breadCrumb = By.cssSelector("div.bg-gray-200 > div > div.flex");

    public UsedCarsSEOPages(WebDriver driver) throws IOException {
        this.driver = driver;
        this.waitUtils = new WaitUtils (driver, 10);
    }
    public void openAllBrandsSection (){
        waitUtils.waitForElementClickable(showAllBrandsButton).click();
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
    public void selectMakeHits (int id) {
        List<WebElement> makes = waitUtils.waitForAllElementsVisible(makeHitSelector);
        if (id < makes.size()){
            makes.get(id).click();
        } else {
            System.out.println("Invalid make hit index: " + id);
        }
    }
    public void selectOtherHits (int id) {
        List<WebElement> others = waitUtils.waitForAllElementsVisible(otherSelectors);
        if (id < others.size()){
            others.get(id).click();
        } else {
            System.out.println("Invalid other hit index: " + id);
        }
    }
    public void clickOnBreadcrumbItem (int id) {
        List<WebElement> breadcrumbElements = waitUtils.waitForAllElementsVisible(breadCrumb);
        breadcrumbElements.get(id).click();
    }

    public void chooseTab(int id){
        driver.findElements(mainTabsSelector).get(id).click();
    }
    public void makeModelYearTrimPath () {
        openAllBrandsSection();
        makes = waitUtils.waitForAllElementsVisible(makeHitSelector);
        for (makeId = 0 ; makeId < makes.size() ; makeId ++){
            makes = waitUtils.waitForAllElementsVisible(makeHitSelector);
            WebElement makeHit = makes.get(makeId);
            makeName = makeHit.getText();
            waitUtils.waitForElementClickable(makeHit).click();
            getModelHitDetails();
            clickOnBreadcrumbItem(1);
        }
    }
    public void getModelHitDetails () {
        models = waitUtils.waitForAllElementsVisible(otherSelectors);
        for (modelId = 0 ; modelId < models.size() ; modelId++){
            models = waitUtils.waitForAllElementsVisible(otherSelectors);
            WebElement modelHit = models.get(modelId);
            modelName = modelHit.getText();
            waitUtils.waitForElementClickable(modelHit).click();
            getYearHitDetails();
            clickOnBreadcrumbItem(2);
        }
    }
    public void getYearHitDetails () {
        boolean yearsLoaded = waitUtils.waitForUrlContains(modelName.substring(0,2).toLowerCase());
        years = waitUtils.waitForAllElementsVisible(otherSelectors);
            for (yearId = 0 ; yearId < years.size() ; yearId++){
                years = waitUtils.waitForAllElementsVisible(otherSelectors);
                WebElement yearHit = years.get(yearId);
                yearName = yearHit.getText();
                waitUtils.waitForElementClickable(yearHit).click();
                getTrimHitDetails();
                clickOnBreadcrumbItem(3);
            }


    }
    public void getTrimHitDetails () {
        trims = waitUtils.waitForAllElementsVisible(otherSelectors);
        for (trimId =0 ; trimId < trims.size() ; trimId++){
            trims = waitUtils.waitForAllElementsVisible(otherSelectors);
            WebElement trimHit = trims.get(trimId);
            trimName = trimHit.getText();
            waitUtils.waitForElementClickable(trimHit).click();
            clickOnBreadcrumbItem(4);
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
                //wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                //searchUsingGovernorateArea();
                testDone= true;
            }
        }
        if (testDone == false){
            hitNumber = getRandomHitNumber(selector, driver);
            if (hitNumber > 12 && nextMakeSelected == true && selector.contains("Make")) {
                openAllBrandsSection();
            }
            element = driver.findElements(By.cssSelector(selector)).get(hitNumber);
            expected = element.getText();
            if (selector.contains("Price")){
                priceFrom = getPriceFrom();
                priceTo = getPriceTo();
            }
            //wait.until(ExpectedConditions.elementToBeClickable(element));
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
