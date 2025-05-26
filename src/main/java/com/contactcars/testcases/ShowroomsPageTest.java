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

    //Creating object of Home page
    HomePage home = new HomePage();
    //Creating object of Showrooms page
    ShowroomsPage showroom = new ShowroomsPage();

    public ShowroomsPageTest() throws IOException {
        super();
    }

    // Get all the cars showrooms without any filters
    @Test
    public void getAllCarsShowrooms() throws InterruptedException, IOException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        home.clickShowroomsLink();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying all filters
    @Test
    public void applyAllFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.enterShowroomName("رويال موتورز");
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        Thread.sleep(5000);
        showroom.clickArea();
        showroom.chooseAreaValue(6);
        showroom.clickMake();
        showroom.chooseMakeValue(0);
        showroom.clickUsed();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "dealerName", "رويال موتورز", "locationId", "164", "makeIds", "243", "status", "3");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying name filter only
    @Test
    public void applyNameFilter() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.enterShowroomName("test");
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "dealerName", "test");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate filter only
    @Test
    public void applyGovernorateFilter() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "1");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate and area filters only
    @Test
    public void applyGovernorateAndAreaFilter() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        Thread.sleep(5000);
        showroom.clickArea();
        showroom.chooseAreaValue(6);
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "164");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying make filter only
    @Test
    public void applyMakeFilter() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickMake();
        showroom.chooseMakeValue(0);
        showroom.chooseMakeValue(1);
        showroom.chooseMakeValue(2);
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "makeIds", "243, 15, 33, 44");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

// Get all the cars showrooms with applying new status filter only
    @Test
    public void applyNewStatusFilter() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickNew();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "status", "2");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying used status filter only
    @Test
    public void applyUsedStatusFilter() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickUsed();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "status", "3");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying name and governorate filters only
    @Test
    public void applyNameAndGovernorateFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.enterShowroomName("test");
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "dealerName", "test", "locationId", "1");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying name, governorate and area filters only
    @Test
    public void applyNameAndAreaFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.enterShowroomName("test");
        showroom.clickCountry();
        showroom.chooseCountryValue(2);
        Thread.sleep(5000);
        showroom.clickArea();
        showroom.chooseAreaValue(1);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "dealerName", "test", "locationId", "220");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying name and make filters only
    @Test
    public void applyNameAndMakeFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.enterShowroomName("الحياة للسيارات");
        showroom.clickMake();
        showroom.chooseMakeValue(7);
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "dealerName", "الحياة للسيارات", "makeIds", "56");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate and make filters only
    @Test
    public void applyGovernorateAndMakeFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        showroom.clickMake();
        showroom.chooseMakeValue(7);
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "1", "makeIds", "56");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate and new status filters only
    @Test
    public void applyGovernorateAndNewStatusFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        showroom.clickNew();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "1", "status", "2");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate and used status filters only
    @Test
    public void applyGovernorateAndUsedStatusFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        showroom.clickUsed();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "1", "status", "3");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate, area and make filters only
    @Test
    public void applyAreaAndMakeFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        Thread.sleep(5000);
        showroom.clickArea();
        showroom.chooseAreaValue(1);
        showroom.clickMake();
        showroom.chooseMakeValue(5);
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "159", "makeIds", "1");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate, area and new status filters only
    @Test
    public void applyAreaAndNewStatusFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        Thread.sleep(5000);
        showroom.clickArea();
        showroom.chooseAreaValue(1);
        showroom.clickNew();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "159", "status", "2");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying governorate, area and used status filters only
    @Test
    public void applyAreaAndUsedStatusFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickCountry();
        showroom.chooseCountryValue(0);
        Thread.sleep(5000);
        showroom.clickArea();
        showroom.chooseAreaValue(1);
        showroom.clickUsed();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "locationId", "159", "status", "3");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying make and new status filters only
    @Test
    public void applyMakeAndNewStatusFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickMake();
        showroom.chooseMakeValue(1);
        showroom.clickNew();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "makeIds", "15", "status", "2");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }

    // Get all the cars showrooms with applying make and used status filters only
    @Test
    public void applyMakeAndUsedStatusFilters() throws InterruptedException {
        initializationOnChrome(getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        showroom.clickMake();
        showroom.chooseMakeValue(1);
        showroom.clickUsed();
        Thread.sleep(5000);
        // Adding all names in a list
        List<String> apiNamesList;
        apiNamesList = callingShowroomsApi("pageIndex", "1", "pageSize", "16", "productType", "1", "makeIds", "15", "status", "3");
        // Passing the list from page object model
        List <String> expectedNamesList = new ArrayList<>();
        showroom.getDealersNames(expectedNamesList);
        // Compare the content of the two lists regardless of their order
        Assert.assertTrue(expectedNamesList.containsAll(apiNamesList));
    }
}

