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

public class DisplayLinkAndNavigateToReturnsAndComplaintsStationaryPageTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display link and navigate to returns and complaints stationary page")
    public void testDisplayLinkAndNavigateToReturnsAndComplaintsStationaryPage(){
        Footer footer = new Footer(page);
        assertThat(footer.getFooterContentSection()).isVisible();
        assertThat(footer.getLinkAriaLabelAttribute(LinksTexts.RETURN_STATIONARY_LABEL_PL.getValue())).isVisible();

        (new FooterMenu(page)).navigateToReturnsAndComplaintsStationaryPage();

        Assert.assertTrue(page.url().contains("zwroty-drogerie-stacjonarne"));
    }
}
