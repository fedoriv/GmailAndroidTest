package web.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.proxy.Button;

import java.util.List;

public class MailList extends BasePage {

    private static final Logger LOG = LogManager.getLogger(MailList.class);

    @FindBy(xpath = "//table[@class='F cf zt']/tbody/tr")
    public WebElement firstEmail;
    private WebDriver driver;

    public MailList(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openFirst() {
        new WebDriverWait(driver, 15).until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState")
                .toString().equals("complete"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(firstEmail));
        firstEmail.click();
    }
}
