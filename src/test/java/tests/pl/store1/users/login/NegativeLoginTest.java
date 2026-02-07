package tests.pl.store1.users.login;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.LoginPage;
import library.testdata.header.PageTitles;
import library.testdata.users.UsersEmail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NegativeLoginTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Negative login test")
    public void userCantLogin() {

        LoginPage loginPage = (new HomePage(page))
                .navigateToLoginPage()
                .waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        loginPage.logInToSystem(
                UsersEmail.STORE1_USER_EMAIL.getValue(),
                loginPage.getFakePassword());

        assertThat(loginPage.getNegativeLoginPopup()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
    }
}
