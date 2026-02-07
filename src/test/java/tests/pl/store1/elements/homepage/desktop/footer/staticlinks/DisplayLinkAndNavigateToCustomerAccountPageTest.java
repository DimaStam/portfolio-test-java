package tests.pl.store1.elements.homepage.desktop.footer.staticlinks;

import library.main.OpenPage;
import library.main.TestCase;
import library.modules.navigation.FooterMenu;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.footer.Footer;
import library.testdata.header.PageTitles;
import library.defaultdata.footer.LinksTexts;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayLinkAndNavigateToCustomerAccountPageTest extends TestCase {

    protected String customerAccountLinkXpath = "//div[@class='footer-block-links']//a[contains(@href, '" + LinksTexts.CUSTOMMER_ACCOUNT_URL.getValue() + "')]";

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());

        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display link and navigate to customer account page")
    public void displayLinkAndNavigateToCustomerAccountPage(){
        Footer footer = new Footer(page);
        assertThat(footer.getFooterContentSection()).isVisible();

        assertThat(page.locator(customerAccountLinkXpath)).isVisible();

        (new FooterMenu(page)).navigateToCustomerAccountPage();

        assertThat(page).hasTitle(PageTitles.LOGIN_PAGE_TITLE_PL.getValue());
    }
}
