package pages;

import driverBase.DriverFactory;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public final class AmazonSearchResultPage extends BasePage {
    //listOF Webelements
    private final By productsGrid = By.xpath("//div[contains(@data-asin,'B0') and @data-component-type='s-search-result']");
    private final By sponsoredLink = By.xpath(".//span[@class='puis-label-popover-default']");
    private final By productPrice = By.xpath(".//span[@class='a-price-whole']");
    private final By productTitle = By.xpath(".//span[@class='a-size-medium a-color-base a-text-normal']");


    public void searchSpecificPricedProduct(int itemPrice){
        WebDriver driver = DriverFactory.getDriver();
        List<WebElement> grid = driver.findElements(productsGrid);
        //
        List<Integer> allPrices = new ArrayList<>();
        for (WebElement element: grid){
            List<WebElement> isPresent= element.findElements(sponsoredLink);
            if (isPresent.size()<1){
                ExplicitWaitFactory.perfornExplicitWaitForElement(productPrice, WaitStrategy.PRESENCE);
                String price  = element.findElement(productPrice).getText().replace(",", "");
                int convertPrice = Integer.parseInt(price);
                if (convertPrice > itemPrice){
                  //  System.out.println(element.findElement(productTitle).getText());
                   // System.out.println(convertPrice);
                    allPrices.add(convertPrice);
                }
            }
        }
        if (allPrices.size()>0) {
            System.out.println("YO Pass");
            Assert.assertTrue(true, "At least one product priced above found");
        }
        else
            Assert.fail();
    }




}
