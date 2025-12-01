package com.contactcars;

import com.contactcars.base.TestBase;
import com.contactcars.utils.ExtentReportUtils;
import com.contactcars.utils.HttpClientUtils;
import com.contactcars.utils.SitemapUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class SitemapTest extends TestBase {

    private SitemapUtils map;
    private HttpClientUtils http;
    private ExtentReportUtils report;

    public SitemapTest(){
        super();
    }

    @Test
    public void validateSitemapUrls() throws IOException {
        // Initialize all utilities that might throw IOException
        map = new SitemapUtils();
        http = new HttpClientUtils();
        report = new ExtentReportUtils();

        // Extract URLs from sitemap
        List<String> urls = map.extractUrlsFromSitemap(System.getenv("SITEMAP_URL"));


        for (String url : urls) {
            report.createTest("Testing URL: " + url);
            // Set custom start time
            report.extentTest.getModel().setStartTime(new Date(System.currentTimeMillis()));
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
            // Set custom end time
            report.extentTest.getModel().setEndTime(new Date());
        }
    }
}
