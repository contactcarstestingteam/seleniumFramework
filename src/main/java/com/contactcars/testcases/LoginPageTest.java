package com.contactcars.testcases;

import com.aventstack.extentreports.Status;
import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.LoginPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import java.io.IOException;


public class LoginPageTest extends TestBase {

    public LoginPageTest() throws IOException {
        super();
    }

    @Test
    public static void login() throws InterruptedException, IOException {
        //Creating object of HOME and Login pages
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);

        initializationOnChrome(prop.getProperty("url"));
        Thread.sleep(5000);
        home.clickSkip();
        home.clickLoginLink();
        Thread.sleep(5000);

        login.enterMobileNumber(sheet.getRow(1).getCell(0).toString());
        login.clickLogin();
        Thread.sleep(5000);

        login.enterOtp(sheet.getRow(1).getCell(1).toString());
        login.clickConfirm();
        Thread.sleep(5000);

        home.clickNoThanks();

        extentTest = extentReports.createTest("Login Test Case");

        //Check on logging in successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://web-staging.contactcars.com/ar";
         if (actualUrl.contentEquals(expectedUrl)){
             Assert.assertTrue(actualUrl.contentEquals(expectedUrl));
             logAssertionBetweenTwoEqualValues(Pass, actualUrl, expectedUrl);
         } else {
             logAssertionBetweenTwoEqualValues(Fail, actualUrl, expectedUrl);
         }
    }
}

