package UserInterfaceTest;

import UserInterfaceTask.Utils.RandomUtils;
import UserInterfaceTask.pages.CardsPage;
import UserInterfaceTask.pages.HomePage;
import UserInterfaceTask.pages.InterestsCard;
import UserInterfaceTest.base.BaseTest;
import UserInterfaceTest.base.loginAuthSteps.LoginCardSteps;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITest extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final CardsPage cardsPage = new CardsPage();
    private final LoginCardSteps loginCardSteps = new LoginCardSteps();
    private final InterestsCard interestsCard = new InterestsCard();


    @Test
    public void firstCase() {
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();

        Assert.assertTrue(cardsPage.getNumberPage().contains("1"), "Card \"1\" was not opened");

        loginCardSteps.doRequiredSteps(RandomUtils.generateEmail(), RandomUtils.generatePassword());

        Assert.assertTrue(cardsPage.getNumberPage().contains("2"), "Card \"2\" was not opened");

        interestsCard.unselectAllInterests();
        interestsCard.selectRandomInterests(3);
        interestsCard.uploadImage();
        interestsCard.goToNextCard();

        Assert.assertTrue(cardsPage.getNumberPage().contains("3"), "Card \"3\" was not opened");
    }

    @Test
    public void secondCase() {
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        cardsPage.hideHelpWindowForm();

        Assert.assertTrue(cardsPage.isHelpFormHidden(), "Help farm was not hidden");
    }

    @Test
    public void thirdCase() {
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        cardsPage.waitCookiesBanner();
        cardsPage.acceptCookies();

        Assert.assertFalse(cardsPage.isCookiesAccepted(), "Cookies not accepted yet");
    }

    @Test
    public void fourthCase() {
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();

        Assert.assertEquals(cardsPage.getTimerValue(), DATA_TEST.getValue("/timer").toString(), "Timer was not started at 00");
    }
}