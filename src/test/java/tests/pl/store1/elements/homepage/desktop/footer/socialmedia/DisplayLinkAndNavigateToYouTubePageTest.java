package tests.pl.store1.elements.homepage.desktop.footer.socialmedia;

import library.defaultdata.footer.LinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.pages.store1.pl.footer.Footer;
import library.testdata.header.PageTitles;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayLinkAndNavigateToYouTubePageTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Store1 display link and navigate to YouTube page")
    public void testDisplayLinkAndNavigateToYouTubePage() {
        Footer footer = new Footer(page);

        assertThat(footer.getFooterContentSection()).isVisible();
        assertThat(footer.getYoutubeLink()).isVisible();

        String popupTitle = footer.switchToExternalWindowReturnTitle(LinksTexts.YOUTUBE_URL.getValue());
        System.out.println(popupTitle);

        Assert.assertEquals(popupTitle, "External Page");
    }
}
