package UserInterfaceTest;

import UserInterfaceTask.Utils.RandomUtils;
import UserInterfaceTask.pages.*;
import UserInterfaceTest.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITest extends BaseTest {
    private final BaseCard baseCard = new BaseCard();

    @Test
    public void firstCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();

        Assert.assertTrue(baseCard.getNumberPage().contains("1"), "Card \"1\" was not opened");


        baseCard.switchToLoginCard().fillLoginForm(RandomUtils.generateEmail(), RandomUtils.generatePassword());
        baseCard.switchToLoginCard().goToNextCardPage();

        Assert.assertTrue(baseCard.getNumberPage().contains("2"), "Card \"2\" was not opened");

        baseCard.switchToInterestsCard().unselectAllInterests();
        baseCard.switchToInterestsCard().selectRandomInterests((Integer) DATA_TEST.getValue("/interestsCount"));
        baseCard.switchToInterestsCard().uploadImage();
        baseCard.switchToInterestsCard().goToNextCard();

        Assert.assertTrue(baseCard.getNumberPage().contains("3"), "Card \"3\" was not opened");
    }

    @Test
    public void secondCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        baseCard.hideHelpWindowForm();

        Assert.assertTrue(baseCard.isHelpFormHidden(), "Help farm was not hidden");
    }

    @Test
    public void thirdCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        baseCard.acceptCookies();

        Assert.assertFalse(baseCard.isCookiesAccepted(), "Cookies not accepted yet");
    }

    @Test
    public void fourthCase() {
        getBrowser().goTo(url);

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();

        Assert.assertEquals(baseCard.getTimerValue(), DATA_TEST.getValue("/timer").toString(), "Timer was not started at 00");


    }
}