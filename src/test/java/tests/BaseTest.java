package tests;

import driverBase.BrowserFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import reports.ExtReports;

import java.io.IOException;

public class BaseTest {



    @BeforeMethod
    public void startUp() throws Exception {
        BrowserFactory.initDriver();

    }

    @AfterMethod
    public void tearDown(){
        BrowserFactory.tearDdown();
    }

}
