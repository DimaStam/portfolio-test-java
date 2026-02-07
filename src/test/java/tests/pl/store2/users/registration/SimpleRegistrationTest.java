package tests.pl.store2.users.registration;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.main.environments.EnvironmentConfig;
import library.modules.users.registration.CreateAccountFactory;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.CreateAccountPage;
import library.pages.store1.common.customer.LoginPage;
import library.testdata.header.PageTitles;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SimpleRegistrationTest extends TestCase {
    EnvironmentConfig environmentConfig = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());

    @BeforeMethod(description = "Open page")
    protected void openPage(){

        (new OpenPage(page)).openPage(environmentConfig.getStore2Url());

        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE2_PAGE_TITLE.getValue());
    }

    @Test(description = "Store2 simple registration test")
    public void simpleRegistration(){

        LoginPage loginPage = (new HomePage(page)).navigateToLoginPage();

        loginPage.waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        CreateAccountPage createAccountPage = loginPage.navigateToCreateAccountForm();

        createAccountPage.waitForCreateAccountPage();

        assertThat(createAccountPage.breadcrumbsItem).isVisible();

        createAccountPage.fillMainRegisterForm(CreateAccountFactory.createRegisterUserData(), false);

        createAccountPage.sendRegisterForm();

        assertThat(createAccountPage.successRegistrationMessage).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        assertThat(createAccountPage.welcomeText).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
    }
}