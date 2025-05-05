package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.io.IOException;


public class OtlobhaPageTest extends TestBase {

    public OtlobhaPageTest() throws IOException {
        super();
    }

    @Test
    public void openOtlobhaLandingPage() throws InterruptedException, IOException {
        //Creating object of Home page
        HomePage home = new HomePage(driver);
        com.contactcars.testcases.LoginPageTest.login();
        Thread.sleep(5000);
        home.hoverOnServicesLink();
        home.clickOtlobhaButton();
    }

    @Test
    public void openOtlobhaForm() throws InterruptedException, IOException {
        //Creating object of Otlobha landing page
        OtlobhaLandingPage otlobhaLanding = new OtlobhaLandingPage(driver);
        openOtlobhaLandingPage();
        Thread.sleep(5000);
        otlobhaLanding.clickRequestNewCarButton();
    }

    @Test
    public void addNewRequest() throws InterruptedException, IOException {
        //Creating object of Otlobha form 1st step page
        OtlobhaForm1stStep form1stStep = new OtlobhaForm1stStep(driver);
        //Creating object of Otlobha form 2nd step page
        OtlobhaForm2ndStep form2ndStep = new OtlobhaForm2ndStep(driver);
        //Creating object of Wallet paymnet gateway page
        WalletPaymentGateway wallet = new WalletPaymentGateway(driver);
        openOtlobhaForm();
       // first step
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(0);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(0);
        form1stStep.clickAgency();
        form1stStep.clickYear();
        form1stStep.chooseYearValue(1);
        Thread.sleep(5000);
        form1stStep.clickTrim();
        form1stStep.chooseTrimValue(0);
        form1stStep.clickNext();
        Thread.sleep(5000);
        // terms and conditions popup
        form1stStep.clickAgree();
        Thread.sleep(5000);

        // second step - promocode
        form2ndStep.enterPromoCode(sheet.getRow(1).getCell(8).toString());
        form2ndStep.clickApplyPromoCode();
        Thread.sleep(5000);
        form2ndStep.clickDeletePromoCode();

        // second step - wallet
        form2ndStep.chooseWallet();
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(sheet.getRow(1).getCell(5).toString());
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        wallet.enterMPin(sheet.getRow(1).getCell(6).toString());
        wallet.enterOtp(sheet.getRow(1).getCell(7).toString());
        wallet.clickPay();
    }

}
