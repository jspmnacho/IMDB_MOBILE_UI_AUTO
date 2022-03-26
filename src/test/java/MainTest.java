import Bases.BaseMobileTest;
import org.testng.annotations.Test;

public class MainTest extends BaseMobileTest {

//    @AndroidFindBy(uiAutomator = "new UISelector().className(\"android.widget.Button\").textContains(\"ok\")")
//    public AndroidElement okButton;

    @Test
    public void firstScenario() {
        locationPopUp.dontAllowLocation();
        locationPopUp.okStayInformed();
        login.notNow();
        searchScreen.searchTap();
        searchScreen.tapSearchBanner();
        searchScreen.searchMovie("Batman");
        //String val1 = searchScreen.getNameMovie();
        searchScreen.imageMovieTap();
        //String val2 = movieMain.getMovieName();
        //movieMain.assertionsEquals(val1, val2);
    }

    @Test
    public void secondScenario(){
        locationPopUp.allowLocation();
        locationPopUp.okStayInformed();
        login.signInGoogle();
        //login.chooseAccount();
        searchScreen.searchTap();
        searchScreen.tapSearchBanner();
        searchScreen.searchMovie("Spiderman");
        searchScreen.imageMovieTap();
        //String val1 = movieMain.getMovieName();
        movieMain.addWatchlistClick();
        //String val2 = youScreen.getMovieText();
        //movieMain.assertionsEquals(val1, val2);
    }

    @Test
    public void thirdScenario(){

    }
}
