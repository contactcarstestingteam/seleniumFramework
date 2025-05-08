package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.devtools.DevTools;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class HomePageTest extends TestBase {

    public HomePageTest() throws IOException {
        super();
    }

    @Test
    public void getRecentDealerAds() throws InterruptedException {
//        initializationOnChrome(prop.getProperty("url"));
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
        System.out.println(response.asString());
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPath = response.jsonPath();
//        JsonPath jsonPath = new JsonPath(strJson);
        System.out.println(jsonPath);

        // Then simply query the JsonPath object to get a String value of the node specified by JsonPath
//        String id = jsonPath.getString("name");

        // Let us print the city variable to see what we got
//        System.out.println("ID received from Response " + id);

        // Validate the response
//        Assert.assertEquals(id, "Colby", "Correct ID received in the Response");

//        System.out.println("Response Body is =>  " + response.asString());

    }
}
