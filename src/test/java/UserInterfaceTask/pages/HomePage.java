package UserInterfaceTask.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {
    private final ILink cardsLinkPage = getElementFactory().getLink(By.xpath("//a[contains(@href, 'game')]"), "CardsLinkPage");

    public HomePage() {
        super(By.xpath("//button[@type='button']"), "NoButton");
    }
    public void clickCardsLinkPage() {
        cardsLinkPage.click();
    }


}