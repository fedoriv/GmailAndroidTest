package android.business_object;

import android.activity.ComposeActivity;
import android.activity.ConversationListActivity;
import io.appium.java_client.android.AndroidDriver;
import android.model.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SendMessage {
    private static final Logger LOG = LogManager.getLogger(SendMessage.class);

    private final static String RECEIVER = "ta.lab.testprofile@gmail.com";
    private final static String SUBJECT = "Lets test our code";
    private final static String TEXT = "Great job! Looks like test passed.";
    private AndroidDriver driver;


    public SendMessage(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean createAndSendMessage() {
        ComposeActivity composeAct = new ComposeActivity(driver);
        ConversationListActivity conversationListActivity = new ConversationListActivity(driver);

        Message message = getMessage();
        LOG.info("Click Compose");
        conversationListActivity.clickComposeButton();

        LOG.info("Skip PopUp");
        composeAct.clickGotItButton();

        LOG.info("Type receiver email address");
        composeAct.fillToField(message.getReceiver());
        LOG.info("Type subject");
        composeAct.fillSubjectField(message.getSubject());
        LOG.info("Type text of message");
        composeAct.fillTextAreaField(message.getText());
        LOG.info("Send message");
        composeAct.clickSendButton();
        return conversationListActivity.getSendPopUpAlert().isDisplayed();
    }

    private Message getMessage() {

        Message m = null;

        //TODO Refactor validation to make code more readable
        try {
            if (System.getProperty("receiver") != null) {
                m = new Message(System.getProperty("receiver"));
            } else {
                m = new Message(RECEIVER);
            }
        } catch (Exception e) {
            try {
                m = new Message(RECEIVER);
            } catch (Exception e1) {
                System.exit(1);
            }
            e.printStackTrace();
        }

        if (System.getProperty("subject") != null) {
            m.setSubject(System.getProperty("subject"));
        } else {
            m.setSubject(SUBJECT);
        }

        if (System.getProperty("text") != null) {
            m.setText(System.getProperty("text"));
        } else {
            m.setText(TEXT);
        }
        return m;
    }
}
