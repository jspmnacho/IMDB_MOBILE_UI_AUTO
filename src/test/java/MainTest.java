import Bases.BaseMobileTest;
import org.testng.annotations.Test;

public class MainTest extends BaseMobileTest {

    @Test
    public void firstScenario() {
        locationPopUp.dontAllowLocation();
        locationPopUp.okStayInformed();
        loginScreen.notNow();
        searchScreen.searchTap();
        searchScreen.tapSearchBanner();
        searchScreen.searchMovie("Batman");
        String val1 = searchScreen.getNameMovie();
        searchScreen.imageMovieTap();
        String val2 = movieMainScreen.getMovieName();
        movieMainScreen.assertionsEquals(val1, val2);
    }

    @Test
    public void secondScenario(){
        locationPopUp.allowLocation();
        locationPopUp.okStayInformed();
        loginScreen.signInGoogle();
        //login.chooseAccount();
        searchScreen.searchTap();
        searchScreen.tapSearchBanner();
        searchScreen.searchMovie("Spiderman");
        searchScreen.imageMovieTap();
        String val1 = movieMainScreen.getMovieName();
        movieMainScreen.addWatchlistClick();
        String val2 = youScreen.getMovieText();
        movieMainScreen.assertionsEquals(val1, val2);
    }

    @Test
    public void thirdScenario() throws InterruptedException {
        locationPopUp.allowLocation();
        locationPopUp.okStayInformed();
        loginScreen.signInGoogle();
        searchScreen.searchTap();
        searchScreen.tapSearchBanner();
        searchScreen.searchMovie("Spiderman");
        searchScreen.imageMovieTap();
        movieMainScreen.scrollDown("Add a Review");
        ratingScreen.addRating();
        //ratingScreen.headlineText("Head line text");
        ratingScreen.reviewText("Review text for the movie selected, Review text for the movie selected, " +
                "Review text for the movie selected, Review text for the movie selected, " +
                "Review text for the movie selected");
        ratingScreen.checkContainsSpoilers("No");
        ratingScreen.submitRating();
        String val1 = ratingScreen.checkReview();
        System.out.println(val1);
        ratingScreen.assertionsEquals(val1, "Submission successful");
        ratingScreen.reviewOkButton();
    }
}
