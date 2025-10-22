package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.LoginPage;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class LoginPageTest extends TestBase {

     HomePage home = new HomePage();
     LoginPage login = new LoginPage();
    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();
    //Creating object of extent report utils
    ExtentReportUtils report = new ExtentReportUtils();

    public LoginPageTest() throws IOException {
        super();
    }


    @Test
    public void login() throws InterruptedException, IOException {
        //Creating object of HOME and Login pages
        driverInitialization();
        openChrome(csv.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
        home.clickLoginLink();
        Thread.sleep(5000);

        login.enterMobileNumber(csv.getVariableValueFromSheet1("MobileNo"));
        login.clickLogin();
        Thread.sleep(5000);

        login.enterOtp(csv.getVariableValueFromSheet1("OTP"));
        login.clickConfirm();
        Thread.sleep(5000);

        home.clickNoThanks();

        report.extentTest = report.extentReports.createTest("Login Test Case");

        //Check on logging in successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = csv.getVariableValueFromSheet1("URL");
         if (actualUrl.contentEquals(expectedUrl)){
             Assert.assertTrue(actualUrl.contentEquals(expectedUrl));
             report.logAssertionBetweenTwoEqualValues(report.Pass, actualUrl, expectedUrl);
         } else {
             report.logAssertionBetweenTwoEqualValues(report.Fail, actualUrl, expectedUrl);
         }
    }
}

