package com.contactcars.testcases;

import com.contactcars.base.TestBase;

import com.contactcars.pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.Request;
import org.openqa.selenium.devtools.v138.network.model.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;


public class HomePageTest extends TestBase {

    //Creating object of Home page
    HomePage home = new HomePage();

    public HomePageTest() throws IOException {
        super();
    }



    @Test
    public void getRecentDealerAds() throws InterruptedException {
        driverInitialization();
        Map<String, String> apiRequests = new ConcurrentHashMap<>();

        // Trigger the network activity
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
       //  Enable Network Monitoring
        devTools.send(Network.enable(Optional.of(10000000), Optional.of(10000000), Optional.of(10000000), Optional.empty()));

        // Listen for all requests
        devTools.addListener(Network.requestWillBeSent(), request -> {
            String requestId = request.getRequestId().toString();
            Request networkRequest = request.getRequest();
            String url = networkRequest.getUrl();
            String method = networkRequest.getMethod();

            // Capture API requests based on patterns
            if (isApiRequest(url, method)) {
                apiRequests.put(requestId, url);

                if(url.contains("DealerAds")){

//                    System.out.println("\n" + "=".repeat(80));
                    System.out.println("🚀 API REQUEST CAPTURED");
//                    System.out.println("=".repeat(80));
                    System.out.println("URL: " + url);
                    System.out.println("Method: " + method);
                    System.out.println("Request ID: " + requestId);

                    // Log request body for POST/PUT requests
//                    if (networkRequest.getPostData() != null && !networkRequest.getPostData().isEmpty()) {
//                        System.out.println("Request Body: " + networkRequest.getPostData());
//                    }
                }
            }
        });



        // Listen for all responses
        devTools.addListener(Network.responseReceived(), response -> {
            String requestId = response.getRequestId().toString();

            if (apiRequests.containsKey(requestId) && response.getResponse().getStatus() == 200) {
                Response networkResponse = response.getResponse();
                String url = networkResponse.getUrl();
                int statusCode = networkResponse.getStatus();
                String statusText = networkResponse.getStatusText();

//                System.out.println("\n" + "=".repeat(80));
                System.out.println("✅ API RESPONSE RECEIVED");
//                System.out.println("=".repeat(80));
                System.out.println("URL: " + url);
                System.out.println("Status: " + statusCode + " " + statusText);
                System.out.println("Request ID: " + requestId);

                // Get and log response body
                try {
                    Network.GetResponseBodyResponse responseBody = devTools.send(Network.getResponseBody(response.getRequestId()));
                    String body = responseBody.getBody();
                    System.out.println("Response Body: ");
                    System.out.println(formatJsonResponse(body));
                    System.out.println("=".repeat(80));

                } catch (Exception e) {
                    System.out.println("Error getting response body: " + e.getMessage());
                }
            }
        });


        // Also capture loading failed events
//        devTools.addListener(Network.loadingFailed(), loadingFailed -> {
//            String requestId = loadingFailed.getRequestId().toString();
//            if (apiRequests.containsKey(requestId)) {
//                System.out.println("\n❌ API REQUEST FAILED: " + apiRequests.get(requestId));
//                System.out.println("Error: " + loadingFailed.getErrorText());
//            }
//        });

        openChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
    }
}
