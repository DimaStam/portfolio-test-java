package tests.pl.store1.elements.homepage.desktop.blog;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.testdata.header.PageTitles;
import library.testdata.homepage.HomePageData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class DisplayBlogSectionTitleTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display blog section title test")
    public void displayBlogSectionTitleTest(){
        HomePage homePage = new HomePage(page);
        assertThat(homePage.getBlogSection()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
        assertThat(homePage.getBlogSectionTitle()).isVisible();
        assertThat(homePage.getBlogSectionTitle()).hasText(HomePageData.BLOG_SECTION_TITLE_TEXT.getValue());
    }
}
