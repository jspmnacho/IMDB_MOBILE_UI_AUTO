package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class Login extends BaseMobileScreen {

    private MobileElement notNow = new MobileElement(By.Id,
            "com.imdb.mobile:id/splash_not_now",
            "Not Now button");

    private MobileElement signInIMDB = new MobileElement(By.Id,
            "com.imdb.mobile:id/imdb_auth_portal",
            "SignIn button with IMDB");

    private MobileElement signInGoogle = new MobileElement(By.Id,
            "com.imdb.mobile:id/google_oauth",
            "SignIn button with Google");

    private MobileElement chooseAccount = new MobileElement(By.Xpath,
            "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[1]",
            "Choose an email account");

    private MobileElement okButton = new MobileElement(By.Id,"android:id/button1","Ok button");

    public Login() {
        super();
    }

    public void notNow(){
        findMobileElement(notNow).click();
    }

    public void signInIMDB(){
        findMobileElement(signInIMDB).click();
    }

    public void signInGoogle(){
        findMobileElement(signInGoogle).click();
    }

    public void chooseAccount(){
        findMobileElement(chooseAccount).click();
        findMobileElement(okButton).click();
    }


}
