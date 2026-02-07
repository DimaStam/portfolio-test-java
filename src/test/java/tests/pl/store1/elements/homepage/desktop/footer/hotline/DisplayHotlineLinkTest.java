package tests.pl.store1.elements.homepage.desktop.footer.hotline;

import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayHotlineLinkTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Store1 display hotline link")
    public void testDisplayHotlineLink(){

        assertThat(new HomePage(page).getHotlineLinkStore1PL()).isVisible();
    }
}
