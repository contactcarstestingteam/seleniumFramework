package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.utils.CsvUtils;
import com.contactcars.utils.HttpClientUtils;
import com.contactcars.utils.SitemapUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SitemapTest extends TestBase {

    public SitemapTest() throws IOException {
    }

    //Creating object of Csv utils
    CsvUtils csv = new CsvUtils();
    //Creating object of sitemap utils
    SitemapUtils map = new SitemapUtils();
    //Creating object of httpClient utils
    HttpClientUtils http = new HttpClientUtils();

    @Test
    public void validateSitemapUrls() throws IOException {
        // Extract URLs from sitemap
        List<String> urls = map.extractUrlsFromSitemap(csv.getVariableValueFromSheet1("Sitemap"));

        for (String url : urls) {
            int statusCode = http.getStatusCode(url);
            Assert.assertEquals(statusCode, 200, "Broken or bad URL: " + url);
            // Optional UI validation using Selenium
            driver.get(url);
            Assert.assertFalse(driver.getTitle().isEmpty(), "Page has no title: " + url);
        }
    }
}
