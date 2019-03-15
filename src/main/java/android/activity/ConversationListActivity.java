package android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConversationListActivity extends BaseActivity{

    private static final Logger LOG = LogManager.getLogger(ConversationListActivity.class);
    public static final String APP_ACTIVITY = ".ConversationListActivity";

    @AndroidFindBy(xpath = "//*[@id='welcome_tour_got_it']")
    private AndroidElement welcomeTourGotItButton;

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.gm:id/compose_button']")
    private AndroidElement composeButton;

    @AndroidFindBy(id = "gm_dismiss_button")
    private AndroidElement welcomePopUpNextButton;

    @AndroidFindBy(id = "gm_dismiss_button")
    private AndroidElement chooseViewPopUpOkButton;

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.gm:id/open_search']/android.widget.ImageButton")
    private AndroidElement navigationMenu;

    @AndroidFindBy(id = "action_text")
    private AndroidElement sendPopUpAlert;


    public ConversationListActivity(AndroidDriver driver) {
        super(driver);
    }

    public AndroidElement getNavigationMenu() {
        return navigationMenu;
    }

    public void clickWelcomeNextButton () {
        welcomePopUpNextButton.click();
    }

    public void clickChooseVievOkButton () {
        chooseViewPopUpOkButton.click();
    }

    public void clickComposeButton () {
        composeButton.click();
    }

    public AndroidElement getSendPopUpAlert() {
        return sendPopUpAlert;
    }
}
