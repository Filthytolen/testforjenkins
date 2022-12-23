package UserInterfaceTask.pages.cardPages;

import UserInterfaceTask.Utils.RandomUtils;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import java.util.List;

import static aquality.selenium.elements.ElementType.TEXTBOX;

public class LoginCard extends BaseCard {
    private static final String XPATH_CARD_NAME_TEXT = "//DIV[contains(@class,'login-form__fields')]";


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
        enterDomain(email.substring(email.indexOf("@") + 1));
    }

}
