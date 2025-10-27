package com.contactcars.pages;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import com.contactcars.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    private List<WebElement> breadcrumbElements;
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
    private static final By cityHitSelector = By.cssSelector("#tabs > div:nth-child(5) > ul > li");
    private static final By priceHitSelector = By.cssSelector("#tabs > div:nth-child(6) > ul > li");
    private static final By downpaymentHitSelector = By.cssSelector("#tabs > div:nth-child(7) > ul > li");
    private static final By moreAttributesHitSelector = By.cssSelector("#tabs > div:nth-child(8) > ul > li");
    private static final By originCountriesHitSelector = By.cssSelector("#tabs > div:nth-child(8) > div >div");
    private static final By otherSelectorsFirstTab = By.cssSelector("#tabs > div:nth-child(3) > ul > li");
    private static final By otherSelectorsSecondTab = By.cssSelector("#tabs > div:nth-child(4) > ul > li");
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
        List<WebElement> others = waitUtils.waitForAllElementsVisible(otherSelectorsFirstTab);
        if (id < others.size()){
            others.get(id).click();
        } else {
            System.out.println("Invalid other hit index: " + id);
        }
    }
    public void clickOnBreadcrumbItem (int id) {
        breadcrumbElements = waitUtils.waitForAllElementsVisible(breadCrumb);
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
            waitUtils.waitForStalenssOfElement(makes.get(0));
            getModelHitDetails();
            clickOnBreadcrumbItem(1);
            openAllBrandsSection();
            waitUtils.waitForStalenssOfElement(breadcrumbElements.get(2));
        }
    }
    public void getModelHitDetails () {
        models = waitUtils.waitForAllElementsVisible(otherSelectorsFirstTab);
        for (modelId = 0 ; modelId < models.size() ; modelId++){
            models = waitUtils.waitForAllElementsVisible(otherSelectorsFirstTab);
            WebElement modelHit = models.get(modelId);
            modelName = modelHit.getText();
            waitUtils.waitForElementClickable(modelHit).click();
            waitUtils.waitForStalenssOfElement(models.get(0));
            getYearHitDetails();
            clickOnBreadcrumbItem(2);
            waitUtils.waitForStalenssOfElement(breadcrumbElements.get(3));
        }
    }
    public void getYearHitDetails () {
        years = waitUtils.waitForAllElementsVisible(otherSelectorsFirstTab);
            for (yearId = 0 ; yearId < years.size() ; yearId++){
                years = waitUtils.waitForAllElementsVisible(otherSelectorsFirstTab);
                WebElement yearHit = years.get(yearId);
                yearName = yearHit.getText();
                waitUtils.waitForElementClickable(yearHit).click();
                waitUtils.waitForStalenssOfElement(years.get(0));
                getTrimHitDetails();
                clickOnBreadcrumbItem(3);
                waitUtils.waitForStalenssOfElement(breadcrumbElements.get(4));
            }
    }
    public void getTrimHitDetails () {
        trims = waitUtils.waitForAllElementsVisible(otherSelectorsFirstTab);
        for (trimId =0 ; trimId < trims.size() ; trimId++){
            trims = waitUtils.waitForAllElementsVisible(otherSelectorsFirstTab);
            WebElement trimHit = trims.get(trimId);
            trimName = trimHit.getText();
            waitUtils.waitForElementClickable(trimHit).click();
            waitUtils.waitForStalenssOfElement(trims.get(0));
            clickOnBreadcrumbItem(4);
            waitUtils.waitForStalenssOfElement(breadcrumbElements.get(5));
        }
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
