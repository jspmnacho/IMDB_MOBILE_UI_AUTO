package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class SearchScreen extends BaseMobileScreen {

    private MobileElement searchMenu = new MobileElement(By.Id,
            "com.imdb.mobile:id/navigation_search_browse",
            "Search Button Menu");
    private MobileElement searchMovieBanner = new MobileElement(By.Id,
            "com.imdb.mobile:id/search_src_text",
            "Search for a Movie banner");
    private MobileElement movieNameResult = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[1]",
            "First result Movie Name");
    private MobileElement movieImage = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.ImageView",
            "Image movie first option");

    public SearchScreen() {
        super();
    }

    public void searchTap(){
        findMobileElement(searchMenu).click();
    }

    public void searchMovie(String movie){
        findMobileElement(searchMovieBanner).sendKeys(movie);
    }

    public void tapSearchBanner(){
        findMobileElement(searchMovieBanner).click();
    }

    public String getNameMovie(){
        String value = String.valueOf(findMobileElement(movieNameResult).getText());
        System.out.println(value);
        return value;
    }

    public void imageMovieTap(){
        findMobileElement(movieImage).click();
    }
}
