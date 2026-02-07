package tests.pl.store1.users.login;

import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.LoginPage;
import library.testdata.AssertionCustomMessages;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class BlankCredentialsLoginTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Login test with blank credentials")
    public void userSendBlankLoginForm(){

        LoginPage loginPage = (new HomePage(page))
                .navigateToLoginPage()
                .waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        loginPage.clickLoginButton();

        assertThat(loginPage.getRequiredLoginField()).isVisible();
        assertThat(loginPage.getRequiredLoginField()).hasText(AssertionCustomMessages.VALIDATION_MESSAGE_ERROR_PL.getValue());
        assertThat(loginPage.getRequiredPasswordField()).isVisible();
        assertThat(loginPage.getRequiredPasswordField()).hasText(AssertionCustomMessages.VALIDATION_MESSAGE_ERROR_PL.getValue());
    }
}