package tests.pl.store1.elements.homepage.desktop.header;

import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.pages.store1.common.customer.LoginPage;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayAccountIconAndNavigateToLoginPageTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display account icon and navigate to login page")
    public void displayAccountIconAndNavigateToLoginPage() {

        LoginPage loginPage  = (new HomePage(page))
                .navigateToLoginPage();

        loginPage.waitForLoginPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());
    }
}