package testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.UsedCarsSEOPages;
import com.contactcars.utils.CsvUtils;
import org.testng.annotations.Test;

import java.io.IOException;


public class UsedCarsSEOPageTest extends TestBase {
    //protected WaitUtils waitUtils;

    UsedCarsSEOPages usedCarsSEOPage;
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
}
