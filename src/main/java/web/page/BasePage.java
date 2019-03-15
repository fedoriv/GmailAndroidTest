package web.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import web.utils.CustomFieldDecorator;

public class BasePage {

    protected BasePage(WebDriver driver) {
        PageFactory.initElements(new CustomFieldDecorator(driver), this);

    }
}
