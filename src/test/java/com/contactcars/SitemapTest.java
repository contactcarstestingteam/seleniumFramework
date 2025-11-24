package com.contactcars;

import com.contactcars.base.DevToolsManager;
import com.contactcars.base.TestBase;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.ExtentReportUtils;
import com.contactcars.utils.HttpClientUtils;
import com.contactcars.utils.SitemapUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SitemapTest extends TestBase {


//    private CsvUtils csv;
    private SitemapUtils map;
    private HttpClientUtils http;
//    private ExtentReportUtils report;

    public SitemapTest(){
        super();
    }

//    //Creating object of Csv utils
//    CsvUtils csv = new CsvUtils();
//    //Creating object of sitemap utils
//    SitemapUtils map = new SitemapUtils();
//    //Creating object of httpClient utils
//    HttpClientUtils http = new HttpClientUtils();
//    //Creating object of report utils
//    ExtentReportUtils report = new ExtentReportUtils();

    @Test
    public void validateSitemapUrls() throws IOException {
        // Initialize all utilities that might throw IOException
//        csv = new CsvUtils();
        map = new SitemapUtils();
        http = new HttpClientUtils();
//        report = new ExtentReportUtils();

        // Extract URLs from sitemap
//        List<String> urls = map.extractUrlsFromSitemap(csv.getVariableValueFromSheet1("Sitemap"));
        List<String> urls = map.extractUrlsFromSitemap(System.getProperty("SITEMAP_URL"));


        for (String url : urls) {
            report.createTest("Testing URL: " + url);
            int statusCode = http.getStatusCode(url);

            if(statusCode == 200) {
//                driver.get(url);
//                String title = driver.getTitle();
//
//                report.testInfo("Page title: " + title);
                report.testPass("Page loaded successfully !");
                Assert.assertEquals(statusCode, 200, "Broken or bad URL: " + url);

                report.logAssertionBetweenTwoEqualValues("Pass", String.valueOf(statusCode), String.valueOf(200));
            } else {
//                Assert.assertFalse(driver.getTitle().isEmpty(), "Page has no title: " + url);
                report.logAssertionBetweenTwoEqualValues("Fail", String.valueOf(statusCode), String.valueOf(200));
            }
        }
    }
}
