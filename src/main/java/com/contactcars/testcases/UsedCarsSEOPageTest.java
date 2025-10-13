package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.UsedCarsSEOPages;
import org.testng.annotations.Test;

import java.io.IOException;

public class UsedCarsSEOPageTest extends TestBase {
    UsedCarsSEOPages usedCarsSEOPage = new UsedCarsSEOPages();
    HomePage homePage = new HomePage();

    public UsedCarsSEOPageTest() throws IOException {
    }

    @Test
    public void makeModelYearTrimScenario () throws InterruptedException {
        driverInitialization();
        openChrome(getVariableValueFromSheet1("URLEn"));
        homePage.NavigateToUsedCarSEOPage();
        Thread.sleep(5000);
        usedCarsSEOPage.makeModelYearTrimPath();
    }
}
