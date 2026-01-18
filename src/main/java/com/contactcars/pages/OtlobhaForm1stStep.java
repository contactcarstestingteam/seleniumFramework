package com.contactcars.pages;

import com.contactcars.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class OtlobhaForm1stStep {

    private WebDriver driver;
    private WaitUtils wait;

    // Test Data
    private int countryIndex;
    private int makeIndex;
    private int modelIndex;
    private int yearIndex;
    private int trimIndex;
    private boolean otherTrim;

    //Constructor that will be automatically called as soon as the object of the class is created
    public OtlobhaForm1stStep(WebDriver driver) throws IOException {
        this.driver = driver;
        this.wait = new WaitUtils(driver, 30);
    }

    //Locator for name field
    By Name = By.cssSelector("#name");

    //Locator for Phone number field
    By Phone = By.cssSelector("#mobile");

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

    //Locator for imported radio button
    By Imported = By.cssSelector("#ضمان\\ التوكيل\\ او\\ استيراد");

    //Locator for year drop down
    By year = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(9) > div > input");

    //Locator for all years values
    By allYears = By.cssSelector("main > div > div:nth-child(2) > form > div:nth-child(9) > div > ul > li");

    //Locator for trim drop down
    By trim = By.cssSelector("div:nth-child(10) > div > div > div > input");

    //Locator for all trims values
    static final By allTrims = By.cssSelector("div:nth-child(10) > div > div > div > ul > li");

    //Locator for other trim field
    By OtherTrim = By.cssSelector("div:nth-child(10) > div > div.mt-3 > input");

    //Locator for finance button
    By Finance = By.cssSelector("div:nth-child(11) > div > div:nth-child(2) > label");

    //Locator for minimum down payment
    By downpayment = By.cssSelector("#installmentType");

    //Locator For Down Payment Value
    By downpaymentValue = By.cssSelector("div.ms-2 > div > input");

    //Locator for click on jop title field
    By JopTitle = By.cssSelector("div.my-5 > input");

    //Locator for next button
    By nextButton = By.cssSelector("div.flex.flex-col.gap-3.mt-3.p-3.md\\:pb-3.pb-5.bg-white-900.md\\:border-none.border-t.md\\:px-3.md\\:mx-3 > div:last-child > button:last-child");

    //Locator for Bank Card
    By BackCardOption = By.cssSelector("div:nth-child(2) > div > label:nth-child(1)");

    //Locator for Terms
    By Terms = By.cssSelector("#terms");

    //Method to click on country drop down
//    public void clickCountry() {
//        driver.findElement(country).click();
//    }
    public void clickCountry() {
        WebElement element = wait.waitForElementClickable(country);
        element.click();
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
        if(!driver.findElement(agency).isSelected()) {
            driver.findElement(agency).click();
        }
    }

    //Method to click on imported radio button
//    public void clickImported() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//   //wait
//        WebElement importedCheckbox = wait.until(ExpectedConditions.elementToBeClickable(Imported));
//
//        if (!importedCheckbox.isSelected()) {
//            importedCheckbox.click();
//        }
//    }
    public void clickImported() {
        WebElement importedCheckbox = wait.waitForElementClickable(Imported);

        if (!importedCheckbox.isSelected()) {
            importedCheckbox.click();
        }
    }

    //Method to click on finance
    public void ClickFinance() {driver.findElement(Finance).click();}

    //Method to click on Minimum down payment
    public void MinimumDownPayment() {driver.findElement(downpayment).click();}

    //Method to click on Down payment Value Field
//    public void DownPaymentValue2() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(downpaymentValue));
//        driver.findElement(downpaymentValue).click();
//        driver.findElement(downpaymentValue).sendKeys("7000");
//    }

    public void DownPaymentValue2() {
        WebElement downPaymentInput = wait.waitForElementClickable(downpaymentValue);
        downPaymentInput.click();
        downPaymentInput.sendKeys("7000");
    }

    // Method to scroll to Job title and click it
    public void ClickJopTitle() {
        WebElement jobTitleElement = driver.findElement(JopTitle);

        // Scroll to the element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", jobTitleElement);

        // Click on the element
        jobTitleElement.click();
    }

    //
    public void WriteJopTilte(){driver.findElement(JopTitle).sendKeys("Engineer");}

    //Method to click on year drop down
    public void clickYear() {
        driver.findElement(year).click();
    }

    //Method to choose year value
    public void chooseYearValue(int index) {
        driver.findElements(allYears).get(index).click();
    }

    //Method to click on trim drop down
//    public void clickTrim() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(trim));
//        driver.findElement(trim).click();
//    }

//    public void clickTrim() {
//        WebElement ClickTrm =wait.waitForElementClickable(trim);
//        ClickTrm.click();
//    }
//public void clickTrim() {
//    WebElement clickTrm = wait.waitForElementClickable(trim);
//    clickTrm.click();
//    wait.waitForElementsVisible(allTrims);
//}

    public void clickTrim() {
        WebElement trimBtn = wait.waitForElementClickable(trim);
        trimBtn.click();
    }

    //Method to choose trim value
    public void chooseTrimValue(int index) {

        By trimsContainer = By.cssSelector("div:nth-child(10) ul");
        wait.waitForElementPresent(trimsContainer);

        List<WebElement> trims = driver.findElements(allTrims);

        if (trims.size() > index) {
            trims.get(index).click();
        } else {
            throw new RuntimeException(
                    "Trim index " + index + " out of bounds. Size = " + trims.size()
            );
        }
    }




//
//    public void chooseTrimValue(int index) {
//    List<WebElement> trims = wait.waitForAllElementsVisible(allTrims);
//
//    if (trims.size() > index) {
//        trims.get(index).click();
//    } else {
//        throw new RuntimeException(
//                "Index " + index + " out of bounds for trims list size " + trims.size()
//        );
//    }
//}

    //Method to Click on other trim field
//    public void ClickAndChooseOtherTrim(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(OtherTrim));
//        driver.findElement(OtherTrim).click();
//        driver.findElement(OtherTrim).sendKeys("Test");
//    }

    public void ClickAndChooseOtherTrim(){
        WebElement otherTrimElement =wait.waitForElementClickable(OtherTrim);
        otherTrimElement.click();
        otherTrimElement.sendKeys("Test");
    }

    //Method to click on next button
    public void clickNext() {
        driver.findElement(nextButton).click();
        wait.waitForUrlContains("order-confirmation");
    }

//    //Method to Click on Terms
//    public void ClickTerms() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement termsElement = wait.until(ExpectedConditions.presenceOfElementLocated(Terms));
//        // Scroll with more than type
//        try {
//
//            //  Move + Click
//            Actions actions = new Actions(driver);
//            actions.moveToElement(termsElement).click().perform();
//
//        } catch (Exception e) {
//            //if all of this not working use JavaScript click
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsElement);
//        }
//    }

    public void ClickTerms() {
        WebElement termsElement = wait.waitForElementPresent(Terms);
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(termsElement).click().perform();

        } catch (Exception e) {
            // fallback click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsElement);
        }
    }

    //Method to click on name field
    public void ClickName (){
        driver.findElement(Name).click();
    }

