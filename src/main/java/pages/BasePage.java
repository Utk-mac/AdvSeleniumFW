package pages;

import constants.FrameworkConstants;
import driverBase.DriverFactory;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected void sendKeys(By locator, String input, WaitStrategy waitStrategy){
        ExplicitWaitFactory.perfornExplicitWaitForElement(locator, waitStrategy).sendKeys(input);
    }
    protected void click(By locator, WaitStrategy waitStrategy ){
        ExplicitWaitFactory.perfornExplicitWaitForElement(locator, waitStrategy).click();
    }

    protected String  getText(By locator, WaitStrategy waitStrategy){
        ExplicitWaitFactory.perfornExplicitWaitForElement(locator, waitStrategy);
        return DriverFactory.getDriver().findElement(locator).getText();
    }



}
