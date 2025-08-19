package com.contactcars.testcases;

import com.contactcars.base.TestBase;

import com.contactcars.pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.ResourceType;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
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

        // Trigger the network activity

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();


        // Enable Network Monitoring
//        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
//
//        devTools.addListener(Network.requestWillBeSent(), requestWillBeSent -> {
//            Request request = requestWillBeSent.getRequest();
////            System.out.println("Mine" + request.getUrl());
//        });
//
//
////        final RequestId[] requestId = new RequestId[1];
//        final Map<RequestId, String> matchedUrls = new HashMap<>();
//
//        // Listen to responseReceived events
//        devTools.addListener(Network.responseReceived(), responseReceived -> {
//            if (responseReceived.getResponse().getUrl().contains("getRecentDealerAds")) {
//                matchedUrls.put(responseReceived.getRequestId(), responseReceived.getResponse().getUrl());
//                System.out.println("Captured response for: " + responseReceived.getResponse().getUrl());
//            }
//        });
//


        // Enable Network monitoring
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(),Optional.empty()));

// Map to track API requests
        Map<String, String> apiRequests = new ConcurrentHashMap<>();

        devTools.addListener(Network.requestWillBeSent(), request -> {
            String requestId = request.getRequestId().toString();
            String url = request.getRequest().getUrl();
            String method = request.getRequest().getMethod();
            Optional<ResourceType> resourceType = request.getType();

            // Debug: print all requests to see what types exist
            System.out.println("🔍 " + resourceType + " " + method + " " + url);

            if (isApiCall(url, method, resourceType)) {
                apiRequests.put(requestId, url);
                System.out.println("✅ API REQUEST: " + method + " " + url);
                System.out.println("   Type: " + resourceType);

                // Log headers
                System.out.println("   Headers: " + request.getRequest().getHeaders());

            }
        });

// Listen for responses
        devTools.addListener(Network.responseReceived(), response -> {
            String requestId = response.getRequestId().toString();

            if (apiRequests.containsKey(requestId)) {
                String url = apiRequests.get(requestId);
                int status = response.getResponse().getStatus();

                System.out.println("✅ API RESPONSE: " + status + " " + url);

//                // Try to get response body
//                try {
//                    CompletableFuture<String> bodyFuture = devTools.send(Network.getResponseBody(requestId));
//                    bodyFuture.thenAccept(body -> {
//                        System.out.println("   Response: " + (body.length() > 300 ? body.substring(0, 300) + "..." : body));
//                    });
//                } catch (Exception e) {
//                    System.out.println("   Could not retrieve response body");
//                }
            }
        });




        openChrome(getVariableValueFromSheet1("URL"));
    }
}
