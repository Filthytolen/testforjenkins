package UserInterfaceTask.pages.cardPages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class BaseCard extends Form {
    private final ILabel pageIndicatorLabel = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'page-indicator')]"),
            "PageIndicator");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//*[contains(text(), 'Next')]"),
            "NextButton");


    public BaseCard(By baseElement, String name) {
        super(baseElement, name);
    }


    public String getNumberPage() {
        return pageIndicatorLabel.getText().substring(0, 1);
    }

    public void clickNextButton() {
        nextButton.clickAndWait();
    }


}