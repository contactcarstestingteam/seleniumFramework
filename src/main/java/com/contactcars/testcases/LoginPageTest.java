package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class LoginPageTest extends TestBase {

    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();
    //Creating object of report utils
    ExtentReportUtils report = new ExtentReportUtils();

    public LoginPageTest() throws IOException {
        super();
    }

    @Test
    public void login() throws InterruptedException, IOException {
        openChrome(csv.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        login.loginScenario();
        report.createTest("Login Test Case");
        //Check on logging in successfully
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = csv.getVariableValueFromSheet1("URL");
         if (actualUrl.contentEquals(expectedUrl)){
             Assert.assertTrue(actualUrl.contentEquals(expectedUrl));
             report.logAssertionBetweenTwoEqualValues("Pass", actualUrl, expectedUrl);
         } else {
             report.logAssertionBetweenTwoEqualValues("Fail", actualUrl, expectedUrl);
         }
    }
}

