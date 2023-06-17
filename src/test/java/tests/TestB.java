package tests;

import driverBase.DriverFactory;
import net.bytebuddy.build.ToStringPlugin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import reports.ExtReports;

public class TestB extends BaseTest {

    @Test(enabled = false)
    public void EbayTest() throws InterruptedException {
        ExtReports.createTest("Third Test");
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.ebay.com/");
        WebElement searchBox = driver.findElement(By.cssSelector("input.gh-tb"));
        searchBox.click();
        searchBox.sendKeys("shoes");
        driver.findElement(By.cssSelector("input.btn.btn-prim.gh-spr")).click();

        // Navigate to Search REsult page
        try {

            driver.findElement(By.xpath("//span[@class='fake-menu-button']//span[@class='btn__cell'][1]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//a[@class='fake-menu-button__item']/span[text()='List View']")).click();
        }
        catch (Exception e){
            System.out.println("Page is alreay on list view");
        }

        String productName = driver.findElement(By.xpath("//ul[@class='srp-results srp-list clearfix']/li[@class='s-item s-item__pl-on-bottom'][1]//span[@role='heading']")).getText();
        System.out.println(productName);

       if (productName.contains("Shoes")){
            Assert.assertTrue(true, productName);
       }
       else
           Assert.assertTrue(false, productName);

    }

}