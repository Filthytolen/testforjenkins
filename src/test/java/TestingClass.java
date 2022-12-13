import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.Test;

public class TestingClass {

    @Test
    public void testingMethod() {
        Browser browser = AqualityServices.getBrowserFactory().getBrowser();
    }
}
