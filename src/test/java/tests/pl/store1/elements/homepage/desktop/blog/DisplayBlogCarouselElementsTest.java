package tests.pl.store1.elements.homepage.desktop.blog;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.main.OpenPage;
import library.main.TestCase;
import library.pages.store1.common.HomePage;
import library.testdata.header.PageTitles;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DisplayBlogCarouselElementsTest extends TestCase {
    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        new HomePage(page).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Display blog carousel items")
    public void distplayBlogCarouselItemsTest(){
        HomePage homePage = (new HomePage(page));
        assertThat(homePage.getBlogCarouselSection()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));
        homePage.waitForBlogPosts();

        Assert.assertEquals(homePage.getCountVisibleBlogCarouselItems().count(), 4);
        assertThat(homePage.getCarouselNavigateLeftArrow()).isVisible();
        assertThat(homePage.getCarouselNavigateRightArrow()).isVisible();
    }
}
