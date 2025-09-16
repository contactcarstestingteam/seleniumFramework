package com.contactcars.testcases;

import com.contactcars.base.DevToolsManager;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.LoginPage;
import com.contactcars.pages.UserInfoPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserInfoTest extends DevToolsManager {

    public UserInfoTest() throws IOException {
    }

    private UserInfoPage userInfoPage = new UserInfoPage();
    private HomePage home = new HomePage();
    private LoginPage Login = new LoginPage();

    @Test
    public void compareApiUserInfoWithUi() throws IOException, InterruptedException {
        // --- Login & Navigate to Profile Page ---
        driverInitialization();
        openChrome("https://web-staging.contactcars.com/ar/login");
        Thread.sleep(5000);

        Login.enterMobileNumber(getVariableValueFromSheet1("MobileNo"));
        Login.clickLogin();
        Thread.sleep(5000);
        Login.enterOtp(getVariableValueFromSheet1("OTP"));
        setupDevTools();
        setupRequestListeners("token");
        setupResponseListeners("token", "");
        Login.clickConfirm();
        Thread.sleep(5000);
        home.clickNoThanks();
        String token = result.get("access_token").toString();
        Thread.sleep(5000);
        home.ClickMyAccountIcon();

        // --- 1) Get API Data ---
        Response apiResponse = userInfoPage.getUserInfoAPI(token);
        String apiName = userInfoPage.getApiName(apiResponse);
        String apiPhone = userInfoPage.getApiPhone(apiResponse);
        String apiGovernorateId = userInfoPage.getApigovernate(apiResponse);
        String apiAreaId = userInfoPage.getApiArea(apiResponse);

        // --- 2) Mapping IDs to Names ---
        Map<String, String> governorates = new HashMap<>();
        governorates.put("1", "القاهرة");
        governorates.put("2", "الجيزة");
        governorates.put("3", "الفيوم");

        Map<String, String> areas = new HashMap<>();
        areas.put("248", "العجوزة");
        areas.put("251", "الدقي");
        areas.put("252", "المهندسين");

        // تحويل الـ ID إلى الاسم الفعلي
        String apiGovernorateName = governorates.getOrDefault(apiGovernorateId, apiGovernorateId);
        String apiAreaName = areas.getOrDefault(apiAreaId, apiAreaId);

        // --- 3) Get UI Data ---
        String uiName = userInfoPage.getUiName();
        String uiPhone = userInfoPage.getUiPhone();
        String uiGovernorate = userInfoPage.getUiGovernorate();
        String uiArea = userInfoPage.getUiArea();

        // --- Debug Print ---
        System.out.println("API Name: " + apiName);
        System.out.println("API Phone: " + apiPhone);
        System.out.println("API Governorate: " + apiGovernorateName + " (ID=" + apiGovernorateId + ")");
        System.out.println("API Area: " + apiAreaName + " (ID=" + apiAreaId + ")");

        System.out.println("UI Name: " + uiName);
        System.out.println("UI Phone: " + uiPhone);
        System.out.println("UI Governorate: " + uiGovernorate);
        System.out.println("UI Area: " + uiArea);

        // --- 4) Compare API vs UI ---
        Assert.assertEquals(uiName, apiName, "Name mismatch between UI and API");
        Assert.assertEquals(uiPhone, apiPhone, "Phone mismatch between UI and API");
        Assert.assertEquals(uiGovernorate, apiGovernorateName, "Governorate mismatch between UI and API");
        Assert.assertEquals(uiArea, apiAreaName, "Area mismatch between UI and API");
    }
}
