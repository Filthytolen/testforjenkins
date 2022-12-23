package UserInterfaceTask.pages.cardPages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CardsPage extends Form {
    private static final String XPATH_TIME_LABEL = "//div[contains(@class,'timer')]";

    private final LoginCard loginCard = new LoginCard();
    private final InterestsCard interestsCard = new InterestsCard();
    private final PersonalDetailsCard personalDetailsCard = new PersonalDetailsCard();

    private final ILabel timerLabel = getElementFactory().getLabel(By.xpath(XPATH_TIME_LABEL),
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
        super(By.xpath(XPATH_TIME_LABEL), "TimerLabel");
    }

    public LoginCard switchToLoginCard() {
        return this.loginCard;
    }

    public InterestsCard switchToInterestsCard() {
        return this.interestsCard;
    }

    public PersonalDetailsCard switchToPersonalDetailsCard() {
        return this.personalDetailsCard;
    }

    public void hideHelpWindowForm() {
        sendToBottomButton.clickAndWait();
    }

    public boolean isHelpFormHidden() {
        return helpFormTextBox.state().isDisplayed();
    }

    public void acceptCookies() {
        cookiesBannerTextBox.state().waitForDisplayed();
        acceptCookiesButton.clickAndWait();
    }

    public boolean isCookiesAccepted() {
        return cookiesBannerTextBox.state().isDisplayed();
    }

    public String getTimerValue() {
        return timerLabel.getText();
    }
}
