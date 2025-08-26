package com.contactcars.testcases;

import com.contactcars.base.DevToolsManager;

import com.contactcars.pages.HomePage;
import org.testng.annotations.Test;

import java.io.IOException;



public class HomePageTest extends DevToolsManager {

    //Creating object of Home page
    HomePage home = new HomePage();

    public HomePageTest() throws IOException {
        super();
    }


    @Test
    public void getRecentDealerAds() throws InterruptedException {
        setupDevTools();
        setupRequestListeners("DealerAds");
        setupResponseListeners("DealerAds");
        openChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
    }
}
