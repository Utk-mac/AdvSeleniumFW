
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import driverBase.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ReadPropertiesFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.time.Duration;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws Exception {


     /* Logger log =  LogManager.getLogger(Main.class.getName());


       log.info("yo ");
       log.debug(" this is a debug");*/


    }




    public void exTest(){


        ExtentReports extent = new ExtentReports();
        extent.attachReporter();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        extent.createTest("MyFirstTest");
        extent.flush();

    }


}