//    //Method to enter name field
//    public void WriteName(String UserName) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
//        user.sendKeys(UserName);
//    }

    //Method to enter name field
    public void WriteName(String UserName) {
        WebElement user = wait.waitForElementVisible(Name);
        user.sendKeys(UserName);
    }

    //Method to click on phone field
    public void ClickPhone (){
        driver.findElement(Phone).click();
    }

    //Method to enter name field
//    public void WritePhone(String MobileNo) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(Phone));
//        user.sendKeys(MobileNo);
//    }

    public void WritePhone(String MobileNo) {
        WebElement user = wait.waitForElementVisible(Phone);
        user.sendKeys(MobileNo);
    }

    //  Init Test Data
    public void initFormData(
            int countryIndex,
            int makeIndex,
            int modelIndex,
            int yearIndex,
            int trimIndex,
            boolean otherTrim
    ) {
        this.countryIndex = countryIndex;
        this.makeIndex = makeIndex;
        this.modelIndex = modelIndex;
        this.yearIndex = yearIndex;
        this.trimIndex = trimIndex;
        this.otherTrim = otherTrim;
    }

/*
    public void fillOtlobhaAgencySpecificTrim(
            int countryIndex,
            int makeIndex,
            int modelIndex,
            int yearIndex,
            int trimIndex,
            boolean otherTrim
    ) {

        clickCountry();
        chooseCountryValue(countryIndex);

        clickMake();
        chooseMakeValue(makeIndex);

        clickModel();
        chooseModelValue(modelIndex);

        clickAgency();

        clickYear();
        chooseYearValue(yearIndex);

        clickTrim();
        chooseTrimValue(trimIndex);

        if (otherTrim) {
            ClickAndChooseOtherTrim();
        }

        ClickTerms();
        clickNext();
    }

 */
// ===== Trim Actions =====
private void selectTrim() {
    clickTrim();
    chooseTrimValue(trimIndex);
}

    private void selectOtherTrimIfNeeded() {
        if (otherTrim) {
            ClickAndChooseOtherTrim();
        }
    }

    // ===== Main Flow =====
    public void fillOtlobhaAgencySpecificTrim() {

        clickCountry();
        chooseCountryValue(countryIndex);

        clickMake();
        chooseMakeValue(makeIndex);

        clickModel();
        chooseModelValue(modelIndex);

        clickAgency();

        clickYear();
        chooseYearValue(yearIndex);

        selectTrim();
        selectOtherTrimIfNeeded();

        ClickTerms();
        clickNext();
    }




}
