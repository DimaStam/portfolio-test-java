package tests.pl.store1.elements.homepage.desktop.footer.socialmedia;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PageAssertions;
import library.defaultdata.footer.LinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.footer.Footer;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayLinkAndNavigateToInstagramPageTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Store1 display link and navigate to Instagram page")
    public void testDisplayLinkAndNavigateToInstagramPage() {
        Footer footer = new Footer(page);

        assertThat(footer.getFooterContentSection()).isVisible();
        assertThat(footer.getInstagramLink()).isVisible();

        Page newWindow = footer.switchToExternalWindow(LinksTexts.INSTAGRAM_PL_URL.getValue());

        assertThat(newWindow)
                .hasURL(LinksTexts.INSTAGRAM_PL_URL.getValue(), new PageAssertions.HasURLOptions().setTimeout(15000));
    }
}