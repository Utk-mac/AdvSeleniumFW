package pages;

import driverBase.DriverFactory;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import reports.ExtentLogger;

import java.util.List;

public final class AmazonLoginPage extends BasePage{

    private final By userName = By.xpath("//input[@name='email']");
    private final By continueUserNameBtn = By.xpath("//input[@id='continue']");
    private final By password = By.xpath("//input[@id='ap_password']");
    private final By signInSubmitBtn = By.xpath("//input[@id='signInSubmit']");
    private final By errorSign = By.xpath("//div[@id='auth-error-message-box']//i");

    public AmazonLoginPage enterUserName(String userNameText){
        WebDriver driver = DriverFactory.getDriver();
        //driver.findElement(userName).sendKeys(userNameText);
        sendKeys(userName,userNameText, WaitStrategy.VISIBLE);
        ExtentLogger.pass("userName is entered");
        return this;
    }
    public AmazonLoginPage clickonContinueUserNameBtn(){
      //  DriverFactory.getDriver().findElement(continueUserNameBtn).click();
        click(continueUserNameBtn, WaitStrategy.CLICKABLE);
        return this;
    }
    public AmazonLoginPage enterPassword(String passwordText){
        WebDriver driver = DriverFactory.getDriver();
          List<WebElement> ele = driver.findElements(errorSign);
          if (ele.size()>0){
              System.out.println("UserName is Incorrect");
              Assert.assertTrue(false, "User is Incorrect");
              ExtentLogger.fail("Invalid userName");
          }
          else {
             // driver.findElement(password).sendKeys(passwordText);
              sendKeys(password,passwordText,WaitStrategy.CLICKABLE);
              ExtentLogger.pass("PassWord is entered");
              return this;
          }
        return null;
    }

    public AmazonHomePage clickOnSubmitBtn() {
        DriverFactory.getDriver().findElement(signInSubmitBtn).click();
        ExtentLogger.pass("Clicked on SignIn Btn");
        List<WebElement> ele = DriverFactory.getDriver().findElements(errorSign);
        if (ele.size() > 0) {
            System.out.println("PassWord is Incorrect");
            Assert.assertTrue(false, "Pass is Incorrect");
            ExtentLogger.fail("Invalid Password");
        } else {
            return new AmazonHomePage();
        }
        return null;
    }
}
