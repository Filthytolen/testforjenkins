package UserInterfaceTask.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CardsPage extends Form {
    private final ILabel pageIndicatorLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'page-indicator')]"),
            "PageIndicator");
    private final ILabel timerLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class,'timer')]"),
            "timer");
    private final IButton sendToBottomButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'bottom-button')]"),
            "helpButton");
    private final IButton acceptCookiesButton = getElementFactory().getButton(By.xpath("//div[@class='align__cell']//button[starts-with(@class,'button')]"),
            "button cookies accept");
    private final ITextBox helpFormTextBox = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'help-form')]"),
            "helpForm");
    private final ITextBox cookiesBannerTextBox = getElementFactory().getTextBox(By.xpath("//div[contains(@class,'cookies'])"),
            "cookies banner");

    public CardsPage() {
        super(By.xpath("//div[contains(@class, 'login-form'])"), "LoginForm");
    }

    public String getNumberPage() {
        return pageIndicatorLabel.getText();
    }

    public void hideHelpWindowForm() {
        sendToBottomButton.clickAndWait();
    }

    public boolean isHelpFormHidden() {
        return helpFormTextBox.state().isDisplayed();
    }

    public void waitCookiesBanner() {
        cookiesBannerTextBox.state().waitForDisplayed();
    }

    public void acceptCookies() {
        acceptCookiesButton.clickAndWait();
    }

    public boolean isCookiesAccepted() {
        return cookiesBannerTextBox.state().isDisplayed();
    }

    public String getTimerValue() {
        return timerLabel.getText();
    }
}

