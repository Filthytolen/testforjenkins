package UserInterfaceTest.base.loginAuthSteps;

import UserInterfaceTask.pages.LoginCard;

public class LoginCardSteps {
    private final LoginCard loginCard = new LoginCard();

    public void doRequiredSteps(String email, String password) {
        loginCard.enterPassword(password);
        loginCard.enterEmail(email);
        loginCard.enterDomain(email);
        loginCard.clickDropDownMenu();
        loginCard.selectDomain();
        loginCard.checkCheckBoxAgreement();
        loginCard.goToNextCardPage();
    }

}
