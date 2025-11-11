package com.contactcars.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ExtentReportUtils {

    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    public static void startReporter() {
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.home") + "/IdeaProjects/seleniumFramework/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Test Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    public static void createTest (String testName) {
        extentTest = extentReports.createTest(testName);
        test.set(extentTest);
    }

    public static void logAssertionBetweenTwoEqualValues (String status, String actual, String expected){
        if (status.equals("Pass")){
            extentTest.log(Status.PASS, "Actual Result = " + actual + " & " + "Expected Result = " + expected);
        } else if (status.equals("Fail")){
            extentTest.log(Status.FAIL,"Actual Result = " + actual + " & " + "Expected Result = " + expected);
        }
    }

    public static void testInfo(String info) {
        extentTest.info(info);
    }

    public static void testPass(String pass) {
        extentTest.pass(pass);
    }

    public static void testWarning(String warning) {
        extentTest.warning(warning);
    }

    public static void tearDown() {
        //to write or update test information to the reporter
        extentReports.flush();
    }
}

