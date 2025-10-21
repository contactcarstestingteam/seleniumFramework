package com.contactcars.testcases;

import com.contactcars.base.RestAssuredManager;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.ShowroomsDetailsPage;
import com.contactcars.pages.ShowroomsPage;
import com.contactcars.utils.CsvUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ShowroomsPageTest extends RestAssuredManager {

    //Creating object of Home page
    HomePage home = new HomePage();
    //Creating object of Showrooms page
    ShowroomsPage showroom = new ShowroomsPage();
    ShowroomsDetailsPage showroomDetails = new ShowroomsDetailsPage();


    public ShowroomsPageTest() throws IOException {
        super();
    }

    // Get all the cars showrooms without any filters
    @Test
    public void getAllCarsShowrooms() throws InterruptedException, IOException {
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        //home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        //home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        //home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        //home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
      //  home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
      //  home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
       // home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
      //  home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
        //home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
     //   home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
      //  home.clickSkip();
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
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URL"));
        Thread.sleep(5000);
    //    home.clickSkip();
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

    // Redirect to a specific showroom page without applying any filters
    @Test
    public void openShowroomPage() throws InterruptedException {
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URLEn"));
        Thread.sleep(5000);
        // home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        String showroomName = showroom.getShowroomName(9);
        showroom.chooseShowroomCard(9);
        Thread.sleep(5000);
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(showroomName.replace(" ", "-")));
        Assert.assertEquals(showroomName, showroomDetails.getName());
    }

    // Redirect to a specific showroom branch page without applying any filters
    @Test
    public void openBranchesTab() throws InterruptedException {
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URLEn"));
        Thread.sleep(5000);
       // home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        String showroomName = showroom.getShowroomName(9);
        showroom.chooseShowroomCard(9);
        Thread.sleep(5000);
        String currentShowroomURL = driver.getCurrentUrl();
        Assert.assertTrue(currentShowroomURL.contains(showroomName.replace(" ", "-")));
        Assert.assertEquals(showroomName, showroomDetails.getName());
        Thread.sleep(5000);
        showroomDetails.clickBranches();
        Thread.sleep(5000);
        String currentBranchesURL = driver.getCurrentUrl();
        Assert.assertTrue(currentBranchesURL.contains("activeTab=branches"));
    }

    // Redirect to a specific showroom contact us page without applying any filters
    @Test
    public void openContactUsTab() throws InterruptedException {
        driverInitialization();
        openChrome(CsvUtils.getVariableValueFromSheet1("URLEn"));
        Thread.sleep(5000);
        //home.clickSkip();
        Thread.sleep(5000);
        home.clickShowroomsLink();
        Thread.sleep(5000);
        String showroomName = showroom.getShowroomName(9);
        showroom.chooseShowroomCard(9);
        Thread.sleep(5000);
        String currentShowroomURL = driver.getCurrentUrl();
        Assert.assertTrue(currentShowroomURL.contains(showroomName.replace(" ", "-")));
        Assert.assertEquals(showroomName, showroomDetails.getName());
        Thread.sleep(5000);
        showroomDetails.clickContactUs();
        Thread.sleep(5000);
        String currentContactUsURL = driver.getCurrentUrl();
        Assert.assertTrue(currentContactUsURL.contains("activeTab=contact"));
    }
}

