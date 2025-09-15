package com.contactcars.testcases;

import com.alibaba.fastjson.JSONObject;
import com.contactcars.base.TestBase;
import com.contactcars.pages.HomePage;
import com.contactcars.pages.UserInfoPage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class UserInfoTest extends TestBase {

    public UserInfoTest() throws IOException {
    }

    private UserInfoPage userInfoPage = new UserInfoPage();
    private HomePage home = new HomePage();
/*
    // --- Token Validation (لو حبيت تستخدمه) ---
    public boolean isTokenValid(String token) {
        try {
            String[] chunks = token.split("\\.");
            Base64.Decoder decoder = Base64.getUrlDecoder();
            String payload = new String(decoder.decode(chunks[1]));
            JSONObject json = JSONObject.parseObject(payload);

            long expiration = json.getLong("exp") * 1000; // Convert to milliseconds
            return System.currentTimeMillis() < expiration;
        } catch (Exception e) {
            System.out.println("Token validation error: " + e.getMessage());
            return false;
        }
    }

 */

    @Test
    public void compareApiUserInfoWithUi() throws IOException, InterruptedException {
        // --- Login & Navigate to Profile Page ---
        LoginPageTest.login();
        home.ClickMyAccountIcon();

        // --- 1) Get API Data ---
        Response apiResponse = userInfoPage.getUserInfoAPI();
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
