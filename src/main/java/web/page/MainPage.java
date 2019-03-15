package web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.proxy.Button;

public class MainPage extends BasePage{

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='z0']/div[@role='button']")
    private Button composeMessage;

    @FindBy(xpath = "//*[@id='gb']//a[@href='#inbox']")
    private Button gmailLogo;

    @FindBy(xpath = "//div[@class='aim']//a[contains(@href, 'drafts')]")
    private Button snoozedMessages;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void composeMessage() {
        composeMessage.click();
    }

    public void openSnoozed() {
            snoozedMessages.click(driver);
    }

    public void clickOnLogo() {
        gmailLogo.click(driver);
    }

}
