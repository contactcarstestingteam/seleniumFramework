package com.contactcars.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.contactcars.pages.CradPaymentGateway;
import com.contactcars.pages.OtlobhaForm2ndStep;
import com.contactcars.pages.WalletPaymentGateway;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;


public class TestBase {
 
    public static WebDriver driver;
    public static Properties prop;
    public static XSSFWorkbook workbook;
    public static Sheet sheet1;
    public static Sheet sheet2;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static String Pass;
    public static String Fail;
    public static Map<String, String> queryParams = new HashMap<>();
    public static Actions actions;


    // Loading properties and credentials files
    public TestBase() throws IOException {
        File credentials = new File("E:\\Website Variables.xlsx");
        FileInputStream fisc = new FileInputStream(credentials);
        workbook = new XSSFWorkbook(fisc);
        sheet1 = workbook.getSheetAt(0);
        sheet2 = workbook.getSheetAt(1);
    }

    // Initialize web driver
    public static WebDriver driverInitialization() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    // Open Website
    public static void openChrome(String url) {
        driver.get(url);
    }
    @BeforeTest

    public void startReporter() {
        extentSparkReporter  = new ExtentSparkReporter("C:/Users/Nada.Adel/IdeaProjects/seleniumFramework/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

   // Get the variables from the Excel sheet 1 regardless of their position
    public static String getVariableValueFromSheet1(String variableKey) {
        int lastColumn = sheet1.getLastRowNum();
        for (int i = 0; i <= lastColumn; i++) {
            if (variableKey.equals(sheet1.getRow(i).getCell(0).toString())) {
                return sheet1.getRow(i).getCell(1).toString();
            }
        }
        return null;
    }

  // Get the variables from the Excel sheet 2 regardless of their position
    public static String getVariableValueFromSheet2(String variableKey) {
        int lastColumn = sheet2.getLastRowNum();
        for (int i = 0; i <= lastColumn; i++) {
              if (variableKey.equals(sheet2.getRow(i).getCell(0).toString())) {
                return sheet2.getRow(i).getCell(1).toString();
            }
        }
        return null;
    }
// method to Closes the ad popup if it's present on any page
    public void closeAdIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement ad = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cntf_mpu")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", ad);
            System.out.println("Ad was hidden.");
        } catch (Exception e) {
            System.out.println("Ad not found, continue normally.");
        }
    }


    // Adding free promo code for Otlobha request
    public void addOtlobhaPromoCode(String promoCode) throws InterruptedException, IOException {
        //Creating object of Otlobha form 2nd step page
        OtlobhaForm2ndStep form2ndStep = new OtlobhaForm2ndStep();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#promoCode")));
        form2ndStep.enterPromoCode(getVariableValueFromSheet1(promoCode));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("main > div:nth-child(2) > div:nth-child(2) > form > div > div > button")));
        form2ndStep.clickApplyPromoCode();
    }

    public void payWithCard() throws IOException {
        //Creating object of card payment gateway page
        CradPaymentGateway card = new CradPaymentGateway();
        card.enterCardNumber(getVariableValueFromSheet1("Card No"));
        card.enterCardName(getVariableValueFromSheet1("Card Name"));
        card.enterCardDate(getVariableValueFromSheet1("Date"));
        card.enterCardCVV(getVariableValueFromSheet1("CVV"));
        card.clickPay();
    }



    // Pay with wallet
    public void payWithWallet() throws IOException {
        WalletPaymentGateway wallet = new WalletPaymentGateway();

        try {
            wallet.enterMPin(getVariableValueFromSheet1("Mpin"));
            wallet.enterOtp(getVariableValueFromSheet1("WalletOTP"));
            wallet.clickPay();
        } catch (NoSuchElementException e) {
            driver.navigate().refresh();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='mpin']")));

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

            wallet.enterMPin(getVariableValueFromSheet1("Mpin"));
            wallet.enterOtp(getVariableValueFromSheet1("WalletOTP"));
            wallet.clickPay();
        }
    }

    // Build qeury params for any Api
    public static Map<String, String> buildQueryParams(String... keyValuePairs) {
        for (int i = 0; i < keyValuePairs.length - 1; i += 2) {
            queryParams.put(keyValuePairs[i], keyValuePairs[i + 1]);
        }
        return queryParams;
    }

    public static List<String> callingShowroomsApi(String... params) {
            // Specify the base URL to the RESTful web service
            RestAssured.baseURI = getVariableValueFromSheet2("BaseURL") + getVariableValueFromSheet2("SearchDealersApi");
            // Get the RequestSpecification of the request that is to be sent
            // to the server.
            RequestSpecification httpRequest = RestAssured.given();
            // Call RequestSpecification.get() method to get the response.
            // Adding query params
            Response response = httpRequest.queryParams(buildQueryParams(params)).get("");
            String strJson = response.asString();
            // First get the Json object instance from the Response interface
            JSONObject responseBodyInJSON = new JSONObject(strJson);
            // Get the result object from the response
            JSONObject result = responseBodyInJSON.getJSONObject("result");
            // Get the items array from the result object
            JSONArray itemsArray = result.getJSONArray("items");
            // Adding all names in a list
            List<String> apiNamesList = new ArrayList<>();
            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject firstItem = itemsArray.getJSONObject(i);
                String nameAr = firstItem.getString("nameAr");
                apiNamesList.add(nameAr);
            }
            return apiNamesList;
    }

    public static void logAssertionBetweenTwoEqualValues (String status, String actual, String expected){
        if (status == Pass){
            extentTest.log(Status.PASS, "Actual Result = "+ actual + " & " + "Expected Result = " + expected);
        } else if (status == Fail){
            extentTest.log(Status.FAIL,"Actual Result = "+ actual + " & " + "Expected Result = " + expected);
        }
    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to the reporter
        extentReports.flush();
    }

    // Close Chrome window
    public void quitChrome() {
        driver.quit();
    }
}
