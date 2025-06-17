package com.contactcars.testcases;

import com.contactcars.base.TestBase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.RequestId;
import org.openqa.selenium.devtools.v129.network.model.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Optional;


public class HomePageTest extends TestBase {

    public HomePageTest() throws IOException {
        super();
    }

    @Test
    public void getRecentDealerAds() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        ChromeDriver driver = new ChromeDriver(options);

        // Trigger the network activity
        initializationOnChrome(getVariableValueFromSheet1("URL"));

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable Network Monitoring
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Listen to responseReceived events
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            Response response = responseReceived.getResponse();
            RequestId requestId = responseReceived.getRequestId();
            String url = response.getUrl();

            // You can filter specific URLs
            if (url.contains("getRecentDealerAds")) {
                System.out.println(">> URL: " + url);
                System.out.println(">> Status: " + response.getStatus());

                // Get the actual response body
                try {
                    Network.GetResponseBodyResponse bodyResponse = devTools.send(
                            Network.getResponseBody(requestId)
                    );
                    System.out.println(">> Response Body: " + bodyResponse.getBody());
                } catch (Exception e) {
                    System.out.println("Failed to get response body: " + e.getMessage());
                }
            }
        });


        try { Thread.sleep(5000); } catch (InterruptedException e) {}

        driver.quit();
    }

}
