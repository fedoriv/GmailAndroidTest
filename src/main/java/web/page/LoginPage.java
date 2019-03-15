package web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import web.proxy.Button;
import web.proxy.TextInput;

public class LoginPage extends BasePage {

    @FindBy(css = "input[type='email']")
    private TextInput loginInput;

    @FindBy(css = "div#identifierNext")
    private Button nextButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void typeLogin(String s) {
        loginInput.sendKeys(s);
    }

    public void clickNext() {
        nextButton.click();
    }
}
