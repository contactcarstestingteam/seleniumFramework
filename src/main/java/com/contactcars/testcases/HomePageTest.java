package com.contactcars.testcases;

import com.contactcars.base.TestBase;

import com.contactcars.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v138.fetch.Fetch;
import org.openqa.selenium.devtools.v138.network.Network;
import org.openqa.selenium.devtools.v138.network.model.Request;
import org.openqa.selenium.devtools.v138.network.model.RequestId;
import org.openqa.selenium.devtools.v138.network.model.ResourceType;
import org.openqa.selenium.devtools.v138.network.model.Response;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


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
//        devTools.addListener(Network.loadingFinished(), loadingFinished -> {
//                    RequestId requestId = loadingFinished.getRequestId();
//                    if (matchedUrls.containsKey(requestId)) {
//                        Network.GetResponseBodyResponse body = devTools.send(Network.getResponseBody(requestId));
//                        System.out.println("Response Body for " + matchedUrls.get(requestId) + ":\n" + body.getBody());
//                    }
//                });



        devTools.send(Fetch.enable(Optional.empty(), Optional.empty()));
        devTools.addListener(Fetch.requestPaused(), requestPaused -> {
            String url = requestPaused.getRequest().getUrl();
            System.out.println("Fetch intercepted: " + url);
            devTools.send(Fetch.continueRequest(
                    requestPaused.getRequestId(),
                    Optional.of(url),
                    Optional.of(requestPaused.getRequest().getMethod()),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
            ));
        });


        Thread.sleep(5000);

        openChrome(getVariableValueFromSheet1("URL"));
    }
}
