package com.contactcars.testcases;

import com.contactcars.base.DevToolsManager;

import com.contactcars.pages.HomePage;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomePageTest extends DevToolsManager {

    //Creating object of Home page
    HomePage home = new HomePage();
    List<String> responseMakesList = new ArrayList<>();
    List<String> responseModelsList = new ArrayList<>();
    List<String> responseYearsList = new ArrayList<>();
    List<String> responsePricesList = new ArrayList<>();
    List<String> responseDealerNamesList = new ArrayList<>();

    public HomePageTest() throws IOException {
        super();
    }

    public void openOtlobhaLandingPage() throws InterruptedException, IOException {
        LoginPageTest.login();
        Thread.sleep(5000);
        home.hoverOnServicesLink();
        Thread.sleep(5000);
        home.clickOtlobhaButton();
        Thread.sleep(5000);
    }

    @Test
    public void getRecentDealerAds() throws InterruptedException {
        setupDevTools();
        setupRequestListeners("DealerAds");
        setupResponseListeners("DealerAds");
        openChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        getResponseItems();
        home.waitDealerAds();
        validateResults();
    }

    public void getResponseItems() {
        // Loop on all objects inside the main result object
        for (int i = 0; i < result.length(); i++){
            // Get the data object from the result array
            JSONObject data = result.getJSONObject(i);
            // Get the make object
            JSONObject makeObject = data.getJSONObject("make");
            // Get the make name
            String makeName = makeObject.get("nameAr").toString();
            // Add the make name to makes list
            responseMakesList.add(makeName);
            // Get the model object
            JSONObject modelObject = data.getJSONObject("model");
            // Get the model name
            String modelName = modelObject.get("nameAr").toString();
            // Add the model name to the models list
            responseModelsList.add(modelName);
            // Get the year
            int year = data.getInt("year");
            // Add the year to the years list
            responseYearsList.add(String.valueOf(year));
            // Get the price
            int price = data.getInt("price");
            // Add the price to the price list
            responsePricesList.add(String.valueOf(price));
            // Get the dealer object
            JSONObject dealerObject = data.getJSONObject("dealer");
            // Get the dealer name
            String dealerName = dealerObject.get("name").toString();
            // Add the dealer name to the dealer names list
            responseDealerNamesList.add(dealerName);
        }
    }

    public void validateResults() {
        Assert.assertEquals(responsePricesList, home.getAdsPrices());
        Assert.assertEquals(responseMakesList, home.getAdsMakes());
        Assert.assertEquals(responseModelsList, home.getAdsModels());
        Assert.assertEquals(responseYearsList, home.getAdsYears());
        Assert.assertEquals(responseDealerNamesList, home.getAdsNames());
    }
    
}
