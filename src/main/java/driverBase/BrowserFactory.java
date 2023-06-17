package driverBase;

import enums.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ReadPropertiesFile;

import java.time.Duration;
import java.util.Objects;

public final class BrowserFactory {

    private BrowserFactory() {
    }

    public static void initDriver() throws Exception {
        if (Objects.isNull(DriverFactory.getDriver())) {
            if (ReadPropertiesFile.getValue(ConfigProperties.BROWSER).equalsIgnoreCase("chrome")) {
        //        WebDriverManager.chromedriver().setup();
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                DriverFactory.setDriver(driver);

            }
            if (ReadPropertiesFile.getValue(ConfigProperties.BROWSER).equalsIgnoreCase("firefox")) {
               // WebDriverManager.firefoxdriver().setup();
                WebDriver  driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                DriverFactory.setDriver(driver);
            }
        }
    }

    public static void tearDdown() {
        if (Objects.nonNull(DriverFactory.getDriver())) {
            DriverFactory.getDriver().quit();
            DriverFactory.unloadDriver();
        }
    }
}
