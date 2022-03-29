package Bases;

import Screens.*;
import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseMobileTest {

    private AndroidDriver<AndroidElement> driver;
    public LocationPopUp locationPopUp;
    public LoginScreen loginScreen;
    public SearchScreen searchScreen;
    public MovieMainScreen movieMainScreen;
    public YouScreen youScreen;
    public RatingScreen ratingScreen;


    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        driver = MobileAppDriver.getMoviesAppDriver(ConfigCapabilities.getCapabilities());
        locationPopUp = new LocationPopUp();
        loginScreen = new LoginScreen();
        searchScreen = new SearchScreen();
        movieMainScreen = new MovieMainScreen();
        youScreen = new YouScreen();
        ratingScreen = new RatingScreen();
    }

    @AfterMethod
    public void failDown(ITestResult result){
        if(ITestResult.FAILURE==result.getStatus()){
            Date date = new Date();
            SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
            try{
                File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(
                        "C:\\Users\\jpuerto\\OneDrive - ENDAVA\\Documents\\JSPM\\Manual2Automation\\" +
                                "Challenge\\IMDB_MOBILE_UI_AUTO\\src\\main\\screenshots\\" + result.getName()+"_"+
                                sFormat.format(date) +".jpg"));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
