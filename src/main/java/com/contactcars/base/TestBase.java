package com.contactcars.base;

import com.contactcars.pages.*;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.ExtentReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;


public class TestBase {
 
    public static WebDriver driver;
    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();
    //Creating object of report utils
    ExtentReportUtils report = new ExtentReportUtils();
    public HomePage home;
    public LoginPage login;
    public OtlobhaForm1stStep form1stStep;
    public OtlobhaForm2ndStep form2ndStep;
    public OtlobhaLandingPage otlobhaLanding;
    public ShowroomsDetailsPage showroomDetails;
    public ShowroomsPage showroom;
    public UsedCarsSEOPages usedCarsSEOPage;
    public UserInfoPage userInfoPage;



    public TestBase() throws IOException {
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

    @BeforeSuite
    public void beforeSuite() {
        report.startReporter();  // Initialize Extent
        driverInitialization();
    }

    @BeforeClass
    public void instanceSetUp() throws IOException {
        home = new HomePage(driver);
        login = new LoginPage(driver);
        form1stStep = new OtlobhaForm1stStep(driver);
        form2ndStep = new OtlobhaForm2ndStep(driver);
        otlobhaLanding = new OtlobhaLandingPage(driver);
        showroomDetails = new ShowroomsDetailsPage(driver);
        showroom = new ShowroomsPage(driver);
        usedCarsSEOPage = new UsedCarsSEOPages(driver);
        userInfoPage = new UserInfoPage(driver);
    }

    @AfterTest
    public void goToHomePage() {
        driver.get(csv.getVariableValueFromSheet1("URL"));
    }

    @AfterSuite
    public void afterSuite() {
        report.tearDown(); // Write report
    }

    // Close Chrome window
    public void quitChrome() {
        driver.quit();
    }
}
