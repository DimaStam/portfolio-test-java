package tests.pl.store2.users.login;

import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.LoginPage;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BlankCredentialsLoginTest extends TestCase {

    protected String requiredLoginField = "#email-error";
    protected String requiredPasswordField = "#pass-error";

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore2Url());

        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE2_PAGE_TITLE.getValue());
    }

    @Test(description = "Store2 login test with blank credentials")
    public void userSendBlankLoginForm(){

        HomePage homePage = (new HomePage(page));

        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        loginPage.clickLoginButton();

        assertThat(page.locator(requiredLoginField)).isVisible();
        assertThat(page.locator(requiredLoginField)).hasText("To jest wymagane pole.");
        assertThat(page.locator(requiredPasswordField)).isVisible();
        assertThat(page.locator(requiredPasswordField)).hasText("To jest wymagane pole.");
    }
}
