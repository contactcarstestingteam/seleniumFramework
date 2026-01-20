package com.contactcars.testcases;
import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.WaitUtils;
import com.contactcars.pages.UsedCarsSEOPages;
import org.testng.annotations.Test;
import java.io.IOException;


public class UsedCarsSEOPageTest extends TestBase {
    //protected WaitUtils waitUtils;

    //Creating object of csv utils
    CsvUtils csv = new CsvUtils();

    public UsedCarsSEOPageTest() throws IOException {
        //waitUtils = new WaitUtils(driver, 10);
    }

    @Test
    public void makeModelYearTrimScenario () throws InterruptedException, IOException {
        usedCarsSEOPage = new UsedCarsSEOPages(driver);
        openChrome(csv.getVariableValueFromSheet1("URLEn"));
        home.NavigateToUsedCarSEOPage();
        Thread.sleep(5000);
        usedCarsSEOPage.makeModelYearTrimPath();
    }

    @Test
    public void cityAreaMakeModelScenario () throws InterruptedException, IOException {
        usedCarsSEOPage = new UsedCarsSEOPages(driver);
        openChrome(csv.getVariableValueFromSheet1("URLEn"));
        home.NavigateToUsedCarSEOPage();
        Thread.sleep(5000);
        usedCarsSEOPage.cityAreaMakeModelPath();
    }

    @Test
    public void cityMakeModelScenario () throws InterruptedException, IOException {
        usedCarsSEOPage = new UsedCarsSEOPages(driver);
        openChrome(csv.getVariableValueFromSheet1("URLEn"));
        home.NavigateToUsedCarSEOPage();
        Thread.sleep(5000);
        usedCarsSEOPage.cityAreaMakeModelPath();
    }
}
