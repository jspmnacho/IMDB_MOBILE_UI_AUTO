package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

import java.util.List;

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
        waitTime();
    }

    public void searchMovie(String movie){
        findMobileElement(searchMovieBanner).sendKeys(movie);
        waitTime();
    }

    public void tapSearchBanner(){
        findMobileElement(searchMovieBanner).click();
        waitTime();
    }

    public String getNameMovie(){
/*        List<MobileElement> list = (List<MobileElement>) findMobileElement(movieNameResult);
        for (int i=0; i< list.size(); i++) {
            (List<MobileElement>) findMobileElement(movieNameResult)
        }
*/
        String value = String.valueOf (findMobileElement(movieNameResult).getText());
        System.out.println(value);
        waitTime();
        return value;
    }

    public void imageMovieTap(){
        findMobileElement(movieImage).click();
        waitTime();
    }
}
