package UserInterfaceTask.pages;

import UserInterfaceTask.Utils.RandomUtils;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

import static aquality.selenium.elements.ElementType.TEXTBOX;

public class LoginCard extends Form {
    private static final String XPATH_CARD_NAME_TEXT = "//div[contains(@class, 'page-indicator')][contains(text(), '1 / ')]";


    private final ITextBox passwordTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Password')]"),
            "PasswordTextBox");
    private final ITextBox emailTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'email')]"),
            "emailTextBox");
    private final ITextBox domainTextBox = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder, 'Domain')]"),
            "domainTextBox");
    private final ICheckBox checkBoxAgreement = getElementFactory().getCheckBox(By.className("checkbox"),
            "CheckBoxAgreement");
    private final IComboBox dropDownMenu = getElementFactory().getComboBox(By.xpath("//div[contains(@class, 'dropdown__field')]"),
            "dropDownMenu");
    private final ILink nextCardLink =
            getElementFactory().getLink(By.className("button--secondary"), "NextCardButton");

    public LoginCard() {
        super(By.xpath(XPATH_CARD_NAME_TEXT),
                "CardNameText");
    }

    public void checkCheckBoxAgreement() {
        checkBoxAgreement.check();
    }

    public void clickDropDownMenu() {
        dropDownMenu.click();
    }

    public void enterPassword(String password) {
        passwordTextBox.clearAndType(password);
    }

    public void enterEmail(String email) {
        emailTextBox.clearAndType(email);
    }

    public void enterDomain(String domain) {
        domainTextBox.clearAndType(domain);
    }

    public void goToNextCardPage() {
        nextCardLink.clickAndWait();
    }

    public void selectDomain() {
        clickDropDownMenu();
        List<ITextBox> domains =
                getElementFactory().findElements(By.className("dropdown__list-item"), "Domains", TEXTBOX);
        domains.get(RandomUtils.generateRandomNumber(1, domains.size())).click();
    }

    public void fillLoginForm(String email, String password) {
        fillFieldWithRandomData(email, password);
        selectDomain();
        checkCheckBoxAgreement();
    }

    private void fillFieldWithRandomData(String email, String password) {
        enterPassword(password);
        enterEmail(email);
        System.out.println(email.substring(email.indexOf("@") + 1));
        enterDomain(email.substring(email.indexOf("@") + 1));
    }

}
