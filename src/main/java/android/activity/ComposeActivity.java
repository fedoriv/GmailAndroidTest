package android.activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ComposeActivity extends BaseActivity{

    private static final Logger LOG = LogManager.getLogger(ComposeActivity.class);
    public static final String APP_ACTIVITY = ".ComposeActivityGmail";

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.gm:id/to']")
    private AndroidElement toField;

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.gm:id/subject']")
    private AndroidElement subjectField;

    @AndroidFindBys(@AndroidBy(xpath = "//*[@resource-id='com.google.android.gm:id/spinner_account_address']"))
    private List<AndroidElement> senderList;

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.gm:id/composearea_tap_trap_bottom']")
    private AndroidElement composeTextArea;

    @AndroidFindBy(id = "button1")
    private AndroidElement smartComposeGotItButton;

    @AndroidFindBy(xpath = "//*[@resource-id='com.google.android.gm:id/send']")
    private AndroidElement sendButton;

    public ComposeActivity(AndroidDriver driver) {
        super(driver);
    }

    public void fillToField (String str) {
        toField.click();
        toField.clear();
        toField.sendKeys(str);
        toField.click();
    }
    public void fillSubjectField (String str) {
        subjectField.click();
        subjectField.clear();
        subjectField.sendKeys(str);
        subjectField.click();
    }
    public void fillTextAreaField (String str) {
        composeTextArea.click();
        composeTextArea.clear();
        composeTextArea.sendKeys(str);
        composeTextArea.click();
    }
    public void clickSendButton () {
        sendButton.click();
    }
    public void clickGotItButton () {
        smartComposeGotItButton.click();
    }

    public AndroidElement getSmartComposeGotItButton() {
        return smartComposeGotItButton;
    }
}
