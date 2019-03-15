
import android.business_object.SendMessage;
import android.business_object.SkipNotifications;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.busnes_object.LoginBO;
import web.page.InboxMessage;
import web.page.MailList;
import web.page.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class OnePlus3tTest {

    private URL url;
    private AndroidDriver driver;
    private WebDriver webDriver;

    private static final String loginEmail = "ta.lab.testprofile@gmail.com";
    private static final String password = "ownerofthisPROFILE";
    private static final Logger LOG = LogManager.getLogger(OnePlus3tTest.class);

    @BeforeClass
    public void initialize() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32/chromedriver.exe");

        try {
            url = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LOG.info("Setting capabilities");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "fc452c57");

        capabilities.setCapability("appPackage", "com.google.android.gm");
        capabilities.setCapability("appActivity", ".ConversationListActivityGmail");

        LOG.info("Initialize AndroidDriver");
        driver = new AndroidDriver(url, capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void sendMessageGmailTest() {
        LOG.info("sendMessageGmailTest is started");
        SkipNotifications skip = new SkipNotifications(driver);
        SendMessage sendMessage = new SendMessage(driver);
        LOG.info("Start skipping notifications");
        Assert.assertTrue(skip.skipAll());
        LOG.info("Creating and sending message");
        Assert.assertTrue(sendMessage.createAndSendMessage());
        LOG.info("Message sent successful");
    }

    @Test(dependsOnMethods = "sendMessageGmailTest")
    public void checkResult() {
        LOG.info("Started checkResult() test method");

        if(System.getProperty("to") == null) {
            LOG.info("In method sendMessageGmailTest() used default receiver email configuration");
            LOG.info("Start checking inbox messages on ta.lab.testprofile@gmail.com account");

            webDriver = new ChromeDriver();
            LoginBO loginBO = new LoginBO(webDriver);
            MailList list = new MailList(webDriver);
            InboxMessage messagePage = new InboxMessage(webDriver);

            webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            webDriver.manage().deleteAllCookies();
            webDriver.manage().window().maximize();
            webDriver.get("https://www.gmail.com/");

            loginBO.login(loginEmail, password);
            list.openFirst();
            Assert.assertEquals(messagePage.getFromWho().getText(), "<oleg.fedoriv.info@gmail.com>");
        } else {
            LOG.info("In method sendMessageGmailTest() used custom email address");
            throw new SkipException("checkResult() test method skipped");
        }
    }

    @AfterClass
    public void closeAfterTest() {
        driver.quit();
        webDriver.close();
    }
}
