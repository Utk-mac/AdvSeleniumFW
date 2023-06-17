package factories;

import constants.FrameworkConstants;
import driverBase.DriverFactory;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }
    public static WebElement perfornExplicitWaitForElement(By locator, WaitStrategy waitStrategy) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameworkConstants.getWaitinseconds()))
                    .until(ExpectedConditions.elementToBeClickable(locator));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameworkConstants.getWaitinseconds()))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(FrameworkConstants.getWaitinseconds()))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        return element;

    }
}