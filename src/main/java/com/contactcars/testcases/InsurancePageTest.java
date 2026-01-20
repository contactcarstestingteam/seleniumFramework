package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.InsurancePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class InsurancePageTest extends TestBase {

    public InsurancePageTest() throws IOException {
    }

    @Test
    public void submitInsuranceRequest() {
        home.hoverOnServicesLink();
        home.clickInsuranceLink();
        insurancePage.insureCarRequest("Test", "01010101010", "350000", "Audi", "A4", "2022");
    }
}
