package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.ShowroomsPage;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ShowroomsPageTest extends TestBase {

    public ShowroomsPageTest() throws IOException {
        super();
    }

    @Test
    public void getSearchDealers() throws InterruptedException, IOException {
        //Creating object of Home page
        HomePage home = new HomePage();
        //Creating object of Showrooms page
        ShowroomsPage showroom = new ShowroomsPage();

        initializationOnChrome(sheet1.getRow(1).getCell(9).toString());
        Thread.sleep(10000);
        home.clickSkip();
        home.clickShowroomsLink();
        Thread.sleep(5000);
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = sheet2.getRow(1).getCell(0).toString() + sheet2.getRow(1).getCell(1).toString();
        // Get the RequestSpecification of the request that is to be sent
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // Call RequestSpecification.get() method to get the response.
        // Adding query params
        Response response = httpRequest.queryParams("pageIndex", "1", "pageSize", "16", "productType", "1").get("");
        String strJson = response.asString();
        // First get the Json object instance from the Response interface
        JSONObject responseBodyInJSON = new JSONObject(strJson);
        // Get the result object from the response
        JSONObject result = responseBodyInJSON.getJSONObject("result");
        // Get the items array from the result object
        JSONArray itemsArray = result.getJSONArray("items");
        // Adding all names in a list
        List<String> apiNamesList = new ArrayList<>();
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject firstItem = itemsArray.getJSONObject(i);
            String nameAr = firstItem.getString("nameAr");
            apiNamesList.add(nameAr);
        }

        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));

    }
}
