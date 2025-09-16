package com.contactcars.pages;

import com.contactcars.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class OtlobhaForm1stStep extends TestBase {

    //Constructor that will be automatically called as soon as the object of the class is created
    public OtlobhaForm1stStep() throws IOException {
        super();
    }

    //Locator for name field
    static By Name = By.cssSelector("#name");

    //Locator for Phone number field
    static By Phone = By.cssSelector("#mobile");

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
    By allTrims = By.cssSelector("div:nth-child(10) > div > div > div > ul > li");

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
        if(!driver.findElement(agency).isSelected()) {
            driver.findElement(agency).click();
        }
    }

    //Method to click on imported radio button
    public void clickImported() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

   //wait
        WebElement importedCheckbox = wait.until(ExpectedConditions.elementToBeClickable(Imported));

        if (!importedCheckbox.isSelected()) {
            importedCheckbox.click();
        }
    }

    //Method to click on finance
    public void ClickFinance() {driver.findElement(Finance).click();}

    //Method to click on Minimum down payment
    public void MinimumDownPayment() {driver.findElement(downpayment).click();}

    //Method to click on Down payment Value Field
    public void DownPaymentValue2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(downpaymentValue));
        driver.findElement(downpaymentValue).click();
        driver.findElement(downpaymentValue).sendKeys("7000");
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
    public void clickTrim() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(trim));
        driver.findElement(trim).click();
    }

    //Method to choose trim value
    public void chooseTrimValue(int index) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement trimOption = wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(allTrims).get(index)));
        trimOption.click();
    }

    //Method to Click on other trim field
    public void ClickAndChooseOtherTrim(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(OtherTrim));
        driver.findElement(OtherTrim).click();
        driver.findElement(OtherTrim).sendKeys("Test");
    }

    //Method to click on next button
    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    //Method to Click on Terms
    public void ClickTerms() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement termsElement = wait.until(ExpectedConditions.presenceOfElementLocated(Terms));

        // Scroll with more than type
        try {

            //  Move + Click
            Actions actions = new Actions(driver);
            actions.moveToElement(termsElement).click().perform();

        } catch (Exception e) {
            //if all of this not working use JavaScript click
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", termsElement);
        }
    }

    //Method to click on name field
    public void ClickName (){
        driver.findElement(Name).click();
    }

    //Method to enter name field
    public static void WriteName(String UserName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(Name));
        user.sendKeys(UserName);
    }


    //Method to click on phone field
    public void ClickPhone (){
        driver.findElement(Phone).click();
    }

    //Method to enter name field
    public static void WritePhone(String MobileNo) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(Phone));
        user.sendKeys(MobileNo);
    }

}
