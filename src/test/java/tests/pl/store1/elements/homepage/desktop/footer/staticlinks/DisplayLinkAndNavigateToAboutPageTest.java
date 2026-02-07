package tests.pl.store1.elements.homepage.desktop.footer.staticlinks;

import library.defaultdata.footer.LinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.navigation.FooterMenu;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.footer.Footer;
import library.testdata.header.PageTitles;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayLinkAndNavigateToAboutPageTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display link and navigate to about page")
    public void displayLinkAndNavigateToAboutPage(){
        Footer footer = new Footer(page);

        assertThat(footer.getFooterContentSection()).isVisible();
        assertThat(footer.getLinkAriaLabelAttribute(LinksTexts.ABOUT_US_LABEL_PL.getValue())).isVisible();

        (new FooterMenu(page)).navigateToAboutPage();

        Assert.assertTrue(page.url().contains("o-nas"));
    }
}
