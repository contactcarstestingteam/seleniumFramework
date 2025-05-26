package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class LoginPageTest extends TestBase {

    public LoginPageTest() throws IOException {
        super();
    }

    @Test
    public static void login() throws InterruptedException, IOException {
        //Creating object of HOME and Login pages
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        initializationOnChrome(getVariableValue("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        home.clickLoginLink();
        Thread.sleep(5000);

        login.enterMobileNumber(getVariableValue("MobileNo"));
        login.clickLogin();
        Thread.sleep(5000);

        login.enterOtp(getVariableValue("OTP"));
        login.clickConfirm();
        Thread.sleep(5000);

        home.clickNoThanks();

        extentTest = extentReports.createTest("Login Test Case");

        //Check on logging in successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = getVariableValue("URL");
         if (actualUrl.contentEquals(expectedUrl)){
             Assert.assertTrue(actualUrl.contentEquals(expectedUrl));
             logAssertionBetweenTwoEqualValues(Pass, actualUrl, expectedUrl);
         } else {
             logAssertionBetweenTwoEqualValues(Fail, actualUrl, expectedUrl);
         }
    }
}

