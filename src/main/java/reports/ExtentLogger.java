package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import driverBase.DriverFactory;
import enums.ConfigProperties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ReadPropertiesFile;
import utils.ScreenShotUtils;

public final class ExtentLogger {
    private ExtentLogger(){}

    public static void pass(String message){
        try {
            if (ReadPropertiesFile.getValue(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")){
                ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
            }else {
                ExtentManager.getExtentTest().pass(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void fail(String message){
        try {
            if (ReadPropertiesFile.getValue(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")){
                ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
            }else {
                ExtentManager.getExtentTest().fail(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void skip(String message){
        try {
            if (ReadPropertiesFile.getValue(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")){
                ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
            }else {
                ExtentManager.getExtentTest().skip(message);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
