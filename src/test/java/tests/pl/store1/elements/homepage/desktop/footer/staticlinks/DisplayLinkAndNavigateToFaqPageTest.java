package tests.pl.store1.elements.homepage.desktop.footer.staticlinks;

import com.microsoft.playwright.assertions.PageAssertions;
import library.defaultdata.footer.LinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.navigation.FooterMenu;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.footer.Footer;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayLinkAndNavigateToFaqPageTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display link and navigate to FAQ page")
    public void displayLinkAndNavigateToFaqPage(){
        Footer footer = new Footer(page);
        assertThat(footer.getFooterContentSection()).isVisible();
        assertThat(footer.getLinkAriaLabelAttribute(LinksTexts.FAQ_LABEL_PL.getValue())).isVisible();

        (new FooterMenu(page)).navigateToFaqPage();

        assertThat(page)
                .hasTitle(PageTitles.FAQ_TITLE_PL
                        .getValue(), new PageAssertions.HasTitleOptions().setTimeout(15000));
    }
}
