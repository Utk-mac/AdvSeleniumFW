package tests;

import annotations.FramewordAnnotations;
import constants.FrameworkConstants;
import driverBase.DriverFactory;
import listeners.RetryFailedTest;
import org.apache.poi.hssf.usermodel.HSSFPolygon;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonHomePage;
import pages.AmazonSearchResultPage;
import reports.ExtReports;
import reports.ExtentManager;
import utils.DataProviderUtils;

import javax.swing.plaf.SpinnerUI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TestA extends BaseTest {
    @FramewordAnnotations(catogery = {"Smoke"})
    @Test()
    public void pomTest(){

        AmazonHomePage amazonHomePage = new AmazonHomePage();
        amazonHomePage.enterSearchData("iphone 13");
        AmazonSearchResultPage amazonSearchResultPage = new AmazonSearchResultPage();
        amazonSearchResultPage.searchSpecificPricedProduct(70000);
    }
    @FramewordAnnotations(catogery = {"Smoke", "Regression"})
    @Test(retryAnalyzer = RetryFailedTest.class)
    public void pomSecondTest() throws InterruptedException {
        AmazonHomePage a = new AmazonHomePage();
        a.dropDownAlphabeticalOrderCheck();

    }

    @FramewordAnnotations(catogery = {"Regression"})
    @Test(dataProvider = "LoginTestData", dataProviderClass = DataProviderUtils.class)
    public void LoginTest (Map<String,String> dataMap){
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        amazonHomePage.clickOnSigninBtn()
                .enterUserName(dataMap.get("username"))
                .clickonContinueUserNameBtn()
                .enterPassword(dataMap.get("password"))
                .clickOnSubmitBtn()
                .AssertUserNameText();
    }

/*    @DataProvider(name = "LoginTestData", parallel = true)
    public Object[][] getData() {
        return new Object[][]
                {
                        {"rcks740@gmail.com", "ae1140sa"},
                        {"rcks741@gmail.com", "ae1140sa"},
                        {"rcks123@gmail.com","ae1140sa"},
                        {"rcks743@gmail.com","aae1140sa"},
                        {"rcks745@gmail.com","ae1140sa"}
                  };
    }
    */




}
