package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;
import enums.ConfigProperties;
import utils.ReadPropertiesFile;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtReports {

    private ExtReports(){}
    private static ExtentReports extent;
    public static void initExtent () throws Exception {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
        }
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
        extent.attachReporter(spark);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Selenium Automation Report");
        spark.config().setReportName("Automation Test Report");

        //NEW
        extent.setSystemInfo("Executed on the Environment Url ", ReadPropertiesFile.getValue(ConfigProperties.URL));
        extent.setSystemInfo("Executed on the Browser ", ReadPropertiesFile.getValue(ConfigProperties.BROWSER));
        extent.setSystemInfo("Executed on the OS ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User ", System.getProperty("user.name"));


    }

    public static void flushReports() throws IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
           // Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath())).toURI());
            ExtentManager.unloadExtentTest();

        }
    }

    public static void createTest(String testCaseName){
       ExtentTest test = extent.createTest(testCaseName);
       ExtentManager.setExtentTest(test);
    }

    public static void addCategories(String[] catagories){
        for (String catagory:catagories){
            ExtentManager.getExtentTest().assignCategory(catagory);
        }
    }
}

