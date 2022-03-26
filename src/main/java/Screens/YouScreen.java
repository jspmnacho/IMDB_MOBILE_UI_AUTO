package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class YouScreen extends BaseMobileScreen {

    private MobileElement youMenu = new MobileElement(By.Id,"com.imdb.mobile:id/navigation_you",
            "You button menu ");

    private MobileElement watchlistMovieName = new MobileElement(By.Id,"com.imdb.mobile:id/main_line",
            "Movie name on Your watchlist");

    public YouScreen() {
        super();
    }

    public String getMovieText(){
        String val = String.valueOf(findMobileElement(watchlistMovieName).getText());
        return val;
    }


}
