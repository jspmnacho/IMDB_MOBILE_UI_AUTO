package Bases;

import core.ConfigCapabilities;
import core.MobileAppDriver;
import core.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class BaseMobileScreen {
    protected AndroidDriver<AndroidElement> driver;
    protected WebDriverWait wait;
    private AndroidElement androidElement;
    private String mobileElementDescription;

    public BaseMobileScreen(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        wait = new WebDriverWait(driver, 30);
        iniElements();
    }

    private void iniElements(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public BaseMobileScreen findMobileElement(MobileElement mobileElement){
        mobileElementDescription = mobileElement.elementDescription;
        switch (mobileElement.by){
            case AndroidUiSelector:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator(mobileElement.element)));
                break;
            case Id:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.id(mobileElement.element)));
                break;
            case ClassName:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.className(mobileElement.element)));
                break;
            case Xpath:
                androidElement = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(mobileElement.element)));
                break;
        }
        return this;
    }

    public BaseMobileScreen click(){
        androidElement.click();
        return this;
    }

    public BaseMobileScreen sendKeys(String text){
        androidElement.sendKeys(text);
        return this;
    }

    public BaseMobileScreen getText(){
        androidElement.getText();
        return this;
    }

    public void assertionsTrue(Boolean actual, String expected) {
        try {
            Assert.assertTrue(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void assertionsEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitTime(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
