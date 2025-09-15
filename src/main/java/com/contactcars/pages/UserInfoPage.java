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
    public Response getUserInfoAPI() {
        return given()
                .baseUri(BaseUrl)
                .auth().oauth2("AAAAAAAAAAAAAAAAAAAAABtKoKg7kBGNZVBg9eV4zNU0yc0wKFGdTOmSG5j+nc6cmRtdgz8okZf+yq+DKl8lg62B1eHRlh7NSCGxIufWnL4zMjIxG6BuwOtOufYBe8cfEaP03nhI4xYj6dqXm+xVSgtVslV4dvcept/heO4KOkkTlAFDj7t0g82/FMSQ8kcN9WJOCrSlFmQ84vvTjaWna7kFm2PahLgSV6s1eYzV7a97bLJa3MlhuCo43qB8Xw4KLc9SAMg05TnSrkypFU+LHXsuwTkgMDT92bnNBnTuSWk/IUR+wOnp8jdHni0+PdmZxdqOVWK7LAL167Rd2aHwgCj9n0jIdj18mQhpXuDiEuYi0YeEqISHvnF8SgaPtKFObzcinFUdnI5fFBnbeD2+1OOxYhGioPuW8APAg3pFXo3tP82glnFGAw5UUU9RBO8MrtpxCzhWwla7sKjYjBiR5fQO89pncKrnyvdZr2P4o3k77EF3iu23JBmeOsJoUl6DX8azci5alGigC+b5LXpFrT9R8/2w0bZ1vNYN4VkitonW0KCw8m223RdYQIpTOCxQEdNJ7mwpjF2PRV8zpVZq4Wm6MGjff0UdxXrohcO0bWVuHj9v6JiYHEgk2STLJ1vCA3m+vvNWe0hh73RDkITGbcL13licNoj8AtXkfdQ5t0Azth6+SIYT7y1qiJoK58MEOgBLY7cXdb9o/bLqwkp2jEJM+J3WIjgT757O1ZWa/PJCzYf4ApczltYpvi3EmTNG6vKrFYsYykBUHUc1NKpmrk5JpWxhLeSS59HRtNhy2kI6spKo0C8IWH1UpWtRShiiE0U4VrbO7gUwd0tciz//0i/UN+EcBEI9OjRmQyqw0ikN6gJLmWphwV5y2Ljau6fCkx+eZa6I1SJDWyJKFGheVDNKX0TMbKTm3wGAd85oQZRgnV11vNJ83mN8F3v4lSXep9a0/OLFWtg7amVzxd5F2lmKCItV1vXcNkmbDNM483C0v4S2h5RF8Sn0iA7fQbRQitxChTEalfBN6syl6BFYa3F3ArKtplx35Stw7Lzh/Xn7Me7h7MWVhTDpCWqZAQZL6459Zo2+pBal6BGwIQH4MfmQO5UVk5jJ3ivkZYsvXVKhEGoFHVfRA7pVFRikvJoCfjBepgEzFN/pXvDiUnfccCusnXY858i7kwWdCEB+STc1spzgZCCRU9sL/J8Yg5OycMaZnAXId7eB/nUnsmA8Bi8jc9BLd3gUFqWaazqAnTn/FdtlxNZhIhnLBEYWQOGhPHEYE59SoKjscDNjSPpUyV2G4ZrRFEy4cMC4Kg65rWCXPIojz5entlqaAu8iWkBm3+oJweFTX4DoVkhd3J3uGGkvygc+wFhFN9Uwh0pDZdnTwUxMdNMhanTzmLACqO1/AZ/ktSeNozc9Ru1HYFprfw/xYFWLBQgzLKP2WMKANrm8EF3ttCmnEt4DNASkrjjdjFCZXwfyDG2mpmK5V3pHw++Wbkmqvu6LSweG3u9qhHL1aUEyc8wXtf2VH71rVZ6c4buKiNKOIXoohY2DJRYpEbge8EH/MGoMux8fJC/HYVQ=")
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
