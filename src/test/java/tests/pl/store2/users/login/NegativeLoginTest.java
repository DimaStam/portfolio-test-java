package tests.pl.store2.users.login;

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

    protected String negativeLoginPopup = "//div[@class='swal2-popup swal2-modal swal2-show']";

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore2Url());

        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE2_PAGE_TITLE.getValue());
    }

    @Test(description = "Store2 negative login test")
    public void userCantLogin(){

        HomePage homePage = (new HomePage(page));

        LoginPage loginPage = homePage.navigateToLoginPage();

        loginPage.waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());

        loginPage.logInToSystem(
                UsersEmail.STORE2_USER_EMAIL.getValue(),
                "Fakepassword123!"
        );

        assertThat(page.locator(negativeLoginPopup)).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
    }
}
