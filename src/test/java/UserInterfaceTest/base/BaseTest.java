package UserInterfaceTest.base;


import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected static final ISettingsFile DATA_TEST = new JsonSettingsFile("DataTest.json");
    protected static final String url = DATA_TEST.getValue("/MainPage").toString();

    private Browser browser;

    @BeforeMethod
    public void setup() {
        getBrowser().goTo(url);
        getBrowser().maximize();
        getBrowser().waitForPageToLoad();
    }

    @AfterSuite
    public void cleanup() {
//        if (browser.isStarted()) {
//            browser.quit();
//        }
    }

    protected Browser getBrowser() {
        return AqualityServices.getBrowser();
    }
}