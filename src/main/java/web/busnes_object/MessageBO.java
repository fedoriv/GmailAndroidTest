package web.busnes_object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.page.EmailPopUp;
import web.page.MailList;
import web.page.MainPage;

public class MessageBO {

    private static final Logger LOG = LogManager.getLogger(MessageBO.class);

    private WebDriver driver;
    private MainPage mainPage;
    private EmailPopUp message;
    private MailList mailList;
    private String mailTo;

    public MessageBO(WebDriver driver) {
        this.driver = driver;
        //Get receiver email address
        mailTo = System.getProperty("to");
    }


    public void openDraftAndSend() {
        mainPage = new MainPage(driver);
        LOG.info("Open draft messages");
//        mainPage.openSnoozed();
        new WebDriverWait(driver, 15).until(d->d.getCurrentUrl().contains("draft") && ((JavascriptExecutor)d).executeScript("return document.readyState")
                .toString().equals("complete"));
        mailList = new MailList(driver);
        LOG.info("Open message from top");
        mailList.openFirst();
        new WebDriverWait(driver, 15).until(d->d.getCurrentUrl().contains("draft") && ((JavascriptExecutor)d).executeScript("return document.readyState")
                .toString().equals("complete"));
        message = new EmailPopUp(driver);
        LOG.info("Send message");
        new WebDriverWait(driver, 15).until(d->d.getCurrentUrl().contains("draft") && ((JavascriptExecutor)d).executeScript("return document.readyState")
                .toString().equals("complete"));
        message.sendMessage();
    }
}
