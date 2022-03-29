package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;
import org.apache.commons.lang3.StringUtils;

public class RatingScreen extends BaseMobileScreen {

    private MobileElement ratingStar = new MobileElement(By.Xpath,
            "(//android.view.View[@content-desc=\"close_webview&site=android&ref_=andp_tt_urv_ar#\"])[7]/android.widget.Image",
            "Rating a movie");

    private MobileElement writeHeadline = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout[1]/android.widget.FrameLayout/" +
                    "androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
                    "android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/" +
                    "android.webkit.WebView/android.view.View/android.view.View/android.view.View[16]/" +
                    "android.widget.EditText",
            "Writing a headline for review");

    private MobileElement writeReview = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout[1]/android.widget.FrameLayout/" +
                    "androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
                    "android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/" +
                    "android.webkit.WebView/android.view.View/android.view.View/android.view.View[17]/" +
                    "android.widget.EditText",
            "Writing a review text for rating");

    private MobileElement checkContainSpoilersYES = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout[1]/android.widget.FrameLayout/" +
                    "androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
                    "android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/" +
                    "android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView/" +
                    "android.view.View[1]",
            "Check Yes contains spoilers");

    private MobileElement checkContainSpoilersNO = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout[1]/android.widget.FrameLayout/" +
                    "androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
                    "android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/" +
                    "android.webkit.WebView/android.view.View/android.view.View/android.widget.ListView/" +
                    "android.view.View[2]",
            "Check No contains spoilers");

    private MobileElement submitButton = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout." +
                    "widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/" +
                    "android.view.View/android.view.View/android.view.View[20]/android.widget.Button",
            "Submit button to add rating");

    private MobileElement checkSubmitRating = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout[1]/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/" +
                    "android.view.View/android.view.View[2]/android.widget.TextView[3]",
            "Message review successfully");

    private MobileElement reviewOkButton = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/" +
                    "android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout[1]/android.widget.FrameLayout/" +
                    "androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout/" +
                    "android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/" +
                    "android.webkit.WebView/android.view.View/android.view.View/android.view.View[8]/" +
                    "android.widget.Button",
            "Ok button to go back to main page");

    public RatingScreen() {
        super();
    }

    public void addRating(){
        findMobileElement(ratingStar).click();
        waitTime();
    }

    public void headlineText(String value){
        findMobileElement(writeHeadline).click();
        findMobileElement(writeHeadline).sendKeys(value);
        waitTime();
    }

    public void reviewText(String value){
        findMobileElement(writeReview).click();
        findMobileElement(writeReview).sendKeys(value);
        waitTime();
    }

    public void checkContainsSpoilers(String val){
        String val1 = StringUtils.lowerCase(val);
        if(val1.equals("yes")){
            findMobileElement(checkContainSpoilersYES).click();
        }else if (val1.equals("no")){
            findMobileElement(checkContainSpoilersNO).click();
        }
        waitTime();
    }

    public void submitRating(){
        findMobileElement(submitButton).click();
        waitTime();
    }

    public String checkReview(){
        String value = String.valueOf(findMobileElement(checkSubmitRating).getText());
        waitTime();
        return value;
    }

    public void reviewOkButton(){
        findMobileElement(reviewOkButton).click();
        waitTime();
    }
}
