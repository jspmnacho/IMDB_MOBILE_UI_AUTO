package Bases;

import Screens.*;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseMobileTest {

    private AndroidDriver<AndroidElement> driver;
    public LocationPopUp locationPopUp;
    public Login login;
    public SearchScreen searchScreen;
    public MovieMain movieMain;
    public YouScreen youScreen;


    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        locationPopUp = new LocationPopUp();
        login = new Login();
        searchScreen = new SearchScreen();
        movieMain = new MovieMain();
        youScreen = new YouScreen();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
