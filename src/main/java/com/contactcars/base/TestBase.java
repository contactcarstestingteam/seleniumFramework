package com.contactcars.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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

    // Loading properties and credentials files
    public TestBase() throws IOException {
        File credentials = new File("D:\\Website Variables.xlsx");
        FileInputStream fisc = new FileInputStream(credentials);
        workbook = new XSSFWorkbook(fisc);
        sheet1 = workbook.getSheetAt(0);
        sheet2 = workbook.getSheetAt(1);
    }

    // Open chrome window
    public static void initializationOnChrome(String URL) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @BeforeTest
    public void startReporter() {
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
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

    // Close chrome window
    public void quitChrome() {
        driver.quit();
    }


}
