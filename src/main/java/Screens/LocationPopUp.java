package Screens;

import Bases.BaseMobileScreen;
import core.By;
import core.MobileElement;

public class LocationPopUp extends BaseMobileScreen {

    private MobileElement whileUsingApp = new MobileElement
            (By.Id,"com.android.permissioncontroller:id/permission_allow_foreground_only_button",
                    "While using the app, Item");
    private MobileElement onlyThisTime = new MobileElement
            (By.Xpath,
                    "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.Button[2]",
                    "Only this time, Item");
    private MobileElement dontAllow = new MobileElement
            (By.Id, "com.android.permissioncontroller:id/permission_deny_button",
                    "Don't allow, Item");

    private MobileElement okTap = new MobileElement(By.Id, "android:id/button2", "Stay informed ok button");
    private MobileElement reviewTap = new MobileElement(By.Id, "android:id/button1", "Stay informed review button");

    public LocationPopUp() {
        super();
    }

    public void allowLocation(){
        findMobileElement(whileUsingApp).click();
        waitTime();
    }

    public void onlyThisTime(){
        findMobileElement(onlyThisTime).click();
        waitTime();
    }

    public void dontAllowLocation(){
        findMobileElement(dontAllow).click();
        waitTime();
    }

    public void okStayInformed(){
        findMobileElement(okTap).click();
        waitTime();
    }

    public void reviewStayInformed(){
        findMobileElement(reviewTap).click();
        waitTime();
    }
}
