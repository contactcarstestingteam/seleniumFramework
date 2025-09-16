package com.contactcars.pages;

import com.contactcars.base.TestBase;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserInfoPage extends TestBase{

    private static final Logger log = LoggerFactory.getLogger(UserInfoPage.class);

    public UserInfoPage() throws IOException {
    }

    public final String BaseUrl = "https://api-staging.contactcars.com";

    // UI Locators
     By nameLocator = By.cssSelector("div.container.w-full.flex.justify-center > div > div.hidden.md\\:flex.lg\\:sticky.lg\\:top-\\[102px\\].h-auto.lg\\:w-1\\/4.w-full.lg\\:h-fit > div > div > div > h3");
     By phoneLocator = By.cssSelector("div.txt-sm.font-medium.text-dark-blue-600");
    // By governorateLocator = By.cssSelector("li.flex.items-center.p-1.py-2.txt-lg.hover\\:bg-gray-100.g-gray-100");
  //  By areaLocator = By.cssSelector("div:nth-child(4) > div > ul > li:nth-child(4)");
    By areaLocator = By.cssSelector("input[placeholder='مثال : مدينة نصر']");
    By governorateLocator = By.cssSelector("input[placeholder='مثال : القاهرة']");




    // UI Methods
    public String getUiName() {
        return driver.findElement(nameLocator).getText();
    }

    public String getUiPhone() {
        return driver.findElement(phoneLocator).getText();
    }
//
//    public String getUiGovernorate() {
//        return driver.findElement(governorateLocator).getText();
//    }
//
//    public String getUiArea() {
//        return driver.findElement(areaLocator).getText();
//    };



    //  API Methods
    public Response getUserInfoAPI(String token) {
        return given()
                .baseUri(BaseUrl)
                .auth().oauth2(token)
                .header("Accept", "application/json")
                .header("correlation-id","test")
                .when()
                .get("/gateway/identity/profile/getUserInfo")
                .then()
                .extract()
                .response();
    }

    public String getApiName(Response response) {
        return response.jsonPath().getString("result.name");
    }

    public String getApiPhone(Response response) {
        return response.jsonPath().getString("result.phoneNumber");
    }


    public String getApigovernate(Response response) {
        return response.jsonPath().getString("result.governate");
    }

    public String getApiArea(Response response) {
        return response.jsonPath().getString("result.area");
    }



    public String getUiArea() {
        WebElement areaInput = driver.findElement(areaLocator);
        return areaInput.getAttribute("value");
    }

    public String getUiGovernorate() {
        WebElement governorateInput = driver.findElement(governorateLocator);
        return governorateInput.getAttribute("value");
    }






}
