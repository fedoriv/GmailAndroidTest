package web.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxMessage extends BasePage{

    private static final Logger LOG = LogManager.getLogger(InboxMessage.class);

    @FindBy(xpath = "//*[@class='go']")
    private WebElement fromWho;

    @FindBy(xpath = "//div[@class='ha']/h2[@class='hP']")
    private WebElement subject;

    @FindBy(xpath = "//div[@class='a3s aXjCH']")
    private WebElement text;

    public InboxMessage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFromWho() {
        return fromWho;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getText() {
        return text;
    }
}
