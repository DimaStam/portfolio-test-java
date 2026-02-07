package tests.pl.store1.users.registration;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.users.registration.CreateAccountFactory;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.CreateAccountPage;
import library.pages.store1.common.customer.LoginPage;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RegistrationWithJoiningClubTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Registration with joining the club test")
    public void testRegisterWithJoiningClub(){

        LoginPage loginPage = (new HomePage(page))
                .navigateToLoginPage()
                .waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        CreateAccountPage createAccountPage = loginPage.navigateToCreateAccountForm();
        createAccountPage.waitForCreateAccountPage();

        assertThat(createAccountPage.breadcrumbsItem).isVisible();

        createAccountPage
                .fillMainRegisterForm(CreateAccountFactory.createRegisterUserData(), true)
                .fillClubRegisterForm(CreateAccountFactory.createRegisterUserData())
                .sendRegisterForm();

        assertThat(createAccountPage
                .successRegistrationMessage).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
        assertThat(createAccountPage
                .welcomeText).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
    }
}
