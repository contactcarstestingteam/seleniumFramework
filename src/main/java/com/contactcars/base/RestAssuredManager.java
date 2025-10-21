package com.contactcars.base;

import com.contactcars.utils.CsvUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RestAssuredManager extends DevToolsManager {
    // Base URL API
    public RestAssuredManager() throws IOException {
        super();
    }

    public static Map<String, String> queryParams = new HashMap<>();

    // Get
    public static Response getRequest(String endpoint, String token) {
        return given()
                .baseUri( CsvUtils.getVariableValueFromSheet1("BaseURL"))
                .auth().oauth2(token)
                .header("Accept", "application/json")
                .header("correlation-id", "test")
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    // Post
    public static Response postRequest(String endpoint, String token, Object body) {
        return given()
                .baseUri( CsvUtils.getVariableValueFromSheet1("BaseURL"))
                .auth().oauth2(token)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }
    // Build qeury params for any Api
    public static Map<String, String> buildQueryParams(String... keyValuePairs) {
        for (int i = 0; i < keyValuePairs.length - 1; i += 2) {
            queryParams.put(keyValuePairs[i], keyValuePairs[i + 1]);
        }
        return queryParams;
    }

    public static List<String> callingShowroomsApi(String... params) {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = CsvUtils.getVariableValueFromSheet2("BaseURL") + CsvUtils.getVariableValueFromSheet2("SearchDealersApi");
        // Get the RequestSpecification of the request that is to be sent
        // to the server.
        RequestSpecification httpRequest = RestAssured.given();
        // Call RequestSpecification.get() method to get the response.
        // Adding query params
        Response response = httpRequest.queryParams(buildQueryParams(params)).get("");
        String strJson = response.asString();
        // First get the Json object instance from the Response interface
        JSONObject responseBodyInJSON = new JSONObject(strJson);
        // Get the resultObject object from the response
        JSONObject result = responseBodyInJSON.getJSONObject("result");
        // Get the items array from the resultObject object
        JSONArray itemsArray = result.getJSONArray("items");
        // Adding all names in a list
        List<String> apiNamesList = new ArrayList<>();
        for (int i = 0; i < itemsArray.length(); i++) {
            JSONObject firstItem = itemsArray.getJSONObject(i);
            String nameAr = firstItem.getString("nameAr");
            apiNamesList.add(nameAr);
        }
        return apiNamesList;
    }


}
