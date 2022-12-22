package UserInterfaceTask.pages;

import UserInterfaceTask.Utils.GetProperties;
import UserInterfaceTask.Utils.RandomUtils;
import UserInterfaceTask.Utils.UploadUtil;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.Label;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.io.File;
import java.util.List;
import java.util.Objects;

public class InterestsCard extends BaseCard {
    private static final String XPATH_CARD_NAME_TEXT = "//DIV[contains(@class,'interests__form')]";
    private static final String XPATH_INTERESTS_CHECK_BOXES = "//div[contains(@class,'list__item')]//label";


    private static final File file = new File(GetProperties.readFromDataConfig("avatarPictureFile"));

    private final IButton uploadAvatarButton = getElementFactory().getButton(By.xpath("//a[contains(@class, 'upload-button')]"), "UploadAvatarButton");


    public InterestsCard() {
        super(By.xpath(XPATH_CARD_NAME_TEXT), "CardNameText");
    }


    private List<Label> getCheckBoxesList() {
        return getElementFactory().findElements(By.xpath(XPATH_INTERESTS_CHECK_BOXES), ElementType.LABEL);
    }

    public void unselectAllInterests() {
        getCheckBoxesList()
                .stream()
                .filter(checkBox -> (checkBox
                        .getAttribute("for"))
                        .equals("interest_unselectall"))
                .findFirst()
                .orElseThrow()
                .clickAndWait();
    }

    public void selectRandomInterests(int countOfInterests) {
        List<Label> interestCheckBoxes =
                getCheckBoxesList()
                        .stream()
                        .filter(checkBox -> !Objects.equals(checkBox.getAttribute("for"), "interest_unselectall")
                                && !Objects.equals(checkBox.getAttribute("for"), "interest_selectall"))
                        .toList();

        for (int i = 0; i < countOfInterests; i++) {
            interestCheckBoxes.get(RandomUtils.generateRandomNumber(0, interestCheckBoxes.size())).clickAndWait();
        }
    }

    public void uploadImage() {
        uploadAvatarButton.clickAndWait();
        UploadUtil.uploadFile(file);
    }

}
