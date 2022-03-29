package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

public class MovieMainScreen extends BaseMobileScreen {

    private MobileElement movieName = new MobileElement(By.Id,"com.imdb.mobile:id/title",
            "Movie screen, getting Movie Name");

    private MobileElement addWatchlist = new MobileElement(By.Id,"com.imdb.mobile:id/state_off",
            "Add Watchlist button");

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

    public WebElement scrollToAnElementByText(String text) {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\"));"));
    }
}
