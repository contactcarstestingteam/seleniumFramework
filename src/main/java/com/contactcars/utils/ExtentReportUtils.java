package com.contactcars.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ExtentReportUtils {

    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static String Pass;
    public static String Fail;


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
}

