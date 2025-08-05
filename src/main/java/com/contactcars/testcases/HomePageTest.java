package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.LoginPage;
import com.contactcars.pages.OtlobhaLandingPage;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.contactcars.pages.HomePage.*;
import static com.contactcars.pages.LoginPage.clickConfirm;
import static com.contactcars.pages.LoginPage.clickLogin;


public class HomePageTest extends TestBase {

    public HomePageTest() throws IOException {
        super();
    }

    @Test
//    public void getRecentDealerAds() throws InterruptedException {
//        dismissExtrasPopup();
//
//    }

    public static void openOtlobhaLandingPage() throws InterruptedException, IOException {
        LoginPageTest.login();
        Thread.sleep(5000);
        hoverOnServicesLink();
        Thread.sleep(5000);
        clickOtlobhaButton();
        Thread.sleep(5000);
    }
}
