package android.business_object;

import android.activity.ConversationListActivity;
import android.activity.StartActivit;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.page.InboxMessage;

public class SkipNotifications {

    private AndroidDriver driver;
    private static final Logger LOG = LogManager.getLogger(SkipNotifications.class);


    public SkipNotifications(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean skipAll() {

        StartActivit activity = new StartActivit(driver);
        ConversationListActivity conversationListActivity = new ConversationListActivity(driver);

        if (activity.isDisplayedGotItButton()) {
            LOG.info("Skip Welcome Tour PopUp window");
            activity.clickGotIt();
        }

        new WebDriverWait(driver, 5).until(d-> d.findElement(By.id("setup_addresses_list")));

        if (activity.isDisplayedTakeMeToGmailButton()) {
            LOG.info("Skip Welcome Tour PopUp window");
            activity.clickTakeMeToGmail();
        }
        LOG.info("Skip welcome window");
        conversationListActivity.clickWelcomeNextButton();
        LOG.info("Choose view");
        conversationListActivity.clickChooseVievOkButton();

        return new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(conversationListActivity.getNavigationMenu())).isDisplayed();
    }
}
