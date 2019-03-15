package web.proxy;

import org.openqa.selenium.*;
import web.utils.Element;

public class TextInput extends Element {

    public TextInput(WebElement webElement) {
        super(webElement);
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        webElement.clear();
        super.webElement.sendKeys(charSequences);
    }
}
