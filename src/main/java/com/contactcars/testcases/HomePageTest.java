package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class HomePageTest extends TestBase {

    public HomePageTest() throws IOException {
        super();
    }

    @Test
    public void getRecentDealerAds() throws InterruptedException {
//        initializationOnChrome(sheet.getRow(1).getCell(9).toString());
//        Thread.sleep(5000);

        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://fake-json-api.mock.beeceptor.com/users";
        // Get the RequestSpecification of the request that is to be sent
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // Call RequestSpecification.get() method to get the response.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("/Colby");
        String strJson = response.asString();
        // First get the Json object instance from the Response interface
        JSONObject responseBodyInJSON = new JSONObject(strJson);
        // Then simply query the Json object to get a String value of the node specified by JsonObject
        String id = responseBodyInJSON.getString("id");
        // Let us print the ID variable to see what we got
        System.out.println("ID received from Response " + id);

        // Validate the response
        Assert.assertEquals(id, "Colby", "Correct ID received in the Response");
    }
}
