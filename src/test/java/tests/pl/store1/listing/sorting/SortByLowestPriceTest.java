package tests.pl.store1.listing.sorting;

import com.microsoft.playwright.assertions.LocatorAssertions;
import library.defaultdata.menu.MenuLinksTexts;
import library.main.OpenPage;
import library.main.TestCase;
import library.modules.navigation.CategoryMenu;
import library.pages.store1.common.HomePage;
import library.pages.store1.listing.ListingPage;
import library.testdata.header.PageTitles;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.fail;

public class SortByLowestPriceTest extends TestCase {

    @BeforeMethod(description = "Open page")
    protected void openPage(){
        (new OpenPage(page)).openPage(config.getStore1Url());
        (new HomePage(page)).waitForHomePage();

        assertThat(page).hasTitle(PageTitles.STORE1_PL_PAGE_TITLE.getValue());
    }

    @Test(description = "Check sorting by lowest price")
    public void checkSortByLowestPricw() {

        CategoryMenu categoryMenu = (new CategoryMenu(page)).expandSubMenu(MenuLinksTexts.MAKEUP_URL_PL.getValue());

        assertThat(categoryMenu.getViewAllButton()).isVisible();

        ListingPage listingPage = categoryMenu.navigateToCategoryPage();
        listingPage.waitForProductsGrid();

        assertThat(categoryMenu.getProductsGrid()).isVisible(new LocatorAssertions.IsVisibleOptions().setTimeout(15000));

        listingPage
                .openSortingDropdown()
                .clickSortByLowestPriceAndWaitForResponsePL("store1_pl_simple_products_price_default_asc")
                .waitForProductsGrid();

        boolean arePricesValid = listingPage.checkIsPricesSortedAsc(listingPage.getProductPrices());
        if (!arePricesValid) {
            fail("Ceny nie są posortowane od najmniejszej do największej");
        }
    }
}
