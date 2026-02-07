package tests.pl.store2.users.login;

import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.LoginPage;
import library.testdata.header.PageTitles;
import library.testdata.users.UsersEmail;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PositiveLoginTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore2Url());

        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE2_PAGE_TITLE.getValue());
    }

    @Test(description = "Store2 ositive login test")
    public void userCanLogin(){

        HomePage homePage = (new HomePage(page));

        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        loginPage.logInToSystem(
                UsersEmail.STORE2_USER_EMAIL.getValue(),
                config.getTestUserPassword()
        );

        assertThat(page).hasTitle(PageTitles.MY_ACCOUNT_TITLE_PL.getValue());
    }
}
