package UserInterfaceTask.pages.cardPages;

import org.openqa.selenium.By;

public class PersonalDetailsCard extends BaseCard {
    private static final String CLASS_CARD_NAME_TEXT = "personal-details__form";

    public PersonalDetailsCard() {
        super(By.className(CLASS_CARD_NAME_TEXT),
                "CardNameText");
    }

}
