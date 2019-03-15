package android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class StartActivit extends BaseActivity{

    private static final Logger LOG = LogManager.getLogger(StartActivit.class);
    public static final String APP_ACTIVITY = ".welcome.WelcomeTourActivity";

    @AndroidFindBy(id = "welcome_tour_got_it")
    private AndroidElement gotItButton;

    @AndroidFindBy(id = "action_done")
    private AndroidElement takeMeToGmailButton;

    @AndroidFindBy(id = "setup_addresses_list")
    private AndroidElement adressList;

    public StartActivit(AndroidDriver driver) {
        super(driver);
    }

    public boolean isDisplayedGotItButton(){
        return gotItButton.isDisplayed();
    }
    public void clickGotIt() {
        gotItButton.click();
    }

    public boolean isDisplayedTakeMeToGmailButton(){
        return takeMeToGmailButton.isDisplayed();
    }

    public void clickTakeMeToGmail() {takeMeToGmailButton.click();}

    public AndroidElement getAdressList() {
        return adressList;
    }
}
