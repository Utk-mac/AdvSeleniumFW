package pages;

import driverBase.DriverFactory;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reports.ExtentLogger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AmazonHomePage extends BasePage {

    private final By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
    private final By searchBtn = By.xpath("//input[@id='nav-search-submit-button']");
    private final By productCatagoeryDropDown = By.xpath("//div[@class='nav-search-scope nav-sprite']");
    private final By dropDownOptions = By.xpath("//div[@class='nav-search-scope nav-sprite']//option");

    private final By signInBtn = By.xpath("//div[@id='nav-signin-tooltip']//span[@class='nav-action-inner']");
    private final By userNameText = By.xpath("//div[@class='nav-line-1-container']/span");




    public void enterSearchData(String searchInput){
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.amazon.in/");
 /*     WebElement serachBox  =driver.findElement(searchBox);
        serachBox.click();*/
        click(searchBox, WaitStrategy.PRESENCE);
       // serachBox.sendKeys(searchInput);
        sendKeys(searchBox, searchInput, WaitStrategy.PRESENCE);
        ExtentLogger.pass(searchInput + " is entered");
        driver.findElement(searchBtn).click();
        ExtentLogger.pass("clicked on search btn");
    }

    public void dropDownAlphabeticalOrderCheck() throws InterruptedException {
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.amazon.in/");
        //driver.findElement(productCatagoeryDropDown).click();
        Thread.sleep(1000);
        click(productCatagoeryDropDown,WaitStrategy.CLICKABLE);
        ExtentLogger.pass("clicked on product Catagoery DropDown");
        Thread.sleep(1000);
        List<String> optionsList = new ArrayList<>();
        List<WebElement> dropDownOptions = driver.findElements(this.dropDownOptions);
        for (WebElement option : dropDownOptions) {
            optionsList.add(option.getText());
        }
        //For sorting
        Collections.sort(optionsList);
        if (optionsList.equals(dropDownOptions))
            Assert.assertTrue(true, "List is IN alphabetical order.");
        else
            Assert.assertTrue(false, "List is NOT in alphabetical order.");
    }

    public AmazonLoginPage clickOnSigninBtn(){
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.amazon.in/");
        driver.findElement(signInBtn).click();
        ExtentLogger.pass("clicked On Signin Btn");
        return new AmazonLoginPage();
    }

    public void AssertUserNameText(){
        WebDriver driver = DriverFactory.getDriver();
    //   String loginValue =  driver.findElement(userNameText).getText();
        String loginValue = getText(userNameText,WaitStrategy.VISIBLE);
        if (loginValue.contains("sign in"))
            System.out.println("Login Failed");
        else
            System.out.println("login passed");
    }

}



