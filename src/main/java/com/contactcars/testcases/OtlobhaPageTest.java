package com.contactcars.testcases;

import com.contactcars.base.TestBase;
import com.contactcars.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import java.io.IOException;


public class OtlobhaPageTest extends TestBase {
    //Creating object of Home page
    HomePage home = new HomePage();
    //Creating object of Otlobha landing page
    OtlobhaLandingPage otlobhaLanding = new OtlobhaLandingPage();
    //Creating object of Otlobha form 1st step page
    OtlobhaForm1stStep form1stStep = new OtlobhaForm1stStep();
    //Creating object of Otlobha form 2nd step page
    OtlobhaForm2ndStep form2ndStep = new OtlobhaForm2ndStep();
    //Creating object of Wallet paymnet gateway page
    WalletPaymentGateway wallet = new WalletPaymentGateway();

    public OtlobhaPageTest() throws IOException {
        super();
    }

@Test // Test (1) (Agency + Specific Trim + cash + Wallet)
    public void OtlobhaAgencySpecificTrim() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
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
        form1stStep.chooseTrimValue(1);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

    // second step Bank Card
    form2ndStep.ChooseBankCard();
    form2ndStep.clickSubmit();
   Thread.sleep(10000);
    payWithCard();
    Thread.sleep(30000);
    //Check on success page
    form2ndStep.CheckUrl();
    quitChrome();

    }

    @Test // Test (2) (Agency + All Trims + cash + wallet)
    public void OtlobhaAgencyAllTrims() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(2);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickAgency();
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        Thread.sleep(5000);
        form1stStep.clickTrim();
        form1stStep.chooseTrimValue(0);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (3) (Agency + Other Trim + cash + wallet)
    public void OtlobhaAgencyOtherTrim() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(2);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickAgency();
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        Thread.sleep(5000);
        form1stStep.clickTrim();
        form1stStep.chooseTrimValue(1);
        form1stStep.ClickAndChooseOtherTrim();
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (4) (Agency + Specific Trim + Finance + Minimum Down Payment + Wallet)
    public void OtlobhaAgencyMinDownPayment() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
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
        form1stStep.ClickFinance();
        form1stStep.MinimumDownPayment();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }

    @Test // Test (5) (Agency + All Trims +  Finance + Minimum Down Payment + wallet)
    public void OtlobhaAgencyMinDownPayment2() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(2);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickAgency();
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        Thread.sleep(5000);
        form1stStep.clickTrim();
        form1stStep.chooseTrimValue(0);
        form1stStep.ClickFinance();
        form1stStep.MinimumDownPayment();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (6) (Agency + Other Trim + Finance + Minimum Down Payment + wallet)
    public void OtlobhaAgencyMinDownPayment3() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(2);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickAgency();
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        Thread.sleep(5000);
        form1stStep.clickTrim();
        form1stStep.chooseTrimValue(1);
        form1stStep.ClickAndChooseOtherTrim();
        form1stStep.ClickFinance();
        form1stStep.MinimumDownPayment();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (7) (Agency + Specific Trim + Finance + Down Payment Value + Wallet)
    public void OtlobhaAgencyDownPaymentValue() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
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
        form1stStep.ClickFinance();
        form1stStep.DownPaymentValue2();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (8) (Agency + All Trims + Finance + Down Payment Value + Wallet)
    public void OtlobhaAgencyDownPaymentValue2() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(2);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickAgency();
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        Thread.sleep(5000);
        form1stStep.clickTrim();
        form1stStep.chooseTrimValue(0);
        form1stStep.ClickFinance();
        form1stStep.DownPaymentValue2();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }



    @Test // Test (9) (Agency +Other Trim + Finance + Down Payment Value + Wallet)
    public void OtlobhaAgencyDownPaymentValue3() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(2);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickAgency();
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        Thread.sleep(5000);
        form1stStep.clickTrim();
        form1stStep.chooseTrimValue(1);
        form1stStep.ClickAndChooseOtherTrim();
        form1stStep.ClickFinance();
        form1stStep.DownPaymentValue2();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (10) (Imported + Specific Trim + cash + wallet)
    public void OtlobhaImportedSpecificTrim() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(6);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickImported();
        Thread.sleep(5000);
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        form1stStep.clickTrim();
        Thread.sleep(5000);
        form1stStep.chooseTrimValue(0);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (11) (Imported + "Imported= All trims" + cash + wallet)
    public void OtlobhaImportedAllTrims() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(25);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(22);
        form1stStep.clickImported();
        Thread.sleep(5000);
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        form1stStep.clickTrim();
        Thread.sleep(5000);
        form1stStep.chooseTrimValue(0);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }

    @Test // Test (12) (Imported + Specific Trim + Finance + Minimum Down Payment + wallet)
    public void OtlobhaImportedMiniDP() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(6);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickImported();
        Thread.sleep(5000);
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        form1stStep.clickTrim();
        Thread.sleep(5000);
        form1stStep.chooseTrimValue(0);
        form1stStep.ClickFinance();
        form1stStep.MinimumDownPayment();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }

    @Test // Test (13) (Imported + (Imported = all trims) + Finance + Minimum Down Payment + wallet)
    public void OtlobhaImportedMiniDP2() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(6);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickImported();
        Thread.sleep(5000);
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        form1stStep.clickTrim();
        Thread.sleep(5000);
        form1stStep.chooseTrimValue(2);
        form1stStep.ClickFinance();
        form1stStep.MinimumDownPayment();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }


    @Test // Test (14) (Imported + Specific trim + Finance + Down Payment value + wallet)
    public void OtlobhaImportedDPvalue() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(6);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickImported();
        Thread.sleep(5000);
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        form1stStep.clickTrim();
        Thread.sleep(5000);
        form1stStep.chooseTrimValue(0);
        form1stStep.ClickFinance();
        form1stStep.DownPaymentValue2();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }

    @Test // Test (15) (Imported + All trims + Finance + Down Payment value + wallet)
    public void OtlobhaImportedDPvalue2() throws InterruptedException, IOException {
        HomePageTest.openOtlobhaLandingPage();
        OtlobhaLandingPage.clickRequestNewCarButton();

        //Step one
        Thread.sleep(5000);
        form1stStep.clickCountry();
        form1stStep.chooseCountryValue(0);
        form1stStep.clickMake();
        form1stStep.chooseMakeValue(6);
        form1stStep.clickModel();
        form1stStep.chooseModelValue(1);
        form1stStep.clickImported();
        Thread.sleep(5000);
        form1stStep.clickYear();
        form1stStep.chooseYearValue(0);
        form1stStep.clickTrim();
        Thread.sleep(5000);
        form1stStep.chooseTrimValue(2);
        form1stStep.ClickFinance();
        form1stStep.DownPaymentValue2();
        form1stStep.ClickJopTitle();
        form1stStep.WriteJopTilte();
        Thread.sleep(5000);
        form1stStep.ClickTerms();
        form1stStep.clickNext();
        Thread.sleep(5000);

        // second step
        form2ndStep.chooseWallet();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        form2ndStep.clickSubmit();
        Thread.sleep(5000);
        form2ndStep.enterWalletNumber(getVariableValueFromSheet1("WalletNo"));
        form2ndStep.clickProceedToPay();
        Thread.sleep(5000);

        //payment gateway
        payWithWallet();
        Thread.sleep(5000);
        //Check on success page
        form2ndStep.CheckUrl();
        quitChrome();
    }
}
