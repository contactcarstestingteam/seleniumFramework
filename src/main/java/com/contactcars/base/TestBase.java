package com.contactcars.base;

import com.contactcars.pages.*;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.EmailUtils;
import com.contactcars.utils.ExtentReportUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class TestBase {
 
    public static WebDriver driver;
     private boolean firstTest = true;
    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();
    public ExtentReportUtils report;
    public EmailUtils mail;
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
    public static WebDriver driverInitialization(String browserMode) {
        ChromeOptions options = new ChromeOptions();
        if (browserMode.equals("headless")) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    // Open Website
    public static void openChrome(String url) {
        driver.get(url);
    }

    @BeforeSuite
    public static void openWebsite (){
        driverInitialization("Chrome");
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
    }


    @Parameters("browserMode")
    public void beforeSuite(@Optional("headless") String browserMode) {
        // Create output directory
        new File("test-output").mkdirs();
        mail = new EmailUtils();
        report = new ExtentReportUtils();
        report.startReporter();  // Initialize Extent
        driverInitialization(browserMode);
    }

    @BeforeClass
    public void instanceSetUp() throws IOException {
        if(!this.getClass().getSimpleName().equals("SitemapTest")){
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
    }

    @AfterMethod
    public void goToHomePage() {
        String url = System.getenv("WEBSITE_URL");
        if (url != null && !url.isEmpty()) {
            driver.get(url);
        }
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        //report.tearDown(); // Write report
        // Send report via email (using SendGrid)
        //mail.sendExtentReport("test-output/extentReport.html", System.getProperty("TO_EMAIL"));
    }

//    @AfterSuite
//    public void afterSuite() {
//        ExtentReportUtils.tearDown(); // Write report
//    }
//
//    // Close Chrome window
//    public void quitChrome() {
//        driver.quit();
//    }
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
}
