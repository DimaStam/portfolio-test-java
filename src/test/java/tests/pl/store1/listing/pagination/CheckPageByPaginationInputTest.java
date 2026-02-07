package tests.pl.store1.listing.pagination;

import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.assertions.PageAssertions;
import library.defaultdata.menu.MenuLinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.navigation.CategoryMenu;
import library.pages.store1.common.HomePage;
import library.pages.store1.listing.ListingPage;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckPageByPaginationInputTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Check pagination by entering page number")
    public void checkPageByPaginationInput() {

        CategoryMenu categoryMenu = (new CategoryMenu(page)).expandSubMenu(MenuLinksTexts.MAKEUP_URL_PL.getValue());

        assertThat(categoryMenu.getViewAllButton()).isVisible();

        ListingPage listingPage = categoryMenu
                .navigateToCategoryPage()
                .waitForProductsGrid();

        assertThat(categoryMenu.getProductsGrid()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        listingPage
                .navigateByFillingPaginationInput("3")
                .waitForProductsGrid();

        assertThat(page).hasURL(Pattern.compile("page=3"), new PageAssertions.HasURLOptions().setTimeout(15000));
        assertThat(listingPage.getTopLeftPaginationArrow()).isVisible();

        listingPage
                .navigateToPreviousPage()
                .waitForProductsGrid();

        assertThat(page).hasURL(Pattern.compile("page=2"), new PageAssertions.HasURLOptions().setTimeout(15000));
    }
}
