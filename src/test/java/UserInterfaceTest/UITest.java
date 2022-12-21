package UserInterfaceTest;

import UserInterfaceTask.Utils.RandomUtils;
import UserInterfaceTask.pages.CardsPage;
import UserInterfaceTask.pages.HomePage;
import UserInterfaceTask.pages.InterestsCard;
import UserInterfaceTask.pages.LoginCard;
import UserInterfaceTest.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITest extends BaseTest {
    private final CardsPage cardsPage = new CardsPage();

    @Test
    public void firstCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();

        Assert.assertTrue(cardsPage.getNumberPage().contains("1"), "Card \"1\" was not opened");

        LoginCard loginCard = new LoginCard();

        loginCard.fillLoginForm(RandomUtils.generateEmail(), RandomUtils.generatePassword());
        loginCard.goToNextCardPage();

        Assert.assertTrue(cardsPage.getNumberPage().contains("2"), "Card \"2\" was not opened");

        InterestsCard interestsCard = new InterestsCard();
        interestsCard.unselectAllInterests();
        interestsCard.selectRandomInterests((Integer) DATA_TEST.getValue("/interestsCount"));
        interestsCard.uploadImage();
        interestsCard.goToNextCard();

        Assert.assertTrue(cardsPage.getNumberPage().contains("3"), "Card \"3\" was not opened");
    }

    @Test
    public void secondCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        cardsPage.hideHelpWindowForm();

        Assert.assertTrue(cardsPage.isHelpFormHidden(), "Help farm was not hidden");
    }

    @Test
    public void thirdCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        cardsPage.acceptCookies();

        Assert.assertFalse(cardsPage.isCookiesAccepted(), "Cookies not accepted yet");
    }

    @Test
    public void fourthCase() {
        getBrowser().goTo(url);

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();

        Assert.assertEquals(cardsPage.getTimerValue(), DATA_TEST.getValue("/timer").toString(), "Timer was not started at 00");


    }
}