package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class MovieMain extends BaseMobileScreen {

    private MobileElement movieName = new MobileElement(By.Id,"com.imdb.mobile:id/title",
            "Movie screen, getting Movie Name");

    private MobileElement addWatchlist = new MobileElement(By.Id,"com.imdb.mobile:id/state_off",
            "Add Watchlist button");

    public MovieMain() {
        super();
    }

    public String getMovieName(){
        String value = String.valueOf(findMobileElement(movieName).getText());
        System.out.println(value);
        return value;
    }

    public void addWatchlistClick(){
        findMobileElement(addWatchlist).click();
    }

    public void assertion(String val1, String val2){
        assertionsEquals(val1, val2);
    }
}
