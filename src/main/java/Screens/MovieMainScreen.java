package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import net.thucydides.core.webdriver.WebDriverFacade;

public class MovieMainScreen extends BaseMobileScreen {

    private MobileElement movieName = new MobileElement(By.Id,"com.imdb.mobile:id/title",
            "Movie screen, getting Movie Name");

    private MobileElement addWatchlist = new MobileElement(By.Id,"com.imdb.mobile:id/state_off",
            "Add Watchlist button");

    AppiumDriver<MobileElement> conexionAppium = ((AppiumDriver<MobileElement>)((WebDriverFacade) driver).getProxiedDriver());
    public AppiumDriver<MobileElement> getConexionAppium(){return this.conexionAppium;}

    public MovieMainScreen() {
        super();
    }

    public String getMovieName(){
        String value = String.valueOf(findMobileElement(movieName).getText());
        System.out.println(value);
        waitTime();
        return value;
    }

    public void addWatchlistClick(){
        findMobileElement(addWatchlist).click();
        waitTime();
    }

    public void scrollDown(String value){
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector()" +
                        ".textContains(\""+value +"\").instance(0))").click();

    }

    private void verticalSwipe() {
        // TODO Auto-generated method stub
        Dimension dim = (driver.manage().window().getSize());
        System.out.println("la dimension es"+dim);
        int height=dim.getHeight();
        int width= dim.getWidth();
        int x = width/2;
        int starty= (int)(height*0.80);
        int endy= (int)(height*0.20);
        swipe(x, starty, x, endy);
    }


    @SuppressWarnings("rawtypes")
    public void swipe (int inicialx, int inicialy, int finx, int finy) {
        new TouchAction((PerformsTouchActions) conexionAppium).longPress(
                        new PointOption<>().withCoordinates(inicialx,inicialy)).
                moveTo(new PointOption<>().withCoordinates(finx,finy)).release().perform();
    }

    public WebElement scrollToAnElementByText(String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }
}
