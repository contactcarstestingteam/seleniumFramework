package com.contactcars.testcases;
import com.contactcars.base.TestBase;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.WaitUtils;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.UsedCarsSEOPages;
import org.testng.annotations.Test;
import java.io.IOException;


public class UsedCarsSEOPageTest extends TestBase {
    //protected WaitUtils waitUtils;

    UsedCarsSEOPages usedCarsSEOPage;
    HomePage homePage = new HomePage();
    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();

    public UsedCarsSEOPageTest() throws IOException {
        //waitUtils = new WaitUtils(driver, 10);
    }

    @Test
    public void makeModelYearTrimScenario () throws InterruptedException, IOException {
        driverInitialization();
        usedCarsSEOPage = new UsedCarsSEOPages(driver);
        openChrome(csv.getVariableValueFromSheet1("URLEn"));
        homePage.NavigateToUsedCarSEOPage();
        Thread.sleep(5000);
        usedCarsSEOPage.makeModelYearTrimPath();
    }
}
