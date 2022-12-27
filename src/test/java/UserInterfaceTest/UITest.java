package UserInterfaceTest;

import UserInterfaceTask.Utils.RandomUtils;
import UserInterfaceTask.pages.*;
import UserInterfaceTask.pages.cardPages.CardsPage;
import UserInterfaceTest.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UITest extends BaseTest {

    @Test
    public void firstCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        CardsPage cardsPage = new CardsPage();

        Assert.assertEquals(cardsPage.switchToLoginCard().getNumberPage(), DATA_TEST.getValue("/LoginCardPageNumber"), "Card \"1\" was not opened");

        cardsPage.switchToLoginCard().state().waitForDisplayed();
        cardsPage.switchToLoginCard().fillLoginForm(RandomUtils.generateEmail(), RandomUtils.generatePassword());
        cardsPage.switchToLoginCard().clickNextButton();

        Assert.assertEquals(cardsPage.switchToInterestsCard().getNumberPage(), DATA_TEST.getValue("/InterestsCardPageNumber"), "Card \"2\" was not opened");

        cardsPage.switchToInterestsCard().state().waitForDisplayed();
        cardsPage.switchToInterestsCard().unselectAllInterests();
        cardsPage.switchToInterestsCard().selectRandomInterests((Integer) DATA_TEST.getValue("/interestsCount"));
        cardsPage.switchToInterestsCard().uploadImage();
        cardsPage.switchToInterestsCard().clickNextButton();
        cardsPage.switchToPersonalDetailsCard().state().waitForDisplayed();

        Assert.assertEquals(cardsPage.switchToPersonalDetailsCard().getNumberPage(), DATA_TEST.getValue("/PersonalDetailsCardPageNumber"), "Card \"3\" was not opened");
    }

    @Test
    public void secondCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        CardsPage cardsPage = new CardsPage();
        cardsPage.hideHelpWindowForm();

        Assert.assertTrue(cardsPage.isHelpFormHidden(), "Help farm was not hidden");
    }

    @Test
    public void thirdCase() {
        getBrowser().goTo(url);
        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        CardsPage cardsPage = new CardsPage();
        cardsPage.acceptCookies();

        Assert.assertFalse(cardsPage.isCookiesAccepted(), "Cookies not accepted yet");
    }

    @Test
    public void fourthCase() {
        getBrowser().goTo(url);

        HomePage homePage = new HomePage();

        Assert.assertTrue(homePage.state().waitForDisplayed(), "Home page is not displayed");

        homePage.clickCardsLinkPage();
        CardsPage cardsPage = new CardsPage();

        Assert.assertEquals(cardsPage.getTimerValue(), DATA_TEST.getValue("/timer").toString(), "Timer was not started at 00");
    }
//jenkins test anodthersfds
}